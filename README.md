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
 - 클래스에 사용할 경우 내부의 모든 메소드의 매핑에 "/path"가 붙는다
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

# Fetch / Eager
 - Eager: 모든 데이터를 가지고 오는 것
 - Fetch: 요청한 것만 가져옴(Prefered)

# Default Fetch Type
 - @OneToOne : FetchType.EAGER
 - @OneToMany : FetchType.LAZY
 - @ManyToOne : FetchType.EAGER
 - @ManyToMany : FetchType.LAZY


# @Transactional
 - 자동으로 트랜잭션 처리
 - 

# @Repositoy
 - DAO implementations를 나타냄


# 리디릭팅

<% response.sendRedirect("customer/list"); %>

# @GetMapping, @PostMapping(스프링 4.3이상)
 - 기존에는 RequestMethod를 지정하는 방식(GET, POST)으로 할 수 있었다.
   RequestMapping(path="/path" method="RequestMethod.GET")
   이 방식으로 길어지므로 @GetMapping, @PostMapping과 같은 방식으로 간결하게 사용 가능하다
 
# Aspect Oriented Programming(AOP)
 - Cross-Cutting Concerns

# Aspect
 - Aspect can be reused at multiple locations


# Advice Type
 - Before advice: run before the method
 - After finally advice: run after the method(finally)
 - After returning advice: run after the method(success execution)
 - After throwing advice: run after the method(if exceptoin thrown)
 - After finally advice: run after the method(finally)
 - Around advice: run before and after method

# Weaving
 - advised object를 생성하여 aspect를 target object에 연결하는 것
 - Compile-time, run-time(slowest)

# AOP Framework
 - Spring AOP : 스프링에서 지원하는 것, 캐싱, 트랜잭션 등 스프링 구동에 필요한것 지원, run-time
 - AspectJ : 커스텀 AOP 지원 가능,


# AspectJ Weaver 다운로드 maven 주소
 - https://mvnrepository.com/artifact/org.aspectj/aspectjweaver

# AOP를 적용하는 시점
 - PointCut: A predicate expression for where advice should be applied, 조건이 맞을 때 advice가 적용된느 부분
 - execution(modifiers-pattern? return-type-pattern declaring-type-pattern? method-name-pattern(param-pattern) throws-pattern?)
   ?가 있는 것은 옵션으로 없어도 된다
 - *(whildcard, matches on everything)가 사용 가능하다

 
# Execution Pointcut Examples

 - @Before("execution(public void add*())") : add로 시작하는 모든 함수에 적용
 - @Before("execution(* * processCreditCard*())") : modifier에 상관 없이 리턴타입이 어떻든 processCreditCard로 시작하는 메소드에 적용

# AspectJ Parameter Pattern Wildcards
 - () : 파라미터 없음
 - (*) : 하나이상의 파라미터
 - (..) :  없거나 하나 이상의 파라미터

 - 예제:
@Before("execution(public void addAccount())")                                                                                                    
@Before("execution(void add*())")                                                                                                                 
@Before("execution(public void addAccount(..))") // 0개 또는 1개 이상의 모든 파라미터                                                                          
@Before("execution(* add*())") // 모든 리턴타입, add로 시작하는 모든 함수, 파라미터는 없음                                                                              
@Before("execution(void add*(Account))") // 파라미터가 전체 경로가 아니기 때문에 오류 발생                                                                              
@Before("execution(void add*(com.neighborpil.aopdemo.Account))") // Account파라미터 하나만 있는 함수이다                                                         
@Before("execution(void add*(com.neighborpil.aopdemo.Account, ..))") // Account 파라미터를 반드시 포함하고, 나머지 파라미터는 있어도 되고 없어도 됨                              
@Before("execution(* com.neighborpil.aopdemo.dao.*.*(..))") // 어떠한 modifier, 어떠한 리턴타입, com.neighborpil.aopdemo.dao패키지 내 어떠한 클래스 내에 어떠한 메소드, 어떠한 파라미터



# Pointcut Expression Param Type
 - @Before("execution(* addAccount(com.neighborpil.aopdemo.Account))") // com.neighborpil.aopdemo.Account는 파라미터의 타입이다

