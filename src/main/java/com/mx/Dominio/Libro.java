package com.mx.Dominio;

import java.sql.Date;

public class Libro {
	
	int id;
	String nombre;
	int numpag;
	String autor;
	Date fechapubli;
	String editorial;
	String pais;
	double precio;
	
	public Libro() {
		
	}

	public Libro(int id, String nombre, int numpag, String autor, Date fechapubli, String editorial, String pais,
			double precio) {
		this.id = id;
		this.nombre = nombre;
		this.numpag = numpag;
		this.autor = autor;
		this.fechapubli = fechapubli;
		this.editorial = editorial;
		this.pais = pais;
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "\nLibro [id=" + id + ", nombre=" + nombre + ", numpag=" + numpag + ", autor=" + autor + ", fechapubli="
				+ fechapubli + ", editorial=" + editorial + ", pais=" + pais + ", precio=" + precio + "]\n";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumpag() {
		return numpag;
	}

	public void setNumpag(int numpag) {
		this.numpag = numpag;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Date getFechapubli() {
		return fechapubli;
	}

	public void setFechapubli(Date fechapubli) {
		this.fechapubli = fechapubli;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}
