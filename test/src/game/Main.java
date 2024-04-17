package game;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame mainFrame = new JFrame("");
		Tool.SetFrame(mainFrame, 100, 100, Resource.screenW, Resource.screenH, 1);
		Tool.Init();
		new MainPage(mainFrame);
	}
}

