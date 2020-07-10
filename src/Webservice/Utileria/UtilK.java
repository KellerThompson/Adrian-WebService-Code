package Webservice.Utileria;

/**
 * @Author Kelller Thompson
 */
public class UtilK 
{
	/**
	 * Valida una cadena string de no tener ' o =
	 * @author Keller Thompson
	 */
	public static boolean validString(String cad)
	{
		char[] cad2 = cad.toCharArray();
		for (char c: cad2)
		{
			if((int)c == 39 || (int)c == 61) // ':39  ,  =:61
			{
				return false;
			}
		}
		return true;
	}
}


















