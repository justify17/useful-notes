# useful-notes

## Java
### Common
1. Преобразование InputStream в ByteArrayOutputStream [Solution.java](/java/common/Solution1.java)
### Json
1. Валидация JSON по JSON схеме [Solution.java](/java/json/Solution1.java)  
Используемая библиотека: https://github.com/networknt/json-schema-validator
## GIT
### Commands for transport
![git-transport](https://github.com/justify17/useful-notes/assets/94614929/75854402-6051-480f-a863-6a0eb2b39c0c)
### Подключение локального проекта к удаленному GIT репозиторию
git init  
git add .  
git commit -m 'Init'  
git remote add origin https://github.com/justify17/useful-notes; Где: origin - псевдоним удаленного репозитория(может быть любым другим); https://github.com/justify17/useful-notes - URL удаленного репозитория  
git pull origin main --allow-unrelated-histories   
git branch --set-upstream-to origin/main master    
git push origin HEAD:main
