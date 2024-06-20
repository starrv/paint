package letspaintapplication;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;


public class CustomVerticalScrollBarTopButtonUI extends BasicButtonUI {

    @Override
    public void paint(Graphics g, JComponent c) {
        //super.paint(g, c);
        g.setColor(Color.black);
        int[] xCoordsTopArrow={0,c.getWidth()/2,c.getWidth()};
        int[] yCoordsTopArrow={c.getHeight(),0,c.getHeight()};
        g.fillPolygon(xCoordsTopArrow,yCoordsTopArrow,3);
    }

}
