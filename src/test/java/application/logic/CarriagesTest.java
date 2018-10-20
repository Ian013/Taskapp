package application.logic;

import application.data.PropertiesReader;
import application.logic.carriages.FreightWagon;
import application.logic.carriages.SecondClassWagon;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class CarriagesTest {

    private FreightWagon freightCarriage;

    private SecondClassWagon secondClassCarriage;

    @BeforeMethod
    public void setup(){
        freightCarriage = new FreightWagon();
        secondClassCarriage = new SecondClassWagon();
    }

    @AfterMethod
    public void cleanUp(){
        freightCarriage = null;
        secondClassCarriage = null;
    }

    @Test
    public void testFreightCarriageOverload(){
        freightCarriage.loadBaggage(700);
        Assert.assertEquals(freightCarriage.getCurrentWeight(),0);
    }

    public void testLoadBaggage(){
        freightCarriage.loadBaggage(20);
        secondClassCarriage.loadBaggage(25);
        Assert.assertEquals(freightCarriage.getCurrentWeight(),20);
        Assert.assertEquals(secondClassCarriage.getCurrentWeight(),25);
    }
    @Test
    public void testFreightWagonPassengers(){
        freightCarriage.givePassengers(10);
        Assert.assertEquals(freightCarriage.getCurrentPassengers(),0);
    }

    @Test
    public void testBaggageWagonPassengers(){
        freightCarriage.givePassengers(5);
    }

    public void testToString(){
        Assert.assertEquals(secondClassCarriage.toString(),"A second class wagon,passengers: 0/50, loaded: 0/100");
    }

    public void testReadPropertyInt(){
        PropertiesReader target = new PropertiesReader("src\\main\\resources\\config.properties");
        Assert.assertEquals(target.readIntProperty("FreightWagon.maxWeight"),500);
        Assert.assertEquals(target.readIntProperty("FirstClassWagon.maxPassengers"),25);
    }
    public void testReadStringProperty(){
        PropertiesReader target = new PropertiesReader("src\\main\\resources\\config.properties");
        Assert.assertEquals(target.readStringProperty("FreightWagon.Comfort"),"BAGGAGE");
        Assert.assertEquals(target.readStringProperty("FirstClassWagon.Comfort"),"SECOND_CLASS");
    }
}
