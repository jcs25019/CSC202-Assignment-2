import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CategoryList
{
	private LinkedList<CategoryNode> categories = new LinkedList<CategoryNode>();
	public CategoryList()
	{
		
	}
	
	public void AddCategory(CategoryNode Item)
	{
		CategoryNode node = categories.getNode(Item);
		if (node == null)
		{
			categories.add(Item);
		}
	}
	
	public void DeleteCategory(CategoryNode node)
	{
		categories.delete(node);
	}
	
	public void AddFoodItemToCategory(CategoryNode category, FoodItem item)
	{
	  	CategoryNode categoryNode = categories.getNode(category);
	  	if (categoryNode == null)
	  	{
	  	    AddCategory(category);
	  	    categoryNode = category;
	  	}
	    categoryNode.AddFoodItem(item);
	}
	
	public void UpdateFoodItem(CategoryNode category, FoodItem item)
	{
	  	CategoryNode categoryNode = categories.getNode(category);
	  	if (categoryNode != null)
	  	{
	  		categoryNode.UpdateFoodItem(item);
	  	}	 	
	}

	public FoodItem getFoodItem(CategoryNode category, FoodItem item)
	{
		FoodItem foodItem = null;
	  	CategoryNode categoryNode = categories.getNode(category);
	  	if (categoryNode != null)
	  	{
	  	    foodItem = categoryNode.getFoodItem(item);
	  	}
	  	return foodItem;
	}

	
	public void DeleteFoodItem(CategoryNode category, FoodItem item)
	{
	  	CategoryNode categoryNode = categories.getNode(category);
	  	if (categoryNode != null)
	  	{
	  	     categoryNode.DeleteFoodItem(item);
	  	}
	}
	
	public boolean isEmpty()
	{
		return categories.isEmpty();
	}
	
	public String toString()
	{
		return categories.toString();
	}
	
	public void writeData(String outfileName)
	{
		PrintWriter outputStream = null;
		try
		{
			outputStream = new PrintWriter(outfileName);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Error opening the file " + outfileName);
			System.exit(0);
		}
		
		LinkedListNode<CategoryNode> node = categories.getFirst();
		while (node != null)
		{
			CategoryNode data = node.getData();
			data.writeData(outputStream);
			node = node.getNext();
		}
		outputStream.close();
	}
	
	public void readData(String infileName)
	{
		Scanner infile = null;
		try
		{
			infile = new Scanner (new File (infileName));
		}
		catch (FileNotFoundException ex)
		{
			System.out.println ("file not found");
			System.exit (0);
		}

		while (infile.hasNext())
		{
			
		}

		infile.close();
	}

}
