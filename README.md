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

### Default Baen ID
 - the class name, make first letter lower-case