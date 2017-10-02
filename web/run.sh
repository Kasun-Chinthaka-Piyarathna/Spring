cd /opt/tomcat/webapps
rm -rf pms-web.war pms-web/
cd /home/chinthaka/apps/new/Spring
mvn clean install
mvn package
cp web/target/ordertracking.war  /opt/tomcat/webapps
cd /opt/tomcat/bin
export JPDA_ADDRESS=5005
export JPDA_TRANSPORT=dt_socket 

./catalina.sh run
