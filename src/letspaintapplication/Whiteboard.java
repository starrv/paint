package letspaintapplication;


import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import javax.swing.*;

/** An applet that lets you perform freehand drawing.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, 
 *  servlets, JSP, and Java 7 and Java 8 programming</a>.
 */

public class Whiteboard extends JPanel implements MouseListener, MouseMotionListener, KeyListener, Pageable
{
  
	/**
	 * 
	 */
	private static final long serialVersionUID = -7519408491395424533L;
	protected int lastX=0, lastY=0;
	protected int getXLocation, getYLocation;
	protected BufferedImage image, backUpImage;
	protected Graphics2D buffer, backup, g2;
	protected String hello;
	protected Ellipse2D o;
	protected Color drawColor, fontColor, backGround;
	protected Cursor cursor;
	protected String fontFamily, buttonSelected;
	protected int fontStyle, fontSize, imageWidth, imageHeight;
	protected FontMetrics fm;
  
  public Whiteboard(int w, int h) 
  {
	setName("Paint");
	cursor=new Cursor(Cursor.DEFAULT_CURSOR);
	setSize(w,h);
	imageWidth=getWidth();
	imageHeight=getHeight();
	drawColor=Color.black;
	fontColor=Color.black;
	backGround=Color.white;
    setBackground(backGround);
    setForeground(fontColor);
    addMouseListener(this);
    addMouseMotionListener(this);
    addKeyListener(this);
    fontFamily="Sans Serif";
    fontStyle=Font.PLAIN;
    buttonSelected="pointer";
    fontSize=12;
    image=null;
    Font font = new Font("Sans Serif", Font.BOLD, 20);
    setFont(font);
    fm = getFontMetrics(font);
    setBorder(BorderFactory.createLineBorder(Color.black, 5, true));
    setOpaque(true);
    setVisible(true);
    //o=new Ellipse2D.Double(getXLocation, getYLocation, 10, 10);
    
  }
  
 @Override
 public void paintComponent(Graphics g)
 {
	 Graphics2D g2=(Graphics2D)g;
	 g2.drawImage(image, 0, 0, this);
	 //Functions.printMessage("repaint from paint");
  }
 
  public void setButtonSelected(String s)
  {
	  buttonSelected=s;
  }
  public void setCursor2(Cursor c)
  {
 	 cursor=c;
 	 setCursor(c);
  }
  
  public void setFontColor(Color c)
  {
	  fontColor=c;
  }
  public void saveOpenedImage(BufferedImage openedImage)
  {
	if(image==null)
	{
		image=(BufferedImage)createImage(imageWidth,imageHeight);
		buffer=image.createGraphics();
	}
	eraseAll();
	buffer.drawImage(openedImage,0,0,null);
	getGraphics().drawImage(image,0,0,this);
  }
  
  public void setDrawColor(Color c)
  {
	  drawColor=c;
  }
 
  public void setBackgroundColor(Color c)
  {
	  backGround=c;
  }
  public void setFontFamily(String name)
  {
	  fontFamily=name;
  }
  public void setFontStyle(int style)
  {
	  fontStyle+=style;
  }
  public void unSetFontStyle(int style)
  {
	  fontStyle-=style;
  }
  
  public int getFontStyle()
  {
	  return fontStyle;
  }
  public void setFontSize(int size)
  {
	  fontSize=size;
  }
  protected void record(int x, int y)
  {
    lastX = x;
    lastY = y;
  }
  public void undo()
  {
	  getGraphics().drawImage(backUpImage, 0,0,this);
	  buffer.drawImage(backUpImage,0,0,this);
  }
  // Record position that mouse entered window or
  // where user pressed mouse button.
 
 
  public BufferedImage getImage()
  {
	  System.out.println("Image dimensions: "+image.getWidth()+","+image.getHeight());
	  return image;
  }
  
  public Graphics getBufferedGraphics()
  {
	  return buffer;
  }
  // As user drags mouse, connect subsequent positions
  // with short line segments.
  public int getXLocation()
  {
	  return getXLocation;
  }
 
