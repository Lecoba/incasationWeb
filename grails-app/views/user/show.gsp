<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="mainTwo"/>
    <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}"/>
    <title><g:message code="default.userShow.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                           default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>

        <li><g:link class="list" action="index"><g:message code="default.userList.label"
                                                           args="[entityName]"/></g:link></li>
        <sec:ifAllGranted roles='ROLE_ADMIN'>
            <li><g:link class="user" action="create"><g:message code="default.newUser.label"
                                                                args="[entityName]"/></g:link></li>
        </sec:ifAllGranted>
    </ul>
</div>

<div id="show-user" class="content scaffold-show" role="main">
    <h1><g:message code="default.userShow.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <f:display bean="user" order="username, accountExpired, accountLocked, passwordExpired"/>
    <sec:ifAllGranted roles='ROLE_ADMIN'>
        <g:form resource="${this.user}" method="DELETE">
            <fieldset class="buttons">
                <g:link class="edit" action="edit" resource="${this.user}"><g:message code="default.button.edit.label"
                                                                                      default="Edit"/></g:link>
                <input class="delete" type="submit"
                       value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                       onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
            </fieldset>
        </g:form>
    </sec:ifAllGranted>
</div>
</body>
</html>
