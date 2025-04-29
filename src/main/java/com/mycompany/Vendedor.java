package com.mycompany;

import java.time.LocalDate;
import java.util.Scanner;

public class Vendedor {
    private static int idCounter = 1;

    private int id;
    private String nombre;
    private String telefono;
    private String idIdentificacion;
    private String ciudad;
    private String pais;
    private LocalDate fechaIngreso;

    public Vendedor(String nombre, String telefono, String idIdentificacion, String ciudad, String pais, LocalDate fechaIngreso) {
        this.id = idCounter++;
        this.nombre = nombre;
        this.telefono = telefono;
        this.idIdentificacion = idIdentificacion;
        this.ciudad = ciudad;
        this.pais = pais;
        this.fechaIngreso = fechaIngreso;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIdIdentificacion() {
        return idIdentificacion;
    }

    public void setIdIdentificacion(String idIdentificacion) {
        this.idIdentificacion = idIdentificacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", idIdentificacion='" + idIdentificacion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", pais='" + pais + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                '}';
    }

    public static Vendedor crearVendedor(Scanner scanner, LocalDate fechaIngreso) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("ID de identificación: ");
        String idIdentificacion = scanner.nextLine();
        System.out.print("Ciudad: ");
        String ciudad = scanner.nextLine();
        System.out.print("País: ");
        String pais = scanner.nextLine();

        return new Vendedor(nombre, telefono, idIdentificacion, ciudad, pais, fechaIngreso);
    }
}