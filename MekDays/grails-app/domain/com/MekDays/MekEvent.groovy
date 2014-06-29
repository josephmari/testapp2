package com.MekDays

class MekEvent {
	
	String city
	String name
	MekUser organizer
	String venue
	Date startDate
	Date endDate
	String description
	
	static hasMany = [volunteers : MekUser, respondents : String, sponsorships: Sponsorship, tasks: Task, messages: MekMessage]
	
	String toString(){
		"$name,$city"
	}
	
    static constraints = {
		name()
		city()
		description maxSize: 5000
		organizer()
		venue()
		startDate()
		endDate()
		volunteers nullable: true
		sponsorships nullable: true
		tasks nullable:true
		messages nullable:true
    }
}
