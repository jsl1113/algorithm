package programmers;

public class P154539_뒤에있는큰수찾기 {
	public int[] solution(int[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        
        answer[len-1]=-1;
        
        for(int i=len-2;i>=0;i--){
            
            for(int j=i+1;j<len;j++){
                if(numbers[i] < numbers[j]){
                    answer[i] = numbers[j];
                    break;
                }else{
                    if(answer[j]==-1){
                        answer[i]= -1;
                        break;
                    }else if(numbers[i]<answer[j]){
                        answer[i] = answer[j];
                        break;
                    }
                }
                
            }
            
        }
        
    
       
        
        return answer;
    }
}
