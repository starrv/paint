package letspaintapplication;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class FontType extends JPanel implements ItemListener
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
	private Font font=new Font("Sans Serif", Font.BOLD, 20);
	private Color color=new Color(217, 187, 169);
	
	public FontType(Whiteboard w)
	{
		this.w=w;
		//label=new JLabel("Font Family: ");
		//label.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		//add(label);
		String[] JButtonLabels={"arial", "times new roman", "comic sans ms", "sans serif", "calibri", "verdana"};
		fonts=new JComboBox<String>(JButtonLabels);
		fonts.addItemListener(this)	;	
		fonts.setSelectedIndex(0);
		fonts.setFont(font);
		add(fonts);
		setBackground(color);
		setOpaque(true);
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
		if(event.getItem().equals("arial"))
		{
			
			//Functions.printMessage("arial");
			w.setFontFamily("Arial");
		}
		else if(event.getItem().equals("times new roman"))
		{
			//Functions.printMessage("times new roman");
			w.setFontFamily("Times New Roman");
		}
		else if(event.getItem().equals("comic sans ms"))
		{
			w.setFontFamily("Comic Sans MS");
			//Functions.printMessage("comic sans ms");
		}
		else if(event.getItem().equals("sans serif"))
		{
			w.setFontFamily("Sans_Serif");
			//Functions.printMessage("sans serif");
		}
		else if(event.getItem().equals("calibri"))
		{
			//Functions.printMessage("calibri");
			w.setFontFamily("Calibri");
		}
		else if(event.getItem().equals("couriers"))
		{
			//Functions.printMessage("couriers");
			w.setFontFamily("Couriers");
		}
		else if(event.getItem().equals("cursive"))
		{
			//Functions.printMessage("cursive");
			w.setFontFamily("Cursive");
		}
		else if(event.getItem().equals("monospace"))
		{
			//Functions.printMessage("monospace");
			w.setFontFamily("MONOSPACE");
		}
		else if(event.getItem().equals("verdana"))
		{
			//Functions.printMessage("verdana");
			w.setFontFamily("Verdana");
		}
	}
}
