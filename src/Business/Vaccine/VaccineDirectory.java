/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Vaccine;

import java.util.ArrayList;

/**
 *
 * @author Danisha
 */
public class VaccineDirectory {
    
    private ArrayList<Vaccine> vaccineList;
    
    public VaccineDirectory(){
        vaccineList= new ArrayList<>();
    }

    public ArrayList<Vaccine> getVaccineList() {
        return vaccineList;
    }

    public void setVaccineList(ArrayList<Vaccine> vaccineList) {
        this.vaccineList = vaccineList;
    }
    
    public Vaccine addVaccine(){
        Vaccine vaccine= new Vaccine();
        vaccineList.add(vaccine);
        return vaccine;
    }
    
    public void removeVaccine(Vaccine vaccine){
        vaccineList.remove(vaccine);
    }
}
