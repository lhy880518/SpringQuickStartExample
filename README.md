# SpringQuickStartExample

## 프레임워크를 쓰는이유
* 프레임워크는 아키텍처와 골격코드를 제공한다.
* 빠른구현시간, 쉬운관리, 개발자들의 역량 획일화, 검증된 아키텍처의 재사용과 일관성 유지

## 스프링을 사용하는 이유
* EJB의 많은 단점 - 스펙 복잡, EJB컴포넌트를 만들어도 비싼 WAS가 필요하다.(여기서 EJB가 구리다고 이야기 하는게 아니다.)
* POJO(평범한 옛날 자바 객체)를 사용하면서도 EJB에서만 가능했던 많은 일을 가능하도록 지원한다.
    * 대표적인 Not POJO클래스가 Servlet클래스이다. 우리마음대로 만들 수 없으며 반드시 규칙에 맞게 클래스를 만들어야 한다.
        1. javax.servlet, javax.servlet.http 패키지를 import해야한다.
        2. public 클래스로 선언되어야 한다.
        3. Servlet, GenericServlet, HttpServlet 중 하나를 상속해야 한다.
        4. 기본생성자가 있어야 한다.
        5. 생명주기에 해당하는 메소드를 재정의 한다.

## 스프링 프레임워크 특징 - IOC와 AOP를 지원하는 경량의 컨테이너 프레임워크
* 경량 - 스프링은 여러개의 모듈로 구성되며 각모듈은 하나이상의 JAR파일만 있으면 개발과 실행이 모두 가능하다.
* 제어의 역행 - 낮은 결합도와 높은 응집도를 제어의 역행을 통해 유지한다.
* 관점지향 프로그래밍 AOP - 공통 로직을 분리함으로써 응집도가 높게 개발 할 수 있도록 지원한다.(횡단 관심사 분리)
* 컨테이너 - 특정 객체의 생성과 관리를 담당하며 객체 운용에 필요한 다양한 기능을 제공한다. (xml파일 혹은 어노테이션을 통한
제어역행 코드를 직접적으로 해석하아 객체 생성과 관리를 직접적으로 해준다는 말이다.)

