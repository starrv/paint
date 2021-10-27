package letspaintapplication;

import java.awt.*;
import java.awt.event.*;

/** A spelling-correcting TextField for entering
 *  a language name.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, 
 *  servlets, JSP, and Java 7 and Java 8 programming</a>.
 */

public class LanguageField extends TextField {
  /**
	 * 
	 */
	private static final long serialVersionUID = -2453128597440221114L;
private String[] substrings =
    { "", "J", "Ja", "Jav", "Java" };

  public LanguageField() {
    addKeyListener(new SpellingCorrector());
    addActionListener(new WordCompleter());
    addFocusListener(new SubliminalAdvertiser());
  }

  // Put caret at end of field.

  private void setCaret() {
    setCaretPosition(5);
  }

  // Listener to monitor/correct spelling as user types.

  private class SpellingCorrector extends KeyAdapter {
    @Override
    public void keyTyped(KeyEvent event) {
      setLanguage();
      setCaret();
    }

    // Enter partial name of good programming language that
    // most closely matches what they've typed so far.

    private void setLanguage() {
      int length = getText().length();
      if (length <= 4) {
        setText(substrings[length]);
      } else {
        setText("Java");
      }
      setCaret();
    }
  }

  // Listener to replace current partial name with
  // most closely-matching name of good language.

  private class WordCompleter implements ActionListener {

    // When they hit RETURN, fill in the right answer.

    @Override
    public void actionPerformed(ActionEvent event) {
      setText("Java");
      setCaret();
    }
  }

  // Listener to give the user a hint.

  private class SubliminalAdvertiser extends FocusAdapter {
    @Override
    public void focusGained(FocusEvent event) {
      String text = getText();
      for(int i=0; i<10; i++) {
        setText("Hint: Java");
        setText(text);
      }
    }
  }
}
