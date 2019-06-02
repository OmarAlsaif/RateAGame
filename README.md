# RateAGame
Länk till github: https://github.com/OmarAlsaif/RateAGame/

För köra hemsidan med dess samtliga funktioner behövs följande program

1. eclipse (https://www.eclipse.org/downloads/packages/release/2019-03/r/eclipse-ide-enterprise-java-developers)
2. postgresql (https://www.postgresql.org/download/)
3. postgresql jar, version PostgreSQL JDBC 4.2 Driver, 42.2.5, (https://jdbc.postgresql.org/download.html)

4. Starta eclipse tryck på "File" och sedan "Import", sök efter "maven" och tryck på "Existing Maven Project" -> next. Tryck på browse och hitta 
mappen som heter "RateAGame". och tryck på "Välj Mapp" -> Finish
5. Högerklicka på projektet och tryck på "Build Path" -> "Configure Build Path" -> Add external JARS (höger sida)
6. Leta upp PostgreSQL JAR-filen och välj denna, tryck sedan på apply and close

Projektet är nu redo att köras

7. För att starta servern, gå in i mappen RateAGame, inne i Eclipse, öppna sedan mappen Spark, högerklicka på klassen Controller och tryck på Run as
-> Run on Application
8. Gå in i valfri browser och skriv in "localhost:4567/"
9. För att stänga ner servern, tryck på röda kvadraten nere till höger i eclipse.