<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="include/app-header.jsp" />


<h1><spring:message code="label.login"/></h1>
<c:if test="${not empty param.login_error}">
	<font color="red"> Your login attempt was not successful, try again.<br/>
	<br/>
	Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />. </font>
</c:if>

<form name="f" action="<c:url value='j_spring_security_check'/>"
	method="POST">
<table>
	<tr>
		<td><spring:message code="label.user"/>:</td>
		<td><input type='text' name='j_username' /></td>
	</tr>
	<tr>
		<td><spring:message code="label.password"/>:</td>
		<td><input type='password' name='j_password'></td>
	</tr>
	<!-- tr>
		<td><input type="checkbox" name="_spring_security_remember_me"></td>
		<td>Don't ask for my password for two weeks</td>
	</tr-->

	<tr>
		<td></td>
		<td>
			<input name="reset"  type="reset"  value="<spring:message code="label.reset"/>">
			<input name="submit" type="submit" value="<spring:message code="label.submit"/>">
		</td>
	</tr>
</table>
</form>

<a href="brokerRegistration.do"><spring:message code="registration.label.registration"/></a>

<jsp:include page="include/app-footer.jsp" />
