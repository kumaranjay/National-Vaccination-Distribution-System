/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Provider;

import java.util.ArrayList;

/**
 *
 * @author Danisha
 */
public class ClinicDirectory {
    
    
    private ArrayList<Clinic> clinicList;
    
    public ClinicDirectory(){
        clinicList= new ArrayList<>();
    }

    public ArrayList<Clinic> getClinicList() {
        return clinicList;
    }

    public void setClinicList(ArrayList<Clinic> clinicList) {
        this.clinicList = clinicList;
    }
    
}
