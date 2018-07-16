package incasation

import grails.gorm.services.Service

@Service(Bank)
interface BankService {

    Bank get(Serializable id)

    List<Bank> list(Map args)

    Long count()

    void delete(Serializable id)

    Bank save(Bank bank)

}