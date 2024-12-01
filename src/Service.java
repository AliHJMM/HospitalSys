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
    // Constructor with parameters
    public Service(String serviceId, String serviceName, double cost, int duration) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.cost = cost;
        this.duration = duration;
    }

    // Getter and Setter Methods
    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    // This Method Compares Two Services by their ID
    public boolean equals(Service otherService) {
        if (otherService == null) {
            return false;
        }
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