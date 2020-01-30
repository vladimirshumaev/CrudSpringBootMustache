call mvn -B -s settings.xml -DskipTests=true clean package
call java -Dspring.profiles.active="heroku" -DDATABASE_URL="postgres://postgres:root@localhost:5432/testcrudmustache2" -jar target/TestCrudSpringBootMustache-1.0-SNAPSHOT.war
