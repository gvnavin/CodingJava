package practice.atm_question

import practice.atm_question.atm.ATMMachineInfo
import practice.atm_question.atm.CurrencyBinInfo
import practice.atm_question.bank.Bank
import practice.atm_question.bank.BankInfo
import practice.atm_question.customer.CustomerInfo
import practice.atm_question.customertransactions.CustomerTransaction
import practice.atm_question.customertransactions.CustomerTransactionsType
import java.time.LocalDateTime

class Admin {

    fun initialize() {

        val customerTransaction = CustomerTransaction("trans_1", CustomerTransactionsType.CREDIT, 100, LocalDateTime.now().minusDays(1));
        val customerInfo = CustomerInfo("customer_1", "account_1", 1000, listOf(customerTransaction))
        val bankInfo = BankInfo("bank_1")
        val bank = Bank(bankInfo, listOf(customerInfo))

        val currencyBinInfo = CurrencyBinInfo("100", 100, 10)
        val atmMachineInfo = ATMMachineInfo("atm_1", listOf(currencyBinInfo))
//        val atmMachine = ATMMachine(atmMachineInfo, bankInfo)

//        atmMachine.enterAccountNumber()
//        atmMachine.enterWithdrawalAmount();
//        atmMachine.enterPin()

    }

}
