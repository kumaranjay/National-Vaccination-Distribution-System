package Business.Network;

import Business.Employee.Employee;
import Business.Enterprise.DistributorEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseDirectory;
import Business.Enterprise.ManufacturerEnterprise;
import Business.Enterprise.PHDEnterprise;
import Business.Organization.Organization;
import Business.Roles.DistributorAdminRole;
import Business.Roles.DistributorInventoryRole;
import Business.Roles.ManufacturerAdminRole;
import Business.Roles.PHDAdminRole;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Danisha
 */
public class Network {

    private String name;
    private long population = 0;
    private int totalVaccines = 0;
    private ArrayList<Network> networkList;
    private EnterpriseDirectory enterpriseDirectory;

    public Network() {
        networkList = new ArrayList<>();
        enterpriseDirectory = new EnterpriseDirectory();
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void createStates(Network network) {

        //Connection con = null;
        //PreparedStatement st = null;
        //String rq1 = "SELECT * FROM  test.states ORDER BY statename ASC";
        String states[] = {"Alabama",
            "Alaska",
            "Arizona",
            "Arkansas",
            "California",
            "Colorado",
            "Connecticut",
            "Delaware",
            "Florida",
            "Georgia",
            "Hawaii",
            "Idaho",
            "Illinois",
            "Indiana",
            "Iowa",
            "Kansas",
            "Kentucky",
            "Louisiana",
            "Maine",
            "Maryland",
            "Massachusetts",
            "Michigan",
            "Minnesota",
            "Mississippi",
            "Missouri",
            "Montana",
            "Nebraska",
            "Nevada",
            "New Hampshire",
            "New Jersey",
            "New Mexico",
            "New York",
            "North Carolina",
            "North Dakota",
            "Ohio",
            "Oklahoma",
            "Oregon",
            "Pennsylvania",
            "Rhode Island",
            "South Carolina",
            "South Dakota",
            "Tennessee",
            "Texas",
            "Utah",
            "Vermont",
            "Virginia",
            "Washington",
            "West Virginia",
            "Wisconsin",
            "Wyoming"};
        long population[] = {4833732,
            735132,
            6626624,
            2959373,
            38332521,
            5268367,
            3596080,
            925749,
            646449,
            19552860,
            9992167,
            1404054,
            1612136,
            12882135,
            6570902,
            3090416,
            2893957,
            4395295,
            4625470,
            1328302,
            5928814,
            6692824,
            9895622,
            5420380,
            2991207,
            6044171,
            1015165,
            1868516,
            2790136,
            1323459,
            8899339,
            2085287,
            19651127,
            9848060,
            723393,
            11570808,
            3850568,
            3930065,
            12773801,
            1051511,
            4774839,
            844877,
            6495978,
            26448193,
            2900872,
            626630,
            8260405,
            6971406,
            1854304,
            5742713,
            582658};




        for (int i = 0; i < 50; i++) {
            Network stateNet = new Network();
            stateNet.setName(states[i]);
            stateNet.setPopulation(population[i]);
            network.getNetworkList().add(stateNet);
        }


    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public int getTotalVaccines() {
        return totalVaccines;
    }

    public void setTotalVaccines(int totalVaccines) {
        this.totalVaccines = totalVaccines;
    }

    public void createEnterpises(Network network) {
        for (Network network1 : network.getNetworkList()) {
            PHDEnterprise phd = new PHDEnterprise();
            Enterprise enterprise1 = phd;
            Employee employee1 = new Employee();
            employee1.setName(network1.getName() + " PHD");
            phd.setEnterpriseName(network1.getName() + " PHD");
            phd.setEnterpriseType(Enterprise.EnterpriseType.PHD);
            phd.setLocation(network1.getName());
            network1.getEnterpriseDirectory().getEnterpriseList().add(enterprise1);
            enterprise1.getUserAccountDirectory().createUserAccount(network1.getName() + " PHD", network1.getName() + " PHD", employee1, new PHDAdminRole());
            enterprise1.getOrganizationDirectory().createOrganization(Organization.Type.Admin);

            DistributorEnterprise de = new DistributorEnterprise();
            Enterprise enterprise2 = de;
            de.setEnterpriseName(network1.getName() + " Distributor");
            de.setEnterpriseType(Enterprise.EnterpriseType.Distributor);
            de.setLocation(network1.getName());
            network1.getEnterpriseDirectory().getEnterpriseList().add(enterprise2);
            enterprise2.getOrganizationDirectory().createOrganization(Organization.Type.Inventory);
            enterprise2.getOrganizationDirectory().createOrganization(Organization.Type.Finance);
            enterprise2.getOrganizationDirectory().createOrganization(Organization.Type.Admin);
            Employee employee2 = new Employee();
            employee2.setName(network1.getName() + " Distributor");
            enterprise2.getUserAccountDirectory().createUserAccount(network1.getName() + " Distributor", network1.getName() + " Distributor", employee2, new DistributorInventoryRole());


            ManufacturerEnterprise me = new ManufacturerEnterprise();
            Enterprise enterprise3 = me;
            me.setEnterpriseName(network1.getName() + " Manufacturer");
            me.setEnterpriseType(Enterprise.EnterpriseType.Manufacturer);
            me.setLocation(network1.getName());
            network1.getEnterpriseDirectory().getEnterpriseList().add(enterprise3);
            enterprise3.getOrganizationDirectory().createOrganization(Organization.Type.Admin);
            enterprise3.getOrganizationDirectory().createOrganization(Organization.Type.Order);
            enterprise3.getOrganizationDirectory().createOrganization(Organization.Type.Finance);
            Employee employee3 = new Employee();
            employee3.setName(network1.getName() + " Manufacturer");
            enterprise3.getUserAccountDirectory().createUserAccount(network1.getName() + " Manufacturer", network1.getName() + " Manufacturer", employee3, new ManufacturerAdminRole());


        }
    }

    @Override
    public String toString() {
        return name;
    }
}
