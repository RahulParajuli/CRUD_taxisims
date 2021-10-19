import  java.util.ArrayList;
import java.util.Collections;

//Qno.8
/* implementing the Class by creating new class TaxiCompany with the attribute in
an array list of object of the previous taxiService class */
public class TaxiCompany {
    private ArrayList<TaxiService>taxiDriver=new ArrayList<TaxiService>();
    //forming an array.


//Qno.9
/* Creating new method and adding a new objects of previous class to the list.
 */
public void addTaxiDriverObject(){
    taxiDriver.add(new TaxiService("Hari Sapkota",750));
    taxiDriver.add(new TaxiService("Lakpa Sherpa",700));
    taxiDriver.add(new TaxiService("Jiban Dani",350));
    taxiDriver.add(new TaxiService("Khemraj Bogati",550));
    }

//Qno.10
/*thw method for removing the objects from the array list.
 */
public void removeTaxiDriverObject(){
    try {
        taxiDriver.remove(0);//removes the data from  the array list.
    }
    catch(IndexOutOfBoundsException e)
    {
        System.out.println("invalid index try again....");
    }
}

//Qno.11
/* new method for booking/hiring or storing records of the passenger
of the taxi service.*/
    public void recordsOfPassenger(int index, String passengerName, String passengerCountry,String hireDate, String passengerDestination,int noOfDays, float downPayment)
    {
        try{
            TaxiService tds= this.taxiDriver.get(index);
            tds.bookTaxiService(passengerName,passengerCountry,passengerCountry,passengerDestination,noOfDays,downPayment);
        }catch(IndexOutOfBoundsException e){
            System.out.println("the taxi driver do not exist");
        }
    }
    public void makeTaxiServiceAvailable(int index){
        try{
            TaxiService tds =this.taxiDriver.get(index);
            tds.taxiServiceAvailable();
        }catch(IndexOutOfBoundsException exception){
            System.out.println("the taxi driver do not exist");
        }
    }



 //Qno.12
 /*methods for making taxi service available */

    public void displayAvailableTaxiService(){
        for (TaxiService tds : taxiDriver ){
            if (tds.isavailableStatus()){
                System.out.println("Tour guide Details :" +taxiDriver.indexOf(tds));
                tds.taxiDriverDetail();
            }
        }
    }


 //Q.no 13 & 14
    public void displayBookedTourGuidesInAscending() {
        Collections.reverse(taxiDriver); //this is to show the list in ascending order
        for(TaxiService tds : taxiDriver) {
            if(tds.isavailableStatus()==false) {
                System.out.println(tds.getpassengerName());
                tds.taxiDriverDetail();
            }
        }
    }

    public static void main(String[] args) {


    }


}


