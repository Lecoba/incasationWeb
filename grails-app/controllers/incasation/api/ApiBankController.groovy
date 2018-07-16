package incasation.api

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import incasation.Bank
import incasation.BankService

@Secured("permitAll")
class ApiBankController {

    BankService bankService

    def list() {
        List<Bank> listOfBanks = bankService.list()
        def bankListJson = listOfBanks as JSON
        render bankListJson, formats: ['json']
    }

}
