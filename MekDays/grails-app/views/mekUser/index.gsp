
<%@ page import="com.MekDays.MekUser" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'mekUser.label', default: 'MekUser')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-mekUser" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-mekUser" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="fullName" title="${message(code: 'mekUser.fullName.label', default: 'Full Name')}" />
					
						<g:sortableColumn property="userName" title="${message(code: 'mekUser.userName.label', default: 'User Name')}" />
					
						<g:sortableColumn property="email" title="${message(code: 'mekUser.email.label', default: 'Email')}" />
					
						<g:sortableColumn property="website" title="${message(code: 'mekUser.website.label', default: 'Website')}" />
					
						<g:sortableColumn property="bio" title="${message(code: 'mekUser.bio.label', default: 'Bio')}" />
					
						<g:sortableColumn property="password" title="${message(code: 'mekUser.password.label', default: 'Password')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${mekUserInstanceList}" status="i" var="mekUserInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${mekUserInstance.id}">${fieldValue(bean: mekUserInstance, field: "fullName")}</g:link></td>
					
						<td>${fieldValue(bean: mekUserInstance, field: "userName")}</td>
					
						<td>${fieldValue(bean: mekUserInstance, field: "email")}</td>
					
						<td>${fieldValue(bean: mekUserInstance, field: "website")}</td>
					
						<td>${fieldValue(bean: mekUserInstance, field: "bio")}</td>
					
						<td>${fieldValue(bean: mekUserInstance, field: "password")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${mekUserInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
