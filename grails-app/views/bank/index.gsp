<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="mainTwo" />
        <g:set var="entityName" value="${message(code: 'bank.label', default: 'Bank')}" />
        <title><g:message code="default.bankԼist.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-bank" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
<sec:ifAllGranted roles='ROLE_ADMIN'>
                <li><g:link class="home" action="create"><g:message code="default.bankCreate.label" args="[entityName]" /></g:link></li>
</sec:ifAllGranted>
            </ul>
        </div>
        <div id="list-bank" class="content scaffold-list" role="main">
            <h1><g:message code="default.bankԼist.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${bankList}" />

            <div class="pagination">
                <g:paginate total="${bankCount ?: 0}" />
            </div>
        </div>
    </body>
</html>