package com.pharmacy_product.api.product.mapper;

import org.springframework.stereotype.Component;

import com.pharmacy_product.api.product.dto.ProduitDTO;
import com.pharmacy_product.api.product.entity.Produit;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProduitMapper {
    
    // Convert Entity to DTO
    public ProduitDTO toDto(Produit produit) {
        if (produit == null) {
            return null;
        }
        
        ProduitDTO dto = new ProduitDTO();
        dto.setId(produit.getId());
        dto.setNom(produit.getNom());
        dto.setDci(produit.getDci());
        dto.setCategorie(produit.getCategorie());
        dto.setNecessiteOrdonnance(produit.getNecessiteOrdonnance());
        dto.setForme(produit.getForme());
        
        return dto;
    }
    
    // Convert DTO to Entity
    public Produit toEntity(ProduitDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Produit produit = new Produit();
        produit.setId(dto.getId());
        produit.setNom(dto.getNom());
        produit.setDci(dto.getDci());
        produit.setCategorie(dto.getCategorie());
        produit.setNecessiteOrdonnance(dto.getNecessiteOrdonnance());
        produit.setForme(dto.getForme());
        
        return produit;
    }
    
    // Convert List<Entity> to List<DTO>
    public List<ProduitDTO> toDtoList(List<Produit> produits) {
        if (produits == null) {
            return null;
        }
        
        return produits.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
    
    // Convert List<DTO> to List<Entity>
    public List<Produit> toEntityList(List<ProduitDTO> dtos) {
        if (dtos == null) {
            return null;
        }
        
        return dtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
    
    // Update existing entity with DTO values (for partial updates)
    public void updateEntityFromDto(ProduitDTO dto, Produit produit) {
        if (dto == null || produit == null) {
            return;
        }
        
        if (dto.getNom() != null) {
            produit.setNom(dto.getNom());
        }
        if (dto.getDci() != null) {
            produit.setDci(dto.getDci());
        }
        if (dto.getCategorie() != null) {
            produit.setCategorie(dto.getCategorie());
        }
        if (dto.getNecessiteOrdonnance() != null) {
            produit.setNecessiteOrdonnance(dto.getNecessiteOrdonnance());
        }
        if (dto.getForme() != null) {
            produit.setForme(dto.getForme());
        }
    }
}
