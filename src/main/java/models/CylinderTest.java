package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CylinderTest {

    @Test
    void calculateVolume() {
        Cylinder cylinder = new Cylinder();
        cylinder.setRadius(5.1);
        cylinder.setHeight(9.23);

        assertEquals(cylinder.calculateVolume(), 754.2094, 0.0001);
    }
}