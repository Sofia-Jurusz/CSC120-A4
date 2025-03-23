import java.util.ArrayList;
public class Car implements CarRequirements{

    //Attributes
    private int capacity;
    private int seatsRemaining;
    private ArrayList<Passenger> manifest;  
    
    /**
     * Constructor for Car
     * @param capacity Car's total seats 
     */
    public Car(int capacity){ 
        this.capacity = capacity;
        this.manifest = new ArrayList<Passenger>(capacity);
        this.seatsRemaining = capacity;
        

    }

    /**
     * Accessor for a given Car's capacity
     * @return capacity how many Passengers the car can hold
     */
    public int getCapacity(){
        return this.capacity;
    }

    /**
     * Accessor for the Car's seats remaining
     * @return seatsRemaining The spaces a Passenger could still occupy
     */
    public int seatsRemaining(){
        return this.seatsRemaining;
    }

    /**
     * Adds a passenger to the car if there is room and they are not already on a car
     * @param p the Passenger that wants to be added
     * @return True if the addition was succesful
     * @return False if the addition was unsuccesful
     */
    public Boolean addPassenger(Passenger p){
        if (null == p.getPassengerCar()){
            this.manifest.add(p);
            this.seatsRemaining = this.seatsRemaining - 1;
            return true;
        } else if(this == p.getPassengerCar()){
            System.out.println(p.getName() + " is already on this car!");
            return false;
        } else{
            System.out.println(p.getName()+" is on a different car");
            return false;
        }
    }

    /**
     * Removes a Passenger from a car if they are already on the car
     * @param p the Passenger that wants to be removed
     * @return True if the removing was succesful
     * @return False if the removing was unsuccesful
     */
    public Boolean removePassenger(Passenger p){
        int Manifest_size = this.manifest.size();
        if (Manifest_size == 0) {
            System.out.println("This car is empty! There is no one to remove!");
            return false;
        }
        else {
            for (int i = 0; i < Manifest_size; i++) {
                if (p == this.manifest.get(i)){
                    this.manifest.remove(p);
                    this.seatsRemaining = this.seatsRemaining + 1;
                    return true;
                }   
            }
            System.out.println(p.getName()+ " is not on this car!");
            return false;       
         }
    }

    /**
     * prints the manifest of the car, which contains a list of Passengers on board
     */
    public void printManifest(){
        if (this.manifest.size() == 0){
            System.out.println("This car is empty!");
            return;
        }
        System.out.println("****");
        for (int i = 0; i < this.manifest.size(); i++){
            Passenger passenger = this.manifest.get(i);
            String name = passenger.getName();
            System.out.println(name);
        }
        System.out.println("****");
    }

    //main for testing
    public static void main(String[] args) {
        Car myCar = new Car(10);
        Passenger sofia = new Passenger("Sofia");
        System.out.println("This is an empty car");
        System.out.println("Capacity: "+ myCar.getCapacity());
        System.out.println("Seats Remaining: " + myCar.seatsRemaining());
        myCar.printManifest();

        System.out.println("Now we are adding a passenger: "+ sofia.getName());
        myCar.addPassenger(sofia);
        System.out.println("Capacity: "+ myCar.getCapacity());
        System.out.println("Seats Remaining: " + myCar.seatsRemaining());
        myCar.printManifest();

        Passenger cleo = new Passenger("Cleo");
        System.out.println("Now we are adding a passenger: "+ cleo.getName());
        myCar.addPassenger(cleo);
        System.out.println("Capacity: "+ myCar.getCapacity());
        System.out.println("Seats Remaining: " + myCar.seatsRemaining());
        myCar.printManifest();

        System.out.println("Sofia is going to leave the train");
        myCar.removePassenger(sofia);
        System.out.println("Capacity: "+ myCar.getCapacity());
        System.out.println("Seats Remaining: " + myCar.seatsRemaining());
        myCar.printManifest();

        Passenger maya = new Passenger("Maya");
        System.out.println("Maya is going to leave the train");
        System.out.println(myCar.removePassenger(maya));

        System.out.println("Cleo is getting on the train");
        System.out.println(myCar.addPassenger(cleo));
    }

}