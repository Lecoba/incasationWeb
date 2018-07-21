package incasation

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException

import java.time.LocalDateTime

import static org.springframework.http.HttpStatus.*

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class TransactionController {

    TransactionService transactionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE", searchList: "POST"]

    def index(Integer max) {
        respond transactionService.list(params), model: [transactionCount: transactionService.count()]
    }

    def show(Long id) {
        respond transactionService.get(id)
    }

    def create() {
        respond new Transaction(params)
    }

    def save(Transaction transaction) {
        if (transaction == null) {
            notFound()
            return
        }

        try {
            transactionService.save(transaction)
        } catch (ValidationException e) {
            respond transaction.errors, view: 'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.createdTransaction.message', args: [message(code: 'transaction.label', default: 'Transaction'), transaction.id])
                redirect transaction
            }
            '*' { respond transaction, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond transactionService.get(id)
    }

    def update(Transaction transaction) {
        if (transaction == null) {
            notFound()
            return
        }

        try {
            transactionService.save(transaction)
        } catch (ValidationException e) {
            respond transaction.errors, view: 'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updatedTransaction.message', args: [message(code: 'transaction.label', default: 'Transaction'), transaction.id])
                redirect transaction
            }
            '*' { respond transaction, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        transactionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deletedTransaction.message', args: [message(code: 'transaction.label', default: 'Transaction'), id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    def search() {
        List<Bank> list = Bank.list()
        respond new Transaction(params), model: [banks: list]
    }

    def searchList() {
        String user = String.valueOf(params.user)
        String amount = String.valueOf(params.amount)
        String currency = String.valueOf(params.currency)
        String destinationBank = String.valueOf(params.destinationBank)
        String destinationBankBranch = String.valueOf(params.destinationBankBranch)
        String transactionDateVal = String.valueOf(params.transactionDate)
        LocalDateTime transactionDate = LocalDateTime.parse(transactionDateVal)

        List<Transaction> searchResultList = Transaction.createCriteria().list {
            if (!user.isEmpty()) {
                eq('user', params.user)
            }
            if (!amount.isEmpty()) {
                eq('amount', params.amount)
            }
            if (!currency.isEmpty()) {
                eq('currency', params.currency)
            }
            if (!destinationBank.isEmpty()) {
                eq('destinationBank', params.destinationBank)
            }
            if (!destinationBankBranch.isEmpty()) {
                eq('destinationBankBranch', params.destinationBankBranch)
            }
            if (!transactionDateVal.isEmpty()) {
                eq('transactionDate', transactionDate)
            }
        } as List<Transaction>

        render view: "index", model: [transactionList: searchResultList]
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.foundTransaction.message', args: [message(code: 'transaction.label', default: 'Transaction'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
