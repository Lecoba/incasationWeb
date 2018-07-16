package incasation

import java.time.LocalDateTime

class Transaction {

    String user
    String amount
    String currency
    String destinationBank
    String destinationBankBranch
    LocalDateTime transactionDate

    static constraints = {
        user(nullable: false)
        amount(nullable: false)
        currency(nullable: false)
        destinationBank(nullable: false)
        destinationBankBranch(nullable: false)
        transactionDate(nullable: false)
    }
}
