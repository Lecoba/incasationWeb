<%@ page import="java.time.format.DateTimeFormatter" %>
<g:set var="localDatePattern" value="${message(code: 'default.localDate.format', default: 'yyyy-MM-dd HH:mm')}"/>

<g:if test="${actionName == "index" || actionName == "searchList"}">
    ${value?.format(DateTimeFormatter.ofPattern(localDatePattern as String, request.getLocale()))}
</g:if>
<g:else>
    <div class="fieldcontain property-list">
        <span id="${this.transaction.transactionDate}-label" class="property-label">${message(code: 'transaction.transactionDate.label')}</span>

        <div class="property-value"
             aria-labelledby="${this.transaction.transactionDate}-label">${this.transaction.transactionDate.format(DateTimeFormatter.ofPattern(localDatePattern as String, request.getLocale()))}</div>
    </div>
</g:else>



