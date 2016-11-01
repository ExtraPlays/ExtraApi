package me.ep.extraapi.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import me.ep.extraapi.ExtraApi;

public class Mysql {
	
	private String host;
	private String user;
	private String pass;
	private String db;	
	private Connection con = null;	
	private Statement s;
	
	String driver = "com.mysql.jdbc.Driver";	
	ExtraApi m;
	
	public Mysql(String host, String user, String pass, String db, ExtraApi m){
		this.host = host;
		this.user = user;
		this.pass = pass;
		this.db = db;
		this.m = m;
	}
	
	
	public String getHost(){
		return this.host;
	}
	
	public String getUser(){
		return this.user;
	}
	
	public String getPass(){
		return this.pass;
	}
	
	public String getDb(){
		return this.db;
	}
	
	public Connection getConnection(){
		return this.con;
	}
	
	public Statement getStatement(){ 
		return this.s;
	}
	
	public void connect(){
		try {
			Class.forName(driver);
					
			
			m.getLogger().info("Conectando ao Banco de Dados " + this.db + "!");
			this.con = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + "3306" + "/" + this.db, this.user, this.pass);	
			m.getLogger().info("Conectado Com Sucesso");
									
			this.s = getConnection().createStatement();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close(){
		try {
			this.con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean isEnabled(){
		return m.getConfig().getBoolean("Mysql.Ativar");
	}
}

