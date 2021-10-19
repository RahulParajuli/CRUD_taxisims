 
//Question(no.1)
public class TaxiService {
    //taxiServices attributes.
    public String taxiDriver,passengerName,passengerCountry;
    public String hireDate, passengerDestination;
    public int noOfDays;
    public double dailyRate,downPayment;
    public boolean availableStatus;

//Question(no.2) supplying the constructor to the parameters.
    public TaxiService(String taxiDriver, double dailyRate) {
        this.taxiDriver = taxiDriver;
        this.dailyRate = dailyRate;
        this.passengerName = "";
        this.passengerCountry = "";
        this.passengerDestination = "";
        this.hireDate = "";
        this.noOfDays = 0;
        this.downPayment = 0.0;
        this.availableStatus = true;
    }

//Question(no.3) methods for returning.
    public String gettaxiDriver() { return taxiDriver; }
    public String getpassengerName() {return passengerName; }
    public String getpassengerCountry() { return passengerCountry; }
    public String gethireDate() { return hireDate; }
    public String getpassengerDestination() { return passengerDestination; }
    public int getnoOfDays() { return noOfDays; }
    public double getdailyRate() { return dailyRate; }
    public double getdownPayment() { return downPayment; }
    public boolean isavailableStatus() { return availableStatus; }

//Question(no.4) defining the new method for daily rate and durations.
    public void setdailyRate(double dailyRate) { this.dailyRate= dailyRate; }
    public void setpassengerDestination(String passengerDestination) { this.passengerDestination= passengerDestination; }

// Question(n0.5) creating the methods to all the customer to book the taxi services.
    public void bookTaxiService(String passengerName, String passengerCountry, String hireDate, String passengerDestination, int noOfDays, double downPayment) {
        //checking weather the taxi services are available or not.
        if (availableStatus==false) {
            System.out.println(" OOps!!!SORRY!!!  "+this.gettaxiDriver()+" The TAXISERVICE is not available,please try after " + this.noOfDays + " days");
        } else {
            this.passengerName = passengerName;
            this.passengerCountry = passengerCountry;
            this.hireDate = hireDate;
            this.passengerDestination = passengerDestination;
            this.noOfDays = noOfDays;
            this.downPayment = downPayment;
            this.availableStatus = false;
            System.out.println("####################--THE BOOKING DETAILS--######################");
            System.out.println("TAXIDRIVER           :" + this.taxiDriver);
            System.out.println("NAME OF PASSENGER    :" + this.getpassengerName());
            System.out.println("PASSENGER COUNTRY    :" + this.getpassengerCountry());
            System.out.println("Hire date            :" + this.gethireDate());
            System.out.println("PASSENGER DESTINATION:" + this.getpassengerDestination());
            System.out.println("NO OF DAYS           :" + this.getnoOfDays());
            System.out.println("DOWN PAYMENT         :" + this.getdownPayment());
        }
    }

    //Question(no.6) methods for making taxi service available.
    public void taxiServiceAvailable() {
        if (availableStatus==true) {
            System.out.println("THE TAXI DRIVER IS FREE!!!!");
        } else {
            this.passengerName = "";
            this.passengerCountry = "";
            this.passengerDestination = "";
            this.hireDate = "";
            this.noOfDays = 0;
            this.downPayment = 0.0;
            this.availableStatus = true;
        }
    }
    public void taxiDriverDetail(){
            System.out.println("Taxi Driver: " + this.gettaxiDriver());
            System.out.println("Daily  Rate: " + this.getdailyRate());
            System.out.println(">>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println("TaxiDriver Name" + "    Passenger Name" + "    DailyRate");
            System.out.println(this.gettaxiDriver() +"          "+ this.getpassengerName() +"          "+ this.getdailyRate());

        }

//Question(no.7) methods for displaying the drivers name and along with the passenger information.
    public static void main(String[] args){
        TaxiService td1=new TaxiService ("Raul Parajuli",430.50);
        TaxiService td2=new TaxiService ("Dinesh Pariar" ,460.50);
        TaxiService td3=new TaxiService ("Rupesh Thakur",430.50);
        TaxiService td4=new TaxiService ("Ashok Tamang"  ,460.50);
        td1.bookTaxiService("Nuria",  "Spain",   "10/7/2020", "Chitwan",   6, 600.0);System.out.println("");
        td1.taxiDriverDetail();
        td2.bookTaxiService("Lluisa", "Mexico",  "10/8/2020", "Pokhara",   10,400.0);System.out.println("");
        td2.taxiDriverDetail();
        td3.bookTaxiService("Javier", "Portugal","10/9/2020", "Biratnagar",5, 800.0);System.out.println("");
        td3.taxiDriverDetail();
        td4.bookTaxiService("Gustavo","France",  "10/10/2020","Lumbini",   7, 500.0);
        td4.taxiDriverDetail();
        System.out.println("");
        System.out.println("");
        td1.bookTaxiService("Pablo","Germany",  "10/11/2020","Manang",   5, 900.0);

    }
}









