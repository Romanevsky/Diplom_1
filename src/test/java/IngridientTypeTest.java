import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngridientTypeTest {

    private String type;

    public IngridientTypeTest(String type) {
        this.type = type;
    }

    @Parameterized.Parameters(name = "Тип ингридиента. Тестовые данные: {0}")
    public static Object[][] getTestData() {
        return new Object[][] {
                {"SAUCE"},
                {"FILLING"},
        };
    }

    @Test
    public void  presenceIngredientTest(){
        assertThat(type.valueOf(type), is(notNullValue()));
    }
}
