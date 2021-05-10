package com.kajanan.inventoryauthservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kajanan.inventoryauthservice.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
