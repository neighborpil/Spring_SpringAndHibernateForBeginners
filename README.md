# Spring_SpringAndHibernateForBeginners
Example Code


Official Site : Spring.io


### POJOs : Plain-Old-Java_Objects

### AOP : Aspect-Oriented_Programming

### Tomcat : tomcat.apache.org

### Eclipse : www.eclipse.org

### Spring ���̺귯�� �ٿ�ε� ������
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

### Eclipse���� FullPath�� ��� ���
 1. �ش��ϴ� Ŭ���� ������ ����.
 2. Ŭ���� �̸��� Ŭ���Ѵ�.
 3. Ŭ���� �̸��� ��Ŭ���Ͽ� "Copy Qualified Name"�� �����ϸ� ���簡 �ȴ�.

### Spring Bean
 - �ν��Ͻ��� ���� �ȴ�.
 - xml �Ǵ� annotaion�� ���Ͽ� ���Ǹ� �Ѵ�.
 - ApplicationContext�� ���Ͽ� ���� ����(getBean)�Ѵ�.
 - ������ ���� �������̽� ������ ��´�.
 - ���α׷� ���� �κп����� �������̽��� �Լ��� �����Ѵ�.
 - �̷��� �����ν� ���� �ڵ�� �������� �ʰ�, xml �Ǵ� annotation�� �ٲ����ν� ����� �ٲ� �� �ִ�.

### Dependency Injection(DI)
 
 - �������̽��� ����� �����صΰ�, �� ����� �����ϴ� Ŭ������ �����Ѵ�.
 - ����� ����ϴ� Ŭ���� ���� �������̽� ������ ������ �ΰ�, ������ �Ǵ� setter�� ���Ͽ� 
   �������̽��� ����� �����ϴ� ���� �ν��Ͻ��� �����Ѵ�.
 - �̸� ���Ͽ� OpenClosedPrinciple�� ��ų �� �ִ�.

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
 - ��� �޼��忡�� @Autowired annotation ��� ����
### Default Baen ID
 - the class name, make first letter lower-case

### Which spring injection type should I use?
 - Whatever you want. But stay consistent throughout your project.

### @Autowired�� ����� ���� ������
 - ���࿡  �����ϴ� Bean�� �Ѱ� �̻��̶�� Exception �߻��Ѵ�
 - @Qualifier("targetService")�� ���� Ư�� Bean�� �������־�� �Ѵ�.

### @Qualifier�� ������, Setter, Field Injection�� ���� ���� ��� �����ϴ�.

### Qualifier �ڿ� ���̹� ��Ģ
 - ù���ڰ� �ѱ��ڸ� �빮�ڸ� �ҹ��ڷ� ���� FortuneService => @Qualifier("fortuneService")
 - �α��� �̻��� �빮�ڷ� �����ϴ� ��� RESTService => @Qualifier("RESTService")

### Qualifier�� �����ڿ� ����ϴ� ���
 - �������� ù° �Ķ���ͷ� Ŭ�������� ������� �Ѵ�
 - Ex:

 @Autowired
 public TennisCoach(@Qualifier("randomFortuneService") FortuneService theFortuneService){ }

### Properties�� ������ �����ϴ� ���
 
 1. properties�� �� ����
  src/sport.properties

  foot.email=myEmail@email.com
  foo.team=SillyJava
 
 2. XML config file�� ���Ͽ� �о���̱�
  applicationContext.xml

  <context:property-placeholder location="classpath:sport.properties"/>

 3. �����ϱ�  
  @Value("@{foo.email}")
  private String email;


#Bean lifecycle(Annotation)
 - @Scope("prototype") �� ���� ������� �ٿ� �� ���ִ�
 - �⺻�����δ� �̱����̴�
 - ����(@PostConstruct), ����(@PreDestroy)�� ���� �޼��带 �����Ͽ� ������ ��ų �� �ִ�
 - ���� Prototype Scope�� ����� ��쿡�� @PreDestory�� ȣ����� �ʴ´�

#Spring Configuration with Java Code(no xml)
 - @Bean�� �ٿ��༭ �������� �ƴ� �Ϲ� �ڹ� Ŭ������ ���������� ��� �� �� �ֵ��� Wrap�ϴ� ���� �����ϴ�

