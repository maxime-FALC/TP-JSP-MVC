<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Discount Code</title>
    </head>
    <body>
        
        <h1>Edition des taux de remise :</h1>
        
        
        <br/><br/>
        
        <form method="GET">
            Code : <input type="text" id="name"/><br/>
            Taux : <input type="number" id="rate"/><br/>
            <input type="submit" action="Ajouter" value="Ajouter"/>
        </form>
        
        <br/><br/>
        
        <table border=2>
            <tr> <th>Code</th> <th>Taux</th> <th>Action</th> </tr>
            <c:forEach var="discount" items="${discounts}">
                <tr> 
                    <td>${discount.name}</td> 
                    <td>
                        <form>
                            <input type="number" value="${discount.rate}" 
                                   onchange='this.form.submit()'/>
                        </form>                        
                    </td> 
                    <td>
                        <form>
                            <input type="submit" value="DELETE"/>
                        </form>
                    </td> 
                </tr>
            </c:forEach>
        </table>
        
        
        
        
        
        
        
        
        
        
        <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
        
        <form>
            <select name='state' onchange='this.form.submit()'>
                <c:forEach var="state" items="${states}">
                    <option value='${state}'
                        <c:if test="${state eq selectedState}">
                            selected
                        </c:if>
                    >${state}</option>
                </c:forEach>
            </select>
        <input type='submit'>
    </form>
    <table border=2>
        <tr> <th>Id</th> <th>Name</th> <th>Address</th> </tr>
        <c:forEach var="customer" items="${customers}">
            <tr> <td>${customer.customerId}</td> <td>${customer.name}</td> <td>${customer.addressLine1}</td> </tr>
        </c:forEach>
    </table>
    <hr>
    <a href='${pageContext.request.contextPath}'>Retour au menu</a><br>
</html>
