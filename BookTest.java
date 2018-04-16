public class BookTest 
  {
	
  public static void main (String[] args)
    {
	 Book firstbook = new Book("The Witcher", "Andrzej", "Sapkowski", 66666666, 'F');
	  System.out.println("The title is " + firstbook.getTitle());
	  System.out.println("The author is " + firstbook.getAuthor());
	  System.out.println("The category is " + firstbook.getCategory());
	  System.out.println("The ID is " + firstbook.getID()); 
	}
  
  }
