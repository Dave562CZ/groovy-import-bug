plugins {
    `java-library`
}

repositories {
    mavenCentral()
}
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}
testing {
    suites {
        val workingTest by registering(JvmTestSuite::class) {
            useJUnitJupiter()
        }
        val brokenTest by registering(JvmTestSuite::class) {
            useJUnitJupiter()
        }
    }

}

dependencies {
    "workingTestImplementation"("org.codehaus.groovy:groovy:2.5.0")
    "brokenTestImplementation"("org.codehaus.groovy:groovy:2.5.1")
}

tasks.check {
    dependsOn("workingTest", "brokenTest")
}


