package letspaintapplication;

public class TrigLookUpTable 
{
	public static double[] cos=new double[360];
	public static double[] sin=new double[360];
	
	public static void populate()
	{
		double radians;
		for(int i=0; i<360; i++)
		{
			radians=i*(Math.PI/180);
			cos[i]=Math.cos(radians);
			sin[i]=Math.sin(radians);
		}
	}
}
