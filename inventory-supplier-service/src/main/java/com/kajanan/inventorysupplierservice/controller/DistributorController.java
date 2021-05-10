package com.kajanan.inventorysupplierservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kajanan.inventorysupplierservice.dto.DistributorDto;
import com.kajanan.inventorysupplierservice.entity.Distributor;
import com.kajanan.inventorysupplierservice.service.DistributorService;

@RestController
@RequestMapping("/distributor")
@CrossOrigin(origins = "*")
public class DistributorController {

	@Autowired
	private DistributorService service;

	@PostMapping
	public ResponseEntity<Distributor> addDistributor(@Valid @RequestBody DistributorDto distributor) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addDistributor(distributor));
	}

	@GetMapping
	public ResponseEntity<List<Distributor>> fetchAllDistributors() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getDistributors());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Distributor> fetchDistributorById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.getDistributorById(id));
	}

	@PutMapping
	public ResponseEntity<Distributor> updateDistributor(@Valid @RequestBody DistributorDto distributor) {
		return ResponseEntity.status(HttpStatus.OK).body(service.addDistributor(distributor));
	}

}
