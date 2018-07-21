<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="mainTwo" />
        <g:set var="entityName" value="${message(code: 'transaction.label', default: 'Transaction')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-transaction" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>

                <li><g:link class="create" action="create"><g:message code="default.transactionsCreate.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="search"><g:message code="default.searchTransaction.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="list-transaction" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${transactionList}" />
        </div>
    </body>
</html>