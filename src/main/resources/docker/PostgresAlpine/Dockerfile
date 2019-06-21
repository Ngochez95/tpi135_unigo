ARG registry="192.168.43.2:5000/"
ARG image="postgres"
ARG tag="9.4-alpine"
FROM ${registry}${image}${tag}

ADD TPIFinal.sql /docker-entrypoint-initdb.d/TPIFinal.sql

