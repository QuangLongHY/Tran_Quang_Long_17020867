package GetData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Word;

public class Getdata {
	private final String url = "jdbc:mysql://localhost:3306/dictionary";
	private final String user = "root";
	private final String password = "17020867";
	
	public List<Word> getModel() {
		List<Word> result = new ArrayList<Word>();
		try {		
			Connection conn = DriverManager.getConnection(this.url, this.user, this.password);
			String sql = "SELECT * FROM diction";
			PreparedStatement pps = conn.prepareStatement(sql);
			ResultSet rs = pps.executeQuery();
			while (rs.next()) {
				result.add(new Word(rs.getString("word"),rs.getString("detail")));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public int DeleteWord(String word) {
		int rs = 0;
		try {		
			Connection conn = DriverManager.getConnection(this.url, this.user, this.password);
			String sql = "DELETE FROM diction WHERE word = ?";
			PreparedStatement pps = conn.prepareStatement(sql);
			pps.setString(1, word);
			rs = pps.executeUpdate();	
			System.out.println(rs);
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public int AddWord(String word, String mean) {
		int rs = 0;
		try {		
			Connection conn = DriverManager.getConnection(this.url, this.user, this.password);
			String sql = "Insert into diction(word,detail) VALUes (?,?)";
			PreparedStatement pps = conn.prepareStatement(sql);
			pps.setString(1, word);
			pps.setString(2, mean);
			rs = pps.executeUpdate();	
			System.out.println(rs);
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public int EditWord(String oword, String nword) {
		int rs = 0;
		try {		
			Connection conn = DriverManager.getConnection(this.url, this.user, this.password);
			String sql = "update diction set word = ? where word = ?";
			PreparedStatement pps = conn.prepareStatement(sql);
			pps.setString(1, oword);
			pps.setString(2, nword);
			rs = pps.executeUpdate();	
			System.out.println(rs);
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
