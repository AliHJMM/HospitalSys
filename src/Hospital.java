//Ali Hasan Jasim 202200428
//Habib Mansoor 202202669
//Mohamed A.Karim 202207430

import java.util.LinkedList;

public class Hospital {
    // Private Data Members  
    private LinkedList<Patient> patientsList;
    private LinkedList<Service> servicesList;
    private int size;

    // Default Constructor  
    public Hospital() {
        this.patientsList = new LinkedList<>();
        this.servicesList = new LinkedList<>();
        this.size = 0;
    }

    // This Method Adds a new Patient to the patientsList if the patient not already in the list.
    public boolean addPatient(Patient patient) {
        if (patientsList.contains(patient)) {
            return false;  // Patient already exists  
        } else {  //else we will add a patient
            patientsList.add(patient);
            size++;
            return true;
        }
    }

    // This Method Deletes a Patient from patientsList by patientId and returns true if removed.
    public boolean deletePatient(long patientId) {
        int index = searchPatient(patientId);
        if (index != -1) { // the patient is found
            patientsList.remove(index);
            size--;
            return true;
        } else {
            return false;  // patient not found
        }
    }

    // This Method Searches for a Patient in patientsList by patientId and returns index if found.
    public int searchPatient(long patientId) {
        for (int i = 0; i < patientsList.size(); i++) {
            if (patientsList.get(i).getPatientId() == patientId) { //if found return index
                return i;
            }
        }
        return -1;  // Not found  
    }

    // This Method Returns true if there is no patients in the list.
    public boolean isEmpty() {
        return patientsList.isEmpty();
    }

    // This Method Returns number of patients in the patientsList.
    public int listSize() {
        return size;
    }

    // This Method Returns the Patient at the specified index in patientsList and returns patient if index is valid.
    public Patient getPatient(int index) {
        if (index >= 0 && index < patientsList.size()) { // validate the index
            return patientsList.get(index);
        } else {
            return null;  // Index is out of bounds
        }
    }

    // This Method Adds a Service to the servicesList if it is not there.
    public void addService(Service service) {
        if (!servicesList.contains(service)) {
            servicesList.add(service);
        }
    }

    // This Method Returns a Service from servicesList based on its ID and if its found return service.
    public Service getService(String serviceId) {
        for (int i = 0; i < servicesList.size(); i++) {
            if (servicesList.get(i).getServiceId().equals(serviceId)) { // if found, return service
                return servicesList.get(i);
            }
        }
        return null;  // Not found, return null
    }

    // This Method Prints details of a Patient including their medical history and services received and if not found print an error message.
    public void printPatientDetails(long patientId) {
        int index = searchPatient(patientId);
        if (index != -1) { //if found
            Patient patient = patientsList.get(index);
            System.out.println(patient);
            patient.printMedicalHistory();
            patient.printServicesReceived();
        } else {
            System.out.println("Patient not found."); // Patient ID not found
        }
    }

    // This Method Print all patients in the patientsList and if list is empty print an error message.
    public void printPatientList() {
        if (patientsList.isEmpty()) {
            System.out.println("No patients registered."); // No patients in the list
        } else {
            for (int i = 0; i < patientsList.size(); i++) {
                System.out.println(patientsList.get(i));
                System.out.println("---------------------------"); // for better readability in terminal
            }
        }
    }

    // This Method Prints all services in the servicesList and if list empty print an error message.
    public void printServiceList() {
        if (servicesList.isEmpty()) {
            System.out.println("No services available."); // No services in the list
        } else {
            for (int i = 0; i < servicesList.size(); i++) {
                System.out.println(servicesList.get(i));
                System.out.println("---------------------------"); // for better readability in terminal
            }
        }
    }

    // This Method Returns  total number of patients in patientsList.
    public int getTotalPatients() {
        return patientsList.size();
    }

    // This Method Returns number of services in servicesList.
    public int getTotalServices() {
        return servicesList.size();
    }

    // This Method Calculate and return totalRevenue from all services received by patients & it loops through each patient services to calculate total cost.
    public double calculateTotalRevenue() {
        double totalRevenue = 0.0;
        for (int i = 0; i < patientsList.size(); i++) { // loop over patient list 
            Patient patient = patientsList.get(i);
            for (int j = 0; j < patient.getServicesReceived().size(); j++) {// inside the first loop this loop will iterate over services and add revenue
                totalRevenue += patient.getServicesReceived().get(j).getCost();
            }
        }
        return totalRevenue;
    }

    // This Method Reset the system by clearing the lists we have and set sizee to 0.
    public void resetSystem() {
        patientsList.clear();
        servicesList.clear();
        size = 0;
    }
}
