/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Employee.Employee;;
import Business.Organization.Organization;
import Business.Roles.CDCFinanceRole;
import Business.Roles.DistributorAdminRole;
import Business.Roles.DistributorFinanceRole;
import Business.Roles.SystemAdminRole;
import Business.Organization.Organization;
import Business.Roles.DistributorAdminRole;
import Business.Roles.DistributorFinanceRole;
import Business.Roles.SystemAdminRole;


/**
 *
 * @author Danisha
 */
public class ConfigureBusiness {

    public static CDCSystem configure() {

        CDCSystem cdcSystem = CDCSystem.getInstance();

        Employee sysadmin = cdcSystem.getEmployeeDirectory().createEmployee("Danisha Kannan");

        cdcSystem.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", sysadmin, new SystemAdminRole());
        
        Employee sysfinance = cdcSystem.getEmployeeDirectory().createEmployee("Danny");

        cdcSystem.getUserAccountDirectory().createUserAccount("sysfinance", "sysfinance", sysfinance, new CDCFinanceRole());
        
        Employee nationalDistributor1 = cdcSystem.getNationalDistributor().getEmployeeDirectory().createEmployee("Kumar");

        Employee nationalDistributor2 = cdcSystem.getNationalDistributor().getEmployeeDirectory().createEmployee("Kumari");

        cdcSystem.getNationalDistributor().getUserAccountDirectory().createUserAccount("nationaladmin", "nationaladmin", nationalDistributor1, new DistributorAdminRole());

        cdcSystem.getNationalDistributor().getUserAccountDirectory().createUserAccount("nationalfinance", "nationalfinance", nationalDistributor2, new DistributorFinanceRole());

        Organization org1= cdcSystem.getNationalDistributor().getOrganizationDirectory().createOrganization(Organization.Type.Finance);

        Organization org2= cdcSystem.getNationalDistributor().getOrganizationDirectory().createOrganization(Organization.Type.Admin);
        
        org2.getUserAccountDirectory().createUserAccount("nationaladmin", "nationaladmin", nationalDistributor1, new DistributorAdminRole());
        
        org1.getUserAccountDirectory().createUserAccount("nationalfinance", "nationalfinance", nationalDistributor2, new DistributorFinanceRole());
        
        return cdcSystem;
    }
}
