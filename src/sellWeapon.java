
public class sellWeapon 
{
	// Game currency
	static int mora = 0;
	
	// Total buyers
	static int totalBuyers = 0;
	
	// Pricing of Weapons
	static int fullsetDiamondArmor = 200000;
	static int fullsetGoldArmor = 75000;
	static int fullsetSilverArmor = 37500;
	static int fullsetBronzeArmor = 9375;
	static int diamondSword = 100000;
	static int goldSword = 25000;
	static int silverSword = 12500;
	static int bronzeSword = 3250;
	static int diamondShield = 50000;
	static int goldShield = 25000;
	static int silverShield = 17500;
	static int bronzeShield = 2500;
	
	// Arrays for simplify printing.
	static int[] armorsell = {fullsetDiamondArmor, fullsetGoldArmor, fullsetSilverArmor, fullsetBronzeArmor};
	static int[] swordsell = {diamondSword, goldSword, silverSword, bronzeSword};
	static int[] shieldsell = {diamondShield, goldShield, silverShield, bronzeShield};

}

class peopleBuy
{
	// class function for selling weapons to customers.
	int people = (int)(Math.random()*(10-0+1)+0);
	int buyers = 0;
	
	void buy()
	{
		// Function for selling weapons to customers.
		if (people==0)
		{
			System.out.println("\nThere seems to be no buyers right now.");
			mainFlow.navigate();
		}
		else
		{
			for(;people>0;people--)
			{
				int randomWeapon = (int)(Math.random()*(2-0+1)+0);
				int randomMaterial = (int)(Math.random()*(3-0+1)+0);
				peopleBuy choice = new peopleBuy();
				String result = choice.item(randomWeapon, randomMaterial);
				
				if (result=="0")
				{
					System.out.println("\nA certain weapon is unavailable for a customer.");
				}
				else
				{
					int[][] getMora = {sellWeapon.armorsell, sellWeapon.swordsell, sellWeapon.shieldsell};
					int totalMora = getMora[randomWeapon][randomMaterial];
					
					sellWeapon.mora+=totalMora;
					System.out.format("\nA buyer purchased 1 %s!\n", result);
					System.out.format("You currently have %d Mora!\n", sellWeapon.mora);
					buyers+=1;
				}
				
			}
			
			sellWeapon.totalBuyers+=buyers;
			
			if (buyers==0)
			{
				System.out.println("\nNo one purchased from your shop.\n");
			}
			if (buyers==1)
			{
				System.out.format("\n%d person purchased from your shop!\n", buyers);
			}			
			if (buyers>=1)
			{
				System.out.format("\n%d persons purchased from your shop!\n", buyers);
			}		
			
			// Checks if goal is achieved.
			if (mainFlow.checkFinish()==true)
			{
				mainFlow.finish();
			}
			else
			{
				System.out.println("\nRedirecting to navigation.....");
				mainFlow.navigate();
			}
		}
	}
	
	String item(int x, int y)
	{
		// Returns the name of weapon if that weapon is available for purchase; returns "0" otherwise.
		
		if (x==0)
		{
			if (y==0 && buildWeapon.fullsetDiamondArmorMade>0)
			{
				buildWeapon.fullsetDiamondArmorMade-=1;
				return buildWeapon.armorName[y];
			}
			if (y==1 && buildWeapon.fullsetGoldArmorMade>0)
			{
				buildWeapon.fullsetGoldArmorMade-=1;
				return buildWeapon.armorName[y];
			}
			if (y==2 && buildWeapon.fullsetSilverArmorMade>0)
			{
				buildWeapon.fullsetSilverArmorMade-=1;
				return buildWeapon.armorName[y];
			}
			if (y==3 && buildWeapon.fullsetBronzeArmorMade>0)
			{
				buildWeapon.fullsetBronzeArmorMade-=1;
				return buildWeapon.armorName[y];
			}
		}
		
		if (x==1)
		{
			if (y==0 && buildWeapon.diamondSwordMade>0)
			{
				buildWeapon.diamondSwordMade-=1;
				return buildWeapon.swordName[y];
			}
			if (y==1 && buildWeapon.goldSwordMade>0)
			{
				buildWeapon.goldSwordMade-=1;
				return buildWeapon.swordName[y];
			}
			if (y==2 && buildWeapon.silverSwordMade>0)
			{
				buildWeapon.silverSwordMade-=1;
				return buildWeapon.swordName[y];
			}
			if (y==3 && buildWeapon.bronzeSwordMade>0)
			{
				buildWeapon.bronzeSwordMade-=1;
				return buildWeapon.swordName[y];
			}
		}
		
		if (x==2)
		{
			if (y==0 && buildWeapon.diamondShieldMade>0)
			{
				buildWeapon.diamondShieldMade-=1;
				return buildWeapon.shieldName[y];
			}
			if (y==1 && buildWeapon.goldShieldMade>0)
			{
				buildWeapon.goldShieldMade-=1;
				return buildWeapon.shieldName[y];
			}
			if (y==2 && buildWeapon.silverShieldMade>0)
			{
				buildWeapon.silverShieldMade-=1;
				return buildWeapon.shieldName[y];
			}
			if (y==3 && buildWeapon.bronzeShieldMade>0)
			{
				buildWeapon.bronzeShieldMade-=1;
				return buildWeapon.shieldName[y];
			}
		}
		return "0";
	}
}