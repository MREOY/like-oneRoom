package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainPage {
	public MainPage(JFrame jf) {
		JPanel mainPage = new JPanel();
		Tool.SetPanelF(jf, mainPage, 0, 0, Resource.screenW, Resource.screenH);
		
		Tool.TimeView(mainPage);

		JButton slectStageB = new JButton(Resource.startImage);
		slectStageB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainPage.setVisible(false);
				new GamePage(jf);
			}
		});
		Tool.SetButtonP(mainPage, slectStageB, 150, 550, 100, 50);

		JButton shopB = new JButton(Resource.shopImage);
		shopB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainPage.setVisible(false);
				new ShopPage(jf);
			}
		});
		Tool.SetButtonP(mainPage, shopB, 300, 550, 100, 50);

		JButton settingB = new JButton(Resource.settingImage);
		settingB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainPage.setVisible(false);
				new SettingPage(jf);
			}
		});
		Tool.SetButtonP(mainPage, settingB, 0, 550, 100, 50);
		
		new ShopHelper().ItemPlace(mainPage, 3);
		new ShopHelper().ItemPlace(mainPage, 2);
		new ShopHelper().ItemPlace(mainPage, 1);
	}
}
