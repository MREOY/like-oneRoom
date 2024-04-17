package game;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BounsGame {
	int bat = 0;
	int sco = 0;
	int move = 2;
	int objnum = 0;
	
	boolean gamePlay = true;
	boolean jump = false;
	
	int pimage = 0;
	
	void BounsOne()	{
		
		JFrame jf = new JFrame("Bonus Game One");
		Tool.SetFrame(jf, 50, 50, 300, 100, 0);
		
		JPanel page = new JPanel();
		Tool.SetPanelF(jf, page, 0, 0, 300, 100);
		
		JLabel score = new JLabel();
		Tool.SetLabelP(page, score, 0, 0, 300, 10, sco + " 점");
		score.setHorizontalAlignment(JLabel.CENTER);

		JLabel player = new JLabel(Resource.playerImage[0]);
		Tool.SetLabelP(page, player, 10, 60, 40, 40, null);
		Tool.SetLabelImage(player, Resource.playerImage[0]);
		
		JLabel sun = new JLabel(Resource.sunImage[0]);
		Tool.SetLabelP(page, sun, 290, 30, 10, 10, null);
		Tool.SetLabelImage(sun, Resource.sunImage[0]);
		
		JLabel obj = new JLabel();
		Tool.SetLabelP(page, obj, 300, 70, 60, 30, null);
		Tool.SetLabelImage(obj, Resource.objImage[0]);
	
		Timer m = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				Tool.SetLabelImage(player, Resource.playerImage[pimage]);
				Tool.SetLabelImage(sun, Resource.sunImage[pimage]);
				Tool.SetLabelImage(obj, Resource.objImage[objnum]);
				sun.setLocation(sun.getX() - 1, 30);
				obj.setLocation(obj.getX() - move, 70);
				
				if(sun.getX() <= -20) sun.setLocation(300, 30);
				if(obj.getX() <= -100) obj.setLocation(310, 70);
				if(sco % 100 == 0 && sco <= 1800) move += 1;
				
				if(pimage >= 3) pimage = 0;
				else pimage += 1;
				
				
				if(player.getY() < 60) player.setLocation(player.getX(), player.getY() + 2);
				else if (player.getY() == 60) player.setLocation(player.getX(), 60);
				
				sco++;
				
				score.setText(sco + " 점");
				
				
			}
		};
		
		m.schedule(task, 50, 50);
		
	}
}
