# INTERVALE TEST TASK
Intervale test task application - `Library`. 

*More detailed information can be reached here - http://localhost/swagger-ui/#/*

## Technology stack:
**`Spring Boot (Web, Data JPA, Validation)`**, **`PostgreSQL`**, **`Liquibase`**, **`ModelMapper`**, **`Swagger`**, **`Docker`**, **`Maven`**. 


## How to build:
1. Build project: mvn clean install
2. To run environment: docker compose up

## Endpoints:
`Author Controller`

|   HTTP Method   | URL                                                     | Description                          |
|:---------------:|---------------------------------------------------------|--------------------------------------|
|      `GET`      | localhost/author/                                       | Get All Entites                      |
|      `GET`      | localhost/author/{uuid}                                 | Get Entity by UUID                   |
|     `POST`      | localhost/author/                                       | Create new Entity                    |
|      `PUT`      | localhost/author/{uuid}                                 | Update Entity by UUID                |
|    `DELETE`     | localhost/author/{uuid}                                 | Delete Entity by UUID                |

`Publisher Controller`

|   HTTP Method   | URL                                                        | Description                       |
|:---------------:|------------------------------------------------------------|-----------------------------------|
|      `GET`      | localhost/publisher/                                       | Get All Entites                   |
|      `GET`      | localhost/publisher/{uuid}                                 | Get Entity by UUID                |
|     `POST`      | localhost/publisher/                                       | Create new Entity                 |
|      `PUT`      | localhost/publisher/{uuid}                                 | Update Entity by UUID             |
|    `DELETE`     | localhost/publisher/{uuid}                                 | Delete Entity by UUID             |


`Book Controller`

|   HTTP Method   | URL                                                      | Description                           |
|:---------------:|--------------------------------------------------------- |---------------------------------------|
|      `GET`      | localhost/books/                                         | Get All Entites                       |
|      `GET`      | localhost/books/{uuid}                                   | Get Entity by UUID                    |
|      `GET`      | localhost/books/author/{authorName}                      | Get Entity by UUID and Author         |
|      `GET`      | localhost/books/publisher/{publisherName}                | Get Entity by UUID and Publisher      |
|      `GET`      | localhost/books/year/{year}                              | Get Entity by UUID and year           |
|     `POST`      | localhost/books/                                         | Create new Entity                     |
|      `PUT`      | localhost/books/{uuid}                                   | Update Entity by UUID                 |
|    `DELETE`     | localhost/books/{uuid}                                   | Delete Entity by UUID                 |

`Magazine Controller`

|   HTTP Method   | URL                                                         | Description                        |
|:---------------:|-------------------------------------------------------------|------------------------------------|
|      `GET`      | localhost/magazine/                                         | Get All Entites                    |
|      `GET`      | localhost/magazine/{uuid}                                   | Get Entity by UUID                 |
|      `GET`      | localhost/magazine/author/{authorName}                      | Get Entity by UUID and Author      |
|      `GET`      | localhost/magazine/publisher/{publisherName}                | Get Entity by UUID and Publisher   |
|      `GET`      | localhost/magazine/year/{year}                              | Get Entity by UUID and year        |
|     `POST`      | localhost/magazine/                                         | Create new Entity                  |
|      `PUT`      | localhost/magazine/{uuid}                                   | Update Entity by UUID              |
|    `DELETE`     | localhost/magazine/{uuid}                                   | Delete Entity by UUID              |

`Newspaper Controller`

|   HTTP Method   | URL                                                          | Description                       |
|:---------------:|--------------------------------------------------------------|-----------------------------------|
|      `GET`      | localhost/newspaper/                                         | Get All Entites                   |
|      `GET`      | localhost/newspaper/{uuid}                                   | Get Entity by UUID                |
|      `GET`      | localhost/newspaper/author/{authorName}                      | Get Entity by UUID and Author     |
|      `GET`      | localhost/newspaper/publisher/{publisherName}                | Get Entity by UUID and Publisher  |
|      `GET`      | localhost/newspaper/year/{year}                              | Get Entity by UUID and year       |
|     `POST`      | localhost/newspaper/                                         | Create new Entity                 |
|      `PUT`      | localhost/newspaper/{uuid}                                   | Update Entity by UUID             |
|    `DELETE`     | localhost/newspaper/{uuid}                                   | Delete Entity by UUID             |

