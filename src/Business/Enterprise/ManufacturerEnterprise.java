/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Order.ManufOrderList;
import Business.Roles.ManufacturerAdminRole;
import Business.Roles.ManufacturerFinanceRole;
import Business.Roles.Roles;
import java.util.ArrayList;

/**
 *
 * @author Danisha
 */
public class ManufacturerEnterprise extends Enterprise {

    private boolean blacklisted = false;
    private float manufTreasure = 5000000;
    public int blackListCount = 0;
    private ManufOrderList manufOrderDirectory;

    public ManufacturerEnterprise() {
        super(Enterprise.EnterpriseType.Manufacturer);
        manufOrderDirectory = new ManufOrderList();
    }

    @Override
    public ArrayList<Roles> getSupportedRole() {
        ArrayList<Roles> roles = new ArrayList<>();
        roles.add(new ManufacturerAdminRole());
        roles.add(new ManufacturerFinanceRole());
        return roles;
    }

    public ManufOrderList getManufOrderDirectory() {
        return manufOrderDirectory;
    }

    public void setManufOrderDirectory(ManufOrderList manufOrderDirectory) {
        this.manufOrderDirectory = manufOrderDirectory;
    }

    public int getBlackListCount() {
        return blackListCount;
    }

    public void setBlackListCount(int blackListCount) {
        this.blackListCount = blackListCount;
    }

    public boolean isBlacklisted() {
        return blacklisted;
    }

    public float getManufTreasure() {
        return manufTreasure;
    }

    public void setManufTreasure(float manufTreasure) {
        this.manufTreasure = manufTreasure;
    }

    public void setBlacklisted(boolean blacklisted) {
        this.blacklisted = blacklisted;
    }
    
    
}
