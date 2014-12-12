#!/bin/bash

. ./aservenv.sh


${asadmin} -u $admin_user --port=$admin_port --echo=true \
create-jdbc-connection-pool \
--datasourceclassname com.mysql.jdbc.jdbc2.optional.MysqlDataSource \
--restype javax.sql.DataSource \
--isolationlevel read-committed \
--isisolationguaranteed \
--isconnectvalidatereq \
--validationmethod table \
--validationtable dual \
--failconnection=true \
--allownoncomponentcallers=false \
--nontransactionalconnections=false \
--property "user=salary:password=salary:URL=jdbc\:mysql\://${mysql_host}\:3306/salary_system" \
salaryPool