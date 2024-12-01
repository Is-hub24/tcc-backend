package com.back.StartTech.controller;

import com.back.StartTech.entity.Carrinho;
import com.back.StartTech.entity.dtos.CarrinhoDto;
import com.back.StartTech.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {
    @Autowired
    CarrinhoService carrinhoService;

   @GetMapping
   public List<Carrinho> getAll(){
       return carrinhoService.listarCarrinhos();
   }

    @PostMapping
    public Carrinho createCarrinho(@RequestBody CarrinhoDto carrinho) {
        return carrinhoService.adicionarAoCarrinho(carrinho);
    }

    @GetMapping("/{id}")
    public Optional<Carrinho> listarCarrinhoByClienteId(@PathVariable Long clienteId) {
        return carrinhoService.listarCarrinhosByClienteId(clienteId);
    }
}