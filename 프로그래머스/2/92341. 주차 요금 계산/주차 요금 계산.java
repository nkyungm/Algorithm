import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        StringTokenizer st = null;
        
        // HashMap에 저장(IN) - 번호, 입차 시간
        // OUT - HashMap에서 빼면서 out - in 시간 
        // 어디다가 저장.. hashmap.. (hashmap 2개)
        // 마지막 carMap 남은거 23:59으로 계산
        HashMap<String,String> carMap = new HashMap<>();
        HashMap<String,Integer> feeMap = new HashMap<>();
        
        
        
        for(String r : records){
            st = new StringTokenizer(r);
            String time = st.nextToken();
            String carnum = st.nextToken();
            String comm = st.nextToken();
            
            if(comm.equals("IN")){
                carMap.put(carnum,time);
            }else{ //OUT
                String inTime = carMap.get(carnum);
                // 시간 계산
                int dT = diffTime(inTime,time);
                feeMap.put(carnum,feeMap.getOrDefault(carnum,0)+dT);
                // 출차
                carMap.remove(carnum);
            }
        }
        
        // 출차 못한 차량 있는지 확인
        if(carMap.size() > 0){
            for(String carnum : carMap.keySet()){
                int dT = diffTime(carMap.get(carnum),"23:59");
                feeMap.put(carnum,feeMap.getOrDefault(carnum,0)+dT);
                // carMap.remove(carnum);
            }
        }
        
        // feeMap을 꺼내면서 계산
        List<int[]> arr = new ArrayList<>();
        for(String key : feeMap.keySet()){
            // System.out.println(feeMap.get(key));
            int totalFee = calFee(feeMap.get(key),fees);
            arr.add(new int[]{Integer.parseInt(key),totalFee});
        }
        // 차량번호 오름차순 정렬
        Collections.sort(arr,(o1,o2)-> o1[0] - o2[0]);
        
        answer = new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            answer[i] = arr.get(i)[1];
        }
        
        return answer;
    }
    static int calFee(int minute,int[] fees){
        int defaultMn = fees[0];
        int defaultFee = fees[1];
        int unitMn = fees[2];
        int unitFee = fees[3];
        
        if(defaultMn >= minute) return defaultFee;
        // 올림 나눗셈
        // (a + b - 1) / b;
        int temp = minute-defaultMn;
        return defaultFee + (temp+unitMn-1)/unitMn * unitFee;
    }
    static int diffTime(String inTime, String outTime){
        int it = getMinuteTotal(inTime);
        int ot = getMinuteTotal(outTime);
        
        return ot -it;
    }
    static int getMinuteTotal(String time){
        String[] tArr = time.split(":");
        int hour = Integer.parseInt(tArr[0]);
        int minute = Integer.parseInt(tArr[1]);
        
        return hour*60 + minute;
    }
}