# Docker Scripts

## Run PostgreSQL

### 스터디 멤버 DB
docker run -p 15432:5432 --name study-member -e POSTGRES_USER=ksug2019 -e POSTGRES_PASSWORD=keesun -e POSTGRES_DB=member -d postgres

### 스터디 키워드 DB
docker run -p 5432:5432 --name study-keyword -e POSTGRES_USER=ksug2019 -e POSTGRES_PASSWORD=keesun -e POSTGRES_DB=study -d postgres
