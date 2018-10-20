package application.logic.carriages;

public class SecondClassWagon extends Wagon {
    {
        maxPassengers = reader.readIntProperty("SecondClassWagon.maxPassengers");
        maxWeight = reader.readIntProperty("SecondClassWagon.maxWeight");
        setComfortLevel(reader.readStringProperty("SecondClassWagon.Comfort"));
    }

    public SecondClassWagon(){

    }
    public SecondClassWagon(int baggage) {
        loadBaggage(baggage);
    }

    public SecondClassWagon(int baggage, int passengers){
        loadBaggage(baggage);
        givePassengers(passengers);
    }

    @Override
    public String toString(){
        return "A second class wagon,passengers: "+currentPassengers+
                "/" +
                maxPassengers +", loaded: " +
                currentWeight+"/"+maxWeight;
    }
}
