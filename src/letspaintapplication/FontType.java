package letspaintapplication;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class FontType extends JPanel implements ItemListener, FocusListener, MouseListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1135763679616462586L;
	private Whiteboard w;
	private JComboBox<String> fonts;
	private Color color=new Color(217, 187, 169);
	private final Color DEFAULT_COLOR;
	private final Color SELECTED_COLOR=new Color(247, 245, 240);
	
	public FontType(Whiteboard w)
	{
		this.w=w;
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] JButtonLabels=ge.getAvailableFontFamilyNames();
		fonts=new JComboBox<String>(JButtonLabels);
		DEFAULT_COLOR=fonts.getBackground();
		fonts.addItemListener(this)	;	
		fonts.addFocusListener(this);
		fonts.setSelectedIndex(0);
		fonts.setFont(Display.DEFAULT_FONT);
		add(fonts);
		setBackground(color);
		setOpaque(true);
		Component[] components=fonts.getComponents();
		for (int i=0; i<components.length; i++){
			components[i].addMouseListener(this);
		}
		setSize(getWidth(),4);
	}

	@Override
	public void itemStateChanged(ItemEvent event)
	{
		// TODO Auto-generated method stub
		w.setFontFamily((String)event.getItem());
		w.requestFocusInWindow();
	}
	
	@Override
	public void focusGained(FocusEvent event) {
		// TODO Auto-generated method stub
		if(event.getComponent().getClass().getName().equals("javax.swing.JComboBox"))
		{
			JComboBox<?> box=(JComboBox<?>)event.getComponent();
			box.setBorder(BorderFactory.createLineBorder(Color.blue,1,true));
		}
	}
	@Override
	public void focusLost(FocusEvent event) {
		// TODO Auto-generated method stub
		if(event.getComponent().getClass().getName().equals("javax.swing.JComboBox"))
		{
			JComboBox<?> box=(JComboBox<?>)event.getComponent();
			box.setBorder(BorderFactory.createEmptyBorder());
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		e.getComponent().setBackground(SELECTED_COLOR);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		e.getComponent().setBackground(DEFAULT_COLOR);
	}
}
