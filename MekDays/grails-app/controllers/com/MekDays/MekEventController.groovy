package com.MekDays



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MekEventController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond MekEvent.list(params), model:[mekEventInstanceCount: MekEvent.count()]
    }

    def show(MekEvent mekEventInstance) {
        respond mekEventInstance
    }

    def create() {
        respond new MekEvent(params)
    }

    @Transactional
    def save(MekEvent mekEventInstance) {
        if (mekEventInstance == null) {
            notFound()
            return
        }

        if (mekEventInstance.hasErrors()) {
            respond mekEventInstance.errors, view:'create'
            return
        }

        mekEventInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'mekEvent.label', default: 'MekEvent'), mekEventInstance.id])
                redirect mekEventInstance
            }
            '*' { respond mekEventInstance, [status: CREATED] }
        }
    }

    def edit(MekEvent mekEventInstance) {
        respond mekEventInstance
    }

    @Transactional
    def update(MekEvent mekEventInstance) {
        if (mekEventInstance == null) {
            notFound()
            return
        }

        if (mekEventInstance.hasErrors()) {
            respond mekEventInstance.errors, view:'edit'
            return
        }

        mekEventInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'MekEvent.label', default: 'MekEvent'), mekEventInstance.id])
                redirect mekEventInstance
            }
            '*'{ respond mekEventInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(MekEvent mekEventInstance) {

        if (mekEventInstance == null) {
            notFound()
            return
        }

        mekEventInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'MekEvent.label', default: 'MekEvent'), mekEventInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'mekEvent.label', default: 'MekEvent'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
