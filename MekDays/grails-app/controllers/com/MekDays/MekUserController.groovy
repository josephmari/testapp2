package com.MekDays



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MekUserController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond MekUser.list(params), model:[mekUserInstanceCount: MekUser.count()]
    }

    def show(MekUser mekUserInstance) {
        respond mekUserInstance
    }

    def create() {
        respond new MekUser(params)
    }

    @Transactional
    def save(MekUser mekUserInstance) {
        if (mekUserInstance == null) {
            notFound()
            return
        }

        if (mekUserInstance.hasErrors()) {
            respond mekUserInstance.errors, view:'create'
            return
        }

        mekUserInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'mekUser.label', default: 'MekUser'), mekUserInstance.id])
                redirect mekUserInstance
            }
            '*' { respond mekUserInstance, [status: CREATED] }
        }
    }

    def edit(MekUser mekUserInstance) {
        respond mekUserInstance
    }

    @Transactional
    def update(MekUser mekUserInstance) {
        if (mekUserInstance == null) {
            notFound()
            return
        }

        if (mekUserInstance.hasErrors()) {
            respond mekUserInstance.errors, view:'edit'
            return
        }

        mekUserInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'MekUser.label', default: 'MekUser'), mekUserInstance.id])
                redirect mekUserInstance
            }
            '*'{ respond mekUserInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(MekUser mekUserInstance) {

        if (mekUserInstance == null) {
            notFound()
            return
        }

        mekUserInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'MekUser.label', default: 'MekUser'), mekUserInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'mekUser.label', default: 'MekUser'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
