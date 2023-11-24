package com.example.demo.respository;

import com.example.demo.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRespository extends JpaRepository<Client,Long> {
}
