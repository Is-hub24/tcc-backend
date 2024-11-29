package com.back.StartTech.entity;

import jakarta.persistence.*;

@Table(name = "carrinho_produtos")
@Entity(name = "carrinho_produtos")
public class CarrinhoProdutos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long quantidade;

    @ManyToOne
    @JoinColumn(name = "id_produtos")
    private Produtos id_produtos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(long quantidade) {
        this.quantidade = quantidade;
    }

    public Produtos getId_produtos() {
        return id_produtos;
    }

    public void setId_produtos(Produtos id_produtos) {
        this.id_produtos = id_produtos;
    }
}
