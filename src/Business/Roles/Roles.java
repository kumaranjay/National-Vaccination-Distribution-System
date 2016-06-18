/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Roles;

import Business.CDCSystem;
import Business.DB4OUtil.DB4OUtil;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
/**
 *
 * @author Danisha
 */
public abstract class Roles {
    public enum RoleType{
        SystemAdmin("System Admin"),
        PHDAdmin("PHD Admin"),
        ProviderAdmin("Provider Admin"),
        DistributorAdmin("Distributor Admin"),
        ManufacturerAdmin("Manufacturer Admin"),
        ProviderOrder("Provider Order"),
        DistributorOrder("Distributor Order"),
        ManufacturerOrder("Manufacturer Order"),
        ProviderFinance("Provider Finance"),
        DistributorFinance("Distributor Finance"),
        ManufacturerFinance("Manufacturer Finance"),
        ProviderInventory("Providr Inventory"),
        DistributorInventory("Distributor Inventory");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            CDCSystem business,
            DB4OUtil db4outil);
    
    

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
    
    
}
