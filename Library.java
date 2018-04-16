
/**It is a public class. The Library class is the driver program for the Library Management System. 
 * The library contains majority of the methods required to administer the library. It contains arrays for books, items and users. 
 * This class contains two types of methods: methods that manage user interface and methods that administer the library.
 */
    import java.util.ArrayList;
    import java.util.Scanner;

	public class Library {

		private static ArrayList<Book> books;  // an arrayList of books
		private static ArrayList<Item> items;  // an arrayList of items
		private static ArrayList<User> users;  // an arrayList of users
		
		private final static int MAX_USERS = User.MAX_USERS;
		private final static int MAX_CATALOGUE = 10;
		

		/**---------------------------------------------------------------**/
		public static void initialiseLibrary () {

			books = new ArrayList<Book>(MAX_CATALOGUE);  
			items = new ArrayList<Item>(MAX_CATALOGUE);  
			users = new ArrayList<User>(MAX_USERS);  

			// Initialise the library catalog with 5 sample books
			books.add(new Book
				("A Tale of Two Cities", "Charles", "Dickens",  11111111, 'F'));
			books.add(new Book
				("The Lord of the Rings", "John R. R.", "Tolkien", 22222222, 'F'));
			books.add(new Book
				("A Brief History of Time", "Stephen", "Hawking",  33333333, 'N'));
			books.add(new Book
				("Java Concepts", "Cay S.", "Horstmann",  44444444, 'N'));
			books.add(new Book
				("Moneyball", "Michael", "Lewis",  55555555, 'S'));
			
			
			// Initialise the library catalog with 5 sample books		
			// Each item in the library catalogue should correspond with a book 
			// in the book array, and appear in the same order in both 
			// arraylists. 
			for (int i = 0; i < 5; i++) {
				int bookID = books.get(i).getID();
				items.add(new Item(bookID));
			}
			
			// Initialise the library membership with 4 users
			users.add(new User("Joe", "Bloggs"));
			users.add(new User("Bill", "Gates"));		
			users.add(new User("Henry", "Ford"));
			users.add(new User("Grace", "Kelly"));	
		}
		
		public static void initialiseSystemTest () 
		{

			books = new ArrayList<Book>(MAX_CATALOGUE);  
			items = new ArrayList<Item>(MAX_CATALOGUE);  
			users = new ArrayList<User>(MAX_USERS);  

			// Initialise the library catalog with 5 sample books
			books.add(new Book
				("A Fortune-Teller Told Me", "Tiziano", "Terzani",  11111111, 'T'));
			books.add(new Book
				("Letters Agains The War", "Tiziano", "Terzani", 22222222, 'T'));
			books.add(new Book
				("Alone Together", "Sherry", "Turkle",  33333333, 'N'));
			books.add(new Book
				("Pride and Prejudice", "Jane", "Austen",  44444444, 'N'));
			books.add(new Book
				("The Sword and The Passion", "Yanina", "Stachura",  55555555, 'F'));
			
		
			for (int i = 0; i < 5; i++) 
			  {
				int bookID = books.get(i).getID();
				items.add(new Item(bookID));
			  }
			// Initialise the library membership with 4 users
			users.add(new User("Martin", "Pokorny"));
			users.add(new User("Martin", "O'Connor"));		
			users.add(new User("Jacek", "Kelyff"));
			users.add(new User("Jacek", "Kaczmarski"));	
		 }
		
		/**---------------------------------------------------------------**/
		public static void main (String[] args) {
		
			
			initialiseSystemTest();
			
			Scanner scan = new Scanner(System.in);
			int menuOption = 0;
		
			while (true) {
				clearConsole();
				System.out.println("Please Make a selection:"); 		
				System.out.println("[1] Borrow item"); 			
				System.out.println("[2] Return item"); 
				System.out.println("[3] Search for item(s) in Library"); 			
				System.out.println("[4] Library Administration"); 
				System.out.println("[0] Exit"); 
				System.out.print("Enter your choice > "); 			

				menuOption = scan.nextInt();
				
				switch(menuOption) {
					case 0: System.exit(0);
						break;			
					case 1: borrowItemMenu();
						break;
					case 2: returnItemMenu();
						break;			
					case 3: searchItems();
						break;
					case 4: libraryAdminMenu();
						break;	
					default:
						System.out.print("You have inputted an invalid option. ");
						System.out.println("press enter to continue.");
						pauseMe();
						break;
				}	
			}	
		}
		
		/**---------------------------------------------------------------**/
		private static void clearConsole() {
			for (int i=0; i < 100; i++) {
				System.out.println("");
			}
		}	
		
		/**---------------------------------------------------------------**/
		private static void pauseMe() {
			Scanner scan = new Scanner(System.in);
			
			System.out.println("press enter to continue.");		
			scan.nextLine();	
			
		}

		/**---------------------------------------------------------------**/
		public static void borrowItemMenu() {
		
			if (users.size() <= 0) {
				clearConsole();
				System.out.println("The library membership is empty. ");	
				pauseMe();
				return;
			}
			
			if (items.size() <= 0) {
				clearConsole();
				System.out.println("The library catalogue is empty. ");	
				System.out.println("There are no items available to lend. ");
				pauseMe();
				return;
			}
			
			Scanner scan = new Scanner(System.in);
			int menuOption = 0;

			while (true) {		
				clearConsole();
				System.out.println("Please Make a selection:"); 		
				System.out.println("1.[1] Borrow item from Library "); 
				System.out.println("1.[2] List all items in Library"); 	
				System.out.println("1.[3] Return to previous menu"); 		
				System.out.print("Enter your choice > "); 			

				menuOption = scan.nextInt();
				
				switch(menuOption) {	
					case 1: borrowItemFromLibrary();
						break;
					case 2: printItems();
						break;			
					case 3: return;
					default:
						System.out.print("You have inputted an invalid option. ");
						pauseMe();
						break;
				}
			}
		}

		/**---------------------------------------------------------------**/
		public static void returnItemMenu() {
		
			if (users.size() <= 0) {
				clearConsole();
				System.out.print("The library membership is empty. ");	
				System.out.println("Therefore, there are no items to return. ");
				pauseMe();
				return;
			}
			
			if (items.size() <= 0) {
				clearConsole();
				System.out.println("The library catalogue is empty. ");	
				System.out.println("Therefore, there are no items to return. ");
				pauseMe();
				return;
			}		
			
			Scanner scan = new Scanner(System.in);
			int menuOption = 0;

			while (true) {		
				clearConsole();
				System.out.println("Please Make a selection:"); 		
				System.out.println("2.[1] Return item to Library."); 
				System.out.println("2.[2] List all items in Library."); 	
				System.out.println("2.[3] Return to previous menu."); 		
				System.out.print("Enter your choice > "); 			

				menuOption = scan.nextInt();
				
				switch(menuOption) {	
					case 1: returnItemToLibrary();
						break;
					case 2: printItems();
						break;			
					case 3: return;
					default:
						System.out.print("You have inputted an invalid option. ");
						pauseMe();
						break;
				}
			}
		}		
		
		/**---------------------------------------------------------------**/
		public static void libraryAdminMenu() {
			Scanner scan = new Scanner(System.in);
			int menuOption = 0;

			while (true) {		
				clearConsole();
				System.out.println("Please Make a selection:"); 		
				System.out.println("4.[1] Add Item."); 
				System.out.println("4.[2] Delete Item."); 
				System.out.println("4.[3] List Items."); 
				System.out.println("4.[4] List Users."); 				
				System.out.println("4.[5] Return to previous menu."); 		
				System.out.print("Enter your choice > "); 			

				menuOption = scan.nextInt();
				
				switch(menuOption) {	
					case 1: 	addItem();
						break;
					case 2: 	deleteItem();
						break;	
					case 3: 	printItems();
						break;
					case 4: 	printUsers();
						break;
					case 5: return;					
					default:
						System.out.print("You have inputted an invalid option. ");
						pauseMe();
						break;
				}
			}
		}
			
		
		public static boolean isItemInLibrary (int itemID) 
		/** It is a public method. The purpose of this method is to verify that a particular itemID exists in the library catalogue. 
		 *  The method receives one parameter – an itemID and returns one parameter – a boolean.
		 *  This boolean returns true if the item is in the library catalogue or false if the item is not in the library.
		 */		
		  {
			boolean itemInTheLibrary = false;
			for (int i=0; i< items.size(); i++)
				if (items.get(i).getID() == itemID)
				  { 
					itemInTheLibrary  = true;
				  }
			return itemInTheLibrary ;
		  }
		
		
		public static void printItems() 
		/** It is a public method. The purpose of this method is to print all items in the library catalogue to the console. 
		 * This method first prints out the total number of items in the library catalogue. 
		 * Then it prints out following details of each item in the library catalogue: Title, Author, ItemID, Category, availability using getter methods.  
		 */
		  {
			if (items.size() > 0)  // It checks how many items are in the catalog
			   { 
			     System.out.println("There are " + items.size() + " in the Library: " + "\n");
			     for (int i=0; i< books.size(); i++)
				   {
			    	 System.out.println("\n");
			         System.out.println("Item " + books.get(i).getID()  + " in the library:"); // It prints all books attributes
			         System.out.println(books.get(i).getAuthor());
			         System.out.println(books.get(i).getTitle());
			         System.out.println(books.get(i).getID());
			         System.out.println(books.get(i).getCategory());
			         
			    
			             
			         if (items.get(i).isOnLoan()) // It checks if the item is on loan
			           {
				         System.out.println("The book is on loan to user: " + items.get(i).getUserID());
				         
			    	   }
			    	
			        else 
			    	   {
			        	System.out.println("The book is not on loan");
			    	   }
			        }  
			     }
			   
			 else 
			   {
				System.out.println("No items in the library");
			   }
			pauseMe();
					
	      }
		public static boolean isUserInLibrary(int userID) 
		/** It is a public method. The purpose of this method is to verify that a particular userID exists in the library membership. 
		 * This method receives one parameter – a userID and returns one parameter – a boolean.  
		 * This boolean returns true if the userID is present in the library catalogue or false if the userID is not present in the library catalogue
		 */
		  {
			  boolean userInTheLibrary = false;
			  for (User user : users) 
			    {
			      if (user.getuserID() == userID)
			        {
			    	  userInTheLibrary = true;
			        }
			     }
			  return userInTheLibrary;
		   }
		

		 public static void printUsers() 
		 /**It is a public method. The purpose of this method is to print all users in the library catalogue to the console. 
		  * It first prints out the total number of the users in the library catalogue. 
		  * Then it prints following details of each user in the library catalogue: Name, UserID, Number of item(s) using getter methods.
		  */
		   {
			  if (users.size() == 0) // It checks if the library has any users
			    {
			      System.out.println("The library membership is empty");
			    } 
			  else 
			    {
			      System.out.println("The library has " + users.size() + " users"); // It checks how many users are in the library
			      for (int i = 0; i < users.size(); i++)  // It print all users' attributes
			        {
			          System.out.println("User " + users.get(i).getuserID()  + " in the library:"); 
			          System.out.println("Name: " + users.get(i).getName());
			          System.out.println("user ID: " + users.get(i).getuserID());
			          System.out.println("Number of items borrowed: " + users.get(i).getnumOfItemsBorrowed());
			        }
			     }
			   pauseMe();
			  
		   }	
			public static void searchItems()
			/**It is a public method. The purpose of this method is to search in the library catalogue 
			 * for an item that has a book title containing a particular case-sensitive string and to print out the results.
			 * It uses getter methods to print books' attributes. 
			 */
			  {
			    if (items.size() ==0) // It checks if the catalogue has any items
			       {
			         System.out.println("The library catalogue is empty");
			       }
			    else
			       {
			         Scanner scanner=new Scanner(System.in);
			         int found=0;
			         System.out.println("This option allows you to search for an item(s) whose title starts with a specific string"); 
			         System.out.println("Please enter the search string > "); 
			         String input=scanner.nextLine();
			         
			         for (int i = 0; i < books.size(); i++) // It looks for a particular string and give the results
			           {
			            if (books.get(i).getTitle().indexOf(input)>= 0 )
			               {
			                 found++;
			                 System.out.println("Item "+ found +" in the library:");
			                 System.out.println(books.get(i).getTitle());
			                 System.out.println(books.get(i).getAuthor());    
			                 System.out.println(books.get(i).getID());
			                 System.out.println(books.get(i).getCategory());
			                
			                 if ( items.get(i).isOnLoan()) //It cheks the availability of an item
			                   {
			                     System.out.println("This item is on loan to userID: "+ items.get(i).getUserID());
			                   } 
			                 else  
			                   {
			                     System.out.println("This item is available.");
			                   }
			                }
			             }
			    
			            System.out.println("Found " + found+" items in total"); // It prints total number of items found
			            pauseMe();
			         }
			   }
			 
			
			public static boolean incrementUserItems(int IDofUser)
			/**It is a public method. The purpose of this method is to then increment the number of the items borrowed by particular user. 
			 * The method returns a parameter – a boolean – true if the number of items was successfully incremented or false if not successfully incremented.
			 * The method use getnumOfItemsBorrowed() method.
			 */
			  {
			    User targetUser=null;
			    boolean isnumberOfUsersItemsIncremented = false;
			    int numOfItemsBorrowed=-1;
			    for (User user : users) 
			       { 
			         if (IDofUser == user.getuserID()) // It increments the number of items borrowed by the user
			            {
			              numOfItemsBorrowed= user.getnumOfItemsBorrowed();
			              user.incrementItems();
			              targetUser=user;
			              isnumberOfUsersItemsIncremented = true;
			            }
			        }
			    return isnumberOfUsersItemsIncremented;
			   }

			public static boolean decrementUserItems(int userID)
			/**It is a public method. The purpose of this method is to decrement the number of the items borrowed by the particular user. 
			 * The method returns a parameter – a boolean – true if the number of items was successfully decremented or false if not successfully decremented.
			 * It uses the getnumOfItemsBorrowed() method.
			 */
			  {
			    User targetUser=null;
			    int numOfItemsBorrowed=-1;
			    boolean isnumberOfUsersItemsDecremented = false;
			    for (User user : users) 
			        {
			          if (userID == user.getuserID()) // It decrements the number of items borrowed by the user
			             {
			               numOfItemsBorrowed=user.getnumOfItemsBorrowed();
			               user.decrementItems();
			               targetUser=user;
			               isnumberOfUsersItemsDecremented = true; 
			              }
			         }
			     return isnumberOfUsersItemsDecremented;
			   }
		
	public static void addItem()
	/**It is a public method. The purpose of this method is to add a new item to the library catalogue.
	 *  The details of the new item to be added are prompted to enter. 
	 *  The details are: Title, First name of author, Surname of author, Book ID, Category.
	 */
	  { 
		
		Scanner scan = new Scanner(System.in);
		if (items.size() > MAX_CATALOGUE) // It checks if the catalogue is not full
		   { 
			System.out.println("The library catalogue is full. The library catalogue limit is " + MAX_CATALOGUE + " items.");
		   }
		else 
		   { 
			//book is added to the book arraylist 
			System.out.println("Enter title of item > ");
			String titleOfNewBook = scan.nextLine(); 				
			System.out.println("Enter first name of author > ");
			String authorNameOfNewBook = scan.nextLine(); 
			System.out.println("Enter surname of author > ");
			String authorSurnameOfNewBook = scan.nextLine(); 
			System.out.println("Enter item ID > ");
			int IDOfNewBook = scan.nextInt(); 
			scan.nextLine();
			System.out.println("Enter category of item > ");
			String categoryOfNewBook = scan.nextLine();
			char category = categoryOfNewBook.charAt(0); 
			
			books.add(new Book
					 (titleOfNewBook, authorNameOfNewBook, authorSurnameOfNewBook, IDOfNewBook, category));
			//new item is added to the library catalogue (the items arraylist) 
			items.add(new Item
					(IDOfNewBook));			
		  // the confirmation of the oparation is printed 
			System.out.println("Item "+ IDOfNewBook + " successfully added to library");
		  }
		pauseMe();
	  }	
	
	public static void deleteItem()
	/**It is a public method. The purpose of this method is to delete an item from the library catalogue. 
	 * The library administrator must be prompted to enter the itemID of the item to be deleted.
	 * This method uses other methods as isItemInLibrary().
	 */
	  { 
	    Scanner scan = new Scanner(System.in);
		if (items.size() == 0)  //It verifies if the library catalog is not empty
		   { 
			System.out.println("The library catalog is empty");
		   
		   }
	    else 
		   {
	    	System.out.println("Enter item ID > ");
		     
		     int IDtoBeChecked = scan.nextInt(); 
		     if (isItemInLibrary(IDtoBeChecked) == false) // It checks if the item is in the catalog
			    { 
		    	 System.out.println("The item ID " + IDtoBeChecked + " does not exist in the Library catalog");
		    	 pauseMe();
		    	 return;
			    }  
		     else 
			     {    
		    	   for (int i=0; i< items.size(); i++)  // It checks if the item is not on loan
		               { 
		    		     if (items.get(i).getID() == IDtoBeChecked)
		                    {
		    		    	 if (items.get(i).isOnLoan())
			                    { System.out.println("Item " + IDtoBeChecked + " cannot be deleted because it is currently on loan to user " +items.get(i).getUserID());
			                      pauseMe();
			                      return;
			                    }
				             }				    	       
					    else
			                {
			    	          int position = 0; // It deletes the item from books and items array			         
			    	          for (int j=0; j< books.size(); j++)
				                  { 
			    	    	        if (books.get(j).getID()== IDtoBeChecked)
				                       {
				                         position = j; 
			    	                     books.remove(j); 
			    	                     items.remove(j);
			    	                     System.out.println("Item " + IDtoBeChecked + " was successfully deleted"); 
			    	                     pauseMe();
			    	                     return;
			    	                    }
				                    }
			                 }
			          
			            }
			     }
		   }
		  
		 pauseMe(); 
		 
	}    
		     
		  public static void borrowItemFromLibrary()
		  /**It is a public method. Its purpose is to record that a particular user has borrowed a particular item from the library.
		   * This method uses isItemInLibrary(), isUserInLibrary(), incrementUserItems(). **/
		    {
		      Scanner scan = new Scanner(System.in);
		      System.out.println("Enter the item ID to borrow >");
		      
		      int givenItemID = scan.nextInt();
		
		      if (isItemInLibrary(givenItemID) == false) // It checks if the item exists in library
		         {
			       System.out.println("The item with ID " + givenItemID+ " is not in the library");
			       pauseMe();
			       return;
		         }
			   Item itemWeLookFor = new Item(-1);
		       for (int i=0; i< items.size(); i++)
		           { 
		    	     if (items.get(i).getID() == givenItemID)
		    	        {
		    	    	  itemWeLookFor =  items.get(i);
		    	        }
	               }
		
	     	    if (itemWeLookFor.isOnLoan()) // It checks if the item is on loan
	    	       {
	     	    	 System.out.println("The item is on loan to user: " + itemWeLookFor.getUserID()+ " and cannot be borrowed");
	     	    	 pauseMe();
	     	    	 return;
	    	       }
	     	
		         System.out.println("Enter the user ID to borrow > ");
		         int givenUserID = scan.nextInt();
		         if ( isUserInLibrary(givenUserID) == false) //It checks if user exists in the library	
		             {
		        	   System.out.println("The user with ID " + givenUserID+ " is not in the library");
		        	   pauseMe();
		        	   return;
		             } 	         
		         
		          if (incrementUserItems(givenUserID) == false) //It checks if user has already the maximum number of items 
			          {
		        	    System.out.println( "The user "+givenUserID+" may not borrow the item "+givenItemID+" because the user has already borrowed the maximum number of items allowable");
		        	    pauseMe();
		        	    return;
			          }
		         
			       else 
	                   {  
		                 itemWeLookFor.borrowItem(givenUserID); //The item is borrowed
		               }  		            
		          pauseMe();
	        }
		
		public static void returnItemToLibrary() 
		/** It is a public method. It enables to record that a particular item has been returned to the library.
		 * This method uses isItemInLibrary(), decrementUserItems().  **/
		  {
			Scanner scanner = new Scanner(System.in);
		    System.out.println("Enter Item ID of item to return >");
			int givenItem = scanner.nextInt();
						
			if (isItemInLibrary(givenItem) == false) // It checks if the item is in the library
		       {
			     System.out.println("The item with ID " + givenItem+ " is not in the library");
			     pauseMe();
			     return;
		        }
			
			 Item itemWeLookFor = new Item(-1);
			 for (int i=0; i< items.size(); i++)
			     { 
				   if (items.get(i).getID() == givenItem)
			    	itemWeLookFor =  items.get(i);
		         }
			     
		     if (!itemWeLookFor.isOnLoan()) // It checks if the item is on loan
		    	 {
		    	   System.out.println("The item " + givenItem+ " cannot be returned as it is not on loan ");
		    	   pauseMe();
		    	   return;
		    	 }		     	
		     int number = itemWeLookFor.getUserID(); // The item is returned
		     itemWeLookFor.returnItem();
		     decrementUserItems(number);
		     pauseMe();
			 
				
		  }
	}
	
		
	

		
	
		
 
		

