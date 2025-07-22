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
}

tasks.test {
    useJUnitPlatform()
}

//application {
//    mainClass.set("com.technogise.assesment.Main")
//}
