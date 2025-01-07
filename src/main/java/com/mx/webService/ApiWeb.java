package com.mx.webService;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mx.Dao.Implementacion;
import com.mx.Dominio.Libro;

@Path("ApiWeb")
public class ApiWeb {
	Implementacion imp;
	@Path("prueba")
	@GET
	@Produces({MediaType.TEXT_PLAIN})
	// minusculas(web.xml) + path de la clase + path del metodo o endpoint
	//http://localhost:9001/Bilbioteca/biblioteca/ApiWeb/prueba
	public String prueba() {
		return "Bienvenido a la Biblioteca";
	}

	@Path("listadoLibros")
	@GET
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	// http://localhost:9001/Bilbioteca/biblioteca/ApiWeb/listadoLibros
	public List<Libro> listar(){
		List<Libro> lista=new ArrayList<Libro>();
		imp=new Implementacion();
		
		lista=imp.listar();
		
		if(lista.isEmpty()) {
			System.out.println("no hay elementos ");
		}
		
		return lista;
	}
	
	@Path("guardarLibro")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	// http://localhost:9001/Bilbioteca/biblioteca/ApiWeb/guardarLibro
	public void guardar(Libro libro) {
		imp=new Implementacion();
		imp.guardar(libro);
	}
	
	@Path("editarLibro")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	// http://localhost:9001/Bilbioteca/biblioteca/ApiWeb/editarLibro
	public void editar(Libro libro) {
		imp=new Implementacion();
		imp.editar(libro);
	}
	
	@Path("eliminarLibro")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	// http://localhost:9001/Bilbioteca/biblioteca/ApiWeb/eliminarLibro
	public void eliminar(Libro libro) {
		imp=new Implementacion();
		imp.eliminar(libro);
	}
	
	@Path("buscarNombreLibro")
	@GET
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	// http://localhost:9001/Bilbioteca/biblioteca/ApiWeb/buscarNombreLibro
	public void buscarNombre(String name) {
		imp=new Implementacion();
		imp.buscarNombre("Pedro Páramo");
	}
	

	
	
}
