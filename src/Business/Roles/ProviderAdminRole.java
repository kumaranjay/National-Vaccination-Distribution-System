 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Roles;

import Business.CDCSystem;
import Business.DB4OUtil.DB4OUtil;
import Business.Enterprise.Enterprise;
import Business.Enterprise.ProviderEnterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.ProviderAdmin.ProviderAdminWorkArea;
import UserInterface.ProviderAdmin.ProviderTempWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Danisha
 */
public class ProviderAdminRole extends Roles{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, CDCSystem business, DB4OUtil db4oUtil) {
       ProviderEnterprise enterprise1= (ProviderEnterprise)enterprise;
       if(enterprise1.getStatus().equals("Deactive")){
        return new ProviderTempWorkAreaJPanel(userProcessContainer, account,enterprise, business, db4oUtil);
       }
       else{
           return new ProviderAdminWorkArea(userProcessContainer, account, organization, enterprise, business, db4oUtil);
       }
      }
    
}
