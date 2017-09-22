cd /hms/tomcat/webapps
rm -rf pms-web.war pms-web/
cd /home/chinthaka/apps/chinthaka_do_not_delete/ChukZOT
mvn clean install
mvn package
cp web/target/ordertracking.war  /hms/tomcat/webapps
cd /hms/tomcat/bin
export JPDA_ADDRESS=5005
export JPDA_TRANSPORT=dt_socket 

./catalina.sh run