#Properties ���
 - src/���� �ؿ� ������ ����(sport.properties)�� ����,
   @PropertySource("classpath:sport.properties")�� ���� �ϸ� Value���� �ܺο��� �ҷ��� ����ϴ� ���� �����ϴ�
 - ���� ����� Ŭ���� ������
   @Value("${foo.email}")
   private String emaili;
   �� ���� ������� ��� �����ϴ�
 - ���� ������ ���� 4.2 ���϶�� �Ʒ��� �޼ҵ带 @Configuration���Ͽ� �־��־�� �Ѵ�

@Bean
public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceHolderConfigurer() {
	return new PropertySourcesPlaceholderConfigurer();
}


# Component-Scan
 - <context:component-scan base-package="com.neighborpil.springdemo" />�� ���� ������ �ξ��� ���
   ���� ��Ű���� ��������� ��� �˻��Ѵ�

# @RequestMapping("/path")
 - Ŭ������ ����� ��� ������ ��� �޼ҵ��� ���ο� "/path"�� �ٴ´�
 - �޼ҵ忡 ����Ͽ� �ּҿ� �����Ѵ�

# @RequestParam("variableName") String name
 - form�� input�� ������ ���ε� ��Ų��.
 - jsp�������� input�±��� name�� ��Ʈ�ѷ� �� �Լ��� variableName�� ���ƾ� �Ѵ�.

# Spring MVC FormTag
 - Taglib�� �ٿ��־�� �Ѵ�
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

 - form:form : ���� �� �����̳�
 - form:input : text field
 - form:textarea : ��Ƽ���� �ؽ�Ʈ �ʵ�
 - form:checkbox(es) : üũ�ڽ�
 - form:radiobutton(s) : ���� ��ư
 - form:select : ����ٿ��Ʈ

# Jstl
 - <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> �� ��忡 
 - <c:forEach var="temp" items="${operatingSystemOptions}">
     <li>${temp}</li>
   </c:forEach>

# Validation Annotations
 - @NotNull
 - @Min: Must be a number >= value
 - @Max: Must be a number <= value
 - @Size: Size must match the given size
 - @Pattern: ���ԽĿ� ��ġ
 - @Future / @Past : Date must be in future or past of given date

# Spring MVC Validation
 - Annotation Validator
 - http://hibernate.org/validator/
 - Spring MVC Validation�� ����� ���, BindingResult �Ķ������ ��ġ�� �ݵ�� ModelAttribute �Ķ���� �ڿ� ��ġ�ؾ� �Ѵ�.

# @InitBinder
 - ������ ���ָ� �ش� ��Ʈ�ѷ� ���� �޼ҵ���� ȣ��� ���� �Ķ���Ͱ� ���� �յڷ� Trim�Ǿ� ȣ��ȴ�

```
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
```

# Ŀ���� ���� �޽��� �����ֱ�

 - �ڹ� src���� �ؿ� resources ���丮�� �����ϰ�
 - messages.properties ������ �����Ѵ�.
 - �� �ȿ� typeMismatch.customer.freePasses=Invalid Number   ��� �����ش�

```
	<!-- Load custom message resources -->	
	<bean id="messageSource"
		class="org.springframework.context.support.ResourceBundleMessageSource">
		<property name="basenames" value="resources/messages" />	
	</bean>
```

# Validation ����

```
	@NotNull(message="��(��) �ʿ��մϴ�.")
	@Size(min=1, message="��(��) �ʿ��մϴ�.")
	private String lastName;
	
	@NotNull(message="��(��) �ʿ��մϴ�")
	@Min(value=0, message="0���� ū ���� �Է��� �ּ���.")
	@Max(value=10, message="10���� ���� ���� �Է��� �ּ���.")
	private Integer freePasses;
	
	@NotNull(message="��(��) �Է��� �ּ���.")
	@Pattern(regexp="^[\\w]{5}", message="5�ڸ��� ���� �Ǵ� ���ڸ� �Է��� �ּ���.")
	private String postalCode;

```


# CustomValidator
 - @interface�� ����

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

 - ConstraintValidator�� ����

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

 - ���

```

//	@CourseCode
	@CourseCode(value="ENG", message="CourseCode should start with ENG")
	private String courseCode;

```


# Object-To-Relational Mapping(ORM)
 - �ڹ� ��ü�� DB ���̺��� ��Ī���� �ش�
 - �������� ���� ���� �� �ִ�

# Hibernate ORM �ٿ�ε� ������
 - http://hibernate.org/orm/

