<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="mainTwo" />
        <g:set var="entityName" value="${message(code: 'default.bankBranch.label', default: 'BankBranch')}" />
        <title><g:message code="default.bankBranchList.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-bankBranch" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
<sec:ifAllGranted roles='ROLE_ADMIN'>
                <li><g:link class="home" action="create"><g:message code="default.bankBranchCreate.label" args="[entityName]" /></g:link></li>
</sec:ifAllGranted>
            </ul>
        </div>
        <div id="list-bankBranch" class="content scaffold-list" role="main">
            <h1><g:message code="default.bankBranchList.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${bankBranchList}" />

            <div class="pagination">
                <g:paginate total="${bankBranchCount ?: 0}" />
            </div>
        </div>
    </body>
</html>