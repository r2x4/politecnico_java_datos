package com.mycompany;

import java.time.LocalDate;
import java.util.Scanner;

public class Producto {
    private static int idCounter = 1;
    private int id;
    private String nombre;
    private String marca;
    private double valorCompra;
    private int stock;
    private LocalDate fechaRegistro;

    public Producto(String nombre, String marca, double valorCompra, int stock, LocalDate fechaRegistro) {
        this.id = idCounter++;
        this.nombre = nombre;
        this.marca = marca;
        this.valorCompra = valorCompra;
        this.stock = stock;
        this.fechaRegistro = fechaRegistro;
    }

    public static void setIdCounterManual(int id) {
        idCounter = id;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void reducirStock(int cantidad) {
        this.stock -= cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", valorCompra=" + valorCompra +
                ", stock=" + stock +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }

    public static Producto crearProducto(Scanner scanner, LocalDate fechaRegistro) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Valor de compra: ");
        double valorCompra = Double.parseDouble(scanner.nextLine());
        System.out.print("Stock: ");
        int stock = Integer.parseInt(scanner.nextLine());

        return new Producto(nombre, marca, valorCompra, stock, fechaRegistro);    
    }
}