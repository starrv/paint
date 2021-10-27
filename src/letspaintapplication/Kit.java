package letspaintapplication;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Checkbox;
import java.awt.CheckboxMenuItem;
import java.awt.Choice;
import java.awt.Desktop;
import java.awt.Dialog;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Label;
import java.awt.List;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.PrintJob;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.datatransfer.Clipboard;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.InvalidDnDOperationException;
import java.awt.dnd.peer.DragSourceContextPeer;
import java.awt.font.TextAttribute;
import java.awt.im.InputMethodHighlight;
import java.awt.image.ColorModel;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.awt.peer.ButtonPeer;
import java.awt.peer.CanvasPeer;
import java.awt.peer.CheckboxMenuItemPeer;
import java.awt.peer.CheckboxPeer;
import java.awt.peer.ChoicePeer;
import java.awt.peer.DesktopPeer;
import java.awt.peer.DialogPeer;
import java.awt.peer.FileDialogPeer;
import java.awt.peer.FontPeer;
import java.awt.peer.FramePeer;
import java.awt.peer.LabelPeer;
import java.awt.peer.ListPeer;
import java.awt.peer.MenuBarPeer;
import java.awt.peer.MenuItemPeer;
import java.awt.peer.MenuPeer;
import java.awt.peer.PanelPeer;
import java.awt.peer.PopupMenuPeer;
import java.awt.peer.ScrollPanePeer;
import java.awt.peer.ScrollbarPeer;
import java.awt.peer.TextAreaPeer;
import java.awt.peer.TextFieldPeer;
import java.awt.peer.WindowPeer;
import java.net.URL;
import java.util.Map;
import java.util.Properties;

public class Kit extends Toolkit{

	@Override
	public void beep() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int checkImage(Image arg0, int arg1, int arg2, ImageObserver arg3) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected ButtonPeer createButton(Button arg0) throws HeadlessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected CanvasPeer createCanvas(Canvas arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected CheckboxPeer createCheckbox(Checkbox arg0)
			throws HeadlessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected CheckboxMenuItemPeer createCheckboxMenuItem(CheckboxMenuItem arg0)
			throws HeadlessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ChoicePeer createChoice(Choice arg0) throws HeadlessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected DesktopPeer createDesktopPeer(Desktop arg0)
			throws HeadlessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected DialogPeer createDialog(Dialog arg0) throws HeadlessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DragSourceContextPeer createDragSourceContextPeer(
			DragGestureEvent arg0) throws InvalidDnDOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected FileDialogPeer createFileDialog(FileDialog arg0)
			throws HeadlessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected FramePeer createFrame(Frame arg0) throws HeadlessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image createImage(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image createImage(URL arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image createImage(ImageProducer arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image createImage(byte[] arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected LabelPeer createLabel(Label arg0) throws HeadlessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ListPeer createList(List arg0) throws HeadlessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected MenuPeer createMenu(Menu arg0) throws HeadlessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected MenuBarPeer createMenuBar(MenuBar arg0) throws HeadlessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected MenuItemPeer createMenuItem(MenuItem arg0)
			throws HeadlessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected PanelPeer createPanel(Panel arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected PopupMenuPeer createPopupMenu(PopupMenu arg0)
			throws HeadlessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ScrollPanePeer createScrollPane(ScrollPane arg0)
			throws HeadlessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ScrollbarPeer createScrollbar(Scrollbar arg0)
			throws HeadlessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected TextAreaPeer createTextArea(TextArea arg0)
			throws HeadlessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected TextFieldPeer createTextField(TextField arg0)
			throws HeadlessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected WindowPeer createWindow(Window arg0) throws HeadlessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ColorModel getColorModel() throws HeadlessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getFontList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FontMetrics getFontMetrics(Font arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected FontPeer getFontPeer(String arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image getImage(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image getImage(URL arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrintJob getPrintJob(Frame arg0, String arg1, Properties arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getScreenResolution() throws HeadlessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Dimension getScreenSize() throws HeadlessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Clipboard getSystemClipboard() throws HeadlessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected EventQueue getSystemEventQueueImpl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isModalExclusionTypeSupported(ModalExclusionType arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isModalityTypeSupported(ModalityType arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<TextAttribute, ?> mapInputMethodHighlight(
			InputMethodHighlight arg0) throws HeadlessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean prepareImage(Image arg0, int arg1, int arg2,
			ImageObserver arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void sync() {
		// TODO Auto-generated method stub
		
	}

}
