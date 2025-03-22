import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Declaración de variables
        String[] productos = new String[10];
        int[] cantidades = new int[10];
        double[] precios = new double[10];
        int opcion;
        int indice = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Tienda De Fruta");


        productos[0] = "Manzana";
        productos[1] = "Plátano";
        productos[2] = "Naranja";
        productos[3] = "Fresa";
        productos[4] = "Mango";
        productos[5] = "Uva";

        cantidades[0] = 10;
        cantidades[1] = 20;
        cantidades[2] = 15;
        cantidades[3] = 3;
        cantidades[4] = 25;
        cantidades[5] = 13;

        precios[0] = 1.50;
        precios[1] = 2.00;
        precios[2] = 1.75;
        precios[3] = 3.00;
        precios[4] = 2.50;
        precios[5] = 5.20;

        while (true) {

            System.out.println("Inventario de la tienda");
            System.out.println("1. Agregar producto");
            System.out.println("2. Eliminar producto");
            System.out.println("3. Mostrar inventario");
            System.out.println("4. Buscar producto");
            System.out.println("5. Salir");


            opcion = scanner.nextInt();


            switch (opcion) {
                case 1:

                    if (indice < 10) {
                        System.out.println("Ingrese el nombre del producto:");
                        scanner.nextLine();
                        productos[indice] = scanner.nextLine();
                        System.out.println("Ingrese la cantidad del producto:");
                        cantidades[indice] = scanner.nextInt();
                        System.out.println("Ingrese el precio del producto:");
                        precios[indice] = scanner.nextDouble();
                        indice++;
                    } else {
                        System.out.println("No hay espacio disponible en el inventario.");
                    }
                    break;
                case 2:

                    System.out.println("Ingrese el nombre del producto a eliminar:");
                    scanner.nextLine();
                    String productoEliminar = scanner.nextLine();
                    for (int i = 0; i < 9; i++) {
                        if (productos[i].equals(productoEliminar)) {

                            for (int j = i; j < 9; j++) {
                                productos[j] = productos[j + 1];
                                cantidades[j] = cantidades[j + 1];
                                precios[j] = precios[j + 1];
                            }
                            indice--;
                            System.out.println("Producto eliminado con éxito.");
                            break;
                        }
                    }
                    break;
                case 3:

                    System.out.println("Inventario:");
                    for (int i = 0; i < indice; i++) {
                        System.out.println("Producto: " + productos[i]);
                        System.out.println("Cantidad: " + cantidades[i]);
                        System.out.println("Precio: " + precios[i]);
                        System.out.println();
                    }
                    break;
                case 4:
                    // Buscar producto
                    System.out.println("Ingrese el nombre del producto a buscar:");
                    scanner.nextLine();
                    String productoBuscar = scanner.nextLine();
                    boolean encontrado = false;
                    for (int i = 0; i < indice; i++) {
                        if (productos[i].equals(productoBuscar)) {
                            System.out.println("Producto encontrado:");
                            System.out.println("Cantidad: " + cantidades[i]);
                            System.out.println("Precio: " + precios[i]);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 5:

                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}