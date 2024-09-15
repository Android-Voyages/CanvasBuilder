plugins{
    id("multiplatform-setup")
    id(libs.plugins.kotlin.get().pluginId)
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.10"
    id(libs.plugins.compose.get().pluginId)
}

kotlin{
    sourceSets{
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.ui)
            implementation(compose.foundation)
            implementation(compose.material)
        }
        androidMain.dependencies {
            implementation(libs.androidx.multidex)
            implementation(libs.androidx.activity.compose)

        }
    }
}

android{
    namespace = "th.observer.FlexCompose"
    compileSdk = 35
    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()

        multiDexEnabled = true

    }
}
