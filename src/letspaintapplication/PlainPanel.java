package letspaintapplication;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;


public class PlainPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 838121083699066558L;
	/**
	 * 
	 */
	private JToolBar toolBar;
	private JLabel firstLabel, label;
	public static final String DEFAULT_DOCUMENT_LABEL="untitled document ";
	private Color color=new Color(217, 187, 169);
	
	public PlainPanel(Whiteboard w)
	{
		setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		setBackground(new Color(217, 187, 169));
		setOpaque(true);
		toolBar=new JToolBar("Tools");
		//toolBar.setLayout(new BoxLayout(toolBar,BoxLayout.X_AXIS));
		toolBar.setLayout(new FlowLayout());
		toolBar.setOpaque(true);
		toolBar.setBackground(color);
		firstLabel=new JLabel("File Name:");
		firstLabel.setFont(Display.DEFAULT_FONT);
		firstLabel.setBackground(color);
		firstLabel.setOpaque(true);
		toolBar.add(firstLabel);
		label=new JLabel(DEFAULT_DOCUMENT_LABEL);
		label.setFont(Display.DEFAULT_FONT);
		label.setAlignmentX(CENTER_ALIGNMENT);
		label.setBackground(color);
		label.setOpaque(true);
		toolBar.add(label);
		toolBar.add(new FontType(w));
		toolBar.add(new FontSize(w));
		toolBar.add(new FontStyle(w));

		Open_SavePanel openSavePanel=new Open_SavePanel(w, this);
		JScrollPane jScrollPane=new JScrollPane(openSavePanel);
		jScrollPane.remove(jScrollPane.getVerticalScrollBar());
		jScrollPane.remove(jScrollPane.getHorizontalScrollBar());
		toolBar.add(jScrollPane);

		toolBar.addSeparator();
		add(toolBar);
		add(new JLabel());
		int borderWidth=1;
		//setBorder(new EmptyBorder(borderWidth,borderWidth,borderWidth,borderWidth));
	}
	
	public void changeDocumentLabel(String name)
	{
		label.setText(name+"  ");
	}
	
	public String getDocumentLabel()
	{
		return label.getText();
	}
	
}
