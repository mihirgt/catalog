plugins {
    id("version-catalog")
    id("maven-publish")
}

group = "in.gore.versioncatalog"
version = "1.0"

repositories {
    mavenLocal()
}

catalog {
    versionCatalog {
        from(files("gradle/libs.versions.toml"))
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["versionCatalog"])
        }
    }
}