package tingo.core.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Created by user on 16/11/3.
 */
public class ForkTest {

    public static void main(String[] args) {
        ProductGenerator generator = new ProductGenerator();
        List<Product> products = generator.generate(10000);
        Task task = new Task(products,0,products.size(),0.20d);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.execute(task);

        for(Product product:products) {
            System.out.println(product.getName()+":"+product.getPrice());
        }
    }
}

class Product {
    private String name;
    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

class ProductGenerator {
    public List<Product> generate(int size) {
        List<Product> ret = new ArrayList<Product>();
        for(int i = 0;i<size; i++) {
            Product product = new Product();
            ret.add(product);
            product.setName("Product"+i);
            product.setPrice(10D);
        }
        return ret;
    }
}

class Task extends RecursiveAction {
    private static final long serialVersionUID = 1L;

    private List<Product> products;
    private int first;
    private int last;
    private double increament;

    public Task(List<Product> products,int first,int last,double increament) {
        this.products = products;
        this.first = first;
        this.last = last;
        this.increament = increament;
    }

    @Override
    protected void compute() {
        if(last - first < 10) {
            updatePrices();
        } else {
            int middle = (last+first)/2;
            Task t1 = new Task(products,first,middle+1,increament);
            Task t2 = new Task(products,middle+1,last,increament);
            invokeAll(t1,t2);
        }
    }

    private void updatePrices() {
        for(Product product:products) {
            product.setPrice(product.getPrice()*(1+increament));
        }
    }
}
