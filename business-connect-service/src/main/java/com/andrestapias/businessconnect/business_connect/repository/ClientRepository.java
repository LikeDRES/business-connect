package com.andrestapias.businessconnect.business_connect.repository;

import com.andrestapias.businessconnect.business_connect.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    boolean existsByEmail(String email);
}
