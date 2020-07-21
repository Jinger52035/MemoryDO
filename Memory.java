package Test1;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Memory {
	
	public static void main(String[] args) {
		Date date = new Date();
		
	}
	
	private int MEMORY_VALUE = 0; //初始记忆度
	private int period = 0;
	
	Map<Incident,Integer> map = new HashMap<Incident,Integer>();
	
	
	public void add(String incident) {//输入增加的事件，初始事件的记忆评分是0
		Incident inci = new Incident(null, null, incident);
		map.put(inci, MEMORY_VALUE);
	}
	
	
	public void review(String incident) {//复习或者学习某件事 
		
		
	}
	//艾宾浩斯记忆曲线
	public int Ebbinghaus(Date dateStart,Date dateEND) {
		
		//时间间隔单位：分钟
		if(period<20) {
			return 100;
		}else if(period<60) {
			return 58;
		}else if(period<420) {
			return 36;
		}else if(period<1440) {
			return 34;
		}else if(period<2880) {
			return 28;
		}else if(period<8640) {
			return 25;
		}else if(period<43200) {
			return 21;
		}else {
			return MEMORY_VALUE;	
		}
		
		
		
	}
	
	
}

class Incident{
	private int memory = 0;//记忆度，最大值100（%），最小值0（%）。初始化为0
	private Date dateStart = new Date();//起始时间
	private Date dateEnd = new Date();//终止时间
	private String incident = null;//事件，初始事件为空
	
	public Incident(Date dateStart,Date dateEnd,String incident) {
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.incident = incident;
	}

}
