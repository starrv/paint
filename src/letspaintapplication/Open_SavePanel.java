package letspaintapplication;

import javax.imageio.ImageIO;
import javax.swing.*;
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



public class Open_SavePanel extends JPanel implements ActionListener
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

	public Open_SavePanel(Whiteboard w, PlainPanel panel)
	{
		this.w=w;
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		addButtons();
		this.panel=panel;
		job.setPrintable(new Print(w));
		setOpaque(true);
	}
	
	private void addButtons()
	{
		String[] labels={"new file", "save as", "open file", "save", "delete", "undo", "print", "play music", "stop music"};
		JButtonBox=new JButton[labels.length];
		for(int i=0; i<labels.length;i++)
		{
			JButtonBox[i]=new JButton(labels[i]);
			JButtonBox[i].addActionListener(this);
			JButtonBox[i].setFont(new Font("Sans Serif", Font.BOLD, 18));
			JButtonBox[i].setBackground(new Color(245, 233, 225));
			JButtonBox[i].setOpaque(true);
			JButtonBox[i].setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.gray, 1, true), new EmptyBorder(5,5,5,5)));
			add(JButtonBox[i]);
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent event)
	{
		// TODO Auto-generated method stub
		if(event.getActionCommand().equals("new file"))
		{
			w.eraseAll();
			panel.changeDocumentLabel(PlainPanel.DEFAULT_DOCUMENT_LABEL);
			JOptionPane.showMessageDialog(null, "new file created");
			saveFile=null;
			openFile=null;
		}
		else if(event.getActionCommand().equals("save as"))
		{
			saveAs();
			/*JFileChooser saveFileDialog = new JFileChooser(new File("C:/Users/Owner/Downloads/document1.jpg"));
			saveFileDialog.showSaveDialog(this);*/
		}
		else if(event.getActionCommand().equals("open file"))
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
	}
	
	private void print()
	{
		
		boolean doPrint = job.printDialog();
		
		if (doPrint) {
		    try {
		        job.print();
		    } catch (PrinterException e) {
		        // The job did not successfully
		        // complete
		    }
		}


		
		//PageFormat pf = pj.pageDialog(pj.defaultPage());
		//pj.defaultPage(pf);
		//
	    
	    /*PrinterJob pj=PrinterJob.getPrinterJob();
		if (pj.printDialog())
		{
			try 
			{
				pj.print();
			}
			catch (PrinterException exc) 
			{
				JOptionPane.showMessageDialog(findParentFrame(), "Print error.  Error Message: "+exc);
			}
		}  */   
	}
	
	private void saveAs()
	{
		JFileChooser chooser = new JFileChooser(saveFile);
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
		    	 JOptionPane.showMessageDialog(findParentFrame(), "Write error for " + file.getPath());
		    	}
		    	catch(IllegalArgumentException e) 
		    	{
		    	 JOptionPane.showMessageDialog(findParentFrame(), "Nothing to save thus far " + file.getPath());
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
			    	 JOptionPane.showMessageDialog(findParentFrame(), "Write error for " + file.getPath());
			    	}
		    	}
		    	else
		    	{
		    		saveAs();
		    	}	    	
	    	}
	    }
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
		Functions.printMessage("File name:"+fileName);
		StringTokenizer tokenizer=new StringTokenizer(fileName,".");
		String extension="";
		while(tokenizer.hasMoreTokens())
		{
			extension=tokenizer.nextToken();
			//Functions.printMessage("extension: "+extension);
		}
		/*for(int i=fileName.length()-4; i<fileName.length(); i++)
		{
			extension +=fileName.charAt(i);
		}*/
		//JOptionPane.showMessageDialog(null,"Extension of "+fileName+" is "+extension);
		if(extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("jpeg") || extension.equalsIgnoreCase("png") || extension.equalsIgnoreCase("gif"))
		{
			//Functions.printMessage(fileName+ " is a JPG file because '"+extension+"' is equal to 'jpg'");
			return true;
		}
		else
		{
			//Functions.printMessage(fileName+ " is not a JPG file because '"+extension+"' is not equal to 'jpg'");
			return false;
		}
	}
	
	private String getExtension(String fileName)
	{
		Functions.printMessage("File name:"+fileName);
		StringTokenizer tokenizer=new StringTokenizer(fileName,".");
		String extension="";
		while(tokenizer.hasMoreTokens())
		{
			extension=tokenizer.nextToken();
			//Functions.printMessage("extension: "+extension);
		}
		/*for(int i=fileName.length()-4; i<fileName.length(); i++)
		{
			extension +=fileName.charAt(i);
		}*/
		//JOptionPane.showMessageDialog(null,"Extension of "+fileName+" is "+extension);
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
	    		if(openFile!=null)
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
	    		}
	    	}
	    	else
	    	{
	    		JOptionPane.showMessageDialog(findParentFrame(), "file could not be deleted");
	    	}
	    }
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
	    	 JOptionPane.showMessageDialog(findParentFrame(), "Write error for " + saveFile.getPath());
	    	}
		}
		else
		{
			saveAs();
		}
    }

	private void openFile()
	{
		JFileChooser chooser = new JFileChooser(saveFile);
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
			} catch (IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(findParentFrame(), "Read error for "+openFile+".  Error message: "+e.getMessage());
			}
	    	w.getGraphics().drawImage(image, 0, 0, w);
	    	w.saveOpenedImage(image);
	    	JOptionPane.showMessageDialog(findParentFrame(), "File opened");
	    }
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
}
