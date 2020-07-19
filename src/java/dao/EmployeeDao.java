package dao;

import bean.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bikram
 */
public class EmployeeDao {
Connection con;
    public EmployeeDao() {
       con=DbConnection.doConnect();
    }

    
    //To insert code.....
    
    public boolean insert(Employee emp_bean) {

    String insert="insert into emp values(null,?,?,?,?)";
        PreparedStatement ps;
    try {
        ps = con.prepareStatement(insert);
        ps.setString(1, emp_bean.getEmp_name());
        ps.setString(2, emp_bean.getEmp_address());
        ps.setDouble(3, emp_bean.getEmp_salary());
        ps.setString(4, emp_bean.getEmp_email());
       int flag= ps.executeUpdate();
       if(flag==1){
           return true;
       }
    } catch (SQLException ex) {
        Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
    }
     
        return false;
    
    }
//To display all details....
    public List<Employee> getAllEmps() {
        List<Employee> empList=new ArrayList();
       String select="select * from emp";
    try {
        Statement st=con.createStatement();
       ResultSet rs= st.executeQuery(select);
       
       while(rs.next()){
           int id=rs.getInt(1);
           String name=rs.getString(2);
           String address =rs.getString(3);
           double sal=rs.getDouble(4);
           String emailDetails=rs.getString(5);
           Employee emp=new Employee(name, address, sal,emailDetails);
           //Employee emp=new Employee(name, address, sal, address,)
           emp.setEmp_id(id);
           
           empList.add(emp);   
       }
       
        
    } catch (SQLException ex) {
        Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
    }
       
    
    return empList;
    }
//To delete particular details....
    public boolean deleteEmp(int idval) {
        
    String delete="delete from emp where emp_id="+idval;
    //if it is only one we can directly give data 
    //else "delete from emp where id=?"
    
    Statement st;
    try {
        st = con.createStatement();
          int count=st.executeUpdate(delete);
          if(count==1){
              return true;
          }
    } catch (SQLException ex) {
        Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
    }
  
    return false;
    }

    public Employee getEmp(int idval) {
    Employee  emp=new Employee();
    String select ="select * from emp where emp_id="+idval;
    Statement st;
    try {
        st = con.createStatement();
        ResultSet rs=st.executeQuery(select);
         if(rs.next()){
             emp.setEmp_id(idval);
             emp.setEmp_name(rs.getString(2));
             emp.setEmp_address(rs.getString(3));
             emp.setEmp_salary(rs.getDouble(4));
             return emp;
         }
    } catch (SQLException ex) {
        Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
    }
 
     return  null;
    }
//To update details....
    public boolean updateEmp(Employee emp_bean) {
        String update="update emp set emp_name=?,emp_address=?,emp_salary=? where emp_id=?";
    try {
        PreparedStatement ps=con.prepareStatement(update);
     
        ps.setString(1, emp_bean.getEmp_name());
        ps.setString(2, emp_bean.getEmp_address());
        ps.setDouble(3, emp_bean.getEmp_salary());
        ps.setInt(4, emp_bean.getEmp_id());
       int count=ps.executeUpdate();
                    
        if(count==1){
            return true;
        }
        
        
    } catch (SQLException ex) {
        Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    return false;
    
    }
    
    
    
}
