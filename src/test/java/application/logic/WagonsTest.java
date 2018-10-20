package application.logic;

import application.data.PropertiesReader;
import application.logic.carriages.FreightWagon;
import application.logic.carriages.SecondClassWagon;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class WagonsTest {

    private FreightWagon freightWagon;

    private SecondClassWagon secondClassWagon;

    @BeforeMethod
    public void setup(){
        freightWagon = new FreightWagon();
        secondClassWagon = new SecondClassWagon();
    }

    @AfterMethod
    public void cleanUp(){
        freightWagon = null;
        secondClassWagon = null;
    }

    @Test
    public void testFreightCarriageOverload(){
        freightWagon.loadBaggage(700);
        Assert.assertEquals(freightWagon.getCurrentWeight(),0);
    }

    public void testLoadBaggage(){
        freightWagon.loadBaggage(20);
        secondClassWagon.loadBaggage(25);
        Assert.assertEquals(freightWagon.getCurrentWeight(),20);
        Assert.assertEquals(secondClassWagon.getCurrentWeight(),25);
    }

    public void testFreightWagonPassengers(){
        freightWagon.givePassengers(10);
        Assert.assertEquals(freightWagon.getCurrentPassengers(),0);
    }


    public void testPassengerWagonPassengers(){
        secondClassWagon.givePassengers(5);
        Assert.assertEquals(secondClassWagon.getCurrentPassengers(),5);

    }
    public void testFirstClassWagonBaggage(){
        secondClassWagon.loadBaggage(10);
        Assert.assertEquals(secondClassWagon.getCurrentWeight(),10);
    }

    public void testToString(){
        Assert.assertEquals(secondClassWagon.toString(),"A second class wagon,passengers: 0/50, loaded: 0/100");
    }

    public void testReadPropertyInt(){
        PropertiesReader target = new PropertiesReader("src\\main\\resources\\config.properties");
        Assert.assertEquals(target.readIntProperty("FreightWagon.maxWeight"),500);
        Assert.assertEquals(target.readIntProperty("FirstClassWagon.maxPassengers"),25);
    }
    public void testReadStringProperty(){
        PropertiesReader target = new PropertiesReader("src\\main\\resources\\config.properties");
        Assert.assertEquals(target.readStringProperty("FreightWagon.Comfort"),"BAGGAGE");
        Assert.assertEquals(target.readStringProperty("FirstClassWagon.Comfort"),"FIRST_CLASS");
    }
}
