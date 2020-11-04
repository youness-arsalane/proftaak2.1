package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CubeTest {

    @Test
    void calculateVolume() {
        Cube cube = new Cube();
        cube.setLength(7.6);
        cube.setWidth(3.2);
        cube.setHeight(8.11);

        assertEquals(cube.calculateVolume(), 197.2352, 0.0001);
    }
}