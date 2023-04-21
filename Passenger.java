import java.util.*;

public class Passenger {

    private String usernamePassenger;
    private String passwordPassenger;
    private int walletCredit = 0;
    int    [] seatNumber = new int[15];
    String [] ticketIdOfFlightReserved = new String[15];
    Flight [] flightReserved = new Flight[15];


    public Passenger(String usernamePassenger, String passwordPassenger) {
        this.usernamePassenger = usernamePassenger;
        this.passwordPassenger = passwordPassenger;
    }

    public Passenger(String usernamePassenger, String passwordPassenger, int walletCredit) {
        this.usernamePassenger = usernamePassenger;
        this.passwordPassenger = passwordPassenger;
        this.walletCredit = walletCredit;
    }

    public String getUsernamePassenger() {
        return usernamePassenger;
    }
    public void setUsernamePassenger(String usernamePassenger) {this.usernamePassenger = usernamePassenger;}

    public String getPasswordPassenger() {
        return passwordPassenger;
    }
    public void setPasswordPassenger(String passwordPassenger) {
        this.passwordPassenger = passwordPassenger;
    }

    public int getWalletCredit() {
        return walletCredit;
    }
    public void setWalletCredit(int walletCredit) {
        this.walletCredit = walletCredit;
    }

    public int[] getSeatNumber() {return seatNumber;}
    public void setSeatNumber(int[] seatNumber) {this.seatNumber = seatNumber;}

    /**
     * After the user enters her username and password correctly,
     * the passenger menu will be displayed for her
     */
    public void passengerMenu(){

        int command = 0;
        while (command != 8){

            System.out.print("\033[H\033[2J");
            System.out.flush();
            Scanner input = new Scanner(System.in);
            System.out.println("::::::::::::::::::::::::::::::::::::::::::::::: \n\t"   +
                    "WELCOME TO NEJATI AIRLINE SYSTE\t\n"    +
                    ":::::::::::::::::::::::::::::::::::::::::::::::   \n"   +
                    "..............PASSENGER MENU...................    \n"  +
                    ":::::::::::::::::::::::::::::::::::::::::::::::     \n\n" +
                               "1.Change Password \n2.Search Flight \n3.Booking Ticket \n" +
                               "4.Ticket Cancelation \n5.Booked \n6.Add Charge \n7.Rate Us \n8.Sign out");

            System.out.println("\nYou have successfully logged into your account :)");
            System.out.print("Please Enter Your Desired Option : ");
            command = input.nextInt();
            System.out.println("\n");

            switch (command){

                case 1:
                    changePassword();
                    break;
                case 2:
                    flightSearch();
                    break;
                case 3:
                    bookingTicket();
                    break;
                case 4:
                    cancelation();
                    break;
                case 5:
                    bookedFlights();
                    break;
                case 6:
                    rechargeWallet();
                    break;
                case 7:
                    rateUs();
                default:
                    break;

            }

        }
        if (command == 8){
            String[]a = null;
            Main.main(a);
        }

    }

    /**
     * This function is for when the user wants to change her password
     */
    public void changePassword(){

        System.out.print("\033[H\033[2J");
        System.out.flush();

        Scanner input = new  Scanner(System.in);
        String newPassword;
        System.out.printf("Your Old Password is : %s\n" , this.passwordPassenger);
        System.out.print("Please Enter Your New Password : ");
        newPassword = input.nextLine();

        while (true){
            if(this.passwordPassenger.equals(newPassword))
            {
                System.out.println("Your password is duplicated !");
                System.out.println("Please try again...");
                System.out.print("Please Enter Your New Password : ");
                newPassword = input.nextLine();
            }
            else {
                this.passwordPassenger = newPassword;
                break;
            }
        }
        System.out.print("Dear ( " + this.usernamePassenger + " ) ,Your Password has been Successfully Changed :)\n"
                           + "New Password is : " + this.passwordPassenger + "\n");
        System.out.println("Please Enter any key to continue...");
        System.out.print("Enter your command : ");
        input.nextLine();
    }

