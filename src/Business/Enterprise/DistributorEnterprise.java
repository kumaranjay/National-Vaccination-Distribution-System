/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Roles.DistributorAdminRole;
import Business.Roles.DistributorFinanceRole;
import Business.Roles.DistributorInventoryRole;
import Business.Roles.Roles;
import java.util.ArrayList;

/**
 *
 * @author Danisha
 */
public class DistributorEnterprise extends Enterprise {

    private float distTreasure = 5000000;

    public DistributorEnterprise() {
        super(EnterpriseType.Distributor);
    }

    public float getDistTreasure() {
        return distTreasure;
    }

    public void setDistTreasure(float distTreasure) {
        this.distTreasure = distTreasure;
    }

    @Override
    public ArrayList<Roles> getSupportedRole() {
        ArrayList<Roles> roles = new ArrayList<>();
        roles.add(new DistributorAdminRole());
        roles.add(new DistributorFinanceRole());
        roles.add(new DistributorInventoryRole());
        return roles;
    }
}
