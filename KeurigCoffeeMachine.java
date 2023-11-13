package coffeeMachine;

public class KeurigCoffeeMachine {

    private static final int MAX_WATER_CUPS = 7;
    private static final int MAX_PODS = 30;
    private static final double SMALL_CUP_WATER = 0.25;
    private static final double MEDIUM_CUP_WATER = 0.75;
    private static final double LARGE_CUP_WATER = 1.5;
    private int waterLevel = MAX_WATER_CUPS;
    private int podsAvailable = MAX_PODS;

    public static void main(String[] args) throws InterruptedException {
        KeurigCoffeeMachine coffeeMachine = new KeurigCoffeeMachine();

        coffeeMachine.startMachine();
        coffeeMachine.checkAndRefillWater();
        coffeeMachine.heatWater();
        coffeeMachine.waitForCupSizeLight();
        coffeeMachine.removeCoffeePod();
        coffeeMachine.placeCoffeePod();
        coffeeMachine.selectCupSize("small"); // Sizes
        coffeeMachine.brewCoffee();
        coffeeMachine.startAutoOffTimer();
    }

    // To simulate pressing the power button
    private void startMachine() throws InterruptedException {
        System.out.println("Turning on the Keurig coffee machine...");
        Thread.sleep(1000); // Simulate the power to the machine
    }

    private void checkAndRefillWater() throws InterruptedException {
        if (waterLevel < MAX_WATER_CUPS) {
            System.out.println("Refilling water...");
            waterLevel = MAX_WATER_CUPS;
        } else {
            System.out.println("Water level is sufficient.");
            Thread.sleep(2500);
        }
    }

    private void heatWater() throws InterruptedException {
        System.out.println("Heating the water...");
        Thread.sleep(5000); // Simulate heating the water
        System.out.println("Water heated. ");
    }

    private void waitForCupSizeLight() throws InterruptedException {
        System.out.println("Waiting for cups size lights to blink blue...");
        Thread.sleep(3000); // Simulate the wait time
    }

    private void removeCoffeePod() throws InterruptedException {
        if (podsAvailable > 0) {
            System.out.println("Removing a coffee pod from the storage drawer...");
            podsAvailable--;
            Thread.sleep(3500); // Simulate removing a pod from the storage
        } else {
            System.out.println("No pods available. Please refill.");
        }
    }

    private void placeCoffeePod() throws InterruptedException {
        System.out.println("Placing the coffee pod inside the machine...");
        Thread.sleep(1500);
    }

    private void selectCupSize(String size) throws InterruptedException {

        double waterUsed;
        switch (size.toLowerCase()) {
            case "small":
                waterUsed = SMALL_CUP_WATER;
                break;
            case "medium":
                waterUsed = MEDIUM_CUP_WATER;
                break;
            case "large":
                waterUsed = LARGE_CUP_WATER;
                break;
            default:
                System.out.println("Invalid cup size selected Defaulting to small. ");
                waterUsed = SMALL_CUP_WATER;
                break;
        }

        if (waterLevel >= waterUsed) {
            waterLevel -= waterUsed;
            System.out.println("Selected cup size: " + size + ". Using " + waterUsed + " cups of water.");
        } else {
            System.out.println("Not enough water for selected cup size. Please refill");

            Thread.sleep(5000); // Simulate the time of choosing the size to prepare.

        }

    }

    private void brewCoffee() throws  InterruptedException {
        System.out.print("Brewing coffee...");
        Thread.sleep(45000); // Simulate the brewing time
        System.out.println("Coffee brewed.");
    }

    private void startAutoOffTimer() throws InterruptedException {
        System.out.println("Starting 10-min auto-off timer...");
        Thread.sleep(600000); // Simulate 10 minutes
        System.out.println("Turning off the coffee machine.");
    }
}
