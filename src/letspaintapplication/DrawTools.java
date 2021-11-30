package letspaintapplication;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class DrawTools extends JPanel implements ActionListener, MouseMotionListener, MouseListener,  KeyListener, FocusListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7682524187297422375L;
	private JButton green, yellow, orange, blue, black, white, red, pink, lightGray, darkGray, magenta, cyan, chocolate1, peach1, buttonSelected;
	//private Graphics buffer;
	//private Image image;
	private Color chocolate=new Color(125,30,45);
	private Color peach=new Color(225,200,195);
	private Whiteboard w;
	private JLabel title;
	private Color color = new Color(217, 187, 169);
	
	public DrawTools(Whiteboard w)
	{
		addMouseMotionListener(this);
		setLayout(new GridLayout(0,1));
		this.w=w;
		title=new JLabel("Draw Colors:");
		title.setFont(Display.DEFAULT_FONT);
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
	    orange.setBackground(color);
	    orange.setOpaque(true);
	    orange.setBorderPainted(false);
	    orange.setFont(Display.DEFAULT_FONT);
	    
	    blue=new JButton("blue");
	    blue.addActionListener(this);
	    blue.addKeyListener(this);
	    blue.addFocusListener(this);
	    blue.setBackground(color);
	    blue.setOpaque(true);
	    blue.setBorderPainted(false);
	    blue.setFont(Display.DEFAULT_FONT);
	    
	    black=new JButton("black");
	    black.addActionListener(this);
	    black.addKeyListener(this);
	    black.addFocusListener(this);
	    black.setBackground(color);
	    black.setOpaque(true);
	    black.setBorderPainted(false);
	    black.setFont(Display.DEFAULT_FONT);
	    
		green=new JButton("green");
		green.addKeyListener(this);
	    green.addActionListener(this);
	    green.addFocusListener(this);
	    green.setBackground(color);
	    green.setOpaque(true);
	    green.setBorderPainted(false);
	    green.setFont(Display.DEFAULT_FONT);
	    
	    yellow=new JButton("yellow");
	    yellow.addActionListener(this);
	    yellow.addKeyListener(this);
	    yellow.addFocusListener(this);
	    yellow.setBackground(color);
	    yellow.setOpaque(true);
	    yellow.setBorderPainted(false);
	    yellow.setFont(Display.DEFAULT_FONT);
	    
	    white=new JButton("white");
	    white.addActionListener(this);
	    white.addKeyListener(this);
	    white.addFocusListener(this);
	    white.setBackground(color);
	    white.setOpaque(true);
	    white.setBorderPainted(false);
	    white.setFont(Display.DEFAULT_FONT);
	    
	    red=new JButton("red");
	    red.addActionListener(this);
	    red.addKeyListener(this);
	    red.addFocusListener(this);
	    red.setBackground(color);
	    red.setOpaque(true);
	    red.setBorderPainted(false);
	    red.setFont(Display.DEFAULT_FONT);
	    
	    darkGray=new JButton("dark gray");
	    darkGray.addActionListener(this);
	    darkGray.addKeyListener(this);
	    darkGray.addFocusListener(this);
	    darkGray.setBackground(color);
	    darkGray.setOpaque(true);
	    darkGray.setBorderPainted(false);
	    darkGray.setFont(Display.DEFAULT_FONT);
	    
	    lightGray=new JButton("light gray");
	    lightGray.addActionListener(this);
	    lightGray.addKeyListener(this);
	    lightGray.addFocusListener(this);
	    lightGray.setBackground(color);
	    lightGray.setOpaque(true);
	    lightGray.setBorderPainted(false);
	    lightGray.setFont(Display.DEFAULT_FONT);
	    
	    pink=new JButton("pink");
	    pink.addActionListener(this);
	    pink.addKeyListener(this);
	    pink.addFocusListener(this);
	    pink.setBackground(color);
	    pink.setOpaque(true);
	    pink.setBorderPainted(false);
	    pink.setFont(Display.DEFAULT_FONT);
	    
	    magenta=new JButton("magenta");
	    magenta.addActionListener(this);
	    magenta.addKeyListener(this);
	    magenta.addFocusListener(this);
	    magenta.setBackground(color);
	    magenta.setOpaque(true);
	    magenta.setBorderPainted(false);
	    magenta.setFont(Display.DEFAULT_FONT);
	    
	    
	    cyan=new JButton("cyan");
	    cyan.addActionListener(this);
	    cyan.addKeyListener(this);
	    cyan.addFocusListener(this);
	    cyan.setBackground(color);
	    cyan.setOpaque(true);
	    cyan.setBorderPainted(false);
	    cyan.setFont(Display.DEFAULT_FONT);
	    
	    chocolate1=new JButton("chocolate");
	    chocolate1.addActionListener(this);
	    chocolate1.addKeyListener(this);
	    chocolate1.addFocusListener(this);
	    chocolate1.setBackground(color);
	    chocolate1.setOpaque(true);
	    chocolate1.setBorderPainted(false);
	    chocolate1.setFont(Display.DEFAULT_FONT);
	    
	    peach1=new JButton("peach");
	    peach1.addActionListener(this);
	    peach1.addKeyListener(this);
	    peach1.addFocusListener(this);
	    peach1.setBackground(color);
	    peach1.setOpaque(true);
	    peach1.setBorderPainted(false);
	    peach1.setFont(Display.DEFAULT_FONT);
	    
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
	
	public DrawTools(Whiteboard w, int x, int y)
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
			changeDrawColor(Color.green,green);
		}
		else if(event.getActionCommand()=="yellow")
		{
			changeDrawColor(Color.yellow,yellow);
		}
		else if(event.getActionCommand()=="orange")
		{
			changeDrawColor(Color.orange,orange);
		}
		else if(event.getActionCommand()=="blue")
		{
			changeDrawColor(Color.blue,blue);
		}
		else if(event.getActionCommand()=="black")
		{
			changeDrawColorToBlack(Color.black,black);
			
		}
		else if(event.getActionCommand()=="light gray")
		{
			changeDrawColor(Color.lightGray,lightGray);
		}
		else if(event.getActionCommand()=="dark gray")
		{
			changeDrawColor(Color.darkGray,darkGray);
		}
		else if(event.getActionCommand()=="red")
		{
			changeDrawColor(Color.red,red);
		}
		else if(event.getActionCommand()=="pink")
		{
			changeDrawColor(Color.pink,pink);
		}
		else if(event.getActionCommand()=="magenta")
		{
			changeDrawColor(Color.magenta,magenta);
		}
		else if(event.getActionCommand()=="cyan")
		{
			changeDrawColor(Color.cyan,cyan);
		}
		else if(event.getActionCommand()=="white")
		{
			changeDrawColor(Color.white,white);
		}
		else if(event.getActionCommand()=="chocolate")
		{
			changeDrawColor(chocolate,chocolate1);
		}
		else if(event.getActionCommand()=="peach")
		{
			changeDrawColor(peach,peach1);
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
	public void mouseClicked(MouseEvent event) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent event) 
	{
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if(event.getKeyCode()==KeyEvent.VK_ENTER)
		{
			if(event.getComponent().equals(green))
			{
				changeDrawColor(Color.green,green);
			
			}
			else if(event.getComponent().equals(yellow))
			{
				changeDrawColor(Color.yellow,yellow);
			}
			else if(event.getComponent().equals(orange))
			{
				changeDrawColor(Color.orange,orange);
			}
			else if(event.getComponent().equals(blue))
			{
				changeDrawColor(Color.blue,blue);
				
			}
			else if(event.getComponent().equals(black))
			{
				changeDrawColorToBlack(Color.black,black);
			}
			else if(event.getComponent().equals(lightGray))
			{
				changeDrawColor(Color.lightGray,lightGray);
			}
			else if(event.getComponent().equals(darkGray))
			{
				changeDrawColor(Color.darkGray,darkGray);
			}
			else if(event.getComponent().equals(red))
			{
				changeDrawColor(Color.red,red);
			}
			else if(event.getComponent().equals(pink))
			{
				changeDrawColor(Color.pink,pink);
			}
			else if(event.getComponent().equals(magenta))
			{
				changeDrawColor(Color.magenta,magenta);
			}
			else if(event.getComponent().equals(cyan))
			{
				changeDrawColor(Color.cyan,cyan);
			}
			else if(event.getComponent().equals(white))
			{
				changeDrawColor(Color.white,white);
			}		
			else if(event.getComponent().equals(chocolate1))
			{
				changeDrawColor(chocolate,chocolate1);
			}
			else if(event.getComponent().equals(peach1))
			{
				changeDrawColor(peach,peach1);
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void changeDrawColor(Color newColor, JButton selectedButton)
	{
		buttonSelected.setBackground(color);
		if(buttonSelected.equals(black))
		{
			buttonSelected.setForeground(Color.black);
		}
		w.setDrawColor(newColor);
		buttonSelected=selectedButton;
		buttonSelected.setBackground(newColor);
		w.requestFocusInWindow();
	}
	
	private void changeDrawColorToBlack(Color newColor, JButton selectedButton)
	{
		buttonSelected.setBackground(color);
		w.setDrawColor(newColor);
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
}
