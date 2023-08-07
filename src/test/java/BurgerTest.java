import org.junit.Test;
import praktikum.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BurgerTest {

    @Test
    public void testGetPrice() {

        Database mockDatabase = mock(Database.class);


        List<Bun> buns = new ArrayList<>();
        List<Ingredient> ingredients = new ArrayList<>();

        buns.add(new Bun("black bun", 100));
        buns.add(new Bun("white bun", 200));
        buns.add(new Bun("red bun", 300));

        ingredients.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));
        ingredients.add(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        ingredients.add(new Ingredient(IngredientType.FILLING, "dinosaur", 200));
        ingredients.add(new Ingredient(IngredientType.FILLING, "sausage", 300));

        when(mockDatabase.availableBuns()).thenReturn(buns);
        when(mockDatabase.availableIngredients()).thenReturn(ingredients);

        Burger burger = new Burger();

        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.addIngredient(ingredients.get(4));
        burger.addIngredient(ingredients.get(3));
        burger.addIngredient(ingredients.get(5));
        burger.moveIngredient(2, 1);
        burger.removeIngredient(3);

        float expectedPrice = 700.0f;
        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void testGetReceipt() {
        Database mockDatabase = mock(Database.class);

        List<Bun> buns = new ArrayList<>();
        List<Ingredient> ingredients = new ArrayList<>();

        buns.add(new Bun("red bun", 300));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        ingredients.add(new Ingredient(IngredientType.FILLING, "dinosaur", 200));

        when(mockDatabase.availableBuns()).thenReturn(buns);
        when(mockDatabase.availableIngredients()).thenReturn(ingredients);

        Burger burger = new Burger();
        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(1));

        double expectedPrice = 1000.0;
        double actualPrice = burger.getPrice();
        assertEquals(expectedPrice, actualPrice, 0.1);

        String actualReceipt = burger.getReceipt();
        System.out.println("Фактический чек:");
        System.out.println(actualReceipt);
        assertEquals(expectedPrice, actualPrice, 0.1);
    }
}