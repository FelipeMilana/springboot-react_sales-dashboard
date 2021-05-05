package com.cursos.salesdashboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursos.salesdashboard.entities.dto.SaleDTO;
import com.cursos.salesdashboard.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(@PageableDefault(page = 0, 
																  size = 10, 
																  sort = "id", 
																  direction = Sort.Direction.ASC) Pageable page) {
		Page<SaleDTO> list = service.findAll(page);
		return ResponseEntity.ok().body(list);
	}
}
