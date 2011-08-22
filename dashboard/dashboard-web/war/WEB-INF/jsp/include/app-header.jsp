<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"    uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@page import="com.dmma.base.gwt.shared.AppVersion"%>
<%@page import="com.dmma.dashboard.core.configuration.AppProperties"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>
	 	<c:choose>
		<c:when test='${currentUrl == "admin"}'>
			<spring:message code="label.project.admin"/>
		</c:when>
		<c:when test='${currentUrl == "broker"}'>
			<spring:message code="label.project.broker"/>
		</c:when>
		<c:when test='${currentUrl == "banker"}'>
			<spring:message code="label.project.banker"/>
		</c:when>
		<c:otherwise>
			<spring:message code="label.project.title"/>
		</c:otherwise>
		</c:choose>
	 </title>
	
	
	<link type="text/css" rel="stylesheet" href="css/app.css">
	<link type="text/css" rel="stylesheet" href="css/base.css">
	<meta name="gwt:property" content="locale=<spring:message code="gwt.property.locale"/>">
</head>

<body>
	<table width="100%">
		<tr>
			<td>
<table class="Application-top"  width="100%" >
	<tr>
		<td class="Application-links" width="100%">
			<table width="100%" >
				<tr>
					<td align="left">
					
						<img class="em1Logo" src = "img/em1_logo.png" height="30px">
					
						<table class="tableVithVersion">
							<tr>
<td class="App-version"><b><%=AppVersion.APP_VERSION%></b></td>
<td>
</td>
<td class="App-language">
	<a href="<% if(AppProperties.getUseGwtCodeserv()){%>?<%=AppProperties.gwtCodeserv%>&<%}else{%>?<%}%>lang=en">en</a>
	|
	<a href="<% if(AppProperties.getUseGwtCodeserv()){%>?<%=AppProperties.gwtCodeserv%>&<%}else{%>?<%}%>lang=no">no</a>
	
</td>
							</tr> 
						</table>
						
					</td>
					<td align="right">
						<table>
							<tr>
<sec:authorize ifNotGranted="ROLE_ANONYMOUS">
	<td><spring:message code="label.welcome"/> <b><sec:authentication property="principal.username"/></b></td>
	<td>|</td>				
</sec:authorize>

<sec:authorize ifAnyGranted="ROLE_ADMIN">
	<c:choose>
	<c:when test='${currentUrl == "admin"}'>
		<td><b><spring:message code="label.project.admin"/></b></td>
	</c:when>
	<c:otherwise>
		<td><a href="<c:url value="/admin.do"/><% if(AppProperties.getUseGwtCodeserv()){%>?<%=AppProperties.gwtCodeserv%><%}%>"><spring:message code="label.project.admin"/></a></td>
	</c:otherwise>
	</c:choose>
	<td>|</td>
</sec:authorize>

<sec:authorize ifAnyGranted="ROLE_BANKER">
	<c:choose>
	<c:when test='${currentUrl == "banker"}'>
		<td><b><spring:message code="label.project.banker"/></b></td>
	</c:when>
	<c:otherwise>
		<td><a href="<c:url value="/banker.do"/><% if(AppProperties.getUseGwtCodeserv()){%>?<%=AppProperties.gwtCodeserv%><%}%>"><spring:message code="label.project.banker"/></a></td>
	</c:otherwise>
	</c:choose>
	<td>|</td>
</sec:authorize>
<sec:authorize ifAnyGranted="ROLE_BROKER">
	<c:choose>
	<c:when test='${currentUrl == "broker"}'>
		<td><b><spring:message code="label.project.broker"/></b></td>
	</c:when>
	<c:otherwise>
		<td><a href="<c:url value="/broker.do"/><% if(AppProperties.getUseGwtCodeserv()){%>?<%=AppProperties.gwtCodeserv%><%}%>"><spring:message code="label.project.broker"/></a></td>
	</c:otherwise>
	</c:choose>
	<td>|</td>
</sec:authorize>
<sec:authorize ifNotGranted="ROLE_ANONYMOUS">
	<td><a href="<c:url value="/j_spring_security_logout"/>"><spring:message code="label.logout"/></a></td>
	<td>|</td>
</sec:authorize>

<sec:authorize ifAnyGranted="ROLE_ANONYMOUS">
	<c:choose>
	<c:when test='${currentUrl == "login"}'>
		<td><b><spring:message code="label.login"/></b></td>
	</c:when>
	<c:otherwise>
		<td><a href="<c:url value="/j_spring_security_login"/>"><spring:message code="label.login"/></a></td>
	</c:otherwise>
	</c:choose>
	<td>|</td>
</sec:authorize>

<td> 
	<c:choose>
	<c:when test='${currentUrl == "about"}'>
		<b><spring:message code="label.about"/></b>
	</c:when>
	<c:otherwise>
		<a href="<c:url value="/about.do"/>"><spring:message code="label.about"/></a>
	</c:otherwise>
	</c:choose>
</td>
							</tr> 
						</table>
					</td>
				</tr>
			</table>
	   	</td>
	</tr>
</table>
			</td>
		</tr>					
		<tr>
			<td>
			
				
				