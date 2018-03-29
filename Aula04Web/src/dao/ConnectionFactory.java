package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {

		static {
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				
			}catch (ClassNotFoundException e) {
				
				throw new RuntimeException(e);
				
			}
		}
		
		//obtem conexao
		public static Connection obtemConexao() throws SQLException{
			
			return DriverManager.getConnection("jdbc:mysql://localhost/Banco-aula02?user=root&password=Lzimmerhansl0626");
		}
}
