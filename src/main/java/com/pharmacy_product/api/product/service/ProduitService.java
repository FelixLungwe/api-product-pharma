package com.pharmacy_product.api.product.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pharmacy_product.api.product.dto.ProduitDTO;
import com.pharmacy_product.api.product.entity.Produit;
import com.pharmacy_product.api.product.mapper.ProduitMapper;
import com.pharmacy_product.api.product.repository.ProduitRepository;

import java.util.List;


@Service
@Transactional
public class ProduitService {
    
    private final ProduitRepository produitRepository;
    private final ProduitMapper produitMapper; // Injection du mapper manuel
    
    
    
    public ProduitService(ProduitRepository produitRepository, ProduitMapper produitMapper) {
		super();
		this.produitRepository = produitRepository;
		this.produitMapper = produitMapper;
	}

	// Create
    public ProduitDTO createProduit(ProduitDTO produitDTO) {
        Produit produit = produitMapper.toEntity(produitDTO);
        Produit savedProduit = produitRepository.save(produit);
        return produitMapper.toDto(savedProduit);
    }
    
    // Read - Get all
    @Transactional(readOnly = true)
    public List<ProduitDTO> getAllProduits() {
        return produitMapper.toDtoList(produitRepository.findAll());
    }
    
    // Read - Get by ID
    @Transactional(readOnly = true)
    public ProduitDTO getProduitById(Long id) {
        Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        return produitMapper.toDto(produit);
    }
    
    // Update
    public ProduitDTO updateProduit(Long id, ProduitDTO produitDTO) {
        
        Produit existingProduit = produitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        
        // Utilisation de la méthode de mise à jour partielle
        produitMapper.updateEntityFromDto(produitDTO, existingProduit);
        
        Produit updatedProduit = produitRepository.save(existingProduit);
        return produitMapper.toDto(updatedProduit);
    }
    
    // Delete
    public void deleteProduit(Long id) {
        
        if (!produitRepository.existsById(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }
        
        produitRepository.deleteById(id);
    }
    
    // Additional search methods
    @Transactional(readOnly = true)
    public List<ProduitDTO> searchByNom(String nom) {
        return produitMapper.toDtoList(produitRepository.findByNomContainingIgnoreCase(nom));
    }
    
    @Transactional(readOnly = true)
    public List<ProduitDTO> getByCategorie(String categorie) {
        return produitMapper.toDtoList(produitRepository.findByCategorie(categorie));
    }
    
    @Transactional(readOnly = true)
    public List<ProduitDTO> getByOrdonnanceRequired(Boolean necessiteOrdonnance) {
        return produitMapper.toDtoList(produitRepository.findByNecessiteOrdonnance(necessiteOrdonnance));
    }

    public ProduitDTO deleteProduitNew(Long id) {

        Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        produitRepository.delete(produit);

        return produitMapper.toDto(produit);
    }
}