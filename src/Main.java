//Ali Hasan Jasim 202200428
//Habib Mansoor 202202669
//Mohamed A.Karim 202207430

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    // This Method Ensure Validated Input is an integer.
    public static int readInt(Scanner scanner, String prompt, int min, int max) {
        int value; // VAIRABLE TO STORE USER INPUT
        // WE DID INFINITE LOOP TO KEEP PROGRAM WORKING UNTIL USER ENTER VALID INPUT
        while (true) {
            System.out.print(prompt);
            try {
                // READ INTEGER FROM USER
                value = scanner.nextInt();
                scanner.nextLine();
                // CHECK IF THE INPUT IS WITHIN RANGE
                if (value >= min && value <= max) {
                    return value; // IF ITS WITHIN RANGE RETURN INPUT VALUE
                } else {
                    // IF INPUT IS NOT IN RANGE THEM PRINT MESSAGE SO USER ENTER VALID INPUT
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                }
            } catch (InputMismatchException e) {
                // IF INPUT NOT INTEGER THEN THROW A EXCEPTION
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine();
            }
        }
    }
    // This Method Ensure Validated Input is long.
    public static long readLong(Scanner scanner, String prompt, long min, long max) {
        long value; // VAIRABLE TO STORE USER INPUT
        // WE DID INFINITE LOOP TO KEEP PROGRAM WORKING UNTIL USER ENTER VALID INPUT
        while (true) {
            System.out.print(prompt);
            try {
                // READ LONG FROM USER
                value = scanner.nextLong();
                scanner.nextLine();
                // CHECK IF THE INPUT IS WITHIN RANGE
                if (value >= min && value <= max) {
                    return value; // IF ITS WITHIN RANGE RETURN INPUT VALUE
                } else {
                    // IF INPUT IS NOT IN RANGE THEM PRINT MESSAGE SO USER ENTER VALID INPUT
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                }
            } catch (InputMismatchException e) {
                // IF INPUT NOT LONG THEN THROW A EXCEPTION
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.nextLine();
            }
        }
    }
    // This Method Ensure Validated Input is Double.
    public static double readDouble(Scanner scanner, String prompt, double min, double max) {
        double value; // VAIRABLE TO STORE USER INPUT
        // WE DID INFINITE LOOP TO KEEP PROGRAM WORKING UNTIL USER ENTER VALID INPUT
        while (true) {
            System.out.print(prompt);
            try {
                // READ DOUBLE FROM USER
                value = scanner.nextDouble();
                scanner.nextLine();
                // CHECK IF THE INPUT IS WITHIN RANGE
                if (value >= min && value <= max) {
                    return value; // IF ITS WITHIN RANGE RETURN INPUT VALUE
                } else {
                    // IF INPUT IS NOT IN RANGE THEM PRINT MESSAGE SO USER ENTER VALID INPUT
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                }
            } catch (InputMismatchException e) {
                // IF INPUT NOT DOUBLE THEN THROW A EXCEPTION
                System.out.println("Invalid input. Please enter a decimal number.");
                scanner.nextLine();
            }
        }
    }
    // This Method Ensure Validated Input is either M for Male or F for Female.
    public static char readGender(Scanner scanner, String prompt) {
        // WE DID INFINITE LOOP TO KEEP PROGRAM WORKING UNTIL USER ENTER VALID INPUT
        while (true) {
            System.out.print(prompt);
            // READ STRING AND MAKE IT UPPERCASE
            String input = scanner.nextLine().trim().toUpperCase();
            // CHECK INPUT IF ITS EITHER M FOR MALE OR F FOR FEMALE
            if (input.length() == 1 && (input.charAt(0) == 'M' || input.charAt(0) == 'F')) {
                return input.charAt(0);
            } else {
//                PRINT MESSAGE IF ITS NOT EITHER M OR F
                System.out.println("Invalid input. Please enter 'M' or 'F'.");
            }
        }
    }
    // This Method Ensure Validated Input is not empty.
    public static String readNonEmptyString(Scanner scanner, String prompt) {
        // WE DID INFINITE LOOP TO KEEP PROGRAM WORKING UNTIL USER ENTER VALID INPUT
        while (true) {
            System.out.print(prompt);
//             // READ STRING AND TRIMMED
            String input = scanner.nextLine().trim();
//            IF THE USER INPUT IS NOT EMPTY THEN RETURN THE INPUT ITSELF
            if (!input.isEmpty()) {
                return input;
            } else {
                // IF ITS EMPTY THEN PRINT A ERROR MESSAGE
                System.out.println("Input cannot be empty. Please enter a valid value.");
            }
        }
    }
    // This Method Ensure Validated Input is an Email by using Regex to do some conditions.
    public static String readEmail(Scanner scanner, String prompt) {
//        WE USED REGEX FOR EMAIL INPUT SO WE MAKE SURE USER ENTER VALID EMAIL
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,}$";
        // COMPILE REGEX PATTERN
        Pattern pattern = Pattern.compile(emailRegex);
        // WE DID INFINITE LOOP TO KEEP PROGRAM WORKING UNTIL USER ENTER VALID INPUT
        while (true) {
            System.out.print(prompt);
            // READ INPUT AND TRIM ANY SPACE
            String email = scanner.nextLine().trim();
            // CHECK IF EMAIL MATCH THE REGEX
            // IF SO THEN RETURN VALID EMAIL
            if (pattern.matcher(email).matches()) {
                return email;
            } else {
                // IF IT DID NOT MATCH THE REGEX THEN PRINT ERROR MESSAGE AND ASK AGAIN
                System.out.println("Invalid email format. Please enter a valid email address.");
            }
        }
    }
    // This Method Ensure Validated Input is consist of letters only with no numbers.
    public static String readName(Scanner scanner, String prompt) {
        // WE USED REGEX FOR NAME INPUT SO WE MAKE SURE USER ENTER VALID INPUT ONLY LETTERS
        String nameRegex = "^[a-zA-Z]+$";
        // COMPILE REGEX PATTERN
        Pattern pattern = Pattern.compile(nameRegex);
        // WE DID INFINITE LOOP TO KEEP PROGRAM WORKING UNTIL USER ENTER VALID INPUT
        while (true) {
            System.out.print(prompt);
            // READ INPUT AND TRIM ANY SPACE
            String name = scanner.nextLine().trim();
            // CHECK IF INPUT MATCH THE REGEX
            // IF SO THEN RETURN VALID NAME
            if (pattern.matcher(name).matches()) {
                return name;
            } else {
                // IF IT DID NOT MATCH THE REGEX THEN PRINT ERROR MESSAGE AND ASK AGAIN
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
            System.out.println("10. Count Total Patients");
            System.out.println("11. Count Total Services");
            System.out.println("12. View Total Revenue");
            System.out.println("13. Reset System");
            System.out.println("14. Exit");

            // Read user choice from main menu.
            int choice = readInt(scanner, "Please select an option (1-14): ", 1, 14);

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
                    // Count Total Patients
                    System.out.println("Total number of patients: " + hospital.getTotalPatients());
                    break;

                case 11:
                    // Count Total Services
                    System.out.println("Total number of services: " + hospital.getTotalServices());
                    break;

                case 12:
                    // View Total Revenue
                    System.out.println("Total revenue generated: $" + hospital.calculateTotalRevenue());
                    break;

                case 13:
                    // Reset the System
                    System.out.print("Are you sure you want to reset the system? (yes/no): ");
                    String confirm = scanner.nextLine().trim().toLowerCase();
                    if (confirm.equals("yes")) {
                        hospital.resetSystem();
                        System.out.println("System has been reset.");
                    } else {
                        System.out.println("Reset cancelled.");
                    }
                    break;

                case 14:
                    // Exit the program
                    exit = true;
                    System.out.println("Exiting Hospital Management System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please select a number between 1 and 14.");
            }

            System.out.println();  // Blank Line for better readability in terminal.
        }

        scanner.close();
    }
}
