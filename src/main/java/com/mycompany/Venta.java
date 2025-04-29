package com.mycompany;

import java.time.LocalDate;
import java.util.Scanner;

public class Venta {
    private static int idCounter = 1;

    private int id;
    private int idVendedor;
    private int idProducto;
    private int cantidad;
    private double precioVenta;
    private LocalDate fecha;

    public Venta(int idVendedor, int idProducto, int cantidad, double precioVenta) {
        this.id = idCounter++;
        this.idVendedor = idVendedor;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
    }

    public int getId() {
        return id;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public static Venta crearVenta(Scanner scanner) {
        System.out.print("ID Vendedor: "); int idVendedor = Integer.parseInt(scanner.nextLine()); System.out.print("ID Producto: "); int idProducto = Integer.parseInt(scanner.nextLine()); System.out.print("Cantidad: "); int cantidad = Integer.parseInt(scanner.nextLine()); System.out.print("Precio de venta: "); double precioVenta = Double.parseDouble(scanner.nextLine()); return new Venta(idVendedor, idProducto, cantidad, precioVenta);
    }
}