package resource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	
	public static Connection con;
	public static Statement stmt;
	
	static{
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/?serverTimezone=UTC&&allowLoadLocalInfile=true", "root", "0000");
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Database() {
		try {
			stmt.execute("drop database if exists list");
			stmt.execute("drop user if exists user@localhost");
			stmt.execute("create database list");
			stmt.execute("create user user@localhost identified by '0000'");
			stmt.execute("use list");
			stmt.execute("set global local_infile = 1");
			stmt.execute("grant select, insert, delete, update on list.* to user@localhost");
			stmt.execute("create table p"
					+ "("
					+ "no int primary key not null auto_increment, "
					+ "x int, "
					+ "y int, "
					+ "iconnum int, "
					+ "rotate int, "
					+ "layer int, "
					+ "money int"
					+ ")");
			stmt.execute("insert into p (no, money) values (0, '0')");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
			System.exit(0);
		}
	}
	
	
	public static void main(String[] args) {
		new Database();
	}
	public static ResultSet rs(String sql) {
		ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}