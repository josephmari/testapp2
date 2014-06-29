package com.MekDays



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MekMessageController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond MekMessage.list(params), model:[mekMessageInstanceCount: MekMessage.count()]
    }

    def show(MekMessage mekMessageInstance) {
        respond mekMessageInstance
    }

    def create() {
        respond new MekMessage(params)
    }

    @Transactional
    def save(MekMessage mekMessageInstance) {
        if (mekMessageInstance == null) {
            notFound()
            return
        }

        if (mekMessageInstance.hasErrors()) {
            respond mekMessageInstance.errors, view:'create'
            return
        }

        mekMessageInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'mekMessage.label', default: 'MekMessage'), mekMessageInstance.id])
                redirect mekMessageInstance
            }
            '*' { respond mekMessageInstance, [status: CREATED] }
        }
    }

    def edit(MekMessage mekMessageInstance) {
        respond mekMessageInstance
    }

    @Transactional
    def update(MekMessage mekMessageInstance) {
        if (mekMessageInstance == null) {
            notFound()
            return
        }

        if (mekMessageInstance.hasErrors()) {
            respond mekMessageInstance.errors, view:'edit'
            return
        }

        mekMessageInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'MekMessage.label', default: 'MekMessage'), mekMessageInstance.id])
                redirect mekMessageInstance
            }
            '*'{ respond mekMessageInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(MekMessage mekMessageInstance) {

        if (mekMessageInstance == null) {
            notFound()
            return
        }

        mekMessageInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'MekMessage.label', default: 'MekMessage'), mekMessageInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'mekMessage.label', default: 'MekMessage'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
