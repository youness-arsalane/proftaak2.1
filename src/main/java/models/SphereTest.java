package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SphereTest {

    @Test
    void calculateVolume() {
        Sphere sphere = new Sphere();
        sphere.setRadius(9.3);

        assertEquals(sphere.calculateVolume(), 3369.2827, 0.0001);
    }
}