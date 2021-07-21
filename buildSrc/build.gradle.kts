plugins {
  `kotlin-dsl`
}

repositories {
  gradlePluginPortal()
}

//val kotlinVersion = "1.5.20"

dependencies {
//  implementation(platform("org.jetbrains.kotlin:kotlin-bom:$kotlinVersion"))
//  implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
//  implementation("org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion")

  implementation("org.springframework.boot:spring-boot-gradle-plugin:2.5.2")
  implementation("io.spring.gradle:dependency-management-plugin:1.0.11.RELEASE")
  implementation("com.netflix.nebula:nebula-release-plugin:15.3.+")
}
