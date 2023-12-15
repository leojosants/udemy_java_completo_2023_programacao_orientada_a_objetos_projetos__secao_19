/*-------------------- packages section --------------------*/
package model.entities;

/*-------------------- imports section --------------------*/
import java.util.Date;

/*-------------------- class LongEntry --------------------*/
public class LogEntry {

	/*-------------------- attributes section --------------------*/
	private String username;
	private Date moment;

	/*-------------------- constructors section --------------------*/
	// default
	public LogEntry() {
		//
	}

	// overload
	public LogEntry(String username, Date moment) {
		this.setUsername(username);
		this.setMoment(moment);
	}
	
	/*-------------------- getters and setters section --------------------*/
	public String getUsername() {
		return this.username.toUpperCase();
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Date getMoment() {
		return this.moment;
	}
	
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	
	/*-------------------- methods section --------------------*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getUsername() == null) ? 0 : this.getUsername().hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;

		LogEntry other = (LogEntry) obj;
		
		if (this.getUsername() == null) {
			if (other.getUsername().toUpperCase() != null) return false;
		} 
		else if (!this.getUsername().equals(other.getUsername().toUpperCase())) return false;

		return true;
	}	
}
