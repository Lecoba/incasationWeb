package incasation

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class BankBranchServiceSpec extends Specification {

    BankBranchService bankBranchService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new BankBranch(...).save(flush: true, failOnError: true)
        //new BankBranch(...).save(flush: true, failOnError: true)
        //BankBranch bankBranch = new BankBranch(...).save(flush: true, failOnError: true)
        //new BankBranch(...).save(flush: true, failOnError: true)
        //new BankBranch(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //bankBranch.id
    }

    void "test get"() {
        setupData()

        expect:
        bankBranchService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<BankBranch> bankBranchList = bankBranchService.list(max: 2, offset: 2)

        then:
        bankBranchList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        bankBranchService.count() == 5
    }

    void "test delete"() {
        Long bankBranchId = setupData()

        expect:
        bankBranchService.count() == 5

        when:
        bankBranchService.delete(bankBranchId)
        sessionFactory.currentSession.flush()

        then:
        bankBranchService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        BankBranch bankBranch = new BankBranch()
        bankBranchService.save(bankBranch)

        then:
        bankBranch.id != null
    }
}
