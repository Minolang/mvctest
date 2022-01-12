package mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDao {
	Connection conn = DBConnection.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public boolean LoginCheck(MemberDto dto) {
		String sql = "select count(*) from member where id = ? and pw = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int ret = rs.getInt(1);
				if(ret==1) return true;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}
	public boolean InsertMember(MemberDto dto) {
		String sql = "insert into member (id,pw,name,point) values(?,?,?,0)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			int r = pstmt.executeUpdate();
			if(r==1) return true;
			
		}catch(Exception e) {e.printStackTrace();}
		
		return false;
	}
	public MemberDto infoUser(String user_id) {
		String sql = "select * from member";
		MemberDto dto = null;
		
		try{
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				int point = rs.getInt("point");
				dto = new MemberDto(id,pw,name,point);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}//맴버 목록을 dto에 담아서??
	public boolean DeleteMember(MemberDto dto) {
		String sql ="delete from member where id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			int r = pstmt.executeUpdate();
			if(r==1) return true; 
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	
	
}
