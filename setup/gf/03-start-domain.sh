#!/bin/bash

. ./aservenv.sh

$asadmin start-domain --user $admin_user $domain_name
