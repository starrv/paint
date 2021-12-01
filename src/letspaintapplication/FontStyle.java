package letspaintapplication;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class FontStyle extends JPanel implements FocusListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3436811857983119324L;
	private Whiteboard w;
	private JCheckBox boldCheckBox, italicsCheckBox;
	private Color color=new Color(217, 187, 169);
	
	public FontStyle(Whiteboard w)
	{
		this.w=w;
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		//add(label);
		
		boldCheckBox=new JCheckBox("bold", false);
		boldCheckBox.addItemListener(new boldItemListener());
		boldCheckBox.addFocusListener(this);
		boldCheckBox.setFont(Display.DEFAULT_FONT);
		add(boldCheckBox);
		
		italicsCheckBox=new JCheckBox("italics", false);
		italicsCheckBox.addItemListener(new italicsItemListener());
		italicsCheckBox.addFocusListener(this);
		italicsCheckBox.setFont(Display.DEFAULT_FONT);
		add(italicsCheckBox);
		
		setBackground(color);
		setOpaque(true);
		//w.setFontStyle(Font.PLAIN);
	}
	
	/*private void addButtons()
	{
		String[] JButtonLabels={"regular", "bold", "italics"};
		JButtonBox=new JButton[JButtonLabels.length];
		for(int i=0; i<JButtonBox.length; i++)
		{
			Functions.printMessage("Add button "+i);
			JButtonBox[i]=new JButton(JButtonLabels[i]);
			JButtonBox[i].setBackground(Color.black);
			JButtonBox[i].setForeground(Color.white);
			JButtonBox[i].addActionListener(this);
			add(JButtonBox[i]);		
		}
	}*/
	

/*
	@Override
	public void actionPerformed(ActionEvent event) 
	{
		// TODO Auto-generated method stub
		if(event.getActionCommand().equals("regular"))
		{
			w.setFontStyle(Font.PLAIN);
		}
		else if(event.getActionCommand().equals("bold"))
		{
			w.setFontStyle(Font.BOLD);
		}
		else if(event.getActionCommand().equals("italics"))
		{
			w.setFontStyle(Font.ITALIC);
		}
	}*/
	
	
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
			checkBox.setFont(Display.FOCUS_FONT);
			checkBox.setBorder(BorderFactory.createLineBorder(Color.blue, 1, true));
			checkBox.setForeground(Color.blue);
		}
	}

	@Override
	public void focusLost(FocusEvent event) {
		// TODO Auto-generated method stub
		if(event.getComponent().getClass().getName().equals("javax.swing.JCheckBox"))
		{
			JCheckBox checkBox=(JCheckBox)event.getComponent();
			checkBox.setFont(Display.DEFAULT_FONT);
			checkBox.setBorder(BorderFactory.createLineBorder(Color.gray, 1, true));
			checkBox.setForeground(Color.black);
		}
	} 
}
