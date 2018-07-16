package incasation

import grails.gorm.services.Service

@Service(BankBranch)
interface BankBranchService {

    BankBranch get(Serializable id)

    List<BankBranch> list(Map args)

    Long count()

    void delete(Serializable id)

    BankBranch save(BankBranch bankBranch)

}