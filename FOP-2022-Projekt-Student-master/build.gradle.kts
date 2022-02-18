import org.sourcegrade.submitter.submit

plugins {
    java
    application
    id("org.sourcegrade.submitter").version("0.4.0")
}

submit {
    assignmentId = "projekt" // do not change assignmentId
    studentId = null // TU-ID  z.B. "ab12cdef"
    firstName = null
    lastName = null
    // Optionally require tests for prepareSubmission task. Default is true
    requireTests = true
}

// !! Achtung !!
// Die studentId (TU-ID) ist keine Matrikelnummer
// Richtig z.B. ab12cdef
// Falsch z.B. 1234567

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains:annotations:23.0.0")
    implementation("org.linkedopenactors.code:loa-distanceCalculator:0.0.6")
    implementation("org.linkedopenactors.code:loa-algorithm-distanceCalculator:0.0.9")
    implementation("org.linkedopenactors.code:distanceCalculator:0.0.1")
    // JUnit only available in "test" source set (./src/test)
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
}

application {
    mainClass.set("projekt.Main")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks {
    withType<JavaCompile> {
        options.encoding = "UTF-8"
    }
    test {
        useJUnitPlatform()
    }
}
