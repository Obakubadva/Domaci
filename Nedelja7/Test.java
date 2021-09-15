package rs.itbootcamp;

import rs.itbootcamp.dao.FoodDao;
import rs.itbootcamp.dao.FoodDaoSQL;
import rs.itbootcamp.model.FoodModel;

import java.util.Scanner;

public class Test {
    private static FoodModel userNewFood(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Unesite id: ");
        int id = sc.nextInt();
        System.out.println("Unesite name: ");
        String name = sc.next();
        System.out.println("Unesite kcal: ");
        double kcal = sc.nextDouble();
        System.out.println("Unesite proteine: ");
        double proteins = sc.nextDouble();
        System.out.println("Unesite UH: ");
        double carbs = sc.nextDouble();
        System.out.println("Unesite masti: ");
        double fats = sc.nextDouble();
        return new FoodModel(id,name,kcal,proteins,carbs,fats);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FoodDao fd = new FoodDaoSQL();

        String menu = """
                0. Exit
                1. Dodaj u tabelu Food
                2. Prikazi tabelu Food
                """;

        int choice = 5;
        while(choice != 0){
            System.out.println(menu);
            choice = sc.nextInt();
            switch(choice){
                case 0:
                    break;
                case 1:
                    fd.insert(userNewFood());
                    break;
                case 2:
                    System.out.println(fd.getAllFood());
                    break;
            }
        }

    }
}
