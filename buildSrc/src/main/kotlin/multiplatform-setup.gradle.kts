
plugins {
    id("com.android.library")
    id("org.jetbrains.compose")
    kotlin("multiplatform")

}

kotlin {
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "core"
            isStatic = true
        }
    }
    androidTarget()
    jvmToolchain(17)

    sourceSets{
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
        }
    }
}
android {
    namespace = "th.observer.FlexCompose"
    compileSdk = 34
}