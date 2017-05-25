
public class Controller {
	
	public static void main(String[] args)
	{
		Database d = new Database(20);
		PatronDatabase pd = new PatronDatabase(20);
		
		MainSystem ms = new MainSystem(d,pd);
		
	}

}


