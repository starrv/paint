package letspaintapplication;

import java.applet.Applet;
import java.awt.*;

/** Lets the user enter the name of <b>any</b>
 *  good programming language. Or does it?
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, 
 *  servlets, JSP, and Java 7 and Java 8 programming</a>.
 */

public class JavaTextField extends Applet {
  /**
	 * 
	 */
	private static final long serialVersionUID = 7569393837473419452L;

@Override
  public void init() {
    setFont(new Font("Serif", Font.BOLD, 14));
    setLayout(new GridLayout(2, 1));
    add(new Label("Enter a Good Programming Language",
                  Label.CENTER));
    LanguageField langField = new LanguageField();
    Font langFont = new Font("SansSerif", Font.BOLD, 18);
    langField.setFont(langFont);
    add(langField);
  }
}
