package com.cursos.salesdashboard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cursos.salesdashboard.entities.dto.SaleDTO;
import com.cursos.salesdashboard.repositories.SaleRepository;
import com.cursos.salesdashboard.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable page) {
		sellerRepository.findAll();
		return repository.findAll(page).map(x -> new SaleDTO(x));
	}
}
