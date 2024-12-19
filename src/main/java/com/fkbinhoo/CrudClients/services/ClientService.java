package com.fkbinhoo.CrudClients.services;

import com.fkbinhoo.CrudClients.dto.ClientDTO;
import com.fkbinhoo.CrudClients.entities.Client;
import com.fkbinhoo.CrudClients.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> result = clientRepository.findAll(pageable);

        return result.map(x -> new ClientDTO(x));
    }

    @Transactional(readOnly = true)
    public ClientDTO clientById(Long id) {
        Client client = clientRepository.findById(id).get();
        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO insert(ClientDTO clientDTO) {
        Client client = new Client();

        client.setName(clientDTO.getName());
        client.setCpf(clientDTO.getCpf());
        client.setIncome(clientDTO.getIncome());
        client.setBirthDate(clientDTO.getBirthDate());
        client.setChildren(client.getChildren());

        client = clientRepository.save(client);

        return new ClientDTO(client);
    }
}
