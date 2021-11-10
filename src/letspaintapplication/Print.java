package letspaintapplication;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.print.*;

public class Print implements Printable, ImageObserver
{

	private Whiteboard w;
	
	public Print(Whiteboard w)
	{
		this.w=w;
	}
	
	@Override
	public int print(Graphics g, PageFormat pf, int page) throws PrinterException 
	{
		// We have only one page, and 'page'
	    // is zero-based
	    if (page > 0) {
	         return NO_SUCH_PAGE;
	    }

	    // User (0,0) is typically outside the
	    // imageable area, so we must translate
	    // by the X and Y values in the PageFormat
	    // to avoid clipping.
	    Graphics2D g2d = (Graphics2D)g;
	    g2d.translate(pf.getImageableX(), pf.getImageableY());

	    // Now we perform our rendering
	    BufferedImage theImage=w.getImage();
	    System.out.println("Image dimensions: "+theImage.getWidth()+","+theImage.getHeight());
	    System.out.println("Page dimensions: "+pf.getWidth()+","+pf.getHeight());
	    g.drawImage(theImage, 0, 0,(int)pf.getWidth(),(int)pf.getHeight(),this);
	    
	    // tell the caller that this page is part
	    // of the printed document
	    return PAGE_EXISTS;
	}

	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		return false;
	}

}
