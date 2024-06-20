package letspaintapplication;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class CustomHorizontalScrollBarUI  extends BasicScrollBarUI {

    private final int BTN_WIDTH = 15;
    private final int BTN_HEIGHT = 15;

    @Override
    protected JButton createDecreaseButton(int orientation) {
        JButton btn = new JButton();
        btn.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        btn.setPreferredSize(new Dimension(BTN_WIDTH, BTN_HEIGHT));
        btn.setUI(new CustomHorizontalScrollBarLeftButtonUI());
        return btn;
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        JButton btn = new JButton();
        btn.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        btn.setPreferredSize(new Dimension(BTN_WIDTH, BTN_HEIGHT));
        btn.setUI(new CustomHorizontalScrollBarRightButtonUI());
        return btn;
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        g.setColor(new Color(79, 55, 41));
        g.fillRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height);
    }
}