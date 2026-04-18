package com.pharmacy_product.api.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharmacy_product.api.product.entity.Produit;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
    
    List<Produit> findByNomContainingIgnoreCase(String nom);
    
    List<Produit> findByCategorie(String categorie);
    
    List<Produit> findByNecessiteOrdonnance(Boolean necessiteOrdonnance);
}