# Entity Class
 - database�� ���ε� �ڹ� Ŭ����

# Fetch / Eager
 - Eager: ��� �����͸� ������ ���� ��
 - Fetch: ��û�� �͸� ������(Prefered)

# Default Fetch Type
 - @OneToOne : FetchType.EAGER
 - @OneToMany : FetchType.LAZY
 - @ManyToOne : FetchType.EAGER
 - @ManyToMany : FetchType.LAZY


# @Transactional
 - �ڵ����� Ʈ����� ó��
 - 

# @Repositoy
 - DAO implementations�� ��Ÿ��


# ������

<% response.sendRedirect("customer/list"); %>

# @GetMapping, @PostMapping(������ 4.3�̻�)
 - �������� RequestMethod�� �����ϴ� ���(GET, POST)���� �� �� �־���.
   RequestMapping(path="/path" method="RequestMethod.GET")
   �� ������� ������Ƿ� @GetMapping, @PostMapping�� ���� ������� �����ϰ� ��� �����ϴ�
 
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
 - advised object�� �����Ͽ� aspect�� target object�� �����ϴ� ��
 - Compile-time, run-time(slowest)

# AOP Framework
 - Spring AOP : ���������� �����ϴ� ��, ĳ��, Ʈ����� �� ������ ������ �ʿ��Ѱ� ����, run-time
 - AspectJ : Ŀ���� AOP ���� ����,

# AspectJ Weaver �ٿ�ε� maven �ּ�
 - https://mvnrepository.com/artifact/org.aspectj/aspectjweaver

# AspectJ Parameter Pattern Wildcards
 - () : �Ķ���� ����
 - (*) : �ϳ��̻��� �Ķ����
 - (..) :  ���ų� �ϳ� �̻��� �Ķ����

 - ����:
@Before("execution(public void addAccount())")                                                                                                    
@Before("execution(void add*())")                                                                                                                 
@Before("execution(public void addAccount(..))") // 0�� �Ǵ� 1�� �̻��� ��� �Ķ����                                                                          
@Before("execution(* add*())") // ��� ����Ÿ��, add�� �����ϴ� ��� �Լ�, �Ķ���ʹ� ����                                                                              
@Before("execution(void add*(Account))") // �Ķ���Ͱ� ��ü ��ΰ� �ƴϱ� ������ ���� �߻�                                                                              
@Before("execution(void add*(com.neighborpil.aopdemo.Account))") // Account�Ķ���� �ϳ��� �ִ� �Լ��̴�                                                         
@Before("execution(void add*(com.neighborpil.aopdemo.Account, ..))") // Account �Ķ���͸� �ݵ�� �����ϰ�, ������ �Ķ���ʹ� �־ �ǰ� ��� ��                              
@Before("execution(* com.neighborpil.aopdemo.dao.*.*(..))") // ��� modifier, ��� ����Ÿ��, com.neighborpil.aopdemo.dao��Ű�� �� ��� Ŭ���� ���� ��� �޼ҵ�, ��� �Ķ����



# Pointcut Expression Param Type
 - @Before("execution(* addAccount(com.neighborpil.aopdemo.Account))") // com.neighborpil.aopdemo.Account�� �Ķ������ Ÿ���̴�

# Pointcut Expression�� ���� �ϴ� ��
 1. creat a pointcut declaration
  @Pointcut("execution(* com.neighborpil.aopdemo.dao.*.*(..))") // ���� pointcut expression
  private void forDaoPackage() {} // ����Ʈ�� ���� �̸�(forDaoPackage), ��� �̸��� �� �� ����

 2. apply pointcut declaration to advice(s)
  @Before("forDaoPackage()")
  public void beforeAddAccountAdvice() {
    ...
  }

# Combining Pointcut Expression
 - �����ؼ� ��� ����
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
 - add @Order(����) annotation
 - Ŭ������ ���δ�
 - ���� ������ ���ڸ� ������ �ִٸ�? ���� ���� ���ο����� �ý��ۿ��� �˾Ƽ� ó���Ѵ�. �ٸ� ���ڴ� ���ļ������ ó���Ѵ�

@Order(1)
public class MyCloudLogAspect { ... }


