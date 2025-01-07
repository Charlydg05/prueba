package com.mx.Controller;

import java.sql.Date;

import com.mx.Dao.Implementacion;
import com.mx.Dominio.Libro;

public class Main {

	public static void main(String[] args) {
		Implementacion imp=new Implementacion();
		
		System.out.println(imp.listar());
		System.out.println(imp.listarIndice());
		
//		Libro libro=new Libro(4, "Duna", 412, "Frank Herbert", Date.valueOf("2024-12-16"), "Chilton Books", "USA", 400.00);
//		imp.guardar(libro);
		
		imp.buscar(2);
		
		imp.eliminar(1);
		
		imp.buscarNombre("Duna");
		
		imp.eliminarNombre("Duna");

	}

}
