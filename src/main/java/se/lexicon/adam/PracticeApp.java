package se.lexicon.adam;

import java.util.ArrayList;
import java.util.List;

public class PracticeApp {
    public static void main(String[] args) {
        Product samsung = new Product("Samsung", 140, 100);
        Product iphone = new Product("iPhone", 130, 0);
        Product bamsung = new Product("Bamsung", 150, 100);
        Product huawei = new Product("Huawei", 200, 1);

        List<Product> products = new ArrayList<>();
        products.add(samsung);
        products.add(iphone);
        products.add(bamsung);
        products.add(huawei);

        System.out.println("With zero stock");
        sort(products, p -> p.getStock() == 0, p -> System.out.println(p.toString()));

        System.out.println("Products that start with B");
        sort(products, p -> p.getProductName().startsWith("B"), p -> System.out.println(p.toString()));

        System.out.println("Products with price above 100 and lower than 150");
        sort(products, p -> p.getPrice() > 100 && p.getPrice() < 150, p -> System.out.println(p.toString()));

        // Add 50% to stock price if value is less than 10 and above 0;
        System.out.println("Add 50% to price");
        System.out.println("Price before: " + huawei.getPrice());
        sort(products, p -> p.getStock() > 0 && p.getStock() < 10, p -> p.setPrice(p.getPrice() * 1.5));
        System.out.println("Price after: " + huawei.getPrice());
    }

    public static void sort(List<Product> list, Conditinal c, Action a) {
        for (Product product : list) {
            if (c.test(product)) a.execute(product);
        }
    }
}
