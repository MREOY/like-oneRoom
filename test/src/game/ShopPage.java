package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShopPage {

	int ck = 0;
	int c= 0;
	
	public ShopPage(JFrame jf) {
		JPanel shopPage = new JPanel();
		Tool.SetPanelF(jf, shopPage, 0, 0, Resource.screenW, Resource.screenH);
		new ShopHelper().Money(shopPage);
		 
		JButton backB = new JButton(Resource.backImage);
		backB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				shopPage.setVisible(false);
				new MainPage(jf);
			}
		});
		Tool.SetButtonP(shopPage, backB, 350, 0, 50, 50);
		
		JButton front = new JButton(Resource.frontImage);
		front.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				shopPage.setVisible(false);
				new ShopHelper().ShopPage(jf, shopPage, 2);
			}
		});
		Tool.SetButtonP(shopPage, front, 350, 550, 50, 50);
		
		ck = c = 0;
		while(c != 5) {
			new ShopHelper().ShopButtonAdd(jf, shopPage, ck, 0, c);
			new ShopHelper().ShopButtonAdd(jf, shopPage, ck + 5, 150, c);
			ck++;
			c++;
		}
		
	}
}
