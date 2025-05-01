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
