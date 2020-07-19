/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bo;

import bean.Employee;
import dao.EmployeeDao;
import java.util.List;

/**
 *
 * @author Bikram
 */
public class EmployeeBo {

    EmployeeDao emo_dao=new EmployeeDao();
    public boolean insert(Employee emp_bean) {
    return emo_dao.insert(emp_bean);
    
    }

    public List<Employee> getAllEmps() {

    return  emo_dao.getAllEmps();
    }

    public boolean deleteEmp(int idval) {
       return emo_dao.deleteEmp(idval);
    
    }

    public Employee getEmp(int idval) {
    return emo_dao.getEmp(idval);
    
    }

    public boolean updateEmp(Employee emp_bean) {

    return emo_dao. updateEmp(emp_bean);
    
    }
    
}
