import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
 
public class WordDatabase
{
    public static void main (String[] args) throws Exception
    {
    	
    	  ArrayList<String> word = distinctWord();
    	System.out.println("size "+word.size());
        // register the driver 
        String sDriverName = "org.sqlite.JDBC";
        Class.forName(sDriverName); //JDBC specific
 
        // now we set up a set of fairly basic string variables to use in the body of the code proper
        String sTempDb = "word";
        String sJdbc = "jdbc:sqlite";
        String sDbUrl = sJdbc + ":" + sTempDb;
        // which will produce a legitimate Url for SqlLite JDBC :
        // jdbc:sqlite:hello.db
        
        Connection conn = DriverManager.getConnection(sDbUrl);
        Statement stmt = conn.createStatement();
        int iTimeout = 30;
        stmt.setQueryTimeout(iTimeout);
        int count = 0;
        String sMakeTable = "CREATE TABLE word_four (id numeric, word text)";
        stmt.executeUpdate( sMakeTable );
       for(String s: word )
       {   
        String sMakeInsert = "INSERT INTO word_four VALUES("+(++count)+",'"+s+"')";
        stmt.executeUpdate( sMakeInsert );
        System.out.println("inserting " + count);
        
       }
   
       stmt.close();
       conn.close();
        // create a database connection
       /*
        try {
           
            try {
               
               
               
               
               
               
               
               
               
               
               
               
               
               
               
               
             
               
              //  ResultSet rs = stmt.executeQuery(sMakeSelect);
                try {
                    while(rs.next())
                        {
                            String sResult = rs.getString("response");
                            System.out.println(sResult);
                        }
                } finally {
                    try { rs.close(); } catch (Exception ignore) {}
                }
            } finally {
                try { stmt.close(); } catch (Exception ignore) {}
            }
        } finally {
            try { conn.close(); } catch (Exception ignore) {}
        }*/
    }

	private static ArrayList<String> distinctWord() throws IOException {
	   
		FileInputStream fis = new FileInputStream("Four_letter_word.txt");
		int content;
		ArrayList<String> al = new ArrayList<String>();
		String word = "";
		
			while ((content = fis.read()) != -1) {
				// convert to char and display it
				
				
				if((char)content != ' ')
					word +=(char)content+"" ;
				else
					{	
						boolean flag = true;
					    for( int i = 0 ; i < word.length() - 1 ; i++)
					    {
					    	if(word.indexOf(word.charAt(i)) != word.lastIndexOf(word.charAt(i)))
					    			{	
					    					flag = false;
					    					break;
					    			}
					    }
					    
					    if(flag)
					    {
					    	//System.out.println(word);
					    	al.add(word);
					    	
					    }
					    
					    word = "";
					
					}
			}
 
			
		

		
		
		return al;
	}
 
}