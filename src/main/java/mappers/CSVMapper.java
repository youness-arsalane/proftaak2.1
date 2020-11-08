package mappers;

import models.*;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

abstract public class CSVMapper implements MapperInterface {
    private static final String filepath = "C:\\Users\\youne\\Desktop\\School\\ELU2.1\\proftaak2.1\\shapes.csv";

    @Override
    public ArrayList<Shape> all() {
        ArrayList<Shape> results = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");

                int shapeId = Integer.parseInt(values[0]);
                String shapeType = values[1];
                double shapeLength = Double.parseDouble(values[2]);
                double shapeWidth = Double.parseDouble(values[3]);
                double shapeHeight = Double.parseDouble(values[4]);
                double shapeRadius = Double.parseDouble(values[5]);

                switch (Shape.Companion.valueOf(shapeType)) {
                    case CUBE:
                        Cube cube = new Cube();
                        cube.setId(shapeId);
                        cube.setType(shapeType);
                        cube.setLength(shapeLength);
                        cube.setWidth(shapeWidth);
                        cube.setHeight(shapeHeight);

                        results.add(cube);
                        break;

                    case SPHERE:
                        Sphere sphere = new Sphere();
                        sphere.setId(shapeId);
                        sphere.setType(shapeType);
                        sphere.setRadius(shapeRadius);

                        results.add(sphere);
                        break;

                    case CYLINDER:
                        Cylinder cylinder = new Cylinder();
                        cylinder.setId(shapeId);
                        cylinder.setType(shapeType);
                        cylinder.setRadius(shapeRadius);
                        cylinder.setHeight(shapeHeight);

                        results.add(cylinder);
                        break;

                    case CONE:
                        Cone cone = new Cone();
                        cone.setId(shapeId);
                        cone.setType(shapeType);
                        cone.setRadius(shapeRadius);
                        cone.setHeight(shapeHeight);

                        results.add(cone);
                        break;

                    case PYRAMID:
                        Pyramid pyramid = new Pyramid();
                        pyramid.setId(shapeId);
                        pyramid.setType(shapeType);
                        pyramid.setLength(shapeLength);
                        pyramid.setWidth(shapeWidth);
                        pyramid.setHeight(shapeHeight);

                        results.add(pyramid);
                        break;
                }
            }
        } catch (FileNotFoundException fnf) {
            try {
                PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(filepath)));
                printWriter.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
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

        try {
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(filepath), true));

            printWriter.write(objToLine(shape) + '\n');

            printWriter.close();

            return true;

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
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
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(filepath)));

            for (Shape currentShape : shapes) {
                printWriter.write(objToLine(currentShape) + '\n');
            }

            printWriter.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    private String objToLine(Shape shape)
    {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add(String.valueOf(shape.getId()));
        arrayList.add(String.valueOf(shape.getType()));
        arrayList.add(String.valueOf(shape.getLength()));
        arrayList.add(String.valueOf(shape.getWidth()));
        arrayList.add(String.valueOf(shape.getHeight()));
        arrayList.add(String.valueOf(shape.getRadius()));

        return String.join(";", arrayList);
    }
}
