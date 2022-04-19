const val ONE_HOUR_IN_SECONDS = 3600
const val ONE_DAY_IN_SECONDS = 86400

fun main() {
    println("-минуты-")
    println(agoToText(50))
    println(agoToText(70))
    println(agoToText(150))
    println(agoToText(250))
    println(agoToText(450))
    println(agoToText(660))
    println(agoToText(720))
    println(agoToText(1260))

    println("-часы-")
    println(agoToText(3660))
    println(agoToText(7660))
    println(agoToText(11660))
    println(agoToText(33660))
    println(agoToText(40660))
    println(agoToText(53660))
    println(agoToText(63660))
    println(agoToText(83660))

    println("-сегодня вчера давно-")
    println(agoToText(163660))
    println(agoToText(253660))
    println(agoToText(363660))

}

fun agoToText(seconds: Int): String {

    var someTimeAgo = ""

    when {
        seconds in 1..60 -> someTimeAgo = "только что"

        seconds in 61 until ONE_HOUR_IN_SECONDS -> {
            someTimeAgo = "${seconds / 60} ${endWithMinutes(seconds)} назад"
        }

        seconds in ONE_HOUR_IN_SECONDS..ONE_DAY_IN_SECONDS -> {
            someTimeAgo = "в сети ${seconds / ONE_HOUR_IN_SECONDS} ${endWithHours(seconds)} назад"
        }

        (seconds > ONE_DAY_IN_SECONDS) && (seconds <= ONE_DAY_IN_SECONDS * 2) -> {
            someTimeAgo = "в сети сегодня"
        }

        (seconds > ONE_DAY_IN_SECONDS * 2) && (seconds <= ONE_DAY_IN_SECONDS * 3) -> {
            someTimeAgo = "в сети вчера"
        }

        (seconds > ONE_DAY_IN_SECONDS * 3) -> someTimeAgo = "в сети давно"
    }

    return "\"..был(а) $someTimeAgo\""
}

fun endWithMinutes(seconds: Int): String {

    val minutes = seconds / 60

    return when {
        (minutes % 10 == 1) && (minutes % 100 != 11) -> "минуту"

        (minutes % 10 == 2) && (minutes % 100 != 12) -> "минуты"
        (minutes % 10 == 3) && (minutes % 100 != 13) -> "минуты"
        (minutes % 10 == 4) && (minutes % 100 != 14) -> "минуты"

        else -> "минут"
    }
}

fun endWithHours(seconds: Int): String {

    val hours = seconds / ONE_HOUR_IN_SECONDS

    return when {
        (hours % 10 == 1) && (hours % 100 != 11) -> "час"

        (hours % 10 == 2) && (hours % 100 != 12) -> "часа"
        (hours % 10 == 3) && (hours % 100 != 13) -> "часа"
        (hours % 10 == 4) && (hours % 100 != 14) -> "часа"

        else -> "часов"
    }
}