package letspaintapplication;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/** The listener used by CircleDrawer1. Note call
 *  to getSource to obtain reference to the applet.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, 
 *  servlets, JSP, and Java 7 and Java 8 programming</a>.
 */

public class CircleListener extends MouseAdapter {
  private int radius = 25;

  @Override
  public void mousePressed(MouseEvent event) {
    Applet app = (Applet)event.getSource();
    Graphics g = app.getGraphics();
    g.fillOval(event.getX()-radius,
               event.getY()-radius,
               2*radius,
               2*radius);
  }
}
