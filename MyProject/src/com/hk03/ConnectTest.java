package com.hk03;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ConnectTest {

		
	public static void main(String[] args) {
		
		try {

			Connection con = null;



			con = DriverManager.getConnection("jdbc:mysql://localhost",

					"root", "hagojun");



			java.sql.Statement st = null;

			ResultSet rs = null;

			st = con.createStatement();

			rs = st.executeQuery("SHOW DATABASES");



			if (st.execute("SHOW DATABASES")) {

				rs = st.getResultSet();

			}



			while (rs.next()) {

				String str = rs.getNString(1);

				System.out.println(str);

			}

		} catch (SQLException sqex) {

			System.out.println("SQLException: " + sqex.getMessage());

			System.out.println("SQLState: " + sqex.getSQLState());

		}



		// TODO Auto-generated method stub
//		 String url = "jdbc:oracle:thin:@localhost:1521:sid1";
//		 String uid = "hkim";
//		 String upw = "hagojun";
//		 
//		 try {
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//			} catch(Exception e) {
//				e.printStackTrace();
//			}
//		Connection con = null;
//		Statement  stmt = null;
//		ResultSet  rs = null;	
//		
//		try {
//			
//			ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
//			con = DriverManager.getConnection(url, uid, upw);
//			stmt = con.createStatement();
//			rs = stmt.executeQuery("select * from member");
//			
//			while(rs.next()) {
//				String name = rs.getString("name");
//				String id  = rs.getString("id");
//				String pw = rs.getString("pw");
//				String phone1  = rs.getString("phone1");
//				String phone2 = rs.getString("phone2");
//				String phone3  = rs.getString("phone3");
//				String gender  = rs.getString("gender");
//				
//				MemberDTO dto = new MemberDTO();
//				dtos.add(dto);
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(rs != null) rs.close();
//				if(stmt != null) stmt.close();
//				if(con != null) con.close();
//				
//			} catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//		
	}

}
