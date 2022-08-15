plugins {
    kotlin("jvm") version "1.7.10"
    `maven-publish`
}

group = "net.gloryx"
version = "0.1.01"

repositories {
    mavenCentral()
    maven("https://dev.gloryx.net/main")
}

dependencies {
    api("org.jetbrains:annotations:23.0.0")
    api(kotlin("reflect"))
}


val javadoc: Javadoc by tasks

val javadocJar by tasks.creating(Jar::class) {
    from(javadoc)
    archiveClassifier.set("javadoc")
}

val sourcesJar by tasks.creating(Jar::class) {
    from(sourceSets["main"].allSource.include("**/*.kt"))
    archiveClassifier.set("sources")
}

publishing {
    repositories {
        maven("https://dev.gloryx.net/main") {
            credentials(PasswordCredentials::class) {
                username = System.getenv("GLORYX_USERNAME")
                password = System.getenv("GLORYX_PASSWORD")
            }
        }
    }
    publications {
        create("maven", MavenPublication::class) {
            artifactId = "oknamer"
            from(components["java"])
            artifact(javadocJar)
            artifact(sourcesJar)
        }
    }
}
