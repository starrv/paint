package letspaintapplication;


import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class App {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		init();
		Display display=new Display();
		display.setVisible(true);
	}

	private static void init(){
		String javaVersion=System.getProperty("java.version");
		if(javaVersion!=null){
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
		}
		else{
			JOptionPane.showMessageDialog(null,"You must have Java installed to use this application.  Please go to https://www.java.com/en/ to download.");
			System.exit(0);
		}
	}

}
