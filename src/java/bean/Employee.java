package bean;

import java.io.Serializable;

/**
 *
 * @author Bikram
 */
public class Employee implements Serializable{//in java beans
    private int emp_id;
    private String emp_name;
    private String emp_address;
    private double emp_salary;
    private String emp_email;
    

    public Employee() {
    }
    
    

    public Employee(String emp_name, String emp_address, double emp_salary,String emp_email) {
        this.emp_name = emp_name;
        this.emp_address = emp_address;
        this.emp_salary = emp_salary;
        this.emp_email=emp_email;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_address() {
        return emp_address;
    }

    public void setEmp_address(String emp_address) {
        this.emp_address = emp_address;
    }

    public double getEmp_salary() {
        return emp_salary;
    }

    public void setEmp_salary(double emp_salary) {
        this.emp_salary = emp_salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_address=" + emp_address + ", emp_salary=" + emp_salary + ", emp_email=" + emp_email + '}';
    }

    public String getEmp_email() {
        return emp_email;
    }

    public void setEmp_email(String emp_email) {
        this.emp_email = emp_email;
    }
}
   