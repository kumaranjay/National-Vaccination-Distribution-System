/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.NationalDistributor;

import Business.Enterprise.DistributorEnterprise;
import java.util.ArrayList;

/**
 *
 * @author Danisha
 */
public class DistributorDirectory {

    private ArrayList<DistributorEnterprise> distributorList;

    public DistributorDirectory() {
        distributorList = new ArrayList<>();
    }

    public ArrayList<DistributorEnterprise> getDistributorList() {
        return distributorList;
    }
   
}
