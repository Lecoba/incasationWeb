<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="mainTwo"/>
    <g:set var="entityName" value="${message(code: 'transaction.label', default: 'Transaction')}"/>
    <title><g:message code="default.search.label" args="[entityName]"/></title>
</head>

<body>
<a href="#create-transaction" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                                    default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>

        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="create-transaction" class="content scaffold-create" role="main">
    <h1><g:message code="default.search.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${this.transaction}">
        <ul class="errors" role="alert">
            <g:eachError bean="${this.transaction}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
                        error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form resource="${this.transaction}" action="searchList" method="GET">
        <fieldset class="form">
            %{--<f:all bean="transaction" required="false"/>--}%
            <f:with bean="transaction" required="false">
                <f:field property="user"/>
                <f:field property="amount"/>
                <f:field property="currency"/>
                <f:field property="destinationBank"/>
                <f:field property="destinationBankBranch"/>
            </f:with>

            <f:field property="bankType" value="${value}"
                     label="Կազմակերպության տեսակ"
                     required="false">
                <g:select name="bankType" from="${["Հաստատագրված", "Պայմանագրային"]}" value="${value}"
                          noSelection="['': '']"/>
            </f:field>

            <f:field bean="transaction" property="transactionDate" value="${this.transaction.transactionDate}"
                     label="Գործարքի ամսաթիվ սկսած"
                     required="false">
                <g:datePicker name="transactionDateAfter" default="none" noSelection="['': '']"
                              precision="day" years="${2018..2050}"/>
            </f:field>

            <f:field bean="transaction" property="transactionDate" value="${this.transaction.transactionDate}"
                     label="Գործարքի ամսաթիվ մինչև"
                     required="false">
                <g:datePicker name="transactionDateBefore" default="none" noSelection="['': '']"
                              precision="day" years="${2018..2050}"/>
            </f:field>

        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="search" class="searchList"
                            value="${message(code: 'default.button.search.label', default: 'Search')}"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
