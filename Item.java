/** This is a public class. The purpose of the Item class is to describe and represent the attributes of a library item and actions we can perform with an item. 
 * Items in this particular library are books only. Each item identifier is identical to a corresponding book identifier. 
 * It contains one constructor and 5 methods.
 **/

public class Item 
  {
	int bookID;
	int userID;
	boolean onLoan;
	
	public Item (int bookID)
	  {  onLoan= false; 
	     userID = 0; 
	     this.bookID = bookID;
	  }
	public int getID()
	  {    
         return bookID;
	  }
	public boolean isOnLoan()
	  { 
		 return onLoan;
	  }
	public int getUserID()
	  { 
		return userID;
	  }
	
	public void borrowItem(int userID)	
	/**This method is public. 
	 * It updates the instance variables to indicate that the item is no longer available and is now on loan to a particular user.
	 **/	
	  { 
	    if (onLoan == true) //It checks if the item is not already on loan. 
	       {
	         System.out.println("Item is already on loan, cannot be borrowed");
	       }
	    else 
		   { 
	        onLoan = true; //If the item is available to borrow, the onLoan variable is set to true and the userID set to the value of the input parameter
		    this.userID =userID;
		    System.out.println("Item " + bookID +  " has been successfully borrowed by user " + userID);
		   }  
	   }
	
	public void returnItem()
	
	/** This method is public. It updates instance variables to indicate that the item has been returned and is now available for loan **/
	  { 
		if (onLoan == false) // It checks if the item is not already on loan.
          {
			System.out.println("Item is not on loan, cannot be return");
          }
        else 
	      { onLoan = false; //If the item is on loan, the onLoan variable is set to false and the userID set to 0. 
	        userID=0;
	        System.out.println("Item " + bookID +  " has been successfully returned");
	      }
	   }
	
  }

