package practice.atm_question.customertransactions

import java.time.LocalDateTime

enum class CustomerTransactionsType  {
    DEBIT,
    CREDIT
}

data class CustomerTransaction(val transactionId: String, val type: CustomerTransactionsType, val amount: Int, val time: LocalDateTime)
