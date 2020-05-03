
import PriceList.Names;
import PriceList.Price;
import PriceList.PriceListBase;

import org.junit.Test;

import static org.junit.Assert.*;

public class test {
    @Test
    public void add(){

        PriceListBase result = new PriceListBase();


        assertTrue(result.add(18500, new Names("Book", new Price(549, 99))));
        assertTrue(result.add(18501, new Names("Candle", new Price (99,99))));
        assertTrue(result.add(18502, new Names("Mirror", new Price (999,90))));
        assertFalse(result.add(18502, new Names("Paper", new Price (4,99))));
        assertTrue(result.add(18503, new Names("Rope", new Price (14,90))));
        assertTrue(result.add(18504, new Names("Soup", new Price (79,90))));
        assertFalse(result.add(18504, new Names("Spoon", new Price (25,90))));
        assertTrue(result.add(18505, new Names("Towel", new Price(249,90))));

        assertEquals(result.getNames(18500), new Names("Book", new Price(549, 99)));
        assertEquals(result.getNames(18501), new Names("Candle", new Price (99,99)));

        assertEquals(new Price (99,99), result.fc(18501, 1));
        assertNotEquals(new Price (299,97), result.fc(18504, 1));


    }


    @Test
    public void changeP(){
        PriceListBase  oldResult = new PriceListBase();
        PriceListBase  newResult = new PriceListBase();

        oldResult.add(18501, new Names("Candle", new Price (99,99)));
        oldResult.add(18504, new Names("Soup", new Price (79,90)));
        oldResult.add(18505, new Names("Towel", new Price (249,90)));
        newResult.add(18501, new Names("Candle", new Price (99,99)));
        newResult.add(18504, new Names("Soup", new Price (79,90)));
        newResult.add(18505, new Names("Towel", new Price (249,90)));


        assertEquals(oldResult, newResult);
        assertTrue(oldResult.changeP(18501, new Price (49,90)));
        assertFalse(oldResult.changeP(18503, new Price (49,90)));
        assertNotEquals(oldResult, newResult);
    }


    @Test
    public void changeN(){
        PriceListBase oldResult = new PriceListBase();
        PriceListBase newResult = new PriceListBase();

        oldResult.add(18501, new Names("Candle", new Price (99,99)));
        oldResult.add(18504, new Names("Soup", new Price (79,90)));
        oldResult.add(18505, new Names("Towel", new Price (249,90)));
        newResult.add(18501, new Names("Candle", new Price (99,99)));
        newResult.add(18504, new Names("Soup", new Price (79,90)));
        newResult.add(18505, new Names("Towel", new Price (249,90)));

        assertEquals(oldResult, newResult);
        assertTrue(oldResult.changeN(18501, "Rope"));
        assertFalse(oldResult.changeN(18503, "Spoon"));
        assertNotEquals(oldResult, newResult);

    }

    @Test
    public void remove(){
        PriceListBase oldResult = new PriceListBase();
        PriceListBase newResult = new PriceListBase();

        oldResult.add(18501, new Names("Candle", new Price (99,99)));
        oldResult.add(18504, new Names("Soup", new Price (79,90)));
        oldResult.add(18505, new Names("Towel", new Price (249,90)));
        newResult.add(18501, new Names("Candle", new Price (99,99)));
        newResult.add(18504, new Names("Soup", new Price (79,90)));
        newResult.add(18505, new Names("Towel", new Price (249,90)));

        assertEquals(oldResult, newResult);
        assertTrue(oldResult.delete(18501));
        assertFalse(oldResult.delete(18503));
        assertNotEquals(oldResult, newResult);
    }

    @Test
    public void fc(){
        PriceListBase oldResult = new PriceListBase();
        PriceListBase newResult = new PriceListBase();

        oldResult.add(18501, new Names("Candle", new Price (99,99)));
        oldResult.add(18504, new Names("Soup", new Price (79,90)));
        oldResult.add(18505, new Names("Towel", new Price (249,90)));
        newResult.add(18501, new Names("Candle", new Price (99,99)));
        newResult.add(18504, new Names("Soup", new Price (79,90)));
        newResult.add(18505, new Names("Towel", new Price (249,90)));

        assertEquals(oldResult, newResult);
        assertTrue(oldResult.changeN(18501, "Rope"));
        assertFalse(oldResult.changeN(18503, "Spoon"));
        assertNotEquals(oldResult, newResult);

        assertEquals(new Price (299,97), newResult.fc(18501, 3));
        assertNotEquals(new Price (299,97), newResult.fc(18504, 3));
    }




}
