package com.ramesh.notesapi;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NotesDao {
	public List<Notes> getAllNotes(){ 
      
      List<Notes> noteList = new ArrayList<Notes>(); 
      Notes note;
      HashMap<String, String> data=new HashMap<String, String>();
      DBConnection dbc = new DBConnection();
      try { 
         
    	  dbc.openDBConnection();
    	  String query = "select * from notesdb";
    	  ResultSet rs=dbc.getDataFromDB(query);
    	  while (rs.next())
    	  {
    		  data.put("id", rs.getString("id"));
    		  data.put("description", rs.getString("description"));
    		  data.put("title", rs.getString("title"));
    		  data.put("category", rs.getString("category"));
    		  data.put("subCategory", rs.getString("subCategory"));
    		  data.put("dateAdded", rs.getString("dateAdded"));
    		  data.put("dueDate", rs.getString("dueDate"));
    		  data.put("priority", rs.getString("priority"));
    		  data.put("userAuthor", rs.getString("userAuthor"));
    		  data.put("assigned", rs.getString("assigned"));
    		  data.put("status", rs.getString("status"));
    		  data.put("comments", rs.getString("comments"));
    		  note = new Notes(data);
    		  noteList.add(note);
    		  
    	  }
        
      } catch (Exception e) { 
         e.printStackTrace(); 
      }    
      finally
      {
    	  dbc.closeDBConnection();
      }
      return noteList; 
   }

	public Notes getNote(String id) {
	      Notes note=null;
	      HashMap<String, String> data=new HashMap<String, String>();
	      DBConnection dbc = new DBConnection();
	      try { 
	         
	    	  dbc.openDBConnection();
	    	  String query = "select * from notesdb where id='"+id+"'";
	    	  ResultSet rs=dbc.getDataFromDB(query);
	    	  while (rs.next())
	    	  {
	    		  data.put("id", rs.getString("id"));
	    		  data.put("description", rs.getString("description"));
	    		  data.put("title", rs.getString("title"));
	    		  data.put("category", rs.getString("category"));
	    		  data.put("subCategory", rs.getString("subCategory"));
	    		  data.put("dateAdded", rs.getString("dateAdded"));
	    		  data.put("dueDate", rs.getString("dueDate"));
	    		  data.put("priority", rs.getString("priority"));
	    		  data.put("userAuthor", rs.getString("userAuthor"));
	    		  data.put("assigned", rs.getString("assigned"));
	    		  data.put("status", rs.getString("status"));
	    		  data.put("comments", rs.getString("comments"));
	    		  note = new Notes(data);
	    		  
	    	  }
	        
	      } catch (Exception e) { 
	         e.printStackTrace(); 
	      }    
	      finally
	      {
	    	  dbc.closeDBConnection();
	      }
	      return note;	}
	
	public boolean addNote(HashMap<String,String> data) {
		  boolean flag = false;
	      DBConnection dbc = new DBConnection();
	      try { 
	         
	    	  dbc.openDBConnection();
	    	  String query = "INSERT INTO notesdb " + "VALUES ("
	    		        				+"\""+data.get("id")+"\""
	    		        				+",\""+ data.get("title")+"\""
	    		        				+",\""+ data.get("description")+"\""
	    		        				+",\""+ data.get("category")+"\""
	    		        				+",\""+ data.get("subCategory")+"\""
	    		        				+",\""+ data.get("dateAdded")+"\""
	    		        				+",\""+ data.get("dueDate")+"\""
	    		        				+",\""+ data.get("priority")+"\""
	    		        				+",\""+ data.get("userAuthor")+"\""
	    		        				+",\""+ data.get("assigned")+"\""
	    		        				+",\""+ data.get("status")+"\""
	    		        				+",\""+ data.get("comments")+"\""
	    		        				+")";
	    	  System.out.println("Insert Query: "+query);
	    	  flag = dbc.insertDataInDB(query,"notesdb");
 	      } catch (Exception e) { 
 	    	 System.out.println("Error in inserting the data to table notesdb");
 	    	 flag =false;
	         e.printStackTrace(); 
	         
	      }    
	      finally
	      {
	    	  dbc.closeDBConnection();
	      }
	      return flag;	}
 
public boolean updateNote(HashMap<String,String> data) {
	  boolean flag = false;
    DBConnection dbc = new DBConnection();
    try { 
       
  	  dbc.openDBConnection();
  	  String query = "UPDATE notesdb set " 
  		        				+ "title =\""+data.get("title")+"\""
  		        				+ ", "+ "description =\""+data.get("description")+"\""
  		        				+ ", "+ "category =\""+data.get("category")+"\""
  		        				+ ", "+ "subCategory =\""+data.get("subCategory")+"\""
  		        				+ ", "+ "dateAdded =\""+data.get("dateAdded")+"\""
  		        				+ ", "+ "dueDate =\""+data.get("dueDate")+"\""
  		        				+ ", "+ "priority =\""+data.get("priority")+"\""
  		        	     		+ ", "+ "dueDate =\""+data.get("dueDate")+"\""
  		        	     		+ ", "+ "userAuthor =\""+data.get("userAuthor")+"\""
  		        	     		+ ", "+ "assigned =\""+data.get("assigned")+"\""
  		        	     		+ ", "+ "status =\""+data.get("status")+"\""
  		        	     		+ ", "+ "comments =\""+data.get("comments")+"\""
  		        			    + "where id =\""+data.get("id")+"\"";
  	  System.out.println("Update Query: "+query);
  	  flag = dbc.updateDataInDB(query,"notesdb");
     } catch (Exception e) { 
   	 System.out.println("Error in inserting the data to table notesdb");
   	 flag =false;
       e.printStackTrace(); 
       
    }    
    finally
    {
  	  dbc.closeDBConnection();
    }
    return flag;	}
}
