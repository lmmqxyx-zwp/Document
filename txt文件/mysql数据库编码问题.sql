---查看mysql数据库版本
MariaDB [(none)]> status;
--------------
mysql  Ver 15.1 Distrib 10.1.26-MariaDB, for Win32 (AMD64)

Connection id:          2
Current database:
Current user:           root@localhost
SSL:                    Not in use
Using delimiter:        ;
Server:                 MariaDB
Server version:         10.1.26-MariaDB mariadb.org binary distribution ---版本号
Protocol version:       10
Connection:             localhost via TCP/IP
Server characterset:    latin1
Db     characterset:    latin1
Client characterset:    gbk
Conn.  characterset:    gbk
TCP port:               3306
Uptime:                 1 hour 29 min 58 sec

Threads: 1  Questions: 5  Slow queries: 0  Opens: 17  Flush tables: 1  Open tables: 11  Queries per second avg: 0.000
--------------

---更改mysql数据库编码
---show variables like 'character%'; //查询当前mysql数据库的所有属性的字符编码
MariaDB [(none)]> show variables like 'character%';
+--------------------------+--------------------------------------+
| Variable_name            | Value                                |
+--------------------------+--------------------------------------+
| character_set_client     | gbk                                  |
| character_set_connection | gbk                                  |
| character_set_database   | latin1                               | ---数据库编码
| character_set_filesystem | binary                               |
| character_set_results    | gbk                                  |
| character_set_server     | latin1                               |
| character_set_system     | utf8                                 |
| character_sets_dir       | E:\commonTools\mysql\share\charsets\ |
+--------------------------+--------------------------------------+

---修改数据库字符编码
alter database 数据库名称 character set utf8;

---创建指定编码的数据库
create database 数据库名称 character set utf8 ;