## 예제 설명
### 의존성 주입을 통한 제어의 역행
![스크린샷 2019-05-15 오전 8 22 47](https://user-images.githubusercontent.com/24884819/57738488-adb11800-76ea-11e9-8c59-85a45496ecca.png)

* 위와같이 어노테이션을 통하여 의존성 주입을 도모 하였는데
    * @Service 어노테이션을 사용하여 boardService라는 이름으로 객체를 요청 할 수 있도록 아이디를 설정하였다.
    * boardService의 객체 요청과 동시에 BoardDAO타입 객체를 의존성 주입하기위해서 @Autowired를 사용했다.

![스크린샷 2019-05-15 오전 8 28 50](https://user-images.githubusercontent.com/24884819/57738708-8e66ba80-76eb-11e9-83d7-dea20c1b5cf6.png)

* 1번과 같이 스프링 컨테이너를 구동하고 빌드를 하게되면 아래와 같이 applicationContext.xml의 Component Scan을 통하여 BoardServiceImpl객체를 생성한. 

![스크린샷 2019-05-15 오전 8 35 21](https://user-images.githubusercontent.com/24884819/57738915-6af03f80-76ec-11e9-8f44-420a59502682.png)

* 처음 userServiceImpl의 경우에는 Setter를 통하여 UserDAO의존성 주입을 진행하였다.

![스크린샷 2019-05-15 오전 9 04 47](https://user-images.githubusercontent.com/24884819/57739984-a12fbe00-76f0-11e9-838e-0725e1df0c3e.png)

### AOP 개념 및 Xml 실습
* 조인트 포인트 : 모든 메소드를 조인 포인트 라고 하면 생각하기 편하다
* 포인트컷 : 필터링 된 조인포인트, 아래 그림과 같이 특정 포인트에서는 적용 제외를 시킨다거나 하기 위해 필터링 하는 방법 
![20170803_2](https://user-images.githubusercontent.com/24884819/57815169-49a55700-77b1-11e9-8fdb-057f10ae5480.jpg)

* 어드바이드 : 횡단관심에 해당하는 공통 기능의 코드를 의미한다. 독립된 클래스의 메소드로 작성된다.
* 위빙 : 포인트 컷으로 지정한 핵심 관심메소드가 호출될 때, 어드바이스에 해당하는 횡단 관심 메소드가 삽입되는 과정을 의미한다.스프링은 런타임 위빙만 지원
* aspect or advisor : 포인트 컷과 어드바이스의 결합으로써 AOP의 핵심이다. 어떤 포인트컷 메소드에 대해서 어떤 어드바이스 메소드를 실행할지 결정한다.

~~~
public class LogAdvice {
    public void printLog(){
        System.out.println("[공통로그] 비지니스 로직 수행 전 동작");
    }
}
~~~
~~~
<bean id="log" class="com.springbook.biz.common.LogAdvice"></bean>

<aop:config>
    <aop:pointcut id="allPointcut" expression="execution(* com.springbook.biz..*Impl.*(..))"/>
    <aop:pointcut id="getPointcut" expression="execution(* com.springbook.biz..*Impl.get*(..))"/>
    <aop:aspect ref="log">
        <aop:after pointcut-ref="getPointcut" method="printLog"/>
    </aop:aspect>
</aop:config>
~~~
1. getPointcut으로 설정한 포인트 컷 메소드가 호출될 때 
2. log라는 어드파이스 객체의 printLog() 메소드가 실행되고
3. 이때 pringLog()메소드의동작 시점이 aop:after라는 내용의 설정이다.  

![042316_0739_SpringAOP2](https://user-images.githubusercontent.com/24884819/57815670-4f03a100-77b3-11e9-9d25-4f60c78eed57.png)

1. 사용자는 시스템을 사용하면서 자연스럽게 조인트포인트를 호출하게된다.
2. 특정 포인트컷으로 지정한 메소드가 호출되는 순간
3. 어드바이스 객체의 어드바이스 메소드가 실행된다. 이 어드바이스 메소드 동작 시점을 5가지로 지정할 수 있으며
4. 포인트컷으로 지정한 메소드가 호출될 때, 어드바이스 메소드를 삽입하도록 하는 설정을 애스팩트라고 한다.
5. 이 애스팩트 설정에 따라 위빙이 처리된다.

### AOP 어노테이션 실습
~~~
<aop:aspectj-autoproxy></aop:aspectj-autoproxy>
~~~
* applicationContext.xml 수정 및 aop관련 어노테이션들은 어드바이스 클래스에 설정해야된다.
* 어드바이스 클래스에 선언된 어노테이션들을 스프링컨테이너가 처리하게 하려면, 반드시 어드바이스 객체가 생성되어 있어야 한다.
따라서 어드바이스 클래스는 반드시 스프링 설정파일에 bean으로 등록하거나 @Service어노테이션을 사용하여 컴포넌트가 검색 될 수 있도록 해야한다.

### Model1, Model2 실습 
* Model1 : DB연동 로직을 담당하는 Model을 제외하고 나머지 Controller, view 역할을 JSP에 포함시켜서 개발하는 방식
* Model2 : VO,DAO를 Model로 Servlet을 Controller로 View를 JSP로 표현하여 프로그램을 만드는 방식
* 프로그램이 커짐에 따라 Model2가 효율적 관리에 더 용이하다.

### MVC프레임워크 개발
1. 클라이언트가 로그인 버튼을 클릭하여 "/login.do" 요청을 전송하면 DispatcherServlet이 요청을 받는다.
2. DispatcherServlet은 HandlerMapping 객체를 통해 로그인 요청을 처리할 LoginController를 검색하고
3. 검색된 LoginController의 handlerRequest() 메소드를 호출하면 로그인 로직이 처리된다.
4. 로그인 처리 후에 이동할 화면 정보가 리턴되면
5. DispatcherServlet은 ViewResolver를 통해 접두사와 접미사가 붙은 JSP 파일의 이름과 경로를 리턴 받는다
6. 그리고 최종적으로 JSP를 실행하고 실행 결과가 브라우저에 응답된다.

### Spring MVC를 이용한 개발(FEAT POJO)
![스크린샷 2019-05-24 오후 6 01 38](https://user-images.githubusercontent.com/24884819/58316287-21bb9080-7e4e-11e9-81d9-100e0f2e5b05.png)
* 3DAY 코드에서 4DAY코드로 가기까지 정말 간단한 변화지만 Spring FrameWork가 추구하는 방향과 이점에 대해 굉장히 의미깊은 수정이다.

### web.xml을 이용한 Servlet 구축에 대해서 알아보자
* [내용이 너무 방대하다 여기서 확인하자](https://gist.github.com/lhy880518/a24161251375e8b2a103ee1c131db284)

### 스프링 컨테이너의 관계([그림출처](https://unordinarydays.tistory.com/121))
![image](https://user-images.githubusercontent.com/24884819/58471888-e4257300-817f-11e9-8869-306d01bbe85f.png)


1. web.xml파일을 로딩하여 서블릿 컨테이너 구동
2. 서블릿 컨테이너는 web.xml파일에 등록된 ContextLoaderListener객체를 생성(Pre loading)
이때 ContextLoaderListener 객체는 src/main/resources 소스 폴더에 있는 applicationContext.xml 파일을 로딩하여
스프링 컨테이너를 구동하는데 이를 Root컨테이너 라고 한다.
그리고 이때 Service 구현클래스나 DAO객체들이 메모리에 생성된다.
3. DispatcherServlet객체는 /WEB-INF/config 폴더에 있는 presentation-layer.xml파일을 로딩하여 두번째 스프링 컨테이너를 구동한다.
이 컨테이너가 Controller객체를 메모리에 생성한다.

### MYBATIS 프레임워크의 사용
* Ibatis라는 이름으로 탄생하였으나 apache -> google로 넘어가면서 mybatis로 변경
* 한두 줄의 자바코드로 DB연동을 처리, SQL명령어를 자바 코드에서 분리하여 XML 파일에 따로 관리한다는 것
