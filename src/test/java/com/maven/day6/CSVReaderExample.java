package com.maven.day6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;

public class CSVReaderExample {
  @Test
  public void f() throws Exception {
	  CSVReader cs = new CSVReader(new FileReader("D:\\LTI_Training\\Testing\\data.csv"));
	  
	  List<String[]> allData = cs.readAll();
	  
	  for(int i=0;i<allData.size();i++) {
		  String[] row = allData.get(i);
		  
		  String user = row[0];
		  String pwd = row[1];
		  System.out.println(user+" "+pwd);
	  }
  }
}
