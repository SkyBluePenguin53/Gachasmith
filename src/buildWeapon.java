
public class buildWeapon
{
	// The material cost of making weapons.
	static int armorMake = 100;
	static int swordMake = 25;
	static int shieldMake = 20;
	
	// Statistics of weapons made.
	static int fullsetDiamondArmorMade = 0;
	static int fullsetGoldArmorMade = 0;
	static int fullsetSilverArmorMade = 0;
	static int fullsetBronzeArmorMade = 0;
	static int diamondSwordMade = 0;
	static int goldSwordMade = 0;
	static int silverSwordMade = 0;
	static int bronzeSwordMade = 0;
	static int diamondShieldMade = 0;
	static int goldShieldMade = 0;
	static int silverShieldMade = 0;
	static int bronzeShieldMade = 0;
	
	// Arrays for simplify printing.
	static String[] armorName = {"Full Set Diamond Armor","Full Set Gold Armor","Full Set Silver Armor", "Full Set Bronze Armor"};
	static String[] swordName = {"Diamond Sword","Gold Sword","Silver Sword", "Bronze Sword"};
	static String[] shieldName = {"Diamond Shield","Gold Shield","Silver Shield", "Bronze Shield"};
	
}

class weaponType
{
	// Factory instructions for making weapons.
	public weapon getWeapon(String weaponType)
	{
		switch(weaponType)
		{
			case "armor":
			{
				return new armor();
			}
			case "sword":
			{
				return new sword();
			}
			case "shield":
			{
				return new shield();
			}
			default:
			{
				System.out.println("Unidentified weapon.");
				mainFlow.navigate();
				return null;
			}
		}
	}
}

interface weapon 
{
	// General weapon blueprint.
	void createWeapon(int materialType);
}

class armor implements weapon 
{
	// Weapon blueprint for armor.
	@Override
	public void createWeapon(int materialType)
	{
		if(materialType == 1 && totalResult.diamond>=buildWeapon.armorMake)
		{
			totalResult.diamond-=buildWeapon.armorMake;
			buildWeapon.fullsetDiamondArmorMade+=1;
			System.out.println("1 Diamond Armor Made.");
		}
		if(materialType == 2 && totalResult.gold>=buildWeapon.armorMake)
		{
			totalResult.gold-=buildWeapon.armorMake;
			buildWeapon.fullsetGoldArmorMade+=1;
			System.out.println("1 Gold Armor Made.");
		}
		if(materialType == 3 && totalResult.silver>=buildWeapon.armorMake)
		{
			totalResult.silver-=buildWeapon.armorMake;
			buildWeapon.fullsetSilverArmorMade+=1;
			System.out.println("1 Silver Armor Made.");
		}
		if(materialType == 4 && totalResult.bronze>=buildWeapon.armorMake)
		{
			totalResult.bronze-=buildWeapon.armorMake;
			buildWeapon.fullsetBronzeArmorMade+=1;
			System.out.println("1 Bronze Armor Made.");
		}
		else
		{
			System.out.println("Insufficient materials!");
		}
	}
}

class sword implements weapon 
{
	// Weapon blueprint for sword.
	@Override
	public void createWeapon(int materialType)
	{
		if(materialType == 1 && totalResult.diamond>=buildWeapon.swordMake)
		{
			totalResult.diamond-=buildWeapon.swordMake;
			buildWeapon.diamondSwordMade+=1;
			System.out.println("1 Diamond Sword Made.");
		}
		if(materialType == 2 && totalResult.gold>=buildWeapon.swordMake)
		{
			totalResult.gold-=buildWeapon.swordMake;
			buildWeapon.goldSwordMade+=1;
			System.out.println("1 Gold Sword Made.");
		}
		if(materialType == 3 && totalResult.silver>=buildWeapon.swordMake)
		{
			totalResult.silver-=buildWeapon.swordMake;
			buildWeapon.silverSwordMade+=1;
			System.out.println("1 Silver Sword Made.");
		}
		if(materialType == 4 && totalResult.bronze>=buildWeapon.swordMake)
		{
			totalResult.bronze-=buildWeapon.swordMake;
			buildWeapon.bronzeSwordMade+=1;
			System.out.println("1 Bronze Sword Made.");
		}
		else
		{
			System.out.println("Insufficient materials!");
		}
	}
}

class shield implements weapon 
{
	// Weapon blueprint for shield.
	@Override
	public void createWeapon(int materialType)
	{
		if(materialType == 1 && totalResult.diamond>=buildWeapon.shieldMake)
		{
			totalResult.diamond-=buildWeapon.shieldMake;
			buildWeapon.diamondShieldMade+=1;
			System.out.println("1 Diamond Shield Made.");
		}
		if(materialType == 2 && totalResult.gold>=buildWeapon.shieldMake)
		{
			totalResult.gold-=buildWeapon.shieldMake;
			buildWeapon.goldShieldMade+=1;
			System.out.println("1 Gold Shield Made.");
		}
		if(materialType == 3 && totalResult.silver>=buildWeapon.shieldMake)
		{
			totalResult.silver-=buildWeapon.shieldMake;
			buildWeapon.silverShieldMade+=1;
			System.out.println("1 Silver Shield Made.");
		}
		if(materialType == 4 && totalResult.bronze>=buildWeapon.shieldMake)
		{
			totalResult.bronze-=buildWeapon.shieldMake;
			buildWeapon.bronzeShieldMade+=1;
			System.out.println("1 Bronze Shield Made.");
		}
		else
		{
			System.out.println("Insufficient materials!");
		}
	}
}