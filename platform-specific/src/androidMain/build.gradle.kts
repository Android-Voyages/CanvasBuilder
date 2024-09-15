plugins{
    id("multiplatform-setup")
    id(libs.plugins.kotlin.get().pluginId)
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.10"
}

kotlin{
    sourceSets{
        commonMain.dependencies {
            implementation(libs.kotlinx.serialization.core)
            implementation(libs.kotlinx.coroutines)
        }
        androidMain.dependencies {
            implementation(libs.androidx.core.ktx)
            implementation(compose.ui)
            implementation(compose.foundation)
            implementation(compose.material)
        }
    }
}

android{
    namespace = "th.observer.FlexCompose"
    compileSdk = 35
    defaultConfig {
        minSdk =  libs.versions.minSdk.get().toInt()

        multiDexEnabled = true

    }
}
