### Получение списка товаров по http запросу

Проект написан на Java 17 + spring boot

Состоит из БД содержащей 2 таблицы (товары и скидки) и rest сервера.

Получить список товаров можно запросом http://localhost:8989/products/
При использовании параметра discount="Название скидки" выводится список товаров со скидкой.