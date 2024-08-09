package letspaintapplication;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.CompoundBorder;

public class FontStyle extends JPanel implements FocusListener,MouseListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3436811857983119324L;
	private Whiteboard w;
	private JCheckBox boldCheckBox, italicsCheckBox;
	private Color color=new Color(217, 187, 169);
	private Color buttonColor=new Color(245, 233, 225);
	private final Color SELECTED_COLOR=new Color(247, 245, 240);
	private int borderWidth=4;
	
	public FontStyle(Whiteboard w)
	{
		this.w=w;
		//setLayout(new FlowLayout());
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		//add(label);
		
		boldCheckBox=new JCheckBox("bold", false);
		boldCheckBox.addItemListener(new boldItemListener());
		boldCheckBox.addFocusListener(this);
		boldCheckBox.addMouseListener(this);
		boldCheckBox.setFont(Display.DEFAULT_FONT);
		boldCheckBox.setBackground(buttonColor);
		CompoundBorder compoundBorder=BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black),BorderFactory.createEmptyBorder(borderWidth,borderWidth,borderWidth,borderWidth));
		boldCheckBox.setBorder(compoundBorder);
		boldCheckBox.setBorderPainted(true);
		add(boldCheckBox);
		
		italicsCheckBox=new JCheckBox("italics", false);
		italicsCheckBox.addItemListener(new italicsItemListener());
		italicsCheckBox.addFocusListener(this);
		italicsCheckBox.addMouseListener(this);
		italicsCheckBox.setFont(Display.DEFAULT_FONT);
		italicsCheckBox.setBackground(buttonColor);
		compoundBorder=BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black),BorderFactory.createEmptyBorder(borderWidth,borderWidth,borderWidth,borderWidth));
		italicsCheckBox.setBorder(compoundBorder);
		italicsCheckBox.setBorderPainted(true);
		add(italicsCheckBox);

		setBackground(color);
		setOpaque(true);
		setAlignmentY(CENTER_ALIGNMENT);
		//w.setFontStyle(Font.PLAIN);
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
		e.getComponent().setBackground(buttonColor);
	}
	
	private class boldItemListener implements ItemListener
	{
		@Override
		public void itemStateChanged(ItemEvent event) 
		{
			// TODO Auto-generated method stub
			if(event.getStateChange()==ItemEvent.SELECTED)
			{
				w.setFontStyle(Font.BOLD);
			}
			else if(event.getStateChange()==ItemEvent.DESELECTED)
			{
				w.unSetFontStyle(Font.BOLD);
			}
		}
	}
	
	private class italicsItemListener implements ItemListener
	{
		@Override
		public void itemStateChanged(ItemEvent event) 
		{
			// TODO Auto-generated method stub
			if(event.getStateChange()==ItemEvent.SELECTED)
			{
				w.setFontStyle(Font.ITALIC);
			}
			else if(event.getStateChange()==ItemEvent.DESELECTED)
			{
				w.unSetFontStyle(Font.ITALIC);
			}
		}
	}
	
	@Override
	public void focusGained(FocusEvent event) {
		// TODO Auto-generated method stub
		if(event.getComponent().getClass().getName().equals("javax.swing.JCheckBox"))
		{
			JCheckBox checkBox=(JCheckBox)event.getComponent();
			checkBox.setBackground(SELECTED_COLOR);
		}
	}

	@Override
	public void focusLost(FocusEvent event) {
		// TODO Auto-generated method stub
		if(event.getComponent().getClass().getName().equals("javax.swing.JCheckBox"))
		{
			JCheckBox checkBox=(JCheckBox)event.getComponent();
			checkBox.setBackground(buttonColor);
		}
	} 
}
