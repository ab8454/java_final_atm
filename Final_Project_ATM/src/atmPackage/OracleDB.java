package atmPackage;

import java.sql.*;
import java.io.*;
import java.util.*;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.concurrent.ExecutionException;
/**
 *
 * @author ab845
 */
public class OracleDB {
    String strDriver = "oracle.jdbc.driver.OracleDriver";

   //    String strURL = "jdbc:oracle:thin:@10.70.41.111:1521:xe";
  //         String strUser = "INHATC";
   // String strPWD = "inha1958";
    
    String strURL = "jdbc:oracle:thin:@localhost:1521:ORCL";
   String strUser="SYSTEM";
   String strPWD="AB8488454";

    
    Connection DB_con;
    Statement DB_stmt;
    ResultSet DB_rs;
    
    public void dbOpen() throws IOException{
        try{
            Class.forName(strDriver);
            DB_con = DriverManager.getConnection(strURL, strUser, strPWD); //2단계
            DB_stmt = DB_con.createStatement();
        } catch (Exception e){
            System.err.println("SQLException :" + e.getMessage());
        }
    }
    
    public void dbClose() throws IOException{
        try{
            DB_stmt.close();
            DB_con.close();
        } catch (Exception e){
            System.err.println("SQLException :" + e.getMessage());
        }
    }
}
