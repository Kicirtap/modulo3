package br.com.viagem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.viagem.factory.ConnectionFactory;
import br.com.viagem.model.Viagem;

public class ViagemDAO {
    
	 public void salvar(Viagem viagem) {
		 
		 //create
		 
		 String sql = "INSERT INTO viagem(destino, descricao, dataViagem) VALUES(?, ?, ?)";
		 
		 Connection conn = null;
		 PreparedStatement pstm = null;
		 
		 try {
			 conn = ConnectionFactory.createConnectionToMySQL();
			 
			 pstm = conn.prepareStatement(sql);
			 pstm.setString(1, viagem.getDestino());
			 pstm.setString(2, viagem.getDescricao());
			 pstm.setString(3, viagem.getDataViagem());
			 
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
	 public void update(Viagem viagem) {
		 
		 String sql = "UPDATE viagem SET destino = ?, descricao = ?, dataViagem = ? " +
		 "WHERE viagem_id = ?";
		 
		 Connection conn = null;
		 PreparedStatement pstm = null;
		 
		 try {
			 conn = ConnectionFactory.createConnectionToMySQL();
			 
			 pstm = conn.prepareStatement(sql); 
			 
			 pstm.setString(1, viagem.getDestino());
			 pstm.setString(2, viagem.getDescricao());
			 pstm.setString(3, viagem.getDataViagem());
			 
			 pstm.setInt(4, viagem.getViagem_id());
			 
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
	 
	 public void deleteByID(int viagem_id) {
		 
		 String sql = "DELETE FROM viagem WHERE viagem_id = ?";
		 
		 Connection conn = null;
		 
		 PreparedStatement pstm = null;
		 
		 try {
			 conn = ConnectionFactory.createConnectionToMySQL();
			 pstm = conn.prepareStatement(sql);
			 pstm.setInt(1, viagem_id);
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
	 public List<Viagem>getViagens(){
		 String sql = "SELECT * FROM viagem";
		 
		 List<Viagem> viagens = new ArrayList<Viagem>();
		 
		 Connection conn = null;
		 PreparedStatement pstm = null;
		 
		 ResultSet rset = null;
		 
		 try {
			 conn = ConnectionFactory.createConnectionToMySQL();
			 pstm = conn.prepareStatement(sql);
			 rset = pstm.executeQuery();
			 
			 while(rset.next()) {
				 
				 Viagem viagem = new Viagem();
				 
				 viagem.setViagem_id(rset.getInt("viagem_id"));
				 viagem.setDestino(rset.getString("destino"));
				 viagem.setDescricao(rset.getString("descricao"));
				 viagem.setDataViagem(rset.getString("dataViagem"));
				 
				 viagens.add(viagem);
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
		 return viagens;
	 }
 }
