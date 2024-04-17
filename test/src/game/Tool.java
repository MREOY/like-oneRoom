package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.time.LocalTime;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tool {
	static void Init() {
		try {
			execute("use list");
			var rs = resource.Database.stmt.executeQuery("select * from p where no = 1");
			rs.next();
			Resource.money = rs.getInt("money");		
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	static void TimeView(JPanel jp) {
		LocalTime now = LocalTime.now();
		
		JLabel time = new JLabel();
		SetLabelP(jp, time, 0, 0, 400, 50, now.getHour() + "시 " + now.getMinute() + "분");
		SetLabelFont(time, 15, Font.ITALIC, now.getHour() + "시 " + now.getMinute() + "분");
		time.setHorizontalAlignment(JLabel.CENTER);
		
	}
	
	static void SetFrame(JFrame jf, int x, int y, int w, int h, int s) {
		jf.setSize(w + 16, h + 39);
		jf.setLayout(null);
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setLocationRelativeTo(null);
		if(s != 0) {
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					try {
						execute("use list");
						var rs = resource.Database.stmt.executeQuery("select * from p");
						rs.next();
						execute("UPDATE p SET money = " + Resource.money + " WHERE no = 1");					
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			});
		}
		jf.setBackground(Color.WHITE);
		jf.repaint();
	}
	
	static void execute(String sql) {
		try {
			resource.Database.stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(sql);
		}
	}

	static void SetPanelF(JFrame jf, JPanel jp, int x, int y, int w, int h) {
		jp.setLocation(x, y);
		jp.setSize(w, h);
		jp.setLayout(null);
		jf.add(jp);
		jp.setBackground(Color.WHITE);
	}

	static void SetButtonF(JFrame jf, JButton jb, int x, int y, int w, int h) {
		jb.setLocation(x, y);
		jb.setSize(w, h);
		jf.add(jb);
	}

	static void SetPanelP(JPanel jp1, JPanel jp, int x, int y, int w, int h) {
		jp.setLocation(x, y);
		jp.setSize(w, h);
		jp.setLayout(null);
		jp1.add(jp);
		jp.setBackground(Color.WHITE);
	}

	static void SetButtonP(JPanel jp, JButton jb, int x, int y, int w, int h) {
		jb.setLocation(x, y);
		jb.setSize(w, h);
		jp.add(jb);
	}

	static void SetLabelP(JPanel jp, JLabel jl, int x, int y, int w, int h, String s) {
		jl.setLocation(x, y);
		jl.setSize(w, h);
		if (s != null)
			jl.setText(s);
		jp.add(jl);
	}
	
	static void SetLabelF(JFrame jf, JLabel jl, int x, int y, int w, int h, String s) {
		jl.setLocation(x, y);
		jl.setSize(w, h);
		if (s != null)
			jl.setText(s);
		jf.add(jl);
	}

	static void SetButtonImage(JButton jb, ImageIcon icon) {
		jb.setIcon(icon);
	}

	static void SetLabelImage(JLabel jl, ImageIcon icon) {
		jl.setIcon(icon);
	}
	
	static void SetLabelFont(JLabel jl, int size, int font, String st) {
		Font f = new Font(st, font, size);
		jl.setText(st);
		jl.setFont(f);
	}
}
