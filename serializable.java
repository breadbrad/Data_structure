/** need to include implements Serializable */

/**To write an object of a Serializable interface 
if the object is a binary tree, a deep copy of all of the nodes of the binary tree will be written to the file */
try {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nameOfFile));
        out.writeObject(nameOfObject);
} catch (Exception ex) {
        ex.printStackTrace();
        System.exit(1);
}

/** To read a Serializable class from a file */
try {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(nameOfFile));
        objectName = (objectClass) in.readObject();
} catch (Exception ex) {
        ex.printStackTrace();
        System.exit(1);
}
