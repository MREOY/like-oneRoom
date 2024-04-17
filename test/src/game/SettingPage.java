package game;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SettingPage {

	int f = 1;
	
	public SettingPage(JFrame jf) {
		JPanel settingPage = new JPanel();
		Tool.SetPanelF(jf, settingPage, 0, 0, Resource.screenW, Resource.screenH);
		
		JLabel text = new JLabel();
		Tool.SetLabelP(settingPage, text, 0, 550, 400, 50, "");
		Tool.SetLabelFont(text, 15, Font.ITALIC, "");
		text.setHorizontalAlignment(JLabel.CENTER);
		
		JButton backB = new JButton(Resource.backImage);
		backB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				settingPage.setVisible(false);
				new MainPage(jf);
			}
		});
		Tool.SetButtonP(settingPage, backB, 350, 0, 50, 50);
		
		JButton reset = new JButton("아이템 리셋");
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(f == 1) {
					f++;
					text.setText("모든 아이템은 10원으로 반환됩니다.");
				}
				else {
					f = 1;
					SettingHelper.Refound();
					text.setText("초기화 되었습니다.");
				}
			}
		});
		Tool.SetButtonP(settingPage, reset, 50, 70, 300, 50);
		
		JButton bouns = new JButton();
		bouns.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new BounsGame().BounsOne();;
			}
		});
		Tool.SetButtonP(settingPage, bouns, 175, 500, 50, 50);
		Tool.SetButtonImage(bouns, Resource.playerImage[0]);
		
	}
}
