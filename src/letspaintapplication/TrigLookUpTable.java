package letspaintapplication;

public class TrigLookUpTable
{
	final static double STEP=.125;
	final static int MAX_ANGLE=360;
	final static double[] cos=new double[(int)(MAX_ANGLE/STEP)];
	final static double[] sin=new double[(int)(MAX_ANGLE/STEP)];
	
	public static void populate()
	{
		int count=0;
		double radians;
		for(double i=0; i<MAX_ANGLE; i+=STEP)
		{
			if(count>=cos.length) break;
			radians=i*(Math.PI/180);
			cos[count]=Math.cos(radians);
			sin[count]=Math.sin(radians);
			count++;
		};
	}

	private static String arrToString(double[] arr){
		StringBuilder sb=new StringBuilder();
		for(int i=0; i<arr.length; i++){
			sb.append(i+":"+arr[i]+"\n");
		}
		return sb.toString();
	}

}

