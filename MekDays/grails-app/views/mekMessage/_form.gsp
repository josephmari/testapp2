<%@ page import="com.MekDays.MekMessage" %>



<div class="fieldcontain ${hasErrors(bean: mekMessageInstance, field: 'subject', 'error')} required">
	<label for="subject">
		<g:message code="mekMessage.subject.label" default="Subject" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="subject" required="" value="${mekMessageInstance?.subject}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: mekMessageInstance, field: 'content', 'error')} required">
	<label for="content">
		<g:message code="mekMessage.content.label" default="Content" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="content" cols="40" rows="5" maxlength="2000" required="" value="${mekMessageInstance?.content}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: mekMessageInstance, field: 'parent', 'error')} ">
	<label for="parent">
		<g:message code="mekMessage.parent.label" default="Parent" />
		
	</label>
	<g:select id="parent" name="parent.id" from="${com.MekDays.MekMessage.list()}" optionKey="id" value="${mekMessageInstance?.parent?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: mekMessageInstance, field: 'author', 'error')} required">
	<label for="author">
		<g:message code="mekMessage.author.label" default="Author" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="author" name="author.id" from="${com.MekDays.MekUser.list()}" optionKey="id" required="" value="${mekMessageInstance?.author?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: mekMessageInstance, field: 'event', 'error')} required">
	<label for="event">
		<g:message code="mekMessage.event.label" default="Event" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="event" name="event.id" from="${com.MekDays.MekEvent.list()}" optionKey="id" required="" value="${mekMessageInstance?.event?.id}" class="many-to-one"/>

</div>

