package letspaintapplication;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Cursors extends JPanel implements ActionListener, KeyListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5217787022390475320L;
	private JButton textCursor, drawCursor, pointerCursor,eraseCursor, paintCursor, paintFillCursor, paintAllCursor, eraseAllCursor, buttonSelected;
	private Whiteboard w;
	private JLabel title;
	private Color buttonSelectedColor=new Color(77, 106, 148);
	private Color buttonSelectedTextColor=Color.white;
	private Color color=new Color(217, 187, 169);
	private Font font=new Font("Sans Serif", Font.BOLD, 20);
	
	
	public Cursors(Whiteboard w)
	{
		setName("Colors");
		setLayout(new FlowLayout());
		
		title=new JLabel("Tools: ");
		title.setFont(font);
		title.setBorder(new EmptyBorder(1,1,1,1));
		add(title);
		setBackground(color);
		setOpaque(true);
		
		textCursor=new JButton("text");
		textCursor.addActionListener(this);
		textCursor.setBackground(color);
		textCursor.setOpaque(true);
		textCursor.setBorderPainted(false);
		textCursor.setFont(font);
		int borderWidth=30;
		title.setBackground(Color.yellow);
		title.setOpaque(true);
		title.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black, 5, true),new EmptyBorder(borderWidth,borderWidth,borderWidth,borderWidth)));
		setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black, 5, true),new EmptyBorder(borderWidth,borderWidth,borderWidth,borderWidth)));
		
		
		drawCursor=new JButton("draw");
		drawCursor.addActionListener(this);
		drawCursor.setBackground(color);
		drawCursor.setOpaque(true);
		drawCursor.setBorderPainted(false);
		drawCursor.setFont(font);
		
		pointerCursor=new JButton("pointer");
		pointerCursor.addActionListener(this);
		pointerCursor.setBackground(color);
		pointerCursor.setOpaque(true);
		pointerCursor.setBorderPainted(false);
		pointerCursor.setFont(font);
		
		eraseCursor=new JButton("erase");
		eraseCursor.addActionListener(this);
		eraseCursor.setBackground(color);
		eraseCursor.setOpaque(true);
		eraseCursor.setBorderPainted(false);
		eraseCursor.setFont(font);
		
		paintCursor=new JButton("paint");
		paintCursor.addActionListener(this);
		paintCursor.setBackground(color);
		paintCursor.setOpaque(true);
		paintCursor.setBorderPainted(false);
		paintCursor.setFont(font);
		
		paintFillCursor=new JButton("paint fill");
		paintFillCursor.addActionListener(this);
		paintFillCursor.addKeyListener(this);
		paintFillCursor.setBackground(color);
		paintFillCursor.setOpaque(true);
		paintFillCursor.setBorderPainted(false);
		paintFillCursor.setFont(font);
		
		paintAllCursor=new JButton("paint all");
		paintAllCursor.addActionListener(this);
		paintAllCursor.addKeyListener(this);
		paintAllCursor.setBackground(color);
		paintAllCursor.setOpaque(true);
		paintAllCursor.setBorderPainted(false);
		paintAllCursor.setFont(font);
		
		eraseAllCursor=new JButton("erase all");
		eraseAllCursor.addActionListener(this);
		eraseAllCursor.setBackground(color);
		eraseAllCursor.setOpaque(true);
		eraseAllCursor.setBorderPainted(false);
		eraseAllCursor.setFont(font);
		
		this.w=w;
		add(textCursor);
		add(drawCursor);
		add(pointerCursor);
		add(eraseCursor);
		add(paintCursor);
		add(paintFillCursor);
		add(paintAllCursor);
		add(eraseAllCursor);
		
		buttonSelected=paintCursor;
		buttonSelected.setBackground(new Color(238,238,238));	
		w.setCursor2(createPaintBrushCursor());
		//w.setCursor2(new Cursor(Cursor.HAND_CURSOR));
		w.setButtonSelected("paint");
		buttonSelected=paintCursor;
		buttonSelected.setBackground(buttonSelectedColor);
		buttonSelected.setForeground(buttonSelectedTextColor);
		buttonSelected.setOpaque(true);
		buttonSelected.setBorderPainted(false);
	}
		
	@Override
	public void actionPerformed(ActionEvent event) 
	{
		// TODO Auto-generated method stub
		if(event.getActionCommand()=="text")
		{
			buttonSelected.setBackground(color);	
			buttonSelected.setForeground(Color.black);	
			Cursor c=new Cursor(Cursor.TEXT_CURSOR);
			w.setCursor2(c);
			w.setButtonSelected("text");
			buttonSelected=textCursor;
			buttonSelected.setBackground(buttonSelectedColor);
			buttonSelected.setForeground(buttonSelectedTextColor);
			buttonSelected.setOpaque(true);
			buttonSelected.setBorderPainted(false);
		}
		else if(event.getActionCommand()=="draw")
		{
			buttonSelected.setBackground(color);	
			buttonSelected.setForeground(Color.black);	
			w.setCursor2(createPencilCursor());
			//w.setCursor2(new Cursor(Cursor.CROSSHAIR_CURSOR));
			w.setButtonSelected("draw");
			buttonSelected=drawCursor;
			buttonSelected.setBackground(buttonSelectedColor);
			buttonSelected.setForeground(buttonSelectedTextColor);
			buttonSelected.setOpaque(true);
			buttonSelected.setBorderPainted(false);
		}
		else if(event.getActionCommand()=="pointer")
		{
			buttonSelected.setBackground(color);	
			buttonSelected.setForeground(Color.black);	
			Cursor c=new Cursor(Cursor.DEFAULT_CURSOR);
			w.setCursor2(c);		
			w.setButtonSelected("pointer");
			buttonSelected=pointerCursor;
			buttonSelected.setBackground(buttonSelectedColor);
			buttonSelected.setForeground(buttonSelectedTextColor);
			buttonSelected.setOpaque(true);
			buttonSelected.setBorderPainted(false);
		}
		else if(event.getActionCommand()=="erase")
		{
			buttonSelected.setBackground(color);	
			buttonSelected.setForeground(Color.black);	
			w.setCursor2(createEraserCursor());
			//w.setCursor2(new Cursor(Cursor.HAND_CURSOR));
			w.setButtonSelected("erase");
			buttonSelected=eraseCursor;
			buttonSelected.setBackground(buttonSelectedColor);
			buttonSelected.setForeground(buttonSelectedTextColor);
			buttonSelected.setOpaque(true);
			buttonSelected.setBorderPainted(false);
		}
		else if(event.getActionCommand()=="paint")
		{
			buttonSelected.setBackground(color);
			buttonSelected.setForeground(Color.black);	
			w.setCursor2(createPaintBrushCursor());
			//w.setCursor2(new Cursor(Cursor.HAND_CURSOR));
			w.setButtonSelected("paint");
			buttonSelected=paintCursor;
			buttonSelected.setBackground(buttonSelectedColor);
			buttonSelected.setForeground(buttonSelectedTextColor);
			buttonSelected.setOpaque(true);
			buttonSelected.setBorderPainted(false);
		}
		else if(event.getActionCommand()=="paint fill")
		{
			buttonSelected.setBackground(color);	
			buttonSelected.setForeground(Color.black);	
			w.setCursor2(createPaintBrushCursor());
			//w.setCursor2(new Cursor(Cursor.HAND_CURSOR));
			w.setButtonSelected("paint fill");
			buttonSelected=paintFillCursor;
			buttonSelected.setBackground(buttonSelectedColor);
			buttonSelected.setForeground(buttonSelectedTextColor);
			buttonSelected.setOpaque(true);
			buttonSelected.setBorderPainted(false);
		}
		else if(event.getActionCommand()=="paint all")
		{
			buttonSelected.setBackground(color);	
			buttonSelected.setForeground(Color.black);	
			w.setCursor2(createPaintBrushCursor());
			//w.setCursor2(new Cursor(Cursor.HAND_CURSOR));
			w.setButtonSelected("paint all");
			buttonSelected=paintAllCursor;
			buttonSelected.setBackground(buttonSelectedColor);
			buttonSelected.setForeground(buttonSelectedTextColor);
			buttonSelected.setOpaque(true);
			buttonSelected.setBorderPainted(false);
		}
		else if(event.getActionCommand()=="erase all")
		{
			buttonSelected.setBackground(color);	
			buttonSelected.setForeground(Color.black);	
			w.setCursor2(createEraserCursor());
			//w.setCursor2(new Cursor(Cursor.HAND_CURSOR));
			w.setButtonSelected("erase all");
			buttonSelected=eraseAllCursor;
			buttonSelected.setBackground(buttonSelectedColor);
			buttonSelected.setForeground(buttonSelectedTextColor);
			buttonSelected.setOpaque(true);
			buttonSelected.setBorderPainted(false);
		}
	}
	public Cursor createPaintBrushCursor()
	{
		
		Toolkit toolkit=Toolkit.getDefaultToolkit();
	  	Image image=toolkit.getImage(Cursors.class.getClassLoader().getResource("brush.png"));
		//image.getGraphics().setColor(w.getBackground());
		Point hotSpot=new Point(0,0);
		Cursor c=toolkit.createCustomCursor(image, hotSpot, "brush");
	  	return c;
	}
	
	public Cursor createPencilCursor()
	{
	  	Toolkit toolkit=Toolkit.getDefaultToolkit();
	  	Image image=toolkit.getImage(Cursors.class.getClassLoader().getResource("pencil.png"));
		//image.getGraphics().setColor(w.getBackground());
		Point hotSpot=new Point(0,0);
		Cursor c=toolkit.createCustomCursor(image, hotSpot, "pencil");
	  	return c;
	}
	
	public Cursor createEraserCursor()
	{
		Toolkit toolkit=Toolkit.getDefaultToolkit();
	  	Image image=toolkit.getImage(Cursors.class.getClassLoader().getResource("erase.png"));
	  	//image.getGraphics().setColor(w.getBackground());
	  	Point hotSpot=new Point(0,0);
	  	Cursor c=toolkit.createCustomCursor(image, hotSpot, "eraser");
	  	return c;
	}


	@Override
	public void keyPressed(KeyEvent event) 
	{
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if(event.getKeyCode()==KeyEvent.VK_ENTER) 
		{
			if(event.getComponent().equals(textCursor))
			{
				buttonSelected.setBackground(new Color(238,238,238));
				buttonSelected.setForeground(Color.black);	
				Cursor c=new Cursor(Cursor.TEXT_CURSOR);
				w.setCursor2(c);
				w.setButtonSelected("text");
				buttonSelected=textCursor;
				buttonSelected.setBackground(buttonSelectedColor);
				buttonSelected.setForeground(buttonSelectedTextColor);
			}
			else if(event.getComponent().equals(drawCursor))
			{
				buttonSelected.setBackground(new Color(238,238,238));
				buttonSelected.setForeground(Color.black);	
				w.setCursor2(createPencilCursor());
				//w.setCursor2(new Cursor(Cursor.CROSSHAIR_CURSOR));
				w.setButtonSelected("draw");
				buttonSelected=drawCursor;
				buttonSelected.setBackground(buttonSelectedColor);
				buttonSelected.setForeground(buttonSelectedTextColor);
			}
			else if(event.getComponent().equals(pointerCursor))
			{
				buttonSelected.setBackground(new Color(238,238,238));	
				buttonSelected.setForeground(Color.black);	
				Cursor c=new Cursor(Cursor.DEFAULT_CURSOR);
				w.setCursor2(c);		
				w.setButtonSelected("pointer");
				buttonSelected=pointerCursor;
				buttonSelected.setBackground(buttonSelectedColor);
				buttonSelected.setForeground(buttonSelectedTextColor);
			}
			else if(event.getComponent().equals(eraseCursor))
			{
				buttonSelected.setBackground(new Color(238,238,238));
				buttonSelected.setForeground(Color.black);	
				w.setCursor2(createEraserCursor());
				//w.setCursor2(new Cursor(Cursor.HAND_CURSOR));
				w.setButtonSelected("erase");
				buttonSelected=eraseCursor;
				buttonSelected.setBackground(buttonSelectedColor);
				buttonSelected.setForeground(buttonSelectedTextColor);
			}
			else if(event.getComponent().equals(paintCursor))
			{
				buttonSelected.setBackground(new Color(238,238,238));
				buttonSelected.setForeground(Color.black);	
				w.setCursor2(createPaintBrushCursor());
				//w.setCursor2(new Cursor(Cursor.HAND_CURSOR));
				w.setButtonSelected("paint");
				buttonSelected=paintCursor;
				buttonSelected.setBackground(buttonSelectedColor);
				buttonSelected.setForeground(buttonSelectedTextColor);
			}
			else if(event.getComponent().equals(paintFillCursor))
			{
				buttonSelected.setBackground(new Color(238,238,238));
				buttonSelected.setForeground(Color.black);	
				w.setCursor2(createPaintBrushCursor());
				//w.setCursor2(new Cursor(Cursor.HAND_CURSOR));
				w.setButtonSelected("paint fill");
				buttonSelected=paintFillCursor;
				buttonSelected.setBackground(buttonSelectedColor);
				buttonSelected.setForeground(buttonSelectedTextColor);
			}
			else if(event.getComponent().equals(paintAllCursor))
			{
				buttonSelected.setBackground(new Color(238,238,238));
				buttonSelected.setForeground(Color.black);	
				w.setCursor2(createPaintBrushCursor());
				//w.setCursor2(new Cursor(Cursor.HAND_CURSOR));
				w.setButtonSelected("paint all");
				buttonSelected=paintFillCursor;
				buttonSelected.setBackground(buttonSelectedColor);
				buttonSelected.setForeground(buttonSelectedTextColor);
			}
			else if(event.getComponent().equals(eraseCursor))
			{
				buttonSelected.setBackground(new Color(238,238,238));	
				buttonSelected.setForeground(Color.black);	
				w.setCursor2(createPaintBrushCursor());
				//w.setCursor2(new Cursor(Cursor.HAND_CURSOR));
				w.setButtonSelected("paint all");
				buttonSelected=paintAllCursor;
				buttonSelected.setBackground(buttonSelectedColor);
				buttonSelected.setForeground(buttonSelectedTextColor);
			}
			else if(event.getComponent().equals(eraseAllCursor))
			{
				buttonSelected.setBackground(new Color(238,238,238));	
				buttonSelected.setForeground(Color.black);	
				w.setCursor2(createEraserCursor());
				//w.setCursor2(new Cursor(Cursor.HAND_CURSOR));
				w.setButtonSelected("erase all");
				buttonSelected=eraseAllCursor;
				buttonSelected.setBackground(buttonSelectedColor);
				buttonSelected.setForeground(buttonSelectedTextColor);
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent event) 
	{
		// TODO Auto-generated method stub
		
	}
	
	
}
