<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="include/app-header.jsp"/>

<c:if test='${brokerFromMidas != null}'>
<h1><spring:message code="registration.conf.confirmation"/></h1>
<table class="registrationConfirmation">
	<tr>
	<th><spring:message code="registration.conf.broker"/></th><th><spring:message code="registration.conf.office"/></th>
	</tr>
	<tr>
	<td>
		<dl>
			<dt>Midas Id</dt>
			<dd>${brokerFromMidas.midasId}</dd>
			<dt><spring:message code="label.name"/></dt>
			<dd>${brokerFromMidas.name}</dd>
			<dt><spring:message code="label.surname"/></dt>
			<dd>${brokerFromMidas.surname}</dd>
			<dt><spring:message code="label.email"/></dt>
			<dd>${brokerFromMidas.email}</dd>
			<dt><spring:message code="label.phone"/></dt>
			<dd>${brokerFromMidas.phone}</dd>
			<dt><spring:message code="label.cellphone"/></dt>
			<dd>${brokerFromMidas.cellPhone}</dd>
		</dl>
	</td>
	<td>
		<dl>
			<dt>Midas Id</dt>
			<dd>${brokerFromMidas.brokerOffice.midasId}</dd>
			<dt><spring:message code="label.name"/></dt>
			<dd>${brokerFromMidas.brokerOffice.name}</dd>
			<dt><spring:message code="label.address"/></dt>
			<dd>${brokerFromMidas.brokerOffice.address}</dd>
			<dt><spring:message code="label.zip"/></dt>
			<dd>${brokerFromMidas.brokerOffice.zip}</dd>
			<dt><spring:message code="label.city"/></dt>
			<dd>${brokerFromMidas.brokerOffice.city}</dd>
			<dt><spring:message code="label.phone"/></dt>
			<dd>${brokerFromMidas.brokerOffice.phone}</dd>
			<dt><spring:message code="label.email"/></dt>
			<dd>${brokerFromMidas.brokerOffice.email}</dd>
		</dl>
	</td>
	</tr>
</table> 
<form:form method="POST" modelAttribute="brokerFromMidas" action="brokerRegistration/brokerRegistrationConfirm.do">
	<input type="submit" name="Confirm"  value="<spring:message code='registration.conf.process'/>">
</form:form>
</c:if>


<c:if test='${brokerFromMidas == null}'>
<h1><spring:message code="registration.label.registration"/></h1>
	<form:form method="POST" modelAttribute="registrationModel">
		<table>
			<tr>
   				<td>MIDAS OFFICE ID:</td>
   				<td><form:input path="midasofficeid"/></td>
   				<td><form:errors path="midasofficeid" cssClass="formEerror"/></td>
   			</tr>
   			<tr>
   				<td>MIDAS BROKER ID:</td>
   				<td><form:input path="midasbrokerid"/></td>
   				<td><form:errors path="midasbrokerid" cssClass="formEerror"/></td>
   			</tr>	
   			<tr>
   				<td><spring:message code="label.email"/>:</td>
   				<td><form:input path="email"/></td>
   				<td><form:errors path="email" cssClass="formEerror"/></td>
   			</tr>	
   			<tr>
   				<td><spring:message code="registration.label.password"/>:</td>
   				<td><form:password path="password1"/></td>
   				<td><form:errors path="password1" cssClass="formEerror" /></td>
   			</tr>	
   			<tr>
   				<td><spring:message code="registration.label.reppassword"/>:</td>
   				<td><form:password path="password2"/></td>
   				<td><form:errors path="password2" cssClass="formEerror" /></td>
   			</tr>
   			<tr>
   				<td><img src="<c:url value='jcaptcha.jpg'/>" /></td>
   				<td><form:input path="jcaptcha"/></td>
   				<td><form:errors path="jcaptcha" cssClass="formEerror" /></td>
   			</tr>	
   			<tr>
   				<td></td>
   				<td><input type="submit" name="Register"  value="<spring:message code="registration.label.save"/>"></td>
   			</tr>	
   		</table>
   		</form:form>
   		</c:if>		
   		
<jsp:include page="include/app-footer.jsp"/>	
