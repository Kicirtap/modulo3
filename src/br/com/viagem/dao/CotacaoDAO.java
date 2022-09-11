package br.com.viagem.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.viagem.factory.ConnectionFactory;
import br.com.viagem.model.Cotacao;

public class CotacaoDAO {
    
	 public void salvar(Cotacao cotacao) {
		 
		 //create
		 
		 String sql = "INSERT INTO cotacao(destino, valor, dataCotacao) VALUES(?, ?, ?)";
		 
		 Connection conn = null;
		 PreparedStatement pstm = null;
		 
		 try {
			 conn = ConnectionFactory.createConnectionToMySQL();
			 
			 pstm = conn.prepareStatement(sql);
			 pstm.setString(1, cotacao.getDestino());
			 pstm.setString(2, cotacao.getValor());
			 pstm.setDate(3, new Date(cotacao.getDataCotacao().getTime()));
			 
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
	 public void update(Cotacao cotacao) {
		 
		 String sql = "UPDATE cotacao SET destino = ?, valor = ?, dataCotacao = ? " +
		 "WHERE id = ?";
		 
		 Connection conn = null;
		 PreparedStatement pstm = null;
		 
		 try {
			 conn = ConnectionFactory.createConnectionToMySQL();
			 
			 pstm = conn.prepareStatement(sql); 
			 
			 pstm.setString(1, cotacao.getDestino());
			 pstm.setString(2, cotacao.getValor());
			 pstm.setDate(3, new Date(cotacao.getDataCotacao().getTime()));
			 
			 pstm.setInt(4, cotacao.getCotacao_id());
			 
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
	 
	 public void deleteByID(int cotacao_id) {
		 
		 String sql = "DELETE FROM cotacao WHERE cotacao_id = ?";
		 
		 Connection conn = null;
		 
		 PreparedStatement pstm = null;
		 
		 try {
			 conn = ConnectionFactory.createConnectionToMySQL();
			 pstm = conn.prepareStatement(sql);
			 pstm.setInt(1, cotacao_id);
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
	 public List<Cotacao>getCotacoes(){
		 String sql = "SELECT * FROM cotacao";
		 
		 List<Cotacao> cotacoes = new ArrayList<Cotacao>();
		 
		 Connection conn = null;
		 PreparedStatement pstm = null;
		 
		 ResultSet rset = null;
		 
		 try {
			 conn = ConnectionFactory.createConnectionToMySQL();
			 pstm = conn.prepareStatement(sql);
			 rset = pstm.executeQuery();
			 
			 while(rset.next()) {
				 
				 Cotacao cotacao = new Cotacao();
				 
				 cotacao.setCotacao_id(rset.getInt("cotacao_id"));
				 cotacao.setDestino(rset.getString("destino"));
				 cotacao.setValor(rset.getString("valor"));
				 cotacao.setDataCotacao(rset.getDate("dataCotacao"));
				 
				 cotacoes.add(cotacao);
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
		 return cotacoes;
	 }
 }
