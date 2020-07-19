<%-- 
    Document   : displayPage
    Created on : Dec 11, 2015, 9:17:44 AM
    Author     : Bikram
--%>

<%@page import="java.util.List"%>
<%@page import="bean.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display</title>
    </head>
    <body>
        <center>
            <h1>Your Details Are Given Below.......</h1>
        <%
        List<Employee> emplist= (List<Employee>)request.getAttribute("list");
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Salary</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                for(Employee emp:emplist){
                %>
                <tr>
                    <td><%=emp.getEmp_name() %></td>
                    <td><%=emp.getEmp_address() %></td>
                    <td><%=emp.getEmp_salary() %></td>
                    <td><a href="EmployeeServlet?action=delete&id=<%=emp.getEmp_id() %>"><img src="image/images.jpg"/></a></td>

                    <td><a href="EmployeeServlet?action=editData&id=<%=emp.getEmp_id() %>">Edit</a></td>
                </tr>
                <%}%>
            </tbody>
            
        </table>
        </center>
    </body>
</html>
