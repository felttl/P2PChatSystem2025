package p2pchatsystem.main.model.assoc;

import p2pchatsystem.main.views.EnterV;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EnterM {

    private EnterV enterV;

    public EnterM(Action a) {
        super();
        enterV = new EnterV();
        enterV.setVisible(true);
    }

    public EnterV getEnterV() {
        return enterV;
    }




}
