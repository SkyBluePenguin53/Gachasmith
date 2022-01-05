import java.util.Scanner;
import java.io.IOException;

public class mainFlow 
{
	static Scanner scan = new Scanner(System.in); //for scanner use in navigate() method;
	
	static int action = 0; //for user to keep track of the actions done and is used in action();
	
	
	public static void main(String[] args) throws IOException, InterruptedException
	{
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); //To clear command prompt or PowerShell console.
		
		System.out.println("WELCOME TO THE GACHASMITH!\nA GACHA AND SHOP GAME FOR PULLING RANDOM MATERIALS AND BUILDING WEAPONS TO SELL!"); //Game title
		
		help();
		
		navigate();
	}
	
	static void navigate()
	{
		/*
		 * Acts as the "navigation" in the game. It contains all of the methods to be used in this program.
		 */
		System.out.println("\n---Navigation---");
		
		System.out.format("\nCurrent Mora: %d\n\n", sellWeapon.mora);
		options();
		
		String option = scan.nextLine().toLowerCase(); // Stores user input choice.

		switch(option)
		{
			case "one pull":
				action();
				onePull(); // One pull in gacha part.
				break;
			case "ten pulls":
				action();
				tenPulls(); // Ten pulls in gacha part.
				break;
			case "show pulls":
				action();
				printPulls(); // Prints total pull statistics including the materials pulled.
				break;
			case "help":
				action();
				help(); // Prints the game guide and very small story.
				break;
			case "build":
				action();
				build(); // Makes user build a weapon of choice.
				break;
			case "show build":
				action();
				showBuild(); // Shows user the builds they done.
				navigate();
				break;
			case "sell":
				action();
				sell(); // Sells the built weapons to interested number of people.
				break;
			case "pricing":
				action();
				pricing(); // Shows the pricing of weapons and their material used.
				break;
			case "exit":
				action();
				exit(); // Option to exit the program.
				break;
			default:
				System.out.println("Invalid option. Try again.");
				navigate(); // Redirects the user if option is invalid.
		}
	}
	
	static void options()
	{
		// For efficient printing by calling this method.
		System.out.println("Type an option (One Pull, Ten Pulls, Show Pulls, Build, Show Build, Sell, Pricing, Help, Exit): ");
	}
	
	static void help()
	{
		// Prints the game guide and very small story.
		System.out.println("\n---Help---");
		System.out.println("\nYou are a blacksmith running a weapons business. Your goal is to earn 1000000 Mora per day.");
		System.out.println("The prices are set by the laws of your kingdom and you can't change it, so do everything you can to earn.");
		System.out.println("\nRedirecting to navigation.....");
		navigate();
	}

	static void onePull()
	{	
		// Pulls one random material from materialType.
		System.out.println("\n---One Pull---");
		
		materialType mats = new materialType();
		
		int randomMaterial = (int)(Math.random()*(50-0+1)+0); // One material
		
		material mat1 = mats.getMaterial(randomMaterial);
		System.out.println("\nResults:");
		mat1.createMaterial();
		
		printPulls();
		navigate();
	}

	static void tenPulls()
	{
		// Pulls ten random materials from materialType.
		System.out.println("\n---Ten Pulls---");
		
		int[] randomMaterial = new int[9];
		int randomMaterial1 = (int)(Math.random()*(50-46+1)+46); // One rate-up material
		
		for(int x=0;x<9;x++)
		{
			int randomMaterial2 = (int)(Math.random()*(50-0+1)+0); // Nine materials
			randomMaterial[x] = randomMaterial2;
		}
		
		materialType mats = new materialType(); //Creating new material
		
		System.out.println("\nResults:");
		
		material mat1 = mats.getMaterial(randomMaterial1);
		mat1.createMaterial();
		
		for(int x=0;x<9;x++)
		{
			material mat = mats.getMaterial(randomMaterial[x]);
			mat.createMaterial();
		}
		
		printPulls();
		navigate();
	}
	
	static void build()
	{	
		// To build weapon from user configuration.
		System.out.println("\n---Build---");
		System.out.println("\nThe materials needed are as follows:\n");
		System.out.format("Armor: %d each material\n", buildWeapon.armorMake);
		System.out.format("Sword: %d each material\n", buildWeapon.swordMake);
		System.out.format("Shield: %d each material\n", buildWeapon.shieldMake);
		System.out.println("\nYou currently have:");
		printPulls();
		
		System.out.println("\nDo you wish to proceed? Yes or No:");
		String option = scan.nextLine().toLowerCase();
		
		switch(option)
		{
			case "yes":
			{
				System.out.println("\nType the weapon type (Armor, Sword, Shield):");
				String weaponType = scan.nextLine().toLowerCase();
				System.out.println("\nType the material type (1 for diamond, 2 for gold, 3 for silver, and 4 for bronze):");
				int materialType = scan.nextInt();
				System.out.println("\nType how many builds:");
				int count = scan.nextInt();
				scan.nextLine();
				System.out.printf("\n");

				for(;count>0;count--)
				{
					weaponType weapon = new weaponType();
					
					weapon newWeapon = weapon.getWeapon(weaponType);
					newWeapon.createWeapon(materialType);
				}
				
				printPulls();
				break;
			}
			case "no":
			{
				System.out.println("\nRedirecting to navigation.....");
				break;
			}
			default:
			{
				System.out.println("\nInvalid input.");
				build();
				break;
			}
		}
		navigate();
	}
	
	static void printPulls()
	{
		// Prints total pull statistics including the materials pulled.
		System.out.println("\n---Show Pulls---");
		
		System.out.printf("\nTotal Material Pulls = %d %s\n", totalResult.pullsMade, pullPrintFormat(totalResult.pullsMade));
		System.out.printf("Diamond: %d %s\n", totalResult.diamond, piecePrintFormat(totalResult.diamond));
		System.out.printf("Gold: %d %s\n", totalResult.gold, piecePrintFormat(totalResult.gold));
		System.out.printf("Silver: %d %s\n", totalResult.silver, piecePrintFormat(totalResult.silver));
		System.out.printf("Bronze: %d %s\n", totalResult.bronze, piecePrintFormat(totalResult.bronze));
		System.out.println("\nRedirecting to navigation.....");
	}
	
	static String pullPrintFormat(int x)
	{
		// To correct grammatical number when printing pulls.
		if (x==1 || x==0)
		{
			return "pull";
		}
		else
		{
			return "pulls";
		}
	}
	
	static String piecePrintFormat(int x)
	{
		// To correct grammatical number when printing pieces.
		if (x==1 || x==0)
		{
			return "piece";
		}
		else
		{
			return "pieces";
		}
	}
	
	
	static void showBuild()
	{
		// Shows total weapon build of user.
		System.out.println("\n---Show Build---");
		
		int[] armor = {buildWeapon.fullsetDiamondArmorMade, buildWeapon.fullsetGoldArmorMade, buildWeapon.fullsetSilverArmorMade, buildWeapon.fullsetBronzeArmorMade};
		int[] sword = {buildWeapon.diamondSwordMade, buildWeapon.goldSwordMade, buildWeapon.silverSwordMade, buildWeapon.bronzeSwordMade};
		int[] shield = {buildWeapon.diamondShieldMade, buildWeapon.goldShieldMade, buildWeapon.silverShieldMade, buildWeapon.bronzeShieldMade};
		
		System.out.println("\nHere are the weapons you have built:\n");
		System.out.println("--------Name-----------------Stock-------\n");
		for(int i=0; i<4; i++)
		{
			System.out.println(String.format("%-30s", buildWeapon.armorName[i]) + String.format("%10d", armor[i]));
		}
		for(int i=0; i<4; i++)
		{
			System.out.println(String.format("%-30s", buildWeapon.swordName[i]) + String.format("%10d", sword[i]));
		}
		for(int i=0; i<4; i++)
		{
			System.out.println(String.format("%-30s", buildWeapon.shieldName[i]) + String.format("%10d", shield[i]));
		}
		System.out.println("\nRedirecting to navigation.....");
		navigate();
	}
	
	static void pricing()
	{
		// Shows pricing of weapons.
		System.out.println("\n---Pricing---");
		
		System.out.println("The costs of the weapons are the following:\n");
		System.out.println("--------Name-----------------Mora-------\n");
		for(int i=0; i<4; i++)
		{
			System.out.println(String.format("%-30s", buildWeapon.armorName[i]) + String.format("%10d", sellWeapon.armorsell[i]));
		}
		for(int i=0; i<4; i++)
		{
			System.out.println(String.format("%-30s", buildWeapon.swordName[i]) + String.format("%10d", sellWeapon.swordsell[i]));
		}
		for(int i=0; i<4; i++)
		{
			System.out.println(String.format("%-30s", buildWeapon.shieldName[i]) + String.format("%10d", sellWeapon.shieldsell[i]));
		}
		System.out.println("\nRedirecting to navigation.....");
		navigate();
	}
	
	static void sell()
	{
		// Function to sell weapons to customers.
		System.out.println("\n---Sell---");
		peopleBuy buy = new peopleBuy();
		buy.buy();
	}
	
	static boolean checkFinish()
	{
		// To check if the user achieved the goal.
		if (sellWeapon.mora>=1000000)
		{
			return true;
		}
		return false;
	}
	
	static void finish()
	{
		// Goal achieved function and exits the game.
		System.out.println("\nCongratulations! You have earned 1000000 Mora!");
		System.out.format("\nA total of %d people bought weapons from you!\n", sellWeapon.totalBuyers);
		System.out.println("\nThank you for playing!");
		System.out.println("\n\n\nShutting down......\n");
		System.exit(0);
	}
	
	static void exit()
	{
		System.out.println("\n---Exit---");
		// Option to end the game.
		System.out.println("\nAre you sure? Yes or No:");
		String choice = scan.nextLine().toLowerCase();
		
		switch(choice)
		{
			case "yes":
				System.out.println("\nThank you for playing!\n");
				System.exit(0);
			default:
				navigate();
		}
	}
	
	static void action()
	{
		//for user to keep track of the actions done;
		action+=1;
		System.out.format("\n----------Action #%d----------\n", action);
	}
}
