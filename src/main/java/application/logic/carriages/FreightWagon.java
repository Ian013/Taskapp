package application.logic.carriages;

import application.logic.util.Baggage;

public class FreightWagon extends Wagon implements Baggage {
    {
        maxPassengers =reader.readIntProperty("FreightWagon.maxPassengers");
        maxWeight = reader.readIntProperty("FreightWagon.maxWeight");
        setComfortLevel(reader.readStringProperty("FreightWagon.Comfort"));
    }
    public FreightWagon(){

    }

    public FreightWagon(int baggage) {
        loadBaggage(baggage);
    }
    @Override
    public String toString(){
        return "A freight wagon, loaded: "+currentWeight+"/"+maxWeight;
    }

}
