<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />

    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
</head>
<body>

<div class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <h1 id="tableColor" style="font-size: 30px">ՀԱՅԻՆԿԱՍԱՑԻԱ</h1>
            <div class="navbar-collapse collapse" aria-expanded="false" style="height: 0.8px;">
                <ul class="nav navbar-nav navbar-right">
                    <g:pageProperty name="page.nav" />
                </ul>
            </div>
        </div>

    </div>
</div>

<ul class="uls">
    <li class="lis"><a href="/">Գործարքներ</a></li>
    <li class="lis"><g:link controller="bank" action="index"><g:message code="default.bank.label" /></g:link></li>
    <li class="lis"><g:link controller="bankBranch" action="index"><g:message code="default.bankBranch.label" /></g:link></li>
    <li class="lis"><g:link controller="user" action="index"><g:message code="default.user.label" /></g:link></li>
    <g:link style="text-align: right; float: right; padding: 14px 16px;" controller='logout' action=''><g:message code="springSecurity.logout.button" /></g:link>
</ul>

<g:layoutBody/>

<div class="footer" role="contentinfo"></div>

<div id="spinner" class="spinner" style="display:none;">
    <g:message code="spinner.alt" default="Loading&hellip;"/>
</div>

<asset:javascript src="application.js"/>

</body>
</html>