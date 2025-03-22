import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayList<String> frutas = new ArrayList<>();
        ArrayList<Double> precios = new ArrayList<>();
        ArrayList<Integer> stock = new ArrayList<>();
        final double IVA = 12;


        frutas.add("Manzana");
        precios.add(1.00);
        stock.add(15);

        frutas.add("Banana");
        precios.add(0.75);
        stock.add(12);

        frutas.add("Naranja");
        precios.add(0.80);
        stock.add(14);

        boolean continuar = true;

        while (continuar) {

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

                System.out.println("Inventario:");
                for (int i = 0; i < frutas.size(); i++) {
                    double precioConIVA = precios.get(i) * (1 + IVA);
                    System.out.println((i + 1) + ". " + frutas.get(i) + " - Q" + String.format("%.2f", precioConIVA) + " (IVA incluido) - Stock: " + stock.get(i));
                }
            } else if (opcion == 2) {

                System.out.print("Ingrese el nombre de la fruta a buscar: ");
                String nombreBusqueda = scanner.nextLine().toLowerCase();
                boolean encontrado = false;

                for (int i = 0; i < frutas.size(); i++) {
                    if (frutas.get(i).toLowerCase().equals(nombreBusqueda)) {
                        double precioConIVA = precios.get(i) * (1 + IVA);
                        System.out.println("Producto encontrado: " + frutas.get(i) + " - Q" + String.format("%.2f", precioConIVA) + " - Stock: " + stock.get(i));
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    System.out.println("Producto no encontrado.");
                }
            } else if (opcion == 3) {

                System.out.print("Ingrese el nombre de la nueva fruta: ");
                String nuevaFruta = scanner.nextLine();
                System.out.print("Ingrese el precio de " + nuevaFruta + ": ");
                double nuevoPrecio = scanner.nextDouble();
                System.out.print("Ingrese el stock de " + nuevaFruta + ": ");
                int nuevoStock = scanner.nextInt();
                scanner.nextLine();


                frutas.add(nuevaFruta);
                precios.add(nuevoPrecio);
                stock.add(nuevoStock);

                System.out.println("Nuevo producto agregado: " + nuevaFruta + " - Q" + String.format("%.2f", nuevoPrecio * (1 + IVA)) + " (IVA incluido) - Stock: " + nuevoStock);
            } else if (opcion == 4) {

                System.out.print("Ingrese el nombre de la fruta a eliminar: ");
                String frutaEliminar = scanner.nextLine().toLowerCase();
                boolean eliminada = false;

                for (int i = 0; i < frutas.size(); i++) {
                    if (frutas.get(i).toLowerCase().equals(frutaEliminar)) {
                        System.out.println("Producto eliminado: " + frutas.get(i));
                        frutas.remove(i);
                        precios.remove(i);
                        stock.remove(i);
                        eliminada = true;
                        break;
                    }
                }

                if (!eliminada) {
                    System.out.println("No se encontró la fruta.");
                }
            } else if (opcion == 5) {

                System.out.println("Gracias por usar el sistema de Tienda de Frutas Vuelva pronto.");
                continuar = false;
            } else {
                System.out.println("Opción no válida, intente nuevamente.");
            }
        }

        scanner.close();
    }
}