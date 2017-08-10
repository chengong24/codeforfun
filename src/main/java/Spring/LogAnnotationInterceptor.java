package Spring;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.core.Ordered;

public class LogAnnotationInterceptor implements MethodInterceptor, Ordered {

	@Override
	public int getOrder() {

		return Ordered.HIGHEST_PRECEDENCE;
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("开始执行");
		Object result = invocation.proceed();
		System.out.println("结束执行");
		return result;
	}

}
