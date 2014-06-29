<%@ page import="com.MekDays.MekEvent" %>



<div class="fieldcontain ${hasErrors(bean: mekEventInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="mekEvent.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${mekEventInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: mekEventInstance, field: 'city', 'error')} required">
	<label for="city">
		<g:message code="mekEvent.city.label" default="City" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="city" required="" value="${mekEventInstance?.city}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: mekEventInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="mekEvent.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="description" cols="40" rows="5" maxlength="5000" required="" value="${mekEventInstance?.description}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: mekEventInstance, field: 'organizer', 'error')} required">
	<label for="organizer">
		<g:message code="mekEvent.organizer.label" default="Organizer" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="organizer" name="organizer.id" from="${com.MekDays.MekUser.list()}" optionKey="id" required="" value="${mekEventInstance?.organizer?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: mekEventInstance, field: 'venue', 'error')} required">
	<label for="venue">
		<g:message code="mekEvent.venue.label" default="Venue" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="venue" required="" value="${mekEventInstance?.venue}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: mekEventInstance, field: 'startDate', 'error')} required">
	<label for="startDate">
		<g:message code="mekEvent.startDate.label" default="Start Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="startDate" precision="day"  value="${mekEventInstance?.startDate}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: mekEventInstance, field: 'endDate', 'error')} required">
	<label for="endDate">
		<g:message code="mekEvent.endDate.label" default="End Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="endDate" precision="day"  value="${mekEventInstance?.endDate}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: mekEventInstance, field: 'volunteers', 'error')} ">
	<label for="volunteers">
		<g:message code="mekEvent.volunteers.label" default="Volunteers" />
		
	</label>
	<g:select name="volunteers" from="${com.MekDays.MekUser.list()}" multiple="multiple" optionKey="id" size="5" value="${mekEventInstance?.volunteers*.id}" class="many-to-many"/>

</div>

<div class="fieldcontain ${hasErrors(bean: mekEventInstance, field: 'sponsorships', 'error')} ">
	<label for="sponsorships">
		<g:message code="mekEvent.sponsorships.label" default="Sponsorships" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${mekEventInstance?.sponsorships?}" var="s">
    <li><g:link controller="sponsorship" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="sponsorship" action="create" params="['mekEvent.id': mekEventInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'sponsorship.label', default: 'Sponsorship')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: mekEventInstance, field: 'tasks', 'error')} ">
	<label for="tasks">
		<g:message code="mekEvent.tasks.label" default="Tasks" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${mekEventInstance?.tasks?}" var="t">
    <li><g:link controller="task" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="task" action="create" params="['mekEvent.id': mekEventInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'task.label', default: 'Task')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: mekEventInstance, field: 'messages', 'error')} ">
	<label for="messages">
		<g:message code="mekEvent.messages.label" default="Messages" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${mekEventInstance?.messages?}" var="m">
    <li><g:link controller="mekMessage" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="mekMessage" action="create" params="['mekEvent.id': mekEventInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'mekMessage.label', default: 'MekMessage')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: mekEventInstance, field: 'respondents', 'error')} ">
	<label for="respondents">
		<g:message code="mekEvent.respondents.label" default="Respondents" />
		
	</label>
	

</div>

