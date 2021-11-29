package letspaintapplication;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class FontTools extends JPanel implements ActionListener, MouseMotionListener, KeyListener, FocusListener
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4011362814260279589L;
	private JButton green, yellow, orange, blue, black, white, red, pink, lightGray, darkGray, magenta, cyan, buttonSelected, chocolate1, peach1;
	//private Graphics buffer;
	//private Image image;
	private Color chocolate=new Color(125,30,45);
	private Color peach=new Color(225,200,195);
	private Whiteboard w;
	private JLabel title;
	private Color color=new Color(217, 187, 169);
	private Font font=new Font("Sans Serif", Font.BOLD, 20);
	
	public FontTools(Whiteboard w)
	{
		addMouseMotionListener(this);
		setLayout(new GridLayout(0,1));
		this.w=w;
		title=new JLabel("Font Colors:");
		title.setFont(new Font("Sans Serif", Font.BOLD, 20));
		title.setBackground(new Color(77, 106, 148));
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
	    //orange.setBackground(color);
	    orange.setOpaque(true);
	    orange.setBorderPainted(false);
	    orange.setFont(font);
	    
	    blue=new JButton("blue");
	    blue.addActionListener(this);
	    blue.addKeyListener(this);
	    blue.addFocusListener(this);
	    //blue.setBackground(color);
	    blue.setOpaque(true);
	    blue.setBorderPainted(false);
	    blue.setFont(font);
	    
	    black=new JButton("black");
	    black.addActionListener(this);
	    black.addKeyListener(this);
	    black.addFocusListener(this);
	    //black.setBackground(color);
	    black.setOpaque(true);
	    black.setBorderPainted(false);
	    black.setFont(font);
	    
		green=new JButton("green");
	    green.addActionListener(this);
	    green.addKeyListener(this);
	    green.addFocusListener(this);
	    //green.setBackground(color);
	    green.setOpaque(true);
	    green.setBorderPainted(false);
	    green.setFont(font);
	    
	    yellow=new JButton("yellow");
	    yellow.addActionListener(this);
	    yellow.addKeyListener(this);
	    yellow.setBackground(color);
	    yellow.setOpaque(true);
	    yellow.setBorderPainted(false);
	    yellow.setFont(font);
	    
	    white=new JButton("white");
	    white.addActionListener(this);
	    white.addKeyListener(this);
	    white.setBackground(color);
	    white.setOpaque(true);
	    white.setBorderPainted(false);
	    white.setFont(font);
	    
	    red=new JButton("red");
	    red.addActionListener(this);
	    red.addKeyListener(this);
	    red.setBackground(color);
	    red.setOpaque(true);
	    red.setBorderPainted(false);
	    red.setFont(font);
	    
	    darkGray=new JButton("dark gray");
	    darkGray.addActionListener(this);
	    darkGray.addKeyListener(this);
	    darkGray.setBackground(color);
	    darkGray.setOpaque(true);
	    darkGray.setBorderPainted(false);
	    darkGray.setFont(font);
	    
	    lightGray=new JButton("light gray");
	    lightGray.addActionListener(this);
	    lightGray.addKeyListener(this);
	    lightGray.setBackground(color);
	    lightGray.setOpaque(true);
	    lightGray.setBorderPainted(false);
	    lightGray.setFont(font);
	    
	    pink=new JButton("pink");
	    pink.addActionListener(this);
	    pink.addKeyListener(this);
	    pink.setBackground(color);
	    pink.setOpaque(true);
	    pink.setBorderPainted(false);
	    pink.setFont(font);
	    
	    magenta=new JButton("magenta");
	    magenta.addActionListener(this);
	    magenta.addKeyListener(this);
	    magenta.setBackground(color);
	    magenta.setOpaque(true);
	    magenta.setBorderPainted(false);
	    magenta.setFont(font);
	    
	    cyan=new JButton("cyan");
	    cyan.addActionListener(this);
	    cyan.addKeyListener(this);
	    cyan.setBackground(color);
	    cyan.setOpaque(true);
	    cyan.setBorderPainted(false);
	    cyan.setFont(font);
	
	    chocolate1=new JButton("chocolate");
	    chocolate1.addActionListener(this);
	    chocolate1.addKeyListener(this);
	    chocolate1.setBackground(color);
	    chocolate1.setOpaque(true);
	    chocolate1.setBorderPainted(false);
	    chocolate1.setFont(font);

	    peach1=new JButton("peach");
	    peach1.addActionListener(this);
	    peach1.addKeyListener(this);
	    peach1.setBackground(color);
	    peach1.setOpaque(true);
	    peach1.setBorderPainted(false);
	    peach1.setFont(font);
	    
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
			changeFontColor(Color.black,black);
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
			changeFontColorToWhite(Color.white,white);
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
		if(event.getKeyCode()==KeyEvent.VK_ENTER)
		{
			if(event.getComponent().equals(green))
			{
				changeFontColor(Color.green,green);
			}
			else if(event.getComponent().equals(yellow))
			{
				changeFontColor(Color.yellow,yellow);
			}
			else if(event.getComponent().equals(orange))
			{
				changeFontColor(Color.orange,orange);
			}
			else if(event.getComponent().equals(blue))
			{
				changeFontColor(Color.blue,blue);
			}
			else if(event.getComponent().equals(black))
			{
				changeFontColor(Color.black,black);
			}
			else if(event.getComponent().equals(lightGray))
			{
				changeFontColor(Color.lightGray,lightGray);
			}
			else if(event.getComponent().equals(darkGray))
			{
				changeFontColor(Color.darkGray,darkGray);
			}
			else if(event.getComponent().equals(red))
			{
				changeFontColor(Color.red,red);
			}
			else if(event.getComponent().equals(pink))
			{
				changeFontColor(Color.pink,pink);
			}
			else if(event.getComponent().equals(magenta))
			{
				changeFontColor(Color.magenta,magenta);
			}
			else if(event.getComponent().equals(cyan))
			{
				changeFontColor(Color.cyan,cyan);
			}
			else if(event.getComponent().equals(white))
			{
				changeFontColorToWhite(Color.white,white);
			}		
			else if(event.getComponent().equals(chocolate1))
			{
				changeFontColor(chocolate,chocolate1);
			}
			else if(event.getComponent().equals(peach1))
			{
				changeFontColor(peach,peach1);
			}
		}
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
		buttonSelected.setForeground(Color.black);
		w.setFontColor(newColor);
		buttonSelected=selectedButton;
		buttonSelected.setBackground(newColor);
		buttonSelected.setForeground(Color.white);
		w.requestFocusInWindow();
	}
	
	private void changeFontColorToWhite(Color newColor, JButton selectedButton)
	{
		buttonSelected.setBackground(color);
		buttonSelected.setForeground(Color.black);
		w.setFontColor(newColor);
		buttonSelected=selectedButton;
		buttonSelected.setBackground(newColor);
		w.requestFocusInWindow();
	}

	@Override
	public void focusGained(FocusEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent event) {
		// TODO Auto-generated method stub
		
	}

}
