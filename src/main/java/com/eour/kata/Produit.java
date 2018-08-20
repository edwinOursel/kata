package com.eour.kata;

import java.util.Objects;

public class Produit {
    private String nom;
    private double prix;

    public Produit(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produit produit = (Produit) o;
        return Double.compare(produit.prix, prix) == 0 &&
                Objects.equals(nom, produit.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prix);
    }
}
