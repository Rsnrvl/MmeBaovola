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
@TableAnnotation(nameTable="parfum", sequence = "parfum_seq", prefix = "PARF_")
public class Parfum {
   @ColumnField(column = "idParfum", primary_key = true, is_increment = true)
   private String id;
   
   @ColumnField(column = "nomParfum")
   private String nomParfum;

    public Parfum(String id, String nomParfum) {
        this.setId(id);
        this.setNomParfum(nomParfum);
    }
    
    public Parfum (){
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomParfum() {
        return nomParfum;
    }

    public void setNomParfum(String nomParfum) {
        this.nomParfum = nomParfum;
    }

    
    
}
