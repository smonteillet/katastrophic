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
				int best_bM = Integer.MIN_VALUE;
				int best_sM = Integer.MIN_VALUE;

				// Max profit is set to min value for initialization purposes.
				int limitProfit = Integer.MIN_VALUE;
				for (int i = 1; i <= 12; i++)
				{
					 mList.add(scanner.nextInt());
				}
				for (int bM = 1; bM <= MAX_HOURS; bM++)
				{
					 for (int sM = bM + 1; sM <= MAX_HOURS; sM++)
					 {
						  int sellPrice = mList.get(bM - 1);
						  int quantity = amount / sellPrice;
						  int priceBuy = mList.get(sM - 1);
						  int currentProfit = -quantity * sellPrice + quantity * priceBuy;
						  if (currentProfit > limitProfit)
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
