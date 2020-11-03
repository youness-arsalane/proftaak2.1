package mappers;

import models.Shape;

import java.util.ArrayList;

abstract public class CSVMapper implements MapperInterface {
    @Override
    public ArrayList<Shape> all() {
        return null;
    }

    @Override
    public Shape findById(int id) {
        return null;
    }

    @Override
    public boolean save(Shape shape) {
        return false;
    }

    @Override
    public boolean delete(Shape shape) {
        return false;
    }
}
