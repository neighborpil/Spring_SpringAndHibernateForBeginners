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

### Default Baen ID
 - the class name, make first letter lower-case