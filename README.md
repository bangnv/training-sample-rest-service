training-calculator-rest
========================

RUN
--------------------------


1. To deploy a rest service in Exo Product. We can take the gatein 3.4.0.Final

-build a jar : mvn package -DskipTests   (if the server is not started, skipTest is mandatory for build the jar )

copy exo-sample-rest-service-4.0.0.Alpha1-SNAPSHOT.jar to gatein/lib, and start gatein


http://localhost:8080/rest/rest/helloworld

2. To access the Rest Service : 
 
All implementation of rest service is in the package org.exoplatform.cross.rest. Your can find the url for access to rest service 
For example : 
 
-- Rest Service for calcul the different between two date in several format as Minutes, Hours, Day with 3 url following

http://localhost:8080/rest/dateService/diffDate/11-05-2011/11-07-2012/Min
http://localhost:8080/rest/dateService/diffDate/11-05-2011/11-07-2012/Hour
http://localhost:8080/rest/dateService/diffDate/11-05-2011/11-07-2012/Day

-- Calculator Rest Service : 
4 operators add multiplication, addition, soutraction, division with 4 url following

http://localhost:8080/rest/calculService/multi/1/2
http://localhost:8080/rest/calculService/plus/1/2
http://localhost:8080/rest/calculService/subs/1/2
http://localhost:8080/rest/calculService/div/1/2

WebService calculator


3. To test the REst Service .
One time, the rest service deployed in the server Gate. We can test by command mvn test



