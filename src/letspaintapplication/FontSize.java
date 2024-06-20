package letspaintapplication;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class FontSize extends JPanel implements ItemListener, FocusListener, MouseListener
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1391431680325839085L;
	private Whiteboard w;
	private JComboBox<String> fontSizeList;
	//private JButton[] JButtonBox;
	//private JButton buttonSelected;
	private String[] JLabels;
	//private JLabel label;
	private final Color DEFAULT_LIST_COLOR;
	private final Color SELECTED_COLOR=new Color(247, 245, 240);
	
	public FontSize(Whiteboard w)
	{
		this.w=w;
		//setLayout(new FlowLayout());
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		/*label=new JLabel("Font Size: ");
		label.setFont(Display.DEFAULT_FONT);
		add(label);*/

		addLabels();
		fontSizeList=new JComboBox<String>(JLabels);
		DEFAULT_LIST_COLOR=fontSizeList.getBackground();
		fontSizeList.addItemListener(this);
		fontSizeList.addFocusListener(this);
		int fontSizeIndex=14;
		fontSizeList.setSelectedIndex(fontSizeIndex);
		fontSizeList.setFont(Display.DEFAULT_FONT);
		add(fontSizeList);
		w.setFontSize(Integer.parseInt(JLabels[fontSizeIndex]));
		setBackground(new Color(217, 187, 169));
		setOpaque(true);
		Component[] components=fontSizeList.getComponents();
		for (int i=0; i<components.length; i++){
			components[i].addMouseListener(this);
		}
		setAlignmentY(CENTER_ALIGNMENT);
		//addButtons();
		//buttonSelected=JButtonBox[1];
		//Functions.Functions.printMessage(JButtonBox[1]);
		//buttonSelected.setBackground(Color.orange);
	}
	
	private void addLabels()
	{
		JLabels=new String[42];
		for(int i=0; i<JLabels.length; i++)
		{
			//Functions.Functions.printMessage("Add Label "+i);
			JLabels[i]=Integer.toString(8+2*i);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent event)
	{
		// TODO Auto-generated method stub
		for(int i=0; i<JLabels.length; i++)
		{
			if(event.getItem().equals(JLabels[i]))
			{
				//Functions.Functions.printMessage(JLabels[i]);
				w.setFontSize(Integer.parseInt(JLabels[i]));
				w.requestFocusInWindow();
				break;
			}
		}
		
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
		e.getComponent().setBackground(DEFAULT_LIST_COLOR);
	}
	
	/*private void addButtons()
	{
		JButtonLabels=new String[32];
		for(int i=0; i<JButtonLabels.length; i++)
		{
			Functions.printMessage("Add Label "+i);
			JButtonLabels[i]=Integer.toString(8+2*i);
		}
		JButtonBox=new JButton[JButtonLabels.length];
		for(int i=0; i<JButtonLabels.length; i++)
		{
			Functions.printMessage("Add button "+i);
			JButtonBox[i]=new JButton(JButtonLabels[i]);
			JButtonBox[i].setBackground(Color.black);
			JButtonBox[i].setForeground(Color.white);
			JButtonBox[i].addActionListener(this);
			add(JButtonBox[i]);	
		}	
	}*/
	
	
	/*private int getIndex(String buttonName)
	{
		for(int i=0; i<JButtonBox.length; i++)
		{
			if(JButtonBox[i].getText().equals(buttonName))
			{
				return i;
			}
		}
		return -1;
	}*/

	/*@Override
	public void actionPerformed(ActionEvent event)
	{
		// TODO Auto-generated method stub
		for(int i=0; i<JButtonLabels.length;i++)
		{
			if(event.getActionCommand().equals(JButtonBox[i].getText()))
			{
				buttonSelected.setBackground(Color.black);
				w.setFontSize(Integer.parseInt(JButtonBox[i].getText()));
				buttonSelected=JButtonBox[i];
				buttonSelected.setBackground(Color.orange);
			}
		}
	}*/

}
