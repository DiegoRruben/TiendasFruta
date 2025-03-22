
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[] productos = new String[10];
        int[] cantidades = new int[10];
        double[] precios = new double[10];
        double[] preciosConIva = new double[10];
        int opcion;
        int indice = 0;
        Scanner scanner = new Scanner(System.in);
        double iva = 0.16;

        System.out.println("Tienda De Frutas");


        productos[0] = "Manzana";
        productos[1] = "Plátano";
        productos[2] = "Naranja";
        productos[3] = "Fresa";
        productos[4] = "Mango";

        cantidades[0] = 10;
        cantidades[1] = 20;
        cantidades[2] = 15;
        cantidades[3] = 30;
        cantidades[4] = 25;

        precios[0] = 1.50;
        precios[1] = 2.00;
        precios[2] = 1.75;
        precios[3] = 3.00;
        precios[4] = 2.50;

        for (int i = 0; i < 5; i++) {
            preciosConIva[i] = precios[i] * (1 + iva);
        }

        while (true) {

            System.out.println("Inventario de la tienda");
            System.out.println("1. Agregar producto");
            System.out.println("2. Eliminar producto");
            System.out.println("3. Mostrar inventario");
            System.out.println("4. Salir");


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
                        preciosConIva[indice] = precios[indice] * (1 + iva);
                        indice++;
                    } else {
                        System.out.println("No hay espacio disponible en el inventario.");
                    }
                    break;
                case 2:

                    System.out.println("Ingrese el nombre del producto a eliminar:");
                    scanner.nextLine(); // Consumir el salto de línea
                    String productoEliminar = scanner.nextLine();
                    for (int i = 0; i < 10; i++) {
                        if (productos[i].equals(productoEliminar)) {
                            // Desplazar los elementos hacia la izquierda
                            for (int j = i; j < 9; j++) {
                                productos[j] = productos[j + 1];
                                cantidades[j] = cantidades[j + 1];
                                precios[j] = precios[j + 1];
                                preciosConIva[j] = preciosConIva[j + 1];
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
                        System.out.println("Precio sin IVA: " + precios[i]);
                        System.out.println("Precio con IVA: " + preciosConIva[i]);
                        System.out.println();
                    }
                    break;
                case 4:

                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}

//Diego Rubén