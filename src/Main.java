import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        int petChoice;
        boolean cat;
        Pet pet1;


        petChoice = welcomeMessagePetChoice();
        cleanConsoleLog();


        switch (petChoice) {
            case 1:
                cat = true;
                pet1 = createPet(cat, catEmoji());
                alterLevels(pet1, cat);

                break;
            case 2:
                cat = false;
                pet1 = createPet(cat, dogEmoji());
                alterLevels(pet1, cat);
                break;

        }


    }

    private static void alterLevels(Pet for_pet1, boolean for_cat) {
        String action;
        int menuOption;
        boolean exit, dead;

        exit = false;
        dead = false;
        do {


            System.out.println(for_pet1);
            actionMenu(for_cat);
            menuOption = scan.nextInt();

            switch (menuOption) {

                case 1:
                    // sleep
                    sleep(for_cat, for_pet1);
                    break;
                case 2:
                    //Eat
                    eat(for_cat, for_pet1);
                    break;
                case 3:
                    //Play
                    play(for_cat, for_pet1);
                    break;

                case 4:
                    // Shower (dog) or Self-clean (cat)
                    shower(for_cat, for_pet1);
                    break;
                case 5:
                    exit = true;
                    break;


            }
            dead = levelsOverdose(for_pet1);
            if (dead){
                deathMessage();
                exit = true;
            }
        } while (!exit);
    }
    private static String welcomeMessagetxt(){

        String txt="\n" +
                "\n" +
                " __          __    _                               \n" +
                " \\ \\        / /   | |                              \n" +
                "  \\ \\  /\\  / /___ | |  ___  ___   _ __ ___    ___  \n" +
                "   \\ \\/  \\/ // _ \\| | / __|/ _ \\ | '_ ` _ \\  / _ \\ \n" +
                "    \\  /\\  /|  __/| || (__| (_) || | | | | ||  __/ \n" +
                "     \\/  \\/  \\___||_| \\___|\\___/ |_| |_| |_| \\___| \n" +
                "                                                   \n";
    return txt;
    }
    private static void deathMessage(){

        System.out.println("\n" +
                "\n" +
                " __     __                           _         _ _          _ \n" +
                " \\ \\   / /                          | |       | (_)        | |\n" +
                "  \\ \\_/ /__  _   _ _ __   _ __   ___| |_    __| |_  ___  __| |\n" +
                "   \\   / _ \\| | | | '__| | '_ \\ / _ \\ __|  / _` | |/ _ \\/ _` |\n" +
                "    | | (_) | |_| | |    | |_) |  __/ |_  | (_| | |  __/ (_| |\n" +
                "    |_|\\___/ \\__,_|_|    | .__/ \\___|\\__|  \\__,_|_|\\___|\\__,_|\n" +
                "                         | |                                  \n" +
                "                         |_|                                  \n" +
                "\n");
    }

    private static boolean levelsOverdose(Pet for_pet1) {
        boolean death;
        death = false;

        if (for_pet1.getSleep() < 0 || for_pet1.getSleep() > 100 || for_pet1.getHygiene() < 0 || for_pet1.getHygiene() > 100 || for_pet1.getEnergy() < 0 || for_pet1.getEnergy() > 100 ||
                for_pet1.getFatigue() < 0 || for_pet1.getFatigue() > 100 || for_pet1.getWeight() < 0 || for_pet1.getWeight() > 100) {
            death = true;
        }

        return death;
    }

    private static void shower(boolean for_cat, Pet for_pet1) {
        if (!for_cat) {
            for_pet1.setSleep(for_pet1.getSleep() - 15);
            for_pet1.setHygiene(for_pet1.getHygiene() + 20);

        }


    }

    private static void play(boolean for_cat, Pet for_pet1) {
        if (for_cat) {
            for_pet1.setSleep(for_pet1.getSleep() + 15);
        } else {
            for_pet1.setSleep(for_pet1.getSleep() - 10);
        }
        for_pet1.setFatigue(for_pet1.getFatigue() + 10);
        for_pet1.setHygiene(for_pet1.getHygiene() - 15);
        for_pet1.setWeight(for_pet1.getWeight() - 10);

    }


    private static void sleep(boolean for_cat, Pet for_pet1) {
        if (for_cat) {
            for_pet1.setSleep(for_pet1.getSleep() + 20);
        } else {
            for_pet1.setSleep(for_pet1.getSleep() + 25);
        }
        for_pet1.setFatigue(for_pet1.getFatigue() - 15);
        for_pet1.setEnergy(for_pet1.getFatigue() + 15);
    }

    private static void eat(boolean for_cat, Pet for_pet1) {
        if (for_cat) {
            for_pet1.setSleep(for_pet1.getSleep() + 15);
        } else {
            for_pet1.setSleep(for_pet1.getSleep() + 10);
        }

        for_pet1.setEnergy(for_pet1.getFatigue() + 10);
        for_pet1.setHygiene(for_pet1.getHygiene() - 10);
        for_pet1.setWeight(for_pet1.getWeight() + 10);
    }

    private static void actionMenu(boolean for_cat
    ) {
        String action;
        if (for_cat) {
            action = "Self-cleaning";
        } else {
            action = "Shower";
        }
        System.out.println("What do you wish to do?");
        System.out.println("1: Sleep\n" +
                "2: Eat\n" +
                "3: Play\n" +
                "4: " + action + "\n" +
                "5: Exit");

    }

    private static Pet createPet(boolean for_cat, String for_emoji) {
        String animal, emoji, name;
        Pet for_p1;

        if (for_cat) {
            animal = "cat";
            emoji = catEmoji();

        } else {
            animal = "dog";
            emoji = dogEmoji();

        }

        System.out.println("You chose a " + animal + " " + emoji);
        System.out.println("How do you want to name it?");
        name = scan.next();
        for_p1 = new Pet(name, for_cat, for_emoji);

        cleanConsoleLog();
        return for_p1;
    }

    private static int welcomeMessagePetChoice() {
        int animalType;
        boolean acceptableAnswer;

        do {
            acceptableAnswer = true;

            System.out.println(ConsoleColors.RED_BOLD + welcomeMessagetxt());

            System.out.println("Please chose what animal you want as a pet");
            System.out.println("          1  " + catEmoji() + "        2  " + dogEmoji());
            animalType = scan.nextInt();
            if (animalType < 0 || animalType > 2) {
                cleanConsoleLog();
                System.out.println(ConsoleColors.RESET + ConsoleColors.RED_BOLD_BRIGHT + "        ERROR, PLEASE CHOOSE 1 OR 2" + ConsoleColors.RESET);
                acceptableAnswer = false;
            }

        } while (!acceptableAnswer);

        return animalType;
    }

    public static void cleanConsoleLog() {
        //File >Settings> Keymap  -   ShortCut "ClearAll": Alt + Shift + 1
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_1);
            robot.keyRelease(KeyEvent.VK_ALT);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease(KeyEvent.VK_1);
            robot.delay(30);
        } catch (AWTException ignored) {
        }
    }

    public static String catEmoji() {
        String pet;

        pet = "\uD83D\uDC31";
        return pet;
    }

    public static String dogEmoji() {
        String pet;

        pet = "\uD83D\uDC36";
        return pet;
    }

    public static Scanner scan = new Scanner(System.in);
}