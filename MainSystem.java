import java.util.Scanner;

public class MainSystem {
	
	
	private Database db;
	private PatronDatabase pd;
	private Patron p;
	
	static Scanner in = new Scanner(System.in);
	static Boolean running = true;
	
	
	public MainSystem(Database database,PatronDatabase patrond)
	{
		
		db = database;
		pd = patrond;
		
		while (running) {
			System.out.println(
					 "\nEnter 1 for  quit"
					+ "\nEnter 2 for list all books in library"
					+ "\nEnter 3 for add book to library"
					+ "\nEnter 4 for borrowing  a book from library"
					+ "\nEnter 5 to get all the stats of a borrower");

			String answer = in.nextLine();
			switch (answer) {

			case "1":
				Quit();
				break;
				
			case "2":
			   System.out.println( db.getAllBooks());
				break;
				
			case "3":
				addBook();
				break;
			
			case "4": borrowABook();
			break;
				
			case "5":  printAllBorrows(); 
			break;

			}
		}
		System.exit(0);
	}

	private void addBook() {
		
		
	
		int isbn;
		String title, author,letter,date;
		
      
		System.out.println("\nEnter Title: ");
		title = in.nextLine();
		
		

		System.out.println("\nEnter Date: ");
		date = in.nextLine();
		
		System.out.println("\nEnter Author: ");
		author = in.nextLine();
		
		System.out.println("\nEnter Letter: ");
		letter = in.nextLine();

		System.out.println("\nEnter ISBN: ");
		isbn = in.nextInt();
		
		
		Key k = new Key(letter,isbn);
		
		
		if(pd.find(k) != null)
		{
		PersonKey k1 = new PersonKey(pd.find(k).getKey().getInt());


		Record b = new Record( title, author,k,date,k1,pd.timesBorrowed(k));
		db.insert(b);
		}
		else
		{
			Record b = new Record(title, author,k);
			db.insert(b);
		}
	}

	private  void Quit() {
		running = false;
		System.out.println("Ju keni perfunduar programine.");
	
	}
	
	public  void listAllBooks()
	{
		System.out.println(db.getAllBooks());
	}

	
	public void borrowABook()
	{
		int isbn;
		String name , address,letter;
	
        int copies;
      
      
		System.out.println("\nEnter Emri: ");
		name = in.nextLine();
		
		System.out.println("\nEnter Letter: ");
		letter = in.nextLine();

		System.out.println("\nEnter Addressa e Lexuesit: ");
		address = in.nextLine();
		

		System.out.println("\nEnter Person ID: ");
		isbn = in.nextInt();

        System.out.println("\nEnter CatalogN: ");
		copies = in.nextInt();
	
		PersonKey k1 = new PersonKey(isbn);
		Key k = new Key(letter,copies);
		
		
		p = new Patron(name,address,k1,k);
		pd.insert(p);
	
	}
	
	
	public void printAllBorrows()
	{
		
		int personid;

		System.out.println("\nEnter Person ID: ");
		personid = in.nextInt();
		
		PersonKey k = new PersonKey(personid);
		
		System.out.println(pd.getAllBorrowsOf(k));
		
	}
	

	
	


}