package com.cursos.salesdashboard.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursos.salesdashboard.entities.dto.SellerDTO;
import com.cursos.salesdashboard.repositories.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository repository;
	
	public List<SellerDTO> findAll() {
		return repository.findAll().stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}
}
