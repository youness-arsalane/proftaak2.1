package views.panels;

import models.Cylinder;
import views.components.DefaultPanel;

import javax.swing.*;
import java.util.ArrayList;

public class AddCylinderPanel extends AddShapePanel {
    public AddCylinderPanel(JFrame jFrame) {
        super(jFrame, new Cylinder());
    }

    @Override
    public ArrayList<JPanel> getTextFields() {
        ArrayList<JPanel> textFields = new ArrayList<>();

        textFields.add(new DefaultPanel().getHeightPanel(heightTextField));
        textFields.add(new DefaultPanel().getRadiusPanel(radiusTextField));

        return textFields;
    }
}