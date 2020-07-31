package edu.bit.board.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect

//**AOP �������
//1. Aspect : ���� ����� ����ִ� Ŭ����(����, �α�....Ʈ�����..)
//2. Advice : Aspect Ŭ���� �ȿ� �ִ� ���� ���(�Ѹ���� Aspect ���� �Լ�)
//3. Joinpoint : advice �Լ��� ����Ǵ� �Լ�
//4. Point Cut : jointpoint�� �κ����� ������ ����Ǵ� �Լ����� ����(@before�Լ� ������, @after�Լ� ������ ����, @around�Լ� ��ü)
//5. weaving : advice�� �����ϴ� ����

public class LogAdvice {
	
	@Before("within(edu.bit.board.service.*)")
	public void printLogging() {
		System.out.println("������ - ����Ʈ �α�");
	}

}
