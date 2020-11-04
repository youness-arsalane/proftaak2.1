package mappers;

import models.Cube;
import models.Shape;
import org.junit.jupiter.api.AfterEach;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class MySQLMapperTest {
    private Statement stmt;
    private Connection connection;

    private static final String DRIVER      = "com.mysql.jdbc.Driver";
    private static final String DB_PATH     = "jdbc:mysql://localhost:3306/vat_calculator";
    private static final String username    = "root";
    private static final String password    = "";

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DB_PATH, username, password);
            stmt = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            fail("Unable to connect to database...");
        }
    }

    @AfterEach
    void tearDown() {
        try {
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            fail("Unable to close connection of database...");
        }
    }

    @org.junit.jupiter.api.Test
    void save() {
        Shape cube = new Cube();
        cube.setId(9999);
        cube.setLength(10);
        cube.setHeight(10);
        cube.setWidth(10);

        try {
            int createdRows = stmt.executeUpdate("INSERT INTO shapes (SHAPE_ID, SHAPE_TYPE, SHAPE_LENGTH, SHAPE_WIDTH, SHAPE_HEIGHT, SHAPE_RADIUS)" + " VALUES (" + cube.getId() + ", '" + cube.getType() + "', " + cube.getLength() + ", " + cube.getWidth() + ", " + cube.getHeight() + ", " + cube.getRadius() + ")");
            assertEquals(createdRows, 1);
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Unable to save shape to database...");
        }
    }

    @org.junit.jupiter.api.Test
    void delete() {
        try {
            stmt.executeUpdate("DELETE FROM shapes WHERE SHAPE_ID = 9999");
        } catch (SQLException e) {
            fail("Unable to delete shape from database...");
        }
    }
}