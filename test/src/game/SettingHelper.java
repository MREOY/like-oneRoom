package game;

import java.sql.SQLException;

import resource.Database;

public class SettingHelper {
	static int count = 0;
	
	static void Refound() {
		count = 0;
		try {
		execute("use list");
			var rs = Database.stmt.executeQuery("select * from p");
			while(rs.next()) {
				count++;
			}
			Resource.money += 10 * (count - 1);
			ResetPage();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	static void ResetPage() {
		
		try {
			execute("use list");
			var rs = Database.stmt.executeQuery("select * from p");
			execute("drop database if exists list");
			execute("drop user if exists user@localhost");
			execute("create database list");
			execute("create user user@localhost identified by '0000'");
			execute("use list");
			execute("set global local_infile = 1");
			execute("grant select, insert, delete, update on list.* to user@localhost");
			execute("create table p"
					+ "("
					+ "no int primary key not null auto_increment, "
					+ "x int, "
					+ "y int, "
					+ "iconnum int, "
					+ "rotate int, "
					+ "layer int, "
					+ "money int"
					+ ")");
			execute("insert into p (no, money) values (0, '0')");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	static void execute(String sql) {
		try {
			resource.Database.stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(sql);
		}
	}
}
