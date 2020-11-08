package mappers;

import models.*;

import java.sql.*;
import java.util.ArrayList;

abstract public class MySQLMapper implements MapperInterface {
    private Statement stmt;
    private Connection connection;

    private static final String DRIVER      = "com.mysql.jdbc.Driver";
    private static final String DB_PATH     = "jdbc:mysql://localhost:3306/vat_calculator";
    private static final String username    = "root";
    private static final String password    = "";

    public String getTableName() {
        return "shapes";
    }

    @Override
    public ArrayList<Shape> all() {
        ArrayList<Shape> results = new ArrayList<>();

        try {
            connect();
            ResultSet resultSet = getStatement().executeQuery("SELECT * FROM " + getTableName());

            while (resultSet.next()) {
                int shapeId = resultSet.getInt("SHAPE_ID");
                String shapeType = resultSet.getString("SHAPE_TYPE");
                double shapeLength = resultSet.getDouble("SHAPE_LENGTH");
                double shapeWidth = resultSet.getDouble("SHAPE_WIDTH");
                double shapeHeight = resultSet.getDouble("SHAPE_HEIGHT");
                double shapeRadius = resultSet.getDouble("SHAPE_RADIUS");

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

            closeConnection();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return results;
    }

    @Override
    public Shape findById(int id) {
        Shape shape = null;

        for (Shape s : all()) {
            if (s.getId() == id) {
                shape = s;
                break;
            }
        }

        return shape;
    }

    @Override
    public boolean save(Shape shape) {
        if (shape.getId() == 0) {
            return _insert(shape);
        } else {
            return _update(shape);
        }
    }

    @Override
    public boolean delete(Shape shape) {
        return _delete(shape.getId());
    }

    private boolean _insert(Shape shape) {
        try {
            connect();
            int createdRows = getStatement().executeUpdate("INSERT INTO " + getTableName() + " (SHAPE_TYPE, SHAPE_LENGTH, SHAPE_WIDTH, SHAPE_HEIGHT, SHAPE_RADIUS)" + " VALUES ('" + shape.getType() + "', " + shape.getLength() + ", " + shape.getWidth() + ", " + shape.getHeight() + ", " + shape.getRadius() + ")");

            closeConnection();

            return createdRows > 0;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /* TODO: create working _update function */
    private boolean _update(Shape shape) {
        return true;
    }

    private boolean _delete(int id) {
        try {
            connect();
            int deletedRows = stmt.executeUpdate("DELETE FROM " + getTableName() + " WHERE SHAPE_ID = " + id);

            closeConnection();

            return (deletedRows > 0);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return false;

    }

    private void connect() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        connection = DriverManager.getConnection(DB_PATH, username, password);
        stmt = connection.createStatement();
    }

    private void closeConnection() throws SQLException {
        stmt.close();
        connection.close();
    }

    private Statement getStatement() {
        return stmt;
    }
}