package application.logic.carriages;

import application.logic.util.Baggage;
import application.logic.util.ComfortLevel;
import application.data.PropertiesReader;
import org.apache.log4j.Logger;

import java.security.InvalidParameterException;
import java.util.Objects;

/**
 * An abstract class, represents a wagon
 */
@SuppressWarnings("WeakerAccess")
public abstract class Wagon {
    protected static Logger log = Logger.getLogger(Wagon.class);

    protected final static String PATH = "src\\main\\resources\\config.properties";

    protected static PropertiesReader reader = new PropertiesReader(PATH);

    protected int maxPassengers;
    protected int maxWeight;

    protected int currentPassengers = 0;
    protected int currentWeight=0;

    protected  int number =0;

    protected ComfortLevel comfortLevel;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public int getCurrentPassengers() {
        return currentPassengers;
    }

    public int getMaxPassengers(){
        return maxPassengers;
    }


    /**
     * @param weight to load
     */
    public void loadBaggage(int weight){
        try{
            if(weight>this.maxWeight){
                throw new InvalidParameterException("An exception: Weight of baggage is more than maximum!");
            }else{
                this.currentWeight = weight;
                }
            }catch(InvalidParameterException e){
            log.error(e.getMessage());
        }
    }

    /**
     * @param passengers amount of passengers to give
     */
    public void givePassengers(int passengers){
        try{
        if(this instanceof Baggage){
            throw new UnsupportedOperationException("An exception: There is no passengers in this type of a carriage!");
        }
        if(passengers>this.maxPassengers ){
            throw new InvalidParameterException("An exception: Amount of passengers is more than maximum!");
        }else{
            currentPassengers = passengers;
        }
        }catch (UnsupportedOperationException | InvalidParameterException e1){
            log.error(e1.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wagon wagon = (Wagon) o;
        return currentPassengers == wagon.currentPassengers &&
                maxPassengers == wagon.maxPassengers &&
                maxWeight == wagon.maxWeight &&
                currentWeight == wagon.currentWeight &&
                comfortLevel == wagon.comfortLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentPassengers, maxPassengers, maxWeight, currentWeight, comfortLevel,number);
    }

    /**
     * @return numeric value of wagons comfort
     */
    public int getComfort(){
        switch (comfortLevel){
            case RESTAURANT: return -1;
            case FIRST_CLASS: return 0;
            case SECOND_CLASS: return 1;
            case THIRD_CLASS: return 2;
            case BAGGAGE: return 3;
            default:
                throw new UnknownError();
        }
    }

    protected void setComfortLevel(String level){
        switch (level.toUpperCase()){
            case "RESTAURANT":
                comfortLevel = ComfortLevel.RESTAURANT;
            break;
            case "FIRST_CLASS":
                comfortLevel = ComfortLevel.FIRST_CLASS;
            break;
            case "SECOND_CLASS":
                comfortLevel = ComfortLevel.SECOND_CLASS;
            break;
            case "THIRD_CLASS":
                comfortLevel = ComfortLevel.THIRD_CLASS;
            break;
            case "BAGGAGE":
                comfortLevel = ComfortLevel.BAGGAGE;
            break;
            default:
                throw new UnknownError();
        }
    }

}

