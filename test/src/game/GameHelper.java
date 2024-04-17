package game;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameHelper {
	static void GameClear(JFrame jf, Thread th) {
		th.interrupt();
		
		JPanel endPage = new JPanel();
		Tool.SetPanelF(jf, endPage, 0, 0, 400, 600);
		
		JLabel gameEnd = new JLabel(Resource.stageclearImage);
		Tool.SetLabelP(endPage, gameEnd, 50, 50, 300, 50, null);
		
		JLabel nowScoreImg = new JLabel(Resource.nowscoreImage);
		Tool.SetLabelP(endPage, nowScoreImg, 125, 130, 150, 50, null);
		
		JLabel nowScore = new JLabel();
		Tool.SetLabelP(endPage, nowScore, 125, 210, 150, 50, "" + Resource.score);
		Tool.SetLabelFont(nowScore, 25, Font.ITALIC, "" + Resource.score);
		nowScore.setHorizontalAlignment(JLabel.CENTER);
		
		JButton nextStage = new JButton(Resource.nextStageImage);
		nextStage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				endPage.setVisible(false);
				if(Resource.nowStage >= Resource.stageCount)
					Resource.nowStage = 1;
				else
					Resource.nowStage++;
				new Stage(jf);
			}
		});
		Tool.SetButtonP(endPage, nextStage, 125, 420, 150, 50);
		
		JButton exit = new JButton(Resource.exitImage);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Resource.money += Resource.score;
				System.out.println(Resource.money);
				endPage.setVisible(false);
				new GamePage(jf);
			}
		});
		Tool.SetButtonP(endPage, exit, 125, 500, 150, 50);
	}
	
	static void GameEnd(JFrame jf, Thread th) {
		th.interrupt();
		JPanel endPage = new JPanel();
		Tool.SetPanelF(jf, endPage, 0, 0, 400, 600);
		
		JLabel gameEnd = new JLabel(Resource.stagefailImage);
		Tool.SetLabelP(endPage, gameEnd, 50, 50, 300, 50, null);
		
		JLabel nowScoreImg = new JLabel(Resource.nowscoreImage);
		Tool.SetLabelP(endPage, nowScoreImg, 125, 130, 150, 50, null);
		
		JLabel nowScore = new JLabel();
		Tool.SetLabelP(endPage, nowScore, 125, 210, 150, 50, "" + Resource.score);
		Tool.SetLabelFont(nowScore, 25, Font.ITALIC, "" + Resource.score);
		nowScore.setHorizontalAlignment(JLabel.CENTER);
		
		JButton exit = new JButton(Resource.exitImage);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Resource.money += Resource.score;
				endPage.setVisible(false);
				new GamePage(jf);
			}
		});
		Tool.SetButtonP(endPage, exit, 125, 500, 150, 50);
	}
	
	static void GameInit() {
		Random rand = new Random();
		Resource.gameClear = false;
		Resource.gameEnd = false;
		Resource.stop = false;
		for (int i = 0; i < Resource.y; i++) {
			for (int j = 0; j < Resource.x; j++) {
				Resource.gamePan[i][j] = 0;
			}
		}
		for (int i = 0; i < 30; i++) {
			Resource.gamePan[rand.nextInt(Resource.y)][rand.nextInt(Resource.x)] = rand.nextInt(5);
		}
	}
	
	static void StagePlace(JFrame jf, JPanel jp, int a) {
		JButton stage = new JButton(Resource.stageImage[a - 1]);
		stage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Resource.nowStage = a;
				new Stage(jf);
				jp.setVisible(false);
			}
		});
		Tool.SetButtonP(jp, stage, 50, 100 + 70 * (a - 1), 300, 50);
	}
	
	static void GamePanAdd() {
		int k, l, c = 0;
		Random rand = new Random();
		for(int i = 0; i < 10; i++) {
			
			k = rand.nextInt(Resource.x);
			l = rand.nextInt(Resource.y);
			if(Resource.gameClear || c >= Resource.x * Resource.y) break;
			
			if(Resource.gamePan[l][k] == 0) {
				Resource.gamePan[l][k] = rand.nextInt(5);
			}else {
				i--;
			}
			c++;
		}
	}
	
	static void GiveScore(int ck, JLabel jl) {
		Resource.score += ck;
		Tool.SetLabelFont(jl, 25, Font.ITALIC, "" + Resource.score);
	}
	
	static void CheckRemain() {
		int ck = 0, ckPan = 0;
		for(int i = 0; i < Resource.y; i++) {
			for(int j = 0; j < Resource.x; j++) {
				ck += Check(i, j, 0, null);
				if(Resource.gamePan[i][j] != 0)
					ckPan++;
			}
		}
		if(ck == 0) {
			Resource.gameClear = true;
		}
		if(ckPan >= Resource.x * Resource.y)
			Resource.gameEnd = true;
		
	}
	
	static int Check(int l, int k, int stage, JLabel jl) {
		int xr, xl, yu, yd, ck = 0;
		
		xl = GameHelper.CheckLeftX(k, l, false);
		xr = GameHelper.CheckRightX(k, l, false);
		yu = GameHelper.CheckUpY(k, l, false);
		yd = GameHelper.CheckDownY(k, l, false);
		
		if (xl == xr && xl != 0) {
			if(stage != 0) {
				if(xl != yu && xl != yd)
					GameHelper.CheckLeftX(k, l, true);
				if(xr != yu && xr != yd)
					GameHelper.CheckRightX(k, l, true);
			}
			ck++;
		}
		
		if (yu == yd && yu != 0) {
			if(stage != 0) {
				if(yu != xl && yu != xr)
					GameHelper.CheckUpY(k, l, true);
				if(yd != xl && yd != xr)
					GameHelper.CheckDownY(k, l, true);
			}
			ck++;
		}
		
		if (xl == yu && xl != 0) {
			if(stage != 0) {
				GameHelper.CheckLeftX(k, l, true);
				GameHelper.CheckUpY(k, l, true);	
			}
			ck++;
		}
		
		if (xl == yd && xl != 0) {
			if(stage != 0) {
				if(xl != yu)	
					GameHelper.CheckLeftX(k, l, true);
				if(yd != xr)
					GameHelper.CheckDownY(k, l, true);
			}
			ck++;
		}
		
		if (xr == yu && xr != 0) {
			if(stage != 0) {
				if(xr != yd)
					GameHelper.CheckRightX(k, l, true);
				if(yu != xl)
					GameHelper.CheckUpY(k, l, true);
			}
			ck++;
		}
		
		if (xr == yd && xr != 0) {
			if(stage != 0) {
				GameHelper.CheckRightX(k, l, true);
				GameHelper.CheckDownY(k, l, true);
			}
			ck++;
		}
		
		if(ck == 0 && stage != 0) {
			GamePanAdd();
			PanRepaint(stage);
		}
		if(stage == 0) {
			return ck;
		}
		if(jl != null) GiveScore(ck, jl);
		return 0;
	}

	static int CheckLeftX(int x, int y, boolean d) {
		for (int k = 0; k < x; k++) {
			if (Resource.gamePan[y][x - k - 1] != 0) {
				if (d == false) {
					return Resource.gamePan[y][x - k - 1];
				} else {
					Resource.gamePan[y][x - k - 1] = 0;
					return 0;
				}
			}
		}
		return 0;
	}

	static int CheckRightX(int x, int y, boolean d) {
		for (int k = 0; k < Resource.x - x - 1; k++) {
			if (Resource.gamePan[y][k + x + 1] != 0) {
				if (d == false) {
					return Resource.gamePan[y][k + x + 1];
				} else {
					Resource.gamePan[y][x + k + 1] = 0;
					return 0;
				}
			}
		}
		return 0;
	}

	static int CheckUpY(int x, int y, boolean d) {
		for (int k = 0; k < y; k++) {
			if (Resource.gamePan[y - k - 1][x] != 0) {
				if (d == false) {
					return Resource.gamePan[y - k - 1][x];
				} else {
					Resource.gamePan[y - k - 1][x] = 0;
					return 0;
				}
			}
		}
		return 0;
	}

	static int CheckDownY(int x, int y, boolean d) {
		for (int k = 0; k < Resource.y - y - 1; k++) {
			if (Resource.gamePan[y + k + 1][x] != 0) {
				if (d == false) {
					return Resource.gamePan[y + k + 1][x];
				} else {
					Resource.gamePan[y + k + 1][x] = 0;
					return 0;
				}
			}
		}
		return 0;
	}
	
	static void ButtonEvent(JButton jb, JFrame jf, JLabel jl, JPanel jp, int x, int y, int stage, Thread th) {
		jb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Resource.gamePan[y][x] == 0) {
					Check(y, x, stage,jl);
				}
				else {
					if(!Resource.gameClear)
						GamePanAdd();
				}
				PanRepaint(stage);
				jf.repaint();
				CheckRemain();
				if(Resource.gameEnd) {
					jp.setVisible(false);
					GameEnd(jf, th);
				}
				else if(Resource.gameClear) {
					jp.setVisible(false);
					GameClear(jf, th);
				}
			}
		});
	}
	
	static void PanRepaint(int stage) {
		for (int i = 0; i < Resource.y; i++) {
			for (int j = 0; j < Resource.x; j++) {
				Tool.SetButtonImage(Resource.jb[i * Resource.x + j], Resource.gridImage[stage - 1][Resource.gamePan[i][j]]);
			}
		}
	}
}
