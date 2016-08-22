// class Object -> hashCode, equals 
// Object.equals -> compares two objects based on their addresses (not contents)
// Object.hashCode -> calculates object's hash code based on its address
// In order to compare two obejects for equality, equals method should be implemented 

/**example as follows...*/ 

public boolean equals(Object obj) {
        if (obj instanceof Person) 
                return IDNumber.equals((Person) obj).IDNumber;
        else
                return false;
}

/** Object.hashCode must be also overridden */
public int hashCode() {
        return IDNumber.hashCode();
}


