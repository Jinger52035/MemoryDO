package Test1;


import java.util.HashMap;
import java.util.Map;

public class Memory {
	
	//map<事件，复习度>       map2<时间， {year,month,day,hour,min,时间差}>
	private Map<String,Double> map = new HashMap<String,Double>();
	private Map<String,int[]> map2 = new HashMap<String,int[]>();
	
	public static void main(String[] args) {
		Memory m = new Memory();
		String Chinese = "语文";
		String Math = "数学";
		m.add(Chinese,2020,8,14,14,59);
		m.review(Chinese, 2020, 8, 14, 15, 20);
		m.review(Chinese, 2020, 8, 14, 20, 20);
		m.review(Chinese, 2020, 8, 20, 15, 20);
		m.add(Math,2020,8,14,14,59);
		m.review(Math, 2020, 8, 15, 15, 20);
		m.review(Math, 2020, 9, 14, 20, 20);
		m.review(Math, 2021, 8, 20, 15, 20);
	}
	
	//计算时间差(输入，事件、年、月、日、时、分)
	private int[] period(String incident,int year,int month,int day,int hour,int min) {
		int[] temp = map2.get(incident);
		temp[5] = timeperiod(temp,year,month,day,hour,min);
		temp[0] = year;
		temp[1] = month;
		temp[2] = day;
		temp[3] = hour;
		temp[4] = min;
		return temp;
	}
	
	//计算两天的时间差，单位：分钟（并不完全精确）
	private int timeperiod(int temp[],int year,int month,int day,int hour,int min) {
		return (year-temp[0])*365*24*60+(month-temp[1])*30*24*60+(day-temp[2])*24*60+(hour-temp[3])*60+(min-temp[4]);
	}
	
	//增加事件，和初始时间
	public void add(String incident,int year,int month,int day,int hour,int min) {
		int[] timetemp = {year,month,day,hour,min,0};
		if(!map2.containsKey(incident)) {
			map2.put(incident,timetemp);
			map.put(incident, 0.0);
		}else{
			map2.put(incident,period(incident,year,month,day,hour,min));
			map.put(incident, 0.0);
		}
	}
	
	//复习事件
	public void review(String incident,int year,int month,int day,int hour,int min) {
		double temp = map.get(incident);
		map2.put(incident,period(incident,year,month,day,hour,min));
		map.put(incident, Ebbinghaus(map2.get(incident)[5])+10);
		if(map.get(incident)>=100) {
			map.put(incident, 100.0);
		}
		System.out.println("您复习了"+incident+"  最后一次学习时复习度是"+temp+"%  "+"今日复习后复习度是:"+map.get(incident)+"%"+"   复习时间 是："+year+"年"+month+"月"+day+"日"+hour+"时"+min+"分");
		System.out.println("表扬语录:"+admire(map.get(incident)));
		System.out.println("*********************************************************************************************");
	}
	
	//表扬用户
	private String admire(double score) {
		if(score<=20) {
			return "能不能认真点学习，你个废物！";
		}else if(score<=40) {
			return "你这个分数，让我很难夸你啊！";
		}else if(score<=60) {
			return "就这，能不能好好学习";
		}else if(score<=80) {
			return "学成这样也叫学习？";
		}else if(score<=100) {
			return "能不能多学点，能学死咋地！";
		}
		return "傻逼";		
	}
	
	//艾宾浩斯记忆曲线,根据中间相距的时间返回复习度
	private double Ebbinghaus(int period){
		if (period <= 20) {
			return -2.1 * period + 100;
		} else if (period <= 60) {
			return -0.35 * period + 65;
		} else if (period <= 540) {
			return -0.021 * period + 45.3;
		} else {
			return 18144 / period;
		}
	}
}