# Pointcut Expression을 재사용 하는 법
 1. creat a pointcut declaration
  @Pointcut("execution(* com.neighborpil.aopdemo.dao.*.*(..))") // 실제 pointcut expression
  private void forDaoPackage() {} // 포인트컷 선언 이름(forDaoPackage), 어떠한 이름이 올 수 있음

 2. apply pointcut declaration to advice(s)
  @Before("forDaoPackage()")
  public void beforeAddAccountAdvice() {
    ...
  }

# Combining Pointcut Expression
 - 결합해서 사용 가능
 - @Before("expressionOne() && expressionTwo()") // AND
 - @Before("expressionOne() || expressionTwo()") // OR
 - @Before("expressionOne() && !expressionTwo()") // NOT

@Pointcut("execution(* com.neighborpil.aopdemo.dao.*.*(..))")                   
private void forDaoPackage() {}                                                 
                                                                                
// create pointcut for getter methods                                           
@Pointcut("execution(* com.neighborpil.aopdemo.dao.*.get*(..))")                
private void getter() {}                                                        
                                                                                
// create pointcut for getter methods                                           
@Pointcut("execution(* com.neighborpil.aopdemo.dao.*.set*(..))")                
private void setter() {}                                                        
                                                                                
// create point: include package ...exclude getter/setter                       
@Pointcut("forDaoPackage() && !(getter() || setter())")                         
private void forDaoPackageNoGetterSetter() {}                                   
                                                                                
@Before("forDaoPackageNoGetterSetter()") //                                     
public void beforeAddAccountAdvice() {                                          
                                                                                
	System.out.println("\n=====> Executing @Before advice on addAccount()");    
	                                                                            
}                                                                               


# Ordering Aspects
 - add @Order(숫자) annotation
 - 클래스에 붙인다
 - 만약 동일한 숫자를 가지고 있다면? 같은 숫자 내부에서는 시스템에서 알아서 처리한다. 다른 숫자는 정렬순서대로 처리한다

@Order(1)
public class MyCloudLogAspect { ... }


# JoinPoint
 - 실제 실행되는 함수의 이름 및 파라미터에 접근하기 위한 것
   public void beforeMethodCAll(JoinPoint theJoinPoint) {}
 - MethodSignature: 함수 이름
 - joinPoint.getArgs() : 함수의 파라미터값

@Before("com.neighborpil.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()") //  
public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {                               
                                                                                           
	System.out.println("\n=====> Executing @Before advice on addAccount()");               
	                                                                                       
	// display the method signature                                                        
	MethodSignature methodSig = (MethodSignature)theJoinPoint.getSignature();              
	                                                                                       
	System.out.println("Method: " + methodSig);                                            
	                                                                                       
	// display method arguments                                                            
	                                                                                       
	// get args                                                                            
	Object[] args = theJoinPoint.getArgs();                                                
	                                                                                       
	// loop thru args                                                                      
	                                                                                       
	for(Object tempArgs : args) {                                                          
		System.out.println(tempArgs);                                                      
		                                                                                   
		if(tempArgs instanceof Account) {                                                  
			// downcast and print Account specific stuff                                   
			Account theAccount = (Account) tempArgs;                                       
			                                                                               
			System.out.println("account name: " + theAccount.getName());                   
			System.out.println("account level: " + theAccount.getLevel());                 
		}                                                                                  
	}                                                                                      
                                                                                           
}

# @AfterReturning Advice
 - 메서드가 성공적으로 호출되었을 때에 
 - 반환값(return value)를 가공할 필요가 있을 때 사용
 - returning="반환값을 담을 변수명"
   파라미터에 동일한 이름의 반환값 변수를 설정해야 한다
 - 함수를 바꾸면서 

// add a new advice for @AfterReturning on the findAccounts method                           
@AfterReturning(                                                                             
		pointcut="execution(* com.neighborpil.aopdemo.dao.AccountDAO.findAccounts(..))",     
		returning="result")                                                             // returning의 값과     
public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){     // List<Account>의 파라미터 변수명 result가 동일해야함
	                                                                                         
	// print out which method we are advising on                                             
	String method = theJoinPoint.getSignature().toShortString();                             
	System.out.println("\n=====>>>Executing @AfterReturning on method: " + method);          
	                                                                                         
	// print out the results of the method call                                              
	System.out.println("\n=====>>>Result is : " + result);                                   
	                                                                                         
	// let's post-process the data .. modify it                                              
	                                                                                         
	// convert the account names to uppercase                                                
	convertAccountNamesToUpperCase(result);                                                  
}                                                                                            
                                                                                             
