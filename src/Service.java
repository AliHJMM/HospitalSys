//Ali Hasan Jasim 202200428
//Habib Mansoor 202202669
//Mohamed A.Karim 202207430

public class Service {
    // Private Data Members
    private String serviceId;
    private String serviceName;
    private double cost;
    private int duration;

    // Default constructor
    public Service() {
        this.serviceId = "";
        this.serviceName = "";
        this.cost = 0.0;
        this.duration = 0;
    }
    // Constructor with parameters to inialize the data memebers with the given data in the parametar
    public Service(String serviceId, String serviceName, double cost, int duration) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.cost = cost;
        this.duration = duration;
    }

    // Getter and Setter Methods:

    //get method to return the service id
    public String getServiceId() {
        return serviceId;
    }
    //set method to set the service id
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    //get method to return the service name
    public String getServiceName() {
        return serviceName;
    }
    //set method to set the service name
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    //get the cost of the service
    public double getCost() {
        return cost;
    }
    // set the codt of the service
    public void setCost(double cost) {
        this.cost = cost;
    }
    // get the duration of the service 
    public int getDuration() {
        return duration;
    }
    // set the duration of the sercvice
    public void setDuration(int duration) {
        this.duration = duration;
    }

    // This Method Compares Two Services by their ID
    public boolean equals(Service otherService) {
        //check if the service is null , then return false
        if (otherService == null) {
            return false;
        }
        // return true if the service equalt to the otherService , otherwise return true
        return this.serviceId.equals(otherService.serviceId);
    }

    // This Method Returns Service Information to be Displayed.
    public String toString() {
        return "Service ID: " + serviceId +
                "\nService Name: " + serviceName +
                "\nCost: $" + cost +
                "\nDuration: " + duration + " minutes";
    }
}