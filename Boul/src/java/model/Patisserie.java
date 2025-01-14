/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import annoted.ColumnField;
import annoted.TableAnnotation;
import database.ConnectionBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import mapping.BddObject;

/**
 *
 * @author rango
 */
@TableAnnotation(nameTable="patisserie", sequence = "patisserie_seq", prefix = "PAT_")
public class Patisserie {
    @ColumnField(column="idPatisserie", is_increment= true, primary_key= true)
    private String id;
    
    @ColumnField(column="nomPatisserie")
    private String nomPatisserie;
    
    @ColumnField(column="prixUnitaire")
    private Double prixUnitaire;
    
    @ColumnField(column="idCategorie")
    private String idCategorie;
    
    @ColumnField(column="idParfum")
    private String idParfum;
    
    private Parfum MyParfum;
    
    private Categorie MyCategorie;
    
    public static Map<String, Integer> getVenteByCategorieAndParfum(String idCatego, String idParf, Connection connection) throws Exception
    {
        Map<String, Integer> result = new HashMap<>();
        boolean isOpen = false;
        ConnectionBase cb = new ConnectionBase();
        if(connection == null){
            connection = cb.dbConnect();     // If it is null, creating connection
        }else{
            isOpen = true;
        }
        PreparedStatement pm = null;
        ResultSet resultSet = null;
       
        try {
            String sqlQuery = "select \n" +
                "    nompatisserie, \n" +
                "    sum(quantite) \n" +
                "from v_vente_avec_categorie_parfum \n" +
                "where idcategorie = ? and idparfum = ? \n" +
                "group by nompatisserie";
            pm = connection.prepareStatement(sqlQuery);
            pm.setString(1, idCatego);
            pm.setString(2, idParf);
            resultSet = pm.executeQuery();
            while (resultSet.next()) {
                // Retrieve the sum of prices from the result set
                String nom = resultSet.getString(1);
                int sum = resultSet.getInt(2);
                result.put(nom, sum);
            }   
            return  result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error on getting search by categorie and by parfum. "+ e.getMessage());
        } finally{
            resultSet.close();
            pm.close();
            if(isOpen == false) connection.close();
        }
    }
    
    

    public Patisserie(String nomPatisserie, String prixUnitaire, String idCategorie, String idParfum) throws Exception {
        try {
        this.setNomPatisserie(nomPatisserie);
        this.setPrixUnitaire(prixUnitaire);
        this.setIdCategorie(idCategorie);
        this.setIdParfum(idParfum);
        }catch (Exception e) {
            throw new Exception("erreur set patisserie" + e.getMessage());
        }
    }
    
    public Patisserie (){
     }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomPatisserie() {
        return nomPatisserie;
    }

    public void setNomPatisserie(String nomPatisserie) {
        this.nomPatisserie = nomPatisserie;
    }

    public Double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(Double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
    
     public void setPrixUnitaire(String prixUnitaireHtml) throws Exception {
        try{
            Double valeur = Double.valueOf(prixUnitaireHtml);
            this.setPrixUnitaire(valeur);
        } catch (Exception e) {
             throw new Exception("Erreur set prix" + e.getMessage());
        }
    }

    public String getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(String idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getIdParfum() {
        return idParfum;
    }

    public void setIdParfum(String idParfum) {
        this.idParfum = idParfum;
    }

    public Parfum getMyParfum() throws Exception {
      if (this.getIdParfum() == null) return null;
      try { 
          Parfum p = new Parfum();
          p.setId(this.getIdParfum());
          p= BddObject.findById(p, null);
          return p;
      } catch (Exception e) {
            throw new Exception("erreur sur la fonction getMyParfum. Error :" + e.getMessage());
        }
    }

    public void setMyParfum(Parfum MyParfum) {
        this.MyParfum = MyParfum;
    }
    
    

    public Categorie getMyCategorie() throws Exception {
        if (this.getIdCategorie() == null) return null;
        try {
            Categorie c = new Categorie();
            c.setId(this.getIdCategorie());
            c = BddObject.findById(c, null);
            return c;
        } catch (Exception e) {
            throw new Exception("erreur sur la fonction getMyCategorie. Error :" + e.getMessage());
        }
    }

    public void setMyCategorie(Categorie MyCategorie) {
        this.MyCategorie = MyCategorie;
    }
    
    
}
