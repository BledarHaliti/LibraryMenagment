/** Record models a Library Book */
public class Record
{ // the names of the fields describe their contents:

	private Key catalog_number;
	private String title;
	private String author;
	private String publication_date;
	
	private PersonKey pks;
	private int tb;
	
/** Constructor Record constructs the book.
* @param num - the book's catalog number
* @param a - the book's author
* @param t - the book's title */
public Record(String n, String an,Key num)
{ 

	catalog_number = num;
	title = n;
	author = an;


}


public Record(String n, String an,Key num, String date,PersonKey pk,int timeBorrowed)
{ 
	catalog_number = num;
    title = n;
    author = an; 
    publication_date = date;
    
    tb = timeBorrowed;
    pks = pk;

}
/** getkey returns the key that identifies the record
* @return the key */
public Key getKey() { return catalog_number; }
/** getTitle returns the book's title
* @return the title */
public String getTitle() { return title; }
/** getAuthor returns the book's author
* @return the author */
public String getAuthor() { return author; }
/** getDate returns the book's publication date
* @return the date */
public String getDate() { return publication_date;}


public PersonKey getPersonKey() { return pks; }

public int getTimesBorrowed() { return tb;}
}