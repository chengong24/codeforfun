package Spring;

import org.springframework.beans.factory.FactoryBean;

public class DemoServiceImpl implements IDemoService,FactoryBean<T> {

	@Override

	public void add(int a, int b) {

	}

	@Override
	public T getObject() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

}
