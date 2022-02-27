# aws
Запуск приложеня происходит по адресу http://localhost:8080/api/ (файл с заданием опубликовал).
При нажатии на кнопку "Show data" происходит считывание данных из локальной базы aws_db (настройки к ней находятся в файле application.properties).
Если в ней нет данных (т.е. приложение еще ни разу не запускалось), то происходит считывание данных из AWS S3 Bucket ʻcloudaware-testʼ и их запись в базу aws_db.
В приложении есть возможность устанавливать время первого автоматического обновления и периода обновлений, изменяя свойства scheduler.initialdelay и 
scheduler.delay в файле application.properties.
В папке sql_sсript находятся скрпипты находятся скрипты для создания пользователя, базы данных и таблицы, в которой будут храниться данные,
полученные из AWS S3 Bucket ʻcloudaware-testʼ (поля owner_id, display_name заполняются строчками "ХХ", т.к. не смог получить эти данные) 
