# 혼밥러들을 위한 식사메이트 서비스

## 팀원 구성
<div align="center">

<div align="center">

| **이준석** |
| :------: | 
| [<img src="https://github.com/CafeCheckin/CafeCheckin/assets/56196986/422a81d3-b0b7-4b85-af31-a42a3c23c771" height=150 width=150> <br/> @JunRock](https://github.com/JunRock) |

</div>
</div>
<br>

## 개발 환경
- BACKEND : Spring Framework, Kotlin 1.9.24, Mysql, Spring Data Jpa, AWS ec2, AWS S3, Docker, Docker-compose, CI/CD, Nginx   <br>
- 버전 및 이슈관리 : Github, Github actions   <br>
---
## Layered-Architecture
```bash
.
├── build
│   ├── bootJarMainClassName
│   ├── kotlin
│   ├── lombok
│   └── tmp
├── build.gradle.kts
├── gradle
│   └── wrapper
├── gradlew
├── gradlew.bat
├── mealmate-api // Controller 모듈
│   ├── build
│   ├── build.gradle.kts
│   └── src
├── mealmate-common // 유틸 모듈
│   ├── build
│   ├── build.gradle.kts
│   └── src
├── mealmate-domain // 비즈니스 모듈
│   ├── build
│   ├── build.gradle.kts
│   └── src
├── mealmate-s3 // S3 업로드 모듈
│   ├── build
│   ├── build.gradle.kts
│   └── src
├── mealmate-storage // DAO 모듈
│   ├── build
│   ├── build.gradle.kts
│   └── src
└── settings.gradle.kts
```
---
## 주제
- 혼밥러들을 위한 식사메이트 서비스
---
## 요구사항
- 사용자는 회원가입시 원하는 식당 종류를 선택할 수 있다.
- 사용자가 원하는 식당을 선택할 수 있어야한다.
- 사용자는 원하는 식당의 게시글에 함께 식사할 사람을 구하는 글을 작성할 수 있어야한다.
 ---
## 참고사항 및 조건
- 모바일용으로도 배포
- 쪽지 보낼 때 이미 구해졌는지 확인
---

## DB구조도
![image](https://github.com/user-attachments/assets/7b2c42b9-4f91-48ca-941a-280687f25015)
