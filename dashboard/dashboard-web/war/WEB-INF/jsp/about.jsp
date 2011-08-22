<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="include/app-header.jsp"/>
<h1>About</h1>
About page infoo


<h3>v.NEXT - effect to HTS</h3>
<ul>	
	<li>HTS update and logic in details view</li>
</ul>

<h3>v.0.06/28 - effect to Mail Template - core</h3>
<ol>	
	<li>Mail template framework added</li>
	<li>Get TEST cases from MIDAS - <a href="getChanged.do"> last changes </a> !!!!!!!!!</li>
</ol>


<h3>v.0.07/06 - effect to GWT - core</h3>
<ol>	
	<li>gwt 2.2.0 -> gwt 2.3.0 - support for IE9</li>
</ol>

<h3>v.0.31/05 - effect to CVP and HTS</h3>
<ol>	
	<li>HTS details view - initial</li>
	<li>my HTSs, with filter (search)</li>
	<li>finally, find by date in Tips View(Admin, Broker, Banker) is working normally</li>
	<li>CVP different style (future/past)</li>
	<li>on the fly editing and save comments for CVP</li>
	<li>on the fly editing and save status for CVP</li>
</ol>

<h3>v.0.26/05 - effect to CVP</h3>
<ol>	
	<li>on the fly editor for comments in CVP - try to click on comments field </li>
	<li>adding CV at Client Visit Planner (button add), support future/past logic, support HTS creation </li>
	<li>adding CV to past (My Estate Details View), we creating new HTS if applicable</li>
	<li>added link into HaveToSell to ClientVisit, so we can tell when and at what visit this client was registered</li>
	<li>HaveToSell rebuilded to support "reminder" logic</li>
</ol>

<h3>v.0.25/05 - effect to CVP</h3>
<ol>
	<li>Broker Home - added new task tab : Uncompleated Visitings</li>
	<li>Norwegian TRL - BaseConstants_no.properties</li>
	<li>Norwegian TRL - messages_no.properties</li>
	<li>Norwegian TRL - dashboardsConstants_no.properties... Lån</li>
</ol>
<hr>
CV  - Client Visit   (ref. to client, ref. to viewing);<br>
CVP - Client Visit Planner 
HTS - Have To Sell  (logging clients, do they have something to sell)<br>
<hr>
known issues:<br>
estate update from MIDAS - estate status is not mapper


<jsp:include page="include/app-footer.jsp" />