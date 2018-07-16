package incasation

class BankBranch {

    String name

    static belongsTo = [bank: Bank]

    static constraints = {
    }

    String toString() {
        return name
    }
}
