/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Roles.ProviderOrderRole;
import Business.Roles.Roles;
import java.util.ArrayList;

/**
 *
 * @author Danisha
 */
public class OrderOrganization extends Organization{

    public OrderOrganization() {
        super(Type.Order.getValue());
    }
    
    @Override
    public ArrayList<Roles> getSupportedRole() {
   
        ArrayList<Roles> roles = new ArrayList<>();
        roles.add(new ProviderOrderRole());
        return roles;
    }
    
    
}
