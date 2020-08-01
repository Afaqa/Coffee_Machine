package machine;

import java.util.Scanner;
import java.util.regex.Pattern;

enum CoffeeType {
    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6);
    int waterCost;
    int milkCost;
    int beanCost;
    int cost;

    CoffeeType(int water, int milk, int bean, int cost)
    {
        this.waterCost = water;
        this.milkCost = milk;
        this.beanCost = bean;
        this.cost = cost;
    }
}

public class CoffeeMachine {
    static int waterStock = 400;
    static int milkStock = 540;
    static int beanStock = 120;
    static int cupStock = 9;
    static int moneyStock = 550;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String action = "";
        int coffeeType;

        while (!action.equals("exit")) {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            action = scanner.nextLine();
            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String coffeeStr = scanner.nextLine();
                    if (!coffeeStr.equals("back")) {
                        coffeeType = Integer.parseInt(coffeeStr);
                        tryBuyCoffee(coffeeType);
                    }
                    break;
                case "fill":
                    System.out.println("Write how many ml of water do you want to add:");
                    waterStock += scanner.nextInt();
                    System.out.println("Write how many ml of milk do you want to add: ");
                    milkStock += scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans do you want to add:");
                    beanStock += scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee do you want to add: ");
                    cupStock += scanner.nextInt();
                    scanner.skip(Pattern.compile(" *\n"));
                    break;
                case "take":
                    System.out.println("\nI gave you $" + moneyStock);
                    moneyStock = 0;
                    break;
                case "remaining":
                    showRemainings();
                    break;
                default:
                    break;
            }
        }
    }

    public static void showRemainings()
    {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(waterStock + " of water");
        System.out.println(milkStock + " of milk");
        System.out.println(beanStock + " of coffee beans");
        System.out.println(cupStock + " of disposable cups");
        System.out.println("$" + moneyStock + " of money");
    }

    public static void tryBuyCoffee(int coffeeType)
    {
        CoffeeType coffee;

        switch(coffeeType)
        {
            case 1:
                coffee = CoffeeType.ESPRESSO;
                break;
            case 2:
                coffee = CoffeeType.LATTE;
                break;
            case 3:
                coffee = CoffeeType.CAPPUCCINO;
                break;
            default:
                return;
        }
        if (waterStock < coffee.waterCost) {
            System.out.println("Sorry, not enough water!");
            return;
        } else if (milkStock < coffee.milkCost) {
            System.out.println("Sorry, not enough milk!");
            return;
        } else if (beanStock < coffee.beanCost) {
            System.out.println("Sorry, not enough beans!");
            return;
        } else if (cupStock < 1) {
            System.out.println("Sorry, not enough cups!");
            return;
        } else {
            System.out.println("I have enough resources, making you a coffee!");
        }
        waterStock -= coffee.waterCost;
        milkStock -= coffee.milkCost;
        beanStock -= coffee.beanCost;
        cupStock -= 1;
        moneyStock += coffee.cost;
    }

//    public static int askInt(String message)
//    {
//        Scanner scanner = new Scanner(System.in);
//        int amount;
//
//        System.out.println(message);
//        amount = scanner.nextInt();
//        return amount;
//    }
//
//    public static void askStocks()
//    {
//        waterStock = askInt("Write how many ml of water the coffee machine has:");
//        milkStock = askInt("Write how many ml of milk the coffee machine has:");
//        beanStock = askInt("Write how many grams of coffee beans the coffee machine has:");
//    }
//
//    public static int askCoffeeAmount()
//    {
//        return askInt("Write how many cups of coffee you will need:");
//    }
//
//    public static void printCoffeeAvailable(int coffeeAmount)
//    {
//        int coffeeCups = waterStock / waterCost;
//        if (milkStock / milkCost < coffeeCups)
//            coffeeCups = milkStock / milkCost;
//        if (beanStock / beanCost < coffeeCups)
//            coffeeCups = beanStock / beanCost;
//        if (coffeeAmount == coffeeCups)
//            System.out.println("Yes, I can make that amount of coffee");
//        else if (coffeeAmount < coffeeCups)
//            System.out.println("Yes, I can make that amount of coffee (and even " +
//                    (coffeeCups - coffeeAmount) + " more than that)");
//        else
//            System.out.println("No, I can make only " + coffeeCups + " cup(s) of coffee");
//    }
//
//    public static void printCoffeeRequirements(int coffeeAmount)
//    {
//        if (coffeeAmount >= 0)
//        {
//            System.out.println("For " + coffeeAmount + " cups of coffee you will need:");
//            System.out.println(waterCost * coffeeAmount + " ml of water");
//            System.out.println(milkCost * coffeeAmount + " ml of milk");
//            System.out.println(beanCost * coffeeAmount + " g of coffee beans");
//        }
//    }
//
//    public static void makeCoffee()
//    {
//        System.out.println("Starting to make a coffee");
//        System.out.println("Grinding coffee beans");
//        System.out.println("Boiling water");
//        System.out.println("Mixing boiled water with crushed coffee beans");
//        System.out.println("Pouring coffee into the cup");
//        System.out.println("Pouring some milk into the cup");
//        System.out.println("Coffee is ready!");
//    }
}
