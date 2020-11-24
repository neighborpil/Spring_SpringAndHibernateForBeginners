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
