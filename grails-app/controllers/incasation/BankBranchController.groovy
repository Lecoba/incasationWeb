package incasation

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

@Secured(['ROLE_ADMIN'])
class BankBranchController {

    BankBranchService bankBranchService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond bankBranchService.list(params), model:[bankBranchCount: bankBranchService.count()]
    }

    def show(Long id) {
        respond bankBranchService.get(id)
    }

    def create() {
        respond new BankBranch(params)
    }

    def save(BankBranch bankBranch) {
        if (bankBranch == null) {
            notFound()
            return
        }

        try {
            bankBranchService.save(bankBranch)
        } catch (ValidationException e) {
            respond bankBranch.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'bankBranch.label', default: 'BankBranch'), bankBranch.id])
                redirect bankBranch
            }
            '*' { respond bankBranch, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond bankBranchService.get(id)
    }

    def update(BankBranch bankBranch) {
        if (bankBranch == null) {
            notFound()
            return
        }

        try {
            bankBranchService.save(bankBranch)
        } catch (ValidationException e) {
            respond bankBranch.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'bankBranch.label', default: 'BankBranch'), bankBranch.id])
                redirect bankBranch
            }
            '*'{ respond bankBranch, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        bankBranchService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'bankBranch.label', default: 'BankBranch'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'bankBranch.label', default: 'BankBranch'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
