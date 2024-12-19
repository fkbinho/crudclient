package com.fkbinhoo.CrudClients.controllers;

import com.fkbinhoo.CrudClients.dto.ClientDTO;
import com.fkbinhoo.CrudClients.services.ClientService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public ResponseEntity<Page<ClientDTO>> findAll(Pageable pageable) {
        Page<ClientDTO> clientDTO = clientService.findAll(pageable);
        return ResponseEntity.ok(clientDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> clientById(@PathVariable Long id) {
        ClientDTO clientDTO = clientService.clientById(id);
        return ResponseEntity.ok(clientDTO);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> insert (@RequestBody ClientDTO clientDTO) {
        clientDTO= clientService.insert(clientDTO);
        return ResponseEntity.ok(clientDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable Long id, @RequestBody ClientDTO clientDTO) {
        clientDTO = clientService.update(id, clientDTO);
        return ResponseEntity.ok(clientDTO);
    }
}
