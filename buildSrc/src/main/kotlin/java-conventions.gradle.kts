plugins {
  id("base-conventions")
  java
}

dependencies {
  testImplementation("org.junit.jupiter:junit-jupiter-api:${Versions.junit}")
  testImplementation("org.junit.jupiter:junit-jupiter-params:${Versions.junit}")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${Versions.junit}")

  testImplementation("org.assertj:assertj-core:${Versions.assertj}")
}

java {
  sourceCompatibility = JavaVersion.VERSION_11
}

tasks {
  withType<JavaCompile> {
    options.encoding = "UTF-8"
  }

  withType<Test> {
    useJUnitPlatform()
  }
}
