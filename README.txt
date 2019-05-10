För att få samtliga funktioner till hemsidan så används följande program:

1. eclipse (https://www.eclipse.org/downloads/packages/release/2019-03/r/eclipse-ide-enterprise-java-developers)
2. tomcat (https://tomcat.apache.org/download-90.cgi)
3. postgresql (sätt lösenord till "password" under installationen för att stämma överrens med koden, port default (5432)) (https://www.postgresql.org/download/)
4. postgresql jar, version PostgreSQL JDBC 4.2 Driver, 42.2.5, (https://jdbc.postgresql.org/download.html)
5. pgadmin 4 (https://www.pgadmin.org/download/) 
6. "sys.war" från RateAGames Github

6. Packa upp tomcat-filen och placera postgresql jar (från steg 4, inte 3) i mappen "lib"
7. Starta eclipse tryck på "File" och sedan "Import", sök efter "war" och tryck på Next. Under War-file, tryck på browse och hitta 
"sys.war", som finns på RateAGames GitHub. Tryck på Välj Fil och sedan på Finish
8. Högerklicka på det nu importerade projektet vid vänster sida av eclipse och välj "Properties" längst ner.
9. Hitta "Targeted Runtimes" och välj "New" -> Apache Tomcat v.9.0 -> Browse -> hitta och välj tomcat-mappen och tryck på OK. 
10. Högerklicka på projektet och tryck på "Build Path" -> "Configure Build Path" -> Add external JARS (höger sida)
11. Leta upp PostgreSQL JAR-filen och välj, tryck sedan på apply and close
12. Högerklicka på projektet igen och tryck på Configure -> Convert to Maven Project, tryck på Finish på rutan som kommer upp
Projektet är nu redo att köras
13. Initialisera databasen: gå in i java resources -> src/java -> öppna "sys" -> högerklicka på DatabaseConnection och tryck på "run as application"
14. Högerklicka på projektet och tryck på "Run As" -> "Run on server", välj Tomcat v.9.0
15. Gå in i valfri browser och skriv in "localhost:8080/sys/"
16. För att stänga ner servern, tryck på röda kvadraten nere till höger i eclipse.

Om något gick fel under stegen, kontakta RateAGame så hjälper vi till.