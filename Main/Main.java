package tpintegrador_programacion2.Main;

import java.util.Scanner;
import services.CRUDCategorias;
import services.CRUDProductos;
import services.CRUDUsuarios;
import services.CRUDPedidos;
import exception.OpcionInvalidaException;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        CRUDCategorias crudCategorias = 
                new CRUDCategorias();
        CRUDProductos crudProductos
                = new CRUDProductos(crudCategorias.getCategorias());
        CRUDUsuarios crudUsuarios
                = new CRUDUsuarios();
        CRUDPedidos crudPedidos
                = new CRUDPedidos(
                        crudUsuarios.getUsuarios(),
                        crudProductos.getProductos());
        int opcion = -1;

        do {

            System.out.println("\n=== SISTEMA DE PEDIDOS (FOOD STORE) ===");
            System.out.println("1. Categorías");
            System.out.println("2. Productos");
            System.out.println("3. Usuarios");
            System.out.println("4. Pedidos");
            System.out.println("0. Salir");
            System.out.print("Seleccione: ");

            try {

                opcion = Integer.parseInt(input.nextLine());

                if (opcion < 0 || opcion > 4) {
                    throw new OpcionInvalidaException(
                            "La opción debe estar entre 0 y 4");
                }

                switch (opcion) {

                    case 1:
                        crudCategorias.menuCategorias(input);
                        break;

                    case 2:
                        crudProductos.menuProductos(input);
                        break;

                    case 3:
                        crudUsuarios.menuUsuarios(input);
                        break;

                    case 4:
                        crudPedidos.menuPedidos(input);
                        break;

                    case 0:
                        System.out.println(
                                "Saliendo del sistema...");
                        break;
                }

            } catch (OpcionInvalidaException e) {

                System.out.println(
                        "Error: " + e.getMessage());

            } catch (NumberFormatException e) {

                System.out.println(
                        "Error: Debe ingresar un número.");
            }

        } while (opcion != 0);

        input.close();
    }
}
