<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="mainTwo" />
        <g:set var="entityName" value="${message(code: 'bank.label', default: 'Bank')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#edit-bank" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>

                <li><g:link class="list" action="index"><g:message code="default.bankԼist.label" args="[entityName]" /></g:link></li>
                <li><g:link class="home" action="create"><g:message code="default.bankCreate.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="edit-bank" class="content scaffold-edit" role="main">
            <h1><g:message code="default.bankEdit.label" args="[entityName]" /></h1>
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
            <g:form resource="${this.bank}" method="PUT">
                <g:hiddenField name="version" value="${this.bank?.version}" />
                <fieldset class="form">
                    <f:with bean="bank">
                        <f:field property="name"/>
                        <f:field property="type">
                            <g:select name="type" from="${["Հաստատգրված", "Պայմանագրային"]}" value="${this.bank?.type}"
                                      noSelection="['': '']"/>
                        </f:field>
                        <f:field property="bankBranches"/>
                    </f:with>
                </fieldset>
                <fieldset class="buttons">
                    <input class="save" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
