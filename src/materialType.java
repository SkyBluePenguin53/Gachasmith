interface material 
{
	// General material blueprint.
	void createMaterial();
}

class bronze implements material 
{
	// Material blueprint for bronze.
	@Override
	public void createMaterial() 
	{
		System.out.println("1 bronze");
		totalResult.addBronze();
		totalResult.pull();
	}
}

class silver implements material
{
	// Material blueprint for silver.
	@Override
	public void createMaterial() 
	{
		System.out.println("1 silver");
		totalResult.addSilver();
		totalResult.pull();
	}
}

class gold implements material
{
	// Material blueprint for gold.
	@Override
	public void createMaterial() 
	{
		System.out.println("1 gold");
		totalResult.addGold();
		totalResult.pull();
	}
}
class diamond implements material
{
	// Material blueprint for diamond.
	@Override
	public void createMaterial() 
	{
		System.out.println("1 diamond");
		totalResult.addDiamond();
		totalResult.pull();
	}
}

public class materialType
{
	// Factory instructions for making materials.
	public material getMaterial(int randomMaterial)
	{
		if(randomMaterial<35)
		{
			return new bronze();
		}
		
		else if(randomMaterial>=35 && randomMaterial<=45)
		{
			return new silver(); 
		}
		else if(randomMaterial>=46 && randomMaterial<=49)
		{
			return new gold(); 
		} 
		else if(randomMaterial==50)
		{
			return new diamond(); 
		}
		return null; 
	}
}

class totalResult
{
	// Statistics for total pulls and total materials.
	static int pullsMade = 0;
	static int bronze = 0;
	static int silver = 0;
	static int gold = 0;
	static int diamond = 0;
	
	// The rest of the static methods below are for incrementing pulls and materials.
	
	static void pull()
	{
		pullsMade+=1;
	}
	static void addBronze()
	{
		bronze+=1;
	}
	static void addSilver()
	{
		silver+=1;
	}
	static void addGold()
	{
		gold+=1;
	}
	static void addDiamond()
	{
		diamond+=1;
	}
}