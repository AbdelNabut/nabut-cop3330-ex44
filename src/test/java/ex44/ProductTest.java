package ex44;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import static com.google.gson.JsonParser.parseReader;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void getProducts() throws FileNotFoundException {
        Double price;
        String name;
        int quantity;
        File file = new File("src/main/java/ex44/exercise44_input.json");
        ArrayList<Product> products = new ArrayList();
        ArrayList<Product> testProducts = new ArrayList();
        Product testProduct = new Product("Widget", 25.00, 5);
        Product testProductTwo = new Product("Thing", 15.00, 5);
        Product testProductThree = new Product("Doodad", 5.00, 10);
        testProducts.add(testProduct);
        testProducts.add(testProductTwo);
        testProducts.add(testProductThree);
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
        for(int i = 0; i < testProducts.size(); i++) {
            assertEquals(testProducts.get(i).getName(), products.get(i).getName());
            assertEquals(testProducts.get(i).getPrice(), products.get(i).getPrice());
            assertEquals(testProducts.get(i).getQuantity(), products.get(i).getQuantity());
        }

    }
}