  public int getYLocation()
  {
	  return getYLocation;
  }

	
	
	@Override
	public void keyPressed(KeyEvent event)
	{
		// TODO Auto-generated method stub
	/*	if(buttonSelected.equals("text"))
		{
			//Functions.printMessage("text written");
			Graphics2D g2=(Graphics2D)getGraphics();
			g2.setColor(fontColor);
			Font font=new Font(fontFamily, fontStyle, fontSize);
			g2.setFont(font);
		//	Functions.printMessage(g.getFont()+" + "+getFontStyle());
			if(event.getKeyCode()!=KeyEvent.VK_BACK_SPACE && event.getKeyCode()!=KeyEvent.VK_DELETE)
			{	
				g2.drawString(""+event.getKeyChar(), getXLocation, getYLocation);
				Functions.printMessage("key pressed is not delete or backspace, its "+event.getKeyCode());
			}
			else
				g2.drawString("", getXLocation, getYLocation);
			if(backUpImage==null)
			{
				backUpImage=(BufferedImage) createImage(1350, 1350);
			}
			backup=backUpImage.createGraphics();
			backup.drawImage(image, 0, 0,null);
			if(image==null)
		    {
		    	image=(BufferedImage) createImage(imageWidth, imageHeight);
		    }
		    buffer = image.createGraphics();
			buffer.setColor(fontColor);
			buffer.setFont(new Font(fontFamily, fontStyle, fontSize));
		//	Functions.printMessage(g.getFont()+" + "+getFontStyle());
			if(event.getKeyCode()!=KeyEvent.VK_BACK_SPACE && event.getKeyCode()!=KeyEvent.VK_DELETE)
				buffer.drawString(""+event.getKeyChar(), getXLocation, getYLocation);
			else
				buffer.drawString("", getXLocation, getYLocation);
			if(fontSize>=65)
				getXLocation+=75;
			else if(fontSize>=55 && fontSize<65)
				getXLocation+=65;
			else if(fontSize>=45 && fontSize<55)
				getXLocation+=55;
			else if(fontSize>=35 && fontSize<45)
				getXLocation+=45;
			else if(fontSize>=25 && fontSize<35)
				getXLocation+=35;
			else if(fontSize>=15 && fontSize<25)
				getXLocation+=25;
			else
				getXLocation+=15;
		}*/
		if(buttonSelected.equals("paint all") && event.getKeyCode()==KeyEvent.VK_ENTER)
		{
			//Functions.printMessage(buttonSelected);
			Graphics g = getGraphics();
		    g.setColor(drawColor);
		    g.fillRect(0,0,imageWidth,imageHeight);
		    if(backUpImage==null)
			{
				backUpImage=(BufferedImage) createImage(imageWidth, imageHeight);
			}
			backup=backUpImage.createGraphics();
			backup.drawImage(image, 0, 0,null);
		    if(image==null)
		    {
		    	image=(BufferedImage) createImage(imageWidth, imageHeight);
		    }
		    buffer = image.createGraphics();
		    buffer.setColor(drawColor);
		    buffer.fillRect(0,0,imageWidth,imageHeight);
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent event)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyTyped(KeyEvent event) 
	{
		if(buttonSelected.equals("text") && (event.getKeyChar()!=KeyEvent.VK_BACK_SPACE && event.getKeyChar()!=KeyEvent.VK_DELETE))
		{
			//image to draw on screen
			Graphics2D g2=(Graphics2D)getGraphics();
			g2.setColor(fontColor);
			Font font=new Font(fontFamily, fontStyle, fontSize);
			g2.setFont(font);
			g2.drawString(""+event.getKeyChar(), getXLocation, getYLocation);
			
			//backup image
			backUpImage=(BufferedImage) createImage(imageWidth, imageHeight);
			backup=backUpImage.createGraphics();
			backup.drawImage(image, 0, 0,null);
			
			//image to draw on repaint
			if(image==null)
		    {
		    	image=(BufferedImage) createImage(imageWidth, imageHeight);
		    }
		    buffer = image.createGraphics();
			buffer.setColor(fontColor);
			buffer.setFont(new Font(fontFamily, fontStyle, fontSize));
			buffer.drawString(""+event.getKeyChar(), getXLocation, getYLocation);
			
			if(fontSize>=65)
				getXLocation+=75;
			else if(fontSize>=55 && fontSize<65)
				getXLocation+=65;
			else if(fontSize>=45 && fontSize<55)
				getXLocation+=55;
			else if(fontSize>=35 && fontSize<45)
				getXLocation+=45;
			else if(fontSize>=25 && fontSize<35)
				getXLocation+=35;
			else if(fontSize>=15 && fontSize<25)
				getXLocation+=25;
			else
				getXLocation+=15;
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent event) 
	{
		// TODO Auto-generated method stub
		
		if(buttonSelected.equals("draw"))
		{
			getXLocation=event.getX();
			getYLocation=event.getY();
			int x = event.getX();
		    int y = event.getY();
		    Graphics2D g = (Graphics2D)getGraphics();
		    g.setColor(drawColor);
		    g.drawLine(lastX, lastY, x, y);
		    
		    if(backUpImage==null)
			{
				backUpImage=(BufferedImage) createImage(imageWidth, imageHeight);
			}
			backup=backUpImage.createGraphics();
			backup.drawImage(image, 0, 0,null);
		    if(image==null)
		    {
		    	image=(BufferedImage) createImage(imageWidth, imageHeight);
		    }
		    
		    
		    buffer = image.createGraphics();
		    buffer.setColor(drawColor);
		    buffer.drawLine(lastX, lastY, x, y);
		    record(x, y);
		}
		else if(buttonSelected.equals("erase"))
		{
			getXLocation=event.getX();
			getYLocation=event.getY();
		    Graphics g = getGraphics();
		    g.setColor(Color.white);
		    g.fillRect(event.getX(), event.getY(), 20,20);
		    if(backUpImage==null)
			{
				backUpImage=(BufferedImage) createImage(imageWidth, imageHeight);
			}
			backup=backUpImage.createGraphics();
			backup.drawImage(image, 0, 0,null);
		    if(image==null)
		    {
		    	image=(BufferedImage) createImage(imageWidth, imageHeight);
		    }
		    buffer = image.createGraphics();
		    buffer.setColor(Color.white);
		    buffer.fillRect(event.getX(), event.getY(), 20,20);
		}
		else if(buttonSelected.equals("paint"))
		{
			getXLocation=event.getX();
			getYLocation=event.getY();
			
			//back up image
		   
				backUpImage=(BufferedImage) createImage(imageWidth, imageHeight);
			
			backup=backUpImage.createGraphics();
			backup.drawImage(image, 0, 0,null);
			
			//image to draw on screen
		    Graphics g = getGraphics();
		    g.setColor(drawColor);
		    g.fillOval(event.getX(), event.getY(), 20,20);
		    
		    
		    
			//image to draw on repaint
			if(image==null)
		    {
		    	image=(BufferedImage) createImage(imageWidth, imageHeight);
		    }
		   // Functions.printMessage(image);
		    buffer = image.createGraphics();
		    buffer.setColor(drawColor);
		    buffer.fillOval(event.getX(), event.getY(), 20,20);
		}
		else if(buttonSelected.equals("paint all"))
		{
		    Graphics g = getGraphics();
		    g.setColor(drawColor);
		    g.fillRect(0,0,imageWidth,imageHeight);
		    if(backUpImage==null)
			{
				backUpImage=(BufferedImage) createImage(imageWidth, imageHeight);
			}
			backup=backUpImage.createGraphics();
			backup.drawImage(image, 0, 0,null);
		    if(image==null)
		    {
		    	image=(BufferedImage) createImage(imageWidth, imageHeight);
		    }
		    buffer = image.createGraphics();
		    buffer.setColor(drawColor);
		    buffer.fillRect(0,0,imageWidth,imageHeight);
		}
		else if(buttonSelected.equals("erase all"))
		{
			if(backUpImage==null)
			{
				backUpImage=(BufferedImage) createImage(imageWidth, imageHeight);
			}
			backup=backUpImage.createGraphics();
			backup.drawImage(image, 0, 0,null);
			eraseAll();
		}
	}
	public void eraseAll()
	{
		Graphics g = getGraphics();
		 g.setColor(Color.white);
		 g.fillRect(0,0,imageWidth,imageHeight);
		 if(image==null)
		 {
		   image=(BufferedImage) createImage(imageWidth, imageHeight);
		 }
		 buffer = image.createGraphics();
		 buffer.setColor(Color.white);
		 buffer.fillRect(0,0,imageWidth,imageHeight);
	}
	
	
	@Override
	public void mouseMoved(MouseEvent event)
	{
		// TODO Auto-generated method stub
		getXLocation=event.getX();
		getYLocation=event.getY();
		/*Graphics2D g=(Graphics2D)getGraphics();
		g.setColor(color);
		repaint();*/
		
	}
	
	@Override
	public void mouseClicked(MouseEvent event) 
	{
		// TODO Auto-generated method stub
		if(buttonSelected.equals("paint all"))
		{
		    Graphics g = getGraphics();
		    g.setColor(drawColor);
		    g.fillRect(0,0,imageWidth,imageHeight);
		    if(backUpImage==null)
			{
				backUpImage=(BufferedImage) createImage(imageWidth, imageHeight);
			}
			backup=backUpImage.createGraphics();
			backup.drawImage(image, 0, 0,null);
		    if(image==null)
		    {
		    	image=(BufferedImage) createImage(imageWidth, imageHeight);
		    }
		    buffer = image.createGraphics();
		    buffer.setColor(drawColor);
		    buffer.fillRect(0,0,imageWidth,imageHeight);
		}
		else if(buttonSelected.equals("paint fill"))
		{
		    Graphics g = getGraphics();
		    g.setColor(drawColor);
		    int curX=event.getX();
		    int curY=event.getY();
		    System.out.println("@ location: "+curX+","+curY+" color is "+Color.getColor(null,this.getImage().getRGB(curX, curY)));
		    /*double radians;
		    for(int i=0; i<360; i++)
		    {
		    	radians=i*(Math.PI/180);
		    	while(cur)
		    }*/
		    
		    /*if(backUpImage==null)
			{
				backUpImage=(BufferedImage) createImage(imageWidth, imageHeight);
			}
			backup=backUpImage.createGraphics();
			backup.drawImage(image, 0, 0,null);
			
		    if(image==null)
		    {
		    	image=(BufferedImage) createImage(imageWidth, imageHeight);
		    }
		    buffer = image.createGraphics();
		    buffer.setColor(drawColor);
		    buffer.fillRect(0,0,imageWidth,imageHeight);*/
		}
		else if(buttonSelected.equals("erase all"))
		{
			if(backUpImage==null)
			{
				backUpImage=(BufferedImage) createImage(imageWidth, imageHeight);
			}
			backup=backUpImage.createGraphics();
			backup.drawImage(image, 0, 0,null);
			eraseAll();
		}
	}
	
	
	@Override
	public void mouseEntered(MouseEvent event)
	{
		// TODO Auto-generated method stub
		requestFocus(); // Plan ahead for typing
	    record(event.getX(), event.getY());
	}
	
	@Override
	public void mouseExited(MouseEvent event)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent event)
	{
		// TODO Auto-generated method stub
		record(event.getX(), event.getY());
	}
	
	@Override
	public void mouseReleased(MouseEvent event) 
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void repaint()
	{
		//Functions.printMessage("repaint");
	}
	
	@Override
	public int getNumberOfPages() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageFormat getPageFormat(int arg0) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Printable getPrintable(int arg0) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}
		
}
