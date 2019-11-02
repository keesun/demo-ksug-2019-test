# 빌드
./mvnw clean package -Dmaven.test.skip=true

# 도커 이미지 빌드
./mvnw clean compile jib:dockerBuild -P docker

# 도커 스크립트

## 개발용 멤버 DB
docker run -p 15432:5432 --name study-member -e POSTGRES_USER=ksug2019 -e POSTGRES_PASSWORD=keesun -e POSTGRES_DB=member -d postgres

## 개발용 스터디 DB
docker run -p 5432:5432 --name study-keyword -e POSTGRES_USER=ksug2019 -e POSTGRES_PASSWORD=keesun -e POSTGRES_DB=study -d postgres

## 테스트용 스터디 DB
docker run -p 11111:5432 --name test-study-keyword -e POSTGRES_USER=ksug2019 -e POSTGRES_PASSWORD=keesun -e POSTGRES_DB=study -d postgres

## 테스트용 멤버 BE 서버
docker run -itd --network=my-net -p 28081:18081 --name study-member-be -i study-member-be

