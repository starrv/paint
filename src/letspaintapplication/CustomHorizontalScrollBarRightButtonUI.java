package letspaintapplication;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class CustomHorizontalScrollBarRightButtonUI extends BasicButtonUI {

    @Override
    public void paint(Graphics g, JComponent c) {
        //super.paint(g, c);
        g.setColor(Color.black);
        int[] xCoordsBottomArrow={0,0,c.getWidth()};
        int[] yCoordsBottomArrow={0,c.getHeight(),c.getHeight()/2};
        g.fillPolygon(xCoordsBottomArrow,yCoordsBottomArrow,3);
    }

}