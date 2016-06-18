/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Vaccine;

import Business.Enterprise.ManufacturerEnterprise;
import java.util.Date;

/**
 *
 * @author Danisha
 */
public class Vaccine {

    private int vaccineId;
    private String vaccineName;
    private String sideeffects;
    private String diseasesCured;
    private String contents;
    private static int counter =1;
    private String dateOfManufacture;
    private String dateOfExpiry; /*one year from date of manufacture*/
    private float basePrice;
    private float salesPrice;
    
    public Vaccine() {
        
        vaccineId= counter;
        counter++;
    }

    public int getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(int vaccineId) {
        this.vaccineId = vaccineId;
    }

    public String getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(String dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public String getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(String dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    public float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }

    public float getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(float salesPrice) {
        this.salesPrice = salesPrice;
    }

    
    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getSideeffects() {
        return sideeffects;
    }

    public void setSideeffects(String sideeffects) {
        this.sideeffects = sideeffects;
    }

    public String getDiseasesCured() {
        return diseasesCured;
    }

    public void setDiseasesCured(String diseasesCured) {
        this.diseasesCured = diseasesCured;
    }

    @Override
    public String toString() {
        return vaccineName;
    }
}
