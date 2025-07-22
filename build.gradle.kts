plugins {
    java
//    application
}

group = "snakesandladders"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    // JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testImplementation("org.mockito:mockito-core:5.5.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    manifest {
        attributes(
            "Main-Class" to "com.technogise.assesment.app.Application"
        )
    }
}
