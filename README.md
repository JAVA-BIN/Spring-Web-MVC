# Spring-Web-MVC
코드로 배우는 웹 프로젝트 (Book)
- JDK 1.8 version
- Tomcat 1.9 version (Intellij 의 smart tomcat used)
- Spring 5.0.7 version
- Servlet 3.1.0 version
- Maven Compile Option 1.8 version
- servlet-context.xml -> ServletConfig.java (spring과 관련)
- root-context.xml -> RootConfig.java (spring과 관련)
- web.xml -> WebConfig.java (tomcat과 관련)

## Spring MVC project
- Servlet/JSP -> MVC (Model2 : 화면과 로직을 분리) 
- root-context.xml로 사용하는 일반 Java 영역(POJO(Plain Old Java Object))과
- servlet-context.xml로 설정하는 Web 관련 영역을 같이 연동해서 구동
- 개발자는 직접적으로 HttpServletRequest / HttpServletResponse 등과 같이
  Servlet/JSP의 API를 사용할 필요성이 현저하게 줄어듭니다.(내부적으로 Servlet/JSP 사용)
- Front-Controller방식 : 모든 Request는 DispatcherServlet을 통하도록 설계

## 동작 방식
- root-context.xml에 정의된 객체(Bean)들은 스프링의 영역(context) 안에 생성되고,
  객체들 간의 의존성이 처리됩니다. root-context.xml이 처리된 후에 스프링 MVC에서 사용하는
  DispatcherServlet이라는 서블릿과 관련된 설정이 동작합니다.
- DispatcherServlet 클래스는 스프링 MVC 구조에서 가장 핵심적인 클래스
- DispatcherServlet에서 XmlWebApplicationContext를 이용해 servlet-context.xml을
  로딩하고 해석하기 시작합니다. 이 과정에서 root-context.xml에서 등록된 객체(Bean)들과 연동되게 됩니다.
  
## MVC Controller의 장점
- HttpServletRequest, HttpServletResponse를 거의 사용할 필요 없이 구현
- 다양한 타입의 파라미터, 리턴 타입 사용 가능
- GET, POST 방식 등 전송 방식에 대한 처리 어노테이션으로 가능
- 상속/인터페이스 방식 대신 어노테이션으로 설정 가능

## Annotation
- @InitBinder : 데이터를 변환하고자 할 때 문제가 생기는 경우에 자동으로 해결해줌
  - 예제 : SampleController -> initBinder
- @ModelAttribute는 강제로 전달받은 파라미터를 Model 담아서 전달하도록 할 때 사용에
  - 예제 : SampleController -> ex04
  
## ResponseEntity
- 스프링 MVC의 사상에서는 HttpServletRequest/HttpServletResponse를 대체하여 ResponseEntity를 통해 헤더 정보나 데이터 전달

## fileupload
- Servlet 2.5에서는 commons의 파일 업로드나 cos.jar을 이용해야 함
- Servlet 3.0(Tomcat 7.0) 이후에는 기본적으로 업로드 되는 파일을 처리할 수 있는 기능이 추가

## ControllerAdvice
- @ControllerAdvice는 AOP (Aspect Oriented Programming)을 이용하는 방식
  - AOP : 공통적인 관심사는 분리 하자는 개념