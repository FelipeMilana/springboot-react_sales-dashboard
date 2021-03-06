package com.cursos.salesdashboard.controllers;

import java.util.List;

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
import com.cursos.salesdashboard.entities.dto.SaleSuccessDTO;
import com.cursos.salesdashboard.entities.dto.SaleSumDTO;
import com.cursos.salesdashboard.services.SaleService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;
	
	@GetMapping
	@ApiOperation(value = "buscar todas as vendas")
	public ResponseEntity<Page<SaleDTO>> findAll(@PageableDefault(page = 0, 
																  size = 10, 
																  sort = "id", 
																  direction = Sort.Direction.ASC) Pageable page) {
		Page<SaleDTO> list = service.findAll(page);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/amount-by-seller")
	@ApiOperation(value = "Buscar o total de valores vendidos por cada cliente")
	public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller() {
		List<SaleSumDTO> list = service.amountGroupedBySeller();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/success-by-seller")
	@ApiOperation(value = "buscar a taxa de sucesso de cada cliente")
	public ResponseEntity<List<SaleSuccessDTO>> successGroupedBySeller() {
		List<SaleSuccessDTO> list = service.successGroupedBySeller();
		return ResponseEntity.ok().body(list);
	}
}
