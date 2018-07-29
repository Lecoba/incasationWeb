package incasation

class Bank {

    String name
    String type

    static hasMany = [bankBranches: BankBranch]

    static constraints = {
    }

    String toString() {
        return name
    }
}
