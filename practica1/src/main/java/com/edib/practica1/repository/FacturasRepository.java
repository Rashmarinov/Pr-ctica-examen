package com.edib.practica1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edib.practica1.model.TablaFacturas;

public interface FacturasRepository extends JpaRepository<TablaFacturas, Long>{

}
