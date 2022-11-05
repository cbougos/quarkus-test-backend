newVersion=$1
if [ -z "$newVersion" ]; then
  echo "Please specify the new version!"
  exit
fi
echo "New Version will be: $newVersion";

docker login

declare -a StringArray=("mongo-with-data" "backend-jvm" "backend-native-normal" "backend-native-micro" "backend-native-distroless" "backend-native-scratch" "backend-native-scratch-upx")

for val in "${StringArray[@]}"; do
   echo "Publishing: $val"
   docker-compose -p quarkus-test -f src/main/docker/docker-compose/docker-compose-"$val"-dockerfile.yml up --build -d
   docker-compose -p quarkus-test -f src/main/docker/docker-compose/docker-compose-"$val"-dockerfile.yml down
   docker tag cbougos/quarkus-test-"$val" cbougos/quarkus-test-"$val":"$newVersion"
   docker push cbougos/quarkus-test-"$val"
   docker push cbougos/quarkus-test-"$val":"$newVersion"
done

#docker-compose -p quarkus-test -f src/main/docker/docker-compose/docker-compose-mongo-with-data-dockerfile.yml up --build -d
#docker-compose -p quarkus-test -f src/main/docker/docker-compose/docker-compose-mongo-with-data-dockerfile.yml down
#docker tag cbougos/quarkus-test-mongo-with-data cbougos/quarkus-test-mongo-with-data:"$newVersion"
#docker push cbougos/quarkus-test-mongo-with-data
#docker push cbougos/quarkus-test-mongo-with-data:"$newVersion"
#
#docker-compose -p quarkus-test -f src/main/docker/docker-compose/docker-compose-backend-jvm-dockerfile.yml up --build -d
#docker-compose -p quarkus-test -f src/main/docker/docker-compose/docker-compose-backend-jvm-dockerfile.yml down
#docker tag cbougos/quarkus-test-backend-jvm cbougos/quarkus-test-backend-jvm:"$newVersion"
#docker push cbougos/quarkus-test-backend-jvm
#docker push cbougos/quarkus-test-backend-jvm:"$newVersion"
#
#docker-compose -p quarkus-test -f src/main/docker/docker-compose/docker-compose-backend-native-normal-dockerfile.yml up --build -d
#docker-compose -p quarkus-test -f src/main/docker/docker-compose/docker-compose-backend-native-normal-dockerfile.yml down
#docker tag cbougos/quarkus-test-backend-native-normal cbougos/quarkus-test-backend-native-normal:"$newVersion"
#docker push cbougos/quarkus-test-backend-native-normal
#docker push cbougos/quarkus-test-backend-native-normal:"$newVersion"
#
#docker-compose -p quarkus-test -f src/main/docker/docker-compose/docker-compose-backend-native-micro-dockerfile.yml up --build -d
#docker-compose -p quarkus-test -f src/main/docker/docker-compose/docker-compose-backend-native-micro-dockerfile.yml down
#docker tag cbougos/quarkus-test-backend-native-micro cbougos/quarkus-test-backend-native-micro:"$newVersion"
#docker push cbougos/quarkus-test-backend-native-micro
#docker push cbougos/quarkus-test-backend-native-micro:"$newVersion"
#
#docker-compose -p quarkus-test -f src/main/docker/docker-compose/docker-compose-backend-native-distroless-dockerfile.yml up --build -d
#docker-compose -p quarkus-test -f src/main/docker/docker-compose/docker-compose-backend-native-distroless-dockerfile.yml down
#docker tag cbougos/quarkus-test-backend-native-distroless cbougos/quarkus-test-backend-native-distroless:"$newVersion"
#docker push cbougos/quarkus-test-backend-native-distroless
#docker push cbougos/quarkus-test-backend-native-distroless:"$newVersion"
#
#docker-compose -p quarkus-test -f src/main/docker/docker-compose/docker-compose-backend-native-scratch-dockerfile.yml up --build -d
#docker-compose -p quarkus-test -f src/main/docker/docker-compose/docker-compose-backend-native-scratch-dockerfile.yml down
#docker tag cbougos/quarkus-test-backend-native-scratch cbougos/quarkus-test-backend-native-scratch:"$newVersion"
#docker push cbougos/quarkus-test-backend-native-scratch
#docker push cbougos/quarkus-test-backend-native-scratch:"$newVersion"
#
#docker-compose -p quarkus-test -f src/main/docker/docker-compose/docker-compose-backend-native-scratch-upx-dockerfile.yml up --build -d
#docker-compose -p quarkus-test -f src/main/docker/docker-compose/docker-compose-backend-native-scratch-upx-dockerfile.yml down
#docker tag cbougos/quarkus-test-backend-native-scratch-upx cbougos/quarkus-test-backend-native-scratch-upx:"$newVersion"
#docker push cbougos/quarkus-test-backend-native-scratch-upx
#docker push cbougos/quarkus-test-backend-native-scratch-upx:"$newVersion"
