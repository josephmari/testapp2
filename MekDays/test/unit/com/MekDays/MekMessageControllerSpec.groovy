package com.MekDays



import grails.test.mixin.*
import spock.lang.*

@TestFor(MekMessageController)
@Mock(MekMessage)
class MekMessageControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.mekMessageInstanceList
            model.mekMessageInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.mekMessageInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            def mekMessage = new MekMessage()
            mekMessage.validate()
            controller.save(mekMessage)

        then:"The create view is rendered again with the correct model"
            model.mekMessageInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            mekMessage = new MekMessage(params)

            controller.save(mekMessage)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/mekMessage/show/1'
            controller.flash.message != null
            MekMessage.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def mekMessage = new MekMessage(params)
            controller.show(mekMessage)

        then:"A model is populated containing the domain instance"
            model.mekMessageInstance == mekMessage
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def mekMessage = new MekMessage(params)
            controller.edit(mekMessage)

        then:"A model is populated containing the domain instance"
            model.mekMessageInstance == mekMessage
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/mekMessage/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def mekMessage = new MekMessage()
            mekMessage.validate()
            controller.update(mekMessage)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.mekMessageInstance == mekMessage

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            mekMessage = new MekMessage(params).save(flush: true)
            controller.update(mekMessage)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/mekMessage/show/$mekMessage.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/mekMessage/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def mekMessage = new MekMessage(params).save(flush: true)

        then:"It exists"
            MekMessage.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(mekMessage)

        then:"The instance is deleted"
            MekMessage.count() == 0
            response.redirectedUrl == '/mekMessage/index'
            flash.message != null
    }
}
