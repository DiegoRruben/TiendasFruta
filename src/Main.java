import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] frutas = {"Manzana", "Banana", "Naranja", "Uva", "Pera"};
        int[] stock = {10, 15, 20, 5, 8};
        double[] precios = {1.5, 0.8, 1.2, 2.0, 1.0};

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- Gestión de Inventario de Frutas");
            System.out.println("1. Ver inventario");
            System.out.println("2. Agregar stock");
            System.out.println("3. Vender fruta");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();

            if (opcion == 1) {
                // Mostrar el inventario actual
                System.out.println("\nInventario actual:");
                for (int i = 0; i < frutas.length; i++) {
                    System.out.println(frutas[i] + " - Stock: " + stock[i] + " - Precio: $" + precios[i]);
                }
            } else if (opcion == 2) {
                // Agregar stock
                System.out.print("Ingrese el número de la fruta para agregar stock (0-4): ");
                int indice = scanner.nextInt();
                if (indice >= 0 && indice < frutas.length) {
                    System.out.print("Ingrese la cantidad a agregar: ");
                    int cantidad = scanner.nextInt();
                    if (cantidad > 0) {
                        stock[indice] += cantidad;
                        System.out.println("Stock actualizado correctamente.");
                    } else {
                        System.out.println("Cantidad inválida.");
                    }
                } else {
                    System.out.println("Opción inválida.");
                }
            } else if (opcion == 3) {
                // Vender fruta
                System.out.print("Ingrese el número de la fruta a vender (0-4): ");
                int indice = scanner.nextInt();
                if (indice >= 0 && indice < frutas.length) {
                    System.out.print("Ingrese la cantidad a vender: ");
                    int cantidad = scanner.nextInt();
                    if (cantidad > 0 && cantidad <= stock[indice]) {
                        stock[indice] -= cantidad;
                        double total = cantidad * precios[indice];
                        System.out.println("Venta realizada. Total a pagar: $" + total);
                    } else {
                        System.out.println("Cantidad no disponible en stock.");
                    }
                } else {
                    System.out.println("Opción inválida.");
                }
            } else if (opcion == 4) {
                // Salir del programa
                salir = true;
                System.out.println("Saliendo del programa...");
            } else {
                System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
        scanner.close();
    }
}
