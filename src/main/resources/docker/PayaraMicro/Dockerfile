ARG registry="192.168.43.2:5000/"
ARG image="payara/micro"
ARG tag=":4.181"
FROM ${registry}${image}${tag}
COPY postgresql-42.2.2.jar $PAYARA_PATH/
COPY asadmin.txt $PAYARA_PATH/
COPY uniGo-1.0-SNAPSHOT.war $PAYARA_PATH/
CMD mkdir /opt/payara/img/tmp/
ENTRYPOINT ["java", "-jar", "payara-micro.jar", "--addLibs", "postgresql-42.2.2.jar", "--postbootcommandfile", "asadmin.txt","--deploy", "uniGo-1.0-SNAPSHOT.war"]
