### Spring - boot 라이브러리

1. spring-boot-starter-web
   * spring-boot-starter-tomcat: 톰캣 (WAS)
   * spring-webmvc: 스프링 웹 MVC
2. spring-boot-starter-thymeleaf: 타임리프 템플릿 엔진(View)
3. spring-boot-starter(공통): 스프링 부트 + 스프링 코어 + 로깅
   * spring-boot
     * spring-core
   * spring-boot-starter-logging
     * logbak, slf4j

### 테스트 라이브러리

1. spring-boot-starter-test
   * junit: 테스트 프레임워크
   * mockito: 목 라이브러리
   * assertj: 테스트 코드를 좀 더 편하게 작성하게 도와주는 라이브러리
   * spring-test: 스프링 통합 테스트 지원







## View 환경 설정

* 스프링 부트가 제공하는 Welcome Page 기능
  * 'static/index.html'을 올려두면 Welcome Page 기능을 제공한다.
  * https://docs.spring.io/spring-boot/docs/2.3.7.RELEASE/reference/html/spring-boot-features.html#boot-features-spring-mvc-static-content









### @ResponseBody 사용원리

* `@ResponseBody` 어노테이션 사용시
  * HTTP 의 BODY에 문자 내용을 직접 반환한다.
  * `viewResolver` 대신 `HttpMessageConverter`가 동작하게 된다.
    * 기본 문자처리: `StringHttpMessageConverter`
    * 기본 객체처리: `MappingJackson2HttpMessageConverter`
  * byte 처리 등등 기타 여러 `HttpMessageConverter`가 기본으로 등록되어 있다.

