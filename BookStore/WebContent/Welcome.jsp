<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>this is login page</title>
</head>
<body>
<center>
        <h1>Books Management</h1>
        <h2>
            <a href="new">Add New Book</a>
            &nbsp;&nbsp;&nbsp;
            <a href="list">List All Books</a>
             
        </h2>
    </center>
                <table border="1" cellpadding="5">
                 <c:forEach var="book" items="${books}">
                
                <tr>
                    <td><c:out value="${book.id}" /></td>
                    <td><c:out value="${book.title}" /></td>
                    <td><c:out value="${book.author}" /></td>
                    <td><c:out value="${book.price}" /></td>
                      <td>
                        <a href="edit?id=<c:out value='${book.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="delete?id=<c:out value='${book.id}' />">Delete</a>                     
                    </td>
                   
                </tr></c:forEach>
                </table>
            
</body>
</html>