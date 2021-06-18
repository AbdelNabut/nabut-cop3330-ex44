package ex44;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import static com.google.gson.JsonParser.parseReader;

public class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public static ArrayList<Product> getProducts(File file) throws FileNotFoundException {
        Double price;
        String name;
        int quantity;
        ArrayList<Product> products = new ArrayList();
        JsonElement fileElement = parseReader(new FileReader(file));
        JsonObject fileObject = fileElement.getAsJsonObject();
        JsonArray jsonArrayOfProducts = fileObject.get("products").getAsJsonArray();
        for(JsonElement product: jsonArrayOfProducts) {
            JsonObject productAsJsonObject = product.getAsJsonObject();
            name = productAsJsonObject.get("name").getAsString();
            price = productAsJsonObject.get("price").getAsDouble();
            quantity = productAsJsonObject.get("quantity").getAsInt();
            Product newProduct = new Product(name, price, quantity);
            products.add(newProduct);
        }
        return products;
    }

    public static void printProduct(Product product) {
        System.out.println("Name: " + product.getName());
        System.out.println("Price: " + product.getPrice());
        System.out.println("Quantity: " + product.getQuantity());
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
