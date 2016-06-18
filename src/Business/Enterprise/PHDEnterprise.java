/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Roles.PHDAdminRole;
import Business.Roles.Roles;
import java.util.ArrayList;

/**
 *
 * @author Danisha
 */
public class PHDEnterprise extends Enterprise{
    
    public PHDEnterprise(){
        super(EnterpriseType.PHD);
    }

    @Override
    public ArrayList<Roles> getSupportedRole() {
        ArrayList<Roles> roles = new ArrayList<>();
        roles.add(new PHDAdminRole());
        return roles;
    }
}
