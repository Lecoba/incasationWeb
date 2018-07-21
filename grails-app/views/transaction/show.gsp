<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="mainTwo"/>
    <g:set var="entityName" value="${message(code: 'transaction.label', default: 'Transaction')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-transaction" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                                  default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><g:link class="search" action="search"><g:message code="default.searchTransaction.label" args="[entityName]" /></g:link></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-transaction" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
<f:display bean="transaction" except="transactionDate"/>
    %{--<f:with bean="transaction">--}%
        %{--<f:display property="transactionDate"/>--}%
        %{--<f:display property="user"/>--}%
        %{--<f:display property="currency"/>--}%
    %{--</f:with>--}%
<f:display bean="transaction" property="transactionDate" widget="localDate"/>
    <g:form resource="${this.transaction}" method="DELETE">
        <fieldset class="buttons">
            <g:link class="edit" action="edit" resource="${this.transaction}"><g:message
                    code="default.button.edit.label" default="Edit"/></g:link>
            <input class="delete" type="submit"
                   value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                   onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
