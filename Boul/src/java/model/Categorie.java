/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import annoted.ColumnField;
import annoted.TableAnnotation;

/**
 *
 * @author rango
 */
@TableAnnotation(nameTable="categorie", sequence="cat_seq", prefix = "CAT_")
public class Categorie {
    @ColumnField(column="idCategorie", is_increment=true, primary_key= true)
    private String id;
    
    @ColumnField(column="nomCategorie")
    private String nomCategorie;
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }
    
    public Categorie (){
    }

    public Categorie(String id, String nomCategorie) {
        this.id = id;
        this.nomCategorie = nomCategorie;
    }
    
    
    
}
