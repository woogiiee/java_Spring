package edu.bit.board.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAOP {
	
	//@pointcut("within(edu.bit.board..**)")
	//@pointcut("execution("edu.bit.board.service.*.*())")
	//@pointcut("execution(edu.bit.board.sevice.*.get*())")
	@Pointcut("execution(* edu.bit.board..*.getList())")//getlist --> 함수 이름 잘 찾아보기.
	
	
	@Around("within(edu.bit.board..*)")
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable{
		
		String signatureStr = joinpoint.getSignature().toShortString();
		
		System.out.println(signatureStr + "is start.");
		
		long st = System.currentTimeMillis();
		
		try {
			Object obj = joinpoint.proceed();
			return obj;
		} finally {
			long et = System.currentTimeMillis();
			
			System.out.println(signatureStr + "is finished.");
			System.out.println(signatureStr + "경과시간 : "+(et-st));
		}
	}
	
}
