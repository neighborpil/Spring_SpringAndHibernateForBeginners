# Spring_SpringAndHibernateForBeginners
Example Code


Official Site : Spring.io


### POJOs : Plain-Old-Java_Objects

### AOP : Aspect-Oriented_Programming

### Tomcat : tomcat.apache.org

### Eclipse : www.eclipse.org

### Spring 라이브러리 다운로드 페이지
 - https://repo.spring.io/release/org/springframework/spring/


### Inversion of Control(IoC)
 - The approach of outsourcing the construction and management of objects.


### Spring Container
 - Primary functions
  - Create and manage objects(IoC)
  - Inject object's dependencies(DI)
 - Configuring Spring Container
  - XML(legacy)
  - Java Annotation
  - Java Source Code

### Spring Development Process
 1. Configure your Spring Beans
 2. Create a Spring Container
 3. Retrieve Beans from Spring Container

### Spring container is generically known as **ApplicationContext**

### Spring Bean
 - simply Java Object
 - Java Objects that are created by the Spring Container, then Spring refers to them as "Spring Beans"

### Eclipse에서 FullPath를 얻는 방법
 1. 해당하는 클래스 파일을 연다.
 2. 클래스 이름을 클릭한다.
 3. 클래스 이름을 우클릭하여 "Copy Qualified Name"을 선택하면 복사가 된다.

### Spring Bean
 - 인스턴스라 보면 된다.
 - xml 또는 annotaion을 통하여 정의를 한다.
 - ApplicationContext를 통하여 빈을 생성(getBean)한다.
 - 생성된 빈은 인터페이스 변수에 담는다.
 - 프로그램 실행 부분에서는 인터페이스의 함수를 실행한다.
 - 이렇게 함으로써 실제 코드는 변경하지 않고, xml 또는 annotation만 바꿈으로써 기능을 바꿀 수 있다.

### Dependency Injection(DI)
 
 - 인터페이스로 기능을 정의해두고, 그 기능을 구현하는 클래스를 생성한다.
 - 기능을 사용하는 클래스 내에 인터페이스 변수를 설정해 두고, 생성자 또는 setter를 통하여 
   인터페이스의 기능을 구현하는 실제 인스턴스를 설정한다.
 - 이를 통하여 OpenClosedPrinciple을 지킬 수 있다.

### Bean Scope
 - singleton: default
 - prototype: creates a new bean instance for each container requeset
 - request: scoped to an HTTP web request. Only used for web apps
 - session: scoped to an HTTP web session. Only used for web apps
 - global-session: scoped to a global HTTP web session. Only used for web apps

### Init and Destroy method
 - Method can have any access modifier(private, protected, public)
 - Method can have any return type. but I cannot capture the return value
 - Method cannot accept any arguments
 - For 'prototype' scope bean, Spring does not call the destroy-method.

### Spring Beans Using Java Annotation
 - XML configuration can be very vervose
 - minimize the XML configuration
 - mark @Component on class
 - mark @Autowired on Constructor or Method
   (After Spring 4.3, @Autowired annotation on constructor is no longer needed 
    if the target bean only defines on constructor to begin with.)
 - 어떠한 메서드에도 @Autowired annotation 사용 가능
### Default Baen ID
 - the class name, make first letter lower-case

### Which spring injection type should I use?
 - Whatever you want. But stay consistent throughout your project.

### @Autowired를 사용할 때의 주의점
 - 만약에  구현하는 Bean이 한개 이상이라면 Exception 발생한다
 - @Qualifier("targetService")와 같이 특정 Bean을 선택해주어야 한다.

### @Qualifier는 생성자, Setter, Field Injection과 같이 어디든 사용 가능하다.

### Qualifier 뒤에 네이밍 규칙
 - 첫글자가 한글자만 대문자면 소문자로 변경 FortuneService => @Qualifier("fortuneService")
 - 두글자 이상의 대문자로 시작하는 경우 RESTService => @Qualifier("RESTService")

### Qualifier를 생성자에 사용하는 경우
 - 생성자의 첫째 파라미터로 클래스명을 적어줘야 한다
 - Ex:

 @Autowired
 public TennisCoach(@Qualifier("randomFortuneService") FortuneService theFortuneService){ }

### Properties의 값들을 주입하는 방법
 
 1. properties에 값 기입
  src/sport.properties

  foot.email=myEmail@email.com
  foo.team=SillyJava
 
 2. XML config file을 통하여 읽어들이기
  applicationContext.xml

  <context:property-placeholder location="classpath:sport.properties"/>

 3. 주입하기  
  @Value("@{foo.email}")
  private String email;


#Bean lifecycle(Annotation)
 - @Scope("prototype") 와 같은 방식으로 붙여 줄 수있다
 - 기본적으로는 싱글톤이다
 - 생성(@PostConstruct), 종료(@PreDestroy)를 붙인 메서드를 정의하여 동작을 시킬 수 있다
 - 만약 Prototype Scope를 사용할 경우에는 @PreDestory가 호출되지 않는다

