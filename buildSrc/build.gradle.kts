plugins {
  `kotlin-dsl`
}

repositories {
  gradlePluginPortal()
}

dependencies {
  implementation("org.springframework.boot:spring-boot-gradle-plugin:2.5.2")
  implementation("io.spring.gradle:dependency-management-plugin:1.0.11.RELEASE")
  implementation("com.netflix.nebula:nebula-release-plugin:15.3.+")
}
