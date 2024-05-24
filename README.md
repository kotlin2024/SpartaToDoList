# 할일 목록 카드를 생성,수정,삭제,조회 하는 간단한 CRUD 적용 API

코틀린 언어를 사용한 간단한 CRUD기능이 들어가있는 API

## 기능

Card
- **createCard**: TO-DO-LIST 카드 생성
- **getCardList**: 전체 TO-DO-LIST 카드 조회
- **getCard**: ID를 기반으로 TO-DO-LIST 카드 조회 
- **updateCard**: ID를 기반으로 TO-DO-LIST 카드 수정
- **deleteCard**: ID를 기반으로 TO-DO-LIST 카드 삭제


Comment
- **createComment**: 생성된 카드에 댓글 생성
- **getComment**: 카드에 존재하는 댓글 조회 (완료여부를 기준으로 상단에 위치)
- **updateComment**: 비밀번호를 이용하여 댓글 수정
- **deleteComment**: 비밀번호를 이용하여 댓글 삭제

User
- **signUp**: 사용자의 정보 생성
- **updateUserProfile** 사용자의 정보 수정



## 부가기능

TO-DO-LIST 카드를 수정하려고 할때는 완료여부에 대해서 true,false를 입력받을 수 있으며 할일 목록을 다 완료했을 경우에는 완료여부가 true로 바꾸어 목록의 하단에 위치하게 하여
아직 완료되지 않은 카드목록이 상단에 위치하도록 함

댓글을 처음 생성할때 작성자 이름, 댓글내용, 비밀번호를 입력받게 되며 해당 비밀번호가 일치해야만 수정이나 삭제가 가능함



## 작동방식

- Client request -> @RequestMapping("/cards")하위의 요청을 CardController가 담당
- 요쳉이 맞는 비즈니스 로직 수행울 하는 cardService에서 비즈니스 로직 수행 후 cardRepository로 값을 저장
- 비즈니스 로직 수행이 끝난후 CardController가  DTO를 Status code와 함께 반환
- 반환된 dto형태를 dispatcher-Servlet이 Client에게 response


## 예외처리

domain하위에 exception 폴더를 만들어 예외처리와 관련된 코드를 작성했으며
RuntimeException을 상속받는 ModelNotFoundException class를 정의하여 예외처리가 어느 Model에서 발생했고 id값은 무엇인지 출력되게 함

 ModelNotFoundException를 전역적으로 처리하기 위해서 @RestControllerAdvice 어노테이션을 이용하여 GlobalExceptionHandler class가 전역적으로 처리할 수 있도록 설계함

비밀번호가 틀렸을경우에 StatusCode 400을 응답하기 위하여 incorrectPasswordException 추가

## Clone the repository

1. **Clone the repository**:
    ```bash
    https://github.com/kotlin2024/SpartaToDoList.git
    ```


## Swagger로 테스트하기
```bash
 http://localhost:8080/swagger-ui/index.html
```
