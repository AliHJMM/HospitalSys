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

    // Adds a new Patient object to the patientsList
    public boolean addPatient(Patient patient) {
        if (patientsList.contains(patient)) {
            return false;  // Patient already exists  
        } else {
            patientsList.add(patient);
            size++;
            return true;
        }
    }

    // Deletes a Patient by patientId
    public boolean deletePatient(long patientId) {
        int index = searchPatient(patientId);
        if (index != -1) {
            patientsList.remove(index);
            size--;
            return true;
        } else {
            return false;  // Patient not found  
        }
    }

    // Searches for a Patient by patientId  
    public int searchPatient(long patientId) {
        for (int i = 0; i < patientsList.size(); i++) {
            if (patientsList.get(i).getPatientId() == patientId) {
                return i;
            }
        }
        return -1;  // Not found  
    }

    // Returns true if patientsList is empty  
    public boolean isEmpty() {
        return patientsList.isEmpty();
    }

    // Returns the size of the patientsList
    public int listSize() {
        return size;
    }

    // Returns the Patient object at the specified index
    public Patient getPatient(int index) {
        if (index >= 0 && index < patientsList.size()) {
            return patientsList.get(index);
        } else {
            return null;  // Index out of bounds  
        }
    }

    // Accepts a Service object and adds it to servicesList  
    public void addService(Service service) {
        if (!servicesList.contains(service)) {
            servicesList.add(service);
        }
    }

    // Returns a Service object based on its ID
    public Service getService(String serviceId) {
        for (Service service : servicesList) {
            if (service.getServiceId().equals(serviceId)) {
                return service;
            }
        }
        return null;  // Not found  
    }

    // Prints details of a Patient including their medical history and services received
    public void printPatientDetails(long patientId) {
        int index = searchPatient(patientId);
        if (index != -1) {
            Patient patient = patientsList.get(index);
            System.out.println(patient);
            patient.printMedicalHistory();
            patient.printServicesReceived();
        } else {
            System.out.println("Patient not found.");
        }
    }

    // Print all patients in the patientsList  
    public void printPatientList() {
        if (patientsList.isEmpty()) {
            System.out.println("No patients registered.");
        } else {
            for (Patient patient : patientsList) {
                System.out.println(patient);
                System.out.println("---------------------------");
            }
        }
    }

    // Print all services in the servicesList  
    public void printServiceList() {
        if (servicesList.isEmpty()) {
            System.out.println("No services available.");
        } else {
            for (Service service : servicesList) {
                System.out.println(service);
                System.out.println("---------------------------");
            }
        }
    }
}