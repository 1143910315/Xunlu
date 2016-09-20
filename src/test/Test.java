package test;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JViewport;

public class Test {
	public static void main(String[] args) {
		JFrame aJFrame = new JFrame();
		JScrollBar aJScrollBar = new JScrollBar(JScrollBar.HORIZONTAL);
		JScrollBar bJScrollBar = new JScrollBar(JScrollBar.VERTICAL);
		JViewport aJViewport = new JViewport();
		aJViewport.add(aJScrollBar);
		aJViewport.add(bJScrollBar);
		aJFrame.add(aJViewport);
		aJFrame.setVisible(true);
	}
}
