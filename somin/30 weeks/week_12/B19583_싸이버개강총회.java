package BOJ.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class B19583_싸이버개강총회 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String str = br.readLine();
		String []ss = str.split(" ");
		Time[] timeList = new Time[3];
		for(int i=0;i<3;i++) {
			String[] t = (ss[i].split(":"));
			timeList[i] = new Time(Integer.parseInt(t[0]), Integer.parseInt(t[1]));
		}
	
		Map<String, String> map = new HashMap<>();
		
		String input= br.readLine();
		while(true) {
			if(input ==null || input.length()==0) break;
			
			String [] sss = input.split(" ");
			String [] t = sss[0].split(":");
			Time time = new Time(Integer.parseInt(t[0]), Integer.parseInt(t[1]));
		
			if(checkBeforeStart(timeList[0], time)) {
				map.put(sss[1],"s");
			}else if(checkEndandQuit(timeList[1],timeList[2], time)) {
				if(map.containsKey(sss[1])) {
					map.put(sss[1],"se");
				}
			}
			
			input = br.readLine();
		}
		
	
		int cnt=0;
		Collection<String> v = map.values();
		for(String val :v) {
			if(val.equals("se")) {
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
	
	//시작전에 채팅친 사람인지 체크
	public static boolean checkBeforeStart(Time time,Time now) {
		int hour = now.hour;
		int min = now.min;
		
		if(time.hour > hour) {
			return true;
		}else if(time.hour == hour) {
			if(time.min>= min) return true;
		}
		
		return false;
	}
	//End후 Quit 전 채팅친 사람 체크
	public static boolean checkEndandQuit(Time end,Time quit,Time now) {
		int hour = now.hour;
		int min = now.min;
		
		//end이상이고 quit이하를 충족하면 true
		if(end.hour > hour) {
			return false;
		}else if(end.hour <= hour) {
			if(end.hour == hour) {
				//시간이 같을때는 분이 미만이면 false
				if(end.min> min) return false;
				//end 이상 완료
			}
			if(quit.hour<hour) {
				return false;
			}
			else if(quit.hour>=hour) {
				if(quit.hour == hour) {
					//시간이 같을 때 분이 초과면 false
					if(quit.min<min) return false;
				}
			}
			
		}
		
		return true;
	}
	
	public static class Time{
		int hour;
		int min;
		Time(int hour, int min){
			this.hour=hour;
			this.min=min;
		}
		
	}

}
