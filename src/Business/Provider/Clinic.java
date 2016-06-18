/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Provider;

import Business.Enterprise.ProviderEnterprise;
import Business.Roles.Roles;
import java.util.ArrayList;

/**
 *
 * @author Danisha
 */
public class Clinic extends ProviderEnterprise {

    private String clinicName;
    private String clinicAddress;
    private PatientDirectory patientDirectory;
    private ProviderEnterprise clinicEnterprise;

    public Clinic() {
        super();
        patientDirectory = new PatientDirectory();
    }

    public ProviderEnterprise getClinicEnterprise() {
        return clinicEnterprise;
    }

    public void setClinicEnterprise(ProviderEnterprise clinicEnterprise) {
        this.clinicEnterprise = clinicEnterprise;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public String getClinicAddress() {
        return clinicAddress;
    }

    public void setClinicAddress(String clinicAddress) {
        this.clinicAddress = clinicAddress;
    }

    public PatientDirectory getPatientDirectory() {
        return patientDirectory;
    }

    public void setPatientDirectory(PatientDirectory patientDirectory) {
        this.patientDirectory = patientDirectory;
    }

    @Override
    public ArrayList<Roles> getSupportedRole() {
        return null;
    }
}
