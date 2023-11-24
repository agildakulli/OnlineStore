package com.example.demo.service;

import com.example.demo.dto.ClientDto;
import com.example.demo.entity.Category;
import com.example.demo.entity.Client;
import com.example.demo.mapper.ClientMapper;
import com.example.demo.respository.CategoryRespository;
import com.example.demo.respository.ClientRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service @AllArgsConstructor
public class ClientService {

    private ClientRespository clientRespository;
    private ClientMapper clientMapper;
    private CategoryRespository categoryRepository;

    public ClientDto save(ClientDto clientDto) {
       Client client  = clientMapper.mapToEntity(clientDto);
        Optional<Category> foundCategory = categoryRepository.findById(clientDto.getCategoryId());
        if (foundCategory.isPresent()) {
            client.setCategory(foundCategory.get());
        }
        Client savedClient = clientRespository.save(client);
        return clientMapper.mapToDto(savedClient) ;
    }

    public List<ClientDto> findAll() {
        List<Client> clientList = clientRespository.findAll();
        List<ClientDto> clientDtoList = new ArrayList<>();
        for (Client client : clientList) {
            clientDtoList.add(clientMapper.mapToDto(client));
        }
        return clientDtoList ;

    }

    public ClientDto findById(Long clientId) {
//        Optional<Student> existingStudent = studentRepository .findById(studentId);
//        if (existingStudent.isPresent()){
//            return studentMapper.mapToDto(existingStudent.get());
//        }
//        else throw  new RuntimeException("Student with id: "+studentId+" was not found in the database.");

        Client existingClient = clientRespository.findById(clientId).orElseThrow(()->
                new RuntimeException("Student with id: "+clientId+" was not found in the database."));
        return clientMapper.mapToDto(existingClient);
    }

    public ClientDto update(ClientDto clientDto, Long clientId) {
//        Student existingStudent = studentRepository.findById(studentId).orElseThrow(() ->
//                new RuntimeException("Student not found with ID: " + studentId));
//        existingStudent.setId(studentId);
//        existingStudent.setFirstName(studentDto.getFirstName());
//        existingStudent.setLastName(studentDto.getLastName());
//        existingStudent.setEmail(studentDto.getEmail());
//        existingStudent.setPassword(studentDto.getPassword());
//        existingStudent.setAge(studentDto.getAge());
//        Student savedStudent = studentRepository.save(existingStudent);
//        return studentMapper.mapToDto(savedStudent);

        Optional<Client> existingClient = clientRespository.findById(clientId);
        Category category = categoryRepository.findById(clientDto.getCategoryId()).orElseThrow(
                ()-> new RuntimeException("Category with id: "+clientDto.getCategoryId()+" not found"));
        if (existingClient.isPresent()) {

            Client  clientToUpdate = existingClient.get();
            clientToUpdate.setId(clientId);
            clientToUpdate.setFirstName(clientDto.getFirstName());
            clientToUpdate.setLastName(clientDto.getLastName());
            clientToUpdate.setAge(clientDto.getAge());
            clientToUpdate.setEmail(clientDto.getEmail());
            clientToUpdate.setUsername(clientDto.getUsername());
            clientToUpdate.setPassword(clientDto.getPassword());
            clientToUpdate.setCategory(category);

            Client savedClient = clientRespository.save(clientToUpdate);
            return clientMapper.mapToDto(savedClient);
        } else {throw new RuntimeException("Student not found with ID: " + clientId);}




    }

    public void delete(Long clientId) {
        Optional<Client> existingClient= clientRespository.findById(clientId);

        if (existingClient.isPresent()){
            clientRespository.delete(existingClient.get());
        }else {throw new RuntimeException("Student not found with ID: " + clientId);}
    }



}
