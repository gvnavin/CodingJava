package companies.atm_question.customer

import companies.atm_question.customertransactions.CustomerTransaction

data class CustomerInfo(val customerId: String, val customerAcNumber: String, val balance: Int, val transactions: List<CustomerTransaction>, val name: String = "")
