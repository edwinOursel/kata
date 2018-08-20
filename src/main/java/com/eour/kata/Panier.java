package com.eour.kata;

import java.util.HashMap;
import java.util.Map;

public class Panier {

    //produit, quantité
    Map<Produit, Integer> produits = new HashMap<>();

    public void addProduit(Produit produit) {
        if (this.produits.containsKey(produit)) {
            this.produits.put(produit, this.produits.get(produit) + 1);
        } else {
            this.produits.put(produit, 1);
        }
    }

    public void changeQuantityProduit(Produit produit, Integer qte) {
        this.produits.put(produit, qte);
    }

    public void deleteProduit(Produit produit) {
        this.produits.remove(produit);
    }


    public double getPrixTotal() {
        return this.produits.entrySet().stream()
                .map(entry -> entry.getKey().getPrix() * entry.getValue())
                .reduce((prix1, prix2) -> prix1 + prix2)
                .orElse(0.0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Produit, Integer> entry : this.produits.entrySet()) {
            sb.append(entry.getValue());
            sb.append(" ");
            sb.append(entry.getKey().getNom());
            sb.append(" : ");
            sb.append(entry.getValue() * entry.getKey().getPrix());
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }
}
