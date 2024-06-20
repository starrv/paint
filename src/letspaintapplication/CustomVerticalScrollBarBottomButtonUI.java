package letspaintapplication;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class CustomVerticalScrollBarBottomButtonUI extends BasicButtonUI {

    @Override
    public void paint(Graphics g, JComponent c) {
        //super.paint(g, c);
        g.setColor(Color.black);
        int[] xCoordsBottomArrow={0,c.getWidth()/2,c.getWidth()};
        int[] yCoordsBottomArrow={0,c.getHeight(),0};
        g.fillPolygon(xCoordsBottomArrow,yCoordsBottomArrow,3);
    }

}
