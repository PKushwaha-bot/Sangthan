<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add Book</title>
    </head>
    <body>
        <c:if test="${addPersonSuccess}">
            <div>Successfully added Book with ISBN: ${person.id}</div>
        </c:if>
    
        <c:url var="addPerson" value="/sangthan/addPerson"/>
        <form:form action="${addPerson}" method="post" modelAttribute="person">
            <form:label path="name">Name: </form:label> <form:input type="text" path="name"/>
            <br/>
            <form:label path="address.id">Address: </form:label> <form:input type="text" path="address.id"/>
            <br/>
            <form:label path="designation.id">Designation: </form:label> <form:input path="designation.id"/>
            <br/>
            <form:label path="shakha.id">shakha: </form:label> <form:input path="shakha.id"/>
            <br/>
            <input type="submit" value="submit"/>
        </form:form>
    </body>
</html>