private void convertAccountNamesToUpperCase(List<Account> result) {                          
	                                                                                         
	// loop through accounts                                                                 
	for(Account tempAccount : result) {                                                      
		                                                                                     
	// get uppercase version of name                                                         
	String theUpperName = tempAccount.getName().toUpperCase();                               
	                                                                                         
	// update the name on the account;                                                       
	tempAccount.setName(theUpperName);                                                       
	}                                                                                        
}                                                                                            


# @AfterThrowing Advice
 - main method의 exeception 호출 이전에 호출
 - Use Cases:
  + 예외처리 로깅
  + 예외 검사
  + Notify DevOps team via email or SMS

@AfterThrowing(                                                                               
		pointcut="execution(* com.neighborpil.aopdemo.dao.AccountDAO.findAccounts(..))",      
		throwing="theExc")                                                                    
public void afterThrowingFindAccountAdvice(                                                   
		JoinPoint theJoinPoint, Throwable theExc) {                                           
	                                                                                          
	// print out witch mehtod we are advising on                                              
	String method = theJoinPoint.getSignature().toShortString();                              
	System.out.println("\n=====>>>Executing @AfterThrowing on method: " + method);            
                                                                                              
	// log the exception                                                                      
	System.out.println("\n====> The exception is: " + theExc);                                
                                                                                              
} 

# @After(finally) Advice
 - main mehtod가 정상 호출 또는 Exception 발생에 상관업이 호출
 - Use Cases:
  + 예외처리 로깅
  + 예외 검사
 - 예외 자체에는 접근 불가능 (따라서 추가 예외처리 @AfterThrowing)정의 필요)
 - 로깅 처리하기에는 여기가 가장 좋음

@After("execution(* com.neighborpil.aopdemo.dao.AccountDAO.findAccounts(..))")       
public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {                 
	                                                                                 
                                                                                     
	// print out witch mehtod we are advising on                                     
	String method = theJoinPoint.getSignature().toShortString();                     
	System.out.println("\n=====>>>Executing @After(finally) on method: " + method);  
	                                                                                 
}

# @Arount Advice
 - 함수 호출 전후에 호출
 - Use Cases:
  + 예외처리 로깅
  + 예외 검사
  + Security
  + Pre-processing and Post-processing data
  + Instrumentation / profiling code : 구동 시간 체크
 - proceeding join point참조 가능, 

@Around("execution(* com.neighborpil.aopdemo.service.*.*(..))")                                
public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{   
	                                                                                           
	// print out witch mehtod we are advising on                                               
	String method = theProceedingJoinPoint.getSignature().toShortString();                     
	System.out.println("\n=====>>>Executing @Around on method: " + method);                    
	                                                                                           
	// get begin timestamp                                                                     
	long begin = System.currentTimeMillis();                                                   
	                                                                                           
	// now, let's execute the method                                                           
	Object result = theProceedingJoinPoint.proceed();                                          
	                                                                                           
	// get end timestamp                                                                       
	long end = System.currentTimeMillis();                                                     
	                                                                                           
	// compute duration and display it                                                         
	long duration = end - begin;                                                               
	System.out.println("\n=====" + duration / 1000.0 + "sec");                                 
	                                                                                           
	return result;                                                                             
}

# @Around Advice에서의 예외처리
 1. 자체적으로 처리가능

@Around("execution(* com.neighborpil.aopdemo.service.*.*(..))")                                
public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{   
	                                                                                           
	// print out witch mehtod we are advising on                                               
	String method = theProceedingJoinPoint.getSignature().toShortString();                     
	myLogger.info("\n=====>>>Executing @Around on method: " + method);                         
	                                                                                           
	// get begin timestamp                                                                     
	long begin = System.currentTimeMillis();                                                   
	                                                                                           
	// now, let's execute the method                                                           
	Object result = null;                                                                      
	try {                                                                                      
		result = theProceedingJoinPoint.proceed();                                             
	} catch (Throwable e) {                                                                    
		// got the exception                                                                   
		myLogger.warning(e.getMessage()); // 여기서 예외처리 하기 때문에 메인 메소드는 예외를 알지 못한다                
		                                                                                       
		//give user a custom message                                                           
		result = "Major Accident!, But no warries";                                            
	}                                                                                          
	                                                                                           
	                                                                                           
	// get end timestamp                                                                       
	long end = System.currentTimeMillis();                                                     
	                                                                                           
	// compute duration and display it                                                         
	long duration = end - begin;                                                               
	myLogger.info("\n=====" + duration / 1000.0 + "sec");                                      
	                                                                                           
	return result;                                                                             
}

 2. 다시 예외를 던질 수 있다

} catch (Throwable e) {                                                                     
	// got the exception                                                                    
	myLogger.warning(e.getMessage());
	                                                                                        
	//give user a custom message                                                            
	result = e; // 다시 예외를 던진다
}

