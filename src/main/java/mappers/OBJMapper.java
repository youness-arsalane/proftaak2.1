package mappers;

import models.*;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class OBJMapper implements MapperInterface {
    private static final String filepath = "C:\\Users\\youne\\Desktop\\School\\ELU2.1\\proftaak2.1\\shapes.obj";

    @Override
    public ArrayList<Shape> all() {
        ArrayList<Shape> results = new ArrayList<>();

        try {
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath));
                try {
                    results = (ArrayList<Shape>) ois.readObject();
                } catch (EOFException eof) {
                }

                ois.close();

            } catch (FileNotFoundException | EOFException eof) {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath));

                oos.writeObject(new ArrayList<>());

                oos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return results;
    }

    @Override
    public Shape findById(int id) {
        for (Shape shape : all()) {
            if (shape.getId() == id) {
                return shape;
            }
        }

        return null;
    }

    @Override
    public boolean save(Shape shape) {
        ArrayList<Shape> shapes = all();

        if (shape.getId() == 0) {
            continuingLoop:
            for (;;) {
                int newId = ThreadLocalRandom.current().nextInt(1, 99999);

                for (Shape currentShape : shapes) {
                    if (currentShape.getId() == newId) {
                        continue continuingLoop;
                    }
                }

                shape.setId(newId);
                break;
            }
        }

        shapes.add(shape);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath));

            oos.writeObject(shapes);

            oos.close();

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(Shape shape) {
        ArrayList<Shape> shapes = all();

        int index = 0;
        for (Shape currentShape : shapes) {
            if (currentShape.getId() == shape.getId()) {
                shapes.remove(index);
                break;
            }
            index++;
        }

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath));

            oos.writeObject(shapes);

            oos.close();

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }
}