package br.com.viagem.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.viagem.factory.ConnectionFactory;
import br.com.viagem.model.Cliente;

public class ClienteDAO {
    
	 public void salvar(Cliente cliente) {
		 
		 //create
		 
		 String sql = "INSERT INTO cliente(nome, email, dataCadastro) VALUES(?, ?, ?)";
		 
		 Connection conn = null;
		 PreparedStatement pstm = null;
		 
		 try {
			 conn = ConnectionFactory.createConnectionToMySQL();
			 
			 pstm = conn.prepareStatement(sql);
			 pstm.setString(1, cliente.getNome());
			 pstm.setString(2, cliente.getEmail());
			 pstm.setDate(3, new Date(cliente.getDataCadastro().getTime()));
			 
			 pstm.execute();
	    }catch (Exception e) {
	    	e.printStackTrace();
	    }finally {
	    	try {
	    		if(pstm!=null) {
	    			pstm.close();
	    		}
	    		if(conn!=null) {
	    			conn.close();
	    		}	
	    	}catch (Exception e) {
	    		e.printStackTrace(); 
	    	}
	    }
	}
 
	 //UPDATE
	 public void update(Cliente cliente) {
		 
		 String sql = "UPDATE cliente SET nome = ?, email = ?, dataCadastro = ? " +
		 "WHERE id = ?";
		 
		 Connection conn = null;
		 PreparedStatement pstm = null;
		 
		 try {
			 conn = ConnectionFactory.createConnectionToMySQL();
			 
			 pstm = conn.prepareStatement(sql); 
			 
			 pstm.setString(1, cliente.getNome());
			 pstm.setString(2, cliente.getEmail());
			 pstm.setDate(3, new Date(cliente.getDataCadastro().getTime()));
			 
			 pstm.setInt(4, cliente.getId());
			 
			 pstm.execute();
		 }catch (Exception e) {
			 e.printStackTrace();
		 }finally {
			 try {
				 if(pstm!=null);{
				 pstm.close();
			 }
			 if(conn!=null) {
				 conn.close();
			 }
		 }catch (Exception e) {
			 e.printStackTrace();
		 	}
		 }
	 }
	 
	 //DELETE
	 
	 public void deleteByID(int id) {
		 
		 String sql = "DELETE FROM cliente WHERE id = ?";
		 
		 Connection conn = null;
		 
		 PreparedStatement pstm = null;
		 
		 try {
			 conn = ConnectionFactory.createConnectionToMySQL();
			 pstm = conn.prepareStatement(sql);
			 pstm.setInt(1, id);
			 pstm.execute();
		 }catch (Exception e) {
			 e.printStackTrace();
		 }finally {
			 try {
				 if(pstm != null) {
					 pstm.close();
				 }
				 if(conn != null) {
					 conn.close();
				 }	 
				 }catch (Exception e) {
					 e.printStackTrace();
				 }
			 }
			 
		 }
	 
	 //READ
	 public List<Cliente>getClientes(){
		 String sql = "SELECT * FROM cliente";
		 
		 List<Cliente> clientes = new ArrayList<Cliente>();
		 
		 Connection conn = null;
		 PreparedStatement pstm = null;
		 
		 ResultSet rset = null;
		 
		 try {
			 conn = ConnectionFactory.createConnectionToMySQL();
			 pstm = conn.prepareStatement(sql);
			 rset = pstm.executeQuery();
			 
			 while(rset.next()) {
				 
				 Cliente cliente = new Cliente();
				 
				 cliente.setId(rset.getInt("id"));
				 cliente.setNome(rset.getString("nome"));
				 cliente.setEmail(rset.getString("email"));
				 cliente.setDataCadastro(rset.getDate("dataCadastro"));
				 
				 clientes.add(cliente);
			 }
		 }catch (Exception e) {
			 e.printStackTrace();
		 }finally {
			try {
				 if(rset!=null) {
					 rset.close();
				 }
				 if(pstm!=null) {
					 pstm.close();
				 }
				 if(conn!=null) {
					 conn.close();
				 }
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		 }
		 return clientes;
	 }
 }
