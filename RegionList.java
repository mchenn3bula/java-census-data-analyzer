package project2;

import java.util.ArrayList;

/**
 * RegionList class is used to store a collection of Region objects. 
 * This class inherits all of its properties from an ArrayList<Region>. It 
 * adds Region-specific functions that allow search by Region name
 * 
 * This class does not store Region objects in any particular order. 
 * 
 * @author Zhengyi Chen
 *
 */
@SuppressWarnings("serial")
public class RegionList extends ArrayList<Region> {

	/**
	 * Search through the list of Regions for an object matching 
	 * the given RegionName. 
	 * @param RegionName the name of the Region for which to search 
	 * @return the reference to a matching Region object in the list, or
	 * null if the matching Region is not found  
	 */
	public Region getByName(String keyword) throws IllegalArgumentException {
		for (Region c : this ) {
			String region = c.getName();
			if (region == null) 
				continue; 
			if (region.equalsIgnoreCase(keyword)) {
				return c; 
			}
		}
		return null; 
	}
}