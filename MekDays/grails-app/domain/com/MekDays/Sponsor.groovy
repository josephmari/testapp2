package com.MekDays

class Sponsor {
	
	String name
	String website
	String description
	byte[] logo
	
	String toString(){
		name
	}
	
	static hasMany = [sponsorships : Sponsorship]
	
    static constraints = {
		
		name blank: false
		website blank: false, url:true
		description nullable: true, maxSize:5000
		logo nullable: true, maxSize:1000000
		sponsorships nullable:true
    }
}
