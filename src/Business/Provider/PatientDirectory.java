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
public class PatientDirectory {

    private ArrayList<Patient> patientList;

    public PatientDirectory() {
        patientList = new ArrayList<>();
    }

    public ArrayList<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(ArrayList<Patient> patientList) {
        this.patientList = patientList;
    }
}
