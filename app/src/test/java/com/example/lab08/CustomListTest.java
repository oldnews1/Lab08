package com.example.lab08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomListTest {
    @Test
    public void testHasCity() {
        CustomList list = new CustomList();
        City calgary = new City("Calgary", "AB");
        list.addCity(calgary);
        // This will fail initially because hasCity() doesn't exist
        assertTrue(list.hasCity(calgary));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        City city = new City("Calgary", "Alberta");
        cityList.add(city);
        cityList.delete(new City("Edmonton", "Alberta"));
        assertFalse(cityList.hasCity(new City("Edmonton", "Alberta")));
        cityList.delete(city);
        assertFalse(cityList.hasCity(city));
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(new City("Toronto", "Ontario"));
        });
    }
}