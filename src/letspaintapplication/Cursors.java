package letspaintapplication;

import java.awt.*;
import java.awt.event.*;
import java.io.Serial;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Cursors extends JPanel implements ActionListener, KeyListener, FocusListener,MouseListener
{
	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = 5217787022390475320L;
	private JButton textCursor, drawCursor, pointerCursor,eraseCursor, paintCursor, paintFillCursor, paintAllCursor, eraseAllCursor, buttonSelected;
	private Whiteboard w;
	private JLabel title;
	private Color buttonSelectedColor=Color.white;
	private Color color=new Color(217, 187, 169);
	private Color buttonHoverColor=new Color(245, 233, 225);
	
	public Cursors(Whiteboard w)
	{
		setName("Colors");
		setLayout(new FlowLayout());
		
		title=new JLabel("Tools: ");
		title.setFont(Display.DEFAULT_FONT);
		title.setBorder(new EmptyBorder(1,1,1,1));
		add(title);
		setBackground(color);
		setOpaque(true);
		
		textCursor=new JButton("text");
		textCursor.addActionListener(this);
		textCursor.addKeyListener(this);
		textCursor.addFocusListener(this);
		textCursor.addMouseListener(this);
		textCursor.setBackground(color);
		textCursor.setOpaque(true);
		textCursor.setBorderPainted(false);
		textCursor.setFont(Display.DEFAULT_FONT);
		int borderWidth=1;
		title.setBackground(Color.yellow);
		title.setOpaque(true);
		title.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black, 5, true),new EmptyBorder(borderWidth,borderWidth,borderWidth,borderWidth)));
		setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black, 5, true),new EmptyBorder(borderWidth,borderWidth,borderWidth,borderWidth)));
		
		
		drawCursor=new JButton("draw");
		drawCursor.addActionListener(this);
		drawCursor.addKeyListener(this);
		drawCursor.addFocusListener(this);
		drawCursor.addMouseListener(this);
		drawCursor.setBackground(color);
		drawCursor.setOpaque(true);
		drawCursor.setBorderPainted(false);
		drawCursor.setFont(Display.DEFAULT_FONT);
		
		pointerCursor=new JButton("pointer");
		pointerCursor.addActionListener(this);
		pointerCursor.addKeyListener(this);
		pointerCursor.addFocusListener(this);
		pointerCursor.addMouseListener(this);
		pointerCursor.setBackground(color);
		pointerCursor.setOpaque(true);
		pointerCursor.setBorderPainted(false);
		pointerCursor.setFont(Display.DEFAULT_FONT);
		
		eraseCursor=new JButton("erase");
		eraseCursor.addActionListener(this);
		eraseCursor.addKeyListener(this);
		eraseCursor.addFocusListener(this);
		eraseCursor.addMouseListener(this);
		eraseCursor.setBackground(color);
		eraseCursor.setOpaque(true);
		eraseCursor.setBorderPainted(false);
		eraseCursor.setFont(Display.DEFAULT_FONT);
		
		paintCursor=new JButton("paint");
		paintCursor.addActionListener(this);
		paintCursor.addKeyListener(this);
		paintCursor.addFocusListener(this);
		paintCursor.addMouseListener(this);
		paintCursor.setBackground(color);
		paintCursor.setOpaque(true);
		paintCursor.setBorderPainted(false);
		paintCursor.setFont(Display.DEFAULT_FONT);
		
		paintFillCursor=new JButton("paint fill");
		paintFillCursor.addActionListener(this);
		paintFillCursor.addKeyListener(this);
		paintFillCursor.addFocusListener(this);
		paintFillCursor.addMouseListener(this);
		paintFillCursor.setBackground(color);
		paintFillCursor.setOpaque(true);
		paintFillCursor.setBorderPainted(false);
		paintFillCursor.setFont(Display.DEFAULT_FONT);
		
		paintAllCursor=new JButton("paint all");
		paintAllCursor.addActionListener(this);
		paintAllCursor.addKeyListener(this);
		paintAllCursor.addFocusListener(this);
		paintAllCursor.addMouseListener(this);
		paintAllCursor.setBackground(color);
		paintAllCursor.setOpaque(true);
		paintAllCursor.setBorderPainted(false);
		paintAllCursor.setFont(Display.DEFAULT_FONT);
		
		eraseAllCursor=new JButton("erase all");
		eraseAllCursor.addActionListener(this);
		eraseAllCursor.addKeyListener(this);
		eraseAllCursor.addFocusListener(this);
		eraseAllCursor.addMouseListener(this);
		eraseAllCursor.setBackground(color);
		eraseAllCursor.setOpaque(true);
		eraseAllCursor.setBorderPainted(false);
		eraseAllCursor.setFont(Display.DEFAULT_FONT);
		
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
		buttonSelected.setOpaque(true);
		buttonSelected.setBorderPainted(false);
	}
		
	@Override
	public void actionPerformed(ActionEvent event) 
	{
		// TODO Auto-generated method stub
		if(event.getActionCommand().equals("text"))
		{
			changeCursorToText();
		}
		else if(event.getActionCommand().equals("draw"))
		{
			changeCursorToDraw();
		}
		else if(event.getActionCommand().equals("pointer"))
		{
			changeCursorToPointer();
		}
		else if(event.getActionCommand().equals("erase"))
		{
			changeCursorToEraser();
		}
		else if(event.getActionCommand().equals("paint"))
		{
			changeCursorToPaint();
		}
		else if(event.getActionCommand().equals("paint fill"))
		{
			changeCursorToPaintFill();
		}
		else if(event.getActionCommand().equals("paint all"))
		{
			changeCursorToPaintAll();
		}
		else if(event.getActionCommand().equals("erase all"))
		{
			changeCursorToEraserAll();
		}
	}
	
	private Cursor createPaintBrushCursor()
	{
		Toolkit toolkit=Toolkit.getDefaultToolkit();
	  	Image image=toolkit.getImage(Cursors.class.getClassLoader().getResource("brush.png"));
		//image.getGraphics().setColor(w.getBackground());
		Point hotSpot=new Point(0,0);
		Cursor c=toolkit.createCustomCursor(image, hotSpot, "brush");
	  	return c;
	}
	
	private Cursor createPencilCursor()
	{
	  	Toolkit toolkit=Toolkit.getDefaultToolkit();
	  	Image image=toolkit.getImage(Cursors.class.getClassLoader().getResource("pencil.png"));
		//image.getGraphics().setColor(w.getBackground());
		Point hotSpot=new Point(0,0);
		Cursor c=toolkit.createCustomCursor(image, hotSpot, "pencil");
	  	return c;
	}
	
	private Cursor createEraserCursor()
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
//		if(event.getKeyCode()==Display.CONFIRM_KEY) 
//		{
//			if(event.getComponent().equals(textCursor))
//			{
//				changeCursorToText();
//			}
//			else if(event.getComponent().equals(drawCursor))
//			{
//				changeCursorToDraw();
//			}
//			else if(event.getComponent().equals(pointerCursor))
//			{
//				changeCursorToPointer();
//			}
//			else if(event.getComponent().equals(eraseCursor))
//			{
//				changeCursorToEraser();
//			}
//			else if(event.getComponent().equals(paintCursor))
//			{
//				changeCursorToPaint();
//			}
//			else if(event.getComponent().equals(paintFillCursor))
//			{
//				changeCursorToPaintFill();
//			}
//			else if(event.getComponent().equals(paintAllCursor))
//			{
//				changeCursorToPaintAll();
//			}
//			else if(event.getComponent().equals(eraseCursor))
//			{
//				changeCursorToEraser();
//			}
//			else if(event.getComponent().equals(eraseAllCursor))
//			{
//				changeCursorToEraserAll();
//			}
//		}
		
	}

	@Override
	public void keyReleased(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent event) 
	{
		// TODO Auto-generated method stub
		
	}
	
	private void changeCursorToText()
	{
		buttonSelected.setBackground(color);	
		buttonSelected.setForeground(Color.black);	
		Cursor c=new Cursor(Cursor.TEXT_CURSOR);
		w.setCursor2(c);
		w.setButtonSelected("text");
		buttonSelected=textCursor;
		buttonSelected.setBackground(buttonSelectedColor);
		buttonSelected.setOpaque(true);
		buttonSelected.setBorderPainted(false);
		w.requestFocusInWindow();
	}
	
	private void changeCursorToDraw()
	{
		buttonSelected.setBackground(color);	
		buttonSelected.setForeground(Color.black);	
		w.setCursor2(createPencilCursor());
		//w.setCursor2(new Cursor(Cursor.CROSSHAIR_CURSOR));
		w.setButtonSelected("draw");
		buttonSelected=drawCursor;
		buttonSelected.setBackground(buttonSelectedColor);
		buttonSelected.setOpaque(true);
		buttonSelected.setBorderPainted(false);
		w.requestFocusInWindow();
	}
	
	private void changeCursorToPointer()
	{
		buttonSelected.setBackground(color);	
		buttonSelected.setForeground(Color.black);	
		Cursor c=new Cursor(Cursor.DEFAULT_CURSOR);
		w.setCursor2(c);		
		w.setButtonSelected("pointer");
		buttonSelected=pointerCursor;
		buttonSelected.setBackground(buttonSelectedColor);
		buttonSelected.setOpaque(true);
		buttonSelected.setBorderPainted(false);
		w.requestFocusInWindow();
	}
	
	private void changeCursorToEraser()
	{
		buttonSelected.setBackground(color);	
		buttonSelected.setForeground(Color.black);	
		w.setCursor2(createEraserCursor());
		//w.setCursor2(new Cursor(Cursor.HAND_CURSOR));
		w.setButtonSelected("erase");
		buttonSelected=eraseCursor;
		buttonSelected.setBackground(buttonSelectedColor);
		buttonSelected.setOpaque(true);
		buttonSelected.setBorderPainted(false);
		w.requestFocusInWindow();
	}
	
	private void changeCursorToPaint()
	{
		buttonSelected.setBackground(color);
		buttonSelected.setForeground(Color.black);	
		w.setCursor2(createPaintBrushCursor());
		//w.setCursor2(new Cursor(Cursor.HAND_CURSOR));
		w.setButtonSelected("paint");
		buttonSelected=paintCursor;
		buttonSelected.setBackground(buttonSelectedColor);
		buttonSelected.setOpaque(true);
		buttonSelected.setBorderPainted(false);
		w.requestFocusInWindow();
	}
	
	private void changeCursorToPaintFill()
	{
		buttonSelected.setBackground(color);
		buttonSelected.setForeground(Color.black);	
		w.setCursor2(createPaintBrushCursor());
		//w.setCursor2(new Cursor(Cursor.HAND_CURSOR));
		w.setButtonSelected("paint fill");
		buttonSelected=paintFillCursor;
		buttonSelected.setBackground(buttonSelectedColor);
		buttonSelected.setOpaque(true);
		buttonSelected.setBorderPainted(false);
		w.requestFocusInWindow();
	}
	
	private void changeCursorToPaintAll()
	{
		buttonSelected.setBackground(color);
		buttonSelected.setForeground(Color.black);	
		w.setCursor2(createPaintBrushCursor());
		//w.setCursor2(new Cursor(Cursor.HAND_CURSOR));
		w.setButtonSelected("paint all");
		buttonSelected=paintAllCursor;
		buttonSelected.setBackground(buttonSelectedColor);
		buttonSelected.setOpaque(true);
		buttonSelected.setBorderPainted(false);
		w.requestFocusInWindow();
	}
	
	private void changeCursorToEraserAll()
	{
		buttonSelected.setBackground(color);	
		buttonSelected.setForeground(Color.black);	
		w.setCursor2(createEraserCursor());
		//w.setCursor2(new Cursor(Cursor.HAND_CURSOR));
		w.setButtonSelected("erase all");
		buttonSelected=eraseAllCursor;
		buttonSelected.setBackground(buttonSelectedColor);
		buttonSelected.setOpaque(true);
		buttonSelected.setBorderPainted(false);
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
			button.setForeground(Color.black);
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
		if(!e.getComponent().equals(buttonSelected)){
			e.getComponent().setBackground(buttonHoverColor);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(!e.getComponent().equals(buttonSelected)){
			e.getComponent().setBackground(color);
		}
	}
}
