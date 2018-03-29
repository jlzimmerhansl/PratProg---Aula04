package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ConnectionFactory;
import dao.PaisDAO;
import model.Pais;

public class Teste {
	
	public static void main(String[] args) throws SQLException {
	Connection conn = null;
		
		
		try {
			
			conn = ConnectionFactory.obtemConexao();		
			
			PaisDAO paisdao = new PaisDAO();
			
			Pais pais = new Pais();
			
			ArrayList<Pais> vetor = new ArrayList<Pais>();
			
			pais = paisdao.maiorPopulacao();
			System.out.println(pais);
	       
			pais = paisdao.menorPopulacao();
			System.out.println(pais);
			
			vetor = paisdao.vetor();
			
			for(Pais v:vetor) {
				System.out.println(v);
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
			if(conn != null) {
				try {
					conn.rollback();
				}
				catch (SQLException e1) {
					System.out.println(e1.getStackTrace());
				}
			}
		}
		finally {
			
			if(conn != null){
				try {
					conn.close();
				}
				catch(SQLException e1){
					System.out.println(e1.getStackTrace());
				}	
			}
		}
	}
	

}
