package fr.pinard.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 
 * @author Philippe
 * Classe de clef composée de l'entity Vin
 *
 */
@Embeddable
public class VinPK implements Serializable {
	private static final long serialVersionUID = 1L;

    private Integer codeProduit;
    
    @Column(length = 50)
    private String designation;
	
    public VinPK(){this(0,null);} 
	
    public VinPK(Integer codeProduit, String designation)
    {
        this.codeProduit=codeProduit;
        this.designation=designation;
    }

    public Integer getCodeProduit() {
        return codeProduit;
    }

    public void setCodeProduit(Integer codeProduit) {
        this.codeProduit = codeProduit;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof VinPK){
        VinPK pk=(VinPK)obj;
            return codeProduit.equals(pk.codeProduit) && designation.equals(pk.designation);
        }else{
            return false;
        }
    }

    @Override
    public int hashCode(){	
        return  super.hashCode()+15*codeProduit.hashCode()+71*designation.hashCode();
    }

    @Override
    public String toString(){
        return codeProduit + " "+designation;
    }
}
