plugins{
    id("multiplatform-setup")
    id(libs.plugins.kotlin.get().pluginId)
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.10"

}

kotlin{
    sourceSets{
        commonMain.dependencies {
        }
        androidMain.dependencies {
            implementation(libs.androidx.multidex)
        }
    }
}

android{
    namespace = "th.observer.FlexCompose"
    compileSdk = 35
    defaultConfig {
        minSdk = 23

        multiDexEnabled = true

    }
}
