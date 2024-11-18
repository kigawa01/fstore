import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    id("net.kigawa.fstore.java-conventions")
    alias(libs.plugins.kvision)
    alias(libs.plugins.kotlin.plugin.serialization)
}

//application {
//    mainClass.set("io.ktor.server.netty.EngineMain")
//
//    val isDevelopment: Boolean = project.ext.has("development")
//    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
//}

repositories {
    mavenCentral()
}

dependencies {
}

kotlin {
    js(IR) {
        browser {
            commonWebpackConfig {
                outputFileName = "main.bundle.js"
                sourceMaps = false
            }
        }
        binaries.executable()
    }
    jvm {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
        }
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        mainRun {
            val mainClassName = "io.ktor.server.netty.EngineMain"

            mainClass.set(mainClassName)
        }
    }
    sourceSets["jsMain"].dependencies {
        implementation(libs.kvision.kvision)
        implementation(libs.kvision.bootstrap)
        implementation(libs.kvision.state)
        implementation(libs.kvision.fontawesome)
        implementation(libs.kvision.i18n)
        implementation(libs.kotlin.stdlib.js)
    }
    sourceSets["commonMain"].dependencies {
        api(libs.kvision.ktor.koin)
    }
    sourceSets["jvmMain"].apply {
        dependencies {
            implementation(libs.koin.ktor)
            implementation(libs.koin.logger.slf4j)
            implementation(libs.ktor.server.core)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.ktor.server.content.negotiation)
            implementation(libs.mongodb.driver.core)
            implementation(libs.mongodb.driver.sync)
            implementation(libs.bson)
            implementation(libs.ktor.server.html.builder)
            implementation(libs.ktor.server.auth)
            implementation(libs.ktor.server.auth.jwt)
            implementation(libs.ktor.server.netty)
            implementation(libs.logback.classic)
            implementation(libs.ktor.server.config.yaml)
        }
    }
    sourceSets["jvmTest"].apply {
        dependencies {
            implementation(libs.ktor.server.test.host)
            implementation(libs.kotlin.test.junit)
            implementation(kotlin("test"))
        }
    }

//    sourceSets["jsTest"].dependencies {
//    }
}