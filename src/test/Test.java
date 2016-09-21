package test;
import gen.Xunlu;

public class Test {
	public static void main(String[] args) {
		/*
		 * JFrame aJFrame = new JFrame(); JScrollBar aJScrollBar = new
		 * JScrollBar(JScrollBar.HORIZONTAL); JScrollBar bJScrollBar = new
		 * JScrollBar(JScrollBar.VERTICAL); JViewport aJViewport = new
		 * JViewport(); aJViewport.add(aJScrollBar);
		 * aJViewport.add(bJScrollBar); aJFrame.add(aJViewport);
		 * aJFrame.setVisible(true);
		 */
		System.out.println(System.currentTimeMillis());
		int left = 10000;
		int top = 10000;
		Xunlu aXunlu = new Xunlu(left, top);
		aXunlu.setorigin(0, 0);
		aXunlu.xunlu(left - 1, top - 1);
		System.out.println(System.currentTimeMillis());
	}
}
