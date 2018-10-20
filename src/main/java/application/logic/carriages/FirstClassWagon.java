package application.logic.carriages;

public class FirstClassWagon extends Wagon {
    {
        maxPassengers = reader.readIntProperty("FirstClassWagon.maxPassengers");
        maxWeight = reader.readIntProperty("FirstClassWagon.maxWeight");
        setComfortLevel(reader.readStringProperty("FirstClassWagon.Comfort"));
    }

    public FirstClassWagon(){

    }

    public FirstClassWagon(int baggage) {
        loadBaggage(baggage);
    }
    public FirstClassWagon(int baggage, int passengers){
        loadBaggage(baggage);
        givePassengers(passengers);
    }

    @Override
    public String toString(){
        return "A first class wagon, passengers: "+currentPassengers+"/"
                + maxPassengers +", loaded: " + currentWeight+"/"+maxWeight;
    }

}
