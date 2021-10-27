package letspaintapplication;

import java.awt.event.*;

/** The listener used by ClickReporter.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, 
 *  servlets, JSP, and Java 7 and Java 8 programming</a>.
 */

public class ClickListener extends MouseAdapter {
  @Override
  public void mousePressed(MouseEvent event) {
    Functions.printMessage("Mouse pressed at (" +
                       event.getX() + "," +
                       event.getY() + ").");
  }
}
