/*-------------------- packages section --------------------*/
package model.entities;

/*-------------------- class Client --------------------*/
public class Client {

	/*-------------------- attributes section --------------------*/
	private String name;
	private String email;

	/*-------------------- constructors section --------------------*/
	public Client() { // default
	}

	// overload
	public Client(String name, String email) {
		this.setName(name);
		this.setEmail(email);
	}

	/*-------------------- getters and setters section --------------------*/
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/*-------------------- methods section --------------------*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getEmail() == null) ? 0 : this.getEmail().hashCode());
		result = prime * result + ((this.getName() == null) ? 0 : this.getName().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass())return false;

		Client other = (Client) obj;
		
		if (this.getEmail() == null) {
			if (other.getEmail() != null) return false;
		} 
		else if (!this.getEmail().equals(other.getEmail())) return false;
		
		if (this.getName() == null) {
			if (other.getName() != null) return false;
		} 
		else if (!this.getName().equals(other.getName())) return false;

		return true;
	}
}
