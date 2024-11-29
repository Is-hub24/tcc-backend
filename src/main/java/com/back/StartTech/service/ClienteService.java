package com.back.StartTech.service;

import com.back.StartTech.entity.Cliente;
import com.back.StartTech.entity.Produtos;
import com.back.StartTech.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> getCliente(){
        return clienteRepository.findAll();
    }
    public Cliente createCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public void deleteClientesById(long id) {
        clienteRepository.deleteById(id);
    }

}
