package Spring;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.util.Assert;

@SuppressWarnings("serial")
public class LogAnnotationAdvisor extends AbstractPointcutAdvisor implements BeanFactoryAware {

	private Advice advice;

	private Pointcut pointcut;

	public LogAnnotationAdvisor() {

		this.advice = new LogAnnotationInterceptor();
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

	}

	@Override
	public Advice getAdvice() {

		return this.advice;
	}

	@Override
	public boolean isPerInstance() {

		return false;
	}

	@Override
	public Pointcut getPointcut() {

		return this.pointcut;
	}

	public void setAsyncAnnotationType(Class<? extends Annotation> asyncAnnotationType) {
		Assert.notNull(asyncAnnotationType, "'asyncAnnotationType' must not be null");
		Set<Class<? extends Annotation>> asyncAnnotationTypes = new HashSet<Class<? extends Annotation>>();
		asyncAnnotationTypes.add(asyncAnnotationType);
		this.pointcut = buildPointcut(asyncAnnotationTypes);
	}

	protected Pointcut buildPointcut(Set<Class<? extends Annotation>> asyncAnnotationTypes) {
		ComposablePointcut result = null;
		for (Class<? extends Annotation> asyncAnnotationType : asyncAnnotationTypes) {
			Pointcut cpc = new AnnotationMatchingPointcut(asyncAnnotationType, true);
			Pointcut mpc = AnnotationMatchingPointcut.forMethodAnnotation(asyncAnnotationType);
			if (result == null) {
				result = new ComposablePointcut(cpc).union(mpc);
			} else {
				result.union(cpc).union(mpc);
			}
		}
		return result;
	}

}
