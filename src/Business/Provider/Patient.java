/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Provider;

/**
 *
 * @author Danisha
 */
public class Patient {

    private String patientName;
    private String lastName;
    private int age;
    private String insuredType;
    private String insuranceName;
    private String contactNo;
    private int patientId;
    private static int count = 1;
    private int insurancePercentage;

    public Patient() {
        patientId = count;
        count++;
    }

    public String getContactNo() {
        return contactNo;
    }

    public int getInsurancePercentage() {
        return insurancePercentage;
    }

    public void setInsurancePercentage(int insurancePercentage) {
        this.insurancePercentage = insurancePercentage;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInsuredType() {
        return insuredType;
    }

    public void setInsuredType(String insuredType) {
        this.insuredType = insuredType;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    @Override
    public String toString() {
        return String.valueOf(patientId);
    }
}
