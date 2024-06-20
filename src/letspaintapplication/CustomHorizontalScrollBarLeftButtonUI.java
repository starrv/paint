package letspaintapplication;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class CustomHorizontalScrollBarLeftButtonUI extends BasicButtonUI {

    @Override
    public void paint(Graphics g, JComponent c) {
        //super.paint(g, c);
        g.setColor(Color.black);
        int[] xCoordsBottomArrow={0,c.getWidth(),c.getWidth()};
        int[] yCoordsBottomArrow={c.getHeight()/2,c.getHeight(),0};
        g.fillPolygon(xCoordsBottomArrow,yCoordsBottomArrow,3);
    }

}
