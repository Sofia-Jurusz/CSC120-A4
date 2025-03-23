public class Engine implements EngineRequirements{

    //Attributes
    private FuelType f;
    private double currentFuel;
    private double maxFuel;

    /**
     * Constructor for Engine
     * @param f Engine's fuel level
     * @param currentFuel Engine's current fuel level
     * @param maxFuel Engine's max fuel level
     */
    public Engine(FuelType f, double currentFuel, double maxFuel){
        this.f = f;
        this.currentFuel = currentFuel;
        this.maxFuel = maxFuel;

    }
    /**
     * Accessor for fuel type
     * @return f This engine's fuel type
     */
    public FuelType getFuelType() {
        return this.f;
    }

    /**
     * Accessor for max fuel level
     * @return maxFuellevel This engine's fuel level
     */
    public double getMaxFuel(){
        return this.maxFuel;
    }
    
    /**
     * Accessor for current fuel level
     * @return currentFuellevel This engine's current fuel level
     */
    public double getCurrentFuel(){
        return this.currentFuel;
    }

    /**
     * Refuels the car by updating it's current fuel to it's max fuel
     */
    public void refuel(){
        this.currentFuel = this.maxFuel;
    }

    /**
     * Subtracts one from the current fuel as long as the tank is not empty
     * @return False if the removal was uncessesful
     * @return True if the removal was successful
     */
    public Boolean go(){
        if (this.currentFuel == 0) {
            System.out.println("Tank is empty! We need to refuel!");
            return false;
        }
        else {
            this.currentFuel = this.currentFuel - 1;
            System.out.println("Choo Choo!!");
            return true;
        }
        
    }

    /**
     * @return a string containing the engine's fuel type, current fuel level, and max fuel level
     */
    public String toString(){
        return ("Fuel Type: "+ this.f + "; Current Fuel Level: "+ this.currentFuel+"; Max Fuel Level:" + this.maxFuel);
    }

    //Main for testing
    public static void main(String[] args) {
        System.out.println("welcome to my train");
        Engine myEngine = new Engine (FuelType.ELECTRIC, 0., 100.);
        
        System.out.println("Here is some information");
        System.out.println("Fuel type: " + myEngine.getFuelType());
        System.out.println("Max FUel: " + myEngine.getMaxFuel());
        System.out.println("Current Fuel: " + myEngine.getCurrentFuel());
        System.out.println("lets refuel");
        myEngine.refuel();
        System.out.println(myEngine.getMaxFuel());
        System.out.println(myEngine.getCurrentFuel());
        System.out.println("lets go somewhere");
        System.out.println(myEngine.go());
        System.out.println(myEngine.getCurrentFuel());

    }
}