<%-- 
    Document   : editData
    Created on : Dec 11, 2015, 6:05:12 PM
    Author     : Bikram 
--%>

<%@page import="bean.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <center>
        
    <body></br>
        <h1>Enter your new Details.....</h1>
       <% 
       Employee emp= (Employee)request.getAttribute("empdata");
       %>
       
       <form action="EmployeeServlet?action=update&id=<%=emp.getEmp_id()%>" method="post">
       <table >
        
           <tbody>
               <tr>
                   <td>Enter Name:</td>
                   <td><input type="text" name="name" value="<%=emp.getEmp_name()%>" /></td>
               </tr>
               <tr>
                   <td>Enter Address:</td>
                   <td><input type="text" name="address" value="<%=emp.getEmp_address()%>" /></td>
               </tr>
               <tr>
                   <td>Enter Salary:</td>
                   <td><input type="text" name="sal" value="<%=emp.getEmp_salary()%>" /></td>
               </tr>
                  <tr>
                   <td></td>
                   <td><input type="submit"  value="Update" /></td>
                   
               </tr>
           </tbody>
       </table>

       </form>
    </body>
    </center>
               
</html>
