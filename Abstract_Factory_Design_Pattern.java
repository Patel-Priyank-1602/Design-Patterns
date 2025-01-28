interface Sweet {
    void prepare();
}

interface SweetPackaging {
    void packageSweet();
}

class MethiPak implements Sweet {
    public void prepare() {
        System.out.println("Preparing Methi Pak...");
    }
}

class MethiPakPackaging implements SweetPackaging {
    public void packageSweet() {
        System.out.println("Packaging Methi Pak...");
    }
}

class Sukhdi implements Sweet {
    public void prepare() {
        System.out.println("Preparing Sukhdi...");
    }
}

class SukhdiPackaging implements SweetPackaging {
    public void packageSweet() {
        System.out.println("Packaging Sukhdi...");
    }
}

class KajuKatli implements Sweet {
    public void prepare() {
        System.out.println("Preparing Kaju Katli...");
    }
}

class KajuKatliPackaging implements SweetPackaging {
    public void packageSweet() {
        System.out.println("Packaging Kaju Katli...");
    }
}

interface SweetFactory {
    Sweet createSweet();
    SweetPackaging createPackaging();
}

class MethiPakFactory implements SweetFactory {
    public Sweet createSweet() {
        return new MethiPak();
    }

    public SweetPackaging createPackaging() {
        return new MethiPakPackaging();
    }
}

class SukhdiFactory implements SweetFactory {
    public Sweet createSweet() {
        return new Sukhdi();
    }

    public SweetPackaging createPackaging() {
        return new SukhdiPackaging();
    }
}

class KajuKatliFactory implements SweetFactory {
    public Sweet createSweet() {
        return new KajuKatli();
    }

    public SweetPackaging createPackaging() {
        return new KajuKatliPackaging();
    }
}

public class Abstract_Factory_Design_Pattern {
    public static void main(String[] args) {
        SweetFactory[] factories = {
            new MethiPakFactory(),
            new SukhdiFactory(),
            new KajuKatliFactory()
        };

        for (SweetFactory factory : factories) {
            Sweet sweet = factory.createSweet();
            SweetPackaging packaging = factory.createPackaging();
            sweet.prepare();
            packaging.packageSweet();
        }
    }
}
