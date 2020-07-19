
package web;

import bean.Employee;
import bo.EmployeeBo;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EmployeeServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
     //action read
     String action=request.getParameter("action");
     String next=null;
      EmployeeBo emp_bo=new EmployeeBo();
      if(action.equalsIgnoreCase("insert")){
          //action = insert than this code works
       String emp_name=request.getParameter("emp_name");
       String emp_add=request.getParameter("emp_add");   
       String emp_sal=request.getParameter("emp_sal"); 
       String emp_email=request.getParameter("emp_email");
       //String emp_dept=request.getParameter("emp_dept");
       double esal=Double.parseDouble(emp_sal);
          Employee emp_bean=new Employee(emp_name, emp_add, esal,emp_email);
          //instead of passing in set metthods we can pass all parameters at a time
         
         boolean status= emp_bo.insert(emp_bean);
         if(status){
             next="successPage.jsp";
         }
          else
         {
             next="error.jsp";
         }   
      }
      //To display 
      if(action.equals("display")){
          List<Employee> list=emp_bo.getAllEmps();
          
          request.setAttribute("list",list);
          next="displayPage.jsp";
      }
      else
          if(action.equals("delete")){
              String id=request.getParameter("id");
              int idval=Integer.parseInt(id);
              boolean status= emp_bo.deleteEmp(idval);
              if(status){
                List<Employee> list=emp_bo.getAllEmps();
                request.setAttribute("list",list);
                next="displayPage.jsp";
              }
              else
                  next="error.jsp";
            }
          else if(action.equals("editData")){
              String id=request.getParameter("id");
              int idval=Integer.parseInt(id);  
             Employee emp= emp_bo.getEmp(idval);
             
             request.setAttribute("empdata", emp);
             next="editData.jsp";
              }
            else if(action.equals("update")){
                 
                    String id=request.getParameter("id");
                    int idval=Integer.parseInt(id);      
                    String emp_name=request.getParameter("name");
                    String emp_add=request.getParameter("address");   
                    String emp_sal=request.getParameter("sal"); 
         
                    double esal=Double.parseDouble(emp_sal.trim());
                    Employee emp_bean=new Employee(emp_name, emp_add, esal,emp_sal); 
                    emp_bean.setEmp_id(idval);
                   boolean status= emp_bo.updateEmp(emp_bean);
                                   
                   if(status){
                List<Employee> list=emp_bo.getAllEmps();
                request.setAttribute("list",list);
                next="displayPage.jsp";
              }
              else
                  next="error.jsp";    
                  }
       
    RequestDispatcher rd=  request.getRequestDispatcher(next);
    rd.forward(request, response);
 
       
              
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
   