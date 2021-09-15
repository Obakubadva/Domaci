package rs.itbootcamp.dao;

import rs.itbootcamp.model.FoodModel;

import java.sql.SQLException;
import java.util.List;

public interface FoodDao {
    void insert(FoodModel fm);
    void addToMeal(int meal_id, int food_id, double mass) throws SQLException;
    void delete(int id) throws SQLException;
    void update(FoodModel fm);
    FoodModel getFood(int id) throws SQLException;
    List<FoodModel> getAllFood();
}
