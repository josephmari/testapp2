package com.MekDays

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(MekEvent)
class MekEventSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test toString"() {
		when: "a mekEvent has a name and a city"
		def mekEvent = new MekEvent(name:'Event One', 
									city: 'New York', 
									organizer: [fullName: 'John Doe'] as MekUser)
		
		then: "the toString method will combine them."
		mekEvent.toString() == 'Event One,New York'
		
    }
}
