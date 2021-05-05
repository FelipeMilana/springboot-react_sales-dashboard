package com.cursos.salesdashboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursos.salesdashboard.entities.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long>{

}
