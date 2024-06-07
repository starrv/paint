package letspaintapplication;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;



public class Open_SavePanel extends JPanel implements ActionListener, KeyListener, FocusListener, MouseListener
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7095649893394083458L;
	/**
	 * 
	 */
	private JButton[] JButtonBox;
	private Whiteboard w;
	private File saveFile, openFile;
	private PlainPanel panel;
	private PrinterJob job = PrinterJob.getPrinterJob();
	private JFileChooser chooser = new JFileChooser(saveFile);;
	private Color buttonColor=new Color(245, 233, 225);

	public Open_SavePanel(Whiteboard w, PlainPanel panel)
	{
		this.w=w;
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		addButtons();
		this.panel=panel;
		job.setPrintable(new Print(w));
		setOpaque(true);
		setBackground(panel.getBackground());
		final int borderWidth=10;
		setBorder(BorderFactory.createEmptyBorder(borderWidth,borderWidth,borderWidth,borderWidth));
	}
	
	private void addButtons()
	{
		String[] labels={"new", "save as", "open", "save", "delete", "undo", "redo", "print", "play music", "stop music"};
		JButtonBox=new JButton[labels.length];
		for(int i=0; i<labels.length;i++)
		{
			JButtonBox[i]=new JButton(labels[i]);
			JButtonBox[i].setName(labels[i]);
			JButtonBox[i].addActionListener(this);
			JButtonBox[i].addKeyListener(this);
			JButtonBox[i].addFocusListener(this);
			JButtonBox[i].addMouseListener(this);
			JButtonBox[i].setFont(Display.DEFAULT_FONT);
			JButtonBox[i].setBackground(buttonColor);
			JButtonBox[i].setOpaque(true);
			JButtonBox[i].setBorder(Display.DEFAULT_BUTTON_BORDER);
			add(JButtonBox[i]);
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent event)
	{
		// TODO Auto-generated method stub
		if(event.getActionCommand().equals("new"))
		{
			newFile();
		}
		else if(event.getActionCommand().equals("save as"))
		{
			saveAs();
			/*JFileChooser saveFileDialog = new JFileChooser(new File("C:/Users/Owner/Downloads/document1.jpg"));
			saveFileDialog.showSaveDialog(this);*/
		}
		else if(event.getActionCommand().equals("open"))
		{
			openFile();
		}
		else if(event.getActionCommand().equals("save"))
		{
			save();
		}
		else if(event.getActionCommand().equals("play music"))
		{
			Display.playMusic();
		}
		else if(event.getActionCommand().equals("stop music"))
		{
			Display.stopMusic();
		}
		else if(event.getActionCommand().equals("delete"))
		{
			delete();
		}
		else if(event.getActionCommand().equals("print"))
		{
			print();
		}	
		else if(event.getActionCommand().equals("undo"))
		{
			w.undo();
		}
		else if(event.getActionCommand().equals("redo"))
		{
			w.redo();
		}
	}
	
	private void print()
	{
		job.pageDialog(job.defaultPage());
		boolean doPrint = job.printDialog();
		if (doPrint) {
		    try {
		        job.print();
		    } catch (PrinterException e) {
		        JOptionPane.showMessageDialog(findParentFrame(), "An error has occurred: "+e.getMessage());
		        e.printStackTrace();
		        Functions.printMessage(e.getMessage());
		    }
		}
		w.requestFocusInWindow();
	}
	
	private void saveAs()
	{
		//JFileChooser chooser = new JFileChooser(saveFile);
		chooser.setSelectedFile(saveFile);
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(
	        "JPG & GIF & PNG Images","jpg","jpeg","gif","png");
	    chooser.setFileFilter(filter);
	    chooser.setAcceptAllFileFilterUsed(false);
	    chooser.setFileHidingEnabled(true);
	    chooser.setSelectedFile(new File(panel.getDocumentLabel()));
	    
	    int returnVal = chooser.showSaveDialog(findParentFrame());
	    if(returnVal == JFileChooser.APPROVE_OPTION) 
	    {
	    	File file = chooser.getSelectedFile();
	    	file=new File(removeWhiteSpace(file.getPath()));
	    	if(!isImageFile(file.getName()))
	    	{
	    		String fileName=file.getPath()+".jpg";
		    	file=new File(fileName);
	    	}
	    	int answer=0;
	    	if(!file.exists())
	    	{
	    		saveFile=file;
	    		openFile=saveFile;
	    		panel.changeDocumentLabel(openFile.getName());
		    	BufferedImage image = w.getImage();
		    	try 
		    	{
		    	   ImageIO.write(image, getExtension(file.getPath()), file);  // ignore returned boolean
		    	   JOptionPane.showMessageDialog(findParentFrame(), "File saved");
		    	} catch(IOException e) 
		    	{
		    	 JOptionPane.showMessageDialog(findParentFrame(), "Write error for " + file.getPath()+": "+e.getMessage());
		    	 Functions.printMessage(e.getMessage());
		    	}
		    	catch(IllegalArgumentException e) 
		    	{
		    	 JOptionPane.showMessageDialog(findParentFrame(), "Nothing to save thus far " + file.getPath()+": "+e.getMessage());
		    	 Functions.printMessage(e.getMessage());
		    	}
		    }
	    	else{
	    		answer=JOptionPane.showConfirmDialog(findParentFrame(), "The file "+file.getPath()+" already exists.  Do you wish to overwrite?");
	    		if(answer==JOptionPane.YES_OPTION)
		    	{
	    			saveFile=file;
	    			openFile=saveFile;
	    			panel.changeDocumentLabel(openFile.getName());
			    	BufferedImage image = w.getImage();
			    	try 
			    	{
			    	   ImageIO.write(image, getExtension(file.getPath()), file);  // ignore returned boolean
			    	   JOptionPane.showMessageDialog(findParentFrame(), "File saved");
			    	} catch(IOException e) 
			    	{
			    	 JOptionPane.showMessageDialog(findParentFrame(), "Write error for " + file.getPath()+": "+e.getMessage());
			    	 Functions.printMessage(e.getMessage());
			    	}
		    	}
		    	else
		    	{
		    		saveAs();
		    	}	    	
	    	}
	    }
	    w.requestFocusInWindow();
	}
	
	private String removeWhiteSpace(String fileName)
	{
		String newFileName="";
		char curr;
		for(int i=0; i<fileName.length(); i++)
		{
			curr=fileName.charAt(i);
			if(curr==' ')
			{
				continue;
			}
			newFileName+=curr;
		}
		return newFileName;
	}
	
	private boolean isImageFile(String fileName)
	{
		StringTokenizer tokenizer=new StringTokenizer(fileName,".");
		String extension="";
		while(tokenizer.hasMoreTokens())
		{
			extension=tokenizer.nextToken();
		}
		if(extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("jpeg") || extension.equalsIgnoreCase("png") || extension.equalsIgnoreCase("gif"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private String getExtension(String fileName)
	{
		StringTokenizer tokenizer=new StringTokenizer(fileName,".");
		String extension="";
		while(tokenizer.hasMoreTokens())
		{
			extension=tokenizer.nextToken();
		}
		return extension;
	}
	
	private void delete()
	{
		JFileChooser chooser = new JFileChooser(saveFile);
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(
	        "JPG & PNG & GIF Images", "jpg","jpeg","png","gif");
	    chooser.setFileFilter(filter);
	    chooser.setAcceptAllFileFilterUsed(false);
	    chooser.setFileHidingEnabled(true);
	    int returnVal = chooser.showDialog(findParentFrame(), "delete");
	    if(returnVal==JFileChooser.APPROVE_OPTION)
	    {
	    	File fileToBeDeleted=chooser.getSelectedFile();
	    	if(fileToBeDeleted.exists() && fileToBeDeleted.delete()==true)
	    	{
	    		JOptionPane.showMessageDialog(findParentFrame(), "file has been deleted");
	    		/*if(openFile!=null)
		    	{
		    		if(!(openFile.equals(fileToBeDeleted)))
		    		{
		    			JOptionPane.showMessageDialog(findParentFrame(), "file has been deleted");
		    		}
		    		else
			    	{
		    			
			    		JOptionPane.showMessageDialog(findParentFrame(), "file could not be deleted");
			    	}
		    	}
	    		else
	    		{
	    			JOptionPane.showMessageDialog(findParentFrame(), "file has been deleted");
	    		}*/
	    	}
	    	else
	    	{
	    		JOptionPane.showMessageDialog(findParentFrame(), "file could not be deleted");
	    	}
	    }
	    w.requestFocusInWindow();
	}
	
	private void newFile()
	{
		w.eraseAll();
		panel.changeDocumentLabel(PlainPanel.DEFAULT_DOCUMENT_LABEL);
		JOptionPane.showMessageDialog(null, "new file created");
		saveFile=null;
		openFile=null;
		w.requestFocusInWindow();
	}
	
	private void save()
	{
		if(saveFile!=null)
		{
			BufferedImage image = w.getImage();
	    	try 
	    	{
	    	   ImageIO.write(image, getExtension(saveFile.getPath()), saveFile);  // ignore returned boolean
	    	   JOptionPane.showMessageDialog(findParentFrame(), "File saved");
	    	} catch(IOException e) 
	    	{
	    	 JOptionPane.showMessageDialog(findParentFrame(), "Write error for " + saveFile.getPath()+": "+e.getMessage());
	    	 Functions.printMessage(e.getMessage());
	    	}
		}
		else
		{
			saveAs();
		}
		w.requestFocusInWindow();
    }

	private void openFile()
	{
		//JFileChooser chooser = new JFileChooser(saveFile);
		chooser.setSelectedFile(saveFile);
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(
	        "JPG & PNG & GIF Images", "jpg", "gif","png","jpeg");
	    chooser.setFileFilter(filter);
	    chooser.setAcceptAllFileFilterUsed(false);
	    
	    int returnVal = chooser.showOpenDialog(findParentFrame());
	    if(returnVal == JFileChooser.APPROVE_OPTION) 
	    {
	    	File file = chooser.getSelectedFile();
	    	openFile=file;
	    	saveFile=openFile;
	    	panel.changeDocumentLabel(openFile.getName());
	    	BufferedImage image=null;
	    	try {
				image=ImageIO.read(openFile);
				w.saveOpenedImage(image);
				JOptionPane.showMessageDialog(findParentFrame(), "File opened");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(findParentFrame(), "Read error for "+openFile+".  Error message: "+e.getMessage());
				Functions.printMessage(e.getMessage());
			}
	    }
	    w.requestFocusInWindow();
	}
	
	 private Frame findParentFrame()
	 { 
		    Container c = this; 
		    while(c != null){ 
		      if (c instanceof Frame) 
		        return (Frame)c; 

		      c = c.getParent(); 
		    } 
		    return (Frame)null; 
	}

	@Override
	public void keyPressed(KeyEvent event) 
	{
		// TODO Auto-generated method stub
//		if(event.getKeyCode()==Display.CONFIRM_KEY)
//		{
//			if(event.getComponent().getName()=="new")
//			{
//				newFile();
//			}
//			else if(event.getComponent().getName()=="save as")
//			{
//				saveAs();
//			}
//			else if(event.getComponent().getName()=="open")
//			{
//				openFile();
//			}
//			else if(event.getComponent().getName()=="save")
//			{
//				save();
//			}
//			else if(event.getComponent().getName()=="delete")
//			{
//				delete();
//			}
//			else if(event.getComponent().getName()=="undo")
//			{
//				w.undo();
//			}
//			else if(event.getComponent().getName()=="print")
//			{
//				print();
//			}
//			else if(event.getComponent().getName()=="play music")
//			{
//				Display.playMusic();
//			}
//			else if(event.getComponent().getName()=="stop music")
//			{
//				Display.stopMusic();
//			}
//		}
	}

	@Override
	public void keyReleased(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent event) {
		// TODO Auto-generated method stub
	}

	@Override
	public void focusGained(FocusEvent event) {
		// TODO Auto-generated method stub
		if(event.getComponent().getClass().getName().equals("javax.swing.JButton"))
		{
			JButton button=(JButton)event.getComponent();
			button.setFont(Display.FOCUS_FONT);
			button.setBorder(Display.FOCUS_BUTTON_BORDER);
			button.setForeground(Color.blue);
		}
	}

	@Override
	public void focusLost(FocusEvent event) {
		// TODO Auto-generated method stub
		if(event.getComponent().getClass().getName().equals("javax.swing.JButton"))
		{
			JButton button=(JButton)event.getComponent();
			button.setFont(Display.DEFAULT_FONT);
			button.setBorder(Display.DEFAULT_BUTTON_BORDER);
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
	public void mouseEntered(MouseEvent event) {
		if(event.getComponent().getClass().getName().equals("javax.swing.JButton"))
		{
			JButton button=(JButton)event.getComponent();
			button.setFont(Display.FOCUS_FONT);
			button.setBorder(Display.FOCUS_BUTTON_BORDER);
			button.setForeground(Color.blue);
		}
	}

	@Override
	public void mouseExited(MouseEvent event) {
		if(event.getComponent().getClass().getName().equals("javax.swing.JButton"))
		{
			JButton button=(JButton)event.getComponent();
			button.setFont(Display.DEFAULT_FONT);
			button.setBorder(Display.DEFAULT_BUTTON_BORDER);
			button.setForeground(Color.black);
		}
	}
}
