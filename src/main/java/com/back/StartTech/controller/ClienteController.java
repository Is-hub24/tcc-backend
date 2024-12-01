package com.back.StartTech.controller;

import com.back.StartTech.entity.Cliente;
import com.back.StartTech.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping
    public List<Cliente> getAll(){
        return clienteService.getCliente();
    }

    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente){
        return clienteService.createCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteCliete(@PathVariable long id) {
        clienteService.deleteClientesById(id);

    }
}