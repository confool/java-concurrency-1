package utils;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

//用Semaphore实现一个有界的hashset,有点浪费

public class SemaphoreDemo {

    public class BoundedHashSet<T> {
        private final Set<T> set;
        private final Semaphore sem;

        public BoundedHashSet(int bound) {
            set = Collections.synchronizedSet(new HashSet<T>());
            sem = new Semaphore(bound);
        }

        public boolean add(T o) throws InterruptedException {
            sem.acquire();
            boolean wasAdded = false;

            try {
                wasAdded = set.add(o);
                return wasAdded;
            } finally {
                if (!wasAdded) sem.release();
            }
        }

        public boolean remove(T o) throws InterruptedException {
            boolean wasRemoved = set.remove(o);
            if (wasRemoved) sem.release();
            return wasRemoved;
        }
    }
}
