import java.util.Scanner;

public class Admin {

     String usernameAdmin = "admin";
     String passwordAdmin = "admin";
     static Flight [] flights = new Flight[15];

    /**
     * When the user enters the username and password (admin) when logging into the system,
     * a special admin menu will be displayed for her, which has the following sections.
     */
    public void adminMenu() {

        Scanner input = new Scanner(System.in);
        int command = 0;

        while (command != 5){

            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(":::::::::::::::::::::::::::::::::::::::::::::: \n\t" +
                    "WELCOME TO NEJATI AIRLINE SYSTEM\t\n"    +
                    ":::::::::::::::::::::::::::::::::::::::::::::::   \n"   +
                    "..............MENU OPTION......................    \n"  +
                    ":::::::::::::::::::::::::::::::::::::::::::::::     \n" +
                    "1.Add \n2.Update \n3.Remove \n4.Flight Schedules \n5.Sign out");

            System.out.print("Please enter your desired option : ");
            command = input.nextInt();

            switch (command){
                case 1:
                    addNewFlight();
                    break;
                case 2:
                    flightUpdates();
                    break;
                case 3:
                    removeTheFlight();
                    break;
                case 4:
                    flightSchedules();
                    break;
                default:
                    break;
            }
        }

        if (command == 5){
            String[]a = null;
            Main.main(a);
        }

    }

    /**
     * This function is for when the admin wants to add a new flight to the list of flights
     */
    public void addNewFlight(){

        Scanner input = new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        String flightId , origin , destination , date , time;
        int price , seat;

        System.out.println("Please complete the requested fields");

        System.out.print("Flight Id : ");
        flightId = input.nextLine();

        System.out.print("\nOrigin : ");
        origin = input.nextLine();

        System.out.print("\nDestination : ");
        destination = input.nextLine();

        System.out.print("\nDate : ");
        date = input.nextLine();

        System.out.print("\nTime : ");
        time = input.nextLine();

        System.out.print("\nPrice : ");
        price = input.nextInt();

        System.out.print("\nSeat : ");
        seat = input.nextInt();

        for (int i = 0; i < flights.length; i++) {

            if (flights[i] == null){
                setFlightManagementList(i , flightId , origin , destination , date , time , price , seat);
                System.out.println("The new flight has been successfully added to the flight list :)");
                System.out.print("Please Enter any key to continue : ");
                input.nextLine();
                break;
            }
        }

    }

    /**
     * This function is for when the administrator wants to update the information of a flight
     */
    public void flightUpdates(){

        Scanner input = new Scanner(System.in);
        String command , newFlightId , flightId;
        printTheFlightsList();
        System.out.print("Please enter the flight ID you want to delete :");
        flightId = input.nextLine();

        if(flightIdSearch(flightId) != -1){

            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Do you want to change the flight ID ?");
            System.out.println("a.Yes\nb.No");
            System.out.print("Enter your command : ");
            command = input.nextLine();

            if (command.charAt(0) == 'a' || command.charAt(0) == 'A'){

                System.out.print("Please Enter the new Flight Id : ");
                newFlightId = input.nextLine();

                while (flightIdSearch(newFlightId) == 1){
                    System.out.println("Oooops , This flight ID has already been used !");
                    System.out.print("Please Enter another Flight Id : ");
                    newFlightId = input.nextLine();
                }

                flights[flightIdSearch(flightId)].setFlightId(newFlightId);
            }

            System.out.println("Do you want to change the Origin ?");
            String newOrigin;
            System.out.println("a.Yes\nb.No");
            System.out.print("Enter your command : ");
            command =input.nextLine();

            if (command.charAt(0) == 'a' || command.charAt(0) == 'A'){
                System.out.print("Please Enter the new Origin : ");
                newOrigin =input.nextLine();
                flights[flightIdSearch(flightId)].setOrigin(newOrigin);
            }

            System.out.println("Do you want to change the Destination ?");
            String newDestination;
            System.out.println("a.Yes\nb.No");
            System.out.print("Enter your command : ");
            command = input.nextLine();

            if (command.charAt(0) == 'a' || command.charAt(0) == 'A'){
                System.out.print("Please Enter the new Destination : ");
                newDestination = input.nextLine();
                flights[flightIdSearch(flightId)].setDestination(newDestination);
            }

            System.out.println("Do you want to change the Date ?");
            String newDate;
            System.out.println("a.Yes\nb.No");
            System.out.print("Enter your command : ");
            command = input.nextLine();

            if (command.charAt(0) == 'a' || command.charAt(0) == 'A'){
                System.out.print("Please Enter the new Date : ");
                newDate = input.nextLine();
                flights[flightIdSearch(flightId)].setDate(newDate);
            }

            System.out.println("Do you want to change the Time ?");
            String newTime;
            System.out.println("a.Yes\nb.No");
            System.out.print("Enter your command : ");
            command = input.nextLine();

            if (command.charAt(0) == 'a' || command.charAt(0) == 'A'){
                System.out.print("Please Enter the new Time : ");
                newTime = input.nextLine();
                flights[flightIdSearch(flightId)].setTime(newTime);
            }

            System.out.println("Do you want to change the Price ?");
            String newPrice;
            System.out.println("a.Yes\nb.No");
            System.out.print("Enter your command : ");
            command = input.nextLine();

            if (command.equals("a") || command.equals("A")){
                System.out.print("Please Enter the new Price : ");
                newPrice = input.nextLine();
                flights[flightIdSearch(flightId)].setPrice(Integer.parseInt(newPrice));
            }

            System.out.println("Do you want to change the Seat ?");
            String newSeat;
            System.out.println("a.Yes\nb.No");
            System.out.print("Enter your command : ");
            command = input.nextLine();

            if (command.charAt(0) == 'a' || command.charAt(0) == 'A'){
                System.out.print("Please Enter the new Seat : ");
                newSeat = input.next();
                flights[flightIdSearch(flightId)].setSeat(Integer.parseInt(newSeat));
            }

            System.out.println("Your desired flight has been successfully updated");
            System.out.print("Please Enter any key to continue : ");
            command = input.next();

        }
        else {
            System.out.println("Oooops , No flight found with such flight ID :(");
            System.out.print("Please Enter any key to continue : ");
            command =input.next();
        }

    }

