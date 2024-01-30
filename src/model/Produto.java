package model;

import java.util.Date;
import java.util.Objects;
import model.Produto;

public class Produto {
    private int codigo;
    private String descricao;
    private String categoria;
    private double precoCusto;
    private double precoVenda;
    private int quantidade;
    private Date dataEntrada;

    public Produto() {

    }

    @Override
    public String toString() {
        return "NomeProduto{" +
                "codigo=" + codigo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto that = (Produto) o;
        return codigo == that.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    public Produto(int codigo) {
        this.codigo = codigo;
    }

    public Produto(int codigo, String descricao, String categoria, double precoCusto, double precoVenda, int quantidade, Date dataEntrada) {
    	this.codigo = codigo;
    	this.descricao = descricao;
        this.categoria = categoria;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.quantidade = quantidade;
        this.dataEntrada = dataEntrada;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    
    public java.sql.Date getDataEntrada() {
        return (java.sql.Date) dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = (java.sql.Date) dataEntrada;
    }
}