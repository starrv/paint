package letspaintapplication;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serial;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.Border;

//import com.apple.eawt.Application;

public class Display extends JFrame implements WindowListener
{
	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = 5657371353338627325L;
	private static Whiteboard whiteboard;
	private static Clip clip;
	public final static Font DEFAULT_FONT=new Font("Sans Serif", Font.BOLD, 18);
	public final static Font FOCUS_FONT=new Font("Sans Serif", Font.ITALIC, 18);
	private final static int PADDING=5;
	public final static Border DEFAULT_BUTTON_BORDER=BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black,1,true),BorderFactory.createEmptyBorder(PADDING, PADDING, PADDING, PADDING));
	public final static Border FOCUS_BUTTON_BORDER=BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.blue,1,true),BorderFactory.createEmptyBorder(PADDING, PADDING, PADDING, PADDING));
	public final static Color DEFAULT_COLOR=Color.black;
	private final static int SCROLL_BAR_WIDTH=15;
	private final static int SCROLL_BAR_HEIGHT=15;

//	private URL getResource(String file)
//	{
//		return getClass().getClassLoader().getResource(file);
//	}
	
	public Display()
	{
		addWindowListener(this);
		setForeground(DEFAULT_COLOR);
		setName("Let's Paint");
		setTitle("Let's Paint");
		TrigLookUpTable.populate();
		setBackground(Color.white);
		Dimension size=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setSize(size.width,size.height);
		setImageIcon("PaintIcon.png");
		//URL url = getResource("PaintIcon.png");
		//setIconImage(Toolkit.getDefaultToolkit().getImage(url));
		setLayout(new BorderLayout());
		setFont(DEFAULT_FONT);

		whiteboard=new Whiteboard(getWidth(),getHeight(),this);

		FontTools fontTools=new FontTools(whiteboard);
		JScrollPane jScrollPaneFontTools=new JScrollPane(fontTools);
		jScrollPaneFontTools.getVerticalScrollBar().setPreferredSize(new Dimension(SCROLL_BAR_WIDTH,jScrollPaneFontTools.getHeight()));
		jScrollPaneFontTools.getVerticalScrollBar().setUI(new CustomVerticalScrollBarUI());
		jScrollPaneFontTools.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		jScrollPaneFontTools.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPaneFontTools.setWheelScrollingEnabled(true);

		PlainPanel panel=new PlainPanel(whiteboard);
		panel.setName("Plain Panel");
		panel.setBorder(BorderFactory.createLineBorder(Color.black,5,true));
		JScrollPane jScrollPanePanel=new JScrollPane(panel);
		jScrollPanePanel.getHorizontalScrollBar().setPreferredSize(new Dimension(jScrollPanePanel.getWidth(),SCROLL_BAR_HEIGHT));
		jScrollPanePanel.getHorizontalScrollBar().setUI(new CustomHorizontalScrollBarUI());
		jScrollPanePanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScrollPanePanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		jScrollPanePanel.setWheelScrollingEnabled(true);

		DrawTools drawTools=new DrawTools(whiteboard);
		JScrollPane jScrollPaneDrawTools=new JScrollPane(drawTools);
		jScrollPaneDrawTools.getVerticalScrollBar().setPreferredSize(new Dimension(SCROLL_BAR_WIDTH,jScrollPaneDrawTools.getHeight()));
		jScrollPaneDrawTools.getVerticalScrollBar().setUI(new CustomVerticalScrollBarUI());
		jScrollPaneDrawTools.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		jScrollPaneDrawTools.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPaneDrawTools.setWheelScrollingEnabled(true);

		Cursors cursors=new Cursors(whiteboard);
		JScrollPane jScrollPaneCursors=new JScrollPane(cursors);
		jScrollPaneCursors.getHorizontalScrollBar().setPreferredSize(new Dimension(jScrollPaneDrawTools.getWidth(),SCROLL_BAR_HEIGHT));
		jScrollPaneCursors.getHorizontalScrollBar().setUI(new CustomHorizontalScrollBarUI());
		jScrollPaneCursors.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScrollPaneCursors.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		cursors.setPreferredSize(new Dimension(getWidth(),getHeight()/8));
		jScrollPaneCursors.setWheelScrollingEnabled(true);

		setVisible(true);

		add(whiteboard, BorderLayout.CENTER);
		add(jScrollPaneCursors,BorderLayout.SOUTH);
		add(jScrollPanePanel,BorderLayout.NORTH);
		add(jScrollPaneFontTools, BorderLayout.EAST);
		add(jScrollPaneDrawTools,BorderLayout.WEST);

		whiteboard.eraseAll();

		// this.setIgnoreRepaint(true);
		//Functions.Functions.printMessage(whiteboard.getIgnoreRepaint()+" to ignore repaint");
		//playMusic();
	}
	
	private void setImageIcon(String url)
	   {		   
		   URL imgURL = getClass().getResource(url);
		   if (imgURL != null) 
		   {
			   //Functions.printMessage("Icon image found");
			   BufferedImage image=null;
			   try
			   {
			      image = ImageIO.read(imgURL);
			      this.setIconImage(image);
			      //Application.getApplication().setDockIconImage(image);
			    } 
			    catch (IOException e)
			    {
			      e.printStackTrace();
			      Functions.printMessage(e.getMessage());
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
	public void windowDeactivated(WindowEvent e) {

	}

	@Override
	public void windowClosed(WindowEvent event) 
	{
		// TODO Auto-generated method stub
		System.exit(0);
		//JOptionPane.showMessageDialog(this, "music stopped");
	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowOpened(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		stopMusic();
		System.exit(0);
	}
	
	static void printTime()
	{
	   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	   LocalDateTime now = LocalDateTime.now();  
	   System.out.print("@ "+dtf.format(now)+": ");  
	}

}

