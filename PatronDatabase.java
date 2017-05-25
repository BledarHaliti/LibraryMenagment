
public class PatronDatabase {
	
 private Patron[] base;   // the collection of Patrons
	  private int NOT_FOUND = -1;  // int used to denote when a Patron not found

	  /** Constructor  Database  initializes the database
	    * @param initial_size - the size of the database */
	  public PatronDatabase(int initial_size)
	  { if ( initial_size > 0 )
	         { base = new Patron[initial_size]; }
	    else { base = new Patron[1]; }
	  }

	  /** findLocation  is a helper method that searches  base  for a Patron
	    *  whose key is  k.   If found, the index of the Patron is returned,
	    *  else  NOT_FOUND  is returned.  */
	  private int findLocation(PersonKey k)
	  { int result = NOT_FOUND;
	    boolean found = false;
	    int i = 0;
	    while ( !found  &&  i != base.length )
	          { if ( base[i] != null  &&  base[i].getKey().equals(k) )
	                 { found = true;
	                   result = i;
	                 }
	            else { i = i + 1; }
	          }
	    return result;
	  }
	  
	  private int findBookLocation(Key k)
	  { int result = NOT_FOUND;
	    boolean found = false;
	    int i = 0;
	    while ( !found  &&  i != base.length )
	          { if ( base[i] != null  &&  base[i].getCatalogN().equals(k) )
	                 { found = true;
	                   result = i;
	                 }
	            else { i = i + 1; }
	          }
	    return result;
	  }

	  /** find  locates a Patron in the database based on a key
	    * @param key - the key of the desired Patron
	    * @return (the address of) the desired Patron;
	    *  return  null if Patron not found.  */
	  public Patron find(PersonKey k)
	  { Patron answer = null;
	    int index = findLocation(k);
	    if ( index != NOT_FOUND )
	       { answer = base[index]; }
	    return answer;
	  }
	  
	  
	  public Patron find(Key k)
	  { Patron answer = null;
	    int index = findBookLocation(k);
	    if ( index != NOT_FOUND )
	       { answer = base[index]; }
	    return answer;
	  }
	  public int timesBorrowed(Key k)
	  {
	  	
	  	  int rezult = -1;
	  	  int a = 0;
	  	 for(int i = 0; i != base.length; i++)
	  	 {
	  		 if(base[i].getCatalogN().equals(k))
	  		 {
	  			 a++;
	  			 rezult = a;
	  		 }
	  	 }
	  		return rezult;  
	  }
	  


	/** insert inserts a new Patron into the database.
	    * @param r - the Patron
	    * @return true, if Patron added; return false if Patron not added because
	    *   another Patron with the same key already exists in the database */
	  public boolean insert(Patron r)
	  { 
		  boolean success = false;
	    if ( findLocation(r.getKey()) == NOT_FOUND )  // r  not already in  base?
	       { // find an empty element in  base  for insertion of  r:
	         boolean found_empty_place = false;
	         int i = 0;
	         while ( !found_empty_place  &&  i != base.length )
	               // so far, all of  base[0]..base[i-1]  are occupied
	               { if ( base[i] == null )   // is this element empty?
	                      { found_empty_place = true; }
	                 else { i = i + 1; }
	               }
	         if ( found_empty_place )
	              { base[i] = r; }
	         else { // array is full!  So, create a new one to hold more Patrons:
	                Patron[] temp = new Patron[base.length * 2];
	                for ( int j = 0;  j != base.length;  j = j + 1 )
	                    { temp[j] = base[j]; } // copy  base  into  temp
	                temp[base.length] = r;   // insert  r  in first free element
	                base = temp;   // change  base  to hold address of  temp
	              }
	         success = true;
	       }
	    return success;
	  }

	  /** delete removes a Patron in the database based on a key
	    * @param key - the Patron's key (identification)
	    * @return true, if Patron is found and deleted; return false otherwise  */
	  public boolean delete(PersonKey k)
	  { 
		  boolean result = false;
	    
		  int index = findLocation(k);
	    
		  
		  if ( index != NOT_FOUND )
	       { base[index] = null;
	         result = true;
	       }
	    return result;
	  }
	  
	  
	  public String getAllBorrowsOf(PersonKey k)
	  {
		  
		  String s = "";
		  
		  int j = 0;
		  while ( j != base.length)
		  {
		
			
			  if(base[j] != null)
			  {
			  
			
				  if(base[j].getKey().equals(k) )					  
				  {

					  s = s + "  \nName:  " + new String(base[j].getName()) +"  \nAddress:  " + new String(base[j].getAddress()) + " \nNumri rendor i shfrytezuesit :  " + base[j].getKey().getInt() + " \nNumri i Katalogut :  " + base[j].getCatalogN().getLetterCode();
					  
					 
				  }
			  
			  }
			  else
			  {
				  
			  }
			  
			  
			j++;  
		  }
		  return s;
	  }


}
