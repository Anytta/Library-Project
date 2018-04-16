/**It is a public class. 
The purpose of the User class is to describe and represent the attributes of a library user and the actions that can be performed on a user 
The User class contains a constructor and 5 methods.**/

public class User 
  {
    private String userFirstName;
    private String userSurName;
    private String userName;
    private int userID;
    private int numOfItemsBorrowed;
    private static int nextID = 100;

    public final static int MAX_USERS= 5;
    public final static int MAX_ITEMS= 3; 

public User (String userFirstName, String userSurName)
  {
    this.userFirstName = userFirstName;
    this.userSurName = userSurName;
    this.userName= userSurName + " "+ userFirstName;
    numOfItemsBorrowed = 0;
    userID = nextID;
    nextID++;
  }
public String getName()
  {   
	return userName;
  }
public int getuserID()
  { 
	return userID;
  }
public int getnumOfItemsBorrowed()
  { 
	return numOfItemsBorrowed;
  }

public void incrementItems()
//It is a public method. The purpose of this method is to increment the number of items borrowed by certain user
  {
    if (numOfItemsBorrowed >= MAX_ITEMS) //It checks if the number of items is less than the maximum of items available
      {
    	System.out.println("The user cannot borrow an item because the user has already borrowed " + MAX_ITEMS + " items.");
      }
    else
      { 
    	numOfItemsBorrowed++; // It decrements the number of items of particular user
        System.out.println("The user " + userID + " now has " + numOfItemsBorrowed + " item(s)");
      }
    }                                              

public void decrementItems()
//It is a public method. The purpose of this method is to decrement the number of items borrowed by certain user
    {
      if (numOfItemsBorrowed <= 0) // It checks if the the number of items borrowed is bigger than 0
        {
    	  System.out.println("The user " + userID + " cannot return an item because the user has not borrowed any items.");
        }
      else
        { 
	      numOfItemsBorrowed--; // It decrements the number of items of particular user
          System.out.println("The user " + userID + " now has " + numOfItemsBorrowed + " item(s)");
        }
    }
  
  }
