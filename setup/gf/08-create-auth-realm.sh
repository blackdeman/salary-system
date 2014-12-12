#!/bin/bash

. ./aservenv.sh

$asadmin -u $admin_user --port=$admin_port --echo=true \
create-auth-realm \
--classname com.sun.enterprise.security.auth.realm.jdbc.JDBCRealm \
--property  "datasource-jndi=jdbc/salaryDB:jaas-context=jdbcRealm:assign-groups=default\
:user-table=user_role_view:user-name-column=username:password-column=password:group-table=user_role_view:group-name-column=rolename\
:digest-algorithm=none:digestrealm-password-enc-algorithm=none" \
salaryRealm
