package thread;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public final class MyLock extends AbstractQueuedSynchronizer {

	private static final long serialVersionUID = -1850812446845359616L;

	protected boolean isHeldExclusively() {
		return getState() != 0;
	}

	protected boolean tryAcquire(int unused) {
		if (compareAndSetState(0, 1)) {
			setExclusiveOwnerThread(Thread.currentThread());
			return true;
		}
		return false;
	}

	protected boolean tryRelease(int unused) {
		setExclusiveOwnerThread(null);
		setState(0);
		return true;
	}

	public void lock() {
		acquire(1);
	}

	public boolean tryLock() {
		return tryAcquire(1);
	}

	public void unlock() {
		release(1);
	}

	public boolean isLocked() {
		return isHeldExclusively();
	}

}
