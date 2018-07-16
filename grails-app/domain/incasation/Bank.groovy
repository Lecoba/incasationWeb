package incasation

class Bank {

    String name

    static hasMany = [bankBranches: BankBranch]

    static constraints = {
    }

    String toString() {
        return name
    }
}
