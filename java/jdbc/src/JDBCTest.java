import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest {

	public static void selectTest() {
		//1.JDBC드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//2. DB연결
		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB와 연결 성공");
			
			//3. SQL문 송신
			String selectSQL = "SELECT employee_id, first_name, salary, hire_date FROM employees";
			stmt = con.createStatement();
			//4. 결과 수신
			rs = stmt.executeQuery(selectSQL);
			while(rs.next()){//while(rs.next() == true)커서를 움직일 위치에 행이 있으면 true를 반환한고 더이상 반환 할 행이 없으면 false반환
				int emp_id = rs.getInt("employee_id");
				String f_name = rs.getString("first_name");
				int sal = rs.getInt(3);//컬럼의 위치만 적어도 가능하다.
				Date hireDt = rs.getDate("hire_date");
				System.out.println(emp_id + ":" + f_name + ":" + sal + ":" + hireDt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//5. DB 닫기
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}		
	}
	
	public static void dmlTest() {
		//1.JDBC드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//2. DB연결
		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		Statement stmt = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			Scanner sc = new Scanner(System.in);
			System.out.print("고객 ID : ");
			String id = sc.nextLine();
			System.out.print("고객 비밀번호 : ");
			String pwd = sc.nextLine();
			
			stmt = con.createStatement();
			//INSERT INTO customer(id, pwd) VALUES('id0', 'p0')
			String insertSQL = "INSERT INTO customer(id, pwd) VALUES('" + id + "', '" + pwd + "')";
			stmt.executeUpdate(insertSQL);//executeQuery를 사용하면 셀렉트 구문을 사용하고 executeUpdate를 사용하면 그밖의 dmlddl을 사용할 수 있다.
			//dml구문을 자동 종료하게 되면 commit이 자동으로 됩니다.
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//5. DB 닫기
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void dmlPreparedStatementTest() {
		//1.JDBC드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//2. DB연결
		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		//Statement stmt = null;
		PreparedStatement pstmt = null;//송신
		try {
			con = DriverManager.getConnection(url, user, password);
			
			Scanner sc = new Scanner(System.in);
			System.out.print("고객 ID : ");
			String id = sc.nextLine();
			System.out.print("고객 비밀번호 : ");
			String pwd = sc.nextLine();
			
			//stmt = con.createStatement();
			//INSERT INTO customer(id, pwd) VALUES('id0', 'p0')
			//String insertSQL = "INSERT INTO customer(id, pwd) VALUES('" + id + "', '" + pwd + "')";
			//stmt.executeUpdate(insertSQL);//executeQuery를 사용하면 셀렉트 구문을 사용하고 executeUpdate를 사용하면 그밖의 dmlddl을 사용할 수 있다.
			//dml구문을 자동 종료하게 되면 commit이 자동으로 됩니다.
			
			String insertSQL = "INSERT INTO customer(id, pwd) VALUES(?,?)";//?는 바인드변수
			pstmt = con.prepareStatement(insertSQL);//SQL구문을 미리준비
			pstmt.setString(1, id);//1번 바인드변수는 id값으로 설정
			pstmt.setString(2, pwd);//2번 바인드변수 pwd값으로 설정
			pstmt.executeUpdate();
			//sql 문법의 위치에 바인드 변수 사용 불가능! ex) select, DESC, ASC등등 -> 여긴 Statement가 더 좋다.
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//5. DB 닫기
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}		
	}
	
	public static void main(String[] args) {
		//selectTest();
		//dmlTest();
		dmlPreparedStatementTest();
	}

}
