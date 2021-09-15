package rs.itbootcamp.model;

public class MealModel {
    private int mealId;
    private String mealName, mealDesc, mealDiff;

    public MealModel(int mealId, String mealName, String mealDesc, String mealDiff) {
        this.mealId = mealId;
        this.mealName = mealName;
        this.mealDesc = mealDesc;
        this.mealDiff = mealDiff;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealDesc() {
        return mealDesc;
    }

    public void setMealDesc(String mealDesc) {
        this.mealDesc = mealDesc;
    }

    public String getMealDiff() {
        return mealDiff;
    }

    public void setMealDiff(String mealDiff) {
        this.mealDiff = mealDiff;
    }
}
