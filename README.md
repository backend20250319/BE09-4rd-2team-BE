# 네이버 블로그 프로젝트

### DDD : https://miro.com/app/board/uXjVImFpKUE=/

### Figma: https://www.figma.com/design/8Nt7QRATRXUoyEid9wAEkL/BE09_4th_2team?node-id=0-1&t=RdBYcVvlFhlY9w50-1

## 개요

---

- ***프로젝트명***: 네이버 블로그 게시판 프로젝트
- ***프로젝트 기간***: 2025-06-19 ~ 2025-07-14
- ***팀원:*** 이혜빈, 이채희, 이주희, 임현우, 김지환
- ***참고 사이트*** : 네이버 블로그(https://section.blog.naver.com/OfficialBlog.naver?currentPage=1)

## **프로젝트 설명**

---

## **목표 및 범위**

---

이 프로젝트의 목표는 스프링 부트 구조를 이해하고, MSA를 통해 확장성과 유지보수성이 뛰어난
서비스를 구현하는 것이 목표입니다. 

RESTful API를 통해 **일관된 HTTP 기반으로한 인터페이스 사용을 이해하고,** Swagger와 Postman으로 API 명세 자동화 → **개발자 협업 및 테스트 용이성 확보한다**

## **타겟 사용자**

---

**🧑‍💼사용자 🧑‍🏫블로거 👤관리자**

## **주요 기능 목록**

---

| 기능 구분 | 주요 기능 설명 |
| --- | --- |
| 회원 기능 | 회원가입, 로그인/로그아웃, 비밀번호 찾기, 프로필 설정 |
| 블로그 홈 | 최신 글 목록, 인기 글, 카테고리별 글 보기, 검색 기능 |
| 글 작성/관리 | 글 작성, 수정, 삭제, 임시 저장, 발행 예약, 태그 설정 |
| 미디어 첨부 | 이미지, 동영상, 지도, 링크 첨부 기능 |
| 댓글 기능 | 댓글 작성, 수정, 삭제, 대댓글, 댓글 알림 |
| 이웃 기능 | 이웃 추가/삭제, 서로이웃 설정, 이웃 새 글 알림 |
| 블로그 디자인 | 스킨 선택, 위젯 설정, 프로필 영역 커스터마이징 |
| 통계 기능 | 방문자 수, 글 조회수, 유입 경로 분석 |
| 모바일 대응 | 반응형 UI, 모바일 전용 메뉴 및 글쓰기 지원 |
| 기타 기능 | 공감, 공유, 스크랩, 글 신고, 비공개 설정 등 |

이 기능들을 기준으로 프론트엔드와 백엔드 역할 배분

## **기술 스택**

---

| 서버 구성 | Spring Boot, Spring Security, JPA, Eureka, Gateway |
| --- | --- |
| 데이터베이스 | MySQL |
| 개발 도구 | IntelliJ IDEA, Postman, DevOps |
| API 문서화 도구 | springdoc-openapi 2.8.9(Swagger) |

## 담당 기능

---

| **이름** | **담당 서비스** | **주요 기능 예시** |
| --- | --- | --- |
| 이혜빈 | 회원 가입, 로그인, 로그아웃, 보안 인증 및 인가 | UI, 폼, 유효성 검사 / 서버 API, 인증, JWT, DB 연동 |
| 김지환 | 게시글 작성, 수정, 삭제 | 게시글 폼, 목록, 상세보기 / 게시글 CRUD, API, DB 연동 |
| 이주희 | 댓글 작성, 수정, 삭제 | 댓글 UI, 목록, 입력 / 댓글 CRUD, API, DB 연동 |
| 임현우 | 프로필, 마이페이지 수정 | 프로필 UI, 정보 수정 / 프로필 API, DB 연동 |
| 이채희 | 검색, 필터, 기타 기능 구현 | 검색 UI, 필터링 / 검색 API, DB 연동, 기타 부가 기능 |

## 주요 API

---

게시글 작성 API 명세

- **API 개요**
    - **URL**: `POST /api/posts`
    - **설명**: 사용자가 블로그 게시글을 작성합니다.
    - **요청 형식**: `application/json`
    - **응답 형식**: `application/json`
- **요청 (Request)**
    - **Endpoint**: `http://localhost:3000/api/posts`
    - **HTTP Method**: `POST`
- **Request Body 예시**

```jsx

{
  "title": "오늘의 브런치 맛집 리뷰",
  "content": "위치도 좋고 분위기도 최고였어요!",
  "tags": ["맛집", "카페", "브런치"],
  "images": ["image1.jpg", "image2.png"],
  "isPrivate": false
}
```

- **응답 예시 (Response)**

```jsx
{
  "status": "success",
  "data": {
    "postId": 123,
    "createdAt": "2025-06-19T09:00:00Z"
  }
}
```

| **필드명** | **타입** | **설명** |
| --- | --- | --- |
| `blogId` | string | 블로그의 고유 ID |
| `postId` | string | 게시글의 고유 ID |
| `title` | string | 게시글 제목 |
| `contents` | string | 게시글 본문 (HTML 포함) |
| `thumbnail` | string | 대표 이미지 URL |
| `tags` | string[] | 태그 목록 |
| `category` | string | 카테고리 이름 |
| `publishDate` | string | 게시일 (ISO 8601 형식: YYYY-MM-DDTHH:mm:ss) |
| `modifiedDate` | string | 수정일 |
| `visibility` | string | 공개 범위 (`PUBLIC`, `NEIGHBOR`, `PRIVATE`) |
| `commentCount` | number | 댓글 수 |
| `likeCount` | number | 공감 수 |
| `url` | string | 게시글 URL |

## 산출물

---

### MSA 아키텍처 설계서

<img width="751" height="626" alt="Image" src="https://github.com/user-attachments/assets/ca2b00c3-e9f5-45e8-9368-d6a41e6d1f02" />

---

### API 명세서

[https://www.notion.so/coffit23/API-224a02b1ffb180fb9ab7ec7a86e104ea](https://www.notion.so/API-224a02b1ffb180fb9ab7ec7a86e104ea?pvs=21)

---

### 테스트 케이스 + 테스트 결과서

[테스트 케이스+ 테스트 결과서]

https://docs.google.com/spreadsheets/d/1u56oi2BC_daUCej5LbtwuU7EEhu17qTYs92x-xUFBUg/edit?usp=sharing

---

## 회고록 (개발 후)

- 이채희 : 이번 프로젝트는 처음으로 백엔드와 프론트엔드를 결합하는 과정을 하다 보니 어려움이 많은 프로젝트였던 것 같다. 그리고 블로그 서비스 특성상 여러가지 기능이 결합되어 있다 보니, 각자가 맡은 엔티티를 연동하고, 또 API를 호출하고 연결하는 과정에 많은 어려움이 있었다. 또 하나의 테이블에 담긴 데이터를 여러 기능에서 같이 사용해야 하는 상황이 많았다 보니, 데이터에 변동이 있으면 잘 작동하던 기능도 갑자기 작동하지 않는 등, 수많은 트러블들과 싸웠던 프로젝트였던 것 같다. 무엇보다 예비군 훈련으로 인해 배포 과정을 함께 하지 못했던 것도 정말 아쉬움으로 남는다.  파이프라인 구축, 테스트, 배포 과정도 여러 트러블이 있었다고 들었는데, 그 과정 가운데 같이 문제를 해결하지 못한 것이 아쉬움으로 남았다.
- 이주희:
- 이혜빈 :

- 임현우 :

- 김지환 :

---

## 트러블 슈팅

|  |  | 문제 내용 | 현상 / 추정 원인 | 조치 사항 / 결과 |
| --- | --- | --- | --- | --- |
| 1 |  |  |  |  |
| 2 |  |  |  |  |
| 3 |  |  |  |  |
| 4 |  |  |  |  |
| 5 |  |  |  |  |
