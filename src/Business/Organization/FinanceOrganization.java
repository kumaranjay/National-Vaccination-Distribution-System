/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Roles.CDCFinanceRole;
import Business.Roles.DistributorFinanceRole;
import Business.Roles.ManufacturerFinanceRole;
import Business.Roles.ProviderFinanceRole;
import Business.Roles.Roles;
import java.util.ArrayList;

/**
 *
 * @author Danisha
 */
public class FinanceOrganization extends Organization{

    public FinanceOrganization() {
        super(Type.Finance.getValue());
    }
    
    @Override
    public ArrayList<Roles> getSupportedRole() {
    
        ArrayList<Roles> roles = new ArrayList<>();
        roles.add(new CDCFinanceRole());
        roles.add(new ManufacturerFinanceRole());
        roles.add(new DistributorFinanceRole());
        roles.add(new ProviderFinanceRole());
        return roles;
    }
    
    
}
