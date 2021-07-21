plugins {
  id("org.springframework.boot")
  id("io.spring.dependency-management")
  id("java-conventions")
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
  implementation("org.springframework.boot:spring-boot-starter-web")

  testImplementation("org.springframework.boot:spring-boot-starter-test")
}

