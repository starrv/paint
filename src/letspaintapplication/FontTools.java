package letspaintapplication;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class FontTools extends JPanel implements ActionListener, MouseMotionListener, KeyListener, FocusListener, MouseListener
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4011362814260279589L;
	private JButton green, yellow, orange, blue, black, white, red, pink, lightGray, darkGray, magenta, cyan, buttonSelected, chocolate1, peach1;
	private Color chocolate=new Color(125,30,45);
	private Color peach=new Color(225,200,195);
	private Whiteboard w;
	private JLabel title;
	private Color color=new Color(217, 187, 169);
	
	public FontTools(Whiteboard w)
	{
		addMouseMotionListener(this);
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.w=w;
		title=new JLabel("Font Colors:");
		title.setFont(Display.DEFAULT_FONT);
		title.setBackground(new Color(77, 106, 148));
		title.setAlignmentX(CENTER_ALIGNMENT);
		add(title);
		setBackground(color);
		setOpaque(true);
		int borderWidth=20;
		title.setBackground(Color.yellow);
		title.setOpaque(true);
		title.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black, 5, true),new EmptyBorder(borderWidth,borderWidth,borderWidth,borderWidth)));
		setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black, 5, true),new EmptyBorder(borderWidth,borderWidth,borderWidth,borderWidth)));
		
		
		orange=new JButton("orange");
	    orange.addActionListener(this);
	    orange.addKeyListener(this);
	    orange.addFocusListener(this);
		orange.addMouseListener(this);
	    orange.setBackground(color);
	    orange.setOpaque(true);
	    orange.setBorderPainted(false);
	    orange.setFont(Display.DEFAULT_FONT);
		orange.setName("orange");
		orange.setAlignmentX(CENTER_ALIGNMENT);
	    
	    blue=new JButton("blue");
	    blue.addActionListener(this);
	    blue.addKeyListener(this);
		blue.addFocusListener(this);
		blue.addMouseListener(this);
	    blue.setBackground(color);
	    blue.setOpaque(true);
	    blue.setBorderPainted(false);
	    blue.setFont(Display.DEFAULT_FONT);
		blue.setName("blue");
		blue.setAlignmentX(CENTER_ALIGNMENT);
	    
	    black=new JButton("black");
	    black.addActionListener(this);
	    black.addKeyListener(this);
	    black.addFocusListener(this);
		black.addMouseListener(this);
	    black.setBackground(color);
	    black.setOpaque(true);
	    black.setBorderPainted(false);
	    black.setFont(Display.DEFAULT_FONT);
		black.setName("black");
		black.setAlignmentX(CENTER_ALIGNMENT);
	    
		green=new JButton("green");
	    green.addActionListener(this);
	    green.addKeyListener(this);
		green.addFocusListener(this);
		green.addMouseListener(this);
	    green.setBackground(color);
	    green.setOpaque(true);
	    green.setBorderPainted(false);
	    green.setFont(Display.DEFAULT_FONT);
		green.setName("green");
		green.setAlignmentX(CENTER_ALIGNMENT);
	    
	    yellow=new JButton("yellow");
	    yellow.addActionListener(this);
	    yellow.addKeyListener(this);
	    yellow.addFocusListener(this);
		yellow.addMouseListener(this);
	    yellow.setBackground(color);
	    yellow.setOpaque(true);
	    yellow.setBorderPainted(false);
	    yellow.setFont(Display.DEFAULT_FONT);
		yellow.setName("yellow");
		yellow.setAlignmentX(CENTER_ALIGNMENT);
	    
	    white=new JButton("white");
	    white.addActionListener(this);
	    white.addKeyListener(this);
	    white.addFocusListener(this);
		white.addMouseListener(this);
	    white.setBackground(color);
	    white.setOpaque(true);
	    white.setBorderPainted(false);
	    white.setFont(Display.DEFAULT_FONT);
		white.setName("white");
		white.setAlignmentX(CENTER_ALIGNMENT);
	    
	    red=new JButton("red");
	    red.addActionListener(this);
	    red.addKeyListener(this);
	    red.addFocusListener(this);
		red.addMouseListener(this);
	    red.setBackground(color);
	    red.setOpaque(true);
	    red.setBorderPainted(false);
	    red.setFont(Display.DEFAULT_FONT);
		red.setName("red");
		red.setAlignmentX(CENTER_ALIGNMENT);
	    
	    darkGray=new JButton("dark gray");
	    darkGray.addActionListener(this);
	    darkGray.addKeyListener(this);
	    darkGray.addFocusListener(this);
		darkGray.addMouseListener(this);
	    darkGray.setBackground(color);
	    darkGray.setOpaque(true);
	    darkGray.setBorderPainted(false);
	    darkGray.setFont(Display.DEFAULT_FONT);
		darkGray.setName("darkGray");
		darkGray.setAlignmentX(CENTER_ALIGNMENT);
	    
	    lightGray=new JButton("light gray");
	    lightGray.addActionListener(this);
	    lightGray.addKeyListener(this);
	    lightGray.addFocusListener(this);
		lightGray.addMouseListener(this);
	    lightGray.setBackground(color);
	    lightGray.setOpaque(true);
	    lightGray.setBorderPainted(false);
	    lightGray.setFont(Display.DEFAULT_FONT);
		lightGray.setName("lightGray");
		lightGray.setAlignmentX(CENTER_ALIGNMENT);
	    
	    pink=new JButton("pink");
	    pink.addActionListener(this);
	    pink.addKeyListener(this);
	    pink.addFocusListener(this);
		pink.addMouseListener(this);
	    pink.setBackground(color);
	    pink.setOpaque(true);
	    pink.setBorderPainted(false);
	    pink.setFont(Display.DEFAULT_FONT);
		pink.setName("pink");
		pink.setAlignmentX(CENTER_ALIGNMENT);
	    
	    magenta=new JButton("magenta");
	    magenta.addActionListener(this);
	    magenta.addKeyListener(this);
	    magenta.addFocusListener(this);
		magenta.addMouseListener(this);
	    magenta.setBackground(color);
	    magenta.setOpaque(true);
	    magenta.setBorderPainted(false);
	    magenta.setFont(Display.DEFAULT_FONT);
		magenta.setName("magenta");
		magenta.setAlignmentX(CENTER_ALIGNMENT);
	    
	    cyan=new JButton("cyan");
	    cyan.addActionListener(this);
	    cyan.addKeyListener(this);
	    cyan.addFocusListener(this);
		cyan.addMouseListener(this);
	    cyan.setBackground(color);
	    cyan.setOpaque(true);
	    cyan.setBorderPainted(false);
	    cyan.setFont(Display.DEFAULT_FONT);
		cyan.setName("cyan");
		cyan.setAlignmentX(CENTER_ALIGNMENT);
	
	    chocolate1=new JButton("chocolate");
	    chocolate1.addActionListener(this);
	    chocolate1.addKeyListener(this);
	    chocolate1.addFocusListener(this);
		chocolate1.addMouseListener(this);
	    chocolate1.setBackground(color);
	    chocolate1.setOpaque(true);
	    chocolate1.setBorderPainted(false);
	    chocolate1.setFont(Display.DEFAULT_FONT);
		chocolate1.setName("chocolate1");
		chocolate1.setAlignmentX(CENTER_ALIGNMENT);

	    peach1=new JButton("peach");
	    peach1.addActionListener(this);
	    peach1.addKeyListener(this);
	    peach1.addFocusListener(this);
		peach1.addMouseListener(this);
	    peach1.setBackground(color);
	    peach1.setOpaque(true);
	    peach1.setBorderPainted(false);
	    peach1.setFont(Display.DEFAULT_FONT);
		peach1.setName("peach1");
		peach1.setAlignmentX(CENTER_ALIGNMENT);
	    
	    add(green);
	    add(yellow);
	    add(orange);
	    add(blue);
	    add(black);
	    add(pink);
	    add(red);
	    add(lightGray);
	    add(darkGray);
	    add(magenta);
	    add(cyan);
	    add(white);
	    add(chocolate1);
	    add(peach1);
	    buttonSelected=black;
	    buttonSelected.setForeground(Color.white);
	    buttonSelected.setBackground(Color.black);
	    setVisible(true);  
	}
	
	public FontTools(Whiteboard w, int x, int y)
	{
		this(w);
		setSize(x,y);
	}
	
	@Override
	public void actionPerformed(ActionEvent event)
	{
		// TODO Auto-generated method stub
		if(event.getActionCommand()=="green")
		{
			changeFontColor(Color.green,green);
		}
		else if(event.getActionCommand()=="yellow")
		{
			changeFontColor(Color.yellow,yellow);
		}
		else if(event.getActionCommand()=="orange")
		{
			changeFontColor(Color.orange,orange);
		}
		else if(event.getActionCommand()=="blue")
		{
			changeFontColor(Color.blue,blue);
			
		}
		else if(event.getActionCommand()=="black")
		{
			changeFontColorToBlack(Color.black,black);
		}
		else if(event.getActionCommand()=="light gray")
		{
			changeFontColor(Color.lightGray,lightGray);
		}
		else if(event.getActionCommand()=="dark gray")
		{
			changeFontColor(Color.darkGray,darkGray);
		}
		else if(event.getActionCommand()=="red")
		{
			changeFontColor(Color.red,red);
		}
		else if(event.getActionCommand()=="pink")
		{
			changeFontColor(Color.pink,pink);
		}
		else if(event.getActionCommand()=="magenta")
		{
			changeFontColor(Color.magenta,magenta);
		}
		else if(event.getActionCommand()=="cyan")
		{
			changeFontColor(Color.cyan,cyan);
		}
		else if(event.getActionCommand()=="white")
		{
			changeFontColor(Color.white,white);
		}		
		else if(event.getActionCommand()=="chocolate")
		{
			changeFontColor(chocolate,chocolate1);
		}
		else if(event.getActionCommand()=="peach")
		{
			changeFontColor(peach,peach1);
		}
	}
	

	@Override
	public void mouseDragged(MouseEvent event)
	{
		// TODO Auto-generated method stub
	
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent event) 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	private void changeFontColor(Color newColor, JButton selectedButton)
	{
		buttonSelected.setBackground(color);
		if(buttonSelected.equals(black))
		{
			buttonSelected.setForeground(Color.black);
		}
		w.setFontColor(newColor);
		buttonSelected=selectedButton;
		buttonSelected.setBackground(newColor);
		w.requestFocusInWindow();
	}
	
	private void changeFontColorToBlack(Color newColor, JButton selectedButton)
	{
		buttonSelected.setBackground(color);
		w.setFontColor(newColor);
		buttonSelected=selectedButton;
		buttonSelected.setBackground(newColor);
		buttonSelected.setForeground(Color.white);
		w.requestFocusInWindow();
	}

	@Override
	public void focusGained(FocusEvent event) {
		// TODO Auto-generated method stub
		if(event.getComponent().getClass().getName().equals("javax.swing.JButton"))
		{
			JButton button=(JButton)event.getComponent();
			button.setBorderPainted(true);
			button.setFont(Display.FOCUS_FONT);
			button.setForeground(Color.blue);
		}
	}

	@Override
	public void focusLost(FocusEvent event) {
		// TODO Auto-generated method stub
		if(event.getComponent().getClass().getName().equals("javax.swing.JButton"))
		{
			JButton button=(JButton)event.getComponent();
			button.setBorderPainted(false);
			button.setFont(Display.DEFAULT_FONT);
			if(button.equals(black) && buttonSelected.equals(black))
			{
				button.setForeground(Color.white);
			}
			else
			{
				button.setForeground(Color.black);
			}	
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
		Component component=e.getComponent();
		if(!component.equals(buttonSelected)){
			String buttonName=component.getName();
			switch(buttonName){
				case("green"):
					component.setBackground(Color.green);
					break;
				case("yellow"):
					component.setBackground(Color.yellow);
					break;
				case("orange"):
					component.setBackground(Color.orange);
					break;
				case("blue"):
					component.setBackground(Color.blue);
					break;
				case("black"):
					component.setBackground(Color.black);
					component.setForeground(Color.white);
					break;
				case("red"):
					component.setBackground(Color.red);
					break;
				case("pink"):
					component.setBackground(Color.pink);
					break;
				case("lightGray"):
					component.setBackground(Color.lightGray);
					break;
				case("darkGray"):
					component.setBackground(Color.darkGray);
					component.setForeground(Color.white);
					break;
				case("magenta"):
					component.setBackground(Color.magenta);
					break;
				case("cyan"):
					component.setBackground(Color.cyan);
					break;
				case("chocolate1"):
					component.setBackground(chocolate);
					component.setForeground(Color.white);
					break;
				case("peach1"):
					component.setBackground(peach);
					break;
				default:
					component.setBackground(Color.white);
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Component component=e.getComponent();
		if(!component.equals(buttonSelected)){
			component.setBackground(color);
			if(component.getName().equals("black") || component.getName().equals("darkGray") || component.getName().equals("chocolate1")){
				component.setForeground(Color.black);
			}
		}
	}
}
