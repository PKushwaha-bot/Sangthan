<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>View Persons</title>
        <link href="/static/css/style.css" rel="stylesheet">
    </head>
    <body>
        <table border="1" align="center">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                      <th>Email</th>
                        <th>Contact NO</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${persons}" var="person">
                    <tr>
                        <td>${person.id}</td>
                        <td>${person.name}</td>
                        <td>${person.email}</td>
                        <td>${person.contact_no}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>