#Maven
 - 프로젝트 관리 툴
 - 주로 build 및 의존성 관리에 사용

# Free Maven Sources
 - https://www.jrebel.com/blog/maven-cheat-sheet
 - http://maven.apache.org/guides/
 - https://www.sonatype.com/ebooks

# Standard Directory Structure

my-app-workspace
 - pom.xml
 ↓src
  ↓main
   -java : 자바 소드
   -resources : properties, config
   -webapp : jsp,css,js
  ↓test : unit test
   -java
   -resources
 -target : compied files

# Spring Security protects against Cross-Site Request Forgery(CSRF) - (c surf라고 읽음)
 - csrf란? 현재 로그인되어 있는 웹어플리케이션에 action을 하게 하는 공격
   ex: You are logged into your banking app
       Tricked into sending money to another person

 - csrf를 방어하기 위해서는 추가적인 인증 데이터 또는 토큰을 html폼에 추가해야 함
 - 방지법: 스프링 시큐리티를 적용하고, 어떠한 form에서도 form:form 사용
 - 웬만하면 GET보다 POST 사용
 - 만약 form:form을 사용하지 않으면, 수동으로 CSRF 토큰을 추가해주어야 한다

 <form action="..." method="POST>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
 </form>

# Restricting Access to Roles
 - configuration파일을 수정하면 된다
 - antMatcheres(<<add apth to match on>>).hasRole(<< authorized role >>)

# mysql JDBC 옵션
 - jdbc:mysql://localhost:3306/web_customer_tracker?allowPublicKeyRetrieval=true&amp;serverTimezone=Asia/Seoul&amp;characterEncoding=utf8&amp;useSSL=false

# jackson-databind에서 모르는 프로퍼티 무시하기
 - @JsonIgnoreProperties(ignoreUnknown=true)

# Http Response
 - 100-199 : Informational
 - 200-299 : Successful
 - 300-399 : Redirection
 - 400-499 : Client error
 - 500-599 : Server error

# MIME Content Types
 - The message format is described by MIME content type
 - Multipurpose Internet Mail-Extension
 - Basic Syntax: type/sub-type
 - Ex:
  + text/html, text/plain
  + application/json, application/xml

# RestApi테스트 툴
 - Postman: https://www.postman.com/downloads/

# 간단 JSON테스트 주소
 - http://teamaqua.github.io/JSONTest/
 - http://jsonplaceholder.typicode.com/

# 스프링부터 프로젝트 생성 사이트
 - https://start.spring.io/

 - 스피링 부트 스타터 리스트 
   https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-starter
# Spring boot component scan
 - Default scanning is fine if everything is under
   com.neighborpil.springboot.demo.myapp

 - 만약 다른 패키지가 있을 때에는 수동으로 설정해야 한다
   @SpringBootApplication(scanBeanPackage="com.neighborpil.springboot.demo.myapp", "org.acme.iot.utils")

# Spring Boot 주의점(Jar파일 생성시)
 - 스프링 레거시 프로젝트처럼 src/main/webapp디렉토리를 사용하지 말것
   이거는 War파일을 만들기 위해서 사용되는 것이기 때문에 Jar파일을 만들 때에 무시된다.
 - 스프링 부트는 pom.xml에서 parent로 버전을 관리한다.
   이를 통하여 하부 버전은 각각 관리 할 필요 없이 부모버전에 맞추어 호환성이 적용된 버전이 받아진다

# spring Boot Devtools
 - 소스 변경시 톰캣을 재시작하지 않고 바로 변경사항을 적용해준다
 - dependency
