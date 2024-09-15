import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins{
    id(libs.plugins.android.get().pluginId)
    id(libs.plugins.kotlin.get().pluginId)
    id(libs.plugins.compose.get().pluginId)
    id(libs.plugins.cocoapods.get().pluginId)
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.10"
}

version = "0.0.1"


kotlin{

    cocoapods{
        summary = "PlayZone IOS SDK"
        homepage = "https://github.com/Android-Voyages/PlayZone"
        ios.deploymentTarget = "14.0"

        framework {
            @OptIn(ExperimentalKotlinGradlePluginApi::class)
            transitiveExport = false
            baseName = "SharedSDK"
            export(projects.core)
            export(projects.ui)
            export(projects.json)
            export(projects.platformSpecific)

        }
    }
    androidTarget()
    jvmToolchain(17)
    jvm()
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach{
        it.binaries.framework{
            baseName = "ComposeApp"
            isStatic = false
            linkerOpts.add("-lsqlite3")
        }
    }
    targets.withType<KotlinNativeTarget>{
        binaries.all{
            linkerOpts.add("-lsqlite3")
        }
    }

    sourceSets{
        commonMain.dependencies {

        }
    }
}

android {
    namespace = "th.observer.FlexCompose"
    compileSdk = 35
    defaultConfig {
        applicationId = "th.observer.FlexCompose"
        minSdk =  libs.versions.minSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.plugin.compose.compiler.get()
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}
