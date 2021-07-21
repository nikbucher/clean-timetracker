/*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("base-conventions")
  id("java-conventions")
  kotlin("jvm")
  //id("org.jlleitschuh.gradle.ktlint")
}

dependencies {
  constraints {
    // Define dependency versions as constrains
    implementation("org.jetbrains.kotlin:kotlin-bom")
  }

  // Align versions of all Kotlin components
  implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  implementation("org.jetbrains.kotlin:kotlin-reflect")

  testImplementation("io.mockk:mockk:${Versions.mockk}")
}

tasks {
  withType<KotlinCompile> {
    kotlinOptions {
      freeCompilerArgs = listOf("-Xjsr305=strict", "-Xinline-classes")
      javaParameters = true
      jvmTarget = JavaVersion.VERSION_11.toString()
    }
  }
}
*/