# JoinPoint
 - ���� ����Ǵ� �Լ��� �̸� �� �Ķ���Ϳ� �����ϱ� ���� ��
   public void beforeMethodCAll(JoinPoint theJoinPoint) {}
 - MethodSignature: �Լ� �̸�
 - joinPoint.getArgs() : �Լ��� �Ķ���Ͱ�

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
 - �޼��尡 ���������� ȣ��Ǿ��� ���� 
 - ��ȯ��(return value)�� ������ �ʿ䰡 ���� �� ���
 - returning="��ȯ���� ���� ������"
   �Ķ���Ϳ� ������ �̸��� ��ȯ�� ������ �����ؾ� �Ѵ�
 - �Լ��� �ٲٸ鼭 

// add a new advice for @AfterReturning on the findAccounts method                           
@AfterReturning(                                                                             
		pointcut="execution(* com.neighborpil.aopdemo.dao.AccountDAO.findAccounts(..))",     
		returning="result")                                                             // returning�� ����     
public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){     // List<Account>�� �Ķ���� ������ result�� �����ؾ���
	                                                                                         
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
 - main method�� exeception ȣ�� ������ ȣ��
 - Use Cases:
  + ����ó�� �α�
  + ���� �˻�
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
 - main mehtod�� ���� ȣ�� �Ǵ� Exception �߻��� ������� ȣ��
 - Use Cases:
  + ����ó�� �α�
  + ���� �˻�
 - ���� ��ü���� ���� �Ұ��� (���� �߰� ����ó�� @AfterThrowing)���� �ʿ�)
 - �α� ó���ϱ⿡�� ���Ⱑ ���� ����

@After("execution(* com.neighborpil.aopdemo.dao.AccountDAO.findAccounts(..))")       
public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {                 
	                                                                                 
                                                                                     
	// print out witch mehtod we are advising on                                     
	String method = theJoinPoint.getSignature().toShortString();                     
	System.out.println("\n=====>>>Executing @After(finally) on method: " + method);  
	                                                                                 
}

# @Arount Advice
 - �Լ� ȣ�� ���Ŀ� ȣ��
 - Use Cases:
  + ����ó�� �α�
  + ���� �˻�
  + Security
  + Pre-processing and Post-processing data
  + Instrumentation / profiling code : ���� �ð� üũ
 - proceeding join point���� ����, 

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

# @Around Advice������ ����ó��
 1. ��ü������ ó������

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
		myLogger.warning(e.getMessage()); // ���⼭ ����ó�� �ϱ� ������ ���� �޼ҵ�� ���ܸ� ���� ���Ѵ�                
		                                                                                       
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

 2. �ٽ� ���ܸ� ���� �� �ִ�

} catch (Throwable e) {                                                                     
	// got the exception                                                                    
	myLogger.warning(e.getMessage());
	                                                                                        
	//give user a custom message                                                            
	result = e; // �ٽ� ���ܸ� ������
}

#Maven
 - ������Ʈ ���� ��
 - �ַ� build �� ������ ������ ���

# Free Maven Sources
 - https://www.jrebel.com/blog/maven-cheat-sheet
 - http://maven.apache.org/guides/
 - https://www.sonatype.com/ebooks

# Standard Directory Structure

my-app-workspace
 - pom.xml
 ��src
  ��main
   -java : �ڹ� �ҵ�
   -resources : properties, config
   -webapp : jsp,css,js
  ��test : unit test
   -java
   -resources
 -target : compied files

# Spring Security protects against Cross-Site Request Forgery(CSRF) - (c surf��� ����)
 - csrf��? ���� �α��εǾ� �ִ� �����ø����̼ǿ� action�� �ϰ� �ϴ� ����
   ex: You are logged into your banking app
       Tricked into sending money to another person

 - csrf�� ����ϱ� ���ؼ��� �߰����� ���� ������ �Ǵ� ��ū�� html���� �߰��ؾ� ��
 - ������: ������ ��ť��Ƽ�� �����ϰ�, ��� form������ form:form ���
 - �����ϸ� GET���� POST ���
 - ���� form:form�� ������� ������, �������� CSRF ��ū�� �߰����־�� �Ѵ�

 <form action="..." method="POST>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
 </form>

# Restricting Access to Roles
 - configuration������ �����ϸ� �ȴ�
 - antMatcheres(<<add apth to match on>>).hasRole(<< authorized role >>)

# mysql JDBC �ɼ�
 - jdbc:mysql://localhost:3306/web_customer_tracker?allowPublicKeyRetrieval=true&amp;serverTimezone=Asia/Seoul&amp;characterEncoding=utf8&amp;useSSL=false