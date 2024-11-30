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

    // Equals method to compare patients by patientId
    public boolean equals(Patient otherPatient) {
        if (otherPatient == null) {
            return false;
        }
        return this.patientId == otherPatient.patientId;
    }

    // printMedicalHistory method to display medical records  
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


    // printServicesReceived method to display services received  
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

    // toString method for displaying patient details
    public String toString() {
        return "Patient ID: " + patientId +
                "\nName: " + firstName + " " + lastName +
                "\nGender: " + gender +
                "\nEmail: " + email;
    }
}

