/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Roles.DistributorAdminRole;
import Business.Roles.ManufacturerAdminRole;
import Business.Roles.PHDAdminRole;
import Business.Roles.ProviderAdminRole;
import Business.Roles.Roles;
import Business.Roles.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author Danisha
 */
public class AdminOrganization extends Organization{

    public AdminOrganization() {
        super(Type.Admin.getValue());
    }
    
    @Override
    public ArrayList<Roles> getSupportedRole() {
        ArrayList<Roles> roles = new ArrayList<>();
        roles.add(new SystemAdminRole());
        roles.add(new PHDAdminRole());
        roles.add(new ManufacturerAdminRole());
        roles.add(new DistributorAdminRole());
        roles.add(new ProviderAdminRole());
        return roles;
    }
    
}
