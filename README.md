# Nexign-Lottery
Реализован сервис : "Лотерея"
Сервис может принимать следующие запросы: 
1)Post-запрос /lottery/participant, тело запрос в виде json имеет поля (имя, возраст, город) участника.
2)Get-запрос /lottery/participant, пользователь получает список всех участников, которые есть в БД в виде json.
3)Get-запрос /lottery/start - запуск лотереи.
4)Get-запрос /lottery/winners - просмотр списка победителей.

Использовалась БД - MySQL 
url = jdbc:mysql://localhost:3306/springbootdemo

БД имеет две таблицы : participants и winners, каждая из которых имеет 4 поля:
1)id - bigint primary key auto increment;
2)first_name - varchar(256);
3)age - int;
4)city - varchar(256);
