#!/bin/bash

. ./aservenv.sh

$asadmin -u $admin_user --port=$admin_port --echo=true \
create-auth-realm \
--classname com.sun.enterprise.security.auth.realm.jdbc.JDBCRealm \
--property  "datasource-jndi=jdbc/salaryDB:jaas-context=jdbcRealm:assign-groups=default\
:user-table=users:user-name-column=user_name:password-column=user_pswd:group-table=groups:group-name-column=group_name\
:digest-algorithm=none:digestrealm-password-enc-algorithm=none" \
salaryRealm
