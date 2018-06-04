
import java.util.Scanner;

public class WestminsterCarParkManager  {
    
    static int slots = 21;
    //array is set for 20 parking spaces
    static Vehicle[] park= new Vehicle[slots]; 
    //starting the index with 1
    static int slotNumber = 1;
    //to get the count of parked vehicle
    static int carCount=0;
    static int vanCount=0;
    static int motorbikeCount=0;
    //first and the last vehicle
    static double firstVehicle;
    static double lastVehicle;
    
    public static void main(String[] args) {
    	//created the object of the class(instance)  
    	//main method is static. So need to create a object to run
        WestminsterCarParkManager w1 = new WestminsterCarParkManager();
        w1.initilise(park);
        //calling the menu for the car park. When every time a method is done executing it will recall the menu for the user.
        w1.menu();
    }
    
    private void menu() {
        
        System.out.println("");
        System.out.println("*****************************************************************************************************************************************");
        System.out.println("                                                   Welcome to Westminster Car Park ");
        System.out.println("*****************************************************************************************************************************************");
        System.out.println("Menu");
        System.out.println("");
        System.out.println("Press 1 to enter to the car park");
        System.out.println("Press 2 to exit from the car park");
        System.out.println("Press 3 to get a list of vehicles parked currently in the park.");
        System.out.println("Press 4 to get a percentage of vehicles parked");
        System.out.println("Press 5 to get the details of the 1st vehicle and the last vehicle parked");
        System.out.println("Press 6  to print the list of vehicles parked using the date.");
        System.out.println("Press 7 to get the ticket");
        System.out.println("Press 0 to exit the menu");
        System.out.println("");
       //getting inputs
        Scanner sc = new Scanner(System.in);
        //int validation
        int input = validationInt(sc);
        
        switch (input) {
            case 0:
                System.exit(input);
            case 1:
                add(park);
            case 2:
                delete(park);
            case 3:
                view(park);
            case 4:
                percentage(park);
            case 5:
                longestTime(park);
            case 6:
                dayPark(park);
            case 7:
                charges(park);
            default:
                System.err.println("Enter a valid input \n");
                menu();
        }
    }

