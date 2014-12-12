#!/bin/bash

. ./aservenv.sh

${asadmin} -u $admin_user --port=$admin_port --host=$admin_host --echo=true \
create-jvm-options \
"-Dlogback.configurationFile=file\:///\${com.sun.aas.instanceRoot}/config/logback.xml"
