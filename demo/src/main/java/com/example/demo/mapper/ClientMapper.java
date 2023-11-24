package com.example.demo.mapper;

import com.example.demo.dto.ClientDto;
import com.example.demo.entity.Client;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ClientMapper {
    private CategoryMapper categoryMapper;



    public Client mapToEntity(ClientDto clientDto) {
       Client client=new Client();
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setUsername(clientDto.getUsername());
        client.setEmail(clientDto.getEmail());
        client.setPassword(clientDto.getPassword());
        client.setAge(clientDto.getAge());
        client.setId(clientDto.getId());
        return client;
    }


    public ClientDto mapToDto(Client client) {
        ClientDto clientDto=new ClientDto();

        clientDto.setId(client.getId());
        clientDto.setFirstName(client.getFirstName());
        clientDto.setLastName(client.getLastName());
        clientDto.setUsername(client.getUsername());
        clientDto.setEmail(client.getEmail());
        clientDto.setPassword(client.getPassword());
        clientDto.setAge(client.getAge());
        clientDto.setCategoryId(client.getCategory().getId());
        clientDto.setCategoryName(client.getCategory().getName());

        return clientDto;
    }
}
