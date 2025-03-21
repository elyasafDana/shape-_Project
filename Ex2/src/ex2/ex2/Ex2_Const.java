package ex2.ex2;

/**
 * This class represents a set of parameters for Ex2 GUI Shape application for:
 * Introduction to Computer Science 2023, Ariel University.
 * Do NOT change this class
 * @author boaz.benmoshe
 *
 * * ID 315489534
 */
public class Ex2_Const {
	public static final double EPS1 = 0.001, EPS2=Math.pow(EPS1, 2), EPS = EPS2;
	// Constant flags for sorting. 
	private static int count = 0;
	public static final int Sort_By_Tag = count++, Sort_By_Anti_Tag=count++, 
			Sort_By_Area =count++, Sort_By_Anti_Area = count++,
			Sort_By_Perimeter =count++, Sort_By_Anti_Perimeter = count++, 
			Sort_By_toString = count++, Sort_By_Anti_toString = count++;
	public static int Width = 640, Height = 640;
	public static int DIM_SIZE = 10;
	
}
