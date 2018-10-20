package application.logic.carriages;

public class RestaurantWagon extends Wagon {
    {
        maxPassengers = 0;
        maxWeight = 0;
        setComfortLevel(reader.readStringProperty("Restaurant.Comfort"));
    }
    public RestaurantWagon(){

    }
    @Override
    public String toString(){
        return "A restaurant wagon ";
    }
}

