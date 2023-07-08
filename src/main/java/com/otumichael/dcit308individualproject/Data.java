package com.otumichael.dcit308individualproject;

import com.otumichael.dcit308individualproject.mapper.*;

import java.util.ArrayList;
import java.util.List;

public class Data {

    public Data() {
        setCustomers();
        setCategories();
        setVendors();
        setGoods();
    }

    private List<Category> categories = new ArrayList<>();
    private List<Vendor> vendors = new ArrayList<>();

    private List<Customer> customers = new ArrayList<>();
    private List<Good> goods = new ArrayList<>();
    private List<Bill> bills = new ArrayList<>();
    private List<IssuedGood> issuedGoods = new ArrayList<>();

    public List<Category> getCategories() {
        return categories;
    }

    public List<Vendor> getVendors() {
        return vendors;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Good> getGoods() {
        return goods;
    }

    public List<IssuedGood> getIssuedGoods() {
        return issuedGoods;
    }

    public List<Bill> getBills() {
        return bills;
    }

    /*
        1. Beverages – coffee/tea, juice, soda
        2. Bread/Bakery – sandwich loaves, dinner rolls, tortillas, bagels
        3. Canned/Jarred Goods – vegetables, spaghetti sauce, ketchup
        4. Dairy Products – cheeses, eggs, milk, yoghurt, butter
        5. Dry/Baking Goods – cereals, flour, sugar, pasta, mixes
        6. Frozen Products – waffles, vegetables, individual meals, ice cream
        7. Meat – lunch meat, poultry, beef, pork
        8. Farm Produce – fruits, vegetables
        9. Home Cleaners – all-purpose, laundry detergent, dishwashing liquid/detergent
        10. Paper Goods – paper towels, toilet paper, aluminium foil, sandwich bags
        11. Home Care – shampoo, soap, hand soap, shaving cream
    */
    private void setCategories() {
        categories.add(new Category(1, "Beverages"));
        categories.add(new Category(2, "Bread/Bakery"));
        categories.add(new Category(3, "Canned/Jarred Goods"));
        categories.add(new Category(4, "Dairy Products"));
        categories.add(new Category(5, "Dry/Baking Goods"));
        categories.add(new Category(6, "Frozen Products"));
        categories.add(new Category(7, "Meat"));
        categories.add(new Category(8, "Farm Produce"));
        categories.add(new Category(9, "Home Cleaners"));
        categories.add(new Category(10, "Paper Goods"));
        categories.add(new Category(11, "Home Care"));
    }

    private void setVendors() {
        vendors.add(new Vendor(1, "Acme Corporation", "acme@email.com"));
        vendors.add(new Vendor(2, "Big Apple Groceries", "bigapple@email.com"));
        vendors.add(new Vendor(3, "Farmer's Market", "farmersmarket@email.com"));
    }

    private void setCustomers() {
        customers.add(new Customer(1, "John Doe", "johndoe@email.com"));
        customers.add(new Customer(2, "Jane Doe", "janedoe@email.com"));
        customers.add(new Customer(3, "Mary Smith", "marysmith@email.com"));
    }

    private void setGoods() {
        goods.add(new Good(1, "Apples", 199, 10, categories.get(7), vendors.get(0), "Red delicious apples"));
        goods.add(new Good(2, "Milk", 299, 5, categories.get(0), vendors.get(1), "Whole milk"));
        goods.add(new Good(3, "Eggs", 399, 12, categories.get(0), vendors.get(2), "Free range eggs"));
        goods.add(new Good(4, "Bread", 199, 20, categories.get(1), vendors.get(0), "Whole wheat bread"));
        goods.add(new Good(5, "Cheese", 399, 10, categories.get(0), vendors.get(1), "Cheddar cheese"));
        goods.add(new Good(6, "Soup", 299, 15, categories.get(2), vendors.get(2), "Chicken noodle soup"));
        goods.add(new Good(7, "Toilet Paper", 499, 12, categories.get(5), vendors.get(0), "12-pack of toilet paper"));
        goods.add(new Good(8, "Shampoo", 599, 6, categories.get(6), vendors.get(1), "24-ounce bottle of shampoo"));
        goods.add(new Good(9, "Dish Soap", 399, 8, categories.get(6), vendors.get(2), "12-ounce bottle of dish soap"));
        goods.add(new Good(10, "Oranges", 149, 15, categories.get(7), vendors.get(0), "Navel oranges"));
        goods.add(new Good(11, "Yogurt", 199, 10, categories.get(0), vendors.get(1), "Plain yogurt"));
        goods.add(new Good(12, "Cereal", 249, 12, categories.get(3), vendors.get(2), "Honey Nut Cheerios"));
        goods.add(new Good(13, "Coffee", 499, 10, categories.get(4), vendors.get(0), "Ground coffee"));
        goods.add(new Good(14, "Tea", 299, 8, categories.get(5), vendors.get(1), "Black tea"));
        goods.add(new Good(15, "Water", 199, 24, categories.get(6), vendors.get(2), "12-pack of bottled water"));
        goods.add(new Good(16, "Pasta", 149, 16, categories.get(1), vendors.get(0), "Dry pasta"));
        goods.add(new Good(17, "Rice", 199, 12, categories.get(1), vendors.get(1), "White rice"));
        goods.add(new Good(18, "Beans", 149, 10, categories.get(1), vendors.get(2), "Black beans"));
        goods.add(new Good(19, "Soda", 249, 12, categories.get(4), vendors.get(0), "Can of soda"));
        goods.add(new Good(20, "Beer", 399, 6, categories.get(4), vendors.get(1), "Bottle of beer"));
        goods.add(new Good(21, "Chicken", 399, 10, categories.get(2), vendors.get(0), "Boneless, skinless chicken breasts"));
        goods.add(new Good(22, "Beef", 499, 8, categories.get(2), vendors.get(1), "Ground beef"));
        goods.add(new Good(23, "Pork", 399, 6, categories.get(2), vendors.get(2), "Boneless, skinless pork chops"));
        goods.add(new Good(24, "Fish", 299, 4, categories.get(2), vendors.get(0), "Salmon fillets"));
        goods.add(new Good(25, "Shrimp", 199, 2, categories.get(2), vendors.get(1), "Frozen shrimp"));
        goods.add(new Good(26, "Eggs", 149, 12, categories.get(0), vendors.get(2), "Free range eggs"));
        goods.add(new Good(27, "Cheese", 299, 10, categories.get(0), vendors.get(0), "Cheddar cheese"));
        goods.add(new Good(28, "Milk", 199, 5, categories.get(0), vendors.get(1), "Whole milk"));
        goods.add(new Good(29, "Butter", 399, 4, categories.get(0), vendors.get(2), "Unsalted butter"));
        goods.add(new Good(30, "Yogurt", 149, 8, categories.get(0), vendors.get(0), "Greek yogurt"));
        goods.add(new Good(31, "Ice Cream", 399, 6, categories.get(4), vendors.get(1), "Vanilla ice cream"));
        goods.add(new Good(32, "Cookies", 299, 4, categories.get(3), vendors.get(2), "Chocolate chip cookies"));
        goods.add(new Good(33, "Cake", 499, 2, categories.get(3), vendors.get(0), "Chocolate cake"));
        goods.add(new Good(34, "Pie", 299, 1, categories.get(3), vendors.get(1), "Apple pie"));
        goods.add(new Good(35, "Candy", 199, 10, categories.get(4), vendors.get(2), "Assorted candies"));
        goods.add(new Good(36, "Chips", 149, 8, categories.get(4), vendors.get(0), "Bag of potato chips"));
    }

}
