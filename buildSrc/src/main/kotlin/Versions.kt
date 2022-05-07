object AndroidConfig {
    const val APPLICATION_ID = "com.mbobiosio.modularapp"
    const val MIN_SDK = 21
    const val TARGET_SDK = 32
    const val COMPILE_SDK = 32

    private const val versionMajor = 1
    private const val versionMinor = 0
    private const val versionPatch = 0

    const val VERSION_CODE = 1
    const val VERSION_NAME = "${versionMajor}.${versionMinor}.${versionPatch}"

    const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"

    /*
    Creating a build number based on current date. This is a better option than using build number based
    on version number because Google play console needs a build number greater each time a new apk is uploaded.
    When using a build number based on version, if your current beta apk is 1.3.0 and you want to publish
    an update to your 1.2.0 production version you won't be able to do so. We can't use build number
    based on milliseconds time though because of 2100000000 version code limitation. Here we make a
    build number that increment only every minute so we should never reach 2100000000.
    */
    private const val projectStartTimeMillis = 1517443200000
    val versionBuild = ((System.currentTimeMillis() - projectStartTimeMillis) / 6000).toInt()
}