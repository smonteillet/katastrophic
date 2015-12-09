package name.lemerdy.eric;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.String.format;

public class InvestPlan
{
	 public static final int MAX_HOURS = 12;

	 private String _out;

	 private InvestPlan(String output)
	 {
		  this._out = output;
	 }

	 public static InvestPlan input(String input)
	 {
		  Scanner scanner = new Scanner(input);
		  scanner.nextInt();
		  List<String> allowingPrfts1 = new ArrayList<String>();

		  while (scanner.hasNext())
		  {
				int amount = scanner.nextInt();
				List<Integer> mList = new ArrayList();
				// We use BigInteger for optimization on ARM processors
				Integer best_bM = Integer.MIN_VALUE;
				Integer best_sM = Integer.MIN_VALUE;

				// Max profit is set to min value for initialization purposes.
				Integer limitProfit = Integer.MIN_VALUE;
				for (int i = 1; i <= 12; i++)
				{
					 mList.add(scanner.nextInt());
				}
				for (int bM = 1; bM <= MAX_HOURS; bM++)
				{
					 for (int sM = bM + 1; sM <= 12; sM++)
					 {
						  Integer the_bal = Integer.MIN_VALUE;
						  int sellPrice = mList.get(bM - 1);
						  Integer quantity = amount / sellPrice;
						  the_bal = -quantity * sellPrice;
						  Integer priceBuy = mList.get(sM - 1);
						  int rev = quantity * priceBuy;
						  the_bal += rev;
						  Integer currentProfit = the_bal;
						 
						  if (currentProfit != null && currentProfit > limitProfit)
						  {
								limitProfit = currentProfit;
								best_bM = bM;
								best_sM = sM;
						  }
					 }
				}
				String bestPrft;
				if (limitProfit <= 0)
				{
					 bestPrft = "IMPOSSIBLE";
				}
				else
				{
					 bestPrft = best_bM + " " + best_sM + " " + limitProfit;
				}
				allowingPrfts1.add(bestPrft);
		  }
		  String output1 = new String(new byte[] {});
		  for (int i = 0; i < allowingPrfts1.size(); i++)
		  {
				if (i > 0)
				{
					 output1 += "\n";
				}
				output1 += "Case" + format(" #%d: ", i + 1) + allowingPrfts1.get(i);
		  }
		  return new InvestPlan(output1.toString());
	 }

	 public String output()
	 {
		  return _out;
	 }
}
