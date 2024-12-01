//Ali Hasan Jasim 202200428
//Habib Mansoor 202202669
//Mohamed A.Karim 202207430

import java.util.ArrayList;

public class Patient {
    // Private Data Members  
    private long patientId;
    private String firstName;
    private String lastName;
    private char gender;
    private String email;
    private ArrayList<String> medicalHistory;
    private ArrayList<Service> servicesReceived;

    // Default Constructor  
    public Patient() {
        this.patientId = 0;
        this.firstName = "";
        this.lastName = "";
        this.gender = ' ';
        this.email = "";
        this.medicalHistory = new ArrayList<>();
        this.servicesReceived = new ArrayList<>();
    }

    // Constructor with parameters to inialize the data memebers with the given data in the parametar (excluding medicalHistory and servicesReceived)
    public Patient(long patientId, String firstName, String lastName, char gender, String email) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.medicalHistory = new ArrayList<>();
        this.servicesReceived = new ArrayList<>();
    }

    // Getter and Setter Methods
    //get method to return the patient id
    public long getPatientId() {
        return patientId;
    }
    //set method to set the patient id
    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }
    //get method to return the first name
    public String getFirstName() {
        return firstName;
    }
    //set method to set the first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    //get method to return the last name
    public String getLastName() {
        return lastName;
    }
    //set method to set the last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    //get method to return the gender
    public char getGender() {
        return gender;
    }
    //set method to set the gender
    public void setGender(char gender) {
        this.gender = gender;
    }
    //get method to return the email
    public String getEmail() {
        return email;
    }
    //set method to set the email
    public void setEmail(String email) {
        this.email = email;
    }
    //get method to return the medicalHistory
    public ArrayList<String> getMedicalHistory() {
        return medicalHistory;
    }
    //set method to set the medicalHistory
    public void setMedicalHistory(ArrayList<String> medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
    //get method to return the getServicesReceived
    public ArrayList<Service> getServicesReceived() {
        return servicesReceived;
    }
    //set method to set the getServicesReceived
    public void setServicesReceived(ArrayList<Service> servicesReceived) {
        this.servicesReceived = servicesReceived;
    }

    // This Method Compares Two Patients by their ID.
    public boolean equals(Patient otherPatient) {
        //check if the patient is null , then return false
        if (otherPatient == null) {
            return false;
        }
        // return true if the patient equalt to the otherPatient , otherwise return true
        return this.patientId == otherPatient.patientId;
    }

    // This Method Displays all the Medical Records in the medicalHistory List.
    public void printMedicalHistory() {
    // PRINT FIRST NAME AND LAST NAME
        System.out.println("Medical History for " + firstName + " " + lastName + ":");
        if (medicalHistory.isEmpty()) {
            // IF MEDICAL HISTORY LIST IS EMPTY THEN PRINT "NO MEDICAL HISTORY AVAILABLE"
            System.out.println("No medical history available.");
        } else {
            // IF LIST IS NOT EMPTY THEN LOOP OVER THE LIST AND PRINT EACH
            for (int i = 0; i < medicalHistory.size(); i++) {
                System.out.println("- " + medicalHistory.get(i));
            }
        }
    }



    // This Method Displays all the Services Received in the servicesReceived List.
    public void printServicesReceived() {
        // PRINT FIRST NAME AND LAST NAME
        System.out.println("Services Received by " + firstName + " " + lastName + ":");
        if (servicesReceived.isEmpty()) {
            // IF SERVICES RECEVIED LIST IS EMPTY THEN PRINT "NO SERVICES RECEIVED"
            System.out.println("No services received.");
        } else {
            // IF ITS NOT EMPTY THEN LOOP OVER THE LIST AND THEN PRINT EACH
            for (int i = 0; i < servicesReceived.size(); i++) {
                System.out.println(servicesReceived.get(i));
                System.out.println("---------------------------");
            }
        }
    }

    // This Method Returns Patients Information to be Displayed.
    public String toString() {
        return "Patient ID: " + patientId +
                "\nName: " + firstName + " " + lastName +
                "\nGender: " + gender +
                "\nEmail: " + email;
    }
}

