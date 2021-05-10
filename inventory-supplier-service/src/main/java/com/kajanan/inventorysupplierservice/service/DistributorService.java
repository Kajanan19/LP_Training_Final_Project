package com.kajanan.inventorysupplierservice.service;

import java.util.List;

import com.kajanan.inventorysupplierservice.dto.DistributorDto;
import com.kajanan.inventorysupplierservice.entity.Distributor;

public interface DistributorService {

	Distributor addDistributor(DistributorDto distributor);

	List<Distributor> getDistributors();

	Distributor getDistributorById(Long id);

}
