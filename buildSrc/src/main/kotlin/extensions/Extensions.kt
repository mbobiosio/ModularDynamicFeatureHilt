package extensions

import java.util.*

fun String.isStableVersion(): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { toUpperCase(java.util.Locale.ROOT).contains(it) }
    return stableKeyword || Regex("^[0-9,.v-]+(-r)?$").matches(this)
}

fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any {
        version.toUpperCase(Locale.ROOT).contains(it)
    }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}