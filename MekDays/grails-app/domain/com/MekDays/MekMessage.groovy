package com.MekDays

class MekMessage {
	String subject
	String content
	MekMessage parent
	MekEvent event
	MekUser author

    static constraints = {
		subject blank:false
		content blank:false, maxSize:2000
		parent nullable:true
		author nullable:false
		
		
    }
	
	static belongsTo = MekEvent
}
