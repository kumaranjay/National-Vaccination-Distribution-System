/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Provider.ClinicDirectory;
import Business.Provider.PatientDirectory;
import Business.Roles.ProviderAdminRole;
import Business.Roles.ProviderFinanceRole;
import Business.Roles.ProviderInventoryRole;
import Business.Roles.ProviderOrderRole;
import Business.Roles.Roles;
import java.util.ArrayList;

/**
 *
 * @author Danisha
 */
public class ProviderEnterprise extends Enterprise {

    private float providerTreasure = 5000000;
    private String providerType;
    private String status;
    private String city;
    private PatientDirectory patientDirectory;
    private ClinicDirectory clinicDirectory;

    public ProviderEnterprise() {
        super(EnterpriseType.Provider);
        patientDirectory= new PatientDirectory();
        clinicDirectory = new ClinicDirectory();
    }

    public PatientDirectory getPatientDirectory() {
        return patientDirectory;
    }

    public void setPatientDirectory(PatientDirectory patientDirectory) {
        this.patientDirectory = patientDirectory;
    }

    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public float getProviderTreasure() {
        return providerTreasure;
    }

    public void setProviderTreasure(float providerTreasure) {
        this.providerTreasure = providerTreasure;
    }

    public void setProviderTreasure(int providerTreasure) {
        this.providerTreasure = providerTreasure;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProviderType() {
        return providerType;
    }

    public void setProviderType(String providerType) {
        this.providerType = providerType;
    }

    public ClinicDirectory getClinicDirectory() {
        return clinicDirectory;
    }

    public void setClinicDirectory(ClinicDirectory clinicDirectory) {
        this.clinicDirectory = clinicDirectory;
    }

    @Override
    public ArrayList<Roles> getSupportedRole() {
        ArrayList<Roles> roles = new ArrayList<>();
        roles.add(new ProviderAdminRole());
        roles.add(new ProviderFinanceRole());
        roles.add(new ProviderInventoryRole());
        roles.add(new ProviderOrderRole());
        return roles;
    }
}
