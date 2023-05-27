Умови завдання (директорія INFO)
----------------------------------
Виконати SQL-запити
INFO/SQLs.sql

Виправити проект.
REST-запити повинні спрацьовувати відповідно.


Тест REST API
----------------------

Postman для тесту REST API
https://www.postman.com/


1) REST-запит(и) на отримання даних

GET http://localhost:8080/api/products

GET http://localhost:8080/api/products/categories/fruits

GET http://localhost:8080/api/products/categories/vegetables


2) REST-запит на створення даних

POST http://localhost:8080/api/products

Налаштування в Postman: Body, raw, JSON.

{
	"name": "broccoli",
	"category": "vegetables",
	"price": 2.95
}


{
	"name": "kiwi",
	"category": "fruits",
	"price": 3.05
}


3) REST-запит на отримання даних за id

GET http://localhost:8080/api/products/2


4) REST-запит на оновлення даних за id

POST http://localhost:8080/api/products

{
	"id": 3,
	"name": "tomato",
	"category": "vegetables",
	"price": 1.95
}


5) REST-запит на видалення даних за id

DELETE http://localhost:8080/api/products/1

