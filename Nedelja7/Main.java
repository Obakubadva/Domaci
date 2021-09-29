package rs.itbootcamp;

import rs.itbootcamp.dao.*;
import rs.itbootcamp.model.FoodModel;
import rs.itbootcamp.model.MealModel;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static FoodDao fd = new FoodDaoSQL();
    static MealDao mm = new MealDaoSQL();
    static int fridge_id = 1;
    static FrigdeDao fr = new FridgeDaoSQL();

    private static void welcomeMessage() {
        System.out.println("Welcome to kitchen!!!");
        System.out.println("------------------------");
    }

    private static void addFoodToFridge(Scanner sc) {
        List<FoodModel> foodList = fd.getAllFood();
        int choice = -1;

        while (choice != 0) {
            for (int i = 0; i < foodList.size(); i++) {
                System.out.println((i + 1) + ". " + foodList.get(i));
            }
            System.out.println("0. Back");

            choice = sc.nextInt();

            if (choice > 0 && choice <= foodList.size()) {
                System.out.println("How much: (in grams)");
                double mass = sc.nextDouble();
                fd.addToFridge(fridge_id, foodList.get(choice - 1).getFoodId(), mass);
                System.out.println("++");
            }
        }
    }

    private static void removeFoodFromFridge(Scanner sc) {
        List<FoodModel> foodList = fd.getAllFood();
        int choice = -1;

        while (choice != 0) {
            for (int i = 0; i < foodList.size(); i++) {
                System.out.println((i + 1) + ". " + foodList.get(i));
            }
            System.out.println("0. Back");

            choice = sc.nextInt();

            if (choice > 0 && choice <= foodList.size()) {

                fd.delete(fridge_id);
                System.out.println("--");
            }
        }

    }

    private static void allFoodInFridge(Scanner sc) {
        List<FoodModel> fm = fr.getAllFood(fridge_id);
        int choice = -1;
        while (choice != 0) {
            for (int i = 0; i < fm.size(); i++) {
                System.out.println((i + 1) + ". " + fm.get(i));
            }
            System.out.println("0. Back");
            choice = sc.nextInt();
            if (choice > 0 && choice <= fm.size()) {
                System.out.println(fd.getFood(choice));
                ;
            }


        }
    }

    private static void fridgeMenu(Scanner sc) {
        int choice;
        do {
            System.out.println("My Fridge:");
            System.out.println("--------");
            System.out.println("1. Add food");
            System.out.println("2. Remove food");
            System.out.println("3. Look in");
            System.out.println("4. Create meal");
            System.out.println("0. Back");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addFoodToFridge(sc);
                case 2 -> removeFoodFromFridge(sc);
                case 3 -> allFoodInFridge(sc);
                case 4 -> System.out.println("Create meal");
                case 0 -> System.out.println();
                default -> System.out.println("Invalid option");
            }
        } while (choice != 0);
    }

    private static void foodKeyWord(Scanner sc) {
        List<FoodModel> fm = fd.getAllFood();
        int choice;
        do {
            List<FoodModel> novi = new ArrayList<>();
            System.out.println("Enter key words: ");
            String str = sc.next().toLowerCase();
            for (int i = 0; i < fm.size(); i++) {
                if (fm.get(i).getFoodName().toLowerCase().contains(str))
                    novi.add(fm.get(i));
            }
            do {
                if (novi.size() == 0) {
                    System.out.println("No items found");
                    break;
                }
                System.out.println("Enter items per page");
                int limit = sc.nextInt();
                if (limit > novi.size()) {
                    System.out.println("Limit must not be higher then " + novi.size());
                    if (novi.size() <= 10)
                        limit = 1;
                    if (novi.size() > 10 && novi.size() <= 100)
                        limit = 10;
                    if (novi.size() > 100)
                        limit = 50;
                }
                int pageNumber = 1;
                int to = pageNumber * limit;
                int from = to - limit;
                for (int i = from; i < to; i++) {
                    System.out.println(novi.get(i));
                }
                System.out.println("----------------------------------------------------");
                if (novi.size() % limit == 0) {
                    for (int i = 1; i <= (novi.size() / limit); i++) {
                        System.out.print(i + " ");
                    }
                } else {
                    for (int i = 1; i <= (novi.size() / limit) + 1; i++) {
                        System.out.print(i + " ");
                    }
                }
                System.out.println();
                System.out.println("0. Back");
                System.out.println();
                choice = sc.nextInt();
                if (choice == novi.size() / limit + 1) {
                    from = (choice - 1) * limit;
                    to = from + (novi.size() % limit);
                } else {
                    pageNumber = choice;
                    to = pageNumber * limit;
                    from = to - limit;
                }

            } while (choice != 0);
            System.out.println("1. Search again");
            System.out.println("0. Back");
            choice = sc.nextInt();
        } while (choice != 0);
    }

    private static void foodFirstLetter(Scanner sc) {
        List<FoodModel> fm = fd.getAllFood();
        int choice;
        do {
            List<FoodModel> novi = new ArrayList<>();
            System.out.println("Enter the forst letter: ");
            String str = sc.next().toLowerCase();
            for (int i = 0; i < fm.size(); i++) {
                if (fm.get(i).getFoodName().toLowerCase().startsWith(str))
                    novi.add(fm.get(i));
            }
            do {
                if (novi.size() == 0) {
                    System.out.println("No items found");
                    break;
                }
                System.out.println("Enter items per page");
                int limit = sc.nextInt();
                if (limit > novi.size()) {
                    System.out.println("Limit must not be higher then " + novi.size());
                    if (novi.size() <= 10)
                        limit = 1;
                    if (novi.size() > 10 && novi.size() <= 100)
                        limit = 10;
                    if (novi.size() > 100)
                        limit = 50;
                }
                int pageNumber = 1;
                int to = pageNumber * limit;
                int from = to - limit;
                for (int i = from; i < to; i++) {
                    System.out.println(novi.get(i));
                }
                System.out.println("----------------------------------------------------");
                if (novi.size() % limit == 0) {
                    for (int i = 1; i <= (novi.size() / limit); i++) {
                        System.out.print(i + " ");
                    }
                } else {
                    for (int i = 1; i <= (novi.size() / limit) + 1; i++) {
                        System.out.print(i + " ");
                    }
                }
                System.out.println();
                System.out.println("0. Back");
                System.out.println();
                choice = sc.nextInt();
                if (choice == novi.size() / limit + 1) {
                    from = (choice - 1) * limit;
                    to = from + (novi.size() % limit);
                } else {
                    pageNumber = choice;
                    to = pageNumber * limit;
                    from = to - limit;
                }

            } while (choice != 0);
            System.out.println("1. Search again");
            System.out.println("0. Back");
            choice = sc.nextInt();
        } while (choice != 0);
    }

    private static void searchFood(Scanner sc) {
        int choice;
        do {
            System.out.println("1. Search by key word(s)");
            System.out.println("2. Search by first letter");
            System.out.println("0. Back");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> foodKeyWord(sc);
                case 2 -> foodFirstLetter(sc);
                case 0 -> System.out.println();
                default -> System.out.println("Invalid option");
            }
        } while (choice != 0);
    }

    private static void mealKeyWord(Scanner sc) {
        List<MealModel> fm = mm.getAllMeals();
        int choice;
        do {
            List<MealModel> novi = new ArrayList<>();
            System.out.println("Enter key words: ");
            String str = sc.next().toLowerCase();
            for (int i = 0; i < fm.size(); i++) {
                if (fm.get(i).getMealName().toLowerCase().contains(str) && fm.get(i).getMealDesc().toLowerCase().contains(str))
                    novi.add(fm.get(i));
            }
            do {
                if (novi.size() == 0) {
                    System.out.println("No items found");
                    break;
                }
                System.out.println("Enter items per page");
                int limit = sc.nextInt();
                if (limit > novi.size()) {
                    System.out.println("Limit must not be higher then " + novi.size());
                    if (novi.size() <= 10)
                        limit = 1;
                    if (novi.size() > 10 && novi.size() <= 100)
                        limit = 10;
                    if (novi.size() > 100)
                        limit = 50;
                }
                int pageNumber = 1;
                int to = pageNumber * limit;
                int from = to - limit;
                for (int i = from; i < to; i++) {
                    System.out.println(novi.get(i));
                }
                System.out.println("----------------------------------------------------");
                if (novi.size() % limit == 0) {
                    for (int i = 1; i <= (novi.size() / limit); i++) {
                        System.out.print(i + " ");
                    }
                } else {
                    for (int i = 1; i <= (novi.size() / limit) + 1; i++) {
                        System.out.print(i + " ");
                    }
                }
                System.out.println();
                System.out.println("0. Back");
                System.out.println();
                choice = sc.nextInt();
                if (choice == novi.size() / limit + 1) {
                    from = (choice - 1) * limit;
                    to = from + (novi.size() % limit);
                } else {
                    pageNumber = choice;
                    to = pageNumber * limit;
                    from = to - limit;
                }

            } while (choice != 0);
            System.out.println("1. Search again");
            System.out.println("0. Back");
            choice = sc.nextInt();
        } while (choice != 0);
    }

    private static void mealFirstLetter(Scanner sc) {
        List<MealModel> fm = mm.getAllMeals();
        int choice;
        do {
            List<MealModel> novi = new ArrayList<>();
            System.out.println("Enter the first letter: ");
            String str = sc.next().toLowerCase();
            for (int i = 0; i < fm.size(); i++) {
                if (fm.get(i).getMealName().toLowerCase().startsWith(str))
                    novi.add(fm.get(i));
            }
            do {
                if (novi.size() == 0) {
                    System.out.println("No items found");
                    break;
                }
                System.out.println("Enter items per page");
                int limit = sc.nextInt();
                if (limit > novi.size()) {
                    System.out.println("Limit must not be higher then " + novi.size());
                    if (novi.size() <= 10)
                        limit = 1;
                    if (novi.size() > 10 && novi.size() <= 100)
                        limit = 10;
                    if (novi.size() > 100)
                        limit = 50;
                }
                int pageNumber = 1;
                int to = pageNumber * limit;
                int from = to - limit;
                for (int i = from; i < to; i++) {
                    System.out.println(novi.get(i));
                }
                System.out.println("----------------------------------------------------");
                if (novi.size() % limit == 0) {
                    for (int i = 1; i <= (novi.size() / limit); i++) {
                        System.out.print(i + " ");
                    }
                } else {
                    for (int i = 1; i <= (novi.size() / limit) + 1; i++) {
                        System.out.print(i + " ");
                    }
                }
                System.out.println();
                System.out.println("0. Back");
                System.out.println();
                choice = sc.nextInt();
                if (choice == novi.size() / limit + 1) {
                    from = (choice - 1) * limit;
                    to = from + (novi.size() % limit);
                } else {
                    pageNumber = choice;
                    to = pageNumber * limit;
                    from = to - limit;
                }

            } while (choice != 0);
            System.out.println("1. Search again");
            System.out.println("0. Back");
            choice = sc.nextInt();
        } while (choice != 0);
    }

    private static void mealWithException(Scanner sc) {
        List<MealModel> fm = mm.getAllMeals();
        int choice;
        do {
            List<MealModel> novi = new ArrayList<>();
            System.out.println("Enter the ingrediant to exclude: ");
            String str = sc.next().toLowerCase();
            for (int i = 0; i < fm.size(); i++) {
               List<FoodModel> foodM=mm.getFoodMeal(fm.get(i).getMealId());
                for (int j = 0; j < foodM.size(); j++) {
                    if (!foodM.get(j).getFoodName().equalsIgnoreCase(str))
                        novi.add(fm.get(i));
                }
            }
            do {
                if (novi.size() == 0) {
                    System.out.println("No items found");
                    break;
                }
                System.out.println("Enter items per page");
                int limit = sc.nextInt();
                if (limit > novi.size()) {
                    System.out.println("Limit must not be higher then " + novi.size());
                    if (novi.size() <= 10)
                        limit = 1;
                    if (novi.size() > 10 && novi.size() <= 100)
                        limit = 10;
                    if (novi.size() > 100)
                        limit = 50;
                }
                int pageNumber = 1;
                int to = pageNumber * limit;
                int from = to - limit;
                for (int i = from; i < to; i++) {
                    System.out.println(novi.get(i));
                }
                System.out.println("----------------------------------------------------");
                if (novi.size() % limit == 0) {
                    for (int i = 1; i <= (novi.size() / limit); i++) {
                        System.out.print(i + " ");
                    }
                } else {
                    for (int i = 1; i <= (novi.size() / limit) + 1; i++) {
                        System.out.print(i + " ");
                    }
                }
                System.out.println();
                System.out.println("0. Back");
                System.out.println();
                choice = sc.nextInt();
                if (choice == novi.size() / limit + 1) {
                    from = (choice - 1) * limit;
                    to = from + (novi.size() % limit);
                } else {
                    pageNumber = choice;
                    to = pageNumber * limit;
                    from = to - limit;
                }

            } while (choice != 0);
            System.out.println("1. Search again");
            System.out.println("0. Back");
            choice = sc.nextInt();
        } while (choice != 0);
    }

    private static void searchMeal(Scanner sc) {
        int choice;
        do {
            System.out.println("1. Search by key word(s)");
            System.out.println("2. Search by first letter");
            System.out.println("3. Search with exception");
            System.out.println("0. Back");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> mealKeyWord(sc);
                case 2 -> mealFirstLetter(sc);
                case 3 -> mealWithException(sc);
                case 0 -> System.out.println();
                default -> System.out.println("Invalid option");
            }
        } while (choice != 0);
    }

    private static void search(Scanner sc) {
        int choice;
        do {
            System.out.println("1. Search food");
            System.out.println("2. Search meal");
            System.out.println("0. Back");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> searchFood(sc);
                case 2 -> searchMeal(sc);
                case 0 -> System.out.println();
                default -> System.out.println("Invalid option");
            }
        } while (choice != 0);

    }

    private static void mainMenu(Scanner sc) {
        int choice;
        do {
            System.out.println("Main menu:");
            System.out.println("-----------");
            System.out.println("1. My Fridge");
            System.out.println("2. Meals");
            System.out.println("3. All food");
            System.out.println("4. Add new food");
            System.out.println("5. Search");
            System.out.println("0. Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> fridgeMenu(sc);
                case 2 -> System.out.println("Meals");
                case 3 -> System.out.println("All food");
                case 4 -> System.out.println("Add new food");
                case 5 -> search(sc);
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option");
            }
        } while (choice != 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        welcomeMessage();

        mainMenu(sc);
    }
}

