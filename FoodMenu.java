
    import java.text.SimpleDateFormat;
    import java.util.Date;
    import java.util.InputMismatchException;
    import java.util.Scanner;
    class MenuItem{
        private String name;
        private double price;
        private int quantity;

        public MenuItem(String name, double price){
            this.name = name;
            this.price = price;
            this.quantity= 0;
        }
        public String getName(){
            return name;
        }
        public double getPrice(){
            return price;
        }
        public int getQuantity(){
            return quantity;
        }
        public void setQuantity(int quantity){
            this.quantity = quantity;
        }
        
    }
    class MenuCategory{
        private MenuItem [] items;
        
        public MenuCategory (MenuItem[] items){
            this.items = items;
        }
        public void displayMenu(){
            for (int i = 0; i< items.length; i++){
                System.out.println((i+1)+". " + items[i].getName()+" \t "+ " \t\t "+ items[i].getPrice());
            }
            System.out.println("0. Back to Menu");
        }
        public MenuItem getItem(int itemNumber){
            if (itemNumber>=1 && itemNumber <= items.length){
                return items[itemNumber - 1];
            }
            return null;
        }
    }
       class ReceiptBox {
        private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        public static void displayReceiptBox() {
            System.out.println("************************************");
            System.out.println("************ Receipt ****************");
            System.out.println("Date: " + getCurrentDateAndTime());
    }

        public static void closeReceiptBox() {
            System.out.println("************************************");
    }

        private static String getCurrentDateAndTime() {
            Date currentDate = new Date();
            return dateFormat.format(currentDate);
    }
}
    
    public class FoodMenu{
        private static MenuItem[] orderItems = new MenuItem[100];
        private static int orderItemCount = 0;

        private static MenuCategory[] menuCategories;
        private static final int WINGS_OPTION = 7;
        private static final int SOUUPS_OPTION = 4;

        private static void addToOrder(MenuItem item, int quantity) {
            item.setQuantity(quantity);
            orderItems[orderItemCount++] = item;
        
            System.out.println("\n-------- Order List --------");
            for (int i = 0; i < orderItemCount; i++) {
                try {
                    String itemName = orderItems[i].getName();
                    double itemPrice = orderItems[i].getPrice();
                    int itemQuantity = orderItems[i].getQuantity();
        
                    System.out.printf("%-2d. %-20s %-10s%n", (i + 1), itemName + "  x" + itemQuantity,
                            String.format("%.2f", itemPrice * itemQuantity));
                } catch (NullPointerException e) {
                    System.out.println("Error: Null item found in the order.");
                }
            }
            System.out.println("---------------------------");
        }
        
        
            private static void handleEditChoice() {
                Scanner input = new Scanner(System.in);
            
                int editChoice;
                do {
                    System.out.println("1. Order again");
                    System.out.println("2. Edit the item");
                    System.out.println("3. Delete an item");
                    System.out.println("0. Back to the category");
            
                    System.out.print("Enter your choice: ");
                    editChoice = input.nextInt();
            
                    switch (editChoice) {
                        case 1:
                            // Ordering again
                            break;
                        
                        case 2:
                            // Edit the item
                            if (orderItemCount == 0) {
                                System.out.println("No items in the order.");
                            } else {
                                System.out.println("\n-------- Order List --------");
            
                                for (int i = 0; i < orderItemCount; i++) {
                                    try {
                                        String itemName = orderItems[i].getName();
                                        double itemPrice = orderItems[i].getPrice();
                                        int itemQuantity = orderItems[i].getQuantity();  // Get quantity
            
                                        System.out.printf("%-2d. %-20s %-10s%n", (i + 1), itemName + "  x" + itemQuantity, String.format("%.2f", itemPrice * itemQuantity));
                                    } catch (NullPointerException e) {
                                        System.out.println("Error: Null item found in the order.");
                                    }
                                }
            
                                System.out.println("---------------------------");
            
                                // Add an option for editing quantity
                                System.out.print("Enter the item number to edit: ");
                                int editItemNumber = input.nextInt();
                                editQuantity(editItemNumber);
                            }
                            break;
                        case 3:
                            // Delete an item
                            if (orderItemCount == 0) {
                                System.out.println("No items in the order.");
                            } else {
                                System.out.println("\n-------- Order List --------");
            
                                for (int i = 0; i < orderItemCount; i++) {
                                    try {
                                        String itemName = orderItems[i].getName();
                                        double itemPrice = orderItems[i].getPrice();
                                        int itemQuantity = orderItems[i].getQuantity();  // Get quantity
            
                                        System.out.printf("%-2d. %-20s %-10s%n", (i + 1), itemName + "  x" + itemQuantity, String.format("%.2f", itemPrice * itemQuantity));
                                    } catch (NullPointerException e) {
                                        System.out.println("Error: Null item found in the order.");
                                    }
                                }
            
                                System.out.println("---------------------------");
            
                                // Add an option for editing quantity
                                System.out.print("Enter the item number to delete: ");
                                int deleteItemNumber = input.nextInt();
                                if (deleteItemNumber >= 1 && deleteItemNumber <= orderItemCount) {
                                    deleteItem(deleteItemNumber, orderItems[deleteItemNumber - 1].getQuantity());
                                    System.out.println("Item deleted successfully.");
                                } else {
                                    System.out.println("Invalid item number");
                                }
                            }
                            break;
                        case 0:
                            // Go back to the category
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter a valid option.");
                            break;
                    }
                } while (editChoice != 1 && editChoice != 0);
            }

        
            private static void editQuantity(int itemNumber) {
                Scanner input = new Scanner(System.in);
            
                if (itemNumber >= 1 && itemNumber <= orderItemCount) {
                    MenuItem editedItem = orderItems[itemNumber - 1];
            
                    System.out.print("Enter new quantity for " + editedItem.getName() + ": ");
                    int newQuantity = input.nextInt();
            
                    if (newQuantity > 0) {
                        editedItem.setQuantity(newQuantity);
                        System.out.println("Quantity updated successfully.");
            
                        // Display the updated order list
                        System.out.println("\n-------- Updated Order List --------");
                        for (int i = 0; i < orderItemCount; i++) {
                            try {
                                String itemName = orderItems[i].getName();
                                double itemPrice = orderItems[i].getPrice();
                                int itemQuantity = orderItems[i].getQuantity();
            
                                System.out.printf("%-2d. %-20s %-10s%n", (i + 1), itemName + "  x" + itemQuantity,
                                        String.format("%.2f", itemPrice * itemQuantity));
                            } catch (NullPointerException e) {
                                System.out.println("Error: Null item found in the order.");
                            }
                        }
                        System.out.println("-------------------------------------");
                    } else {
                        System.out.println("Invalid quantity. Please enter a positive integer.");
                    }
                } else {
                    System.out.println("Invalid item number");
                }
            }

            private static void deleteItem(int itemNumber, int quantity) {
                Scanner input = new Scanner(System.in);
            
                if (itemNumber >= 1 && itemNumber <= orderItemCount) {
                    // Remove the selected item from the orderItems array
                    for (int i = itemNumber - 1; i < orderItemCount - 1; i++) {
                        orderItems[i] = orderItems[i + 1];
                    }
            
                    // Set the last element to null and decrement the orderItemCount
                    orderItems[orderItemCount - 1] = null;
                    orderItemCount--;
            
                    System.out.println("Item deleted successfully.");
            
                    // Display the updated order list
                    System.out.println("\n-------- Updated Order List --------");
                    for (int i = 0; i < orderItemCount; i++) {
                        try {
                            String itemName = orderItems[i].getName();
                            double itemPrice = orderItems[i].getPrice();
                            int itemQuantity = orderItems[i].getQuantity();
            
                            System.out.printf("%-2d. %-20s %-10s%n", (i + 1), itemName + "  x" + itemQuantity,
                                    String.format("%.2f", itemPrice * itemQuantity));
                        } catch (NullPointerException e) {
                            System.out.println("Error: Null item found in the order.");
                        }
                    }
                    System.out.println("-------------------------------------");
                } else {
                    System.out.println("Invalid item number");
                }
            }
        
            public static void displayReceipt() {
                ReceiptBox.displayReceiptBox();
        
                System.out.println("\n-------- Receipt --------");
                double total = 0;
        
                for (int i = 0; i < orderItemCount; i++) {
                    try {
                        String itemName = orderItems[i].getName();
                        double itemPrice = orderItems[i].getPrice();
                        int itemQuantity = orderItems[i].getQuantity();  // Get quantity
        
                        System.out.printf("%-20s %-10s%n", itemName + " x" + itemQuantity, String.format("%.2f", itemPrice * itemQuantity));
                        total += itemPrice * itemQuantity;
                    } catch (NullPointerException e) {
                        System.out.println("Error: Null item found in the order.");
                    }
                }
        
                System.out.println("-------------------------");
                System.out.printf("%-20s %-10s%n", "Total:", String.format("%.2f", total));
        
                ReceiptBox.closeReceiptBox();
            }
        private static MenuItem[] Wings() {
            return new MenuItem[]{
                    new MenuItem("Solo With Rice   ", 115.0),
                    new MenuItem("Good for 3 Person", 185.0)
                    
            };
        }
        
        private static MenuItem[] WingFlavors() {
            return new MenuItem[]{
                    new MenuItem("Buffalo      ", 0.0), 
                    new MenuItem("Honey Soy    ", 0.0),
                    new MenuItem("Sweet & Spicy", 0.0),
                    new MenuItem("Garlic       ", 0.0),
                    new MenuItem("Parmesan     ", 0.0)
                    
            };
        }
        public static void displayWings() {
            Scanner input = new Scanner(System.in);
            System.out.println("------------ WINGS -----------");
            System.out.println("1. Solo With Rice          115");
            System.out.println("2. Good for 3 Person       185");
        
            MenuItem[] wings = Wings();
            MenuItem[] flavors = WingFlavors();
        
            System.out.print("Choose number (1 or 2): ");
            int wingsOption = input.nextInt();
        
            if (wingsOption == 1 || wingsOption == 2) {
                int priceIndex = wingsOption - 1;
        
                System.out.println("--------- Flavors ---------");
                for (int i = 0; i < flavors.length; i++) {
                    System.out.println((i + 1) + ". " + flavors[i].getName());
                }
        
                System.out.print("Choose flavor number (1 to " + flavors.length + "): ");
                int flavorChoice = input.nextInt();
        
                if (flavorChoice >= 1 && flavorChoice <= flavors.length) {
                    MenuItem selectedWing = wings[priceIndex];
                    MenuItem selectedFlavor = flavors[flavorChoice - 1];
        
                    // Ask for quantity
                    System.out.print("Enter quantity: ");
                    int quantity = input.nextInt();
        
                    // Add the selected wings to the order
                    addToOrder(new MenuItem("Wings " + selectedWing.getName() + " " + selectedFlavor.getName(), selectedWing.getPrice()), quantity);

                    
                    
                }
            } else {
                System.out.println("Invalid wings option.");
            }
        }
        private static MenuItem[] createSoups() {
            return new MenuItem[]{
                new MenuItem("Solo          ", 145),
                new MenuItem("Soup with Rice", 285)
            };
        }
        
        private static MenuItem[] createSoupFlavors() {
            return new MenuItem[]{
                new MenuItem("Pork Sinigang    ", 0),
                new MenuItem("Pork Nilaga      ", 0),
                new MenuItem("Sinigang na Hipon", 0),
                new MenuItem("Bulalo           ", 0),
                new MenuItem("Kare-Kare        ", 0)
            };
        }
        
        private static void displaySoups() {
            Scanner input = new Scanner(System.in);
            System.out.println("------------ SOUPS -----------");
        
            MenuItem[] soups = createSoups();
            MenuItem[] flavors = createSoupFlavors();
        
            for (int i = 0; i < soups.length; i++) {
                System.out.println((i + 1) + ". " + soups[i].getName() + "\t\t" + soups[i].getPrice());
            }
        
            System.out.print("Choose number (1 to " + soups.length + "): ");
            int soupOption = input.nextInt();
        
            if (soupOption >= 1 && soupOption <= soups.length) {
                MenuItem selectedSoup = soups[soupOption - 1];
        
                System.out.println("--------- Flavors ---------");
                for (int i = 0; i < flavors.length; i++) {
                    System.out.println((i + 1) + ". " + flavors[i].getName());
                }
        
                System.out.print("Choose flavor number (1 to " + flavors.length + "): ");
                int flavorChoice = input.nextInt();
        
                if (flavorChoice >= 1 && flavorChoice <= flavors.length) {
                    MenuItem selectedFlavor = flavors[flavorChoice - 1];
        
                    // Ask for quantity
                    System.out.print("Enter quantity: ");
                    int quantity = input.nextInt();
        
                    // Add the selected soup to the order
                    addToOrder(new MenuItem("Soups "+selectedSoup.getName() + " " + selectedFlavor.getName(), selectedSoup.getPrice()), quantity);
        
                    // Calculate total price
                    double totalPrice = quantity * selectedSoup.getPrice();
        
                    
                    
                } else {
                    System.out.println("Invalid flavor choice.");
                }
            } else {
                System.out.println("Invalid soup option.");
            }
        }
        public static void initializeMenu(){
            MenuItem[] AllDayBreakfast = {
                new MenuItem("Tapa Silog         ",       90.0),
                new MenuItem("Pork Chop Silog    ",       90.0),
                new MenuItem("Chicken Silog      ",       85.0),
                new MenuItem("Longganisa Silog   ",       75.0),
                new MenuItem("Daing na Biya Silog",       75.0),
                new MenuItem("Hungarian Silog    ",       85.0)
            };
            MenuItem[] Starter = {
                new MenuItem("Nachos                   ", 90.0),
                new MenuItem("Mojos                    ", 75.0),
                new MenuItem("Fries                    ", 75.0),
                new MenuItem("Onion Rings              ", 75.0),
                new MenuItem("Crispy Fillet Mojos Fries", 155.0),
                new MenuItem("Wings, Mojos, Fries      ", 155.0)
            };
            MenuItem[] RiceMeals = {
                new MenuItem("Lumpiang Shanghai  ",       85.0),
                new MenuItem("Fish Fillet        ",      105.0),
                new MenuItem("Chicken Teriyaki   ",      105.0),
                new MenuItem("Bangus ala Pobre   ",      105.0),
                new MenuItem("Grilled Chicken    ",      115.0),
                new MenuItem("Beef Steak         ",      115.0),
                new MenuItem("Beef Pares         ",      115.0),
                new MenuItem("Lechon Kawali      ",      115.0),
                new MenuItem("Sweet Sour Pork    ",      125.0),
                new MenuItem("Chicken Cordon Blue",      125.0),
                new MenuItem("Pork Binagoongan   ",      125.0),
                new MenuItem("Roast Chicken      ",      155.0),
                new MenuItem("Pork Ribs          ",      185.0)
            };
            
            MenuItem[] Sizzlers = {
                new MenuItem("Pork Sisig      ",           105),
                new MenuItem("Chicken BBQ     ",           105),
                new MenuItem("Pork Steak      ",           115),
                new MenuItem("Liempo          ",           115),
                new MenuItem("Tenderloin      ",           115),
                new MenuItem("Whole Sisig     ",           165),
                new MenuItem("Whole Tenderloin",           255),
                new MenuItem("T Bone          ",           185)
            };
            MenuItem[] Platters = {
                new MenuItem("Butter Shrimp       ",       285),
                new MenuItem("Sweet & Sour Pork   ",       275),
                new MenuItem("Bangus Ala Pobre    ",       185),
                new MenuItem("Lolo Boyong's Rice  ",       125),
                new MenuItem("Lumpiang Shanghai   ",       145),
                new MenuItem("1/2 Fried Chicken   ",       235),
                new MenuItem("Pork Binagoongan    ",       285),
                new MenuItem("Beef Broccoli       ",       285),
                new MenuItem("Chickeen Cordon Blue",       295),
                new MenuItem("Fish Fillet         ",       225),
                new MenuItem("Lechon Kawali       ",       265)
            };
           
            MenuItem[] ShortOrders = {
                new MenuItem("Bihon   ",                   115),
                new MenuItem("Lomi    ",                   135),
                new MenuItem("Canton  ",                   125),
                new MenuItem("Chopsuey",                   145)
            };
            MenuItem[] SandWiches = {
                new MenuItem("Club House  ",               125),
                new MenuItem("Tuna        ",                85),
                new MenuItem("Ham & Cheese",                85),
                new MenuItem("Chicken     ",                85),
                new MenuItem("Queso Dilla ",               125)
            };
            MenuItem[] Pasta = {
                new MenuItem("Tuna Pasta      ",           105),
                new MenuItem("Carbonara       ",           105),
                new MenuItem("Spaghetti       ",           105),
                new MenuItem("Pesto           ",           135),
                new MenuItem("Seafood Marinara",           165),
                new MenuItem("Seafood Pasta   ",           165),
                new MenuItem("Garlic Bread    ",            35)
            };
            MenuItem[] Frappe = {
                new MenuItem("Cookies & Cream",            105),
                new MenuItem("Chocolate      ",            105),
                new MenuItem("Caramel        ",            105)
            };
            MenuItem[] FreshFuitShake = {
                new MenuItem("Green Mango  ",               55),
                new MenuItem("Ripe Mango   ",               55),
                new MenuItem("Banana       ",               55),
                new MenuItem("Mais Con Yelo",               65)
            };
            MenuItem[] Beverages = {
                new MenuItem("Iced Tea (Glass)       ",     45),
                new MenuItem("Iced Tea (Pitcher)     ",    105),
                new MenuItem("Blue Lemonade (Glass)  ",     45),
                new MenuItem("Blue Lemonade (Pitcher)",    105),
                new MenuItem("Cucumber (Glass)       ",     45),
                new MenuItem("Cucumber (Pitcher)     ",    105),
                new MenuItem("Fresh Lemon            ",     55),
                new MenuItem("Soft Drink in Can      ",     40),
                new MenuItem("Fresh Cucumber Lemonade",     75),
            };
            menuCategories = new MenuCategory[]{
                new MenuCategory(AllDayBreakfast),
                new MenuCategory(Starter),
                new MenuCategory(RiceMeals),
                new MenuCategory(createSoups()),
                new MenuCategory(Sizzlers),
                new MenuCategory(Platters),
                new MenuCategory(Wings()),
                new MenuCategory(ShortOrders),
                new MenuCategory(SandWiches),
                new MenuCategory(Pasta),
                new MenuCategory(Frappe),
                new MenuCategory(FreshFuitShake),
                new MenuCategory(Beverages),         
        };

    }
            private static void displayMainMenu() {
                System.out.println("-------- Lolo Boyong's Kantina Menu --------");

            for (int i = 0; i < menuCategories.length; i++) {
                System.out.println("\t" + (i + 1) + ". " + getMenuCategoryName(i + 1));
        }
        System.out.println("\t0. Exit");
    }
        private static String getMenuCategoryName(int categoryIndex) {
            switch (categoryIndex) {
                case 1:
                    return "All Day Breakfast";
                case 2:
                    return "Starter";
                case 3:
                    return "Rice Meal";
                case 4:
                    return "Soups";
                case 5:
                    return "Sizzlers";
                case 6:
                    return "Platters";
                case 7:
                    return "Wings Platter";
                case 8:
                    return "Short Order";
                case 9:
                    return "Sandwiches";
                case 10:
                    return "Pasta";
                case 11:
                    return "Frappe";
                case 12:
                    return "Fresh Fruit Shake";
                case 13:
                    return "Beverages";
                default:
                    return " ";
        }
    }

            public static void main(String[] args) {
                initializeMenu();
                Scanner input = new Scanner(System.in);

                int quantity;  // Declare quantity outside the loop
                do {
                    try {
                        displayMainMenu();
                        System.out.print("\nEnter your choice: ");
                        int choice = input.nextInt();

                        if (choice == 0) {
                            break;
                        }

                        if (choice < 0 || choice > menuCategories.length) {
                            System.out.println("Invalid choice. Please enter a valid option.");
                            continue;
                        }

                        if (choice == WINGS_OPTION) {
                            displayWings();
                            handleEditChoice();
                        } else if (choice == SOUUPS_OPTION) {
                            displaySoups();
                            handleEditChoice();
                        } else {
                            MenuCategory selectedCategory = menuCategories[choice - 1];
                            if (selectedCategory != null) {
                                do {
                                    selectedCategory.displayMenu();
                                    System.out.print("Enter the item number to order (0 to go back to the main menu): ");
                                    int itemNumber = input.nextInt();

                                    if (itemNumber == 0) {
                                        break;
                                    }

                                    MenuItem selectedItem = selectedCategory.getItem(itemNumber);
                                    if (selectedItem != null) {
                                        // Ask for quantity
                                        System.out.print("Enter quantity: ");
                                        quantity = input.nextInt();

                                        // Calculate total price
                                        double totalPrice = quantity * selectedItem.getPrice();
                                        // Add to order
                                        addToOrder(selectedItem, quantity);

                                        // Display options for ordering again, showing item list, editing, or deleting an item
                                        int editChoice;
                                    }
                                    handleEditChoice();

                                } while (true);
                            }
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Invalid input. Please enter a number.");
                        input.nextLine(); // consume the invalid input to avoid an infinite loop
                    }

                } while (true);

            displayReceipt();
        }
    }