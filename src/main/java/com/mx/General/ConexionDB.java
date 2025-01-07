package com.mx.General;

public class ConexionDB {
	private String driver;
	private String url;
	private String user;
	private String pass;
	public ConexionDB() {
		
		this.driver="oracle.jdbc.OracleDriver";
		this.url="jdbc:oracle:thin:@localhost:1521:xe";
		this.user="System";
		this.pass="123";
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

}
