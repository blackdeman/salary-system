#!/bin/bash

export GLASSFISH_HOME=/c/dev/glassfish4/glassfish
asadmin=${GLASSFISH_HOME}/bin/asadmin

domain_name=salary
domain_dir=${GLASSFISH_HOME}/domains

admin_user=admin
admin_port=14848

# create-domain options
instance_port=18080
http_ssl_port=18181

mysql_host=localhost
