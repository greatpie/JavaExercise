package visualdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by pie on 2015-6-22.
 */
public class AccessToJson {
    public void ConnectAccessFile() throws Exception
    {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        /**
         * 直接连接access文件。
         */
        String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=d://pie.mdb";
        Connection conn = DriverManager.getConnection(dbur1, "", "");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from 'data' where ID = 1");
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
        rs.close();
        stmt.close();
        conn.close();
    }
    public static void main(String args[]) throws Exception {
        new AccessToJson().ConnectAccessFile();
    }
}
