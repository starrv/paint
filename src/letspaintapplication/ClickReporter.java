package letspaintapplication;

import java.applet.Applet;
import java.awt.*;

/** Prints a message saying where the user clicks.
 *  Uses an external listener.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, 
 *  servlets, JSP, and Java 7 and Java 8 programming</a>.
 */

public class ClickReporter extends Applet {
  /**
	 * 
	 */
	private static final long serialVersionUID = -5288371512622908470L;

@Override
  public void init() {
    setBackground(Color.YELLOW);
    addMouseListener(new ClickListener());
  }
}
