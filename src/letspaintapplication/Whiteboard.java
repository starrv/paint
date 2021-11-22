package letspaintapplication;


import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;
import java.util.ArrayList;

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
	setName("LetsPaint");
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
	  //System.out.println("Image dimensions: "+image.getWidth()+","+image.getHeight());
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
		if((buttonSelected.equals("paint all") && event.getKeyCode()==KeyEvent.VK_ENTER) || (buttonSelected.equals("paint all") && event.getKeyCode()==KeyEvent.VK_CONTROL && event.getKeyCode()==KeyEvent.VK_P))
		{
			paintAll();
		}
		else if((buttonSelected.equals("paint fill") && event.getKeyCode()==KeyEvent.VK_ENTER) || (buttonSelected.equals("paint fill") && event.getKeyCode()==KeyEvent.VK_CONTROL && event.getKeyCode()==KeyEvent.VK_P))
		{
			paintAll();
		}
		else if((buttonSelected.equals("paint") && event.getKeyCode()==KeyEvent.VK_ENTER) || (buttonSelected.equals("paint") && event.getKeyCode()==KeyEvent.VK_CONTROL && event.getKeyCode()==KeyEvent.VK_P))
		{
			paintAll();
		}
		else if(event.getKeyCode()==KeyEvent.VK_CONTROL && event.getKeyCode()==KeyEvent.VK_Z)
		{
			undo();
		}
		
		
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
			type(event);
		}
	}
	
	public void eraseAll()
	{
		if(backUpImage==null)
		{
			backUpImage=(BufferedImage) createImage(imageWidth, imageHeight);
		}
		backup=backUpImage.createGraphics();
		backup.drawImage(image, 0, 0,null);
		
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
	public void mouseDragged(MouseEvent event) 
	{
		// TODO Auto-generated method stub
		
		if(buttonSelected.equals("draw"))
		{
			draw(event.getX(),event.getY());
		}
		else if(buttonSelected.equals("erase"))
		{
			erase(event.getX(),event.getY());
		}
		else if(buttonSelected.equals("paint"))
		{
			paint(event.getX(),event.getY());
		}
		else if(buttonSelected.equals("paint all"))
		{
		   paintAll(); 
		}
		else if(buttonSelected.equals("erase all"))
		{
			eraseAll();
		}
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
		   paintAll();
		}
		else if(buttonSelected.equals("paint fill"))
		{
		    paintFill(event.getX(),event.getY());
		}
		else if(buttonSelected.equals("erase all"))
		{
			eraseAll();
		}
		System.out.println("Color at ("+event.getX()+","+event.getY()+"): "+Color.getColor(null,getImage().getRGB(event.getX(),event.getY())));
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
	
	private void paintAll()
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
	
	private void paintFill(int x, int y)
	{
		Graphics g = getGraphics();
	    g.setColor(drawColor);
	    int initX=x;
	    int initY=y;
	    BufferedImage theImage=getImage();
	    Color initColor=Color.getColor(null,theImage.getRGB(initX, initY));
	    Color curColor;
	    double radians;
	    double curX;
	    double curY;
	    final double R=.5;
	    double distX;
	    double distY;
	    ArrayList<Integer> xCoordsArrayList=new ArrayList<Integer>();
	    ArrayList<Integer> yCoordsArrayList=new ArrayList<Integer>();
	    for(double i=0; i<360; i+=1)
	    {
	    	radians=i*(Math.PI/180);
	    	distX=R*Math.cos(radians);
		    distY=R*Math.sin(radians);
	    	
	    	curX=initX;
	    	curY=initY;
	    	curColor=initColor;
	    	
	    	double[] coords=getEdgeIfExist(curX,curY,theImage,initColor);
	    	
	    	while(coords[0]==curX && coords[1]==curY)
	    	{
		    	curX+=distX;
		    	curY+=distY;
		    	coords=getEdgeIfExist(curX,curY,theImage,initColor);
	    	}
	    	curX=coords[0];
	    	curY=coords[1];
	    	xCoordsArrayList.add((int)curX);
	    	yCoordsArrayList.add((int)curY);
	    }
	    int[] xCoords=new int[xCoordsArrayList.size()];
	    int[] yCoords=new int[yCoordsArrayList.size()];
	    for(int i=0; i<xCoords.length; i++)
	    {
	    	xCoords[i]=xCoordsArrayList.get(i);
	    	yCoords[i]=yCoordsArrayList.get(i);
	    }
	    g.fillPolygon(xCoords, yCoords,xCoords.length);
	    
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
	    buffer.fillPolygon(xCoords, yCoords,xCoords.length);
	}
	
	private void draw(int x, int y)
	{
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
	
	private void erase(int x, int y)
	{
	    Graphics g = getGraphics();
	    g.setColor(Color.white);
	    g.fillRect(x, y, 20,20);
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
	    buffer.fillRect(x, y, 20,20);
	}
	
	private void paint(int x, int y)
	{
		//image to draw on screen
	    Graphics g = getGraphics();
	    g.setColor(drawColor);
	    g.fillOval(x, y, 20,20);
	    
	    //back up image
		backUpImage=(BufferedImage) createImage(imageWidth, imageHeight);
		backup=backUpImage.createGraphics();
		backup.drawImage(image, 0, 0,null);
	    
		//image to draw on repaint
		if(image==null)
	    {
	    	image=(BufferedImage) createImage(imageWidth, imageHeight);
	    }
	   // Functions.printMessage(image);
	    buffer = image.createGraphics();
	    buffer.setColor(drawColor);
	    buffer.fillOval(x, y, 20,20);
	}
	
	private void type(KeyEvent event)
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
	
	private boolean isEdge(double x, double y, BufferedImage theImage, Color initColor)
	{
		Color curColor;
		int curX;
		int curY;
		int imageWidth=theImage.getWidth();
		int imageHeight=theImage.getHeight();
		for(double i=-5; i<=5; i+=.5)
		{
			curX=(int)(x+i);
			curY=(int)(y+i);
			if(((curX>0 && curX<imageWidth) && (curY>0 && curY<imageHeight)))
			{
				curColor=Color.getColor(null,theImage.getRGB(curX,curY));
				if(!curColor.equals(initColor))
				{
					return true;
				}
			}
			else
			{
				return true;
			}
		}
		return false;
	}
	
	private double[] getEdgeIfExist(double x, double y, BufferedImage theImage, Color initColor)
	{
		Color curColor;
		int curX;
		int curY;
		int imageWidth=theImage.getWidth();
		int imageHeight=theImage.getHeight();
		for(double i=-5; i<=5; i+=.5)
		{
			curX=(int)(x+i);
			curY=(int)(y+i);
			if(((curX>0 && curX<imageWidth) && (curY>0 && curY<imageHeight)))
			{
				curColor=Color.getColor(null,theImage.getRGB(curX,curY));
				if(!curColor.equals(initColor))
				{
					double[] coords=new double[2];
					coords[0]=curX;
					coords[1]=curY;
					return coords;
				}
			}
			else
			{
				double[] coords=new double[2];
				coords[0]=curX;
				coords[1]=curY;
				return coords;
			}
		}
		double[] coords=new double[2];
		coords[0]=x;
		coords[1]=y;
		return coords;
	}
}
