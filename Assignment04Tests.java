package assignment04;

import org.junit.*;
import org.junit.jupiter.api.DynamicTest;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Assignment04Tests {

    @Test
    public void testMaxMilesLeft() throws Exception {
        Car car = new Car(1, 100.);
        car.addGas(100.);
        Assert.assertEquals(100., car.maxMilesLeft(), 0.0000001);
    }

    @Test
    public void testDrive_1() throws Exception {
        Car car = new Car(2, 100.);
        car.addGas(100.);
        car.drive(20.);
        Assert.assertEquals(180., car.maxMilesLeft(), 0.0000001);
    }

    @Test
    public void testDrive_2() throws Exception {
        Car car = new Car(2, 100.);
        car.addGas(100.);
        car.drive(20.);
        Assert.assertEquals(180., car.maxMilesLeft(), 0.0000001);
    }

    @Test
    public void testLongest_1() throws Exception {
        List<String> strs = new ArrayList<>(Arrays.asList("a", "b", "abc", "def"));
        Assert.assertEquals(new ArrayList<>(Arrays.asList("abc", "def")), Question3.longest(strs));
    }

    @Test
    public void testLongest_2() throws Exception {
        Assert.assertTrue(Question3.longest(null) == null);
        Assert.assertEquals(new ArrayList<String>(), Question3.longest(new ArrayList<String>()));
    }

    @Test
    public void testShortest_1() throws Exception {
        List<String> strs = new ArrayList<>(Arrays.asList("a", "b", "abc", "def"));
        Assert.assertArrayEquals(new String[] {"a", "b"}, Question3.shortest(strs));
    }

    @Test
    public void testShortest_2() throws Exception {
        Assert.assertTrue(Question3.longest(null) == null);
        Assert.assertEquals(new String[] {}, Question3.shortest(new ArrayList<String>()));
    }

    @Test
    public void testLongestLocations_1() throws Exception {
        List<String> strs = new ArrayList<>(Arrays.asList("a", "b", "abc", "def"));
        int[] locations = Question3.longestLocations(strs);
        Assert.assertArrayEquals(new int[] {2,3}, locations);
    }

    @Test
    public void testLongestLocations_2() throws Exception {
        Assert.assertTrue(Question3.longestLocations(null) == null);
        Assert.assertArrayEquals(new int[] {}, Question3.longestLocations(new ArrayList<String>()));
    }

    @Test
    public void testMostCs_1() throws Exception {
        List<String> strs = new ArrayList<>(Arrays.asList("a", "b", "abc", "def"));
        List<String> cstrs = Question3.mostCs(strs, 'a');
        Assert.assertEquals(new ArrayList<>(Arrays.asList("a", "abc")), cstrs);
    }

    @Test
    public void testMostCs_2() throws Exception {
        Assert.assertTrue(Question3.mostCs(null, 'a') == null);
        Assert.assertEquals(new ArrayList<String>(), Question3.mostCs(new ArrayList<String>(), 'a'));
    }

    @Test
    public void testFewestCs_1() throws Exception {
        List<String> strs = new ArrayList<>(Arrays.asList("a", "b", "abc", "def"));
        String[] cstrs = Question3.fewestCs(strs, 'a');
        Assert.assertArrayEquals(new String[] {"b", "def"}, cstrs);
    }

    @Test
    public void testFewestCs_2() throws Exception {
        Assert.assertTrue(Question3.fewestCs(null, 'a') == null);
        Assert.assertEquals(new String[] {}, Question3.fewestCs(new ArrayList<String>(), 'a'));
    }

    @Test
    public void testMostCsLocations_1() throws Exception {
        List<String> strs = new ArrayList<>(Arrays.asList("a", "b", "abc", "def"));
        int[] locations = Question3.mostCsLocations(strs, 'a');
        Assert.assertArrayEquals(new int[] {0,2}, locations);
    }

    @Test
    public void testMostCsLocations_2() throws Exception {
        Assert.assertTrue(Question3.mostCsLocations(null, 'a') == null);
        Assert.assertArrayEquals(new int[] {}, Question3.mostCsLocations(new ArrayList<String>(), 'a'));
    }
}
