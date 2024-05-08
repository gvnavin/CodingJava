package companies.atm_question.atm

import companies.atm_question.bank.Bank

class ATMMachine(val atmMachineInfo: ATMMachineInfo, val bank: Bank) {

    init {

    }

    var currentAcNumber : Int = -1
    var currentWithdrawalAmount : Int = -1
    var currentPin : String = ""

    fun enterAccountNumber(acNumber: Int) {
        //validation account number
        //bank.authenticateAC()
    }

    fun enterWithdrawalAmount(amount: Int) {
        //validate amount
        //give message
    }

    fun enterPin(pin: String) {
        //validate pin
    }

    fun transact() {
        //bank.transact(accountNumber, amount, pin)
    }

    fun fulFillRequestByDeliveringTheCurrencies() {
        //strategy
    }

    fun fillBin(binId: String, numberOfCurrencyNotes: Int) {

    }

}