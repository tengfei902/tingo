package tingo.core.dp;

import org.junit.Test;

/**
 * Created by user on 17/8/12.
 */
public class BuilderTest {

    @Test
    public void testBuilder() {
        Builder builder = new DebtSaleBuilder();
        builder.setType();
        Product product = builder.build();
    }
}

interface Builder {
    void setType();
    Product build();
}

class DebtSaleBuilder implements Builder {
    public void setType() {

    }

    public Product build() {
        DebtSaleProduct debtSaleProduct = new DebtSaleProduct();
        return debtSaleProduct;
    }
}


interface Product {

}

class DebtSaleProduct implements Product {

}