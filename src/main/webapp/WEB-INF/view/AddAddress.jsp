<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add Book</title>
    </head>
    <body>
        <c:if test="${addAddressSuccess}">
            <div>Successfully added Address with Id: ${address.id}</div>
        </c:if>
    
        <c:url var="addPerson" value="/sangthan/Address/Add"/>
        <form:form action="${addPerson}" method="post" modelAttribute="address">
            <form:label path="name">Name: </form:label> <form:input type="text" path="name"/>
            <br/>
            <form:label path="district">District: </form:label> <form:input type="text" path="district"/>
            <br/>
            <form:label path="state">State: </form:label> <form:input path="state"/>
            <br/>
            <form:label path="pin">Pin: </form:label> <form:input path="pin"/>
            <br/>
            <input type="submit" value="submit"/>
        </form:form>
    </body>
</html>