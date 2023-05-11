package br.Estock.pojo;

import java.util.Date;

public class Produto {
	private int id;
	private String descricao;
	private int quantidade;
	private Date dataAtualizacao;
	private Date dataValidade;
	private double preco;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "produto [id=" + id + ", descricao=" + descricao + ", quantidade=" + quantidade + ", dataAtualizacao="
				+ dataAtualizacao + ", dataValidade=" + dataValidade + ", preco=" + preco + "]";
	}
	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Produto(int id, String descricao, int quantidade, Date dataAtualizacao, Date dataValidade, double preco) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.dataAtualizacao = dataAtualizacao;
		this.dataValidade = dataValidade;
		this.preco = preco;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/**
	 * @return the quantidade
	 */
	public int getQuantidade() {
		return quantidade;
	}
	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	/**
	 * @return the dataAtualizacao
	 */
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	/**
	 * @param dataAtualizacao the dataAtualizacao to set
	 */
	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	/**
	 * @return the dataValidade
	 */
	public Date getDataValidade() {
		return dataValidade;
	}
	/**
	 * @param dataValidade the dataValidade to set
	 */
	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}
	/**
	 * @return the preco
	 */
	public double getPreco() {
		return preco;
	}
	/**
	 * @param preco the preco to set
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
}
