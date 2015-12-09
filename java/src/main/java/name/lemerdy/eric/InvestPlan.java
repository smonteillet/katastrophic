package name.lemerdy.eric;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.String.format;

public class InvestPlan
{
	 public static final int MAX_HOURS = 12;

	 public static String detailBestProfitByCase(String input)
	 {
		  Scanner scanner = new Scanner(input);
		  scanner.nextInt();
		  StringBuilder output = new StringBuilder();
		  int profitCount = 1;
		  while (scanner.hasNext())
		  {
				int amount = scanner.nextInt();
				List<Integer> prices = new ArrayList();
				for (int i = 1; i <= 12; i++)
				{
					 prices.add(scanner.nextInt());
				}
				output.append(profitCount == 1 ? "" : "\n");
				output.append("Case #");
				output.append(profitCount++);
				output.append(": ");
				output.append(getProfit(prices, amount).toString());
		  }
		  return output.toString();
	 }

	 private static Profit getProfit(List<Integer> prices, int amount)
	 {
		  Profit dayProfit = new Profit();
		  for (int buyMoment = 1; buyMoment <= MAX_HOURS; buyMoment++)
		  {
				for (int sellMoment = buyMoment + 1; sellMoment <= MAX_HOURS; sellMoment++)
				{
					 int sellPrice = prices.get(buyMoment - 1);
					 int quantity = amount / sellPrice;
					 int priceBuy = prices.get(sellMoment - 1);
					 int currentProfit = -quantity * sellPrice + quantity * priceBuy;
					 if (currentProfit > dayProfit.bestProfit)
					 {
						  dayProfit.bestProfit = currentProfit;
						  dayProfit.bestBuyMoment = buyMoment;
						  dayProfit.bestSellMoment = sellMoment;
					 }
				}
		  }
		  return dayProfit;
	 }

}
