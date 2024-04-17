package game;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Stage {
	public Stage(JFrame jf) {
		
		JPanel stagePage = new JPanel();
		Tool.SetPanelF(jf, stagePage, 0, 0, Resource.screenW, Resource.screenH);
		
		JPanel stopPage = new JPanel();
		Tool.SetPanelF(jf, stopPage, 0, 0, Resource.screenW, Resource.screenH);
		stopPage.setVisible(false);
		
		Time t = new Time();
		Thread th = new Thread(t);
		
		JLabel nowScoreImg = new JLabel(Resource.nowscoreImage);
		Tool.SetLabelP(stopPage, nowScoreImg, 125, 50, 150, 50, null);
		
		JLabel nowScore = new JLabel();
		Tool.SetLabelP(stopPage, nowScore, 125, 100, 150, 50, "" + Resource.score);
		nowScore.setHorizontalAlignment(JLabel.CENTER);
		
		JButton restartB = new JButton(Resource.restartImage);
		restartB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Resource.stop = false;
				stagePage.setVisible(true);
				stopPage.setVisible(false);
			}
		});
		Tool.SetButtonP(stopPage, restartB, 125, 300, 150, 50);
			
		JButton exitB = new JButton(Resource.exitImage);
		exitB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Resource.money += Resource.score;
				th.interrupt();
				stopPage.setVisible(false);
				new GamePage(jf);
			}
		});
		Tool.SetButtonP(stopPage, exitB, 125, 400, 150, 50);
		
		GameHelper.GameInit();
		
		JLabel scoreImg = new JLabel(Resource.scoreImage);
		Tool.SetLabelP(stagePage, scoreImg, 50, 0, 150, 100, null);
		
		JLabel score = new JLabel();
		Tool.SetLabelP(stagePage, score, 200, 0, 500, 100, "" + Resource.score);
		Tool.SetLabelFont(score, 25, Font.ITALIC, "" + Resource.score);
		
		JButton stopB = new JButton(Resource.stopImage);
		stopB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Tool.SetLabelFont(nowScore, 25, Font.ITALIC, "" + Resource.score);
				Resource.stop = true;
				stagePage.setVisible(false);
				stopPage.setVisible(true);
			}
		});
		Tool.SetButtonP(stagePage, stopB, 350, 0, 50, 50);

		for (int i = 0; i < Resource.y; i++) {
			for (int j = 0; j < Resource.x; j++) {
				Resource.jb[i * Resource.x + j] = new JButton(Resource.gridImage[Resource.nowStage - 1][Resource.gamePan[i][j]]);
				GameHelper.ButtonEvent(Resource.jb[i * Resource.x + j], jf, score, stagePage, j, i, Resource.nowStage, th);
				Tool.SetButtonP(stagePage, Resource.jb[i * Resource.x + j], j * 30 + 50, i * 30 + 80, 30, 30);
			}
		}
		
		th.start();
		
	}
}
