package tw.leonchen.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("logAdvice")
@Aspect
public class LogAdvice {
	
	@Pointcut(value = "execution(* tw.leonchen.model.HouseService.selectBy*(..))")
	private void pointcut1() {};
	
	@Before(value = "pointcut1()")
	public void logBefore(JoinPoint p) {
		System.out.print("before: at " + p.getTarget().getClass() + " ");
		System.out.print("calling " + p.getSignature().getName() + " ");
		System.out.println("using " + p.getArgs()[0]);
		System.out.println("before going into JoinPoint method");
	}
	
	@Around(value = "pointcut1()")
	public Object logAround(ProceedingJoinPoint p) throws Throwable {
		System.out.print("around: at " + p.getTarget().getClass() + " ");
		System.out.print("calling " + p.getSignature().getName() + " ");
		System.out.println("using " + p.getArgs()[0]);
		Object result = p.proceed();
		System.out.println("Result:" + result);
		return result;
	}
	
	@AfterReturning(pointcut = "pointcut1()", returning = "result")
	public void logAfter(JoinPoint p, Object result) {
		System.out.println("after calling method finished");
		System.out.println("after: result=" + result);
	}
	
	@AfterThrowing(pointcut = "pointcut1()", throwing = "e")
	public void logThrow(JoinPoint p, Throwable e) {
		System.out.println("Exception:" + e);
	}

}
