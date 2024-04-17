package game;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import resource.Database;

public class ShopHelper {
	int x = 0;
	int y = 0;
	int c = 0;
	int ck = 0;
	int d = 0;
	int layer = 1;
	boolean itemSet = false;
	ImageIcon helpImg = new ImageIcon();
	
	void Money(JPanel jp) {
		JLabel money = new JLabel(Resource.money+"");
		Tool.SetLabelP(jp, money, 0, 0, 400, 50, "돈 :" + Resource.money);
		Tool.SetLabelFont(money, 15, Font.ITALIC, "돈 :" + Resource.money);
		money.setHorizontalAlignment(JLabel.CENTER);
	}
	
	void ItemPlace(JPanel jp, int a) {
		try {
			execute("use list");
			var rs = Database.stmt.executeQuery("select * from p");
			while(rs.next()) {
				if(rs.getInt("no") == 1) continue;
				int num = rs.getInt("no");
				int x = rs.getInt("x");
				int y = rs.getInt("y");
				int i = rs.getInt("iconnum");
				int l = rs.getInt("layer");
				int r = rs.getInt("rotate");
				if(l == a) {
					Resource.itemPlace[num - 2] = new JLabel(helpImg);
					Tool.SetLabelP(jp, Resource.itemPlace[num - 2], x, y, Resource.itemImage[i][r].getIconWidth(), Resource.itemImage[i][r].getIconHeight(), null);
					Tool.SetLabelImage(Resource.itemPlace[num - 2], Resource.itemImage[i][r]);
				}
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	
	}
	
	void SetItem(int a, int b, JFrame jf) {
		
		JPanel jp = new JPanel();
		Tool.SetPanelF(jf, jp, 0, 0, 400, 600);
		
		JLabel jl = new JLabel(Resource.itemImage[a][b]);	
		Tool.SetLabelP(jp, jl, 100, 100, Resource.itemImage[a][b].getIconWidth(), Resource.itemImage[a][b].getIconHeight(), null);
		Tool.SetLabelImage(jl, Resource.itemImage[a][b]);
		
		JButton rotate = new JButton(Resource.itemRotateImage);
		rotate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(c >= 3) c = 0;
				else c++;
				Tool.SetLabelImage(jl, Resource.itemImage[a][c]);
				jl.setSize(Resource.itemImage[a][c].getIconWidth(), Resource.itemImage[a][c].getIconHeight());
			}
			
		});
		Tool.SetButtonP(jp, rotate, 300, 540, 50, 50);
		
		JButton check = new JButton(Resource.placeitemImage);
		check.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				Resource.money -= Resource.itemPrice[a];
				try {
					execute("use list");
					var rs = resource.Database.stmt.executeQuery("select * from p");
					execute("insert into p (no, x, y, iconnum, rotate, layer) values (0, '" + x +"', '" + y +"', '" + a + "', '" + c +"', '" + layer +"')");
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				jp.setVisible(false);
				new MainPage(jf);
			}
		});
		Tool.SetButtonP(jp, check, 150, 540, 100, 50);
		
		JButton cancel = new JButton(Resource.cancelImage);
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jp.setVisible(false);
				new ShopPage(jf);
			}
		});
		Tool.SetButtonP(jp, cancel, 50, 540, 50, 50);
		
		JButton up = new JButton(Resource.upArrowImage);
		up.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(layer < 3) layer++;
			}
		});
		Tool.SetButtonP(jp, up, 10, 5, 25, 50);
		
		JButton down = new JButton(Resource.downArrowImage);
		down.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(layer > 1) layer--;
			}
		});
		Tool.SetButtonP(jp, down, 45, 5, 25, 50);
		
		JButton wb = new JButton(Resource.wImage);
		wb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				y -= 1;
				jl.setLocation(x, y);
			}
		});
		Tool.SetButtonP(jp, wb, 300, 8, 20, 20);
		JButton ab = new JButton(Resource.aImage);
		ab.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				x -= 1;
				jl.setLocation(x, y);
			}
		});
		Tool.SetButtonP(jp, ab, 275, 33, 20, 20);
		JButton sb = new JButton(Resource.sImage);
		sb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				y += 1;
				jl.setLocation(x, y);
			}
		});
		Tool.SetButtonP(jp, sb, 300, 33, 20, 20);
		JButton db = new JButton(Resource.dImage);
		db.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				x += 1;
				jl.setLocation(x, y);
			}
		});
		Tool.SetButtonP(jp, db, 325, 33, 20, 20);
		
		ItemPlace(jp, 3);
		ItemPlace(jp, 2);
		ItemPlace(jp, 1);
		
		JLabel page = new JLabel(Resource.itemImage[a][b]);
		Tool.SetLabelP(jp, page, 0, 0, 400, 600, null);
		Tool.SetLabelImage(page, Resource.setitempageImage);
		
		jp.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				x = e.getX() - (Resource.itemImage[a][c].getIconWidth()/2);
				y = e.getY() - (Resource.itemImage[a][c].getIconHeight()/2);
				jl.setLocation(x, y);
			}
		});
	}
	
	void ShopPage(JFrame jf, JPanel jp, int a) {
		
		int b = a;
		
		jp.setVisible(false);
		
		JPanel jp1 = new JPanel();
		Tool.SetPanelF(jf, jp1, 0, 0, 400, 600);
		
		JButton backB = new JButton(Resource.backImage);
		backB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jp1.setVisible(false);
				new MainPage(jf);
			}
		});
		Tool.SetButtonP(jp1, backB, 350, 0, 50, 50);
		
		Money(jp1);
		
		JButton back = new JButton(Resource.backImage);
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jp1.setVisible(false);
				if(b - 1 == 1) new ShopPage(jf);
				else ShopPage(jf, jp1, b - 1);
			}
		});
		Tool.SetButtonP(jp1, back, 0, 550, 50, 50);
		
		JButton front = new JButton(Resource.frontImage);
		front.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jp1.setVisible(false);
				ShopPage(jf, jp1, b + 1);
			}
		});
		Tool.SetButtonP(jp1, front, 350, 550, 50, 50);
		
		d = 0;
		ck = 10 * (b - 1);
		while(d != 5) {
			ShopButtonAdd(jf, jp1, ck, 0, d);
			ShopButtonAdd(jf, jp1, ck + 5, 150, d);
			ck++;
			d++;
		}
	}
	
	void ShopButtonAdd(JFrame jf, JPanel jp, int a, int b, int c) {
			JLabel itemImg = new JLabel(Resource.itemImage[a][0]);
			Tool.SetLabelP(jp, itemImg, 50 + b, 130 + 70*c, Resource.itemImage[a][0].getIconWidth(), Resource.itemImage[a][0].getIconHeight(), null);
				
			JLabel text = new JLabel();
			Tool.SetLabelP(jp, text, 0, 550, 400, 50, "");
			Tool.SetLabelFont(text, 15, Font.ITALIC, "");
			text.setHorizontalAlignment(JLabel.CENTER);
			
			JButton buy = new JButton(Resource.itemPrice[a] + "");
			buy.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(Resource.money >= Resource.itemPrice[a]) {
						jp.setVisible(false);
						SetItem(a, 0, jf);
					}
					else {
						text.setText("돈이 부족합니다.");
					}
				}
			});
			Tool.SetButtonP(jp, buy, 130 + b, 130 + 70*c, 50, 50);
	}
	
	void execute(String sql) {
		try {
			resource.Database.stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(sql);
		}
	}
}
