public class Passenger implements PassengerRequirements{
    
    //attributes
    private String name;
    private Car passengersCar;

    /**
     * constructor for passenger
     * @param name passenger's name
     */
    public Passenger(String name) {
        this.name = name;
        this.passengersCar = null;
    }

    /**
     * accessor for the passenger's name
     * @return passenger's name
     */ 
    public String getName(){
        return this.name;
    }

    /**
     * accessor for the passenger's car
     * @return passengersCar
     */
    public Car getPassengerCar(){
        return this.passengersCar;
    }


    /**
     * Lets a passenger board a Car c
     * calls on the addPassenger method from Car class
     * @param c Car
     */
    public void boardCar(Car c){
        if (c.addPassenger(this)){
            this.passengersCar = c;
            System.out.println(this.name + " has succesfully boarded!");
        } else {
            System.out.println(this.name + " has not sucessfully boarded the car");
        }
        return;
    }

   /**
    * Lets passenger leave a Car c
    * calls on removePassenger method from Car class
    * @param c Car
    */
    public void getOffCar(Car c) {
        if (c.removePassenger(this)){
            System.out.println(this.name + " has succesfully left!");
        }
    }

    /**
     * manipulator for the passenger's car
     * @param c the car the passenger is boarding
     */
    public void changeCar(Car c){
        this.passengersCar = c;
    }

    //main for testing
    public static void main(String[] args) {
        Car carOne = new Car(1);
        Passenger walter = new Passenger("Walter");
        Passenger susan = new Passenger("Susan");
        System.out.println("----walter is boarding....");
        walter.boardCar(carOne);
        carOne.printManifest();
        System.out.println("---susan is leaving...");
        susan.getOffCar(carOne);
        System.out.println("----Susan is boarding...");
        susan.boardCar(carOne);
        System.out.println("---walter is getting off...");
        walter.getOffCar(carOne);
        carOne.printManifest();
        System.out.println("----walter tries to get off again...");
        walter.getOffCar(carOne);
    }
}
