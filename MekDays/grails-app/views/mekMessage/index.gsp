
<%@ page import="com.MekDays.MekMessage" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'mekMessage.label', default: 'MekMessage')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-mekMessage" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-mekMessage" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="subject" title="${message(code: 'mekMessage.subject.label', default: 'Subject')}" />
					
						<g:sortableColumn property="content" title="${message(code: 'mekMessage.content.label', default: 'Content')}" />
					
						<th><g:message code="mekMessage.parent.label" default="Parent" /></th>
					
						<th><g:message code="mekMessage.author.label" default="Author" /></th>
					
						<th><g:message code="mekMessage.event.label" default="Event" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${mekMessageInstanceList}" status="i" var="mekMessageInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${mekMessageInstance.id}">${fieldValue(bean: mekMessageInstance, field: "subject")}</g:link></td>
					
						<td>${fieldValue(bean: mekMessageInstance, field: "content")}</td>
					
						<td>${fieldValue(bean: mekMessageInstance, field: "parent")}</td>
					
						<td>${fieldValue(bean: mekMessageInstance, field: "author")}</td>
					
						<td>${fieldValue(bean: mekMessageInstance, field: "event")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${mekMessageInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
