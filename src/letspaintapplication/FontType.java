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
	//private JButton arial, timesNewRomans, comicsSansMS, sansSerif, calibri, couriers, cursive, fantasy, buttonSelected;
	//private JButton[] JButtonBox;
	private Whiteboard w;
	//private JLabel label;
	private JComboBox<String> fonts;
	private Color color=new Color(217, 187, 169);
	private final Color DEFAULT_COLOR;
	private final Color SELECTED_COLOR=new Color(247, 245, 240);
	
	public FontType(Whiteboard w)
	{
		this.w=w;
		//setLayout(new FlowLayout());
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		//label=new JLabel("Font Family: ");
		//label.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		//add(label);
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		//String[] JButtonLabels={"arial", "times new roman", "comic sans ms", "calibri", "verdana", "cursive"};
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
	/*
	private void addButtons()
	{
		String[] JButtonLabels={"arial", "times new roman", "comic sans ms", "sans serif", "calibri", "verdana"};
		JButtonBox=new JButton[JButtonLabels.length];
		for(int i=0; i<JButtonBox.length; i++)
		{
			//Functions.printMessage("Add button "+i);
			JButtonBox[i]=new JButton(JButtonLabels[i]);
			JButtonBox[i].setBackground(Color.black);
			JButtonBox[i].setForeground(Color.white);
			JButtonBox[i].addActionListener(this);
			add(JButtonBox[i]);		
		}
	}
	
	private int getIndex(String buttonName)
	{
		for(int i=0; i<JButtonBox.length; i++)
		{
			if(JButtonBox[i].getText().equals(buttonName))
			{
				return i;
			}
		}
		return -1;
	}

	@Override
	public void actionPerformed(ActionEvent event)
	{
		// TODO Auto-generated method stub
		if(event.getActionCommand().equals("arial"))
		{
			buttonSelected.setBackground(Color.black);
			//Functions.printMessage("arial");
			w.setFontFamily("Arial");
			buttonSelected=JButtonBox[getIndex("arial")];
			buttonSelected.setBackground(Color.green);
		}
		else if(event.getActionCommand().equals("times new roman"))
		{
			buttonSelected.setBackground(Color.black);
			//Functions.printMessage("times new roman");
			w.setFontFamily("Times New Roman");
			buttonSelected=JButtonBox[getIndex("times new roman")];
			buttonSelected.setBackground(Color.green);
		}
		else if(event.getActionCommand().equals("comic sans ms"))
		{
			buttonSelected.setBackground(Color.black);
			w.setFontFamily("Comic Sans MS");
			//Functions.printMessage("comic sans ms");
			buttonSelected=JButtonBox[getIndex("comic sans ms")];
			buttonSelected.setBackground(Color.green);
		}
		else if(event.getActionCommand().equals("sans serif"))
		{
			buttonSelected.setBackground(Color.black);
			//Functions.printMessage("sans serif");
			w.setFontFamily("Sans Serif");
			buttonSelected=JButtonBox[getIndex("sans serif")];
			buttonSelected.setBackground(Color.green);
		}
		else if(event.getActionCommand().equals("calibri"))
		{
			buttonSelected.setBackground(Color.black);
			//Functions.printMessage("calibri");
			w.setFontFamily("Calibri");
			buttonSelected=JButtonBox[getIndex("calibri")];
			buttonSelected.setBackground(Color.green);
		}
		else if(event.getActionCommand().equals("couriers"))
		{
			buttonSelected.setBackground(Color.black);
			//Functions.printMessage("couriers");
			w.setFontFamily("Couriers");
			buttonSelected=JButtonBox[getIndex("couriers")];
			buttonSelected.setBackground(Color.green);
		}
		else if(event.getActionCommand().equals("cursive"))
		{
			buttonSelected.setBackground(Color.black);
			//Functions.printMessage("cursive");
			w.setFontFamily("Cursive");
			buttonSelected=JButtonBox[getIndex("cursive")];
			buttonSelected.setBackground(Color.green);
		}
		else if(event.getActionCommand().equals("fantasy"))
		{
			buttonSelected.setBackground(Color.black);
			//Functions.printMessage("fantasy");
			w.setFontFamily("Fantasy");
			buttonSelected=JButtonBox[getIndex("fantasy")];
			buttonSelected.setBackground(Color.green);
		}
		else if(event.getActionCommand().equals("verdana"))
		{
			buttonSelected.setBackground(Color.black);
			//Functions.printMessage("verdana");
			w.setFontFamily("Verdana");
			buttonSelected=JButtonBox[getIndex("verdana")];
			buttonSelected.setBackground(Color.green);
		}
		
	}
*/
	@Override
	public void itemStateChanged(ItemEvent event)
	{
		// TODO Auto-generated method stub
		w.setFontFamily((String)event.getItem());
		w.requestFocusInWindow();
		
		/*if(event.getItem().equals("arial"))
		{
			//Functions.printMessage("arial");
			w.setFontFamily("Arial");
			w.requestFocusInWindow();
		}
		else if(event.getItem().equals("times new roman"))
		{
			//Functions.printMessage("times new roman");
			w.setFontFamily("Times New Roman");
			w.requestFocusInWindow();
		}
		else if(event.getItem().equals("comic sans ms"))
		{
			w.setFontFamily("Comic Sans MS");
			w.requestFocusInWindow();
			//Functions.printMessage("comic sans ms");
		}
		else if(event.getItem().equals("sans serif"))
		{
			w.setFontFamily("Sans_Serif");
			w.requestFocusInWindow();
			//Functions.printMessage("sans serif");
		}
		else if(event.getItem().equals("calibri"))
		{
			//Functions.printMessage("calibri");
			w.setFontFamily("Calibri");
			w.requestFocusInWindow();
		}
		else if(event.getItem().equals("couriers"))
		{
			//Functions.printMessage("couriers");
			w.setFontFamily("Couriers");
			w.requestFocusInWindow();
		}
		else if(event.getItem().equals("cursive"))
		{
			//Functions.printMessage("cursive");
			w.setFontFamily("Cursive");
			w.requestFocusInWindow();
		}
		else if(event.getItem().equals("monospace"))
		{
			//Functions.printMessage("monospace");
			w.setFontFamily("MONOSPACE");
			w.requestFocusInWindow();
		}
		else if(event.getItem().equals("verdana"))
		{
			//Functions.printMessage("verdana");
			w.setFontFamily("Verdana");
			w.requestFocusInWindow();
		}*/
	}
	
	@Override
	public void focusGained(FocusEvent event) {
		// TODO Auto-generated method stub
		if(event.getComponent().getClass().getName().equals("javax.swing.JComboBox"))
		{
			JComboBox<?> box=(JComboBox<?>)event.getComponent();
			//box.setFont(Display.FOCUS_FONT);
			//box.setForeground(Color.blue);
			box.setBorder(BorderFactory.createLineBorder(Color.blue,1,true));
		}
	}
	@Override
	public void focusLost(FocusEvent event) {
		// TODO Auto-generated method stub
		if(event.getComponent().getClass().getName().equals("javax.swing.JComboBox"))
		{
			JComboBox<?> box=(JComboBox<?>)event.getComponent();
			//box.setFont(Display.DEFAULT_FONT);
			//box.setForeground(Color.black);
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
