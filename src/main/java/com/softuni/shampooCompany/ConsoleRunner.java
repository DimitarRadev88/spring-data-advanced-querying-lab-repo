package com.softuni.shampooCompany;

import com.softuni.shampooCompany.entities.Shampoo;
import com.softuni.shampooCompany.entities.Size;
import com.softuni.shampooCompany.services.interfaces.IngredientService;
import com.softuni.shampooCompany.services.interfaces.LabelService;
import com.softuni.shampooCompany.services.interfaces.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.*;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private static final Scanner SCANNER = new Scanner(System.in);
    private IngredientService ingredientService;
    private LabelService labelService;
    private ShampooService shampooService;

    @Autowired
    public ConsoleRunner(IngredientService ingredientService, LabelService labelService, ShampooService shampooService) {
        this.ingredientService = ingredientService;
        this.labelService = labelService;
        this.shampooService = shampooService;
    }

    @Override
    public void run(String... args) throws Exception {
//        selectShampoosBySize();
//        selectShampoosBySizeOrLabel();
//        selectShampoosByPrice();
//        selectIngredientsByName();
//        selectIngredientsByNames();
//        countShampoosByPrice();
//        selectShampoosByIngredients();
//        selectShampoosByIngredientsCount();
//        deleteIngredientsByName();
//        increaseIngredientPriceByPercentAmount();
//        updateIngredientsPriceByName();
    }

    private void updateIngredientsPriceByName() {
        List<String> ingredientNames = getIngredientNamesFromConsole();
        BigDecimal price = new BigDecimal(promptInput("Ingredient price increase percent"));

        ingredientService.increasePriceForIngredientsWithNamesByPercent(ingredientNames, price);
    }

    private void increaseIngredientPriceByPercentAmount() {
        BigDecimal increasePercent = new BigDecimal(promptInput("Ingredient price increase percent"));

        ingredientService.increasePriceByPercent(increasePercent);
    }

    private void deleteIngredientsByName() {
        String name = promptInput("Ingredient name for deletion");

        ingredientService.deleteIngredientsWithName(name);
    }

    private void selectShampoosByIngredientsCount() {
        int maxIngredients = Integer.parseInt(promptInput("Max ingredients count"));

        shampooService
                .getAllShampoosWithIngredientsLessThan(maxIngredients)
                .forEach(s -> System.out.println(s.getBrand()));
    }

    private void selectShampoosByIngredients() {
        List<String> ingredients = getIngredientNamesFromConsole();

        shampooService.getAllShampoosWithIngredientsListContaining(ingredients).forEach(s -> System.out.println(s.getBrand()));

    }

    private void countShampoosByPrice() {
        BigDecimal price = new BigDecimal(promptInput("Price: "));

        System.out.println(shampooService.getShampoosCountWithPriceLowerThan(price));
    }

    private void selectIngredientsByNames() {
        List<String> ingredientNames = getIngredientNamesFromConsole();

        ingredientService
                .getAllIngredientsWithNamesSortedByPrice(ingredientNames)
                .forEach(i -> System.out.println(i.getName()));
    }

    private List<String> getIngredientNamesFromConsole() {
        List<String> ingredientNames = new ArrayList<>();
        String promptMessage = "Ingredient name [Empty input to end]";

        ingredientNames.add(promptInput(promptMessage));

        while (!ingredientNames.get(ingredientNames.size() - 1).isBlank()) {
            ingredientNames.add(promptInput(promptMessage));
        }

        ingredientNames.remove(ingredientNames.size() - 1);

        return ingredientNames;
    }

    private void selectIngredientsByName() {
        String ingredientNameStart = promptInput("Ingredient start string");

        ingredientService
                .getAllIngredientsByNameStartingWith(ingredientNameStart)
                .forEach(i -> System.out.println(i.getName()));

    }

    private void selectShampoosByPrice() {
        BigDecimal price = new BigDecimal(promptInput("Price"));

        shampooService
                .getAllShampoosWithPriceHigherThanSortedByPriceDesc(price)
                .forEach(ConsoleRunner::printShampoo);

    }

    private void selectShampoosBySizeOrLabel() {
        Size size = Size.valueOf(promptInput("Size"));
        long labelId = Long.parseLong(promptInput("Label id"));

        shampooService
                .getAllShampoosWithSizeOrLabelIdSortedByPrice(size, labelId)
                .forEach(ConsoleRunner::printShampoo);

    }

    private void selectShampoosBySize() {
        Size size = Size.valueOf(promptInput("Size"));
        shampooService
                .getAllShampoosWithSizeSortedById(size)
                .forEach(ConsoleRunner::printShampoo);
    }

    private static PrintStream printShampoo(Shampoo s) {
        return System.out.printf("%s %s %.2flv.%n",
                s.getBrand(), s.getSize().name(), s.getPrice());
    }

    private String promptInput(String promptMessage) {
        System.out.print(promptMessage + ": ");
        return SCANNER.nextLine();
    }

}
