
public class Patron {
	
	private String n;
	private String a;
	private PersonKey k;
	private Key cn;
	public Patron(String name, String address, PersonKey key,Key catalogN)
	{
		
		n = name;
		a = address;
		k = key;
		cn = catalogN;
		
		
		
		
	}
	
	public String getName()
	{
		return n;
	}
    public String getAddress()
    {
       return a;
    }
    public PersonKey getKey()
    {
      return k;	
    }
    public Key getCatalogN()
    {
      return cn;
    }
    
    

    }
