package parser;

import java.text.DecimalFormat;
import java.util.ListIterator;
import java.util.regex.*;

public class parserResult {
	private String result;
	private boolean isContain;
	private String[] subStr;
	private String[] subStr2;
	private String subStr3;
	private String result1;
	private String result2;
	private String result3;
	private String result4;
	private String result5;
	private String result6;
	private String result7;
	private String result8;
	private String result9;
	private String result10;
	private String result11;
	private String result12;
	private int i;
	private double results[] = new double[8];
	private String formattedDouble[] = new String[8];
	public void parse(String result) {
		result1 = result.replace("{", " ");
		result2 = result1.replace("}", "");
		result3 = result2.replace("E-", "");
		Pattern pat=Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
		i = 0;
		Matcher matcher=pat.matcher(result3);
		while (matcher.find()) {
			results[i] = Double.parseDouble(matcher.group());
		    i++;
		}
		for(int i = 0; i <8 ; i++) {
			results[i] = results[i] * 100;
			if(results[i] >= 100)
				results[i] = 0;
			formattedDouble[i] = new DecimalFormat("#0.00").format(results[i]);
		}
		result4 = "Овчарка = " + formattedDouble[0] + "%\nМопс = " + formattedDouble[1] + "%\nДалматинец = " + formattedDouble[2] + "%\nКорги = " + formattedDouble[3] + "%\nШпиц = " + formattedDouble[4] + "%\nЙорк = " + formattedDouble[5] + "%\nПудель = " + formattedDouble[6] + "%\nЛабрадор = " + formattedDouble[7]+ "%";
		this.result = result4;
		
	}

	public String getResult() {
		return result;
	}
}
