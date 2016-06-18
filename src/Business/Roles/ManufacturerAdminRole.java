/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Roles;

import Business.CDCSystem;
import Business.DB4OUtil.DB4OUtil;
import Business.Enterprise.Enterprise;
import Business.Enterprise.ManufacturerEnterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.ManufacturerAdmin.ManufacturerAdminWorkArea;
import UserInterface.ManufacturerAdmin.ManufacturerTempWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Danisha
 */
public class ManufacturerAdminRole extends Roles {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, CDCSystem business, DB4OUtil db4oUtil) {
        
        ManufacturerEnterprise enterprise1 = (ManufacturerEnterprise) enterprise;
        if (enterprise1.isBlacklisted()) {
            return new ManufacturerTempWorkAreaJPanel(userProcessContainer, account, enterprise, business, db4oUtil);
        } else {
            return new ManufacturerAdminWorkArea(userProcessContainer,business,db4oUtil,account,enterprise);
}

    }
}
