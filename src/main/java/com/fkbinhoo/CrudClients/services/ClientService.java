package com.fkbinhoo.CrudClients.services;

import com.fkbinhoo.CrudClients.dto.ClientDTO;
import com.fkbinhoo.CrudClients.entities.Client;
import com.fkbinhoo.CrudClients.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> result = clientRepository.findAll(pageable);

        return result.map(x -> new ClientDTO());
    }
}
