package atmPackage;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.concurrent.ExecutionException;

public class OracleDB {
    String strDriver = "oracle.jdbc.driver.OracleDriver"; //JDBC 드라이버 사용
   String strURL = "jdbc:oracle:thin:@192.168.56.1:1521:ORCL"; //Oracle DB ip접근 주소
   String strUser="SYSTEM"; //ORACLE ID
   String strPWD="AB8488454"; //ORACLE PASSWORD

    Connection DB_con; //DB연결된 상태(세션)을 담은 객체
    Statement DB_stmt; //SQL문 실행 할 statement
    ResultSet DB_rs; //쿼리문을 날린것에 대한 반환값을 담을 객체
    
    public void dbOpen() throws IOException{//쿼리 실행 전 DB 연결
        try{
            Class.forName(strDriver); //드라이버 연결
            DB_con = DriverManager.getConnection(strURL, strUser, strPWD);//서버 연결 
            DB_stmt = DB_con.createStatement();
        } catch (Exception e){
            System.err.println("SQLException :" + e.getMessage());
        }
    }
    
    public void dbClose() throws IOException{//쿼리 실행 후 DB 연결 종료
        try{
            DB_stmt.close();
            DB_con.close();
        } catch (Exception e){
            System.err.println("SQLException :" + e.getMessage());
        }
    }
}
