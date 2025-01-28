import java.util.Scanner;

interface Sweet {
    void prepare();
}

class MethiPak implements Sweet {
    public void prepare() {
        System.out.println("Preparing Methi Pak...");
    }
}

class Sukhdi implements Sweet {
    public void prepare() {
        System.out.println("Preparing Sukhdi (Golpapdi)...");
    }
}

class KhajurPak implements Sweet {
    public void prepare() {
        System.out.println("Preparing Khajur Pak...");
    }
}

class KajuKatli implements Sweet {
    public void prepare() {
        System.out.println("Preparing Kaju Katli...");
    }
}

class AngurRabdi implements Sweet {
    public void prepare() {
        System.out.println("Preparing Angur Rabdi...");
    }
}

class KesarSweet implements Sweet {
    public void prepare() {
        System.out.println("Preparing Kesar Sweet...");
    }
}

class MotichurLaddu implements Sweet {
    public void prepare() {
        System.out.println("Preparing Motichur Laddu...");
    }
}

class SadaPenda implements Sweet {
    public void prepare() {
        System.out.println("Preparing Sada Penda...");
    }
}

class Matho implements Sweet {
    public void prepare() {
        System.out.println("Preparing Matho...");
    }
}

class CowMilk implements Sweet {
    public void prepare() {
        System.out.println("Preparing Cow Milk...");
    }
}

class BuffaloMilk implements Sweet {
    public void prepare() {
        System.out.println("Preparing Buffalo Milk...");
    }
}

interface SweetFactory {
    Sweet createSweet(String sweetType);
}

class SeasonalSweetFactory implements SweetFactory {
    public Sweet createSweet(String sweetType) {
        switch (sweetType) {
            case "Methi Pak":
                return new MethiPak();
            case "Sukhdi":
                return new Sukhdi();
            case "Khajur Pak":
                return new KhajurPak();
            default:
                throw new IllegalArgumentException("Unknown seasonal sweet: " + sweetType);
        }
    }
}

class PremiumSweetFactory implements SweetFactory {
    public Sweet createSweet(String sweetType) {
        switch (sweetType) {
            case "Kaju Katli":
                return new KajuKatli();
            case "Angur Rabdi":
                return new AngurRabdi();
            default:
                throw new IllegalArgumentException("Unknown premium sweet: " + sweetType);
        }
    }
}

class SpecialSweetFactory implements SweetFactory {
    public Sweet createSweet(String sweetType) {
        switch (sweetType) {
            case "Kesar Sweet":
                return new KesarSweet();
            case "Motichur Laddu":
                return new MotichurLaddu();
            default:
                throw new IllegalArgumentException("Unknown special sweet: " + sweetType);
        }
    }
}

class RegularSweetFactory implements SweetFactory {
    public Sweet createSweet(String sweetType) {
        switch (sweetType) {
            case "Sada Penda":
                return new SadaPenda();
            case "Matho":
                return new Matho();
            default:
                throw new IllegalArgumentException("Unknown regular sweet: " + sweetType);
        }
    }
}

class MilkProductFactory implements SweetFactory {
    public Sweet createSweet(String sweetType) {
        switch (sweetType) {
            case "Cow Milk":
                return new CowMilk();
            case "Buffalo Milk":
                return new BuffaloMilk();
            default:
                throw new IllegalArgumentException("Unknown milk product: " + sweetType);
        }
    }
}

public class Factory_Design_Pattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SweetFactory factory = null;
        Sweet sweet = null;

        System.out.println(" ");
        System.out.println("Welcome");
        System.out.println(" ");
        System.out.println("Select a category");
        System.out.println("1. Seasonal Sweets");
        System.out.println("2. Premium Sweets");
        System.out.println("3. Special Sweets");
        System.out.println("4. Regular Sweets");
        System.out.println("5. Milk Products");
        System.out.println(" ");
        System.out.print("Enter a Category: ");
        int categoryChoice = scanner.nextInt();
        scanner.nextLine();
        System.out.println(" ");

        switch (categoryChoice) {
            case 1:
                factory = new SeasonalSweetFactory();
                System.out.println("Available Seasonal Sweets: Methi Pak, Sukhdi, Khajur Pak");
                break;
            case 2:
                factory = new PremiumSweetFactory();
                System.out.println("Available Premium Sweets: Kaju Katli, Angur Rabdi");
                break;
            case 3:
                factory = new SpecialSweetFactory();
                System.out.println("Available Special Sweets: Kesar Sweet, Motichur Laddu");
                break;
            case 4:
                factory = new RegularSweetFactory();
                System.out.println("Available Regular Sweets: Sada Penda, Matho");
                break;
            case 5:
                factory = new MilkProductFactory();
                System.out.println("Available Milk Products: Cow Milk, Buffalo Milk");
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.print("Enter the name of the product: ");
        String sweetType = scanner.nextLine();
        System.out.println(" ");

        try {
            sweet = factory.createSweet(sweetType);
            sweet.prepare();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(" ");
        scanner.close();
    }
}
