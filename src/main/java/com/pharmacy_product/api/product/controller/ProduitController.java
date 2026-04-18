package com.pharmacy_product.api.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pharmacy_product.api.product.dto.ProduitDTO;
import com.pharmacy_product.api.product.service.ProduitService;

import java.util.List;

@RestController
@RequestMapping("/produits")
@CrossOrigin(origins = "*")
public class ProduitController {
    
    private final ProduitService produitService;
    
    
    
    public ProduitController(ProduitService produitService) {
		super();
		this.produitService = produitService;
	}

	// Create
    @PostMapping
    public ResponseEntity<ProduitDTO> createProduit(@RequestBody ProduitDTO produitDTO) {
        ProduitDTO createdProduit = produitService.createProduit(produitDTO);
        return new ResponseEntity<>(createdProduit, HttpStatus.CREATED);
    }
    
    // Read - Get all
    @GetMapping
    public ResponseEntity<List<ProduitDTO>> getAllProduits() {
        List<ProduitDTO> produits = produitService.getAllProduits();
        return ResponseEntity.ok(produits);
    }
    
    // Read - Get by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProduitDTO> getProduitById(@PathVariable Long id) {
        ProduitDTO produit = produitService.getProduitById(id);
        return ResponseEntity.ok(produit);
    }
    
    // Update
    @PutMapping("/{id}")
    public ResponseEntity<ProduitDTO> updateProduit(
            @PathVariable Long id, 
            @RequestBody ProduitDTO produitDTO) {
        ProduitDTO updatedProduit = produitService.updateProduit(id, produitDTO);
        return ResponseEntity.ok(updatedProduit);
    }
    
    // Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduit(@PathVariable Long id) {
        produitService.deleteProduit(id);
        return ResponseEntity.noContent().build();
    }
    
 // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<ProduitDTO> deleteProduitNew(@PathVariable Long id) {
    	ProduitDTO deleted = produitService.deleteProduitNew(id);
    	return ResponseEntity.ok(deleted);
//        return ResponseEntity.noContent().build();
    }
    
    // Search endpoints
    @GetMapping("/search")
    public ResponseEntity<List<ProduitDTO>> searchByNom(@RequestParam String nom) {
        List<ProduitDTO> produits = produitService.searchByNom(nom);
        return ResponseEntity.ok(produits);
    }
    
    @GetMapping("/categorie/{categorie}")
    public ResponseEntity<List<ProduitDTO>> getByCategorie(@PathVariable String categorie) {
        List<ProduitDTO> produits = produitService.getByCategorie(categorie);
        return ResponseEntity.ok(produits);
    }
    
    @GetMapping("/ordonnance")
    public ResponseEntity<List<ProduitDTO>> getByOrdonnanceRequired(
            @RequestParam Boolean necessiteOrdonnance) {
        List<ProduitDTO> produits = produitService.getByOrdonnanceRequired(necessiteOrdonnance);
        return ResponseEntity.ok(produits);
    }
}