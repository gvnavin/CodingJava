package practice.atm_question.atm

data class ATMMachineInfo(val id: String, val bins: List<CurrencyBinInfo>, val location: String = "")
