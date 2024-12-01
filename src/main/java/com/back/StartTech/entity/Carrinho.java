package com.back.StartTech.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "carrinho")
@Entity(name = "carrinho")
public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carrinho;

    private Integer status;

    @OneToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_carrinho")
    private List<CarrinhoProdutos> carrinhoProdutos = new ArrayList<>();

    public Long getId_carrinho() {
        return id_carrinho;
    }

    public void setId_carrinho(Long id_carrinho) {
        this.id_carrinho = id_carrinho;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<CarrinhoProdutos> getCarrinhoProdutos() {
        return carrinhoProdutos;
    }

    public void setCarrinhoProdutos(List<CarrinhoProdutos> carrinhoProdutos) {
        this.carrinhoProdutos = carrinhoProdutos;
    }
}


