package application.logic.carriages;

import application.logic.util.Baggage;


public class BaggageWagon extends Wagon implements Baggage {

    {
        setComfortLevel(reader.readStringProperty("BaggageWagon.Comfort"));
        maxWeight = reader.readIntProperty("BaggageWagon.maxWeight");
        maxPassengers= reader.readIntProperty("BaggageWagon.maxPassengers");
    }
    public BaggageWagon(){

    }
    public BaggageWagon(int baggage) {
        loadBaggage(baggage);
    }

    @Override
    public String toString(){
        return "A baggage wagon, loaded: " + currentWeight+"/"+maxWeight;
    }

}
