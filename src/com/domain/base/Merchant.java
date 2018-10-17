package com.domain.base;

public class Merchant {
	
	private Long id;
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Merchant(String name) {
		super();
		this.name = name;
	}
	
public Merchant() {
		
	}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Merchant other = (Merchant) obj;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equalsIgnoreCase(other.name))
		return false;
	return true;
}


}
