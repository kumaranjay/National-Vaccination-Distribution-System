/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.NationalDistributor;

import Business.Enterprise.Enterprise;
import Business.Roles.Roles;
import java.util.ArrayList;

/**
 *
 * @author Danisha
 */
public class NationalDistributor extends Enterprise{

    private DistributorDirectory distributorDirectory;

    public NationalDistributor(){
        super(null);
        distributorDirectory = new DistributorDirectory();
    }

    public DistributorDirectory getDistributorDirectory() {
        return distributorDirectory;
    }

    @Override
    public ArrayList<Roles> getSupportedRole() {
        return null;
    }
}