    /**
     * This function helps the user to display specific flights
     * according to the input parameters that the user enters
     */
    public void flightSearch(){

        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner input = new Scanner(System.in);

        String command;
        String search;
        int numberOfTicketsFound = 0;
        boolean findTicket = false;
        Flight [] temp1 = Admin.flights;
        Flight [] temp2 = new Flight[15];

        System.out.println("Do you Want to filter the search by FLIGHT ID ?");
        System.out.println("a.Yes\nb.No");
        System.out.print("Enter your command : ");
        command = input.nextLine();

        if (command.charAt(0) == 'a' || command.charAt(0) == 'A'){

            System.out.print("Please Enter Your FLIGHT ID : ");
            search = input.nextLine();

            int count = 0 ;
            for (int i = 0; i < temp1.length; i++) {

                if (temp1[i] != null && temp1[i].getFlightId().equals(search)){
                    temp2[count] = temp1[i];
                    findTicket = true;
                    break;
                }

            }
            temp1 = temp2;
            temp2 = new Flight[15];

        }

        System.out.println("Do you Want to filter the search by ORIGIN ?");
        System.out.println("a.Yes\nb.No");
        System.out.print("Enter your command : ");
        command = input.nextLine();

        if (command.charAt(0) == 'a' || command.charAt(0) == 'A'){
            System.out.print("Please Enter Your ORIGIN : ");
            search = input.nextLine();
            search = search.toLowerCase();
            String search2 = search.substring(0,1).toUpperCase() + search.substring(1);

            int count2 = 0;
            for (int i = 0; i < temp1.length; i++) {

                if (temp1[i] != null &&  temp1[i].getOrigin().equals(search2)){
                    temp2[count2] = temp1[i];
                    findTicket = true;
                    count2 ++;
                }

            }
            temp1 = temp2;
            temp2 = new Flight[15];

        }

        System.out.println("Do you Want to filter the search by DESTINATION ?");
        System.out.println("a.Yes\nb.No");
        System.out.print("Enter your command : ");
        command = input.nextLine();

        if (command.charAt(0) == 'a' || command.charAt(0) == 'A'){
            System.out.print("Please Enter Your DESTINATION : ");
            search = input.nextLine();
            search = search.toLowerCase();
            String search3 = search.substring(0,1).toUpperCase() + search.substring(1);

            int count3 = 0;
            for (int i = 0; i < temp1.length; i++) {

                if (temp1[i] != null && temp1[i].getDestination().equals(search3)){
                    temp2[count3] = temp1[i];
                    findTicket = true;
                    count3 ++;
                }

            }
            temp1 = temp2;
            temp2 = new Flight[15];
        }


        System.out.println("Do you Want to filter the search by DATE ?");
        System.out.println("a.Yes\nb.No");
        System.out.print("Enter your command : ");
        command = input.nextLine();

        if (command.charAt(0) == 'a' || command.charAt(0) == 'A'){
            System.out.println("Please enter the desired date in Gregorian format according to the example : " +
                               "Day / Month / Year");
            System.out.print("Please Enter Your DATE : ");
            String search4 = input.nextLine();

            int count4 = 0;
            for (int i = 0; i < temp1.length; i++) {

                if (temp1[i] != null && temp1[i].getDate().equals(search4)){
                    temp2[count4] = temp1[i];
                    findTicket = true;
                    count4 ++;
                }

            }
            temp1 = temp2;
            temp2 = new Flight[15];
        }


        System.out.println("Do you Want to filter the search by TIME ?");
        System.out.println("a.Yes\nb.No");
        System.out.print("Enter your command : ");
        command = input.nextLine();

        if (command.charAt(0) == 'a' || command.charAt(0) == 'A'){
            System.out.println("Please enter your desired flight time as follows:\n" +
                               "HH : MM (AM or PM) for example : 04:30 AM");
            System.out.print("Please Enter Your Time : ");
            String search5 = input.nextLine();

            int count5 = 0;
            for (int i = 0; i < temp1.length; i++) {

                if (temp1[i] != null && temp1[i].getTime().equals(search5)){
                    temp2[count5] = temp1[i];
                    findTicket = true;
                    count5 ++;
                }

            }
            temp1 = temp2;
            temp2 = new Flight[15];
        }

        System.out.println("Do you Want to filter the search by PRICE ?");
        System.out.println("a.Yes\nb.No");
        System.out.print("Enter your command : ");
        command = input.nextLine();

        if (command.charAt(0) == 'a' || command.charAt(0) == 'A'){
            System.out.print("Please Enter Your Minimum PRICE : ");
            int minimum = input.nextInt();
            System.out.print("Please Enter Your Maximum PRICE : ");
            int maximum = input.nextInt();

            int count6 = 0;
            for (int i = 0; i < temp1.length; i++) {

                if (temp1[i] != null && temp1[i].getPrice() <= maximum && temp1[i].getPrice() >= minimum){
                    temp2[count6] = temp1[i];
                    findTicket = true;
                    count6 ++;
                }

            }
            temp1 = temp2;

        }
        for (int i = 0; i < temp1.length; i++) {
            if(temp1[i] != null){
                numberOfTicketsFound++;
            }
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("<< " + numberOfTicketsFound + " >> " + "Flights were found");
        System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s\n",
                          "Flight Id","Origin","Destination","Date","Time","Price","Seat");
        System.out.println(".....................................................................................................");

        for (int i = 0; i < temp1.length; i++) {
            if (temp1[i] != null){
                System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|%-15d|%-15d\n",
                        temp1[i].getFlightId(),temp1[i].getOrigin(),
                        temp1[i].getDestination(),temp1[i].getDate(),
                        temp1[i].getTime(),temp1[i].getPrice(),temp1[i].getSeat());
                System.out.println(".....................................................................................................");
            }

        }
        if(findTicket == true){
            System.out.println("Do you want to book this ticket / (tickets) ?");
            System.out.println("1-Yes\n2-No");
            System.out.print("Enter Your Command : ");
            int answer = input.nextInt();
            if(answer == 1){
                bookingTicket();
            }
        }
        else {
            System.out.println("Sorry, no flights were found matching your criteria :(");
        }

