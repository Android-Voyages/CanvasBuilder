plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    id("signing")
    id("maven-publish")
    id("org.jetbrains.compose") version "1.6.11"

}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(kotlin("stdlib"))
            implementation(libs.androidx.activity.compose)
        }
        iosMain.dependencies {

        }
        commonMain.dependencies {
            implementation(kotlin("stdlib-common"))
            implementation(compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

publishing{
    publications{
        create<MavenPublication>("maven"){
            from(components["kotlin"])

            groupId = "th.observer"
            artifactId = "FlexCompose"
            version = "0.1.0"

            pom{
                name.set("FlexCompose")
                description.set("A Kotlin Multiplatform library for working with Compose kit")
                url.set("https://github.com/Android-Voyages/CanvasBuilder")


                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        distribution.set("repo")
                    }
                }
                developers {
                    developer {
                        id.set("ktoznet")
                        name.set("Kirill Bereznev")
                        email.set("bereznev681@gmail.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/Android-Voyages/FlexCompose.git")
                    developerConnection.set("scm:git:ssh://github.com/Android-Voyages/FlexCompose.git")
                    url.set("https://github.com/Android-Voyages/FlexCompose")
                }

            }
        }
    }
}
signing{
    sign(publishing.publications["maven"])
}

android {
    namespace = "th.observer.FlexCompose"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.7.1"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
