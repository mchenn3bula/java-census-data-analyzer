package project2;

/**
 * This class represents a origin. 
 * @author Zhengyi Chen
 *
 */
public class Origin implements Comparable<Origin> {

	
	private int count;
	private String originName; 
	
	
	/**
	 * Constructs a new Origion object with specified population and origin name. 
	 * @param count population integer to be used for this Origin; should be in the format of integer
	 * @param originName origin name to be used for this Origin; should be in the format of String 
	 * @throws IllegalArgumentException if input is invalid 
	 */
	public Origin ( String originName, int count )  throws IllegalArgumentException {
		setCount(count);
		setName(originName);
		this.originName = originName; 		
	}
	
	/**
	 * @return the number of immigrants of a country
	 */
	public int getCount () {
		return count;
	}

	/**
	 * @return the English name of this country 
	 */
	public String getOriginName () {
		return originName;
	}

	
	/**
	 * Returns the string representation of this Origin.
	 * @returns the string representation of this Origin object 
	 */
	@Override
	public String toString () {
			return String.format("%s  %d", originName,count); 
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
		if (!(obj instanceof Origin))
			return false;
		Origin temp = (Origin) obj;
        return (count == temp.count) && originName.equalsIgnoreCase(temp.originName);
	}
	
	/**
	 * compares two obj. 
	 * @return an Integer based on their count (with the one having a smaller count being considered smaller).
	 */
	
	public int compareTo(Origin obj) {
		// TODO Auto-generated method stub
		if (this.count == obj.count) {
			return this.originName.compareToIgnoreCase(obj.originName);
		} else {
			return this.count - obj.count;
		}
		
	}
	
	
	/**
	 * Validates and sets the count and originName for this Origin object. 
	 * @param count integer to be examined and set. 
	 * @throws IllegalArgumentException if the count and originName is invalid 
	 */
	
	private void setCount(int count)  throws IllegalArgumentException {
		
		//check if Count is integer
		if (!(count == (int)count))
		{
			throw new IllegalArgumentException("Invalid symbol found. Integers Only"); 
		}
		this.count = count; 
		}
		
	private void setName(String originName)  throws IllegalArgumentException {
		
		//check if originName contains letters only
		if(originName == null || originName.equals("")) {
			throw new IllegalArgumentException("origin name is empty"); 
		}
		this.originName = originName;
	}



			 
		 
}