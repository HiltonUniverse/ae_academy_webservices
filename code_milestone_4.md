## Milestone 4

1. Create a java class called &#39;CloudConfiguration.java&#39; in the &#39;be.ae&#39; package with following code:

```java
@Configuration
@Profile("cloud")
public class CloudConfiguration extends AbstractCloudConfig {
}
```

2. Create a java class called &#39;LocalConfiguration.java&#39; in the &#39;be.ae&#39; package with following code:

```java
@Configuration
@Profile("local")
public class LocalConfiguration {
}
```

3. Add 2 files to your &#39;src/resources&#39; folder:
   1. application-local.properties

```
#Build with maven using: -Dspring.profiles.active=local
```
   2. application-cloud.properties

```
#Build with maven using: -Dspring.profiles.active=cloud
spring.cloud.appId=accountservice
```

4. Change the current application.properties file to (blank):
```

```

5. Check if you code still works by running your code from the cli with following command:
```
mvn spring-boot:run -Dspring.profiles.active=local
```

6. Add a file named &#39;Procfile&#39; (no extension on that file) and add the following line to that file:

```
web: java $JAVA_OPTS -Dserver.port=$PORT  -jar target/*.jar --spring.profiles.active=cloud
```

You can find more information about why we create a procfile here:
[https://devcenter.heroku.com/articles/procfile#deploying-to-heroku](https://devcenter.heroku.com/articles/procfile#deploying-to-heroku)

7. Make sure to install:
   1. Heroku CLI: [download page](https://devcenter.heroku.com/articles/heroku-cli)
   2. Git: [download page](https://git-scm.com/downloads)
8. Create following accounts
   1. Git
   2. Heroku
9. Create a git repository
   1. Use &#39;git clone [https://yourrepositoryhere](https://yourrepositoryhere)&#39; to put a clone version on your machine
   2. Change the .gitignore by adding following lines:
```
.idea
*.iml
target
```
      Be carefull above lines can change depending on the ide someone uses, adapt accordingly!

   3. Copy the project you&#39;ve made earlier into it
   4. Execute following commands:
 ```
 git add .
 git commit -am”initial implementation of my aewesomeservice”
 git push
 ```

10. Deploy your application to heroku and watch the magic happen by using this command:
```
heroku create
git push heroku master
```
