package tingo.core.algorithm;

import org.junit.Test;

/**
 * Created by user on 17/8/1.
 */
public class BucketTest {

    private int total = 8;

    @Test
    public void testGenerateRoute() {

        Bucket bucket1 = new Bucket(3);
        Bucket bucket2 = new Bucket(5);
        Bucket bucket3 = new Bucket(8);

        exchange(bucket1);
        exchange(bucket2);
        exchange(bucket3);

    }

    private void doBuck(Bucket bucket1,Bucket bucket2,Bucket bucket3) {
        if(bucket2.getUsed() == 4 && bucket3.getUsed() == 4) {
            return;
        }

    }

    private void exchange(Bucket fromBucket,Bucket toBucket) {
        int exchangeNum = Integer.min(fromBucket.getUsed(),toBucket.getFree());
        fromBucket.subtract(exchangeNum);
        toBucket.add(exchangeNum);
    }

    private void exchange(Bucket bucket) {
        int exchange = Integer.min(bucket.getFree(),total);
        total = total-exchange;
        bucket.add(exchange);
    }

}

class Bucket {
    private int capacity;
    private int used;
    private int free;

    public Bucket(int capacity) {
        this.capacity = capacity;
        this.used = 0;
        this.free = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
    }

    public int getFree() {
        return free;
    }

    public void setFree(int free) {
        this.free = free;
    }

    public void add(int num) {
        free = free - num;
        used = used+num;
    }

    public void subtract(int num) {
        used = used-num;
        free = free+num;
    }
}
