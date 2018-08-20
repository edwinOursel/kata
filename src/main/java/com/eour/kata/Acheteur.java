package com.eour.kata;

public class Acheteur {

    Panier panier = new Panier();

    public void addProduit(Produit produit) {
        this.panier.addProduit(produit);
    }

    public void deleteProduit(Produit produit) {
        this.panier.deleteProduit(produit);
    }

    public double getPrixTotal() {
        return this.panier.getPrixTotal();
    }

    public String displayPanier() {
        return this.panier.toString();
    }
}
