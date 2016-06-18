/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Enterprise.Enterprise;
import Business.NationalDistributor.NationalDistributor;
import Business.Network.Network;
import Business.Roles.Roles;
import Business.UserAccount.UserAccount;
import Business.Vaccine.VaccineDirectory;
import java.util.ArrayList;

/**
 *
 * @author Danisha
 */
public class CDCSystem extends Enterprise {

    private static CDCSystem business;
    private NationalDistributor nationalDistributor;
    private VaccineDirectory vaccineDirectory;
    private Network network;

    public static CDCSystem getInstance() {
        if (business == null) {
            business = new CDCSystem();
        }
        return business;
    }

    private CDCSystem() {
        super(null);
        nationalDistributor = new NationalDistributor();
        vaccineDirectory = new VaccineDirectory();
        network = new Network();
        network.setName("United States of America");
        network.createStates(network);
        network.createEnterpises(network);
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public NationalDistributor getNationalDistributor() {
        return nationalDistributor;
    }

    public void setNationalDistributor(NationalDistributor nationalDistributor) {
        this.nationalDistributor = nationalDistributor;
    }

    public VaccineDirectory getVaccineDirectory() {
        return vaccineDirectory;
    }

    public void setVaccineDirectory(VaccineDirectory vaccineDirectory) {
        this.vaccineDirectory = vaccineDirectory;
    }

    public boolean checkUsernameUnique(CDCSystem system, String userName) {
        boolean flag = false;
        flag = system.getUserAccountDirectory().checkIfUsernameIsUnique(userName);
        if (flag == false) {
            A:
            for (Network stateNetwork : system.getNetwork().getNetworkList()) {

                for (Enterprise enterprise : stateNetwork.getEnterpriseDirectory().getEnterpriseList()) {
                    flag = enterprise.getUserAccountDirectory().checkIfUsernameIsUnique(userName);
                    if (flag == true) {
                        break A;
                    }
                }
                for (Network cityNet : stateNetwork.getNetworkList()) {
                    for (Enterprise enterprise : cityNet.getEnterpriseDirectory().getEnterpriseList()) {
                        flag = enterprise.getUserAccountDirectory().checkIfUsernameIsUnique(userName);
                        if (flag == true) {
                            break A;
                        }
                    }
                }
            }
        }
        else{
            return flag;
        }
        return flag;

    }

    @Override
    public ArrayList<Roles> getSupportedRole() {
        return null;
    }
}
