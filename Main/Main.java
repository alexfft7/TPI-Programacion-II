package tpintegrador_programacion2.Main;

import java.util.Scanner;
import java.util.ArrayList;
import tpintegrador_programacion2.exception.OpcionInvalidaException;
import tpintegrador_programacion2.entities.Categoria;
import tpintegrador_programacion2.entities.Producto;
import tpintegrador_programacion2.entities.Usuario;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Categoria> categorias = new ArrayList<>(); //Colecciones
        int opcion = -1;
        
        do { System.out.println("\n=== SISTEMA DE PEDIDOS (FOOD STORE) ===");
            System.out.println("1. Categorías");
            System.out.println("2. Productos");
            System.out.println("3. Usuarios");
            System.out.println("4. Pedidos");
            System.out.println("0. Salir");
            System.out.print("Seleccione: ");
            
            //cuando se ingresa un numero fuera de rango no muestra un error
            try {
                opcion = Integer.parseInt(input.nextLine());
                if (opcion < 0 || opcion > 4) {
                    throw new OpcionInvalidaException("La opción debe estar entre 0 y 4");
        }
                
         switch (opcion) {
            case 1:
                menuCategorias(input, categorias);
                break;
            case 2:
                menuCRUD(input, "Productos");
                break;
            case 3:
                menuCRUD(input, "Usuarios");
                break;
            case 4:
                menuCRUD(input, "Pedidos");
                break;
            case 0:
                System.out.println("Saliendo del sistema...");
                break;
        }

        } catch (OpcionInvalidaException e) {
        System.out.println("Error: " + e.getMessage());

        } catch (NumberFormatException e) {
        System.out.println("Error: Debe ingresar un número.");

        input.nextLine();
    }
            
        } while (opcion != 0);
    }
        
private static void menuCRUD(Scanner input, String entidad) {

    int opcionCRUD = -1;

    do {
        try {

            System.out.println("\n--- " + entidad + " ---");
            System.out.println("1. Listar");
            System.out.println("2. Crear");
            System.out.println("3. Editar");
            System.out.println("4. Eliminar");
            System.out.println("0. Volver");
            System.out.print("Seleccione: ");

            opcionCRUD = Integer.parseInt(input.nextLine());

            if (opcionCRUD < 0 || opcionCRUD > 4) {
                throw new OpcionInvalidaException(
                        "La opción debe estar entre 0 y 4");
            }

            switch (opcionCRUD) {
                case 1:
                    System.out.println("Listando " + entidad);
                    break;
                case 2:
                    System.out.println("Creando " + entidad);
                    break;
                case 3:
                    System.out.println("Editando " + entidad);
                    break;
                case 4:
                    System.out.println("Eliminando " + entidad);
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
            }

        } catch (OpcionInvalidaException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (NumberFormatException e) {
            System.out.println("Error: Debe ingresar un número.");
        }

    } while (opcionCRUD != 0);
}
    /// Colecciones de categoria ///
private static void menuCategorias(
        Scanner input,
        ArrayList<Categoria> categorias) {

    int opcion = -1;

    do {
        System.out.println("\n--- CATEGORIAS ---");
        System.out.println("1. Listar");
        System.out.println("2. Crear");
        System.out.println("3. Editar");
        System.out.println("4. Eliminar");
        System.out.println("0. Volver");

        opcion = Integer.parseInt(input.nextLine());
        switch(opcion){
            case 1:
                boolean hayCategorias = false;

                for (Categoria c : categorias) {
                    if (!c.isEliminado()) {
                        System.out.println(c);
                        hayCategorias = true;
                    }
                }

    if (!hayCategorias) {
        System.out.println("No hay categorias cargadas");
                }
                break;
                
            case 2: // CREAR
                System.out.print("Nombre: ");
                String nombre = input.nextLine();
                boolean existe = false;

                for (Categoria c : categorias) {
                    if (c.getNombre().equalsIgnoreCase(nombre)) {
                        existe = true;
                break;
                    }
                }

                if (existe) {
                    System.out.println("Ya existe una categoria con ese nombre");
                    break;
                } else {
                System.out.print("Descripcion: ");
                String descripcion = input.nextLine();
                Categoria categoria = new Categoria(nombre, descripcion);
                categorias.add(categoria); //recorre la coleccion y verifica si existe una categoria con el mismo nombre
                System.out.println("Categoria creada");
                }
                break;
            case 3: /// EDITAR 

                System.out.println("\nCategorias disponibles:");            
                for (Categoria c : categorias) {
                    if (!c.isEliminado()) {
                        System.out.println("ID: " + c.getId() + " - " + c.getNombre());
                    }
                }
                
                System.out.print("Ingrese id que quiere editar: ");
                Long idEditar = Long.parseLong(input.nextLine());
                Categoria categoriaEditar = null;
                for (Categoria c : categorias) {
                    if (c.getId().equals(idEditar) && !c.isEliminado()) {
                        categoriaEditar = c;
                        break;
                    }
                }
               if (categoriaEditar == null) {
                   System.out.println("Categoria no encontrada");
                   break;
               }
               System.out.print("Nuevo nombre: ");
               String nuevoNombre = input.nextLine();
               
               System.out.print("Nueva descripcion: ");
               String nuevaDescripcion = input.nextLine();
               
               categoriaEditar.setNombre(nuevoNombre);
               categoriaEditar.setDescripcion(nuevaDescripcion);
               
               System.out.println("Categoria editada");
               break;
                
            case 4: // ELIMINAR 
                System.out.print("Ingrese el id de la categoria a eliminar: ");
                Long idEliminar = Long.parseLong(input.nextLine());
                Categoria categoriaEliminar = null;
                
                for (Categoria c : categorias) {
                    if (c.getId().equals(idEliminar) && !c.isEliminado()) {
                        categoriaEliminar = c;
                        break;
                    }
                }
                if (categoriaEliminar == null) {
                    System.out.println("Categoria no encontrada");
                } else {
                    categoriaEliminar.setEliminado(true);
                    System.out.println("Categoria eliminada correctamente");
                }
                break;


                
            case 0:
                System.out.println("Volviendo al menu principal");
                break;
        }
    }while(opcion != 0);
}  
    //PRODUCTOS
    
    
}

