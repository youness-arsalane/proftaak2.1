package mappers;

import models.Shape;

import java.util.ArrayList;

interface MapperInterface {
    ArrayList<Shape> all();

    Shape findById(int id);

    boolean save(Shape shape);

    boolean delete(Shape shape);
}