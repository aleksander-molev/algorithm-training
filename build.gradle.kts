plugins {
    java
}

group = "dev.alex.algorithmtraining"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

sourceSets {
    main {
        java.setSrcDirs(listOf("src/main/java", "problems"))
    }
    test {
        java.setSrcDirs(listOf("src/test/java", "tests"))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.11.4"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
