#!/bin/bash

. ./aservenv.sh

$asadmin restart-domain --user $admin_user $domain_name
