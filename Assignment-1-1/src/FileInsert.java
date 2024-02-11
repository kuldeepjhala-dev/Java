import java.io.File;

public class FileInsert {
	FileInsert(int id, String name, String author, String pub, String dop, int price, int quantity, int cost) {
		System.out.println(id + " " + name);
		
		try
		{
			File fd = new File("C:\\Users\\kulde\\eclipse-workspace\\Assignment-1-1\\src\\bookfile.txt");
			if (fd.createNewFile()) 
			{
				System.out.println("File created"); 
				
			}
			else
			{
				System.out.println("File already exists"); 
				System.out.println(fd.getAbsolutePath());
				
			}
	            
		}
		catch(Exception e)
		{
			
		}
		

	}
}
