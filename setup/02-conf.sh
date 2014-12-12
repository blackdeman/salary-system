#!/bin/bash

. ./aservenv.sh

cp -av logback.xml ${domain_dir}/${domain_name}/config

echo 
echo !!!!!!!!!!!!!!!!!!!!!!!!!!!!!
echo "Copy jdbc drivers into ${domain_dir}/${domain_name}/lib/ext"
