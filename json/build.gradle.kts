plugins{
    id("multiplatform-setup")
    id(libs.plugins.kotlin.get().pluginId)
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.10"

}

kotlin{
    sourceSets{
        commonMain.dependencies {
            implementation(libs.kotlinx.serialization.json)
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
