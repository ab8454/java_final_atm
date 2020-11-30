

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
public class DB_MAN {
    String strDriver = "oracle.jdbc.driver.OracleDriver";
    //String strURL = "jdbc:sqlserver://localhost:1521;DatabaseName=CARINFO";
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
