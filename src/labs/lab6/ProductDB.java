package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductDB {

	// ADD YOUR INSTANCE VARIABLES EHRE
	String productsFileName;
	ArrayList<Product> product = new ArrayList<Product>();
	/**
	 * Constructor that reads in the product data from a file
	 * 
	 * @param productsFileName name of file with product data
	 */
	public ProductDB(String productsFileName) {
		// FILL IN
		this.productsFileName = productsFileName;
		try {
			
			File inputFile = new File(productsFileName);
			Scanner db = new Scanner(inputFile);
			while(db.hasNextLine()) {
				String nextLine = db.nextLine();
				String[] p = nextLine.split(";");
				Product pr = new Product(p[0], Double.parseDouble(p[1]), Integer.parseInt(p[2]));
;				product.add(pr);
				}
				db.close();
			}
			catch (FileNotFoundException e1) {
				System.out.print("File: "+ productsFileName + " not found");
				
			}
	}


	/**
	 * Searches for the product with the given name and returns it if found,
	 * otherwise returns null.
	 * 
	 * @param productName name of product to search for
	 * 
	 * @return product with given name, or null if not found
	 */
	public Product findProduct(String productName) {
		for(Product tp : product) {
//			System.out.println(tp.getName());
//			System.out.println(productName);
			if(tp.getName().equals(productName)){
				//System.out.print(1);
				return tp;
			}
		}
		
		
		return null; // FIX ME
	}


	/**
	 * Adds a new product to the products DB if a product with the given name
	 * doesn't already exist
	 * 
	 * @param name     name of product
	 * @param price    price of product
	 * @param quantity quantity of product
	 */
	public void addProduct(String name, double price, int quantity) {
		if(findProduct(name) == null) {
            // create a new Product object with the given details
            Product np = new Product(name, price, quantity);
            // add the product to the products list
            product.add(np);
            try {
    			
    			File inputFile = new File(productsFileName);
    			Scanner sc = new Scanner(inputFile);
    			StringBuilder sb = new StringBuilder();
    			while (sc.hasNextLine()) {
    				sb.append(sc.nextLine() + "\n");}	
    			sc.close();
    			String s = sb.toString();
    			s += (name + ";" + String.valueOf(price) + ";" + String.valueOf(quantity) + "\n");
    			try (FileWriter fileWriter = new FileWriter(productsFileName)) {
					fileWriter.write(s);
				}
			}  
            catch (FileNotFoundException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    			System.out.print("File: " + productsFileName + " not found");
    		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
        }
		
		
		// FILL IN
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		String prodFileName = "res/products.txt";
		ProductDB db = new ProductDB(prodFileName);
		System.out.println(new Product("stuffed sloth", 9.99, 4).equals(db.findProduct("stuffed sloth")));
		db.findProduct("Red bandana");
		}
}
