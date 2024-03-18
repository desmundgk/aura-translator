plugins {
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.serialization") version "1.9.22"

    `java-library`
    `maven-publish`
}

group = "net.georgekent.lib.aura_translator"
version = "1.5.1"

publishing {
    publications {
        create<MavenPublication>("auraTranslator") {
            groupId = "net.georgekent.lib"
            artifactId = "aura_translator"
            version = "1.5.1"
            from(components["java"])
        }
    }

    repositories {
        maven {
            name = "GKRepo"
            url = uri(layout.buildDirectory.dir("repo"))
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-cbor:1.3.2")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-cbor:2.17.0")
    implementation("junit:junit:4.13.1")

    testImplementation("org.jetbrains.kotlin:kotlin-test:1.7.0")
}
