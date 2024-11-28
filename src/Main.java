import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    // Helper methods for input validation

    public static int readInt(Scanner scanner, String prompt, int min, int max) {
        int value;
        while (true) {
            System.out.print(prompt);
            try {
                value = scanner.nextInt();
                scanner.nextLine(); // consume the newline character
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine(); // consume the invalid input
            }
        }
    }

    public static long readLong(Scanner scanner, String prompt, long min, long max) {
        long value;
        while (true) {
            System.out.print(prompt);
            try {
                value = scanner.nextLong();
                scanner.nextLine(); // consume the newline character
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.nextLine(); // consume the invalid input
            }
        }
    }

    public static double readDouble(Scanner scanner, String prompt, double min, double max) {
        double value;
        while (true) {
            System.out.print(prompt);
            try {
                value = scanner.nextDouble();
                scanner.nextLine(); // consume the newline character
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a decimal number.");
                scanner.nextLine(); // consume the invalid input
            }
        }
    }

    public static char readGender(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.length() == 1 && (input.charAt(0) == 'M' || input.charAt(0) == 'F')) {
                return input.charAt(0);
            } else {
                System.out.println("Invalid input. Please enter 'M' or 'F'.");
            }
        }
    }

    public static String readNonEmptyString(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println("Input cannot be empty. Please enter a valid value.");
            }
        }
    }


    public static String readEmail(Scanner scanner, String prompt) {
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        while (true) {
            System.out.print(prompt);
            String email = scanner.nextLine().trim();
            if (pattern.matcher(email).matches()) {
                return email;
            } else {
                System.out.println("Invalid email format. Please enter a valid email address.");
            }
        }
    }


    public static String readName(Scanner scanner, String prompt) {
        String nameRegex = "^[a-zA-Z]+$";
        Pattern pattern = Pattern.compile(nameRegex);
        while (true) {
            System.out.print(prompt);
            String name = scanner.nextLine().trim();
            if (pattern.matcher(name).matches()) {
                return name;
            } else {
                System.out.println("Invalid input. Name must contain only letters.");
            }
        }
    }

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
            System.out.println("6. Add Medical History to Patient");
            System.out.println("7. Add Service to Patient");
            System.out.println("8. View All Patients");
            System.out.println("9. View All Services");
            System.out.println("10. Exit");
            int choice = readInt(scanner, "Please select an option (1-10): ", 1, 10);

            switch (choice) {
                case 1:
                    // Add New Patient
                    long patientId = readLong(scanner, "Enter Patient ID: ", 1, Long.MAX_VALUE);
                    String firstName = readName(scanner, "Enter First Name: ");
                    String lastName = readName(scanner, "Enter Last Name: ");
                    char gender = readGender(scanner, "Enter Gender (M/F): ");
                    String email = readEmail(scanner, "Enter Email: ");

                    Patient newPatient = new Patient(patientId, firstName, lastName, gender, email);
                    if (hospital.addPatient(newPatient)) {
                        System.out.println("Patient added successfully.");
                    } else {
                        System.out.println("Patient already exists.");
                    }
                    break;

                case 2:
                    // Remove Patient
                    long removeId = readLong(scanner, "Enter Patient ID to remove: ", 1, Long.MAX_VALUE);
                    if (hospital.deletePatient(removeId)) {
                        System.out.println("Patient removed successfully.");
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 3:
                    // View Patient Details
                    long viewId = readLong(scanner, "Enter Patient ID to view details: ", 1, Long.MAX_VALUE);
                    hospital.printPatientDetails(viewId);
                    break;

                case 4:
                    // Search for a Patient
                    long searchId = readLong(scanner, "Enter Patient ID to search: ", 1, Long.MAX_VALUE);
                    int index = hospital.searchPatient(searchId);
                    if (index != -1) {
                        System.out.println("Patient found at index: " + index);
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 5:
                    // Add Medical Service
                    String serviceId = readNonEmptyString(scanner, "Enter Service ID: ");
                    String serviceName = readNonEmptyString(scanner, "Enter Service Name: ");
                    double cost = readDouble(scanner, "Enter Cost: ", 0, Double.MAX_VALUE);
                    int duration = readInt(scanner, "Enter Duration (minutes): ", 0, Integer.MAX_VALUE);

                    Service newService = new Service(serviceId, serviceName, cost, duration);
                    hospital.addService(newService);
                    System.out.println("Service added successfully.");
                    break;

                case 6:
                    // Add Medical History to Patient
                    long patIdMH = readLong(scanner, "Enter Patient ID: ", 1, Long.MAX_VALUE);
                    Patient patientMH = hospital.getPatient(hospital.searchPatient(patIdMH));

                    if (patientMH != null) {
                        String medicalRecord = readNonEmptyString(scanner, "Enter Medical History Record: ");
                        patientMH.getMedicalHistory().add(medicalRecord);
                        System.out.println("Medical history added to patient.");
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 7:
                    // Add Service to Patient
                    long patientIdInput = readLong(scanner, "Enter Patient ID: ", 1, Long.MAX_VALUE);
                    String serviceIdInput = readNonEmptyString(scanner, "Enter Service ID: ");

                    Patient patientToUpdate = hospital.getPatient(hospital.searchPatient(patientIdInput));
                    Service serviceToAdd = hospital.getService(serviceIdInput);

                    if (patientToUpdate != null && serviceToAdd != null) {
                        patientToUpdate.getServicesReceived().add(serviceToAdd);
                        System.out.println("Service added to the patient's record successfully.");
                    } else {
                        if (patientToUpdate == null) {
                            System.out.println("Patient with ID " + patientIdInput + " not found.");
                        }
                        if (serviceToAdd == null) {
                            System.out.println("Service with ID " + serviceIdInput + " not found.");
                        }
                    }
                    break;

                case 8:
                    // View All Patients
                    hospital.printPatientList();
                    break;

                case 9:
                    // View All Services
                    hospital.printServiceList();
                    break;

                case 10:
                    // Exit
                    exit = true;
                    System.out.println("Exiting Hospital Management System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please select a number between 1 and 10.");
            }

            System.out.println();  // Add a blank line for readability
        }

        scanner.close();
    }
}