    private void initilise(Vehicle[] park) {
    
        for (int i = 0; i <slots; i++ ){ 
            //set the slots in to empty
			park[i] = new Vehicle() {};
			park[i].setBrand("empty");
			park[i].setDate(00);
            park[i].setEntryTime(00.00);
			park[i].setiDPlate("00-0000");
                        
            //park[i] = new Car();
            //System.out.println(park[i]);
		}
    }
    //adding to the array
    private void add(Vehicle[] park) {
        Scanner sc = new Scanner(System.in);
        //varibles to store data        
        String iDPlate;
        String brand;
        double entryTime;
        int Date;
        int type;
        
        int noofDooors;
        String color;
        
        int sizeofEngine;
        
        int cargoVolume;
        
        System.out.println("");
        System.out.println("Please choose The Vehicle type");
        System.out.println("Press 1 for Car");
        System.out.println("Press 2 for Motorbike");
        System.out.println("Press 3 for Van");
        System.out.println("");
        
        //getting inputs
        type = validationInt(sc);
        //selecting vehicle type
        switch (type) {
            case 1:
            	//check whether the park is full
                if(slotNumber>20){
                    System.out.println("Car Park is Full. You can't add Cars");
                }else{
                
                    System.out.println("Enter the ID Plate number of the vehicle");
                    iDPlate = sc.next();
                    System.out.println("Enter the Brand of the vehicle");
                    brand = sc.next();
                    System.out.println("Enter the entry time");
                    entryTime = validationDouble(sc);
                    System.out.println("Enter the date");
                    Date = validationInt(sc);
                    //System.out.println("Enter the slot number");
                    System.out.println("Enter the number of doors");
                    noofDooors = validationInt(sc);
                    System.out.println("Enter the colour of the car");
                    color = sc.next();
                    
                    //car object is created to store data
                    Car temp = new Car();
                    temp.setBrand(brand);
                    temp.setColor(color);
                    temp.setDate(Date);
                    temp.setEntryTime(entryTime);
                    temp.setNumberofDoors(noofDooors);
                    temp.setiDPlate(iDPlate);
                    temp.setslotNo(slots);
                    park[slotNumber] = temp;
                    slotNumber++;
                    carCount++;
                    System.out.println("Vehicle Data successfully added to the Car park system.");
                    System.out.println("");
                
                }
                break;
                
            case 2:
            	//check whether the park is full
                if(slotNumber>20){
                    System.out.println("Car Park is Full. You can't add Motor Bikes");
                }else{
                
                    System.out.println("Enter the ID Plate number of the vehicle");
                    iDPlate = sc.next();
                    System.out.println("Enter the Brand of the vehicle");
                    brand = sc.next();
                    System.out.println("Enter the entry time");
                    entryTime = validationDouble(sc);
                    System.out.println("Enter the date");
                    Date = validationInt(sc);
                    //System.out.println("Enter the slot number");
                    System.out.println("Enter the size of the engine");
                    sizeofEngine = validationInt(sc);

                    //bike object is created to store data
                    Motorbike temp1 = new Motorbike();
                    temp1.setBrand(brand);                
                    temp1.setDate(Date);
                    temp1.setEntryTime(entryTime);                
                    temp1.setiDPlate(iDPlate);
                    temp1.setSizeofEngine(sizeofEngine);
                    temp1.setslotNo(slots);  
                    park[slotNumber] = temp1;
                    slotNumber++;
                    motorbikeCount++;
                    
                    System.out.println("Vehicle Data successfully added to the Car park system.");
                    System.out.println("");
                }
                break;
                
            case 3:
            	//van needs 2 spaces. Check whether the park is full
                if(slotNumber>=19){
                    System.out.println("Car Park is Full. You can't add Vans");
                }else{
                    
                    System.out.println("Enter the ID Plate number of the vehicle");
                    iDPlate = sc.next();
                    System.out.println("Enter the Brand of the vehicle");
                    brand = sc.next();
                    System.out.println("Enter the entry time");
                    entryTime = validationDouble(sc);
                    System.out.println("Enter the date");
                    Date = validationInt(sc);
                    //System.out.println("Enter the slot number");
                    System.out.println("Enter the cargo volume of the van");
                    cargoVolume = validationInt(sc);

                    //van object is created to store data
                    Van temp2 = new Van();
                    temp2.setBrand(brand);
                    temp2.setDate(Date);
                    temp2.setEntryTime(entryTime);
                    temp2.setiDPlate(iDPlate);
                    System.out.println(iDPlate);
                    temp2.setslotNo(slots);
                    temp2.setCargoVolume(cargoVolume);
                    park[slotNumber] = temp2;
                    park[++slotNumber].setiDPlate(iDPlate);
                    park[slotNumber++] = temp2;
                    
                    vanCount++;

                    System.out.println("Vehicle Data successfully added to the Car park system.");
                    System.out.println("");
                }
                break;
                //if not the number in the vehicle list
            default:
                System.out.println("Your vehical can't be parked in here. Try again");
                break;
        }
                
        //calling back the menu to display
	menu();	       
        
    }
    //deleting from the park
    private void delete(Vehicle[] park) {
        Scanner sc = new Scanner(System.in);
            //asking for the ID Plate number to delete the vehicle
            System.out.println("Enter the ID Plate number to exit");
            String out = sc.next();
            for(int i = 1;i<slots;i++){
               if(out.equals(park[i].getiDPlate())){
                        System.out.println("Here we have your car in slot number "+i);
                        System.out.println("Do you want to exit from the park? Press y to exit or any other key to go back.");
                        String exit= sc.next();
                        if(exit.equalsIgnoreCase("y")){
                        	//initizing again for new vehicles
                            park[i].setBrand("empty");
                            park[i].setDate(00);
                            park[i].setEntryTime(00.00);
                            park[i].setiDPlate("00-0000"); 
                            System.out.println("Thank you. Good Bye.");
                            System.exit(0);
                            //menu();
                        }else{
                            System.out.println("");
                            System.out.println("Calling the menu again.");
                            menu();
                        }
               }
               //show that there are no vehicles matching
               System.out.println("Currently we don't have a car with matching ID Plate in slot Number "+i);
            }
            
        //calling back the menu to display
	menu();    
    
    }
    //view vehicles
    private void view(Vehicle[] park) {
        for(int i = 1;i<slots;i++){
            if(park[i].getiDPlate().equals("00-0000")){
                System.out.println("Slot number "+i+" is empty");
            }else{  //show them using id plate number
                System.out.println("Slot number "+i+" is filled by the vehicle "+park[i].getiDPlate());
            }
        }
        
        //calling back the menu to display
	menu();	
    }

    

    private void percentage(Vehicle[] park) {
      //declaring variables 
      int carPercentage = 0;
      int vanPercentage = 0;
      int motorbikePercentage = 0;
      int all=carCount+vanCount+motorbikeCount;
      
      //chechking the count
      if(carCount!=0){
          carPercentage = (carCount/all)*100;
      } 
      if(vanCount!=0){
          vanPercentage = (vanCount/all)*100;
      }
      if(motorbikeCount!=0){
          motorbikePercentage= (motorbikeCount/all)*100;
      }    
      //displaying the percentage
      System.out.println("");
      System.out.println("Number of the Cars "+carCount);
      System.out.println("Number of the Vans "+vanCount);
      System.out.println("Number of the Motor Bikes "+motorbikeCount);
      System.out.println("");
      System.out.println("Percentage of the vehicle parked.");
      System.out.println("Percentage of Cars "+carPercentage+"%");
      System.out.println("Percentage of Vans "+vanPercentage+"%");
      System.out.println("Percentage of Motor Bikes "+motorbikePercentage+"%");
      
       //calling back the menu to display
	menu();	
    }

