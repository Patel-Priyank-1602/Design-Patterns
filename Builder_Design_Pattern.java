import java.util.Scanner;

interface Sweet {
    void display();
}

interface SweetBuilder {
    SweetBuilder setName(String name);
    SweetBuilder setIngredients(String ingredients);
    SweetBuilder setPreparationSteps(String steps);
    SweetBuilder setPackaging(String packaging);
    Sweet build();
}

class SweetImpl implements Sweet {
    private String name;
    private String ingredients;
    private String preparationSteps;
    private String packaging;

    public SweetImpl(String name, String ingredients, String preparationSteps, String packaging) {
        this.name = (name == null || name.isEmpty()) ? "null" : name;
        this.ingredients = (ingredients == null || ingredients.isEmpty()) ? "null" : ingredients;
        this.preparationSteps = (preparationSteps == null || preparationSteps.isEmpty()) ? "null" : preparationSteps;
        this.packaging = (packaging == null || packaging.isEmpty()) ? "null" : packaging;
    }

    @Override
    public void display() {
        System.out.println("\nSweet Details:");
        System.out.println("Sweet Name: " + name);
        System.out.println("Ingredients: " + ingredients);
        System.out.println("Preparation Steps: " + preparationSteps);
        System.out.println("Packaging: " + packaging);
    }
}

class SweetConcreteBuilder implements SweetBuilder {
    private String name;
    private String ingredients;
    private String preparationSteps;
    private String packaging;

    @Override
    public SweetBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public SweetBuilder setIngredients(String ingredients) {
        this.ingredients = ingredients;
        return this;
    }

    @Override
    public SweetBuilder setPreparationSteps(String steps) {
        this.preparationSteps = steps;
        return this;
    }

    @Override
    public SweetBuilder setPackaging(String packaging) {
        this.packaging = packaging;
        return this;
    }

    @Override
    public Sweet build() {
        return new SweetImpl(name, ingredients, preparationSteps, packaging);
    }
}

public class Builder_Design_Pattern {
    private static Scanner scanner = new Scanner(System.in);

    private static String getValidInput(String prompt) {
        System.out.print(prompt + ": ");
        String input = scanner.nextLine().trim();
        return input.isEmpty() ? null : input;
    }

    private static int getValidNumber(String prompt, int defaultValue) {
        System.out.print(prompt + ": ");
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            return defaultValue;
        }
        try {
            int number = Integer.parseInt(input);
            return Math.max(number, 0);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Using default: " + defaultValue);
            return defaultValue;
        }
    }

    public static void main(String[] args) {
        SweetBuilder builder = new SweetConcreteBuilder();
        int sweetCount = getValidNumber("Enter the number of sweets to create", 0);

        if (sweetCount == 0) {
            System.out.println("\nNo sweets created. Exiting...");
            return;
        }

        Sweet[] sweets = new Sweet[sweetCount];

        for (int i = 0; i < sweetCount; i++) {
            System.out.println("\nEnter details for Sweet " + (i + 1) + ":");
            String name = getValidInput("Sweet Name");
            String ingredients = getValidInput("Ingredients");
            String steps = getValidInput("Preparation Steps");
            String packaging = getValidInput("Packaging");

            sweets[i] = builder.setName(name)
                    .setIngredients(ingredients)
                    .setPreparationSteps(steps)
                    .setPackaging(packaging)
                    .build();
        }

        System.out.println("\nDisplaying all created sweets:");
        for (Sweet sweet : sweets) {
            sweet.display();
        }

        scanner.close();
    }
}
