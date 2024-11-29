package com.back.StartTech.service;

import com.back.StartTech.entity.Carrinho;
import com.back.StartTech.entity.CarrinhoProdutos;
import com.back.StartTech.repository.CarrinhoPordutosRepository;
import com.back.StartTech.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrinhoProdutosService {
    @Autowired
    CarrinhoPordutosRepository carrinhoprodutosRepository;

    public List<CarrinhoProdutos> getCarrinhoProdutos(){
        return carrinhoprodutosRepository.findAll();
    }

    public CarrinhoProdutos createCarrinhoProdutos(CarrinhoProdutos carrinhoProdutos){
        return carrinhoprodutosRepository.save(carrinhoProdutos);
    }
}
