# Project Backend Documentation

DCIT308: DATA STRUCTURES AND ALGORITHMS 2
SECOND SEMESTER 2022/2023
INDIVIDUAL PROJECT

## Data structures

- use the data structures: lists, stacks, arrays, queues, trees, sets, maps, hashmaps, hash tables, and graphs)
- use appropriate searching and sorting algorithms or techniques to search through the database for specific items and sort some items in alphabetical order

## Task

Create an inventory management system for a provision store. We can

- add goods
- view goods
- view bills
- issued goods (items that are sold)
- view issued goods
- view vendors

## Entities (tables)

- Category: id, name
- Customer: id, name, email
- Vendor: id, name, email
- Good: id, name, description, price, quantity, categoryId, vendorId
- IssuedGood: id, goodId, quantity, dateIssued, customerId
- Bill: id, goodId, quantity, price, dateBilled, customerId

## Item Category

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

## Data structure implementation

1. Implement stacks when adding and removing items in categories 1 to 4.
2. Implement queues when adding and removing items in categories 5 to 7.
3. Implement lists when adding and removing items in categories 8 to 11.
4. You can use iterators, recursion, stack and queue implementations of the list and other techniques to best for the issued goods and viewing goods and bills.
5. Use maps to keep track of product sales (note, each time a product is sold, its product code should be entered into a sales file)
6. Use HashMaps to store information about the vendors

## Other Requirements

1. Maintain the balance between too high and too low stock
2. Generate reports to show how the data structure implementation were performed
3. Generate or allow users to view reports as shown in Figure 1.
4. Creativity will attract extra marks
5. Implement searching and sorting algorithms on items in categories 6 to 11
6. Analyze and report on the performance of your algorithm using Big O Notation and Omega Notation
7. Document all sections of your codes
8. You may design any suitable efficient algorithm to support your implementation

## Implementation

- Implementation in Java with a simple interactive UI client
- Using MySQL for the backend
