
/**This is a public class. The purpose of the Book class is to describe and represent the attributes of books and behavior associated with the books.
It contains 1 constructor and 4 getter methods taking no parameters. 
**/

public class Book 
  { 
    String title;
    String authorFirstName;
    String authorSurName;
    String Name;
    int ID;
    char category; 
  
    public Book (String title, String authorFirstName, String authorSurName, int ID, char category)
     {
       this.title = title;
       this.authorFirstName = authorFirstName;
       this.authorSurName = authorSurName;
       this.Name = authorFirstName + " " + authorSurName;
       this.ID = ID;
       this.category = category;
     }
  
    public String getTitle() 
     { 
    	return title;
     }
    public String getAuthor() 
     { 
	   return Name;
     }
    public int getID() 
     {  
	  return ID;
     }
    public char getCategory()
     { 
	  return category;
     }
 
  } 
  
