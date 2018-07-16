package incasation

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class BankServiceSpec extends Specification {

    BankService bankService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Bank(...).save(flush: true, failOnError: true)
        //new Bank(...).save(flush: true, failOnError: true)
        //Bank bank = new Bank(...).save(flush: true, failOnError: true)
        //new Bank(...).save(flush: true, failOnError: true)
        //new Bank(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //bank.id
    }

    void "test get"() {
        setupData()

        expect:
        bankService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Bank> bankList = bankService.list(max: 2, offset: 2)

        then:
        bankList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        bankService.count() == 5
    }

    void "test delete"() {
        Long bankId = setupData()

        expect:
        bankService.count() == 5

        when:
        bankService.delete(bankId)
        sessionFactory.currentSession.flush()

        then:
        bankService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Bank bank = new Bank()
        bankService.save(bank)

        then:
        bank.id != null
    }
}
