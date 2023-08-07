import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;
    private final static float PRICES = 10.1F;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] params() {
        return new Object[][]{
                {"ДжунТест", 120.4F},
                {"МидлТест", 235.7F},
                {"СеньорТест", 345.9F},
                {"TeamLeadTest", 555.5F}
        };
    }

    @Test
    public void getName() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(), PRICES);
    }





}
