package letspaintapplication;


import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/** Draw circles centered where the user clicks.
 *  Attaches itself as a listener.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, 
 *  servlets, JSP, and Java 7 and Java 8 programming</a>.
 */

public class CircleDrawer2 extends Applet
                           implements MouseListener {
  /**
	 * 
	 */
	private static final long serialVersionUID = -3763850360468341608L;
private int radius = 25;

  @Override
  public void init() {
    setForeground(Color.BLUE);
    addMouseListener(this);
  }

  // Remaining methods are from the MouseListener interface.

  
  @Override public void mouseEntered(MouseEvent event) {}
  @Override public void mouseExited(MouseEvent event) {}
  @Override public void mouseReleased(MouseEvent event) {}
  @Override public void mouseClicked(MouseEvent event) {}

  @Override
  public void mousePressed(MouseEvent event) {
    Graphics g = getGraphics();
    g.fillOval(event.getX()-radius,
               event.getY()-radius,
               2*radius,
               2*radius);
  }
}
