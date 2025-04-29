package com.mycompany;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class GenerateInfoFiles {

    private static final String CARPETA_DATOS = "Datos/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nGENERADOR DE ARCHIVOS BASE");
        System.out.println("1. Crear vendedores.csv");
        System.out.println("2. Crear productos.csv");
        System.out.println("3. Crear ventas.csv");
        System.out.println("4. Crear TODOS los archivos");
        System.out.println("5. Salir");
        System.out.print("Seleccione opcion (1-5): ");

        String opcion = scanner.nextLine();

        try {
            switch (opcion) {
                case "1":
                    generarArchivoConConfirmacion("vendedores.csv",
                            "id,nombre,idIdentificacion,ciudad,pais\n", scanner);
                    break;
                case "2":
                    generarArchivoConConfirmacion("productos.csv",
                            "id,nombre,marca,valorCompra,stock\n", scanner);
                    break;
                case "3":
                    generarArchivoConConfirmacion("ventas.csv",
                            "id,id_vendedor,id_producto,cantidad,precio_venta,fecha\n", scanner);
                    break;
                case "4":
                    generarTodosArchivos(scanner);
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Opcion no valida");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }        
    }

   private static void generarTodosArchivos(Scanner scanner) throws IOException {
        System.out.println("\nEsto sobrescribira TODOS los archivos existentes.");
        System.out.print("Desea continuar? (S/N): ");
        if (scanner.nextLine().equalsIgnoreCase("S")) {
            generarArchivo("vendedores.csv", "id,nombre,idIdentificacion,ciudad,pais\n");
            generarArchivo("productos.csv", "id,nombre,marca,valorCompra,stock\n");
            generarArchivo("ventas.csv", "id,id_vendedor,id_producto,cantidad,precio_venta,fecha\n");
            System.out.println("\nTodos los archivos creados en " + CARPETA_DATOS);
        } else {
            System.out.println("Operacion cancelada.");
        }
    }

    private static void generarArchivoConConfirmacion(String filename, String cabecera,
                                                      Scanner scanner) throws IOException {
        File archivo = new File(CARPETA_DATOS + filename);
        if (archivo.exists()) {
            System.out.print("\nEl archivo ya existe. Sobrescribir? (S/N): ");
            if (!scanner.nextLine().equalsIgnoreCase("S")) {
                return;
            }
        }
        generarArchivo(filename, cabecera);
        System.out.println("\n" + filename + " creado exitosamente");        
    }   

    private static void generarArchivo(String filename, String cabecera) throws IOException {
        crearDirectorioSiNoExiste();
        try (FileWriter writer = new FileWriter(CARPETA_DATOS + filename)) {
            writer.write(cabecera);
        }
    }

    private static void crearDirectorioSiNoExiste() {
        File directorio = new File(CARPETA_DATOS);
        if (!directorio.exists()) {
            directorio.mkdir();
        }
    }
}