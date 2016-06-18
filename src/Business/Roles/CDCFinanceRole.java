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
import UserInterface.CDCFinance.CDCFinanceWorkArea;
import javax.swing.JPanel;

/**
 *
 * @author Danisha
 */
public class CDCFinanceRole extends Roles{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, CDCSystem business, DB4OUtil db4oUtil) {
        return new CDCFinanceWorkArea(userProcessContainer, business, account, db4oUtil);
    }
    
}
