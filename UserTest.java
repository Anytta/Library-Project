public class UserTest 
  {

  public static void main (String[] args)
    {
      User firstuser= new User("Anita", "Nowak");
      User seconduser = new User("Gosia", "Nowacka");

System.out.println("The user " + firstuser.getName() + " has ID " + firstuser.getuserID());
System.out.println("The user " + seconduser.getName() + " has ID " + seconduser.getuserID());

      firstuser.incrementItems();
      firstuser.decrementItems();
      firstuser.decrementItems();
System.out.println("Number of borrowed items by user is " + firstuser.getnumOfItemsBorrowed());
      seconduser.incrementItems();
      seconduser.incrementItems();

      System.out.println("Number of borrowed items by user is " + seconduser.getnumOfItemsBorrowed());
      seconduser.incrementItems();
      seconduser.incrementItems();
System.out.println("Number of borrowed items by user is " + seconduser.getnumOfItemsBorrowed());

    }
  }

