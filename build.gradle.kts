plugins {
  `java-library`
  id("io.papermc.paperweight.userdev") version "1.5.5"
  id("xyz.jpenilla.run-paper") version "2.2.0" // Adds runServer and runMojangMappedServer tasks for testing
  id("maven-publish")
}

val group = "de.dasshorty"
val artifact = "enhancedui"
val projectVersion = "1.0.0"

java {
  // Configure the java toolchain. This allows gradle to auto-provision JDK 17 on systems that only have JDK 8 installed for example.
  toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

dependencies {
  paperweight.paperDevBundle("1.20.1-R0.1-SNAPSHOT")
  implementation("org.projectlombok:lombok:1.18.28")
  annotationProcessor("org.projectlombok:lombok:1.18.28")
}

publishing {
  repositories {
    maven {
      url = uri("https://repo.dasshorty.de/repository/api/")
      credentials {
        username = System.getenv("NEXUS_USER")
        password = System.getenv("NEXUS_PWD")
      }
    }
  }
  publications {
    create<MavenPublication>("api") {
      groupId = group
      artifactId = artifact
      version = projectVersion

      from(components["java"])
    }
  }
}

tasks {
  // Configure reobfJar to run when invoking the build task
  assemble {
    dependsOn(reobfJar)
  }

  compileJava {
    options.encoding = Charsets.UTF_8.name() // We want UTF-8 for everything

    // Set the release flag. This configures what version bytecode the compiler will emit, as well as what JDK APIs are usable.
    // See https://openjdk.java.net/jeps/247 for more information.
    options.release.set(17)
  }
  javadoc {
    options.encoding = Charsets.UTF_8.name() // We want UTF-8 for everything
  }
  processResources {
    filteringCharset = Charsets.UTF_8.name() // We want UTF-8 for everything
  }


  reobfJar {
    // This is an example of how you might change the output location for reobfJar. It's recommended not to do this
    // for a variety of reasons, however it's asked frequently enough that an example of how to do it is included here.
    outputJar.set(layout.buildDirectory.file("dist/EnhancedUI-${project.version}.jar"))
  }

}
