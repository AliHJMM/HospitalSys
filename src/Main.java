import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hospital hospital = new Hospital();
        boolean exit = false;

        while (!exit) {
            // Display Menu
            System.out.println("====== Hospital Management System ======");
            System.out.println("1. Add New Patient");
            System.out.println("2. Remove Patient");
            System.out.println("3. View Patient Details");
            System.out.println("4. Search for a Patient");
            System.out.println("5. Add Medical Service");
            System.out.println("6. Add Service to Patient");
            System.out.println("7. View All Patients");
            System.out.println("8. View All Services");
            System.out.println("9. Exit");
            System.out.print("Please select an option (1-9): ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Add New Patient
                    System.out.print("Enter Patient ID: ");
                    long patientId = scanner.nextLong();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter Gender (M/F): ");
                    char gender = scanner.nextLine().charAt(0);
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    Patient newPatient = new Patient(patientId, firstName, lastName, gender, email);
                    if (hospital.addPatient(newPatient)) {
                        System.out.println("Patient added successfully.");
                    } else {
                        System.out.println("Patient already exists.");
                    }
                    break;

                case 2:
                    // Remove Patient
                    System.out.print("Enter Patient ID to remove: ");
                    long removeId = scanner.nextLong();
                    if (hospital.deletePatient(removeId)) {
                        System.out.println("Patient removed successfully.");
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 3:
                    // View Patient Details
                    System.out.print("Enter Patient ID to view details: ");
                    long viewId = scanner.nextLong();
                    hospital.printPatientDetails(viewId);
                    break;

                case 4:
                    // Search for a Patient
                    System.out.print("Enter Patient ID to search: ");
                    long searchId = scanner.nextLong();
                    int index = hospital.searchPatient(searchId);
                    if (index != -1) {
                        System.out.println("Patient found at index: " + index);
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 5:
                    // Add Medical Service
                    System.out.print("Enter Service ID: ");
                    String serviceId = scanner.nextLine();
                    System.out.print("Enter Service Name: ");
                    String serviceName = scanner.nextLine();
                    System.out.print("Enter Cost: ");
                    double cost = scanner.nextDouble();
                    System.out.print("Enter Duration (minutes): ");
                    int duration = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    Service newService = new Service(serviceId, serviceName, cost, duration);
                    hospital.addService(newService);
                    System.out.println("Service added successfully.");
                    break;

                case 6:
                    // Add Service to Patient
                    System.out.print("Enter Patient ID: ");
                    long patId = scanner.nextLong();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Service ID: ");
                    String servId = scanner.nextLine();

                    Patient patient = hospital.getPatient(hospital.searchPatient(patId));
                    Service service = hospital.getService(servId);

                    if (patient != null && service != null) {
                        patient.getServicesReceived().add(service);
                        System.out.println("Service added to patient.");
                    } else {
                        System.out.println("Patient or Service not found.");
                    }
                    break;

                case 7:
                    // View All Patients
                    hospital.printPatientList();
                    break;

                case 8:
                    // View All Services
                    hospital.printServiceList();
                    break;

                case 9:
                    // Exit
                    exit = true;
                    System.out.println("Exiting Hospital Management System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please select a number between 1 and 9.");
            }

            System.out.println();  // Add a blank line for readability
        }

        scanner.close();
    }
}