# 웹 애플리케이션 서버
## 진행 방법
* 웹 애플리케이션 서버 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


# 단계별 요구사항
## Step 1 TDD 실습

- [x] RequestLine 파싱하기
   1. RequestLine을 파싱해 원하는 값을 가져올 수 있는 API를 제공해야 한다.
   2. RequestLine은 HTTP 요청의 첫번째 라인을 의미한다.

- [x] 요구사항 1 - GET 요청
   1. HTTP GET 요청에 대한 RequestLine을 파싱한다.
   2. 파싱하는 로직 구현을 TDD로 구현한다.
   3. 예를 들어 "GET /users HTTP/1.1"을 파싱하면 다음과 같은 결과를 얻을 수 있어야 한다.
   4. method는 GET
   5. path는 /users
   6. protocol은 HTTP
   7. version은 1.1

- [x] 요구사항 2 - POST 요청 HTTP POST 요청에 대한 RequestLine을 파싱한다.
   1. 파싱하는 로직 구현을 TDD로 구현한다.
   2. 예를 들어 "POST /users HTTP/1.1"을 파싱하면 다음과 같은 결과를 얻을 수 있어야 한다.
   3. method는 POST
   4. path는 /users
   5. protocol은 HTTP
   6. version은 1.1

- [x] 요구사항 3 - Query String 파싱
   1. HTTP 요청(request)의 Query String으로 전달되는 데이터를 파싱한다.
   2. 클라이언트에서 서버로 전달되는 데이터의 구조는 name1=value1&name2=value2와 같은 구조로 전달된다.
   3. 파싱하는 로직 구현을 TDD로 구현한다.
   4. Query String 예 - GET 요청   
      ```GET /users?userId=javajigi&password=password&name=JaeSung HTTP/1.1```

- [x] 요구사항 4 - enum 적용(선택)
   1. HTTP method인 GET, POST를 enum으로 구현한다.