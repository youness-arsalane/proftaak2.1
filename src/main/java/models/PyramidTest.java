package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PyramidTest {

    @Test
    void calculateVolume() {
        Pyramid pyramid = new Pyramid();
        pyramid.setLength(7);
        pyramid.setWidth(20);
        pyramid.setHeight(20);

        assertEquals(pyramid.calculateVolume(), 933.3333, 0.0001);
    }
}