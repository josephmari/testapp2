<%@ page import="com.MekDays.MekUser" %>



<div class="fieldcontain ${hasErrors(bean: mekUserInstance, field: 'fullName', 'error')} required">
	<label for="fullName">
		<g:message code="mekUser.fullName.label" default="Full Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="fullName" required="" value="${mekUserInstance?.fullName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: mekUserInstance, field: 'userName', 'error')} required">
	<label for="userName">
		<g:message code="mekUser.userName.label" default="User Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="userName" required="" value="${mekUserInstance?.userName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: mekUserInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="mekUser.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="email" required="" value="${mekUserInstance?.email}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: mekUserInstance, field: 'website', 'error')} required">
	<label for="website">
		<g:message code="mekUser.website.label" default="Website" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="website" required="" value="${mekUserInstance?.website}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: mekUserInstance, field: 'bio', 'error')} required">
	<label for="bio">
		<g:message code="mekUser.bio.label" default="Bio" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="bio" cols="40" rows="5" maxlength="5000" required="" value="${mekUserInstance?.bio}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: mekUserInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="mekUser.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="password" required="" value="${mekUserInstance?.password}"/>

</div>

