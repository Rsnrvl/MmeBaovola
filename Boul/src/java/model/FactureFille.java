/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import annoted.ColumnField;
import annoted.TableAnnotation;
import mapping.BddObject;

/**
 *
 * @author rango
 */
@TableAnnotation(nameTable="facture_fille", sequence="ff_seq", prefix="FF_")
public class FactureFille {
    @ColumnField(column="idFactureFille", primary_key=true, is_increment=true)
    private String id;
    
    @ColumnField(column="quantite")
    private Double quantite;
    
    @ColumnField(column="puPatisserie")
    private Double puPatisserie;
    
    @ColumnField(column="montantTotal")
    private Double montantTotal;
    
    @ColumnField(column="idFacture")
    private String idFacture;
    
    @ColumnField(column="idPatisserie")
    private String idPatisserie;
    
    
    private Patisserie MyPatisserie;
    
    private Facture MyFacture; 

    
    public FactureFille() {
    }
    
    public FactureFille(String quantite,  String idFacture, String idPatisserie) throws Exception{
       try { 
            this.setQuantite(quantite);
            this.setIdFacture(idFacture);
            this.setIdPatisserie(idPatisserie);
       } catch (Exception e) {
       throw new Exception("erreur " + e.getMessage());
       }
    }

    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }
    
    public void setQuantite(String quantiteHtml) throws Exception{
        try {
        Double valeurQt = Double.valueOf(quantiteHtml);
        this.setQuantite(valeurQt);
        } catch (Exception e) {
            throw new Exception("Erreur setQuantite" + e.getMessage());
        }
    }

    public Double getPuPatisserie() {
        return puPatisserie;
    }

    public void setPuPatisserie(Double puPatisserie) {
        this.puPatisserie = puPatisserie;
    }
    
    public void setPuPatisserie(String puPatisserieHtml) throws Exception {
        try{
            Double valeur = Double.valueOf(puPatisserieHtml);
            this.setPuPatisserie(valeur);
        } catch (Exception e) {
             throw new Exception("Erreur set prix" + e.getMessage());
        }
    }

    public Double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(Double montantTotal) {
        this.montantTotal = montantTotal;
    }
    
     public void setMontantTotal(String montantTotalHtml) throws Exception {
        try{
            Double valeurMt = Double.valueOf(montantTotalHtml);
            this.setMontantTotal(valeurMt);
        } catch (Exception e) {
             throw new Exception("Erreur set prix" + e.getMessage());
        }
    }

    public String getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(String idFacture) {
        this.idFacture = idFacture;
    }

    public String getIdPatisserie() {
        return idPatisserie;
    }

    public void setIdPatisserie(String idPatisserie) {
        this.idPatisserie = idPatisserie;
    }

    public Patisserie getMyPatisserie() throws Exception {
        if(this.getIdPatisserie()==null) return null;
        try{
            Patisserie p = new Patisserie();
            p.setId(this.getIdPatisserie());
            p = BddObject.findById(p, null);
            return p;
        } catch (Exception e){
            throw new Exception("erreur sur la fonction getMyPatisserie. Error :" + e.getMessage());
        }
    }

    public void setMyPatisserie(Patisserie MyPatisserie) {
        this.MyPatisserie = MyPatisserie;
    }
    
    
    public Facture getMyFacture() throws Exception {
        if(this.getIdFacture()== null) return null;
        try {
            Facture f = new Facture();
            f.setId(this.getIdFacture());
            f = BddObject.findById(f, null);
            return f;
        } catch (Exception e) {
        throw new Exception("erreur sur la fonction getMyFacture. Erreur : " + e.getMessage());
        }
        
    }

    public void setMyFacture(Facture MyFacture) {
        this.MyFacture = MyFacture;
    }
    
    
    
    
}