    private void longestTime(Vehicle[] park) {
       //getting details of the 1st parking lot vehicle and compare the others
        System.out.println("");
        double first = park[1].getEntryTime(); //1st lot vehicle
        double first1;							//Comparing vehicle
        String iDF = park[1].getiDPlate();
        String iDF1;
        String typeF = park[1].getBrand();
        String typeF1;
        int dateF = park[1].getDate();
        int dateF1;
        
         for(int i = 1; i < slots - 1; i++){
            //for(int j = 2; j < slots; j++){
                //storing the time to variables
                first1 = park[i+1].getEntryTime();
                iDF1 = park[i+1].getiDPlate();
                typeF1 = park[i+1].getBrand();
                dateF1 = park[i+1].getDate();
                if(first1 <= first && first1 != 0.0){
                    first = first1;
                    iDF = iDF1;
                    typeF = typeF1;
                    dateF = dateF1;
                    //System.out.println("");
                }
        }
        //System.out.println(iDF);
        System.out.println("The first vehicle's time : "+ first+"||  ID Plate Number : "+iDF+"||  Brand : "+typeF+"||  Parked date : "+dateF );
        System.out.println("");
        
        //last vehicle
        System.out.println("");
        double last = park[1].getEntryTime();
        double last1;
        String iDL = park[1].getiDPlate();
        String iDL1;
        String typeL = park[1].getBrand();
        String typeL1;
        int dateL = park[1].getDate();
        int dateL1;
        
         for(int i = 1; i < slots - 1; i++){
            //for(int j = 2; j < slots; j++){
                
                last1 = park[i+1].getEntryTime();
                iDL1 = park[i+1].getiDPlate();
                typeL1 = park[i+1].getBrand();
                dateL1 = park[i+1].getDate();
                if(last1 >= last && last1 != 0.0){
                    last = last1;
                    iDL = iDL1;
                    typeL = typeL1;
                    dateL = dateL1;
                }
        }
        
        System.out.println("The last vehicle's time is : "+ last+"||  ID Plate Number : "+iDL+"||  Brand : "+typeL+"||  Parked date : "+dateL);
        
        //calling back the menu to display
	menu();
    }
    //check the vehicles park in a day
    private void dayPark(Vehicle[] park) {
        System.out.println("");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the year");
        int year = validationInt(sc);
        System.out.println("Enter the Date");
        int date = validationInt(sc);
        for(int i = 1; i < slots; i++){
            if(date== park[i].getDate()){
                System.out.println("ID Plate of the vehicle : "+park[i].getiDPlate()+" Brand of the vehicle : "+park[i].getBrand());
                
            }else{
                System.out.println("There are no vehicles parked in that day.");
            }
        }
        
        
        //calling back the menu to display
	menu();
    }
    //getting the charges
    private void charges(Vehicle[] park) {
        Scanner sc = new Scanner(System.in);
        //varibles to store them
        double total = 0;
        String ID = null;
        
        System.out.println("Type the IDPlate of the Vehicle to get the ticket.");
        String iD = sc.next();
        System.out.println("Time of exit : ");
        System.out.println("");
        double out = validationDouble(sc);			//getting the out time
        double finalTime=0;
        for(int i = 1; i < slots; i++){
            if (iD.equals(park[i].getiDPlate())){
                double time = park[i].getEntryTime(); //getting the entry time
                finalTime = (out-time);
                
            }
            if(finalTime <= 3){
                total = (finalTime)*3;
            }else if(finalTime > 3 && finalTime < 24){
                total = (finalTime-3)*1 +9;
            }else if (finalTime>=24 && finalTime <=48){
                total = 30;
            }
            //double in = park[i].getDate();
        }
        
        
        System.out.println(" The ticket price for : "+iD+" is $"+total);
        System.out.println("Thank you!");
        
        //calling back the menu to display
	menu();
    }
    //validation for int
    private int validationInt(Scanner sc) {
        int value;
        boolean correct = false;
        
        do{
            while(!sc.hasNextInt()){
                System.err.println("Enter a valid input");
                sc.next();
            }
            
            value = sc.nextInt();
            correct = true;
        }while(!correct);
        
        return value;
    }
    //validation for double
    private double validationDouble(Scanner sc) {
        double value;
        boolean correct = false;
        
        do{
            while(!sc.hasNextDouble()){
                System.err.println("Enter a valid input");
                sc.next();
            }
            
            value = sc.nextDouble();
            correct = true;
        }while(!correct);
        
        return value;
    }
    
    
    
    
}

