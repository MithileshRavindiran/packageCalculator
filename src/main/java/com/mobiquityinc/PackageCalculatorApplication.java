package com.mobiquityinc;


import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.packer.Packer;
import org.apache.commons.lang3.StringUtils;

public class PackageCalculatorApplication {


	public static void main(String[] args) throws Exception {
		if (args != null && args.length >=1) {
           for (int i=0;i < args.length; i++) {
            pack(args[i]);
		   }
		} else {
			pack(null);
		}
	}

	private static void pack(String filePath) throws APIException {
		String output = StringUtils.EMPTY;
		if (StringUtils.isBlank(filePath))
			output = Packer.pack("src/main/resources/testcases.txt");
		else
			output = Packer.pack(filePath);
		System.out.println(output);
	}
}
