package br.Estock.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.Estock.pojo.Produto;

public class DaoProduto {
	private String url = "jdbc:hsqldb:hsql://localhost/";
	private String user = "SA";
	private String password = "";
	private Connection connection;
	
	public DaoProduto() {
		super();
		try {
			connection = DriverManager.getConnection(url, user, password);
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void insert(Produto produto) {
		String sql = "INSERT INTO PRODUTOS VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1,produto.getId());
			pstmt.setString(2, produto.getDescricao());
			pstmt.setInt(3, produto.getQuantidade());
			pstmt.setDate(5, new java.sql.Date(produto.getDataValidade().getTime()));
			pstmt.setDate(4, new java.sql.Date(produto.getDataAtualizacao().getTime()));
			pstmt.setDouble(6, produto.getPreco());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public List<Produto> getLista(){
		List<Produto> lista = new ArrayList<>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM PRODUTOS");
			while (rs.next()) {
				lista.add(new Produto(rs.getInt(1),
									  rs.getString(2),
									  rs.getInt(3),
									  rs.getDate(4),
									  rs.getDate(5),
									  rs.getDouble(6)));
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return lista;
	}
	
	public void delete(int id) {
		String sql = "DELETE FROM PRODUTOS WHERE ID=?";
		try {
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		} catch (SQLException e) {
		e.printStackTrace();
		throw new RuntimeException(e);
		}
		}
	
	public void update(Produto produto) {
		String sql = "UPDATE PRODUTOS SET DESCRICAO=?, QUANTIDADE=?, DATAATUALIZACAO=?, DATAVALIDADE=?, PRECO=? WHERE ID=?";
		try {
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, produto.getDescricao());
		pstmt.setInt(2, produto.getQuantidade());
		pstmt.setDate(3, new java.sql.Date(produto.getDataAtualizacao().getTime()));
		pstmt.setDate(4, new java.sql.Date(produto.getDataValidade().getTime()));
		pstmt.setDouble(5, produto.getPreco());
		pstmt.setInt(6, produto.getId());
		pstmt.executeUpdate();
		} catch (SQLException e) {
		e.printStackTrace();
		throw new RuntimeException(e);
		}
		}
	
	public Produto buscarPorId(int id) {
		Produto produto = null;
		String sql = "SELECT * FROM PRODUTOS WHERE ID=?";
		try {
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
		produto = new Produto(rs.getInt(1),
		rs.getString(2),
		rs.getInt(3),
		rs.getDate(4),
		rs.getDate(5),
		rs.getDouble(6));
		}
		} catch (SQLException e) {
		e.printStackTrace();
		throw new RuntimeException(e);
		}
		return produto;
		}
	
}