## People controllers (`Author`, `Publisher`) have the same behavior. As example - author controller. 

## Get All Entities

*Request:*

`localhost/author/`

*Response:*

```json
{
    "content": [
        {
            "id": "1a875548-9db7-4dc3-acfb-e51496d51689",
            "createDate": "2023-02-08T18:09:06.450002",
            "version": 0,
            "name": "Author1",
            "lastname": "lastname",
            "birthYear": 2021
        }
    ],
    "pageable": {
        "sort": {
            "empty": true,
            "unsorted": true,
            "sorted": false
        },
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 10,
        "paged": true,
        "unpaged": false
    },
    "totalPages": 1,
    "totalElements": 1,
    "last": true,
    "size": 10,
    "number": 0,
    "sort": {
        "empty": true,
        "unsorted": true,
        "sorted": false
    },
    "numberOfElements": 1,
    "first": true,
    "empty": false
}
```
> 200 OK
## Get Entity by UUID

*Request:*

`localhost/author/1a875548-9db7-4dc3-acfb-e51496d51689`

*Response:*
```json
{
    "id": "1a875548-9db7-4dc3-acfb-e51496d51689",
    "createDate": "2023-02-08T18:09:06.450002",
    "version": 0,
    "name": "Author1",
    "lastname": "lastname",
    "birthYear": 2021
}

```
> 200 OK
## Create new Entity

*Request:*

`localhost/author/`
> 


```json
{
    "name": "Author",
    "lastname": "lastname",
    "birthYear": 2021
}
```

*Response:*
```json
{
    "id": "011ce894-7595-4925-ac3e-6e0dcc559acf",
    "createDate": "2023-02-08T18:11:07.145052018",
    "version": 0,
    "name": "Author",
    "lastname": "lastname",
    "birthYear": 2021
}
```
> 201 Created
## Update Entity by UUID
*Request:*

`localhost/author/011ce894-7595-4925-ac3e-6e0dcc559acf`

```json
{
    "id": "011ce894-7595-4925-ac3e-6e0dcc559acf",
    "createDate": "2023-02-08T18:11:07.145052018",
    "version": 0,
    "name": "Author",
    "lastname": "newLastname",
    "birthYear": 2021
}
```

*Response:*
```json
{
    "id": "011ce894-7595-4925-ac3e-6e0dcc559acf",
    "createDate": "2023-02-08T18:11:07.145052018",
    "version": 1,
    "name": "Author",
    "lastname": "newLastname",
    "birthYear": 2021
}
```
> 200 OK
## Delete Entity by UUID and Version
*Request:*

`localhost/author/011ce894-7595-4925-ac3e-6e0dcc559acf`

*Response:*

> 200 OK

## Books controllers (`Book`, `Magazine`, `Newspaper`) have the same behavior. As example - book controller. 

## Get All Entities

*Request:*

`localhost/books/`

*Response:*

```json
{
    "content": [
        {
            "id": "47d37eeb-3e11-424f-b843-8bca2e740969",
            "createDate": "2023-02-08T18:21:00.925154",
            "version": 0,
            "title": "CREATE_DATE",
            "year": 9999,
            "authors": [
                {
                    "id": "1a875548-9db7-4dc3-acfb-e51496d51689",
                    "createDate": "2023-02-08T18:09:06.450002",
                    "version": 0,
                    "name": "Author1",
                    "lastname": "lastname",
                    "birthYear": 2021
                }
            ],
            "publisher": {
                "id": "d1ba15e7-d170-4f70-aee3-e92297136902",
                "createDate": "2023-02-08T18:19:44.726261",
                "version": 0,
                "name": "Greg",
                "country": "Urugway"
            }
        }
    ],
    "pageable": {
        "sort": {
            "empty": true,
            "unsorted": true,
            "sorted": false
        },
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 10,
        "paged": true,
        "unpaged": false
    },
    "totalPages": 1,
    "totalElements": 1,
    "last": true,
    "size": 10,
    "number": 0,
    "sort": {
        "empty": true,
        "unsorted": true,
        "sorted": false
    },
    "numberOfElements": 1,
    "first": true,
    "empty": false
}
```
> 200 OK
## Get Entity by UUID

