<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>View Addresses</title>
        <link href="/static/css/style.css" rel="stylesheet">
    </head>
    <body>
        <table border="1" align="center">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Address</th>
                    <th>District</th>
                    <th>State</th>
                    <th>Pin</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${addresses}" var="address">
                    <tr>
                        <td>${address.id}</td>
                        <td>${address.name}</td>
                         <td>${address.district}</td>
                        <td>${address.state}</td>
                        <td>${address.pin}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>