package incasation

import grails.converters.JSON

import java.time.format.DateTimeFormatter

class BootStrap {

    def init = { servletContext ->

        JSON.registerObjectMarshaller(Bank) {
            def returnArray = [:]
            returnArray['name'] = it.name
            returnArray['bankBranches'] = it.bankBranches
            return returnArray
        }

        JSON.registerObjectMarshaller(BankBranch) {
            def returnArray = [:]
            returnArray['name'] = it.name
            return returnArray
        }

        JSON.registerObjectMarshaller(Transaction) {
            def returnArray = [:]
            returnArray['user'] = it.user
            returnArray['amount'] = it.amount
            returnArray['currency'] = it.currency
            returnArray['destinationBank'] = it.destinationBank
            returnArray['destinationBankBranch'] = it.destinationBankBranch
            returnArray['transactionDate'] = it.transactionDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"))
            return returnArray
        }

        def adminRole = Role.findOrSaveWhere(authority: 'ROLE_ADMIN')
        def userRole = Role.findOrSaveWhere(authority: 'ROLE_USER')

        def admin = User.findOrSaveWhere(username: 'LevonAdmin', password: '939473')
        def user = User.findOrSaveWhere(username: 'Levon', password: '939473')

        if(!admin.getAuthorities().contains(adminRole)){
           UserRole.create(admin, adminRole, true)
        }

        if(!user.getAuthorities().contains(userRole)){
            UserRole.create(user, userRole, true)
        }
    }
    def destroy = {
    }
}
