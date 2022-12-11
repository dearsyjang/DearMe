<div align=center>
<img width="400" alt="image" src="https://user-images.githubusercontent.com/97591083/206917767-873d53c9-870a-4ebc-845a-46673fa7ae9f.png">
</div>

## 목차
- [기획배경](#기획배경)
- [프로젝트 소개](#프로젝트-소개)
- [프로젝트 기간](#프로젝트-기간)
- [주요 자료](#주요-자료)
- [팀원 소개](#팀원-소개)
- [설치](#설치)
- [ERD](#erd)
- [기능 소개](#기능-소개)
- [시스템 아키텍처](#시스템-아키텍처)
- [기술 스택](#기술-스택)
- [폴더 구조](#폴더-구조)

## 기획배경

- 청년취업난과 코로나블루의 대두로 우울감을 느끼는 청년들이 많아졌습니다. 하지만 현재 대한민국에서는 심리 치료와 상담에 대해 상대적으로 부정적인 시선과 인식이 많아 진입 장벽이 높습니다. 이에 일기를 통해 자신도 몰랐던 자신의 모습을 알아가고 비대면 화상 상담을 통해 청년 특히, 취업 준비생들이 심리적으로 안정을 찾는 데 도움이 되는 서비스를 기획하게 되었습니다.

## 프로젝트 소개

- 심리적으로 지친 취업 준비생들을 위한 WebRTC 기반 화상일기, 텍스트일기, 화상상담 등의 멘탈 케어 서비스 ❤️‍🩹

## 프로젝트 기간

- SSAFY 공통 웹기술 프로젝트 2022.07.05 ~ 2022.08.19 (7주)

## 주요 자료
- [NOTION🖋️](https://www.notion.so/Dear-Me-3f5087884137450a9570d15913d87fac)
- [FIGMA🎨](https://www.figma.com/file/axgyuL7MwNSIVYPm3B821z/D206?node-id=430%3A3589&t=VNkycd2vew1EyO3v-1)

## 팀원 소개

|   이름   |     [정윤해](https://github.com/JEONGYOONHAE)         |     [이기종](https://github.com/LeeKiJong)     |     [이상민](https://github.com/Sangmeeeee)     |     [강지명](https://github.com/rainbow77777)     |     [장수영](https://github.com/dearsyjang)     |     [최지상](https://github.com/)     |
| :------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
|  포지션  |                 Team Leader<br/>Front-end                 |         Back-end        |            Back-end<br/>        | Front-end| Front-end | Front-end |


## 설치

서비스를 사용하기 위해서는 다음과 같은 방법으로 실행합니다.<br/>
레포지토리를  clone 받습니다.

**[ BACK-END ]**

1. 백엔드를 실행합니다.

```

```

**[ FRONT-END ]**

1. frontend 폴더에서 pacakge.json에 정의된 패키지 및 모듈을 설치합니다.

```
npm install
```
2. 설치 완료 후, 프론트엔드를 실행합니다.
```
npm run serve
```

## ERD
<img width="800" src="https://user-images.githubusercontent.com/97591083/206917875-efe48738-ccd8-41b0-8bbb-4db3f7f297ab.png">

## 기능 소개

| 구분                             | 기능                           | 설명                                    |
| ---------------------------------------------------------------- | -------------------------------------------------------------- | --------------------------------------- |
| 회원                             | 회원가입<br/>로그인<br/>로그아웃 | - [취업준비생] 아이디, 비밀번호, 닉네임, 성별, 이메일, 전화번호, 생년월일 <br/> - [상담사] 아이디, 비밀번호, 닉네임, 성별, 전화번호, 이메일, 생년월일<br/>상담 전문분야, 주요 약력, 주요 자격증, 상담가격, 자기소개   |
| 일기                        | 영상 일기                   | -  OpenVidu Recording을 활용하여 10초~1분 영상 일기 녹화 <br/> - 녹화 시작, 녹화 정지, 녹화 영상 재생, 녹화 영상 저장, 녹화 영상 삭제 <br/> - Google STT를 활용하여 음성 텍스트 변환           |
| 일기                      | 텍스트 일기                    | - 일기 제목 및 내용 작성  |
| 감정 달력                  | 일기 조회                    | - 해당 날짜에 저장된 영상 일기 및 텍스트 일기 조회  |
| 감정 달력                  | 감정 분석                    | - Naver Sentiment를 활용해 STT된 영상 일기 및 텍스트 일기 감정 분석 <br/> - 감정이 표현된 부분 추출  |
| 감정 달력                  | 감정 달력                    | - 분석된 감정을 긍정, 중립, 부정 퍼센트화 <br/> - 날씨 이모티콘을 활용하여 나만의 감정 달력 커스텀 <br/> - 긍정🌈🌞🌤⛅🌥  중립☁  부정🌦🌧⛈🌩🌪 |
| 심리 상담 | 상담사 조회 | - 상담사 필터 및 즐겨찾기 <br/> [정렬] 별점 높은 순, 별점 낮은 순, 리뷰 많은 순, 리뷰 적은 순 <br/> [전문분야] 가족, 직장•진로, 연애•결혼, 자기이해 <br/> - 해당 상담사 정보 조회(전문분야, 주요약력, 주요 자격, 상담 가격, 상담 정보 등)|
| 심리 상담 | 상담 신청 | - 원하는 상담 일정 및 시간 선택 <br/> 상담 내용 작성 |
| 심리 상담 | 1:1 상담                      | - OpenVidu를 활용하여 상담사와 취업준비생 1:1 상담     |
| 심리 상담 | 그룹 상담                      | - OpenVidu를 활용하여 상담사와 다수의 취업준비생의 그룹 상담 |
| 심리 상담 | 상담 평가                      | - 상담 종료 후, 상담에 대한 별점과 리뷰 작성    |
| 상담 게시판 | 게시글                      | - 취업 준비생의 게시글 제목, 내용 작성, 수정, 삭제   |
| 상담 게시판 | 댓글                      | - 상담사의 댓글 작성 |
| 결제  | 카카오페이 결제                    | - 카카오페이를 활용해 포인트 충전 및 결제 |
| 마이페이지  | 상담사<br/>취업준비생                      | - [취업준비생] 프로필 사진, 포인트, 작성한 게시글, 그룹 상담방 <br/> - [상담사] 프로필 사진, 포인트, 리뷰, 오늘 상담일정 |


### 💛 회원


## 시스템 아키텍처
<img width="800" src="img_source/Untitled.png">

## 기술 스택

**[ FRONT-END ]**

- **Vue3**
- **JavaScript**
- **Noe.js 16.16.0**
- **HTML, CSS**
- **BootStrap 5.2.0**
- **Openvidu 2.22.0**

**[ BACK-END ]**

- **JAVA**
  - jdk 11
- **Spring Boot 2.7.2**
- **Zulu**
- **Docker 20.10.12**
- **Jenkins 2.346.2**
- **Nginx 1.23.1**
- **MariaDB 10.8.3**
- **Openvidu 2.22.0**

## 폴더 구조

**[ FRONT-END ]**

```
📁 frontend
├── 📁public
├── 📁src
│ ├── 📁api
│   └── 📄drf.js
│ ├── 📁assets
│   ├── 📁css
│   └── 📁images
│ ├── 📁router
│   ├──📄board.js
│   ├──📄calendar.js
│   ├──📄counseling.js
│   ├──📄counselingGroup.js
│   ├──📄counselingRequest.js
│   ├──📄counselingSchedule.js
│   ├──📄counselor.js
│   ├──📄group.js
│   ├──📄home.js
│   ├──📄index.js
│   ├──📄member.js
│   ├──📄mypage.js
│   ├──📄point.js
│   ├──📄textDiary.js
│   └──📄videoDiary.js
│ ├── 📁store
│   ├── 📁modules
│     ├──📄board.js
│     ├──📄bottombar.js
│     ├──📄counselingRequest.js
│     ├──📄counselingSchedule.js
│     ├──📄counselors.js
│     ├──📄group.js
│     ├──📄home.js
│     ├──📄member.js
│     ├──📄mypage.js
│     ├──📄textDiary.js
│     └──📄videoDiary.js
│   └──📄index.js
│ ├── 📁views
│   ├── 📁board
│   ├── 📁calendar
│   ├── 📁counseling-group
│   ├── 📁counseling-request
│   ├── 📁counseling
│   ├── 📁counselor
│   ├── 📁group
│   ├── 📁home
│   ├── 📁member
│   ├── 📁mypage
│   ├── 📁point
│   ├── 📁text-diary
│   ├── 📁video-diary
│   └── 📄HomeView.vue
│ ├──📄App.vue
│ └──📄main.js
├──📄babel.config.js
├──📄jsconfig.json
├──📄package-lock.json
├──📄package.json
└──📄vue.config.js
```



**[ BACK-END ]**

```
📁 Back
└── 📁demo
│ ├── 📁.mvn/wrapper
│ ├── 📁src/main
│   ├── 📁java/com/dearme/demo
│     ├── 📁domain
│       ├── 📁base/entity
│       ├── 📁board
│         ├── 📁controller
│         ├── 📁dto
│         ├── 📁entity
│         ├── 📁exception
│         ├── 📁repository
│         └── 📁service
│       ├── 📁counseling
│         ├── 📁controller
│         ├── 📁dto
│         ├── 📁entity
│         ├── 📁exception
│         ├── 📁repository
│         └── 📁service
│       ├── 📁counselingdocument
│         ├── 📁controller
│         ├── 📁dto
│         ├── 📁entity
│         ├── 📁exception
│         ├── 📁repository
│         └── 📁service
│       ├── 📁counselingroom
│         ├── 📁controller
│         ├── 📁dto
│         ├── 📁entity
│         ├── 📁exception
│         ├── 📁repository
│         └── 📁service
│       ├── 📁favorite
│         ├── 📁controller
│         ├── 📁dto
│         ├── 📁entity
│         ├── 📁exception
│         ├── 📁repository
│         └── 📁service
│       ├── 📁group
│         ├── 📁controller
│         ├── 📁dto
│         ├── 📁entity
│         ├── 📁exception
│         ├── 📁repository
│         └── 📁service
│       ├── 📁recordingroom
│         ├── 📁controller
│         ├── 📁dto
│         ├── 📁entity
│         ├── 📁exception
│         ├── 📁repository
│         └── 📁service
│       ├── 📁review
│         ├── 📁controller
│         ├── 📁dto
│         ├── 📁entity
│         ├── 📁exception
│         ├── 📁repository
│         └── 📁service
│       ├── 📁textdiary
│         ├── 📁controller
│         ├── 📁dto
│         ├── 📁entity
│         ├── 📁exception
│         ├── 📁repository
│         └── 📁service
│       ├── 📁user
│         ├── 📁controller
│         ├── 📁dto
│         ├── 📁entity
│         ├── 📁exception
│         ├── 📁repository
│         └── 📁service
│       ├── 📁videodiary
│         ├── 📁controller
│         ├── 📁dto
│         ├── 📁entity
│         ├── 📁exception
│         ├── 📁repository
│         └── 📁service
│     ├── 📁global
│       ├── 📁common
│       ├── 📁config
│       ├── 📁converter
│       ├── 📁exceptionhandler
│       ├── 📁qtype
│       ├── 📁scheduler
│       └── 📁util/jwt
│     ├── 📄DemoApplication.java
│   └── 📁resources
│ ├── 📄DockerFile
│ ├── 📄deploy.sh
│ ├── 📄docker-compose.blue.yml
│ ├── 📄docker-compose.green.yml
│ ├── 📄mvnw
│ ├── 📄mvnw.cmd
│ └──  📄pom.xml
```