        System.out.println("Please Enter any key to continue...");
        System.out.print("Enter your command : ");
        input.nextLine();


    }

    /**
     * The most important part of this program is this function,
     * with the help of which the user can book the desired flight
     */
    static int bookingTicket = 0;
    public void bookingTicket(){

        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner input = new Scanner(System.in);
        Random rnd = new Random();

        if (bookingTicket == 0){
            Main.admin.printTheFlightsList();
            bookingTicket++;
        }

        int index;
        String command;

        if (this.walletCredit == 0){
            System.out.println("Your Charge is << 0 >>");
            System.out.println("Do you want to charge your wallet ?");
            System.out.println("a.Yes\nb.No");
            System.out.print("Enter your command : ");
            command = input.nextLine();
            if (command.charAt(0) == 'a' || command.charAt(0) == 'A'){
                rechargeWallet();
            }
            else {
                System.out.println("Please Enter any key to continue...");
                System.out.print("Enter your command : ");
                input.nextLine();
                passengerMenu();
            }
        }

        Main.admin.printTheFlightsList();
        System.out.printf("your charge amount is : %d $\n", this.walletCredit);
        System.out.print("Please Enter Your Flight Id That You Want to Book it : ");
        String flightId = input.nextLine();

        for (int i = 0; i < this.flightReserved.length; i++) {

            if (this.flightReserved[i] == null){

                    index = Main.admin.flightIdSearch(flightId);

                    if (index != -1){
                        if (this.walletCredit >= Admin.flights[index].getPrice()){
                            if (Admin.flights[index].getSeat() != 0){

                                this.flightReserved[i] = Admin.flights[index];
                                for (int j = 0; j < this.seatNumber.length; j++) {
                                    if (this.seatNumber[i] == 0){
                                        this.seatNumber[i] = rnd.nextInt(Admin.flights[index].getSeat());
                                        break;
                                    }
                                }
                                this.ticketIdOfFlightReserved[i] = this.flightReserved[i].getFlightId() + this.flightReserved[i].getSeat() +
                                        this.flightReserved[i].getPrice() + rnd.nextInt(10);

                                Admin.flights[index].setSeat(Admin.flights[index].getSeat() - 1);
                                this.walletCredit -= Admin.flights[index].getPrice();

                                System.out.println("Your desired flight has been successfully booked :)\n");
                                System.out.printf("Your ticker Id is : %s\n" , this.ticketIdOfFlightReserved[i]);
                                System.out.printf("Your seat number is : %d\n\n" , this.seatNumber[i]);
                                System.out.println("Thank you for choosing Nejati Airline Company for your trip.\n" +
                                                   "We wish you a good trip :)\n");
                                System.out.println("Please Enter any key to continue...");
                                System.out.print("Enter your command : ");
                                input.nextLine();
                                break;
                            }
                            else {
                                System.out.println("Unfortunately, all the tickets for this flight have been sold :(");
                                System.out.println("Please Enter any key to continue...");
                                System.out.print("Enter your command : ");
                                input.nextLine();
                                break;
                            }

                        }
                        else {
                            System.out.println("Unfortunately, your wallet credit is not enough :(");
                            System.out.println("Do you want to increase the credit of your wallet ?");
                            System.out.println("a.Yes\nb.No");
                            System.out.print("Enter Your Command : ");
                            String res = input.nextLine();
                            if(res.charAt(0) == 'a' || res.charAt(0) == 'A'){
                                rechargeWallet();
                            }
                            break;
                        }

                    }
                    else {
                        System.out.println("Oooops , No such flight was found with this flight ID :/");
                        System.out.println("Do you want to try again ?");
                        System.out.println("a.Yes\nb.No");
                        System.out.print("Enter Your Command : ");
                        command = input.nextLine();
                        if (command.charAt(0) == 'a' || command.charAt(0) == 'A'){
                            bookingTicket();
                            break;
                        }
                        else {
                            System.out.println("Please Enter any key to continue...");
                            System.out.print("Enter your command : ");
                            input.nextLine();
                            break;
                        }
                        //break;
                    }
                }
            else {
                if(this.flightReserved[i].getFlightId().equals(flightId)){
                    System.out.println("You have already booked this flight");
                    System.out.println("Do you want to try again ?");
                    System.out.println("a.Yes\nb.No");
                    System.out.print("Enter Your Command : ");
                    command = input.nextLine();
                    if (command.charAt(0) == 'a' || command.charAt(0) == 'A'){
                        bookingTicket();
                    }
                    else {
                        System.out.println("Please Enter any key to continue...");
                        System.out.print("Enter your command : ");
                        input.nextLine();
                        break;
                    }
                }
                break;
            }

        }

    }

    /**
     * This function is for when the user wants to cancel his pre-booked flight
     */
    public void cancelation(){

        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner input = new Scanner(System.in);

        String ticket;
        String command;
        boolean flag2 = false;
        int indexSearchPassenger;
        int indexSearchAdmin;
        System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s\n",
                          "FlightId","Origin","Destination","Date","Time","Price","Seat");
        System.out.println(".....................................................................................................");

        for (int i = 0; i < this.flightReserved.length; i++) {

            if (this.flightReserved[i] != null ){
                System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|%-15d|%-15d\n",
                                  this.flightReserved[i].getFlightId(),this.flightReserved[i].getOrigin(),
                                  this.flightReserved[i].getDestination(),this.flightReserved[i].getDate(),
                                  this.flightReserved[i].getTime(),this.flightReserved[i].getPrice(),
                                  this.flightReserved[i].getSeat());

                System.out.println("ticketId is : " + this.ticketIdOfFlightReserved[i]);
                System.out.println("Your Seat Number is : " + this.seatNumber[i]);
                System.out.println(".....................................................................................................");
                flag2 = true;
            }

        }
        if (flag2 == true){
            System.out.println("which of the flights do tou want to cancel ?");
            System.out.print("Please Enter Your TICKET ID : ");
            ticket = input.nextLine();

            indexSearchPassenger = searchTicket(ticket);
            indexSearchAdmin = Main.admin.flightIdSearch(this.flightReserved[indexSearchPassenger].getFlightId());
            if (indexSearchPassenger != -1){
                if (indexSearchAdmin != -1){
                    Admin.flights[indexSearchAdmin].setSeat(Admin.flights[indexSearchAdmin].getSeat() + 1);
                }
                this.walletCredit += this.flightReserved[indexSearchPassenger].getPrice();
                this.flightReserved[indexSearchPassenger] = null;
                this.ticketIdOfFlightReserved[indexSearchPassenger] = null;
                System.out.println("Your desired flight has been successfully cancelled");
                System.out.println("Please Enter any key to continue...");
                System.out.print("Enter your command : ");
                input.nextLine();
            }
            else {
                System.out.println("The entered ticket ID is incorrect !");
                System.out.println("Please Enter any key to continue...");
                System.out.print("Enter your command : ");
                input.nextLine();
            }

        }
        else {
            System.out.println("You do not have a booked flight :/");
            System.out.println("Please Enter any key to continue...");
            System.out.print("Enter your command : ");
            input.nextLine();
        }

    }

    /**
     * With the help of this function, the user can see her booked flights
     */
    public void bookedFlights(){

        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner input = new Scanner(System.in);
        System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s\n",
                          "Flight Id","Origin","Destination","Date","Time","Price", "Seat");
        System.out.println(".....................................................................................................");

        int flagSign = 1;
        for (int i = 0; i < this.flightReserved.length; i++) {
            if (this.flightReserved[i] != null){
                System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|%-15d|%-15d\n\n",
                        this.flightReserved[i].getFlightId(),this.flightReserved[i].getOrigin(),
                        this.flightReserved[i].getDestination(),this.flightReserved[i].getDate(),
                        this.flightReserved[i].getTime(),this.flightReserved[i].getPrice(),
                        this.flightReserved[i].getSeat());
                System.out.println("ticketId is : " + this.ticketIdOfFlightReserved[i]);
                System.out.println("Your Seat Number is : " + this.seatNumber[i] + "\n");
                System.out.println(".....................................................................................................");
            }
            else {
                if (flagSign == 1){
                    String sign = "----";
                    System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s\n\n",
                            sign , sign , sign , sign , sign , sign ,sign);
                    System.out.println("TicketId is : " + "----");
                    System.out.println("Your Seat Number is : " + "----" + "\n");
                    System.out.println(".....................................................................................................");
                    flagSign = 0;
                }

            }
        }
        System.out.println("Please Enter any key to continue...");
        System.out.print("Enter your command : ");
        input.nextLine();
    }


    /**
     * This function is designed to charge user wallet credit
     */
    public void rechargeWallet(){

        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner input = new Scanner(System.in);

        int money;
        System.out.println("Your current credit is : " + this.walletCredit + " $ ");
        System.out.print("Please enter the desired amount to charge your wallet : ");
        money = input.nextInt();
        this.walletCredit += money;
        System.out.println("Your account has been charged successfully :)");
        System.out.println("Your current new credit is : " + this.walletCredit + " $ ");
        System.out.println("Please Enter any key to continue...");
        System.out.print("Enter Your command : ");
        input.nextLine();
        input.nextLine();

    }


    /**
     *The function of this function is to search for ticket ID among the booked flights
     */
    public int searchTicket(String ticketID){

        System.out.print("\033[H\033[2J");
        System.out.flush();

        for (int i = 0; i < this.ticketIdOfFlightReserved.length; i++) {

            if (this.ticketIdOfFlightReserved[i] != null && this.ticketIdOfFlightReserved[i].equals(ticketID)){
                return i;
            }

        }
        return -1;
    }


    /**
     * This function is designed to participate in the survey of Rani Nejati Airlines
     */
    static int change = 1;
    public void rateUs(){

        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner input = new Scanner(System.in);

        if (change == 1){
            System.out.println("By sending your comments and criticisms for us, your wallet will be charged ten dollars :)");
            System.out.println("So what are you waiting for? Complete the form below and receive your gift...\n");
            System.out.println("a.Lets goooo...");
            System.out.println("b.I am not your ten dollar beggar :/\n");
            System.out.print("Enter your command : ");
            String res = input.nextLine();
            if(res.charAt(0) == 'a' || res.charAt(0) == 'A'){
                System.out.print("Enter your Name : ");
                input.nextLine();
                System.out.print("Enter your Family : ");
                input.nextLine();
                System.out.print("Enter your Age : ");
                input.nextLine();
                System.out.println("Write your opinion about Nejati Airlines : ");
                input.nextLine();
                System.out.println("Your message has been successfully sent to the collection manager (Mr. Nejati)");
                System.out.println("Your wallet has been charged ten dollars :)");
                this.walletCredit += 10;
                System.out.println("Your new wallet credit is : " + this.walletCredit + " $ \n");
                change++;
                System.out.println("Please Enter any key to continue...");
                System.out.print("Enter Your command : ");
                input.nextLine();
            }
            else {
                System.out.println("So you give me ten dollars :/");
                System.out.println("Please Enter any key to continue...");
                System.out.print("Enter Your command : ");
                input.nextLine();
            }
        }
        else {
            System.out.println("Do you like free money? Sorry, you have to put your hand in your pocket :)");
            System.out.println("Please Enter any key to continue...");
            System.out.print("Enter Your command : ");
            input.nextLine();
        }

    }

    @Override
    public String toString() {
        return "Passenger{" +
                "username='" + usernamePassenger + '\'' +
                ", password='" + passwordPassenger + '\'' +
                ", charge=" + walletCredit +
                '}';
    }
}
