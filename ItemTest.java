public class ItemTest 
  {

    public static void main (String[] args)
      {
	    Item firstitem = new Item(66666666);
        System.out.println("The item ID is " + firstitem.getID());

        firstitem.borrowItem(100);
        firstitem.borrowItem(100);
        firstitem.returnItem(); 
        firstitem.returnItem(); 
      }
  }
