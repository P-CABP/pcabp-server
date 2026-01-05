# P-CABP Server

## 1. Application Setting

### 1.1 Java Installation

- Oracle OpenJDK 21 사용
- [OpenJDK](https://jdk.java.net/archive/) 에서 21.0.2 버전을 OS 에 맞게 설치
- `MacOS` ~/.zshrc 또는 ~/.bash_profile 에 아래 내용 추가

```
JAVA_HOME_21=/Library/Java/JavaVirtualMachines/openjdk-21.jdk/Contents/Home
JAVA_HOME=$JAVA_HOME_21
PATH=$PATH:$JAVA_HOME/bin
export JAVA_HOME
export PATH
```

- 수정된 파일 적용

```bash
$ source ~/.zshrc
```

- `Windows` 환경변수 설정
  - 시스템 속성 -> 고급 시스템 설정 -> 환경 변수 -> 시스템 변수 -> 새로 만들기
    - 변수 이름: `JAVA_HOME`
    - 변수 값: `C:\Program Files\Java\jdk-21.0.2` (설치 경로)
  - 시스템 변수 `Path` 편집 -> 새로 만들기
    - `%JAVA_HOME%\bin`

### 1.2 Git Clone

```bash
$ git clone https://github.com/P-CABP/pcabp-server.git
$ cd pcabp-server
```

### 1.3 Docker Compose

- [Docker Desktop](https://www.docker.com/products/docker-desktop/) 설치
- Docker Desktop 실행 후 Application Terminal 진입
- 프로젝트 루트 디렉토리로 이동
- Docker Compose 실행

```bash
$ cd pcabp-server
$ docker-compose up -d
```

### 1.4 Application Build & Run

- 터미널에서 프로젝트 루트 디렉토리로 이동
- Gradle 빌드 및 실행

```bash
$ ./gradlew build
$ ./gradlew bootRun
```

### 1.5 Swagger UI 접속

- 브라우저에서 아래 URL 접속
- http://localhost:8080/swagger-ui.html
