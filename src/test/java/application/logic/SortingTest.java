package application.logic;

import application.logic.carriages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

@Test
public class SortingTest extends UtilTest {

    private ArrayList<Wagon> expected;
    private ArrayList<Wagon> actual;

    @Override
    @BeforeMethod
    public void setup(){
        super.setup();
        expected = new ArrayList<>();
        train.shuffle();
    }

    @Override
    @AfterMethod
    public void cleanUp(){
        super.cleanUp();
        expected = null;
        actual = null;
    }

    public void testSortByMaxWeight() {

        train.sortByMaxWeight();

        expected.add(new RestaurantWagon());
        expected.add(new FirstClassWagon(20,15));
        expected.add(new SecondClassWagon(12,12));
        expected.add(new BaggageWagon(123));
        expected.add(new FreightWagon(302));

        actual = train.getWagons();

        Assert.assertEquals(expected.subList(2,expected.size()),actual.subList(2, actual.size()));
    }

    public void testSortByCurrentWeight() {

        train.sortByCurrentWeight();

        expected.add(new RestaurantWagon());
        expected.add(new SecondClassWagon(12,12));
        expected.add(new FirstClassWagon(20,15));
        expected.add(new BaggageWagon(123));
        expected.add(new FreightWagon(302));

        actual = train.getWagons();

        Assert.assertEquals(expected,actual);
    }

    public void testSortByCurrentPassengers() {

        for(int i=2;i>=0;i--){
            train.addCarriage(new SecondClassWagon(0,i*5));
        }
        train.sortByCurrentPassengers();

        expected.add(new SecondClassWagon());
        expected.add(new SecondClassWagon(0,5));
        expected.add(new SecondClassWagon(0,10));
        expected.add(new SecondClassWagon(12,12));
        expected.add(new FirstClassWagon(20,15));

        actual = train.getWagons();

        Assert.assertEquals(expected,actual.subList(3, actual.size()));

    }

    public void testSortByMaxPassengers() {
        train.sortByMaxPassengers();

        expected.add(new RestaurantWagon());
        expected.add(new BaggageWagon(123));
        expected.add(new FreightWagon(302));
        expected.add(new FirstClassWagon(20,15));
        expected.add(new SecondClassWagon(12,12));
        actual = train.getWagons();

        Assert.assertEquals(expected.subList(3,expected.size()),actual.subList(3,actual.size()));
    }

    public void testSortByComfort() {

        train.sortByComfort();

        expected.add(new RestaurantWagon());
        expected.add(new FirstClassWagon(20,15));
        expected.add(new SecondClassWagon(12,12));
        expected.add(new BaggageWagon(123));
        expected.add(new FreightWagon(302));

        actual = train.getWagons();

        Assert.assertEquals(actual.subList(0,2), expected.subList(0,2));
    }

}
