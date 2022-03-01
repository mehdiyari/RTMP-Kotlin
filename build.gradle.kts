plugins {
    kotlin("jvm") version "1.6.0"
}

group = "ir.mehdiyari"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
}
