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

    @OneToOne
    @JoinColumn(name = "image_id", nullable = true)
    private Image image;

    public long getId_produtos() {
        return id_produtos;
    }

    public void setId_produtos(long id_produtos) {
        this.id_produtos = id_produtos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(String id_categoria) {
        this.id_categoria = id_categoria;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    
}
