
import java.io.PrintWriter;

public class CategoryNode
{
	private String Name;
	private LinkedList<FoodItem> foodItems = new LinkedList<FoodItem>();
	
	public CategoryNode(String Name)
	{
		this.Name = Name;
	}
	
	public void AddFoodItem(FoodItem Item)
	{
		
		FoodItem node = foodItems.getNode(Item);
		if (node == null)
		{
			foodItems.add(Item);
		}

	}
	
	public void DeleteFoodItem(FoodItem Item)
	{
		foodItems.delete(Item);
	}

	public boolean hasFoodItem(FoodItem Item)
	{
		return (foodItems.contains(Item));
	}
	
	public void UpdateFoodItem(FoodItem Item)
	{
		FoodItem item = foodItems.getNode(Item);
		if (item == null)
		{
			item = new FoodItem(Item.getName());
		}
		item.update(Item.getPrice(), Item.getQuantity(), Item.getDescription(), Item.getSize(), Item.getSpecialOrder());
		
	}
	
	public FoodItem getFoodItem(FoodItem Item)
	{
		
		FoodItem item = foodItems.getNode(Item);
		if (item != null)
		{
			return item;
		}
		else 
		{
			return null;
		}
		
	}
	
	public String getName()
	{
		return Name;
	}
	
	public String toString()
	{
		StringBuilder strBuilder = new StringBuilder("Category: ");
		strBuilder.append(Name + "\n\n");
		strBuilder.append(foodItems.toString());
		return strBuilder.toString();
	}
	
	public void writeData(PrintWriter outputStream)
	{

		outputStream.print(Name);
		outputStream.print("\n");
		LinkedListNode<FoodItem> node = foodItems.getFirst();
		while (node != null)
		{
			FoodItem data = node.getData();
			data.writeData(outputStream);
			node = node.getNext();
		}
	}
	
	
	public boolean equals(Object obj)
	{
	   boolean same = false;
	   if (obj != null)
	   {
		   if (obj instanceof CategoryNode){
			  CategoryNode otherNode = (CategoryNode)obj;
		      same = (Name.equals(otherNode.Name));
		   }
	   }
	   return same;
	}
}
