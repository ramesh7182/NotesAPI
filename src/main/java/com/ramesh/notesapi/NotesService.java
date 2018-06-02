package com.ramesh.notesapi;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;  
@Path("/NotesService") 

public class NotesService {  
   NotesDao noteDao = new NotesDao(); 
   
   private static final String SUCCESS_RESULT="<result>success</result>";
   private static final String FAILURE_RESULT="<result>failure</result>";
   
   //http://localhost:8080/databaseapi/rest/NotesService/notes
   @GET 
   @Path("/notes") 
   @Produces(MediaType.APPLICATION_XML) 
   public List<Notes> getNotes(){ 
      return noteDao.getAllNotes(); 
   }
    
   
   //http://localhost:8080/MyApp/rest/NotesService/notes/1
   @GET
   @Path("/notes/{id}")
   @Produces(MediaType.APPLICATION_XML)
   public Notes getNotes(@PathParam("id") String id){
         return noteDao.getNote(id);
      }
   
   //http://localhost:8080/MyApp/rest/NotesService/notes
   
   @POST
   @Path("/notes")
   @Produces(MediaType.APPLICATION_XML)
   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   public String createNote(
		   //id, title, description, category, subCategory, dateAdded, dueDate, priority, userAuthor, assigned, status, comments;
	  @FormParam("id") String id,
      @FormParam("title") String title,
      @FormParam("description") String description,
      @FormParam("category") String category,
      @FormParam("subCategory") String subCategory,
      @FormParam("dateAdded") String dateAdded,
      @FormParam("dueDate") String dueDate,
      @FormParam("priority") String priority,
      @FormParam("userAuthor") String userAuthor,
      @FormParam("assigned") String assigned,
      @FormParam("status") String status,
      @FormParam("comments") String comments,
      @Context HttpServletResponse servletResponse) throws IOException{
	  HashMap<String, String> data = new HashMap<String, String>();
	  data.put("id", id);
	  data.put("description", description);
	  data.put("title", title);
	  data.put("category", category);
	  data.put("subCategory", subCategory);
	  data.put("dateAdded", dateAdded);
	  data.put("dueDate", dueDate);
	  data.put("priority", priority);
	  data.put("userAuthor", userAuthor);
	  data.put("assigned", assigned);
	  data.put("status", status);
	  data.put("comments", comments);
      boolean result = noteDao.addNote(data);
      if(result){
         return SUCCESS_RESULT;
      }
      return FAILURE_RESULT;
   }
   @PUT
   @Path("/notes")
   @Produces(MediaType.APPLICATION_XML)
   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   public String updateNote(
		   //id, title, description, category, subCategory, dateAdded, dueDate, priority, userAuthor, assigned, status, comments;
	  @FormParam("id") String id,
      @FormParam("title") String title,
      @FormParam("description") String description,
      @FormParam("category") String category,
      @FormParam("subCategory") String subCategory,
      @FormParam("dateAdded") String dateAdded,
      @FormParam("dueDate") String dueDate,
      @FormParam("priority") String priority,
      @FormParam("userAuthor") String userAuthor,
      @FormParam("assigned") String assigned,
      @FormParam("status") String status,
      @FormParam("comments") String comments,
      @Context HttpServletResponse servletResponse) throws IOException{
	  HashMap<String, String> data = new HashMap<String, String>();
	  data.put("id", id);
	  data.put("description", description);
	  data.put("title", title);
	  data.put("category", category);
	  data.put("subCategory", subCategory);
	  data.put("dateAdded", dateAdded);
	  data.put("dueDate", dueDate);
	  data.put("priority", priority);
	  data.put("userAuthor", userAuthor);
	  data.put("assigned", assigned);
	  data.put("status", status);
	  data.put("comments", comments);
      boolean result = noteDao.updateNote(data);
      if(result){
         return SUCCESS_RESULT;
      }
      return FAILURE_RESULT;
   }
     
}