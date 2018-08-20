package com.eour.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AcheteurTest {

    private Acheteur acheteur;

    @BeforeEach
    public void beforeEach() {
        acheteur = new Acheteur();
    }

    @Test
    public void displayPanierShoulDisplayAProductPutWithAddProduit() {
        //GIVEN
        String nomProduit = "television";
        double prixProduit = 1199.99;
        Produit produit = new Produit(nomProduit, prixProduit);

        //WHEN
        acheteur.addProduit(produit);
        String displayPanier = acheteur.displayPanier();

        //THEN
        assertTrue(displayPanier.contains(nomProduit));
    }

    @Test
    public void displayPanierShouldNotDisplayAproductAfterADelete() {
        //GIVEN
        String nomProduit = "television";
        double prixProduit = 1199.99;
        Produit produit = new Produit(nomProduit, prixProduit);

        //WHEN
        acheteur.addProduit(produit);
        acheteur.deleteProduit(produit);
        String displayPanier = acheteur.displayPanier();

        //THEN
        assertFalse(displayPanier.contains(nomProduit));
    }

    @Test
    public void getPrixTotalShouldGiveCorrectPriceForAGivenProduct() {
        //GIVEN
        String nomProduit = "television";
        double prixProduit = 1199.99;
        Produit produit = new Produit(nomProduit, prixProduit);

        //WHEN
        acheteur.addProduit(produit);
        double prix = acheteur.getPrixTotal();

        //THEN
        assertEquals(prix, prixProduit);
    }

    @Test
    public void getPrixTotalShouldReturnSumOfPricesForManyProducts() {
        //GIVEN
        String nomProduit1 = "television";
        double prixProduit1 = 1199.99;
        Produit produit1 = new Produit(nomProduit1, prixProduit1);

        String nomProduit2 = "ordinateur";
        double prixProduit2 = 522.25;
        Produit produit2 = new Produit(nomProduit2, prixProduit2);

        String nomProduit3 = "livre";
        double prixProduit3 = 15.00;
        Produit produit3 = new Produit(nomProduit3, prixProduit3);

        //WHEN
        acheteur.addProduit(produit1);
        acheteur.addProduit(produit2);
        acheteur.addProduit(produit3);
        double prix = acheteur.getPrixTotal();

        //THEN
        assertEquals(prix, prixProduit1 + prixProduit2 + prixProduit3);
    }

    @Test
    public void getPrixTotalShouldGiveCorrectPriceIfQtyIsMoreThanOne() {
        //GIVEN
        String nomProduit = "television";
        double prixProduit = 1199.99;
        Produit produit = new Produit(nomProduit, prixProduit);

        //WHEN
        acheteur.addProduit(produit);
        acheteur.addProduit(produit);
        acheteur.addProduit(produit);
        double prix = acheteur.getPrixTotal();

        //THEN
        assertEquals(prix, prixProduit * 3);
    }

    @Test
    public void getPrixTotalShouldGiveCorrectPriceAfterChangingQty() {
        //GIVEN
        String nomProduit = "television";
        double prixProduit = 1199.99;
        Produit produit = new Produit(nomProduit, prixProduit);

        //WHEN
        acheteur.addProduit(produit);
        acheteur.addProduit(produit);
        acheteur.addProduit(produit);

        acheteur.changeQuantityProduit(produit, 2);
        double prix = acheteur.getPrixTotal();

        //THEN
        assertEquals(prix, prixProduit * 2);
    }

    @Test
    public void acheteurHasNom() {
        assertNotNull(acheteur.getNom());
    }

}