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

}
