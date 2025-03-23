import java.util.ArrayList;
public class Train implements TrainRequirements{

    //Attributes
    private ArrayList<Car> cars;
    private Engine engine;
    private int maxCapacity;
    private String trainsName;


    /**
     * Constructor for Train Class
     * @param fuelType Train's engine's fuel type
     * @param fuelCapacity Train's engine's fuel capacity
     * @param nCars Train's number of cars
     * @param maxCapacity the amount of passengers each car can hold
     * @param trainsName the name of the train
     */
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int maxCapacity, String trainsName){
        this.engine = new Engine(fuelType,0,fuelCapacity); 
        this.cars = new ArrayList<Car>();
        this.trainsName = trainsName;
        this.maxCapacity = maxCapacity;
        for (int i = 0; i <nCars; i++){
            Car newCar = new Car(maxCapacity);
            cars.add(newCar);
        }
    }

    /**
     * Accessor for information about the Train's engine
     * @return engine information about the engine's fuel type, current fuel level, and max fuel level
     */
    public Engine getEngine(){
        return this.engine;
    }

   /**
    * Accessor for a Train car at a specific index
    * @param i index of the Car that wants to be accessed
    * @return the car located at index i
    */
    public Car getCar(int i){
        return this.cars.get(i);
    }

    /**
     * Accessor for the total amount of passengers a train can hold
     * multiplies the amount of cars by the capacity of each
     * @return Maximum capacity
     */
    public int getMaxCapacity(){
        return cars.size() * maxCapacity;
    }
    
    /**
     * Accessor for the total seats left
     * adds the empty seats from each car in the Train
     * @return seatsRemaining how many open seats
     */
    public int seatsRemaining(){
        int seatsRemaining = 0;
        for (int i = 0; i < cars.size();i++){
            seatsRemaining = seatsRemaining+ cars.get(i).seatsRemaining();
        }
        return seatsRemaining;
    }

    /**
     * Prints the Manifest of the entire train by printing out the manifest for each car
     */
    public void printManifest(){
        System.out.println(this.trainsName +"'s Manifest");
        System.out.println("----------------------------");
        for (int i = 0; i < cars.size();i++){
            System.out.println("Car " + i +":");
            cars.get(i).printManifest();
        }
    }

    //main for testing
    public static void main(String[] args) {
        System.out.println("       ");
        Train amtrak = new Train(FuelType.ELECTRIC,200,5,4,"Amtrak Valley Flier");
        System.out.println(amtrak.getEngine());
        Car carTwo = amtrak.getCar(1);
            Passenger sofia = new Passenger("Sofia");
            carTwo.addPassenger(sofia);
            Passenger maya = new Passenger("Maya");
            carTwo.addPassenger(maya);

            Passenger walter = new Passenger("Walter");
            carTwo.addPassenger(walter);

            Passenger susan = new Passenger("Susan");
            carTwo.addPassenger(susan);

        Car carOne = amtrak.getCar(0);

            Passenger kate = new Passenger("Kate");
            carOne.addPassenger(kate);

            Passenger cleo = new Passenger("Cleo");
            carOne.addPassenger(cleo);

        System.out.println("Lucy, Annika, and Catherine are borading Car 4:");
        Car carFive = amtrak.getCar(4);

            Passenger lucy = new Passenger("Lucy");
            lucy.boardCar(carFive);

            Passenger annika = new Passenger("Annika");
            annika.boardCar(carFive);

            Passenger catherine = new Passenger("Catherine");
            catherine.boardCar(carFive);


        System.out.println("seats remaining: "+amtrak.seatsRemaining());
        System.out.println("max capacity: "+amtrak.getMaxCapacity());
        amtrak.printManifest();

        System.out.println();
        System.out.println("Catherine wants to board car 1 instead....");
        catherine.boardCar(carOne);

        System.out.println("seats remaining: "+amtrak.seatsRemaining());
        System.out.println("max capacity: "+amtrak.getMaxCapacity());
        amtrak.printManifest();
    }


}
