package com.mx.General;

import java.util.List;

import com.mx.Dominio.Libro;


public interface Metodos {
	
	public void guardar(Object obj);
	public void buscar(Object obj);
	public void editar(Object obj);
	public void eliminar(Object obj);
	public List<Libro> listar();
	public String listarIndice();
	

}
