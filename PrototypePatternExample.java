import java.util.ArrayList;
import java.util.List;

abstract class Sweet implements Cloneable {
    protected String name;
    protected List<String> ingredients;

    abstract void prepare();

    public String getName() {
        return name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public Sweet shallowCopy() {
        try {
            return (Sweet) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Shallow cloning failed!");
        }
    }

    public Sweet deepCopy() {
        try {
            Sweet cloned = (Sweet) super.clone();
            cloned.ingredients = new ArrayList<>(this.ingredients); 
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Deep cloning failed!");
        }
    }
}

class MethiPak extends Sweet {
    public MethiPak() {
        this.name = "Methi Pak";
        this.ingredients = new ArrayList<>();
        this.ingredients.add("Fenugreek");
        this.ingredients.add("Sugar");
        this.ingredients.add("Ghee");
    }

    public void prepare() {
        System.out.println("Preparing Methi Pak with ingredients: " + ingredients);
    }
}

class KajuKatli extends Sweet {
    public KajuKatli() {
        this.name = "Kaju Katli";
        this.ingredients = new ArrayList<>();
        this.ingredients.add("Cashew");
        this.ingredients.add("Sugar");
        this.ingredients.add("Milk");
    }

    public void prepare() {
        System.out.println("Preparing Kaju Katli with ingredients: " + ingredients);
    }
}

class MotichurLaddu extends Sweet {
    public MotichurLaddu() {
        this.name = "Motichur Laddu";
        this.ingredients = new ArrayList<>();
        this.ingredients.add("Gram Flour");
        this.ingredients.add("Sugar");
        this.ingredients.add("Ghee");
    }

    public void prepare() {
        System.out.println("Preparing Motichur Laddu with ingredients: " + ingredients);
    }
}

public class PrototypePatternExample {
    public static void main(String[] args) {
        System.out.println("Welcome to Vijay Dairy - Sweet Management System!");
        System.out.println("Available Sweets: Methi Pak, Kaju Katli, Motichur Laddu");

        Sweet methiPakPrototype = new MethiPak();
        Sweet kajuKatliPrototype = new KajuKatli();
        Sweet motichurLadduPrototype = new MotichurLaddu();

        Sweet shallowCopyMethiPak = methiPakPrototype.shallowCopy();
        System.out.println("\nShallow Copy Example:");
        System.out.println("Original Ingredients: " + methiPakPrototype.getIngredients());
        System.out.println("Shallow Copy Ingredients: " + shallowCopyMethiPak.getIngredients());

        methiPakPrototype.getIngredients().add("Cardamom");
        System.out.println("After modifying original object:");
        System.out.println("Original Ingredients: " + methiPakPrototype.getIngredients());
        System.out.println("Shallow Copy Ingredients: " + shallowCopyMethiPak.getIngredients());

        Sweet deepCopyKajuKatli = kajuKatliPrototype.deepCopy();
        System.out.println("\nDeep Copy Example:");
        System.out.println("Original Ingredients: " + kajuKatliPrototype.getIngredients());
        System.out.println("Deep Copy Ingredients: " + deepCopyKajuKatli.getIngredients());

        kajuKatliPrototype.getIngredients().add("Saffron");
        System.out.println("After modifying original object:");
        System.out.println("Original Ingredients: " + kajuKatliPrototype.getIngredients());
        System.out.println("Deep Copy Ingredients: " + deepCopyKajuKatli.getIngredients());

        System.out.println("\nPreparing Sweets:");
        shallowCopyMethiPak.prepare();
        deepCopyKajuKatli.prepare();
        motichurLadduPrototype.prepare();
    }
}