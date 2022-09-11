package br.com.viagem.factory;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {
	
	   private static final String USERNAME = "root";
	   private static final String PASSWORD = "12345678";
	   private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agencia";
	  
	   
	   public static Connection createConnectionToMySQL() throws Exception {
	     
			Class.forName("com.mysql.cj.jdbc.Driver");
		
	      //Cria a conexão com o banco de dados
	      Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
	 
	      return connection;
	 
}
	   
	   public static void main(String[] args) throws Exception{
		   
		      //Recupera uma conexão com o BD
		      Connection con = createConnectionToMySQL();
		 
		      //Testa se a conexão é null
		      if(con != null){
		         System.out.println("Conexão obtida com sucesso!" + con);
		         con.close();
		      }
		 
		   }
		}
