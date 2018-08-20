package com.eour.kata;

public class Acheteur {

    final static String DEFAULT_NAME = "visiteur";

    private String nom;

    public Acheteur() {
        this(DEFAULT_NAME);
    }

    public Acheteur(String nom) {
        this.nom = nom;
    }

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

    public void changeQuantityProduit(Produit produit, int quantity) {
        this.panier.changeQuantityProduit(produit, quantity);
    }

    public String displayPanier() {
        return this.panier.toString();
    }

    public String getNom() {
        return this.nom;
    }
}
