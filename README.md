# Java Census Data Analyzer 📊

## Overview 📋
This Java application analyzes U.S. Census immigration data from 1900, allowing users to query information about foreign-born populations across different regions and countries of origin. The program implements custom data structures and demonstrates object-oriented design principles.

![Census Data Analysis Demo](census_demo.png)

## Project Features 🌟
- **Interactive Query System:** Command-line interface for executing specific queries
- **Custom Data Structures:** Implementation of specialized classes for storing and accessing census data
- **CSV Data Processing:** Parsing and handling of census data from structured files
- **Flexible Search Capabilities:** Various query options to extract meaningful information from the dataset

## Query Commands 🔍
The application supports the following query types:
- `REGION total` - Display total foreign-born population in a specified region
- `REGION from ORIGIN` - List immigrants from a specific origin in a region
- `REGION all` - Show all immigrant populations in a region
- `quit` - Exit the application

## Data Model Architecture 🏗️
The project implements a three-tier object model:

### RegionList Class
- Extends `ArrayList<Region>`
- Provides methods to search for regions by name
- Acts as the top-level container for all census data

### Region Class
- Represents a U.S. state or territory
- Contains a collection of Origin objects
- Implements search functionality by origin name
- Provides formatted string representation of region data

### Origin Class
- Represents a country or place of origin
- Stores population count data
- Implements Comparable interface for sorting
- Provides validation for data integrity

## Technical Implementation ⚙️
### Data File Processing
```java
while (f.hasNextLine()) {
    try { 
        line = f.nextLine(); 
        parseLine = new Scanner(line);
        String [] temp = line.split(",(?![^()]*\\))");
        // Processing logic...
    }
    catch (NoSuchElementException ex) {
        continue;
    }
}
```

### Interactive User Interface
```java
do {
    System.out.println("Enter your instruction:");
    userValue = userInput.nextLine();
    if (!userValue.equalsIgnoreCase("quit")) {
        // Query processing logic...
    }
} while (!userValue.equalsIgnoreCase("quit"));
```

### Object Comparison Implementation
```java
public int compareTo(Origin obj) {
    if (this.count == obj.count) {
        return this.originName.compareToIgnoreCase(obj.originName);
    } else {
        return this.count - obj.count;
    }
}
```

## Sample Output 📋
```
Enter one of the following instructions.

REGION total
REGION from ORIGIN
REGION all
quit

Replace REGION with your desired region, and ORIGIN with your desired place of origin (or its substring).
------

Enter your instruction:
New York total
New York: Total foreign born is: 1900001

Enter your instruction:
Texas from Germany
Texas: foreign born population
Germany  48295

Enter your instruction:
California all
California: foreign born population
Austria  11498
Canada  22118
...
```

## Skills Demonstrated 💪
- **Object-Oriented Design:** Class hierarchy with inheritance and polymorphism
- **Data Structure Implementation:** Custom collections with specialized behaviors
- **File I/O Operations:** Reading and parsing complex CSV data
- **String Processing:** Advanced string manipulation techniques
- **Input Validation:** Robust error handling and data verification
- **Interactive Command Processing:** Command parsing and execution logic
