plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "net.kigawa.fstore"
include("back")
include("front")
