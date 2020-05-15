package com.allen.springdemo;

import org.springframework.stereotype.Component;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Component
public class PracFortuneService implements FortuneService {

	private List<String> fortuneDataList;
	private String fileName = "/Users/yujiewu/eclipse-workspace/spring-demo-annotations/src/com/allen/springdemo/fortunes_data.txt";
	
	public PracFortuneService() {
		
		fortuneDataList = new ArrayList<String>();

		readFromFile();
	}
	
	@Override
	public String getFortune() {
		
		System.out.println(fortuneDataList.toString());
		if (fortuneDataList.size() == 0) { return "Error happens";}
		
		int index = generateRandomIntIntRange(fortuneDataList.size());
		System.out.println("randomNumber: " + index);
		String selectedFortuneService = fortuneDataList.get(index);
		
		return selectedFortuneService;
	}
	
	private int generateRandomIntIntRange(int index) {
	    // create a random number generator
		Random r = new Random();
	    return r.nextInt(index);
	}
	
	private void readFromFile() {
		
			File file = new File(fileName);
			
			System.out.println("Reading fortunes from file: " + file);
			System.out.println("File exists: " + file.exists());
		  
			try(BufferedReader br = new BufferedReader(new FileReader(file))) {
				
				String tempLine;
				
				while ((tempLine = br.readLine()) != null) {
					fortuneDataList.add(tempLine);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
}
