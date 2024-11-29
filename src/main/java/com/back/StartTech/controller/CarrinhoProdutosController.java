package com.back.StartTech.controller;

import com.back.StartTech.entity.CarrinhoProdutos;
import com.back.StartTech.service.CarrinhoProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrinhoprodutos")
public class CarrinhoProdutosController {
    @Autowired
    CarrinhoProdutosService carrinhoProdutosService;

    @GetMapping
    public List<CarrinhoProdutos> getAll(){
       return carrinhoProdutosService.getCarrinhoProdutos();
    }

    @PostMapping
    public CarrinhoProdutos createCarrinhoProdutos(@RequestBody CarrinhoProdutos carrinhoprodutos){
        return carrinhoProdutosService.createCarrinhoProdutos(carrinhoprodutos);
    }

}
