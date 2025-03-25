import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Tienda Web De Frutas");

        ArrayList<String> frutas = new ArrayList<>();
        ArrayList<Double> precios = new ArrayList<>();
        ArrayList<Integer> stock = new ArrayList<>();
        final double IVA = 0.12;

        frutas.add("Manzana");
        precios.add(1.00);
        stock.add(15);

        frutas.add("Banana");
        precios.add(2.25);
        stock.add(12);

        frutas.add("Naranja");
        precios.add(3.30);
        stock.add(18);

        frutas.add("Aguacate");
        precios.add(5.90);
        stock.add(12);

        frutas.add("Pera");
        precios.add(7.10);
        stock.add(8);




        boolean continuar = true;

        while (continuar) {
            System.out.println("\nTienda de Frutas");
            System.out.println("1. Ver productos");
            System.out.println("2. Buscar un producto");
            System.out.println("3. Agregar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\nInventario:");
                    System.out.println("-----------------------------------------");
                    System.out.printf("%-10s %-10s %-10s%n", "Fruta", "Precio(Q)", "Stock");
                    System.out.println("-----------------------------------------");

                    for (int i = 0; i < frutas.size(); i++) {
                        double precioConIVA = precios.get(i) * (1 + IVA);
                        System.out.printf("%-10s Q%-9.2f %-10d%n", frutas.get(i), precioConIVA, stock.get(i));
                    }
                    System.out.println("-----------------------------------------");
                    break;

                case 2:
                    System.out.print("Ingrese el nombre de la fruta a buscar: ");
                    String nombreBusqueda = scanner.nextLine();
                    boolean encontrado = false;

                    for (int i = 0; i < frutas.size(); i++) {
                        if (frutas.get(i).equalsIgnoreCase(nombreBusqueda)) {
                            double precioConIVA = precios.get(i) * (1 + IVA);
                            System.out.println("Producto encontrado: " + frutas.get(i) +
                                    " - Q" + String.format("%.2f", precioConIVA) +
                                    " - Stock: " + stock.get(i));
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el nombre de la nueva fruta: ");
                    String nuevaFruta = scanner.nextLine();
                    System.out.print("Ingrese el precio de " + nuevaFruta + ": ");
                    double nuevoPrecio = scanner.nextDouble();
                    System.out.print("Ingrese el stock de " + nuevaFruta + ": ");
                    int nuevoStock = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer

                    frutas.add(nuevaFruta);
                    precios.add(nuevoPrecio);
                    stock.add(nuevoStock);

                    System.out.println("Nuevo producto agregado: " + nuevaFruta +
                            " - Q" + String.format("%.2f", nuevoPrecio * (1 + IVA)) +
                            " (IVA incluido) - Stock: " + nuevoStock);
                    break;

                case 4:
                    System.out.print("Ingrese el nombre de la fruta a eliminar: ");
                    String frutaEliminar = scanner.nextLine();
                    boolean eliminada = false;

                    for (int i = 0; i < frutas.size(); i++) {
                        if (frutas.get(i).equalsIgnoreCase(frutaEliminar)) {
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
                    break;

                case 5:
                    System.out.println("Gracias por usar la Tienda de Frutas. ¡Vuelva pronto!");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        }

        scanner.close();
    }
}