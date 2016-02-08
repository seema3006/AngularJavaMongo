<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Persons Manage Page</title>
<style>
table,th,td {
    border: 1px solid black;
}
</style>
</head>
<body>
    <%-- Employee Add/Edit logic --%>
 
 Success/Error Msg here
 
 
    <c:url value="/addPerson" var="addURL"></c:url>
    <c:url value="/editPerson" var="editURL"></c:url>
 
    <%-- Edit Request --%>
     
    <%-- Employees List Logic --%>
        <table>
            <tbody>
                <tr>
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </tbody>
        </table>
   </body>
</html>