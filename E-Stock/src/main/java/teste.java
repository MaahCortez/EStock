import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


public class teste {

	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/","SA","");
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM PRODUTOS");
		while( rs.next() ) {
			int id = rs.getInt("id");
			String descricao = rs.getString(2);
			int quantidade = rs.getInt("quantidade");
			Date dataAtualizacao = rs.getDate(4);
			Date dataValidade = rs.getDate(5);
			double preco = rs.getDouble("preco");
			System.out.println(id + " " + descricao + " " + quantidade + " " + dataAtualizacao + " " + dataValidade + " " + preco);
		}
	}

}