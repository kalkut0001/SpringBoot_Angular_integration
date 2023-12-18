# Springboot-Angular-Integration

This is a sample project to guide how to integrate and execute spring boot and angular project in to one port.

## Step 1:

– Set the output directory to static folder:
Open angular.json, add the "outputPath": "./static" option to the build target so that the production will be stored in static folder under project root directory.

{
  ...
  "projects": {
    "Angular8ClientCrud": {
      ...
      "architect": {
        "build": {
          "builder": "@angular-devkit/build-angular:browser",
          "options": {
            "outputPath": "./static",  <==Update output path==>
            "index": "src/index.html",
            "main": "src/main.ts",
            ...
          },
          "configurations": {
            ...
          }
        },
        ...
      }
    }},
  "defaultProject": "Angular8ClientCrud"
}

## Step 2:

Now we need to copy all files from Angular static folder to src/target/classes/static folder of Spring Boot project.

<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>


			<plugin>
				<artifactId>maven-resources-plugin</artifactId>
				<executions>
					<execution>
						<id>copy-resources</id>
						<phase>validate</phase>
						<goals>
							<goal>copy-resources</goal>
						</goals>
						<configuration>
							<outputDirectory>${basedir}/target/classes/static/</outputDirectory>
							<resources>
								<resource>
									<directory>${basedir}/../Angularfrontend/static</directory>
								</resource>
							</resources>
						</configuration>
					</execution>
				</executions>
			</plugin>


		</plugins>
	</build>

## Run and Check Result

Build and run the Spring Boot server with commands:
– mvn clean install
– mvn spring-boot:run

## From UI (frontend code base )

Open browser with url: http://localhost:8080/.

## To check json data  (backend code base )

http://localhost:8080/getAllData

## Further help

Let me know if you face any issue while set up.
