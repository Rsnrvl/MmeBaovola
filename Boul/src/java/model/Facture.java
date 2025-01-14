/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import annoted.ColumnField;
import annoted.TableAnnotation;
import java.sql.Date;
import mapping.BddObject;
import utilities.DatePattern;
import utilities.DateUtil;

/**
 *
 * @author rango
 */
@TableAnnotation(nameTable="facture", sequence="fm_seq", prefix="FM_")
public class Facture {
    @ColumnField(column="idFacture", primary_key=true, is_increment=true)
    private String id;
    
    @ColumnField(column="dateFacture")
    private java.sql.Date dateFacture;
    
    @ColumnField(column="idClient")
    private String idClient;
    
    // Etat ana facture
    // 0 : Creer fotsiny ilay facture
    // 1 : Enregistrer ilay facture (Validée)
    // 10 : Payée (ohatra : Afaka asina etat bdb ny facture zay tina)
    @ColumnField(column="etat")
    private Integer etat;
    
    private Client MyClient;
    
    public Facture (){
    }
    
    public Facture(String dateFacture, String idClient) throws Exception {
        try {
        this.setDateFacture(dateFacture);
        this.setIdClient(idClient);
        this.setEtat(0); // Creation facture : 0
        } catch (Exception e) {
        throw new Exception("Erreur constructeur Facture" + e.getMessage());
        }
    }
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }
    
   public void setDateFacture(String dateFactureHtml) throws Exception {
    try {
            java.sql.Date dateFacture = DateUtil.stringToSqlDate(java.sql.Date.class, dateFactureHtml, DatePattern.YYYY_MM_DD);
            this.setDateFacture(dateFacture);
        } catch (Exception e) {
            throw new Exception("Erreur set Date naissnace");
        }
    }
    
    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public Client getMyClient() throws Exception {
        if(this.getIdClient() == null) return null;
        try {
         Client cl = new Client();
         cl.setId(this.getIdClient());
         cl = BddObject.findById(cl,null);
         return cl;
        } catch (Exception e) {
            throw new Exception("Erreur sur la fonction getMyClient. Erreur :" + e.getMessage());
        }
    }

    public void setMyClient(Client MyClient) {
        this.MyClient = MyClient;
    }

    public Integer getEtat() {
        return etat;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }
}
