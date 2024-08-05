# K스타터

이 애플리케이션은 JHipster 7.9.3 기반으로 생성했습니다. 상세내용은 아래 링크 참조해주세요.
링크 : [https://www.jhipster.tech/documentation-archive/v7.9.3](https://www.jhipster.tech/documentation-archive/v7.9.3).

## 프로젝트 구조

`package.json` 에 정의되어 있는 npm 명령으로 실행하는것을 추천하지만 필수는 아닙니다.
하지만 `package.json` 으로 javadoc 을 생성하거나 docker 명령어가 포함되어 있어 편리합니다.
예를들어 서버 기동명령은 다음과 같습니다.

```npm
npm run app:start
```

백엔드 소스의 기본 경로는 `/src/*` 를 참조해주세요.

- `.yo-rc.json` - JHipster 설정 파일로 `generator-jhipster` 명령어 실행시 생성
- `.yo-resolve` (optional) - JHipster 설정 파일이 충돌되는 경우 사용 (# 키워드로 생략)
- `.jhipster/*.json` - JHipster 엔티티 설정 파일
- `/src/main/docker` - 어플리케이션 도커 설정 파일

## 개발하기

아래 명령어 실행시 dev 프로필로 애플리케이션이 실행됩니다.

```
./gradlew
```

For further instructions on how to develop with JHipster, have a look at [Using JHipster in development][].

### JHipster 제어 센터

JHipster 제어 센터로 백엔드 애플리케이션을 제어하는 기능을 제공합니다.
아래 명령어롷 docker 앱을 실행하면 [http://localhost:7419](http://localhost:7419) 로 접속가능합니다.

```
docker-compose -f src/main/docker/jhipster-control-center.yml up
```

## 운영 빌드하기

### Jar 패키징

다음 명령어로 Jar 패키지 빌드 :

```
./gradlew -Pprod clean bootJar
```

배포 완료 후 서버 실행 :

```
java -jar build/libs/*.jar
```

### War 패키징

다음 명령어로 War 로 패키지 빌드 :

```
./gradlew -Pprod -Pwar clean bootWar
```

## Testing

아래 명령어로 jacoco 테스트 실행 :

```
./gradlew test integrationTest jacocoTestReport
```

### 코드 품질 분석

code sonar 로 코드품질 분석 기능을 제공합니다.
다음 명령어 실행시 http://localhost:9001 로 접속할 수 있습니다.

```
docker-compose -f src/main/docker/sonar.yml up -d
```

추가정보: docker 설정파일에서 [src/main/docker/sonar.yml](src/main/docker/sonar.yml) 인증을 오프할 수 있습니다.
다음 명령어 실행시 코드분석 시작 :

```
./gradlew -Pprod clean check jacocoTestReport sonarqube
```

## Docker 를 활용하여 쉽게 개발하기

MariaDB 서버 실행 :

```
docker-compose -f src/main/docker/mariadb.yml up -d
```

MariaDB 서버 종료 :

```
docker-compose -f src/main/docker/mariadb.yml down
```

아래 명령어로 애플리케이션 전체 도커화 :

```
npm run java:docker
```

arm64 프로세스의 경우 다음 명령어로 도커화 :

```
npm run java:docker:arm64
```

이미지 생성 후 서버 실행:

```
docker-compose -f src/main/docker/app.yml up -d
```

## 지속적인 통합 (CI)

jhipster ci (`jhipster ci-cd`) 를 활용하여 CI 환경을 구성할 수 있습니다.

[jhipster homepage and latest documentation]: https://www.jhipster.tech
[jhipster 7.9.3 archive]: https://www.jhipster.tech/documentation-archive/v7.9.3
[using jhipster in development]: https://www.jhipster.tech/documentation-archive/v7.9.3/development/
[using docker and docker-compose]: https://www.jhipster.tech/documentation-archive/v7.9.3/docker-compose
[using jhipster in production]: https://www.jhipster.tech/documentation-archive/v7.9.3/production/
[running tests page]: https://www.jhipster.tech/documentation-archive/v7.9.3/running-tests/
[code quality page]: https://www.jhipster.tech/documentation-archive/v7.9.3/code-quality/
[setting up continuous integration]: https://www.jhipster.tech/documentation-archive/v7.9.3/setting-up-ci/
[node.js]: https://nodejs.org/
[npm]: https://www.npmjs.com/
