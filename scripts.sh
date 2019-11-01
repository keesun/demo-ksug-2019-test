# Docker Scripts

## Run PostgreSQL

### 개발용 멤버 DB
docker run -p 15432:5432 --name study-member -e POSTGRES_USER=ksug2019 -e POSTGRES_PASSWORD=keesun -e POSTGRES_DB=member -d postgres

### 개발용 스터디 DB
docker run -p 5432:5432 --name study-keyword -e POSTGRES_USER=ksug2019 -e POSTGRES_PASSWORD=keesun -e POSTGRES_DB=study -d postgres

### 테스트용 스터디 DB
docker run -p 11111:5432 --name test-study-keyword -e POSTGRES_USER=ksug2019 -e POSTGRES_PASSWORD=keesun -e POSTGRES_DB=study -d postgres
