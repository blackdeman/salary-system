call dbenv.bat
%mysql% -u%rootname% -p%rootpswd% -e "grant all privileges on %db_name%.* to %username%@"localhost" identified by '%userpswd%';"