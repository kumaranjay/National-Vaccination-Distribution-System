/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Inventory.InventoryDirectory;
import Business.Roles.DistributorInventoryRole;
import Business.Roles.ProviderInventoryRole;
import Business.Roles.Roles;
import java.util.ArrayList;

/**
 *
 * @author Danisha
 */
public class InventoryOrganization extends Organization{

    private InventoryDirectory inventoryDirectory;
    public InventoryOrganization() {
        super(Type.Inventory.getValue());
        inventoryDirectory= new InventoryDirectory();
    }

    public InventoryDirectory getInventoryDirectory() {
        return inventoryDirectory;
    }

    public void setInventoryDirectory(InventoryDirectory inventoryDirectory) {
        this.inventoryDirectory = inventoryDirectory;
    }
    
    
    @Override
    public ArrayList<Roles> getSupportedRole() {
        
        ArrayList<Roles> roles = new ArrayList<>();
        roles.add(new DistributorInventoryRole());
        roles.add(new ProviderInventoryRole());
        return roles;
    }
    
}
