package tpintegrador_programacion2.Main;

import java.util.Scanner;

import tpintegrador_programacion2.config.CRUDCategorias;
import tpintegrador_programacion2.config.CRUDProductos;
import tpintegrador_programacion2.config.CRUDUsuarios;
import tpintegrador_programacion2.config.CRUDPedidos;

import tpintegrador_programacion2.exception.OpcionInvalidaException;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        CRUDCategorias menuCrudCategorias = new CRUDCategorias();
        CRUDProductos menuCrudProductos = new CRUDProductos();
        CRUDUsuarios menuCrudUsuarios = new CRUDUsuarios();
        CRUDPedidos menuCrudPedidos = new CRUDPedidos();

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
                        menuCrudCategorias.menuCategorias(input);
                        break;

                    case 2:
                        menuCrudProductos.menuProductos(input);
                        break;

                    case 3:
                        menuCrudUsuarios.menuUsuarios(input);
                        break;

                    case 4:
                        menuCrudPedidos.menuPedidos(input);
                        break;

                    case 0:
                        System.out.println("Saliendo del sistema...");
                        break;
                }

            } catch (OpcionInvalidaException e) {

                System.out.println("Error: " + e.getMessage());

            } catch (NumberFormatException e) {

                System.out.println("Error: Debe ingresar un número.");
            }

        } while (opcion != 0);

        input.close();
    }
}
