import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Arrays para gestionar la información del inventario
        String[] frutas = {"Manzana", "Banana", "Naranja", "Pera", "Uva"};
        double[] precios = {1.00, 0.75, 0.80, 1.20, 2.50};  // Precio por unidad
        int[] stock = {10, 15, 12, 8, 20};
        final double IVA = 0.12;

        boolean continuar = true;

        while (continuar) {
            // Menú de opciones
            System.out.println("Tienda de Frutas");
            System.out.println("1. Ver productos");
            System.out.println("2. Buscar un producto");
            System.out.println("3. Agregar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {

                System.out.println("\nInventario:");
                for (int i = 0; i < frutas.length; i++) {
                    double precioConIVA = precios[i] * (1 + IVA);
                    System.out.println((i + 1) + ". " + frutas[i] + " - $" + String.format("%.2f", precioConIVA) + " (IVA incluido) - Stock: " + stock[i]);
                }
            } else if (opcion == 2) {
                // Buscar producto
                System.out.print("\nIngrese el nombre de la fruta a buscar: ");
                String nombreBusqueda = scanner.nextLine().toLowerCase();
                boolean encontrado = false;

                for (int i = 0; i < frutas.length; i++) {
                    if (frutas[i].toLowerCase().equals(nombreBusqueda)) {
                        double precioConIVA = precios[i] * (1 + IVA);
                        System.out.println("Producto encontrado: " + frutas[i] + " - $" + String.format("%.2f", precioConIVA) + " - Stock: " + stock[i]);
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    System.out.println("Producto no encontrado.");
                }
            } else if (opcion == 3) {
                // Agregar producto (no cambia tamaño del array, solo simula el ingreso)
                System.out.print("\nIngrese el nombre de la nueva fruta: ");
                String nuevaFruta = scanner.nextLine();
                System.out.print("Ingrese el precio de " + nuevaFruta + ": ");
                double nuevoPrecio = scanner.nextDouble();
                System.out.print("Ingrese el stock de " + nuevaFruta + ": ");
                int nuevoStock = scanner.nextInt();
                scanner.nextLine();  // Limpiar el buffer

                System.out.println("Nuevo producto agregado: " + nuevaFruta + " - $" + String.format("%.2f", nuevoPrecio * (1 + IVA)) + " (IVA incluido) - Stock: " + nuevoStock);
            } else if (opcion == 4) {
                // Eliminar producto (simulación, no cambia el array)
                System.out.print("\nIngrese el nombre de la fruta a eliminar: ");
                String frutaEliminar = scanner.nextLine().toLowerCase();
                boolean eliminada = false;

                for (int i = 0; i < frutas.length; i++) {
                    if (frutas[i].toLowerCase().equals(frutaEliminar)) {
                        System.out.println("Producto eliminado: " + frutas[i]);
                        eliminada = true;
                        break;
                    }
                }

                if (!eliminada) {
                    System.out.println("No se encontró la fruta.");
                }
            } else if (opcion == 5) {
                // Salir del programa
                System.out.println("Gracias por usar el sistema de inventario.");
                continuar = false;
            } else {
                System.out.println("Opción no válida, intente nuevamente.");
            }
        }

        scanner.close();
    }
}