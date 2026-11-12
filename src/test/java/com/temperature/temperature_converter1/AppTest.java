package com.temperature.temperature_converter1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Unit test for Temperature Converter App.
 */
public class AppTest {

    @Test
    public void testCelsiusToFahrenheit() {
        assertEquals(212.0, App.convert(100, "C", "F"), 0.001);
    }

    @Test
    public void testFahrenheitToCelsius() {
        assertEquals(100.0, App.convert(212, "F", "C"), 0.001);
    }

    @Test
    public void testCelsiusToKelvin() {
        assertEquals(273.15, App.convert(0, "C", "K"), 0.001);
    }

    @Test
    public void testKelvinToCelsius() {
        assertEquals(0.0, App.convert(273.15, "K", "C"), 0.001);
    }

    @Test
    public void testFahrenheitToKelvin() {
        assertEquals(273.15, App.convert(32, "F", "K"), 0.001);
    }

    @Test
    public void testKelvinToFahrenheit() {
        assertEquals(32.0, App.convert(273.15, "K", "F"), 0.001);
    }

    @Test
    public void testInvalidSource() {
        assertThrows(IllegalArgumentException.class,
            () -> App.convert(100, "X", "C"));
    }

    @Test
    public void testInvalidTarget() {
        assertThrows(IllegalArgumentException.class,
            () -> App.convert(100, "C", "X"));
    }

    @Test
    public void testBelowAbsoluteZero() {
        assertThrows(IllegalArgumentException.class,
            () -> App.convert(-300, "C", "F"));
    }
}
