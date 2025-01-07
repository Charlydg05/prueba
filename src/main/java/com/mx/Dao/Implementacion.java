package com.mx.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mx.Dominio.Libro;
import com.mx.General.ConexionDB;
import com.mx.General.Metodos;

public class Implementacion implements Metodos {

	Libro libro;
	ConexionDB db = new ConexionDB();

	@Override
	public void guardar(Object obj) {
		libro = (Libro) obj;
		Connection conexion = null;
		PreparedStatement pst = null;
		String query = "INSERT INTO LIBRO (ID, NOMBRE, NUMPAG, AUTOR, FECHA_PUBLICACION, EDITORIAL, PAIS, PRECIO)"
				+ "VALUES(?,?,?,?,?,?,?,?)";
		try {
			Class.forName(db.getDriver());
			conexion = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());

			pst = conexion.prepareStatement(query);

			pst.setInt(1, libro.getId());
			pst.setString(2, libro.getNombre());
			pst.setInt(3, libro.getNumpag());
			pst.setString(4, libro.getAutor());
			pst.setDate(5, libro.getFechapubli());
			pst.setString(6, libro.getEditorial());
			pst.setString(7, libro.getPais());
			pst.setDouble(8, libro.getPrecio());

			if (pst.executeUpdate() == 1) {
				System.out.println("Libro registrado con exito");
			} else {
				System.out.println("Posibles errores al guardar libro");
			}

		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

	}

	@Override
	public void buscar(Object obj) {
		libro=(Libro) obj;
		Connection conexion = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		String query = "SELECT * FROM LIBRO WHERE ID=" + libro.getId();

		try {
			Class.forName(db.getDriver());
			conexion = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());
			pst = conexion.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				libro = new Libro(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getInt("NUMPAG"), rs.getString("AUTOR"),
						rs.getDate("FECHA_PUBLICACION"), rs.getString("EDITORIAL"), rs.getString("PAIS"),
						rs.getDouble("PRECIO"));
			}
			System.out.println(libro);

		} catch (Exception e) {
			System.out.println("Erro en consulta: " + e);
		}

	}

	@Override
	public void editar(Object obj) {

		libro = (Libro) obj;
		Connection conexion = null;
		PreparedStatement pst = null;
		String query = "UPDATE LIBRO SET NOMBRE=?, NUMPAG=?, AUTOR=?, FECHA_PUBLICACION=?, EDITORIAL=?, PAIS=?, PRECIO=? WHERE ID=?";
		try {
			Class.forName(db.getDriver());
			conexion = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());

			pst = conexion.prepareStatement(query);

			pst.setString(1, libro.getNombre());
			pst.setInt(2, libro.getNumpag());
			pst.setString(3, libro.getAutor());
			pst.setDate(4, libro.getFechapubli());
			pst.setString(5, libro.getEditorial());
			pst.setString(6, libro.getPais());
			pst.setDouble(7, libro.getPrecio());
			pst.setInt(8, libro.getId());

			if (pst.executeUpdate() == 1) {
				System.out.println("Libro actualizado con exito");
			} else {
				System.out.println("Posibles errores al actualizar el libro");
			}

		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

	}

	@Override
	public void eliminar(Object obj) {
		libro=(Libro) obj;
		Connection conexion=null;
		PreparedStatement pst=null;
		
		String query="DELETE FROM LIBRO WHERE ID="+libro.getId();
		
		try {
			Class.forName(db.getDriver());
			conexion=DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());
			pst=conexion.prepareStatement(query);
			if(pst.executeUpdate()==1) {
				System.out.println("Se Elimino el libro");
			}else {
				System.out.println("No existe ese libro");
			}
			
		} catch (Exception e) {
			System.out.println("Se genero un error: "+e);
		}

	}

	@Override
	public List<Libro> listar() {

		List<Libro> lista = new ArrayList<Libro>();

		Connection conexion = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		String query = "SELECT * FROM LIBRO";

		try {
			Class.forName(db.getDriver());
			conexion = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());

			pst = conexion.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				lista.add(new Libro(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getInt("NUMPAG"), rs.getString("AUTOR"),
						rs.getDate("FECHA_PUBLICACION"), rs.getString("EDITORIAL"), rs.getString("PAIS"),
						rs.getDouble("PRECIO")));
			}

		} catch (Exception e) {
			System.out.println("Error al listar: " + e.getMessage());

			return null;
		}

		return lista;
	}

	@Override
	public String listarIndice() {
		List<Libro> lista = new ArrayList<Libro>();

		Connection conexion = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		String query = "SELECT * FROM LIBRO", cadena = "";

		try {

			Class.forName(db.getDriver());
			conexion = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());

			pst = conexion.prepareStatement(query);
			rs = pst.executeQuery();

			while (rs.next()) {
				lista.add(new Libro(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getInt("NUMPAG"), rs.getString("AUTOR"),
						rs.getDate("FECHA_PUBLICACION"), rs.getString("EDITORIAL"), rs.getString("PAIS"),
						rs.getDouble("PRECIO")));
			}

			for (int i = 0; i < lista.size(); i++) {
				cadena += ("\n[" + i + "]" + lista.get(i).getNombre());

			}
			return cadena;

		} catch (Exception e) {
			return "Error al listar: " + e.getMessage();
		}

	}

	public void buscarNombre(Object obj) {
		String id = (String) obj;
		Connection conexion = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		String query = "SELECT * FROM LIBRO WHERE nombre='" + id + "'";

		try {
			Class.forName(db.getDriver());
			conexion = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());
			pst = conexion.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				libro = new Libro(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getInt("NUMPAG"), rs.getString("AUTOR"),
						rs.getDate("FECHA_PUBLICACION"), rs.getString("EDITORIAL"), rs.getString("PAIS"),
						rs.getDouble("PRECIO"));
			}
			System.out.println(libro);

		} catch (Exception e) {
			System.out.println("Erro en consulta: " + e);
		}

	}

	public Libro getLibro(int id) {
		Connection conexion = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		String query = "SELECT * FROM LIBRO WHERE ID=" + id;

		try {
			Class.forName(db.getDriver());
			conexion = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());
			pst = conexion.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				libro = new Libro(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getInt("NUMPAG"), rs.getString("AUTOR"),
						rs.getDate("FECHA_PUBLICACION"), rs.getString("EDITORIAL"), rs.getString("PAIS"),
						rs.getDouble("PRECIO"));
			}
			return libro;

		} catch (Exception e) {
			System.out.println("Erro en consulta: " + e);
		}
		return null;
	}
	
	public void eliminarNombre(Object obj) {
		String id=(String)obj;
		Connection conexion=null;
		PreparedStatement pst=null;
		
		String query="DELETE FROM LIBRO WHERE NOMBRE='"+id+"'";
		
		try {
			Class.forName(db.getDriver());
			conexion=DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());
			pst=conexion.prepareStatement(query);
			if(pst.executeUpdate()==1) {
				System.out.println("Se Elimino el libro");
			}else {
				System.out.println("No existe ese libro");
			}
			
		} catch (Exception e) {
			System.out.println("Se genero un error: "+e);
		}

	}

}
