package letspaintapplication;

import java.applet.Applet;
import java.awt.*;

/** Draw circles centered where the user clicks.
 *  Uses an external listener.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, 
 *  servlets, JSP, and Java 7 and Java 8 programming</a>.
 */

public class CircleDrawer1 extends Applet {
  /**
	 * 
	 */
	private static final long serialVersionUID = -6037322830815723381L;

@Override
  public void init() {
    setForeground(Color.BLUE);
    addMouseListener(new CircleListener());
  }
}
