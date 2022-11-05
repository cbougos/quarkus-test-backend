echo "MONGO INIT COMMENCING IN 10!"
sleep 10
mongo --username root --password root_password --authenticationDatabase admin mongo-init.js
