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

    // Constructor with parameters (excluding medicalHistory and servicesReceived)  
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
    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<String> getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(ArrayList<String> medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public ArrayList<Service> getServicesReceived() {
        return servicesReceived;
    }

    public void setServicesReceived(ArrayList<Service> servicesReceived) {
        this.servicesReceived = servicesReceived;
    }

    // This Method Compares Two Patients by their ID.
    public boolean equals(Patient otherPatient) {
        if (otherPatient == null) {
            return false;
        }
        return this.patientId == otherPatient.patientId;
    }

    // This Method Displays all the Medical Records in the medicalHistory List.
    public void printMedicalHistory() {
        System.out.println("Medical History for " + firstName + " " + lastName + ":");
        if (medicalHistory.isEmpty()) {
            System.out.println("No medical history available.");
        } else {
            for (int i = 0; i < medicalHistory.size(); i++) {
                System.out.println("- " + medicalHistory.get(i));
            }
        }
    }



    // This Method Displays all the Services Received in the servicesReceived List.
    public void printServicesReceived() {
        System.out.println("Services Received by " + firstName + " " + lastName + ":");
        if (servicesReceived.isEmpty()) {
            System.out.println("No services received.");
        } else {
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

