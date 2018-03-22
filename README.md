# test_case

Развертывание проекта: 

Клонировать/загрузить проект.
Запустить проект в Intellij IDEA.

API:

1. http://localhost:8080/create/new/all - заполнение БД информацией описанной в классах CategoryServiceImpl, ProductServiceImpl,
AttributeServiceImpl, AttributeValueServiceImpl. Возвращает true/false в зависимости от успеха завершения метода. В случае неудачи
выбрасывается Exception в лог.

2. http://localhost:8080/find?id=1

{"id":1,"name":"T19C350EX","brand_name":"Samsung","count":100,"price":8999,"category":{"id":1,"name":"TV"},
"attributeValues":[{"id":3,"value":"LED","attribute":{"id":3,"name":"Type of TV"}},
{"id":1,"value":"18.5","attribute":{"id":1,"name":"Diagonal"}},
{"id":2,"value":"150","attribute":{"id":2,"name":"Depth"}}]}

Запрос выполняет поиск по Id товара. Возвращает обьект класса Product с полной информацией о найденном товаре.
В случае если товар по данному Id не найден - вернется null, в лог выведется сообщение об этом.

3. http://localhost:8080/findAll

[{"id":1,"name":"T19C350EX","brand_name":"Samsung","count":100,"price":8999,"category":{"id":1,"name":"TV"},
"attributeValues":[{"id":2,"value":"150","attribute":{"id":2,"name":"Depth"}},
{"id":1,"value":"18.5","attribute":{"id":1,"name":"Diagonal"}},
{"id":3,"value":"LED","attribute":{"id":3,"name":"Type of TV"}}]},

{"id":2,"name":"T22C350EX","brand_name":"Samsung","count":150,"price":10999,"category":{"id":1,"name":"TV"},
"attributeValues":[{"id":6,"value":"LED","attribute":{"id":3,"name":"Type of TV"}},
{"id":4,"value":"21.5","attribute":{"id":1,"name":"Diagonal"}},
{"id":5,"value":"147","attribute":{"id":2,"name":"Depth"}}]},

...

{"id":9,"name":"MV65FZ23/S","brand_name":"Gorenje","count":174,"price":17490,"category":{"id":3,"name":"Washer"},
"attributeValues":[{"id":21,"value":"60","attribute":{"id":5,"name":"Width"}},
{"id":22,"value":"44","attribute":{"id":6,"name":"Depth"}},
{"id":24,"value":"vertical","attribute":{"id":8,"name":"Type of download"}},
{"id":23,"value":"85","attribute":{"id":7,"name":"Height"}}]}]

Запрос выводит полную информацию о товарах. Возвращает Collection<Product>. В случае если ничего не найдено приложение ведет себя
аналогично предыдущему запросу.

4. http://localhost:8080/update?id=1&price=10999&count=75

Запрос редактирует данные у существующего товара. Возвращает true/false. Предусмотрена проверка на положительность цены
и неотицательность кол-ва, в противном случае возвращется false и в лог уходит сообщение о некорретном аргументе. Если один из 
аргументов не указан, то будет использовано старое значение для данного товара.