*Request:*

`localhost/books/47d37eeb-3e11-424f-b843-8bca2e740969`

*Response:*
```json
{
    "id": "47d37eeb-3e11-424f-b843-8bca2e740969",
    "createDate": "2023-02-08T18:21:00.925154",
    "version": 0,
    "title": "CREATE_DATE",
    "year": 9999,
    "authors": [
        {
            "id": "1a875548-9db7-4dc3-acfb-e51496d51689",
            "createDate": "2023-02-08T18:09:06.450002",
            "version": 0,
            "name": "Author1",
            "lastname": "lastname",
            "birthYear": 2021
        }
    ],
    "publisher": {
        "id": "d1ba15e7-d170-4f70-aee3-e92297136902",
        "createDate": "2023-02-08T18:19:44.726261",
        "version": 0,
        "name": "Greg",
        "country": "Urugway"
    }
}

```
> 200 OK
## Create new Entity

*Request:*

`localhost/books/`
> 


```json
{
            "title": "CREATE_DATE",
            "year": 9999,
            "authors": [
                {
                    "createDate": "2022-11-13T01:25:12.202133",
                    "version": 0,
                    "name": "Author1",
                    "lastname": "lastname",
                    "birthYear": 2021
}
            ],
            "publisher": {
    "id": "d1ba15e7-d170-4f70-aee3-e92297136902",
    "createDate": "2023-02-08T18:19:44.726260774",
    "version": 0,
    "name": "Greg",
    "country": "Urugway"
}
}
```

*Response:*
```json
{
    "id": "47d37eeb-3e11-424f-b843-8bca2e740969",
    "createDate": "2023-02-08T18:21:00.925154456",
    "version": 0,
    "title": "CREATE_DATE",
    "year": 9999,
    "authors": [
        {
            "id": "1a875548-9db7-4dc3-acfb-e51496d51689",
            "createDate": "2022-11-13T01:25:12.202133",
            "version": 0,
            "name": "Author1",
            "lastname": "lastname",
            "birthYear": 2021
        }
    ],
    "publisher": {
        "id": "d1ba15e7-d170-4f70-aee3-e92297136902",
        "createDate": "2023-02-08T18:19:44.726260774",
        "version": 0,
        "name": "Greg",
        "country": "Urugway"
    }
}
```
> 201 Created
## Update Entity by UUID
*Request:*

`localhost/books/47d37eeb-3e11-424f-b843-8bca2e740969`

```json
{
    "id": "47d37eeb-3e11-424f-b843-8bca2e740969",
    "createDate": "2023-02-08T18:21:00.925154",
    "version": 0,
    "title": "CREATE_DATE_NEW",
    "year": 9999,
    "authors": [
        {
            "id": "1a875548-9db7-4dc3-acfb-e51496d51689",
            "createDate": "2023-02-08T18:09:06.450002",
            "version": 0,
            "name": "Author1",
            "lastname": "lastname",
            "birthYear": 2021
        }
    ],
    "publisher": {
        "id": "d1ba15e7-d170-4f70-aee3-e92297136902",
        "createDate": "2023-02-08T18:19:44.726261",
        "version": 0,
        "name": "Greg",
        "country": "Urugway"
    }
}
```

*Response:*
```json
{
    "id": "47d37eeb-3e11-424f-b843-8bca2e740969",
    "createDate": "2023-02-08T18:21:00.925154",
    "version": 1,
    "title": "CREATE_DATE_NEW",
    "year": 9999,
    "authors": [
        {
            "id": "1a875548-9db7-4dc3-acfb-e51496d51689",
            "createDate": "2023-02-08T18:09:06.450002",
            "version": 0,
            "name": "Author1",
            "lastname": "lastname",
            "birthYear": 2021
        }
    ],
    "publisher": {
        "id": "d1ba15e7-d170-4f70-aee3-e92297136902",
        "createDate": "2023-02-08T18:19:44.726261",
        "version": 0,
        "name": "Greg",
        "country": "Urugway"
    }
}
```
> 200 OK
## Delete Entity by UUID and Version
*Request:*

`localhost/books/47d37eeb-3e11-424f-b843-8bca2e740969`

*Response:*

> 200 OK


