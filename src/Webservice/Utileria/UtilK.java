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

	public static void imprimeMatriz(String[][] matriz)
	{
		for(int i = 0; i < matriz.length; i++) // filas
		{
			System.out.println();
			for(int e = 0; e < matriz[0].length; e++) //columnas
			{
				System.out.print(matriz[i][e] + "  ");
			}
		}
		System.out.println();
	}
}


















