package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConeTest {

    @Test
    void calculateVolume() {
        Cone cone = new Cone();
        cone.setRadius(7);
        cone.setHeight(20);

        assertEquals(cone.calculateVolume(), 1026.2536, 0.0001);
    }
}