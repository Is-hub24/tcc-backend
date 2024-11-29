package com.back.StartTech.entity;

import jakarta.persistence.*;

@Table(name = "produtos")
@Entity(name = "produtos")
public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_produtos;
    private String nome;
    private String descricao ;
    private int quantidade;
    private double preco;
    private String id_categoria;

    public String getnome() {
        return nome;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    public long getId_produtos() {
        return id_produtos;
    }

    public void setId_produtos(long id) {
        this.id_produtos = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidadeProdutos) {
        this.quantidade = quantidadeProdutos;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double precoProduto) {
        this.preco = precoProduto;
    }

    public String getCategoria() {
        return id_categoria;
    }

    public void setCategoria(String categoria) {
        this.id_categoria = categoria;
    }
}
