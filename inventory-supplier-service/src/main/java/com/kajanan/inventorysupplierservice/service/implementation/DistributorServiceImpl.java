package com.kajanan.inventorysupplierservice.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kajanan.inventorysupplierservice.dto.DistributorDto;
import com.kajanan.inventorysupplierservice.entity.Distributor;
import com.kajanan.inventorysupplierservice.exception.NotFoundException;
import com.kajanan.inventorysupplierservice.helper.GenericMapper;
import com.kajanan.inventorysupplierservice.repository.DistributorRepository;
import com.kajanan.inventorysupplierservice.service.DistributorService;

@Service
public class DistributorServiceImpl implements DistributorService {

  @Autowired
  private DistributorRepository repository;

  @Override
  public Distributor addDistributor(DistributorDto distributor) {
    return repository.save(GenericMapper.distributorDtoToEntity(distributor));
  }

  @Override
  public List<Distributor> getDistributors() {
    return repository.findAll();
  }

  @Override
  public Distributor getDistributorById(Long id) {
    return repository.findById(id).orElseThrow(() -> new NotFoundException("distributorId", "Distributor Not found"));
  }

}
