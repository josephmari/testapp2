import com.MekDays.*

class BootStrap {

    def init = { servletContext ->
		new MekUser(fullName: 'Joseph Mari',
						userName: 'jmari',
						password: 'toodles123',
						email: 'josephmari@gmail.com',
						website: 'www.functionalbeer.com',
						bio: ''' Joseph is the bomb.  Bomb da bomb da bomb da bomb.  He likes to doo doo like a bomb''').save()
		
		new MekUser(fullName: 'Jessica Mari',
						userName: 'jmari2',
						password: 'toodles1234',
						email: 'jessicamari@gmail.com',
						website: 'www.functionalbeerbum.com',
						bio: ''' Jessica is the bomb.  Bomb da bomb da bomb da bomb.  She likes to doo doo like a bomb''').save()
		
		def event1 = new MekEvent(name:'Joe Super Event',
									city: 'New York',
									organizer: MekUser.findByFullName('Joseph Mari'),
									venue: 'BAM',
									startDate: new Date('11/21/2013'),
									endDate: new Date('11/22/2013'),
									description: ''' This is going to be the most amazing event in the world.
									There will be lot's of Joes.  There will be even more Joes.  It will be absoultely amazing''').save()
		//if(!event1.save()){
		//	event1.errors.allErrors.each{error ->
		//		println "An error occured with event1: ${error}"
		//		}
		//	}
			
		def event2 = new MekEvent (name:'Jess Super Event',
									city: 'New York',
									organizer: MekUser.findByFullName('Jessica Mari'),
									venue: 'Empellon Taqueria',
									startDate: new Date('12/1/2013'),
									endDate: new Date('12/2/2013'),
									description: ''' This is going to be the most amazing event in the world.
									There will be lot's of Jesses.  There will be even more Jesses.  It will be absolultey amazing''').save()
									
		//if(!event2.save()){
		//	event2.errors.allErrors.each{error ->
		//		println "An error occured with event2: ${error}"
		//		}
		//	}
		
		def g1 = MekEvent.findByName('Joe Super Event')
		g1.addToVolunteers(new MekUser(fullName: 'Brett Lotito',
										userName: 'blotito',
										password: 'boodles123',
										email: 'blotito@gmail.com',
										website: 'www.brett.com',
										bio: 'Brett the designer'))
		g1.addToVolunteers(new MekUser(fullName: 'Bryce Parrott',
										userName: 'bparrott',
										password: 'boodles456',
										email: 'bparrott@gmail.com',
										website: 'www.bryce.com',
										bio: 'Bryce the coder'))
		
		g1.addToRespondents('ben.smith@gmail.com')
		g1.addToRespondents('dad.mom@gmail.com')
		g1.addToRespondents('hucklefine@gmail.com')
		
		g1.save()
		
		def s1 = new Sponsor(name: 'Google',
								website:'http://www.google.com',
								description: 'Owner of the world!').save()
								
		def s2 = new Sponsor(name: 'Netfliz',
								website:'http://www.netfliz.com',
								description: 'Movies for all!').save()
		
		def sp1 = new Sponsorship(event:g1,
									sponsor:s1,
									contributionType:'Other',
									description:'Cool t-shirts').save()		
									
		def sp2 = new Sponsorship(event:g1,
									sponsor:s2,
									contributionType:'Venue',
									description:'Will be paying for BAM').save()						
									
    }
    def destroy = {
    }
}
