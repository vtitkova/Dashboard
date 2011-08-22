<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="include/app-header.jsp"/>
<h1>GetChanged</h1>

<form:form method="POST" modelAttribute="getChangedModel">
	<table>
		<tr>
   			<td>MIDAS OFFICE ID:</td>
   			<td><form:input path="minutes"/></td>
   		</tr>
   		<tr>
   			<td></td>
   			<td><input type="submit" name="Invoke" ></td>
   		</tr>
   		<tr>
   			<td colspan="2">
	   		Warning: request can take several minutes (1 - 5 min.)	
   			</td>
   		</tr>
   	</table>
</form:form>

<c:if test='${listOfInfo != null}'>
<table border="1">
	<tr>
		<th>o_Id</th>	
		<th>o_Name</th>	
		<th>b_Id</th>	
		<th>b_Name</th>	
		<th>b_Email</th>	
		<th>e_Id</th>	
		<th>e_Status</th>	
		<th>e_Address</th>	
	</tr>
<c:forEach items="${listOfInfo}" var="tableObject">
	<tr>
		<td>${tableObject.officeId}</td>	
		<td>${tableObject.officeName}</td>	
		<td>${tableObject.brokerId}</td>	
		<td>${tableObject.brokerDisplayName}</td>	
		<td>${tableObject.brokerEmail}</td>	
		<td>${tableObject.estateMidasId}</td>	
		<td>${tableObject.estateStatus} - ${tableObject.estateStatusString}</td>	
		<td>${tableObject.estateAddress}</td>	
	</tr>
</c:forEach>
</table>
</c:if>


<jsp:include page="include/app-footer.jsp" />