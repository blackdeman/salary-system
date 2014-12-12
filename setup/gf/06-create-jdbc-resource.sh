#!/bin/bash

. ./aservenv.sh

${asadmin} -u $admin_user --port=$admin_port --host=$admin_host --echo=true \
create-jdbc-resource \
--connectionpoolid salaryPool \
jdbc/salaryDB
