package com.hk03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;


public class MemberDAO {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "hkim";
	private String upw = "hagojun";
	
	public static final int MEMBER_NONEXISTENT  = 1;
	public static final int MEMBER_EXISTENT = 1;
	public static final int MEMBER_JOIN_FAIL = 1;
	public static final int MEMBER_JOIN_SUCCESS = 0;
	public static final int MEMBER_LOGIN_PW_NO_GOOD = 0;
	public static final int MEMBER_LOGIN_SUCCESS = 0;
	public static final int MEMBER_LOGIN_IS_NOT = -1;
	
	private static MemberDAO memberinst = new MemberDAO();
	
	private MemberDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDAO getInstance() {
		return memberinst;
	}
	
	
	public int insertMember(MemberDTO dto) {
		int rtn = 0;
		Connection con = null;
		PreparedStatement  pstmt = null;
		ResultSet  rs = null;	
		String query = "insert into members value (?,?,?,?,?,?,?,?)";
		try {
			// connect
			con = DriverManager.getConnection(url, uid, upw);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getPhone());
			pstmt.setString(5, dto.getAddress());			
			pstmt.setString(6, dto.geteMail());
			pstmt.setString(7, dto.getGender());
			pstmt.setTimestamp(8, dto.getrDate());
			pstmt.executeQuery();
			rtn = MemberDAO.MEMBER_JOIN_SUCCESS;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return rtn;
	}
	
	public int confirmId(String id) {
		int rtn = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select id from members where id = ?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				rtn = MemberDAO.MEMBER_EXISTENT;
			}else {
				rtn = MemberDAO.MEMBER_JOIN_SUCCESS;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return rtn;
	}
	
	public int userCheck(String id , String pw) {
		int rtn = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select pw from members where id = ?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				rtn = 0;
			}else {
				rtn = 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return rtn;
	}
	
	public ArrayList<MemberDTO> membersAll(){
		
		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		
		Connection con = null;
		Statement  stmt = null;
		ResultSet  rs = null;	
		
		try {
			con = DriverManager.getConnection(url, uid, upw);
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from member");
			
			while(rs.next()) {
				String name = rs.getString("name");
				String id  = rs.getString("id");
				String pw = rs.getString("pw");
				String phone  = rs.getString("phone");
				String gender  = rs.getString("gender");
				String eMail  = rs.getString("eMail");
				Timestamp rDate  = rs.getTimestamp("rDate");
				String address =rs.getString("address");
				MemberDTO dto = new MemberDTO();
				dtos.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return dtos;
	}
	
	public MemberDTO getMember(String id) {
		Connection con = null;
		PreparedStatement  pstmt = null;
		ResultSet rs = null;
		String query = "select * from members where id = ?";
		MemberDTO dto = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setId(rs.getString("id"));
			    dto.setPw(rs.getString("pw"));
			    dto.setName(rs.getString("name"));
				dto.seteMail(rs.getString("eMail"));
				dto.setrDate(rs.getTimestamp("rDate"));
				dto.setAddress(rs.getString("address"));
				dto.setGender(rs.getNString("gender"));
				dto.setPhone(rs.getString("phone1"), rs.getString("phone2"), rs.getString("phone3"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return dto;
	}
	
	
	public int updateMember(MemberDTO dto) {
		int rtn = 0;
       
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		String query = "update members set pw=?, eMail=?, address=? where id=?";
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.geteMail());
			pstmt.setString(3, dto.getAddress());
			pstmt.setString(4, dto.getId());
			rtn = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		return rtn;
	}
	
	private Connection getConnection() {
		
		Context context = null;
		DataSource dataSource = null;
		Connection connection = null;
		try {
			context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			connection = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
