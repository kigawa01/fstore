/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
  kotlin("multiplatform")
}

repositories {
  mavenLocal()
  mavenCentral()
  gradlePluginPortal()

  maven {
    url = uri("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
  }
}

dependencies {
  commonMainImplementation("org.jetbrains.kotlin:kotlin-stdlib:2.0.21")
  commonMainImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")

  commonTestImplementation(kotlin("test-common"))
}

group = "net.kigawa"
version = "0.0.1"

kotlin {
  jvm {
  }
  js(IR) {
    browser {
      testTask {
        useKarma {
          useChromeHeadless()
        }
      }
    }
  }
}

