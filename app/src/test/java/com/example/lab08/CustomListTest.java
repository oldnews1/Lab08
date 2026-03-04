package com.example.lab08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomListTest {
    private CustomList mockCityList() {
        CustomList cityList = new CustomList();
        cityList.addCity(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    public void testHasCity() {
        CustomList list = new CustomList();
        City calgary = new City("Calgary", "AB");
        list.addCity(calgary);
        // This will fail initially because hasCity() doesn't exist
        assertTrue(list.hasCity(calgary));
    }

    @Test
    void testDeleteCity() {
        CustomList cityList = mockCityList();
        City city = new City("Calgary", "Alberta");
        cityList.addCity(city);
        cityList.deleteCity(new City("Edmonton", "Alberta"));
        assertFalse(cityList.hasCity(new City("Edmonton", "Alberta")));
        cityList.deleteCity(city);
        assertFalse(cityList.hasCity(city));
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.deleteCity(new City("Toronto", "Ontario"));
        });
    }

    @Test
    void testCountCities() {
        CustomList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
        City city = new City("Calgary", "Alberta");
        cityList.addCity(city);
        assertEquals(2, cityList.countCities());
        cityList.deleteCity(city);
        assertEquals(1, cityList.countCities());
    }
}