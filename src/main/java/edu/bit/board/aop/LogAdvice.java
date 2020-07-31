package edu.bit.board.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect

//**AOP 용어정리
//1. Aspect : 공통 기능이 들어있는 클래스(예제, 로깅....트랜잭션..)
//2. Advice : Aspect 클래스 안에 있는 공통 기능(한마디로 Aspect 안의 함수)
//3. Joinpoint : advice 함수가 적용되는 함수
//4. Point Cut : jointpoint의 부분으로 실제로 적용되는 함수내의 지점(@before함수 시작전, @after함수 끝나는 지점, @around함수 전체)
//5. weaving : advice를 적용하는 행위

public class LogAdvice {
	
	@Before("within(edu.bit.board.service.*)")
	public void printLogging() {
		System.out.println("공통기능 - 프린트 로그");
	}

}
