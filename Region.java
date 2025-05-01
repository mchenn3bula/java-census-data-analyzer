package project2;

/**
 * represent a particular US state or territory.
 * @author Zhengyi Chen
 *
 */
import java.util.ArrayList;

public class Region {
	
	private String name;
	private ArrayList<Origin> originList = new ArrayList<Origin>();
	
	/**
	 * Constructs a new Region object with specified name of the region and originList. 
	 * @param name Region name to be used for this Region; should be in the format of String 
	 * @throws IllegalArgumentException if input is invalid 
	 */
	public Region (String name) {
		setRegionName(name);
	}
	
	/**
	 * Obtain the name of the origin. 
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * a method that add origin obj into originList
	 * @param origin Origin obj to be added into originList 
	 * @throws IllegalArgumentException if input is invalid 
	 */
	public boolean add(Origin origin) throws IllegalArgumentException {
		if(origin == null) {
			throw new IllegalArgumentException("The input is empty"); 
		}
		if (originList.contains(origin)) {
			return false;
		} else {
			originList.add(origin);
			return true;
		}
	}
	
	/**
	 * a method that retrieves an originList based on the keyword (originName)
	 * @param keyword keyword used to retrieve Arraylist 
	 * @throws IllegalArgumentException if input is invalid 
	 */
	public ArrayList<Origin> getByName (String keyword) throws IllegalAccessException {
			if (keyword == null || keyword.isEmpty()) {
				return null;
			} else {
				ArrayList<Origin> tempList = new ArrayList<Origin>();
				for (int i = 0; i < originList.size(); i++) {	
					if ((originList.get(i).getOriginName().contains(keyword.substring(1)))) {
						tempList.add(originList.get(i));
					}
				}
				if (tempList.size() == 0) {
					return null;
				}
				return tempList;
			}
	}
	
	/**
	 * Returns the string representation of this Origin.
	 * @returns the string representation of this Origin object 
	 */
	@Override
	public String toString () {
		String output = name + ": foreign born population\n";
		for (int i = 0; i < originList.size(); i++) {
			output += originList.get(i).toString() + "\n";
			}
		return output;
		}
	
	
	/**
	 * Indicates whether some object obj is "equal to" this one. 
	 * Two Origin objects are the same if their names and counts are the same 
	 * @return true if this object is the same as the obj argument; false otherwise.
	 */
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Region))
			return false;
		Region temp = (Region) obj;
        return name.equalsIgnoreCase(temp.name);
	}
	
	
	private void setRegionName(String name)  throws IllegalArgumentException {
		
		//check if originName contains letters only
		if(name == null) {
			throw new IllegalArgumentException("The name is empty"); 
		}
		this.name = name;
	}
}