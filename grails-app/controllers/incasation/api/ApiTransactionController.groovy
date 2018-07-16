package incasation.api

import grails.converters.JSON
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import groovy.json.JsonSlurper
import incasation.Transaction
import incasation.TransactionService
import incasation.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager

import java.time.LocalDateTime

@Secured("permitAll")
class ApiTransactionController {

    TransactionService transactionService
    SpringSecurityService springSecurityService
    UserDetailsService userDetailsService = getUserDetailsManager()
    BCryptPasswordEncoder bCryptPasswordEncoder = getEncoder()

    def auth() {
        boolean isValidUserPass = false
        if (params) {
            String userName = params.get('login').toString()
            String userPass = params.get('pass').toString()
            User user = User.findByUsername(userName)
            if (user) {
                def userDetails = getUserDetailsService().loadUserByUsername(userName)
                def encodedPass = userDetails.getPassword()
                isValidUserPass = isValidUser(userDetails) && isValidPassword(userPass, encodedPass)
            }


        }

        def auth = (['auth': isValidUserPass]) as JSON
        render auth, formats: ['json']
    }

    def save() {
        String loggedUserName = request.getHeader("Username")
        def userDetails = getUserDetailsService().loadUserByUsername(loggedUserName)
        def json = request.JSON
        if (userDetails.isAccountNonExpired()) {
            if (json) {
                def jsonObj = new JsonSlurper().parseText(json.toString())
                Transaction transaction = new Transaction(jsonObj)
                transaction.transactionDate = LocalDateTime.now()
                transactionService.save(transaction)
            }
        } else {
            render("Account is Expired")
        }
    }

    def list() {
        String loggedUserName = request.getHeader("Username")
        def userDetails = getUserDetailsService().loadUserByUsername(loggedUserName)
        if (userDetails.isAccountNonExpired()) {
            List<Transaction> transactions = Transaction.createCriteria().list(max: 2, sort: "id", order: "desc") {
                eq('user', loggedUserName)
            } as List
            def transactionListJson = transactions as JSON
            render transactionListJson, formats: ['json']
        } else {
            render("Account is Expired")
        }
    }

    BCryptPasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder()
    }

    UserDetailsService getUserDetailsManager() {
        return new InMemoryUserDetailsManager()
    }

    Boolean isValidUser(def userDetails) {
        return userDetails.isAccountNonExpired() && userDetails.isAccountNonLocked() && userDetails.isCredentialsNonExpired() && userDetails.isEnabled()
    }

    Boolean isValidPassword(String userPass, String encodedPass) {
        return getbCryptPasswordEncoder().matches(userPass, encodedPass)
    }

}
