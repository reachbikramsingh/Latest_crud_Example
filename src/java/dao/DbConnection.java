
package dao;


import java.sql.Connection;//import proper interface
import java.sql.DriverManager;

public class DbConnection {
  static Connection con=null;
 public static Connection  doConnect(){
      try{
          
      Class.forName("com.mysql.jdbc.Driver");
       con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_details_app", "root", "welcome");
        System.out.println("Connection ready");
    }catch(Exception ex){
        ex.printStackTrace();
    }
      return con;
}
//    public static void main(String[] args) {
//        doConnect();
//    }
}
