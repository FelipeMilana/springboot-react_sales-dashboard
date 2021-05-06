package com.cursos.salesdashboard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cursos.salesdashboard.entities.Sale;
import com.cursos.salesdashboard.entities.dto.SaleSuccessDTO;
import com.cursos.salesdashboard.entities.dto.SaleSumDTO;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{

	@Query("SELECT new com.cursos.salesdashboard.entities.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
		+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.cursos.salesdashboard.entities.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			+ " FROM Sale AS obj GROUP BY obj.seller")
		List<SaleSuccessDTO> successGroupedBySeller();
}
