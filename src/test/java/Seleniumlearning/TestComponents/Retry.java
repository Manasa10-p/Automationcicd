package Seleniumlearning.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	
	int Count=0;
	int maxTry=1;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if (Count<maxTry)
		{
			
			Count++;
			return true;
		}
			
		return false;
	}

}
