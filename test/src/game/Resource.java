package game;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Resource {
	static int screenW = 400;
	static int screenH = 600;
	
	static int score = 0;
	static boolean gameClear = false;
	static boolean gameEnd = false;
	
	static boolean stop = false;
	static int nowStage = 0;
	static int stageCount = 4;
	
	static int money = 0;

	static int x = 10, y = 15;

	static int[][] gamePan = new int[y][x];
	
	static JButton[] jb = new JButton[x * y];
	
	static ImageIcon backImage = new ImageIcon("../test/src/resource/back.png");
	static ImageIcon frontImage = new ImageIcon("../test/src/resource/front.png");
	static ImageIcon stopImage = new ImageIcon("../test/src/resource/stop.png");
	static ImageIcon exitImage = new ImageIcon("../test/src/resource/exit.png");
	static ImageIcon restartImage = new ImageIcon("../test/src/resource/restart.png");
	static ImageIcon nowscoreImage = new ImageIcon("../test/src/resource/nowscore.png");
	static ImageIcon scoreImage = new ImageIcon("../test/src/resource/score.png");
	static ImageIcon stagefailImage = new ImageIcon("../test/src/resource/stagefail.png");
	static ImageIcon stageclearImage = new ImageIcon("../test/src/resource/stageclear.png");
	static ImageIcon nextStageImage = new ImageIcon("../test/src/resource/nextstage.png");
	
	static ImageIcon[][] itemImage = {
		{
			new ImageIcon("../test/src/resource/woodblock_1.png"),
			new ImageIcon("../test/src/resource/woodblock_2.png"),
			new ImageIcon("../test/src/resource/woodblock_3.png"),
			new ImageIcon("../test/src/resource/woodblock_4.png")  
		},
		{
			new ImageIcon("../test/src/resource/woodstepblock_1.png"),
			new ImageIcon("../test/src/resource/woodstepblock_2.png"),
			new ImageIcon("../test/src/resource/woodstepblock_3.png"),
			new ImageIcon("../test/src/resource/woodstepblock_4.png")
		},
		{
			new ImageIcon("../test/src/resource/woodhalfblock_1.png"),
			new ImageIcon("../test/src/resource/woodhalfblock_2.png"),
			new ImageIcon("../test/src/resource/woodhalfblock_3.png"),
			new ImageIcon("../test/src/resource/woodhalfblock_4.png")
		},
		{
			new ImageIcon("../test/src/resource/woodsmallblock_1.png"),
			new ImageIcon("../test/src/resource/woodsmallblock_2.png"),
			new ImageIcon("../test/src/resource/woodsmallblock_3.png"),
			new ImageIcon("../test/src/resource/woodsmallblock_4.png")
		},
		{
			new ImageIcon("../test/src/resource/woodsmallstepblock_1.png"),
			new ImageIcon("../test/src/resource/woodsmallstepblock_2.png"),
			new ImageIcon("../test/src/resource/woodsmallstepblock_3.png"),
			new ImageIcon("../test/src/resource/woodsmallstepblock_4.png")
		},
		{
			new ImageIcon("../test/src/resource/woodwallpaper_1.png"),
			new ImageIcon("../test/src/resource/woodwallpaper_2.png"),
			new ImageIcon("../test/src/resource/woodwallpaper_3.png"),
			new ImageIcon("../test/src/resource/woodwallpaper_4.png")
		},
		{
			new ImageIcon("../test/src/resource/woodstepwallpaper_1.png"),
			new ImageIcon("../test/src/resource/woodstepwallpaper_2.png"),
			new ImageIcon("../test/src/resource/woodstepwallpaper_3.png"),
			new ImageIcon("../test/src/resource/woodstepwallpaper_4.png")
		},
		{
			new ImageIcon("../test/src/resource/woodhalfwallpaper_1.png"),
			new ImageIcon("../test/src/resource/woodhalfwallpaper_2.png"),
			new ImageIcon("../test/src/resource/woodhalfwallpaper_3.png"),
			new ImageIcon("../test/src/resource/woodhalfwallpaper_4.png")
		},	
		{
			new ImageIcon("../test/src/resource/woodsmallwallpaper_1.png"),
			new ImageIcon("../test/src/resource/woodsmallwallpaper_2.png"),
			new ImageIcon("../test/src/resource/woodsmallwallpaper_3.png"),
			new ImageIcon("../test/src/resource/woodsmallwallpaper_4.png")
		},
		{
			new ImageIcon("../test/src/resource/woodsmallstepwallpaper_1.png"),
			new ImageIcon("../test/src/resource/woodsmallstepwallpaper_2.png"),
			new ImageIcon("../test/src/resource/woodsmallstepwallpaper_3.png"),
			new ImageIcon("../test/src/resource/woodsmallstepwallpaper_4.png")
		},
		{
			new ImageIcon("../test/src/resource/glassblock_1.png"),
			new ImageIcon("../test/src/resource/glassblock_2.png"),
			new ImageIcon("../test/src/resource/glassblock_3.png"),
			new ImageIcon("../test/src/resource/glassblock_4.png")
		},
		{
			new ImageIcon("../test/src/resource/glassstepblock_1.png"),
			new ImageIcon("../test/src/resource/glassstepblock_2.png"),
			new ImageIcon("../test/src/resource/glassstepblock_3.png"),
			new ImageIcon("../test/src/resource/glassstepblock_4.png")
		},
		{
			new ImageIcon("../test/src/resource/glasshalfblock_1.png"),
			new ImageIcon("../test/src/resource/glasshalfblock_2.png"),
			new ImageIcon("../test/src/resource/glasshalfblock_3.png"),
			new ImageIcon("../test/src/resource/glasshalfblock_4.png")
		},
		{
			new ImageIcon("../test/src/resource/glasssmallblock_1.png"),
			new ImageIcon("../test/src/resource/glasssmallblock_2.png"),
			new ImageIcon("../test/src/resource/glasssmallblock_3.png"),
			new ImageIcon("../test/src/resource/glasssmallblock_4.png")
		},
		{
			new ImageIcon("../test/src/resource/glasssmallstepblock_1.png"),
			new ImageIcon("../test/src/resource/glasssmallstepblock_2.png"),
			new ImageIcon("../test/src/resource/glasssmallstepblock_3.png"),
			new ImageIcon("../test/src/resource/glasssmallstepblock_4.png")
		},
		{
			new ImageIcon("../test/src/resource/woodwallpaper_1.png"),
			new ImageIcon("../test/src/resource/woodwallpaper_2.png"),
			new ImageIcon("../test/src/resource/woodwallpaper_3.png"),
			new ImageIcon("../test/src/resource/woodwallpaper_4.png")
		},
		{
			new ImageIcon("../test/src/resource/woodstepwallpaper_1.png"),
			new ImageIcon("../test/src/resource/woodstepwallpaper_2.png"),
			new ImageIcon("../test/src/resource/woodstepwallpaper_3.png"),
			new ImageIcon("../test/src/resource/woodstepwallpaper_4.png")
		},
		{
			new ImageIcon("../test/src/resource/woodhalfwallpaper_1.png"),
			new ImageIcon("../test/src/resource/woodhalfwallpaper_2.png"),
			new ImageIcon("../test/src/resource/woodhalfwallpaper_3.png"),
			new ImageIcon("../test/src/resource/woodhalfwallpaper_4.png")
		},
		{
			new ImageIcon("../test/src/resource/woodsmallwallpaper_1.png"),
			new ImageIcon("../test/src/resource/woodsmallwallpaper_2.png"),
			new ImageIcon("../test/src/resource/woodsmallwallpaper_3.png"),
			new ImageIcon("../test/src/resource/woodsmallwallpaper_4.png")
		},
		{
			new ImageIcon("../test/src/resource/woodsmallstepwallpaper_1.png"),
			new ImageIcon("../test/src/resource/woodsmallstepwallpaper_2.png"),
			new ImageIcon("../test/src/resource/woodsmallstepwallpaper_3.png"),
			new ImageIcon("../test/src/resource/woodsmallstepwallpaper_4.png")
		}
	};
	
	static int[] itemPrice = {
		10, 10, 10, 10, 10, 
		10, 10, 10, 10, 10,
		15, 15, 15, 15, 15, 
		10, 10, 10, 10, 10
	};
	
	static JLabel[] itemPlace = new JLabel[100];
	
	static int itemLimitX = 20;
	static int itemLimitY = 60;
	
	static ImageIcon startImage = new ImageIcon("../test/src/resource/start.png");
	static ImageIcon shopImage = new ImageIcon("../test/src/resource/shop.png");
	static ImageIcon settingImage = new ImageIcon("../test/src/resource/setting.png");
	static ImageIcon setitempageImage = new ImageIcon("../test/src/resource/setitempage.png");
	static ImageIcon placeitemImage = new ImageIcon("../test/src/resource/placeimage.png");
	static ImageIcon itemRotateImage = new ImageIcon("../test/src/resource/rotateimage.png");
	static ImageIcon cancelImage = new ImageIcon("../test/src/resource/cancelimage.png");
	static ImageIcon upArrowImage = new ImageIcon("../test/src/resource/uparrow.png");
	static ImageIcon downArrowImage = new ImageIcon("../test/src/resource/downarrow.png");
	static ImageIcon wImage = new ImageIcon("../test/src/resource/w.png");
	static ImageIcon dImage = new ImageIcon("../test/src/resource/d.png");
	static ImageIcon sImage = new ImageIcon("../test/src/resource/s.png");
	static ImageIcon aImage = new ImageIcon("../test/src/resource/a.png");
	
	
	static ImageIcon[] stageImage = {
		new ImageIcon("../test/src/resource/stageone.png"),
		new ImageIcon("../test/src/resource/stagetwo.png"),
		new ImageIcon("../test/src/resource/stagethree.png"),
		new ImageIcon("../test/src/resource/stagefour.png")		
	};
	
	static ImageIcon[][] gridImage = { 
		{
			new ImageIcon("../test/src/resource/grid.png"), 
			new ImageIcon("../test/src/resource/yellow.png"),
			new ImageIcon("../test/src/resource/blue.png"), 
			new ImageIcon("../test/src/resource/pupple.png"),
			new ImageIcon("../test/src/resource/skyblue.png"), 
		},
		{
			new ImageIcon("../test/src/resource/grid.png"), 
			new ImageIcon("../test/src/resource/yellowMarum.png"),
			new ImageIcon("../test/src/resource/skyblueMarum.png"), 
			new ImageIcon("../test/src/resource/yellowCir.png"),
			new ImageIcon("../test/src/resource/skyblueCir.png"), 
		},
		{
			new ImageIcon("../test/src/resource/grid.png"), 
			new ImageIcon("../test/src/resource/american football.png"),
			new ImageIcon("../test/src/resource/baseball.png"), 
			new ImageIcon("../test/src/resource/football.png"),
			new ImageIcon("../test/src/resource/basketball.png"), 
		},
		{
			new ImageIcon("../test/src/resource/grid.png"), 
			new ImageIcon("../test/src/resource/bottle1.png"),
			new ImageIcon("../test/src/resource/bottle2.png"), 
			new ImageIcon("../test/src/resource/bottle3.png"),
			new ImageIcon("../test/src/resource/bottle4.png"), 
		}
	};
	
	static ImageIcon[] playerImage = { 
		new ImageIcon("../test/src/resource/player_1.png"),
		new ImageIcon("../test/src/resource/player_2.png"),
		new ImageIcon("../test/src/resource/player_3.png"),
		new ImageIcon("../test/src/resource/player_4.png"),
	};
	
	static ImageIcon[] sunImage = {
		new ImageIcon("../test/src/resource/sun_1.png"),
		new ImageIcon("../test/src/resource/sun_2.png"),
		new ImageIcon("../test/src/resource/sun_3.png"),
		new ImageIcon("../test/src/resource/sun_4.png"),
	};
	static ImageIcon[] objImage = {
			new ImageIcon("../test/src/resource/obj_1.png"),
			new ImageIcon("../test/src/resource/obj_2.png"),
			new ImageIcon("../test/src/resource/obj_3.png"),
			new ImageIcon("../test/src/resource/obj_4.png"),
		};
}
