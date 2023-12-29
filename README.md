# useful-notes

## Java
### Common
1. Преобразование InputStream в ByteArrayOutputStream [Solution.java](/java/common/Solution1.java)
### Json
1. Валидация JSON по JSON схеме [Solution.java](/java/json/Solution1.java)  
Используемая библиотека: https://github.com/networknt/json-schema-validator
## GIT
### Полезные ссылки  
Различия между merge и rebase:  
https://medium.com/nuances-of-programming/%D0%B2%D0%BB%D0%B0%D0%B4%D0%B5%D0%B5%D1%88%D1%8C-merge-%D0%BE%D1%81%D0%B2%D0%BE%D0%B9-%D0%B8-rebase-412e36bddce2  
Основы GIT:  
https://git-scm.com/book/ru/v2
### Commands for transport
![git-transport](https://github.com/justify17/useful-notes/assets/94614929/75854402-6051-480f-a863-6a0eb2b39c0c)
### Подключение локального проекта к удаленному GIT репозиторию
#### Кейс 1: Удаленный GIT репозиторий был инициализирован(содержит README.md и т.п.):
git init  
git add .  
git commit -m 'Init'  
git remote add origin https://github.com/justify17/useful-notes; Где: origin - псевдоним удаленного репозитория; https://github.com/justify17/useful-notes - URL удаленного репозитория  
git pull origin main --allow-unrelated-histories
##### Удаленная и локальная ветки имеют одинаковые имена:
git branch --set-upstream-to origin/main main    
git push
##### Удаленная и локальная ветки имеют разные имена:
git branch --set-upstream-to origin/main master  
git config --local push.default upstream  
git push
#### Кейс 2: Удаленный GIT репозиторий не был инициализирован(является пустым):
git init  
git add .  
git commit -m 'Init'  
git remote add origin https://github.com/justify17/useful-notes; Где: origin - псевдоним удаленного репозитория; https://github.com/justify17/useful-notes - URL удаленного репозитория  
git push -u origin master
### Проблема после git commit без параметра -m  
Открывается текстовый редактор Vim и нам нужно ввести комментарий к коммиту:  
Нажимаем i  
Вводим комментарий  
Нажимаем Ctrl + o или Ctrl + c  
Вводим :wq  
Нажимаем Enter
