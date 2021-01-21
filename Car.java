package assignment04;

import java.util.logging.*;

    /*
        Bradley Estus
        B00780491
        Assignment 04
     */

public class Car {

    private final Logger logObj = Logger.getLogger("Car");
    private Handler handler;

    private final int fuelEfficiency;
    private final double tankCapacity;
    private double gasInTank;
    private double milesDriven;

    /**
     * Constructor, 2 args
     * Initializes logger logObj with SimpleFormatter to Car.log
     * Prints possible exceptions to console:
     * SecurityException, IOException
     * @param fuelEfficiency fuel efficiency of this car, final int
     * @param tankCapacity fuel tank maximum capacity of this car, final double
     */
    public Car(int fuelEfficiency, double tankCapacity){
        this.fuelEfficiency = fuelEfficiency;
        this.tankCapacity = tankCapacity;
        try {
            handler = new FileHandler("Car.log");
            //SimpleFormatter produces plain text(as opposed to XML)
            handler.setFormatter(new SimpleFormatter());
            logObj.addHandler(handler);
            logObj.setLevel(Level.ALL);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Fetches the fuel efficiency
     * @return fuel efficiency, as int
     */
    public int getFuelEfficiency(){
        return fuelEfficiency;
    }

    /**
     * fetches the fuel tank capacity
     * @return fuel tank capacity, as double
     */
    public double getTankCapacity(){
        return tankCapacity;
    }

    /**
     * fetches the current fuel level
     * @return fuel level, as double
     */
    public double getGasInTank(){
        return gasInTank;
    }

    /**
     * Fetches the maximum number of miles the Car can drive,
     * given the current gasInTank and fuelEfficiency
     * @return the maximum possible travel distance, as double
     */
    public double maxMilesLeft(){
        return gasInTank*fuelEfficiency;
    }

    /**
     * Drives the Car for the specified number of miles,
     * or the maximum distance as found in maxMilesLeft
     * @param miles distance to be driven, double
     */
    public void drive(double miles) {
        double gallonsUsed = miles / fuelEfficiency;
        if (gallonsUsed <= gasInTank) {
            gasInTank -= gallonsUsed;
            logObj.info("Drove " + miles + " miles.");
            logObj.info("Used " + gallonsUsed + " gallons of gasoline.");
        } else {
            logObj.info("Drove " + maxMilesLeft() + " miles.");
            logObj.info("Used " + gasInTank + " gallons of gasoline.");
            logObj.info("Warning: ran out of gas.");
            gasInTank = 0.0;
        }
    }

    /**
     * Adds the specified amount of fuel to the Car, if possible
     * If not possible, excess is spilled
     * Throws IllegalArgumentException for excess fuel
     * @param gallons number of gallons of fuel to be added, double
     */
    public void addGas(double gallons){
        if(gasInTank+gallons<=tankCapacity){
            logObj.info("Added " + gallons + " gallons of gasoline.");
            gasInTank+=gallons;
        }else{
            double spill = (gallons+gasInTank) - tankCapacity;
            logObj.info("Added " + (tankCapacity-gasInTank) + " gallons of gasoline.");
            logObj.info("Warning: spilled " + spill + " gallons of gasoline.");
            gasInTank = tankCapacity;
            throw new IllegalArgumentException("Spilled " + spill + " gallons of gasoline");
        }
    }
}
