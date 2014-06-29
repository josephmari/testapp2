package com.MekDays

class Task {

	String title
	String notes
	MekUser assignedTo
	Date dueDate
	MekEvent event
	
    static constraints = {
		title blank:false
		notes blank:true, nullable:true, maxSize:5000
		assignedTo nullable:true
		dueDate nullable:true
    }
	
	static belongsTo = MekEvent
}
