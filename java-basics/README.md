# Basic Java Project 


## Build 

### Create Jar 

```bash
./gradlew build
```

The jar would be generated in `build/libs` folder.

### Creating Fat Jars 

A fat jar is a jar file that includes all the required libraries inside it. 
Far jars are easy to distribute and deploy as they do not require anything other
than a working Java Runtime Environment to run. 

Add this to `build.gradle.kts`
```kts

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "com.scaler.Main"
    }
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from(configurations.runtimeClasspath.get().map({ if (it.isDirectory) it else zipTree(it) }))
}
```

Build and run the jar file
```bash
./gradlew build
java -jar build/libs/java-basics-1.0-SNAPSHOT.jar
```
