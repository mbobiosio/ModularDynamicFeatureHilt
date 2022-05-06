object AndroidConfig {
    const val APPLICATION_ID = "com.mbobiosio.modularapp"
    const val MIN_SDK = 21
    const val TARGET_SDK = 32
    const val COMPILE_SDK = 32

    private const val versionMajor = 1
    private const val versionMinor = 0
    private const val versionPatch = 0

    const val VERSION_CODE = versionMajor * 1000 + versionMinor * 100 + versionPatch
    const val VERSION_NAME = "${versionMajor}.${versionMinor}.${versionPatch}"

    const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
}