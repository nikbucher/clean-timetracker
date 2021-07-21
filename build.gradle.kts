plugins {
  `spring-java-conventions`
  application
}

group = "io.reflectoring"
version = "0.0.1-SNAPSHOT"

dependencies {
  implementation("javax.xml.bind:jaxb-api:2.3.1")
  implementation("org.javassist:javassist:3.23.1-GA")
  implementation("nz.net.ultraq.thymeleaf:thymeleaf-layout-dialect:2.3.0")
  implementation("javax.validation:validation-api:2.0.1.Final")
  compileOnly("org.projectlombok:lombok:1.18.2")
  annotationProcessor("org.projectlombok:lombok:1.18.2")
  runtimeOnly("com.h2database:h2")
}

application {
  mainClass.set("io.reflectoring.cleantimetracker.CleanTimetrackerApplication")
}

tasks {
  bootRun {
    jvmArgs = listOf(
      "-XX:TieredStopAtLevel=1",
      "-noverify",
      "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005"
    )
  }
}
