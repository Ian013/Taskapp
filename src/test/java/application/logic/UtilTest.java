package application.logic;

import application.logic.carriages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class UtilTest {

    protected Train train;

    @BeforeMethod
    public void setup(){
        train =  new Train(
        new FirstClassWagon(20,15),
        new SecondClassWagon(12,12),
        new FreightWagon(302),
        new RestaurantWagon(),
        new BaggageWagon(123));
    }

    @AfterMethod
    public void cleanUp(){
        train = null;
    }
}
