# 4JO
4JO test






프로젝트 개요 : 농장의 일은 온도와 습도같은 환경에 예민하게 반응한다.
               개발한 프로젝트의 어플리케이션으로 온도와 습도를 관련하여 농장을 편리하게 관리할 수 있도록 하기위해 제작을 결심했다.
               
프로젝트 소개: 안드로이드 App에 접속하여 회원가입을 진행 후 농장을 만들어 해당 농장의 온도,습도정보를 확인할 수 있다.
              온도의 따라 라즈베리파이에 연결된 Fan을 원격으로 동작시켜 온도를 낮출 수 있고, 
              그래프와 카메라를 이용하여 농장의 온도변화와 실시간 화면을 확인 할 수 있다.
              
              웹의 관리자 화면에서는 관리자 비밀번호를 입력 후 회원가입한 회원정보 리스트를 확인 할 수있다.
              회원정보리스트에서 회원정보를 수정 및 삭제 가능

      App기능  
                  1. 회원가입
                   - ID, password, password_confirm, nickname입력 후 회원가입
                     (primary key:ID, password = password_confirm, 모든 빈칸을 채워야 회원가입 가능)
                     (ID:최대 10글자 가능. password:최대 12글자 가능, nickname: 최대 3글자 가능)
                  2. DB에 실시간으로 저장된 온도,습도 정보 확인
                     (이상 수치 발생시 log저장 후 푸시알림 및 Fan 자동 작동)
                  3. 스위치 버튼 클릭 시 라즈베리파이에 연결된 DC모터를 이용하여 원격 Fan 수동 작동
                  4. 그래프를 통한 온도 확인
                  5. 라즈베리파이에 연결된 카메라를 통해서 실시간 농장확인
      
      웹 기능(관리자 화면)
                  1. 관리자 비밀번호 입력 후 Member list 출력 화면
                  2. Member list에서 회원정보 수정 및 삭제 가능
               
      Local에서 돌리기 위한 메뉴얼
                  1. 안드로이드 App : android client 폴더 - team4Android 실행 (Size=Picel 3XL, Minimum SDK=API 22:Android 5.1(Lollipop)) 
                  2. Spring boot: backend 폴더 - service 실행(intellij(Ultimate Version))
                    (본인의 AWS DB 주소 및 local ip주소 변경 후 RUN)
                  
                  
    #개발환경
        -Web
        * SERVER : TOMCAT 11.0
        * DATABASE : MariaDB(AWS EC2 RDS생성)
        * IDE : Intellij(Ultimate Version)
        * FrontEnd : Bootstrap, Javascript, HTML5, CSS3
        * Language & Framework : Java, Spring boot

        -App
        * Language & Framework : Kotlin , Anroid Studio
        * DATABASE : MariaDB             

        * Git & Sourcetree, Slack 메신저, oven 스토리 보드 활용

        * 하드웨어 - 라즈베리파이 3 Model
