# 할일 목록 카드를 생성,수정,삭제,조회 하는 간단한 CRUD 적용 API

코틀린 언어를 사용한 간단한 CRUD기능이 들어가있는 API

## 기능

Card
- **createCard**: TO-DO-LIST 카드 생성
- **getCardList**: 전체 TO-DO-LIST 카드 조회
- **getCard**: ID를 기반으로 TO-DO-LIST 카드 조회 
- **updateCard**: ID를 기반으로 TO-DO-LIST 카드 수정
- **deleteCard**: ID를 기반으로 TO-DO-LIST 카드 삭제

User
- **signUp**: 사용자의 정보 생성
- **updateUserProfile** 사용자의 정보 수정



## 작동방식

- Client request -> @RequestMapping("/cards")하위의 요청을 CardController가 담당
- 요쳉이 맞는 비즈니스 로직 수행울 하는 cardService에서 비즈니스 로직 수행 후 cardRepository로 값을 저장
- 비즈니스 로직 수행이 끝난후 CardController가  DTO를 Status code와 함께 반환
- 반환된 dto형태를 dispatcher-Servlet이 Client에게 response


## 예외처리

domain하위에 exception 폴더를 만들어 예외처리와 관련된 코드를 작성했으며
RuntimeException을 상속받는 ModelNotFoundException class를 정의하여 예외처리가 어느 Model에서 발생했고 id값은 무엇인지 출력되게 함

 ModelNotFoundException를 전역적으로 처리하기 위해서 @RestControllerAdvice 어노테이션을 이용하여 GlobalExceptionHandler class가 전역적으로 처리할 수 있도록 설계함


## Clone the repository

1. **Clone the repository**:
    ```bash
    https://github.com/kotlin2024/SpartaToDoList.git
    ```


## Swagger로 테스트하기
```bash
 http://localhost:8080/swagger-ui/index.html
```
