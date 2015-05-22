# YotaTest #

# Тестовое задание для Yota #

## Описание ###
Веб-приложение для работы с XML-файлами

## Список вопросов ##
https://bitbucket.org/finnetrolle/yotatest/wiki/FAQ

## XML файлы для тестирования ##
Можно скачать тут https://bitbucket.org/finnetrolle/yotatest/downloads

## Демо ##
Демо доступно по адресу http://trollsmedjan.ru:8080/yotatest-1.0/#/
*(ВНИМАНИЕ! Сервер слабый, на нем крутится еще куча всего, так что он может внезапно уйти в отключку)*

## Установка и запуск ##

1) Клонировать репозиторий

```
#!bash

git clone https://finnetrolle@bitbucket.org/finnetrolle/yotatest.git
```

2) Перейти в папку с исходниками

```
#!bash

cd yotatest
```

3) Собрать проект с помощью maven

```
#!bash

mvn clean package
```

4) WAR файл будет находиться в папке yotatest/target