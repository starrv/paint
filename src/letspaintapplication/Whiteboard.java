package letspaintapplication;


import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;
import java.io.BufferedReader;
import java.security.Key;
import java.util.Stack;

import javax.swing.*;

/** An application that lets you perform freehand drawing.
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
	protected BufferedImage image, backUpImage, currentImg;
	protected Graphics2D buffer, backup, g2;
	protected Stack<BufferedImage> backUpImages=new Stack<>();
	protected Stack<BufferedImage> redoImages=new Stack<>();
	protected String hello;
	protected Ellipse2D o;
	protected Color drawColor, fontColor, backGround;
	protected Cursor cursor;
	protected String fontFamily, buttonSelected;
	protected int fontStyle, fontSize, imageWidth, imageHeight;
	protected FontMetrics fm;
	protected JFrame frame;
  
  public Whiteboard(int w, int h, JFrame frame) 
  {
	setName("Whiteboard");
	cursor=new Cursor(Cursor.DEFAULT_CURSOR);
	setSize(w,h);
	imageWidth=getWidth();
	imageHeight=getHeight();
	this.frame=frame;
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
    setOpaque(true);
    setVisible(true);
  }
  
 @Override
 public void paintComponent(Graphics g)
 {
	 Graphics2D g2=(Graphics2D)g;
	 g2.drawImage(image, 0, 0, this);
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

  public void setCurrentImg(BufferedImage newCurrentImg){
	  this.currentImg=newCurrentImg;
  }

  public BufferedImage getCurrentImg(){
	  return this.currentImg;
  }

  private void reset(){
	  eraseAll();
	  currentImg=null;
	  backUpImage=null;
	  buffer=null;
	  image=null;
	  backUpImages=new Stack<>();
	  redoImages=new Stack<>();
  }

  public void createNewImage(){
	  reset();
  }

  public void setFontColor(Color c)
  {
	  fontColor=c;
  }

  public void saveOpenedImage(BufferedImage openedImage){
	  reset();
	  BufferedImage newImg=(BufferedImage) createImage(imageWidth,imageHeight);
	  Graphics newImgGraphics=newImg.getGraphics();
	  newImgGraphics.drawImage(openedImage,0,0,this);
	  getGraphics().drawImage(newImg,0,0,this);
	  currentImg=newImg;
	  if(image==null)
	  {
		  image=(BufferedImage)createImage(imageWidth,imageHeight);
		  buffer=image.createGraphics();
	  }
	  buffer.drawImage(openedImage,0,0,this);
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
	  if(!backUpImages.empty()){
		  redoImages.push(currentImg);
		  backUpImage=backUpImages.pop();
		  getGraphics().drawImage(backUpImage, 0,0,this);
		  buffer.drawImage(backUpImage,0,0,this);
		  currentImg=backUpImage;
		  requestFocusInWindow();
		  backUpImage=null;
	  }
  }
  // Record position that mouse entered window or
  // where user pressed mouse button.

 public void redo(){
	if(!redoImages.empty()){
		backUpImages.push(currentImg);
		backUpImage=redoImages.pop();
		getGraphics().drawImage(backUpImage, 0,0,this);
		buffer.drawImage(backUpImage,0,0,this);
		currentImg=backUpImage;
		requestFocusInWindow();
		backUpImage=null;
	}
}


  public BufferedImage getImage()
  {
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
		if(event.getKeyCode()==KeyEvent.VK_ENTER)
		{
			if(buttonSelected=="paint")
			{
				paint(getXLocation,getYLocation);
			}
			else if(buttonSelected=="paint fill")
			{
				paintFill(getXLocation,getYLocation);
			}
			else if(buttonSelected=="paint all")
			{
				paintAll();
			}
			else if(buttonSelected=="erase")
			{
				erase(getXLocation,getYLocation);
			}
			else if(buttonSelected=="erase all")
			{
				eraseAll();
			}
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
			type(event);
		}
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
		getXLocation=event.getX();
		getYLocation=event.getY();
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
	}
	
	
	@Override
	public void mouseEntered(MouseEvent event)
	{
		// TODO Auto-generated method stub
		requestFocus(); // Plan ahead for typing
	    record(event.getX(), event.getY());
		if(buttonSelected.equals("paint all") || buttonSelected.equals("paint fill") || buttonSelected.equals("paint"))
		{
			setCursor2(Cursors.createPaintBrushCursor());
		}
		else if(buttonSelected.equals("draw"))
		{
			setCursor2(Cursors.createPencilCursor());
		}
		else if(buttonSelected.equals("erase") || buttonSelected.equals("erase all"))
		{
			setCursor2(Cursors.createEraserCursor());
		}
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
		if(buttonSelected.equals("paint") || buttonSelected.equals("draw") || buttonSelected.equals("erase")){
			backUpImages.push(backUpImage);
			backUpImage=null;
		}
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
		if(!redoImages.empty())redoImages=new Stack<>();
		Graphics g = getGraphics();
		if(currentImg==null){
			currentImg=(BufferedImage) createImage(imageWidth, imageHeight);
		}
		Graphics2D g2=currentImg.createGraphics();
		g2.setColor(drawColor);
		g2.fillRect(0,0,imageWidth,imageHeight);
		g.drawImage(currentImg,0,0,this);

	  	backUpImage=(BufferedImage) createImage(imageWidth, imageHeight);
		backup=backUpImage.createGraphics();
		backup.drawImage(image, 0, 0,this);
	    if(image==null)
	    {
	    	image=(BufferedImage) createImage(imageWidth, imageHeight);
	    }
	    buffer = image.createGraphics();
	    buffer.setColor(drawColor);
	    buffer.fillRect(0,0,imageWidth,imageHeight);
		backUpImages.push(backUpImage);
		backUpImage=null;
	}
	
	private void paintFill(int x, int y)
	{
		if(!redoImages.empty())redoImages=new Stack<>();
		Functions.printMessage("Calculating painting range....");
		final JDialog modelDialog = new JDialog(frame, "Calculating painting range....");
		modelDialog.setBounds(this.getWidth()/2,this.getHeight()/2, 500, 100);
		modelDialog.setLocationRelativeTo(this);
		modelDialog.setVisible(true);
		Graphics g = getGraphics();
		if(currentImg==null){
			currentImg=(BufferedImage) createImage(imageWidth, imageHeight);
		}
		Graphics2D g2=currentImg.createGraphics();
		g2.setColor(drawColor);
	    int initX=x;
	    int initY=y;
	    BufferedImage theImage=getImage();
		if(theImage==null){
			theImage=(BufferedImage)createImage(imageWidth,imageHeight);
		}
	    Color initColor=Color.getColor(null,theImage.getRGB(initX, initY));
	    double curX;
	    double curY;
	    final int R=1;
	    double distX;
	    double distY;
	    int[] xCoords=new int[360];
	    int[] yCoords=new int[360];
	    
	    for(int i=0; i<360; i+=1)
	    {
	    	distX=R*TrigLookUpTable.cos[i];
		    distY=R*TrigLookUpTable.sin[i];
	    	
	    	curX=initX;
	    	curY=initY;
	    	
	    	while(!isEdge(curX,curY,theImage,initColor))
	    	{
		    	curX+=distX;
		    	curY+=distY;
		    	//g.drawLine((int)curX,(int)curY,(int)curX,(int)curY);
	    	}
	    	xCoords[i]=(int)curX;
	    	yCoords[i]=(int)curY;
	    }
	    g2.fillPolygon(xCoords, yCoords,xCoords.length);
		g.drawImage(currentImg,0,0,this);
	    backUpImage=(BufferedImage) createImage(imageWidth, imageHeight);
		backup=backUpImage.createGraphics();
		backup.drawImage(image, 0, 0,this);
		
	    if(image==null)
	    {
	    	image=(BufferedImage) createImage(imageWidth, imageHeight);
	    }
	    buffer = image.createGraphics();
	    buffer.setColor(drawColor);
	    buffer.fillPolygon(xCoords, yCoords,xCoords.length);
		backUpImages.push(backUpImage);
		backUpImage=null;
	    modelDialog.setVisible(false);
		setCursor2(Cursors.createPaintBrushCursor());
	}

	private void paint(int x, int y)
	{
		//image to draw on screen
		if(!redoImages.empty())redoImages=new Stack<>();
		Graphics2D g = (Graphics2D)getGraphics();
		if(currentImg==null){
			currentImg=(BufferedImage) createImage(imageWidth, imageHeight);
		}
		Graphics2D g2=currentImg.createGraphics();
		g2.setColor(drawColor);
		g2.fillRect(x, y, 20,20);
		g.drawImage(currentImg,0,0,this);

		//back up image
		if(backUpImage==null){
			backUpImage=(BufferedImage) createImage(imageWidth, imageHeight);

			backup=backUpImage.createGraphics();


			backup.drawImage(image, 0, 0,this);
			//image to draw on repaint
			if(image==null)
			{
				image=(BufferedImage) createImage(imageWidth, imageHeight);
			}
		}

		buffer = image.createGraphics();
		buffer.setColor(drawColor);
		buffer.fillRect(x, y, 20,20);
	}
	
	private void draw(int x, int y)
	{
		if(!redoImages.empty())redoImages=new Stack<>();
	    Graphics2D g = (Graphics2D)getGraphics();
		if(currentImg==null){
			currentImg=(BufferedImage) createImage(imageWidth, imageHeight);
		}
		Graphics2D g2=currentImg.createGraphics();
	    g2.setColor(drawColor);
	    g2.drawLine(lastX, lastY, x, y);
		g.drawImage(currentImg,0,0,this);

		if(backUpImage==null){
			backUpImage=(BufferedImage) createImage(imageWidth, imageHeight);
			backup=backUpImage.createGraphics();
			backup.drawImage(image, 0, 0,this);
			if(image==null)
			{
				image=(BufferedImage) createImage(imageWidth, imageHeight);
			}
		}
	    
	    buffer = image.createGraphics();
	    buffer.setColor(drawColor);
	    buffer.drawLine(lastX, lastY, x, y);
		//backUpImages.push(backUpImage);
	    
	    record(x, y);
	}

	private void type(KeyEvent event)
	{
		//image to draw on screen
		if(!redoImages.empty())redoImages=new Stack<>();
		Graphics2D g = (Graphics2D)getGraphics();
		if(currentImg==null){
			currentImg=(BufferedImage) createImage(imageWidth, imageHeight);
		}
		Graphics2D g2=currentImg.createGraphics();
		g2.setColor(fontColor);
		Font font=new Font(fontFamily, fontStyle, fontSize);
		g2.setFont(font);
		g2.drawString(""+event.getKeyChar(), getXLocation, getYLocation);
		g.drawImage(currentImg,0,0,this);

		//backup image
		backUpImage=(BufferedImage) createImage(imageWidth, imageHeight);
		backup=backUpImage.createGraphics();
		backup.drawImage(image, 0, 0,this);

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
		backUpImages.push(backUpImage);
		backUpImage=null;
	}
	
	private void erase(int x, int y)
	{
		if(!redoImages.empty())redoImages=new Stack<>();
		Graphics2D g = (Graphics2D)getGraphics();
		if(currentImg==null){
			currentImg=(BufferedImage) createImage(imageWidth, imageHeight);
		}
		Graphics2D g2=currentImg.createGraphics();
	    g2.setColor(Color.white);
	    g2.fillRect(x, y, 20,20);
		g.drawImage(currentImg,0,0,this);

		if(backUpImage==null){
			backUpImage=(BufferedImage) createImage(imageWidth, imageHeight);
			backup=backUpImage.createGraphics();
			backup.drawImage(image, 0, 0,this);
			if(image==null)
			{
				image=(BufferedImage) createImage(imageWidth, imageHeight);
			}
		}

	    buffer = image.createGraphics();
	    buffer.setColor(Color.white);
	    buffer.fillRect(x, y, 20,20);
		//backUpImages.push(backUpImage);
	}

	public void eraseAll()
	{
		if(!redoImages.empty())redoImages=new Stack<>();
		Graphics2D g = (Graphics2D)getGraphics();
		if(currentImg==null){
			currentImg=(BufferedImage) createImage(imageWidth, imageHeight);
		}
		Graphics2D g2=currentImg.createGraphics();
		g2.setColor(Color.white);
		g2.fillRect(0,0,imageWidth,imageHeight);
		g.drawImage(currentImg,0,0,this);

		backUpImage=(BufferedImage) createImage(imageWidth, imageHeight);
		backup=backUpImage.createGraphics();
		backup.drawImage(image, 0, 0,this);
		if(image==null)
		{
			image=(BufferedImage) createImage(imageWidth, imageHeight);
		}
		buffer = image.createGraphics();
		buffer.setColor(Color.white);
		buffer.fillRect(0,0,imageWidth,imageHeight);
		backUpImages.push(backUpImage);
		backUpImage=null;
	}
	
	private boolean isEdge(double x, double y, BufferedImage theImage, Color initColor)
	{
		Color curColor;
		int curX;
		int curY;
		int imageWidth=theImage.getWidth();
		int imageHeight=theImage.getHeight();
		for(int i=-1; i<=0; i+=1)
		{
			curX=(int)(x+i);
			for(int j=-1; j<=0; j+=1)
			{
				curY=(int)(y+j);
				if(((curX>0 & curX<imageWidth) && (curY>0 & curY<imageHeight)))
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
		}
		return false;
	}

	public Color getFontColor() {
		return fontColor;
	}

	
	
}
