public class Pet {
    private int sleep, hygiene, energy, fatigue,weight, randMin, randMax;
    private String name, emoji;

    private boolean cat;

    public Pet(String name, boolean cat, String emoji) {
        randMin = 40;
        randMax = 60;

        this.name = name;

        this.cat = cat;
        this.emoji = emoji;

        this.sleep = randNum(randMin, randMax);
        this.hygiene = randNum(randMin, randMax);
        this.energy = randNum(randMin, randMax);
        this.fatigue = randNum(randMin, randMax);
        this.weight = randNum(randMin, randMax);
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSleep() {
        return sleep;
    }

    public void setSleep(int sleep) {
        this.sleep = sleep;
    }

    public int getHygiene() {
        return hygiene;
    }

    public void setHygiene(int hygiene) {
        this.hygiene = hygiene;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getFatigue() {
        return fatigue;
    }

    public void setFatigue(int fatigue) {
        this.fatigue = fatigue;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getRandMin() {
        return randMin;
    }

    public void setRandMin(int randMin) {
        this.randMin = randMin;
    }

    public int getRandMax() {
        return randMax;
    }

    public void setRandMax(int randMax) {
        this.randMax = randMax;
    }

    @Override
    public String toString() {
        String pet, animal;
        if (cat){
           animal = "cat";

       } else {
            animal = "dog";
        }


        pet = name+ " the " + animal +" "+ emoji+ " has the following levels:\n" +
               ConsoleColors.RED_BOLD+ " sleep level: " + ConsoleColors.GREEN_BOLD+ sleep +  ConsoleColors.RED_BOLD+
                "\n hygiene level: " + ConsoleColors.GREEN_BOLD+ hygiene +  ConsoleColors.RED_BOLD+
                "\n energy level: " + ConsoleColors.GREEN_BOLD+ energy +  ConsoleColors.RED_BOLD+
                "\n fatigue level: " + ConsoleColors.GREEN_BOLD+ fatigue +  ConsoleColors.RED_BOLD+
                "\n weight : " + ConsoleColors.GREEN_BOLD + weight +  ConsoleColors.RED_BOLD ;
    return pet;
    }

    private static int randNum(int min, int max) {
        int randNum;
        randNum = min + (int)(Math.random() * max);
return randNum;
    }
}
