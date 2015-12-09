package name.lemerdy.eric;

/**
 * Created by monteillet on 09/12/2015.
 */
public class Profit
{
	 public int bestProfit = Integer.MIN_VALUE;

	 public int bestBuyMoment = Integer.MIN_VALUE;

	 public int bestSellMoment = Integer.MIN_VALUE;

	 @Override public String toString()
	 {
		  String toString;
		  if (bestProfit <= 0)
		  {
				toString = "IMPOSSIBLE";
		  }
		  else
		  {
				toString = bestBuyMoment + " " + bestSellMoment + " " + bestProfit;
		  }
		  return toString;
	 }
}
