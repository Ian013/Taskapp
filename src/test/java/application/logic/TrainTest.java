package application.logic;

import application.logic.carriages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;


@Test
public class TrainTest extends UtilTest{

    public void testToString() {
        Assert.assertEquals(train.toString(),
                    "Wagon №1 : A first class wagon, passengers: 15/25, loaded: 20/25\n" +
                        "Wagon №2 : A second class wagon,passengers: 12/50, loaded: 12/100\n" +
                        "Wagon №3 : A freight wagon, loaded: 302/500\n" +
                        "Wagon №4 : A restaurant wagon \n" +
                        "Wagon №5 : A baggage wagon, loaded: 123/300\n");
    }

    public void testCalculateMaxPassengers() {
        Assert.assertEquals(train.calculateMaxPassengers(),75);
    }

    public void testCalculateCurrentPassengers() {
        Assert.assertEquals(train.calculateCurrentPassengers(),27);
    }

    public void testGetTrainLength() {
        Assert.assertEquals(train.getTrainLength(), 5);
    }

    public void testAddWagons() {
        ArrayList<Wagon> list = new ArrayList<>();
        for(int i=0;i<3;i++){
            list.add(new SecondClassWagon(i+5,i+10));
        }

        ArrayList<Wagon> expected = new ArrayList<>();

        expected.addAll(train.getWagons());
        expected.addAll(list);

        train.addWagons(list);
        Assert.assertEquals(train.getWagons(),expected);
    }

    public void testGetWagons() {
        ArrayList<Wagon> expected = new ArrayList<>();

        expected.add(new FirstClassWagon(20,15));
        expected.add(new SecondClassWagon(12,12));
        expected.add(new FreightWagon(302));
        expected.add(new RestaurantWagon());
        expected.add(new BaggageWagon(123));

        Assert.assertEquals(train.getWagons(),expected);
    }

    public void testGetWagon() {
        Wagon expected = new FirstClassWagon(20,15);
        Wagon target = train.getWagonByIndex(0);
        Assert.assertEquals(expected,target);
    }

    public void testCalculateCurrentWeight() {
        Assert.assertEquals(train.calculateCurrentWeight(),457);
    }

    public void testCalculateMaxWeight() {
        Assert.assertEquals(train.calculateMaxWeight(),925);
    }

    public void testLoadToCarriage() {
        train.loadToWagon(2,100);
        Assert.assertEquals(train.getWagonByIndex(2).getCurrentWeight(),100);
    }

    public void testGivePassengersToWagen() {
        train.givePassengersToWagen(0,10);
        Assert.assertEquals(train.getWagonByIndex(0).getCurrentPassengers(),10);
    }


    public void testGetWagonsByPassengers() {
        Wagon[] expected = {
                new SecondClassWagon(12,12),
                new FirstClassWagon(0,8),
                new SecondClassWagon(0,9),
                new FirstClassWagon(0,10),
                new SecondClassWagon(0,11),
                new FirstClassWagon(0,12)
        };
        for(int i=5;i<15;i++){
            if(i%2==0){
                train.addWagon(new FirstClassWagon(0,i));
            }else
                {train.addWagon(new SecondClassWagon(0,i));
            }
        }
        Assert.assertEquals(train.getWagonsByPassengers(7,13),expected);
    }

    public void testGetWagonsByWeight() {
        Wagon[] expected = {
                new FreightWagon(90),
                new BaggageWagon(100),
                new FreightWagon(110),
                new BaggageWagon(120),
        };
        for(int i=5;i<15;i++){
            if(i%2!=0){
                train.addWagon(new FreightWagon(i*10));
            }else
            {train.addWagon(new BaggageWagon(i*10));
            }
        }
        Assert.assertEquals(train.getWagonsByWeight(89,121),expected);
    }
}
