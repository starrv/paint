package letspaintapplication;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.Border;

import com.apple.eawt.Application;

@SuppressWarnings("restriction")
public class Display extends JFrame implements WindowListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5657371353338627325L;
	private static Whiteboard whiteboard;
	private static Clip clip;
	public final static Font DEFAULT_FONT=new Font("Sans Serif", Font.PLAIN, 18);
	public final static Font FOCUS_FONT=new Font("Sans Serif", Font.ITALIC, 18);
	private final static int PADDING=5;
	public final static Border DEFAULT_BUTTON_BORDER=BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black,1,true),BorderFactory.createEmptyBorder(PADDING, PADDING, PADDING, PADDING));
	public final static Border FOCUS_BUTTON_BORDER=BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.blue,1,true),BorderFactory.createEmptyBorder(PADDING, PADDING, PADDING, PADDING));
	
//	private URL getResource(String file)
//	{
//		return getClass().getClassLoader().getResource(file);
//	}
	
	public Display()
	{
		setName("LetsPaint");
		setTitle("LetsPaint");
		TrigLookUpTable.populate();
		PrintStream o=null;
		try
		{
			o = new PrintStream(new FileOutputStream("./log.txt",true));
			System.setOut(o); 
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setBackground(new Color(193, 217, 230));
		Dimension size=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setSize(size.width,size.height);
		setImageIcon("PaintIcon.png");
		//URL url = getResource("PaintIcon.png");
		//setIconImage(Toolkit.getDefaultToolkit().getImage(url));
		setLayout(new BorderLayout());
		setFont(new Font("Sans Serif", Font.BOLD, 20));
		whiteboard=new Whiteboard(getWidth(),getHeight(),this);
		add(whiteboard, BorderLayout.CENTER);
		FontTools fontTools=new FontTools(whiteboard);
		add(fontTools, BorderLayout.EAST);
		PlainPanel panel=new PlainPanel(whiteboard);
		panel.setBorder(BorderFactory.createLineBorder(Color.black,5,true));
		add(panel,BorderLayout.NORTH);
		DrawTools drawTools=new DrawTools(whiteboard);
		add(drawTools,BorderLayout.WEST);
		Cursors cursors=new Cursors(whiteboard);
		add(cursors,BorderLayout.SOUTH);
		setVisible(true);
		addWindowListener(this);
		whiteboard.eraseAll();//this.setIgnoreRepaint(true);
		//Functions.Functions.printMessage(whiteboard.getIgnoreRepaint()+" to ignore repaint");
		//playMusic();
	}
	
	private void setImageIcon(String url)
	   {		   
		   URL imgURL = getClass().getResource(url);
		   if (imgURL != null) 
		   {
			   Functions.printMessage("Icon image found");
			   BufferedImage image=null;
			   try
			   {
			      image = ImageIO.read(imgURL);
			      this.setIconImage(image);
			      Application.getApplication().setDockIconImage(image);
			    } 
			    catch (IOException e)
			    {
			      e.printStackTrace();
			    }
		   } 
		   else
		   {
			   Functions.printMessage("Could not find icon image");
		   }
	   }

	public static void playMusic()
	{
		URL url=null;
		try 
		{
			url=Display.class.getClassLoader().getResource("PaintSong.wav");
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
			clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.loop(Clip.LOOP_CONTINUOUSLY);
	       // JOptionPane.showMessageDialog(null, "Music started");
		} 
		catch(Exception ex) 
		{
	    	Functions.printMessage(ex.getMessage());
	        JOptionPane.showMessageDialog(null,ex.getMessage());
		}
		whiteboard.requestFocusInWindow();
	}
	
	public static void stopMusic()
	{
		if(clip!=null)
			clip.stop();
		//JOptionPane.showMessageDialog(null,"music stopped");
		whiteboard.requestFocusInWindow();
	}
	//C:/Users/Owner/workspace1/Paint/src/paint/Maid with the Flaxen Hair.mp3
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent event) 
	{
		// TODO Auto-generated method stub
		stopMusic();
		System.exit(0);
		//JOptionPane.showMessageDialog(this, "music stopped");
	}
	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		stopMusic();
		System.exit(0);
		//JOptionPane.showMessageDialog(this, "music stopped");
	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	static void printTime()
	{
	   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	   LocalDateTime now = LocalDateTime.now();  
	   System.out.print("@ "+dtf.format(now)+": ");  
	}
}

