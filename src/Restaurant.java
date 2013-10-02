public class Restaurant
{

	CategoryList restaurantCategories = new CategoryList();
	String FILENAME = "myFood.txt";

	public static void main(String[] args)
	{
		
		Restaurant myRestaurant = new Restaurant();
		
		// OR
		// Restaurant myRestaurant = new Restaurant(FILENAME);

	}
	
	// constructor to read the data in from the file
	public Restaurant(String filename)
	{
	   // restaurantCategories.readData(filename);	

		CategoryList restaurantCategories = new CategoryList();
		
		CategoryNode node = new CategoryNode("Sandwiches");
		restaurantCategories.AddCategory(node);
		
		FoodItem hamburgers = new FoodItem("hamburger", new Float (2.50), 12, "Quarter pound of beef on a bun", "Medium", "   ");
		node.AddFoodItem(hamburgers);
		
		FoodItem turkey = new FoodItem("turkey", new Float (2.75), 4, "Quarter pound of turkey on a bun", "large", "   ");
		node.AddFoodItem(turkey);
		
		CategoryNode badnode = new CategoryNode("BadGuy");
		restaurantCategories.AddCategory(badnode);
		FoodItem badFood = new FoodItem("badFood", new Float (2.50), 12, "gross", "Medium", "   ");
		badnode.AddFoodItem(badFood);
		System.out.println(restaurantCategories.toString());		
		
		restaurantCategories.DeleteFoodItem(badnode, badFood);
		System.out.println(restaurantCategories.toString());	
		
		restaurantCategories.DeleteCategory(badnode);
		
		System.out.println(restaurantCategories.toString());
}
	
	// constructor to use a gui
	public Restaurant()
	{
		VendorGUI gui = new VendorGUI(this);
		gui.setVisible(true);
	}
	
	
	//methods that the action listeners call
	public void addCategory(String name)
	{
		CategoryNode node = new CategoryNode(name);
		restaurantCategories.AddCategory(node);
		restaurantCategories.writeData(FILENAME);
	}
	
	public void addFoodItem(String CategoryName, String Name, Float Price, Integer Quantity, String Description, String Size, String SpecialOrder)
	{
		CategoryNode node = new CategoryNode(CategoryName);
		FoodItem foodItem = new FoodItem(Name, Price, Quantity, Description, Size, SpecialOrder);
		restaurantCategories.AddFoodItemToCategory(node, foodItem);
		restaurantCategories.writeData(FILENAME);
	}
	public void deleteCategory(String name)
	{
		CategoryNode node = new CategoryNode(name);
		restaurantCategories.DeleteCategory(node);
		restaurantCategories.writeData(FILENAME);
	}
	public void deleteFoodItem(String categoryName, String name)
	{
		CategoryNode node = new CategoryNode(categoryName);
		FoodItem foodItem = new FoodItem(name);
		restaurantCategories.DeleteFoodItem(node,foodItem);
		restaurantCategories.writeData(FILENAME);
	}
	public void updateFoodItem(String CategoryName, String Name, Float Price, Integer Quantity, String Description, String Size, String SpecialOrder)
	{
		CategoryNode node = new CategoryNode(CategoryName);
		FoodItem foodItem = new FoodItem(Name, Price, Quantity, Description, Size, SpecialOrder);
		restaurantCategories.UpdateFoodItem(node, foodItem);
		restaurantCategories.writeData(FILENAME);
	}
	public FoodItem searchFoodItem(String CategoryName, String Name)
	{
		FoodItem item = null;
		CategoryNode node = new CategoryNode(CategoryName);
		FoodItem foodItem = new FoodItem(Name);
		item = restaurantCategories.getFoodItem(node, foodItem);
		
		return item;
	}

	public String toString(){
		return restaurantCategories.toString();
	}

}
