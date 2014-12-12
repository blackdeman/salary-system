#!/bin/bash

. ./aservenv.sh

${asadmin} create-domain \
--user $admin_user \
--adminport $admin_port \
--instanceport $instance_port \
--domainproperties http.ssl.port=$http_ssl_port \
$domain_name

