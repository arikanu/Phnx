Phnx
====

SETUP PROCEDURE


DATABASE CONFIGURATION

	1. Setup Database
		1.1 Setup with SQL Shell (psql)
			Run SQL Shell (psql)
			Connect to postgres as postgres, and run the following commands:
				CREATE ROLE examtestgroup VALID UNTIL 'infinity';
				CREATE ROLE pyre LOGIN ENCRYPTED PASSWORD 'md52a61004c4532c208ad6f92fb53935e9e' VALID UNTIL 'infinity';
				GRANT examtestgroup TO pyre;
				CREATE DATABASE examtestdb WITH ENCODING='UTF8' CONNECTION LIMIT=-1;
				\connect examtestdb
				CREATE SCHEMA schema1;
				GRANT ALL ON SCHEMA schema1 TO GROUP examtestgroup WITH GRANT OPTION;
		1.2 Setup with pgAdmin
			Run pgAdmin
			Connect to PostgreSQL x.x (localhost:5432)
			Right-click (RC) on Group Roles > New Group Role
				Role Name = examtestgroup > OK
			RC on Login Roles > New Login Role
				Properties - Role Name = pyre
				Definition - Password = rebirth
				Role Membership - Member >> examtestgroup > OK
			RC on Databases > New Database
				Name = examtestdb > 
			Double click database examtestdb
				RC on Schemas > New Schema
				Properties - Name = schema1
				Privileges tab
					Select Role = group examtestgroup in Role dropdown
					Check ALL
					Click Add/Change > OK
					
	2. Create Tables
		Open class com.phoenix.mvc.db.initialize.InitializeDb.java
			RC and Run as Java Application.
			
	3. Configuration
		Database Name = examtestdb
		Schema Name = schema1
		(Admin) Username = pyre
		Password = rebirth
		Connection Url = jdbc:postgresql://localhost:5432/examtestdb