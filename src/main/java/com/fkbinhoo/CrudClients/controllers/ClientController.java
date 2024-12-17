package com.fkbinhoo.CrudClients.controllers;

import com.fkbinhoo.CrudClients.entities.Client;
import com.fkbinhoo.CrudClients.repositories.ClientRepository;
import com.fkbinhoo.CrudClients.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    ClientRepository clientRepository;

    @GetMapping
    public Page<Client> findAll(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }
}