<!-- Add support for automatic reloading -->         
<dependency>                                         
	<groupId>org.springframework.boot</groupId>      
	<artifactId>spring-boot-devtools</artifactId>    
</dependency>

# spring boot actuator
 - dependency를 추가해주는 것 만으로도 restapi방식으로 서버 분석 툴을 추가해준다
 - dependency
<!-- Add support for actuator -->                           
<dependency>                                                
	<groupId>org.springframework.boot</groupId>             
	<artifactId>spring-boot-starter-actuator</artifactId>   
</dependency>
 - 모든 것을 보여주고 싶다면
   management.endpoints.web.exposure.include=*
 - 일부만 보여주고 싶다면
   

# JSON Formatter 크롬 확장 프로그램
 - https://chrome.google.com/webstore/detail/json-formatter/bcjindcccaagfpapjjmafapmmgkkhgoa/related


# spring boot 실행 방법
## 방법 1
  1. 프로젝트 워크스페이스 폴더로 이동
  2. 커맨드프롬프트 실행
  3. ./mvnw package 실행하여 패키지 생성
  4. cd target 하여 타겟 폴더로 이동
  5. java -jar **jar파일명**으로 실행
  6. 종료할 때는 Ctrl + C

## 방법2
  1. 프로젝트 워크스페이스 폴더로 이동
  2. 커맨드프롬프트 실행
  3. ./mvnw spring-boot:run  
  4. 종료할 때는 Ctrl + C

# Spring Boot 커스텀 properties 사용
 1. 기본적으로 src/main/resources/application.properties에 변수 적어 사용하면 된다
 2. java코드 내에서 @Value 어노테이션 붙여서 사용하면 됨
```
@Value("${coach.name})
private String CoachName;
```

## Spring boot common properties document
 - https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html#common-application-properties

## Spring boot properties group
 - Core
   + logging.level.org.springframework=DEBUG
   + logging.level.org.HIBERNATE=TRACE
   + logging.level.com/luv2code=INFO
   + logging.file=my-crazy-stuff.log
 - Web
   + server.port=7070
   + server.servlet.context-path=/my-silly-app
   + server.servlet.session.timeout=15m
 - Security
   + spring.security.user.name=tiger
   + spring.security.user.password=scott
 - Data
   + spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
   + spring.datasource.username=tiger
   + spring.datasource.password=scott
 - Actuator
   + management.endpoint.web.exposure.include=*
   + management.endpoint.web.exposure.exclude=beans,mappign
   + management.endpoint.web.base-path=/actuator
 - Integration
 - DevTools
 - Testing

## ※Logging level
 - Trace, Debug, Info, Warn, Error, Fatal, Off

## hibernate crud demo
 - 프로젝트 명 : 21-hivernate-with-service-demo

## JPA methods
 - merge: id == 0이면 save/insert 아니면 update

