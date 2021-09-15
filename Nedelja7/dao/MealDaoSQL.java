package rs.itbootcamp.dao;

import rs.itbootcamp.database.DatabaseConnection;
import rs.itbootcamp.model.FoodModel;
import rs.itbootcamp.model.MealModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MealDaoSQL implements MealDao{
    private static final Connection conn = DatabaseConnection.getConnection();
    @Override
    public void insert(MealModel mm) {
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO meal " +
                    "VALUES (?,?,?,?)");
            st.setInt(1, mm.getMealId());
            st.setString(2, mm.getMealName());
            st.setString(3, mm.getMealDesc());
            st.setString(4, mm.getMealDiff());
            st.executeUpdate();
            st.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement st = conn.prepareStatement("DELETE FROM meal WHERE meal_id = ?");
        st.setInt(1, id);
        st.executeUpdate();
    }

    @Override
    public void update(MealModel mm) {
        try {
            PreparedStatement st = conn.prepareStatement("UPDATE meal " +
                    "SET meal_id = ?, " +
                    "meal_name = ?, " +
                    "meal_desc = ?, " +
                    "meal_difficulty = ? " +
                    "WHERE meal_id = ?");
            st.setInt(1, mm.getMealId());
            st.setString(2, mm.getMealName());
            st.setString(3, mm.getMealDesc());
            st.setString(4, mm.getMealDiff());
            st.setInt(5, mm.getMealId());
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public MealModel getMeal(int id) throws SQLException {
        PreparedStatement st = conn.prepareStatement("SELECT * FROM meal WHERE meal_id = ?");
        st.setInt(1,id);
        ResultSet rs = st.executeQuery();
        rs.next();
        MealModel mm = new MealModel(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4));
        return mm;
    }

    @Override
    public List<MealModel> getAllMeals() {
        List<MealModel> allMeal = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM meal");
            while(rs.next()){
                MealModel newMeal = new MealModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)

                );

                allMeal.add(newMeal);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allMeal;
    }

    @Override
    public List<String> getFoodMealNames(int meal_id) throws SQLException {
        List<String> ingredient = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement("SELECT food_name FROM food \n" +
                    "JOIN mealfood ON food.food_id = mealfood.food_id\n" +
                    "JOIN meal ON mealfood.meal_id= meal.meal_id\n" +
                    "WHERE meal_id = ?");
            st.setInt(1, meal_id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                String name = rs.getString(2);
                ingredient.add(name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ingredient;
    }

        @Override
    public List<FoodModel> getFoodMeal(int meal_id) {
            List<FoodModel> ingredient = new ArrayList<>();
            try {
                PreparedStatement st = conn.prepareStatement("SELECT * FROM food \n" +
                        "JOIN mealfood ON food.food_id = mealfood.food_id\n" +
                        "JOIN meal ON mealfood.meal_id= meal.meal_id\n" +
                        "WHERE meal_id = ?");
                st.setInt(1, meal_id);
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    FoodModel newFood = new FoodModel(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getDouble(3),
                            rs.getDouble(4),
                            rs.getDouble(5),
                            rs.getDouble(6)
                    );
                    ingredient.add(newFood);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return ingredient;
    }
}
