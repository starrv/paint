package letspaintapplication;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/** Draw circles centered where the user clicks.
 *  Uses anonymous inner classes.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, 
 *  servlets, JSP, and Java 7 and Java 8 programming</a>.
 */

public class CircleDrawer4 extends Applet {
  /**
	 * 
	 */
	private static final long serialVersionUID = -1791037939483262288L;

@Override
  public void init() {
    setForeground(Color.BLUE);
    addMouseListener
      (new MouseAdapter() {
         private int radius = 25;

         @Override
         public void mousePressed(MouseEvent event) {
           Graphics g = getGraphics();
           g.fillOval(event.getX()-radius,
                      event.getY()-radius,
                      2*radius,
                      2*radius);
         }
      });
  }
}