![image](https://user-images.githubusercontent.com/22423285/131589378-ec073192-d3d2-43c9-953a-afaf1768b07f.png)
 - 프로젝트 명: 22-jpa-cruddemo
       
#### ※bean이 2개일때 특정하는 법
 - @Qualifier로 특정
 - 첫글자는 대문자      
```
	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl")EmployeeDAO theEmployeeDAO) {
		
		employeeDAO = theEmployeeDAO;
	}
	    
```
## Spring Data JPA
 - https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details
 - 프로젝트명: 23-spring-data-jpa-cruddemo
 - 단순히 JpaRepository<T, ID> 클래스를 상속하는것 만으로 기본적인 DAO의 클래스들을 자동으로 구현해준다(findAll, delete, ...)

       
![image](https://user-images.githubusercontent.com/22423285/131757017-45793a69-7611-454c-aaba-6cee18f57fc2.png)


#### Java Optional
 - 명확하게 null값을 체크가 필요할 때에, Optional은 항상 null이 아니다.
 - 대신 안의 값이 null일수 있다
```
	@Override
	public Employee findById(int theId) {

		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		if(result.isPresent()) {
			theEmployee = result.get();
		} else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return theEmployee; 
	}	
```
	
## Spring Data REST
 - give me a REST CRUD implementation for Free
 - 프로젝트명: 24-spring-data-rest-cruddemo
 - 기본적으로 3가지가 필요하다.
  + 1. entity(Employee.class)
  + 2. JpaRepository: EmployeeRepository extends JpaRepository
  + 3. Maven POM dependency for: spring-boot-starter-data-rest
 - 기본 주소 바꾸기: resources/application.properties파일 내에 추가하면 된다.
	
```
#
# Spring Data REST properties
#
spring.data.rest.base-path=/magic-api	
```
	
![image](https://user-images.githubusercontent.com/22423285/131758630-853b2a3a-7f1b-41ea-b440-1c848c7d0b82.png)

![image](https://user-images.githubusercontent.com/22423285/131758722-4b7bef99-74e0-433c-8467-c05c885fd557.png)

 - maven에서 아래의 dependency를 추가만 하면 된다
	
![image](https://user-images.githubusercontent.com/22423285/131758788-f2844f04-091f-4e8c-8d72-d0ced2d37164.png)
	
![image](https://user-images.githubusercontent.com/22423285/131758823-d6bdd24e-c550-42de-9e4f-77f962ac8f88.png)

![image](https://user-images.githubusercontent.com/22423285/131759005-c8732d00-0f0e-4611-ac34-c7f479e29444.png)

![image](https://user-images.githubusercontent.com/22423285/131759162-0e18635c-c818-464f-af2d-572e2e91eb82.png)

```
		<!-- Add dependency for Spring Data REST -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-rest</artifactId>
		</dependency>	
```

 - 명명규칙에서 기본적으로 Entity명에 s를 붙인다. 하지만 영어의 불규칙 복수는 제대로 적용 X

![image](https://user-images.githubusercontent.com/22423285/131926475-64811c78-26c3-4696-898b-e84065be163d.png)

```

@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// no need to write any code at all
}
```
	
![image](https://user-images.githubusercontent.com/22423285/131926534-9ea99efa-2919-4dd2-8af8-481d6f186d35.png)

```
# application.properties에서
#
# Spring Data REST properties
#
spring.data.rest.base-path=/magic-api
spring.data.rest.default-page-size=3
```
=> 주소에서 http://localhost:8080/magic-api/employees?page=1&size=3 파라미터 붙이면 페이징 된다

![image](https://user-images.githubusercontent.com/22423285/131926574-423ed60d-0403-4f88-aa2a-7efdc20ea960.png)

![image](https://user-images.githubusercontent.com/22423285/131926602-70414e5e-8c7a-4955-98cf-9fc45f946020.png)

![image](https://user-images.githubusercontent.com/22423285/131926641-0263c397-3df1-477f-91a5-e4a8104d489e.png)

=> 주소에서 http://localhost:8080/magic-api/employees?sort=firstName,asc 하면 된다(오름차순)
http://localhost:8080/magic-api/employees?sort=firstName,desc (내림차순)
	
	

## Thymleaf
	
![image](https://user-images.githubusercontent.com/22423285/131929192-41223d38-081b-46c5-8854-fa35716eff26.png)

![image](https://user-images.githubusercontent.com/22423285/131929228-5787ed5f-d7a5-4b5e-b7b6-6d1579ea53fb.png)

 - jsp랑 비슷하다
 - jsp랑 다른점은 web 이외에 non-web enviroment 에서 사용 가능하다
	
![image](https://user-images.githubusercontent.com/22423285/131929327-bd6f04f5-666b-4e11-af86-fd959f136a96.png)

![image](https://user-images.githubusercontent.com/22423285/131929402-5a2c4dc4-7c5d-4ce2-aec2-0e58bc8bc5df.png)

![image](https://user-images.githubusercontent.com/22423285/131929441-a00212d2-a23b-4c11-9087-152b61f9f29f.png)

![image](https://user-images.githubusercontent.com/22423285/131929455-9a8d246b-389d-4bae-9da7-56f551ed6913.png)

![image](https://user-images.githubusercontent.com/22423285/131929494-e967be39-4936-4cca-bce4-1b16c9e59f42.png)

![image](https://user-images.githubusercontent.com/22423285/131929537-7b280071-b734-426b-bd82-99cef05d0831.png)

![image](https://user-images.githubusercontent.com/22423285/131929570-f05a6b03-1c50-463e-9f04-fee14d3087a0.png)

![image](https://user-images.githubusercontent.com/22423285/131929609-0cd8c204-dcd8-4ebe-8ea7-177c4477e185.png)

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
