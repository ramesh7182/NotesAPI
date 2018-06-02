package com.ramesh.notesapi;

import java.io.Serializable;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlElement; 
import javax.xml.bind.annotation.XmlRootElement; 
@XmlRootElement(name = "note") 

public class Notes implements Serializable {  
   private static final long serialVersionUID = 1L; 
   private String id; 
   private String title; 
   private String description;
   private String category;
   private String subCategory;
   private String dateAdded;
   private String dueDate;
   private String priority;
   private String userAuthor;
   private String assigned;
   private String status;
   private String comments;
   public Notes(){
	      
   } 
    
   public Notes(HashMap<String, String> data ){  
      this.id = data.get("id");
      this.title = data.get("title"); 
      this.description = data.get("description"); 
      this.category = data.get("category");
      this.subCategory =data.get("subCategory");
      this.dateAdded =data.get("dateAdded");
      this.dueDate = data.get("dueDate");
      this.priority = data.get("priority");
      this.userAuthor = data.get("userAuthor");
      this.assigned = data.get("assigned");
      this.status=data.get("status");
      this.comments=data.get("comments");
   }  
   	public String getId() 
   		{ 
   			return id; 
   		}  
   @XmlElement 
   	public void setId(String id) 
   		{ 
	   		this.id = id; 
   		} 
   	public String getTitle() 
   		{ 
   			return title; 
   		} 
   @XmlElement
   	public void setTitle(String title) 
   		{ 
	   		this.title = title; 
   		} 
   	public String getDescription() 
   		{ 
   			return description; 
   		} 
   @XmlElement
   	public void setDescription(String description) 
   		{ 
	   		this.description = description; 
   		} 
   	public String getCategory() 
   		{ 
   			return category; 
   		} 
   @XmlElement 
   	public void setCategory(String category) 
   		{ 
	   		this.category = category; 
   		}   
   	public String getSubCategory() 
   		{ 
		    return subCategory; 
		} 
   	@XmlElement 
   	public void setSubCategory(String subCategory) 
   		{ 
		    this.subCategory = subCategory; 
		}   
   	public String getDateAdded() 
   		{ 
   			return dateAdded; 
   		} 
	@XmlElement 
	public void setDateAdded(String dateAdded) 
		{ 
		    this.dateAdded = dateAdded; 
		}  
	public String getDueDate() 
		{ 
		    return dueDate; 
		} 
	@XmlElement 
	public void setDueDate(String dueDate) 
		{ 
		     this.dueDate = dueDate; 
		}
	public String getPriority() 
		{ 
		     return priority; 
		} 
	@XmlElement 
	public void setPriority(String priority) 
		{ 
			this.priority = priority; 
		}   
	public String getAssigned() 
	{ 
		return assigned; 
	} 
	@XmlElement 
	public void setAssigned(String assigned) 
	{ 
		this.assigned = assigned; 
	}  
	public String getUserAuthor() 
		{ 
			return userAuthor; 
		} 
	@XmlElement 
	public void setUserAuthor(String userAuthor) 
		{ 
		    this.userAuthor = userAuthor; 
		}   
	public String getStatus() 
	{ 
		return status; 
	} 
	@XmlElement 
	public void setStatus(String status) 
	{ 
	    this.status = status; 
	}   
	public String getComments() 
	{ 
		return comments; 
	} 
	@XmlElement 
	public void setComments(String comments) 
	{ 
		this.comments = comments; 
	}   
} 