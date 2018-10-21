package application.logic;
import application.logic.carriages.Wagon;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * A class, represents a train
 */
@SuppressWarnings("WeakerAccess")
public class Train {
    private static Logger log  = Logger.getLogger(Train.class);

    /**
     * List of wagons
     */
    private ArrayList<Wagon> wagons = new ArrayList<>();

    /**
     * A new empty train
     */
    public Train(){

    }

    /**
     * @return A list of wagons
     */
    public ArrayList<Wagon> getWagons() {
        return wagons;
    }

    /**
     * @param index of carriage
     * @return carriage with given index
     */
    public Wagon getWagonByIndex(int index){
        try{
            return wagons.get(index);
        }catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }

    /***
     * A train with pre-initialized wagons
     * @param cars wagons to add
     */
    public Train(Wagon... cars){
        addWagons(cars);
    }

    /***
     * A train with pre-initialized wagons
     * @param cars wagons to add
     */
    public Train(List<Wagon> cars){
        addWagons(cars);
    }

    /**
     * Loads baggage in the carriage with given index
     * @param index of car
     * @param weight of baggage
     */
    public void loadToWagon(int index, int weight){
        wagons.get(index).loadBaggage(weight);
    }

    /**
     * Sets amount of passengers in the car with given index
     * @param index of car
     * @param passengers quantity
     */
    public void givePassengersToWagen(int index, int passengers){
        wagons.get(index).givePassengers(passengers);
    }
    /**
     * @return Calculates current weight of baggage
     */
    public int calculateCurrentWeight(){
        int res=0;
        for(Wagon car: wagons){
            res+=car.getCurrentWeight();
        }
        return res;
    }

    /**
     * @return Calculates the biggest possible weight of baggage
     */
    public int calculateMaxWeight()
    {
        int res=0;
        for(Wagon car: wagons){
            res+=car.getMaxWeight();
        }
        return res;
    }
    /**
     * Calculates the biggest possible number of passengers in all wagons
     * @return maximal amount of passengers
     */
    public int calculateMaxPassengers(){
        int res =0;
        for(Wagon car : wagons){
            res +=car.getMaxPassengers();
        }
        return res;
    }

    /**
     * @return current quantity of passengers
     */
    public int calculateCurrentPassengers(){
        int res =0;
        for(Wagon car : wagons){
            res +=car.getCurrentPassengers();
        }
        return res;
    }

    /**
     * Sorts wagons by maximal weight of baggage
     */
    public void sortByMaxWeight(){
        wagons.sort(Comparator.comparingInt(Wagon::getMaxWeight));
    }

    /**
     * Sorts wagons by current weight of baggage
     */
    public void sortByCurrentWeight(){
        wagons.sort(Comparator.comparingInt(Wagon::getCurrentWeight));
    }

    /**
     * Sorts wagons by maximal amount of passengers
     */
    public void sortByMaxPassengers(){
        wagons.sort(Comparator.comparingInt(Wagon::getMaxPassengers));
    }

    /**
     *Sorts wagons by current amount of passengers
     */
    public void sortByCurrentPassengers(){
        wagons.sort(Comparator.comparingInt(Wagon::getCurrentPassengers));
    }

    /**
     *Sorts wagons by comfort
     */
    public void sortByComfort(){
        wagons.sort(Comparator.comparingInt(Wagon::getComfort));
    }

    /**Adds a new carriage to the train
     * @param car new carriage to be added
     */
    public void addWagon(Wagon car){
        car.setNumber(wagons.size()+1);
        wagons.add(car);
    }

    /**Adds a list of wagons to the train
     * @param cars new list to be added
     */
    public void addWagons(List<Wagon> cars){
        for(Wagon car:cars){
            car.setNumber(wagons.size()+1);
            addWagon(car);
        }
    }

    /**Adds an array of wagons to the train
     * @param cars new array to be added
     */
    public void addWagons(Wagon[] cars){
        for(Wagon car:cars){
            car.setNumber(wagons.size()+1);
            addWagon(car);
        }
    }

    public Wagon[] getWagonsByPassengers(int min, int max){
        ArrayList<Wagon> res = new ArrayList<>();
        for(Wagon wagon: wagons){
            if(wagon.getCurrentPassengers()>min&&wagon.getCurrentPassengers()<max){
                res.add(wagon);
            }
        }
        return res.toArray(new Wagon[0]);
    }

    public Wagon[] getWagonsByWeight(int min, int max){
        ArrayList<Wagon> res = new ArrayList<>();
        for(Wagon wagon: wagons){
            if(wagon.getCurrentWeight()>min&&wagon.getCurrentWeight()<max){
                res.add(wagon);
            }
        }
        return res.toArray(new Wagon[0]);
    }

    /**
     * @return length of train
     */
    public int getTrainLength(){
        return wagons.size();
    }

    public void shuffle(){
        Collections.shuffle(wagons);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return wagons.equals(train.wagons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wagons);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for(Wagon car: wagons) {
            res.append("Wagon №").append(car.getNumber()).append(" : ").append(car.toString()).append("\n");
        }
        return res.toString();
    }

}
