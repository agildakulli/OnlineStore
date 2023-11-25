package com.example.demo.controller;

import com.example.demo.dto.ClientDto;
import com.example.demo.service.ClientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @AllArgsConstructor
    @RestController
    @RequestMapping("/api/clients")
    public class ClientController {

        private ClientService clientService;


        //    @PreAuthorize("hasRole('ADMIN')")
        @PostMapping("/save")
        public ClientDto save(@Valid @RequestBody ClientDto clientDto) {
            return clientService.save(clientDto);
        }

        //    @PreAuthorize("hasRole('GUEST')")
        @GetMapping
        public List<ClientDto> findAll() {
            return clientService.findAll();
        }

        //    @PreAuthorize("hasRole('client')")
        @GetMapping("/view/{clientId}")
        public ClientDto findById(@PathVariable(name = "clientId") Long clientId) {
            return clientService.findById(clientId);
        }

        @PutMapping("/{clientId}")
        public ClientDto update(@Valid @RequestBody ClientDto clientDto,
                                @PathVariable(name = "clientId") Long clientId) {
            return clientService.update(clientDto,clientId);
        }


        @DeleteMapping("/{clientId}")
        public String delete(@PathVariable(name = "clientId") Long clientId) {
            clientService.delete(clientId);
            return "Client successfully deleted!";
        }



    }
