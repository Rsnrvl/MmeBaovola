/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import annoted.ColumnField;
import annoted.TableAnnotation;
import java.sql.Date;
import utilities.DatePattern;
import utilities.DateUtil;

/**
 *
 * @author rango
 */
@TableAnnotation(nameTable="client", sequence="cli_seq", prefix="CLI_")
public class Client {
    @ColumnField(column="idClient", primary_key=true, is_increment=true)
    private String id;
    
    @ColumnField(column="nomClient")
    private String nomClient;
    
    @ColumnField(column = "genre")
    private Integer genre;
    
    @ColumnField(column="dateNaissance")
    private java.sql.Date dateNaissance;
    
    public Client(String nomClient, String genre, String dateNaissance)throws Exception {
       try { 
        this.setNomClient(nomClient);
        this.setGenre(Integer.valueOf(genre));
        this.setDateNaissance(dateNaissance);
       } catch (Exception e) {
       throw new Exception("Erreur constructeur client" + e.getMessage());
               }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public Integer getGenre() {
        return genre;
    }

    public void setGenre(Integer genre) {
        this.genre = genre;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    
    public void setDateNaissance(String dateNaissanceHtml) throws Exception {
    try {
            java.sql.Date date = DateUtil.stringToSqlDate(java.sql.Date.class, dateNaissanceHtml, DatePattern.YYYY_MM_DD);
            this.setDateNaissance(date);
        } catch (Exception e) {
            throw new Exception("Erreur set Date naissnace");
        }
    }
    
     public Client (){
    }
    
}
