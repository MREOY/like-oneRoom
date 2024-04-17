package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GamePage {
	public GamePage(JFrame jf) {
		JPanel gamePage = new JPanel();
		Tool.SetPanelF(jf, gamePage, 0, 0, Resource.screenW, Resource.screenH);

		JButton backB = new JButton(Resource.backImage);
		backB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainPage(jf);
				gamePage.setVisible(false);
			}
		});
		Tool.SetButtonP(gamePage, backB, 350, 0, 50, 50);
		
		GameHelper.StagePlace(jf, gamePage, 1);
		GameHelper.StagePlace(jf, gamePage, 2);
		GameHelper.StagePlace(jf, gamePage, 3);
		GameHelper.StagePlace(jf, gamePage, 4);
		
		Resource.score = 0;
	}
}