    /**
     * This function is for when the administrator wants
     * to remove the information of a flight from the list of flights
     */
    public void removeTheFlight(){

        Scanner input = new Scanner(System.in);
        Flight [] tempFlight = new Flight[10];
        boolean flag = false;
        String command;
        printTheFlightsList();

        System.out.print("Please Enter the flight ID you want to remove : ");
        String removeFlightId = input.nextLine();

        for (int i = 0; i < flights.length; i++) {

            if (flights[i] != null && flights[i].getFlightId().equals(removeFlightId)){
                flights[i] = null;

                int count = 0;
                for (int j = 0; j < flights.length; j++) {

                    if (flights[j] != null){
                        tempFlight[count] = flights[j];
                        count++;
                    }

                }
                flights = tempFlight;
                flag = true;
                break;
            }
        }

        if (flag == false){
            System.out.println("Sorry , A flight with such specifications was not found in the flight list");
            System.out.print("Please Enter any key to continue : ");
            command = input.next();
        }
        else {
            System.out.println("Your desired flight has been successfully removed from the flight list");
            System.out.print("Please Enter any key to continue : ");
            command = input.next();
        }
    }

    /**
     * By calling this function, the list of flights will be displayed
     */
    public void flightSchedules(){

        Scanner input = new Scanner(System.in);
        printTheFlightsList();
        System.out.print("Please Enter any key to continue : ");
        input.nextLine();

    }

    /**
     * By default, this function has added some flights to the list of flights
     */
    public void flightManagementList(){

        setFlightManagementList(0,"wx-12","Yazd","Tehran","8/16/2023","04:30 AM",193,351);
        setFlightManagementList(1,"wz-15","Mashhad","Isfahan","6/25/2023","03:10 PM",223,206);
        setFlightManagementList(2,"bg-22","Shiraz","Qeshm","12/9/2023","10:23 AM",450,182);
        setFlightManagementList(3,"az-48","Tehran","Istanbul","4/29/2023","05:18 PM",258,122);
        setFlightManagementList(4,"hf-78","Tehran","Kish","5/15/2023","08:54 PM",925,247);

    }

    /**
     * The task of this function is to set the flight information in the flight array
     */
    public void setFlightManagementList(int number , String flightId , String origin , String destination ,
                                        String date , String time , int price , int seat){

        flights[number] = new Flight();
        flights[number].setFlightId(flightId);
        flights[number].setOrigin(origin);
        flights[number].setDestination(destination);
        flights[number].setDate(date);
        flights[number].setTime(time);
        flights[number].setPrice(price);
        flights[number].setSeat(seat);

    }


    /**
     * As the name suggests, this function prints the flight chart
     */
    public void printTheFlightsList(){

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s\n",
                          "FlightId","Origin","Destination","Date","Time","Price","Seat");
        System.out.println(".....................................................................................................");

        for (int i = 0; i < this.flights.length; i++) {
            if (this.flights[i] != null){
                System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|%-15d|%-15d\n",
                                  this.flights[i].getFlightId(),this.flights[i].getOrigin(),
                                  this.flights[i].getDestination(),this.flights[i].getDate(),
                                  this.flights[i].getTime(),this.flights[i].getPrice(),this.flights[i].getSeat());
                System.out.println(".....................................................................................................");
            }

        }
    }

    /**
     * This function helps the admin to find out with a flight ID if there is such a flight or not.
     */
    public int flightIdSearch(String flightId){

        for (int i = 0; i < this.flights.length; i++) {

            if (this.flights[i] != null && this.flights[i].getFlightId().equals(flightId)){
                return i;
            }

        }

        return -1;
    }








}
