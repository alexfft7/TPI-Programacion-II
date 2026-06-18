package tpintegrador_programacion2.Main;

import java.util.Scanner;
import java.util.ArrayList;
import tpintegrador_programacion2.config.CRUDCategorias;
import tpintegrador_programacion2.exception.OpcionInvalidaException;
import tpintegrador_programacion2.entities.Categoria;
import tpintegrador_programacion2.entities.Producto;
import tpintegrador_programacion2.entities.Usuario;



public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CRUDCategorias menuCrudCategorias = new CRUDCategorias();
        CRUDProductos menuCrudProductos = new CRUDProductos();
        CRUDUsuarios menuCrudUsuarios = new CRUDUsuarios();
        CRUDPedidos menuCrudPedidos = new CRUDPedidos();
        int opcion = -1;

        CRUDCategorias menuCrudCategorias = new CRUDCategorias();
        
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
                menuCrudCategorias.menuCategorias(input);
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

}  
    //PRODUCTOS


