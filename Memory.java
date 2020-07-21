package Test1;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Memory {
	
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date.getTime());
	}
	
	private Date date = new Date();
	private double memory = 0;//初始记忆度，初始化0
	
	Map<String,Integer> map = new HashMap<String,Integer>();//创建HashMap用来放置事件，和评分
	Map<String,Date> map2 = new HashMap<String,Date>();//创建HashMap用来放置事件，和时间差
	
	public void add(String incident) {//输入增加的事件，初始事件的记忆评分是0
		map.put(incident,0);
		map2.put(incident,date);
	}
	
	
	public void review(String incident) {//复习或者学习某件事 
		map.put(incident, 100);
		System.out.println("你当前学习了"+incident+",学习程度"+map.get(incident)+"%");
	}
	//艾宾浩斯记忆曲线
	
	
}
