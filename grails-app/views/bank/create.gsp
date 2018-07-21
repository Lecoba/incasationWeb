<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="mainTwo" />
        <g:set var="entityName" value="${message(code: 'bank.label', default: 'Bank')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#create-bank" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>

                <li><g:link class="list" action="index"><g:message code="default.bankԼist.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>

        <div id="create-bank" class="content scaffold-create" role="main">
            <h1><g:message code="default.bankCreate.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.bank}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.bank}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.bank}" method="POST">
                <fieldset class="form">
                    <f:all bean="bank"/>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>

    </body>
</html>
