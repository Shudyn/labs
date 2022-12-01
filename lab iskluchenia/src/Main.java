import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args){ //Initialization of the shop and main menu
        //Init variables, lists and assortment
        HashMap <String, String> loginpasswords = new HashMap <String, String>();
        LinkedList <Thing> thingList = new LinkedList <Thing>();
        loginpasswords.put("admin", "admin");
        boolean loggedIn = false;

        //Welcome screen
        System.out.println("Internet Shop");
        System.out.println("To login into the system write Login. To register enter Register. (Case Sensitive)");
        Scanner in = new Scanner(System.in);
        String currentCommand = in.nextLine();
        System.out.println(currentCommand);
        
        //Register method, if successful will redirect to login menu.
        if(currentCommand.equals("Register")){
            Object[] registervalues = new Object[2];
            registervalues = register(loginpasswords, in);
            loginpasswords = (HashMap <String, String>) registervalues[0];
            if((boolean) registervalues[1]){
                currentCommand = "Login";
                loggedIn = true;
            }
        }
        //Login method call
        if(currentCommand.equals("Login")){
            boolean loginsuccess = login(loginpasswords, in);
            if(loginsuccess){
                System.out.println("Login successful.");
                loggedIn = true;
            }
            else{
                main(null);
            }
        }
        else{
            System.out.println("Enter correct command");
        }
        if(loggedIn){
            //Initialise assortment and send the user to the assortment view method.
            thingList = setAssortment(thingList);

            HashMap <Thing, Integer> cart = new HashMap <Thing, Integer> ();
            viewAssortmentMain(thingList, cart, in);
        }
       
        //Deinitialize and send the user back to the welcome screen if user exits view.
        in.close();
        main(null);
    }

    //Register method. Takes the hashmap with login-password couples and the scanner from main.
    //Will ask the user to input a login, and if such string does not exist, 
    //asks to input a password. Then creates a couple login-password in hashmap.
    //Returns an object array, where 0th is the new loginpasswords hashmap, and
    //1st is the result of the operation (true/false) aka success/fail.
    public static Object[] register(HashMap<String, String>  loginpasswords, Scanner in) {
        //User input
        System.out.println("Registration algorithm");
        System.out.println("Enter login");
        String login = in.nextLine();
        boolean registerState = false;

        Object[] returnvalues = new Object[2];

        if(loginpasswords.containsKey(login)){
            //failed to create a user, returns to main method
            System.out.println("Such login exists");
            returnvalues[0] = loginpasswords;
            returnvalues[1] = registerState;
            return returnvalues;
        }
        System.out.println("Enter password");
        String password = in.nextLine();

        //create new user 
        loginpasswords.put(login, password);
        registerState = true;
        returnvalues[0] = loginpasswords;
        returnvalues[1] = registerState;
        return returnvalues;
    }

    //Lo method. Takes the hashmap with login-password couples and the scanner from main.
    //Will ask the user to input a login, and if such string does exist in the loginpassword
    //hashmap, then ask the password. If it's true, log in the user.
    //If anything fails asks the user if they want to retry, then calls login method again.
    //Returns a boolean that is the result of the operation (true/false) aka success/fail.
    public static boolean login(HashMap<String, String>  loginpasswords, Scanner in) {
        System.out.println("Login algorithm");
        System.out.println("Enter login");
        String login = in.nextLine();
        if(loginpasswords.containsKey(login)){
            System.out.println("Enter password");
            String password = in.nextLine();
            if(loginpasswords.get(login).equals(password)){
                System.out.println("Login successful");
                return true;
            }
            else{
                System.out.println("Password incorrect");
                System.out.println("Login failed. Would you like to try again? Y/N");
                String currentCommand = in.nextLine();
                if(currentCommand.equals("Y")){
                    login(loginpasswords, in);
                }
                else{
                    return false;
                }
                
            }
        }
        else{
            System.out.println("Such user does not exist");
            System.out.println("Login failed. Would you like to try again? Y/N");
                String currentCommand = in.nextLine();
                if(currentCommand.equals("Y")){
                    login(loginpasswords, in);
                }
                else{
                    return false;
                }
            
        }
        return false;
        
    }
    public static LinkedList <Thing> setAssortment(LinkedList <Thing> thingList){
        Thing thingMilk = new Thing("Milk", "A dairy product", 5, 4);
        Thing thingBoxes = new Thing("Box", "A 1mx1mx1m cardboard box", 6, 10);
        Thing thingCookies = new Thing("Cookies box", "A 500g box of cookies", 8, 6);
        thingList.add(thingMilk);
        thingList.add(thingBoxes);
        thingList.add(thingCookies);
        return thingList;
    }

    //Main menu of catalogue
    public static void viewAssortmentMain(LinkedList <Thing> thingList, HashMap <Thing, Integer> cart, Scanner in){
        System.out.println("You are now in the shop catalogue.");
        System.out.println("If you wish to view assortment, type View.");
        System.out.println("If you wish to view your shopping cart, type Cart.");
        System.out.println("If you wish to log out, type anything.");

        String currentCommand = in.nextLine();
        if(currentCommand.equals("View")){
            chooseAssortment(thingList, cart, in);
        }
        else if(currentCommand.equals("Cart")){
            viewCart(thingList, cart, in);
        }
        main(null);
    }

    public static void chooseAssortment(LinkedList <Thing> thingList, HashMap <Thing, Integer> cart, Scanner in){
        Thing currentThing;
        for (int i = 0; i < thingList.size(); i++) {
            System.out.print("Product number: ");
            System.out.println(i);
            currentThing = thingList.get(i);
            currentThing.printThing();
        }
        System.out.print("If you wish to add a product to your cart, input the product number. ");
        System.out.println("Otherwise type anything to exit.");
        String currentCommand = in.nextLine();
        Integer intCommand = 0;
        boolean isNumber = false;
        try{
            intCommand = Integer.parseInt(currentCommand);
            isNumber = true;
        }
        catch (NumberFormatException ex) {
            isNumber = false;
        }
        if(isNumber){
            if(intCommand < thingList.size() && intCommand >= 0){
                currentThing = thingList.get(intCommand);
                System.out.println("Input number of the amount you wish to get.");
                intCommand = in.nextInt();
                if(intCommand <= currentThing.numAvailable){
                    cart.put(currentThing, intCommand);
                    System.out.println("The product has been successfully put in the cart.");
                }
                else{
                    System.out.println("The amount you chose is more than available.");
                }
            }
            else{
                System.out.println("Product number is incorrect.");
            }
        }
        viewAssortmentMain(thingList, cart, in);
        
    }

    public static void viewCart(LinkedList <Thing> thingList, HashMap <Thing, Integer> cart, Scanner in){
        for(Thing thing: cart.keySet()){
            String thingName = thing.name;
            int amount = cart.get(thing);
            System.out.println("Product: " + thingName + ", amount: " + amount);
        }
        viewAssortmentMain(thingList, cart, in);
    }
}