#Spring Configuration with Java Code(no xml)
 - @Bean을 붙여줘서 스프링이 아닌 일반 자바 클래스를 스프링에서 사용 할 수 있도록 Wrap하는 것이 가능하다

#Properties 사용
 - src/폴더 밑에 파일을 생성(sport.properties)해 놓고,
   @PropertySource("classpath:sport.properties")와 같이 하면 Value값을 외부에서 불러와 사용하는 것이 가능하다
 - 값의 사용은 클래스 내에서
   @Value("${foo.email}")
   private String emaili;
   와 같은 방식으로 사용 가능하다
 - 만약 스프링 버전 4.2 이하라면 아래의 메소드를 @Configuration파일에 넣어주어야 한다

@Bean
public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceHolderConfigurer() {
	return new PropertySourcesPlaceholderConfigurer();
}


# Component-Scan
 - <context:component-scan base-package="com.neighborpil.springdemo" />와 같이 설정해 두었을 경우
   하위 패키지도 재귀적으로 모두 검색한다

# @RequestMapping("/path")
 - 클래스에 상용할 경우 내부의 모든 메소드의 매핑에 "/path"가 붙는다
 - 메소드에 사용하여 주소에 매핑한다

# @RequestParam("variableName") String name
 - form의 input을 데이터 바인딩 시킨다.
 - jsp페이지의 input태그의 name과 컨트롤러 내 함수의 variableName이 같아야 한다.

# Spring MVC FormTag
 - Taglib를 붙여주어야 한다
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

 - form:form : 메인 폼 컨테이너
 - form:input : text field
 - form:textarea : 멀티라인 텍스트 필드
 - form:checkbox(es) : 체크박스
 - form:radiobutton(s) : 라디오 버튼
 - form:select : 드랍다운리스트

# Jstl
 - <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 를 헤드에 
 - <c:forEach var="temp" items="${operatingSystemOptions}">
     <li>${temp}</li>
   </c:forEach>

# Validation Annotations
 - @NotNull
 - @Min: Must be a number >= value
 - @Max: Must be a number <= value
 - @Size: Size must match the given size
 - @Pattern: 정규식에 일치
 - @Future / @Past : Date must be in future or past of given date

# Spring MVC Validation
 - Annotation Validator
 - http://hibernate.org/validator/
 - Spring MVC Validation을 사용할 경우, BindingResult 파라미터의 위치는 반드시 ModelAttribute 파라미터 뒤에 위치해야 한다.

# @InitBinder
 - 설정을 해주면 해당 컨트롤러 내의 메소드들이 호출될 때에 파라미터가 전부 앞뒤로 Trim되어 호출된다

```
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
```

# 커스텀 에러 메시지 보여주기

 - 자바 src폴더 밑에 resources 디렉토리를 생성하고
 - messages.properties 파일을 생성한다.
 - 그 안에 typeMismatch.customer.freePasses=Invalid Number   라고 적어준다

```
	<!-- Load custom message resources -->	
	<bean id="messageSource"
		class="org.springframework.context.support.ResourceBundleMessageSource">
		<property name="basenames" value="resources/messages" />	
	</bean>
```

# Validation 예제

```
	@NotNull(message="이(가) 필요합니다.")
	@Size(min=1, message="이(가) 필요합니다.")
	private String lastName;
	
	@NotNull(message="이(가) 필요합니다")
	@Min(value=0, message="0보다 큰 수를 입력해 주세요.")
	@Max(value=10, message="10보다 작은 수를 입력해 주세요.")
	private Integer freePasses;
	
	@NotNull(message="을(를) 입력해 주세요.")
	@Pattern(regexp="^[\\w]{5}", message="5자리의 숫자 또는 문자만 입력해 주세요.")
	private String postalCode;

```


# CustomValidator
 - @interface를 생성

```

@Constraint(validatedBy = CourseCodeContraintValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

	// define default course code
	public String value() default "CLS";
	
	// define default error message
	public String message() default "Must start with CLS";
	
	// define default groups
	public Class<?>[] groups() default {};
	
	// define default payloads
	public Class<? extends Payload>[] payload() default {};
}


```

 - ConstraintValidator를 구현

```

public class CourseCodeContraintValidator implements ConstraintValidator<CourseCode, String>{

	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode theCourseCode) {

			coursePrefix = theCourseCode.value();
	}


	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
		
		if(theCode == null) {
			return false;
		}
		
		return theCode.startsWith(coursePrefix);
	}
}

```

 - 사용

```

//	@CourseCode
	@CourseCode(value="ENG", message="CourseCode should start with ENG")
	private String courseCode;

```


# Object-To-Relational Mapping(ORM)
 - 자바 객체와 DB 테이블을 매칭시켜 준다
 - 쿼리문을 많이 줄일 수 있다

# Hibernate ORM 다운로드 페이지
 - http://hibernate.org/orm/

# Entity Class
 - database에 매핑된 자바 클래스
