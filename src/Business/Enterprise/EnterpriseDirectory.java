/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author Danisha
 */
public class EnterpriseDirectory {
    
    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }
    
    public boolean checkIfEnterpriseNameIsUnique(String enterpriseName){
        for (Enterprise enterprise: enterpriseList){
            if (enterprise.getEnterpriseName().equals(enterpriseName))
                return false;
        }
        return true;
    }
    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type){
        Enterprise enterprise = null;
        if (type == Enterprise.EnterpriseType.Distributor){
            enterprise = new DistributorEnterprise();
            enterpriseList.add(enterprise);
        }
        if (type == Enterprise.EnterpriseType.Manufacturer){
            enterprise = new ManufacturerEnterprise();
            enterpriseList.add(enterprise);
        }
        if (type == Enterprise.EnterpriseType.PHD){
            enterprise = new PHDEnterprise();
            enterpriseList.add(enterprise);
        }
        if (type == Enterprise.EnterpriseType.Provider){
            enterprise = new ProviderEnterprise();
            enterpriseList.add(enterprise);
        }
        return enterprise;
    }
    
}
