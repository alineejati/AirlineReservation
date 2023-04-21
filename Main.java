/**
 *
 *  AIRLINES RESERVATION SYSTEM
 *  Master : Dr.Shokoofeh_Bostan
 *  Programmer : Ali_Nejati
 *  @alineejati
 *  April-2023
 *
 */

import java.util.*;

public class Main {

    static Passenger[] passenger = new Passenger[15];
    static Admin admin = new Admin();

    /**
     * This function has three sections: Sign in, Sign up and Exit from the program,
     * which according to the user's choice, the program runs in a certain direction.
     */
    public static void main(String[] args) {

        System.out.print("\033[H\033[2J");
        System.out.flush();
        admin.flightManagementList();
        Scanner input = new Scanner(System.in);

        int command;
        while (true){

            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("::::::::::::::::::::::::::::::::::::::::::::::: \n\t"   +
                    "WELCOME TO NEJATI AIRLINE SYSTEM\t\n"    +
                    ":::::::::::::::::::::::::::::::::::::::::::::::   \n"   +
                    "..............MENU OPTION......................    \n"  +
                    ":::::::::::::::::::::::::::::::::::::::::::::::     \n" +
                    "1.Sign in \n2.Sign up \n3.Exit");
            System.out.print("Enter Your command : ");
            command = input.nextInt();

            switch (command) {
                case 1:
                    signIn();
                    break;
                case 2:
                    signUp();
                    break;
                case 3:
                    exitApp();
                    break;
            }

        }


    }


    /**
     * This function is for when the user logs in for the first time and must Sign up,
     * and the point of this function is that the username and password values cannot be empty.
     * Also, if the username is already registered in the system, it is not acceptable...
     */
    public static void signUp(){

        Scanner input = new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        String username = null;
        String password = null;

        for(int i = 0 ; i < Main.passenger.length ; i++){

            if (Main.passenger[i] == null){

                System.out.print("Please Enter your Username : ");
                username = input.nextLine();
                while (searchPassenger(username) == 1 || username.length() == 0){
                    if (searchPassenger(username) == 1){
                        System.out.println("This username already exists");
                    }
                    if (username.length() == 0){
                        System.out.println("The Username cannot be empty !");
                    }
                    System.out.print("Please Enter another Username : ");
                    username = input.nextLine();
                }

                System.out.print("Please Enter your Password : ");
                password = input.nextLine();
                while (password.length() == 0){
                    System.out.println("The password cannot be empty !");
                    System.out.print("Please Enter your Password : ");
                    password = input.nextLine();
                }

                Main.passenger[i] = new Passenger(username,password);
                System.out.println("Dear << " + username + " >> Your account has been successfully created ...");
                System.out.println("Welcome to our big family :)");
                break;
            }
        }
        System.out.print("Please Enter any key to continue : ");
        input.nextLine();
    }


    /**
     * This function is for when the user has Sign up before and now wants to enter his account
     */
    public static void signIn(){

        Scanner input = new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        String username = null;
        String password = null;

        boolean flag = false;
        System.out.print("Please Enter your Username : ");
        username = input.nextLine();
        System.out.print("Please Enter your password : ");
        password = input.nextLine();

        if(username.toLowerCase().equals(admin.usernameAdmin)){
            if (password.toLowerCase().equals(admin.passwordAdmin)){
                admin.adminMenu();
                flag = true;
            }
            else {
                System.out.println("Your password is << admin >> Please try again...");
                System.out.print("Please Enter any key to continue : ");
                input.nextLine();
                flag = true;
            }
        }

        for (int i = 0; i < passenger.length; i++) {

            if (passenger[i] != null && passenger[i].getUsernamePassenger().equals(username)){
                if (passenger[i].getPasswordPassenger().equals(password)){
                    passenger[i].passengerMenu();
                    flag = true;
                }
                else {
                    System.out.println("Your password is incorrect. Please try again ...");
                    System.out.print("Please Enter any key to continue : ");
                    input.nextLine();
                    flag = true;
                }
            }

        }

        if (flag == false){
            System.out.println("Oooops , No such user found. Please sign up first !");
            System.out.print("Please Enter any key to continue : ");
            input.nextLine();

        }
    }

    /**
     * This function compares the entered username with all the usernames registered in the system,
     * and if it exists in the system, it does not allow the user to choose it.
     */
    public static int searchPassenger(String username){
        for (int i = 0; i < Main.passenger.length; i++) {

            if (Main.passenger[i] != null && Main.passenger[i].getUsernamePassenger().equals(username)){
                return 1;
            }

        }
        return -1;
    }

    /**
     * Calling this function closes the program
     */
    public static void exitApp(){
        System.out.print("Goodbye dear\n" + "Hoping to see you again...");
        System.exit(0);
    }

}

/**
 * آه یکی بود یکی نبود یه عاشقی بود که یه روز
 * بهت میگفت دوست داره آخ که دوست داره هنوز
 * دلم یه دیوونه شده ، واست بی آزاره هنوز
 * از دل دیوونه نترس آخ که دوست داره هنوز
 * وای که دوست داره هنوز
 * شب که میشه به عشق تو غزل غزل صدا میشم
 * ترانه خون قصه ی تموم عاشقا میشم
 * @alineejati
 * @ebi
 *گفتی
 * که با وفا بشم سهم من از وفا تویی
 * سهم من از خودم تویی سهم من از خدا تویی
 * گفتی که دلتنگی نکن آخ مگه میشه نازنین
 * حال پریشون منو ندیدی و بیا ببین
 * شب که می شه به عشق تو غزل غزل صدا می شم
 * ترانه خون قصه ی تموم عاشقا می شم
 */