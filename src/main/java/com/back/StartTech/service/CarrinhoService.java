package com.back.StartTech.service;

import com.back.StartTech.entity.Carrinho;
import com.back.StartTech.entity.CarrinhoProdutos;
import com.back.StartTech.entity.Produtos;
import com.back.StartTech.entity.dtos.CarrinhoDto;
import com.back.StartTech.repository.CarrinhoRepository;
import com.back.StartTech.repository.ClienteRepository;
import com.back.StartTech.repository.ProdutosRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoService {
    @Autowired
    CarrinhoRepository carrinhoRepository;

    @Autowired
    ProdutosRepository produtosRepository;

    @Autowired
    ClienteRepository clienteRepository;

    public Carrinho adicionarAoCarrinho(CarrinhoDto carrinhoDto) {
        Carrinho carrinho = carrinhoRepository.findByCliente_Id(carrinhoDto.id_cliente())
                .orElseGet(() -> {
                    Carrinho novoCarrinho = new Carrinho();
                    novoCarrinho.setCliente(clienteRepository.findById(carrinhoDto.id_cliente()).orElseThrow(() ->
                            new RuntimeException("Usuário não encontrado!")
                    ));
                    return novoCarrinho;
                });

        Produtos produto = produtosRepository.findById(carrinhoDto.id_produto())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        CarrinhoProdutos item = new CarrinhoProdutos();

        item.setId_produtos(produto);
        item.setQuantidade(carrinhoDto.quantidade());

        carrinho.getCarrinhoProdutos().add(item);
        return carrinhoRepository.save(carrinho);
    }

    public List<Carrinho> listarCarrinhos() {
        return carrinhoRepository.findAll();
    }

    public Optional<Carrinho> listarCarrinhosByClienteId(Long ClienteId) {
        return carrinhoRepository.findByCliente_Id(ClienteId);
    }
}