import java.util.*;
class Solution {
    static List<Integer> answer;
    static int[] lionInfo;
    static int maxScore=0;
    public int[] solution(int n, int[] info) {
        lionInfo = new int[11];
        answer = new ArrayList<>();
        int[] finalAns = new int[11];
        answer.add(-1);
        
        go(n,info,10,0,0);
        
        if(answer.size() ==1){
            return new int[]{-1};
        }
        
        for(int i=0;i<=10;i++){
            finalAns[i] = answer.get(i);
        }
        
        return finalAns;
    }
    static void go(int n, int[] info, int idx, int lionScore, int peachScore){
        
        // 중단 시점
        if(idx ==0){
            if(n >=0){
                // 남으면 0으로 다 넣기
                lionInfo[10] = n;
                // 어피치 보다 점수가 큰 지 확인
                if(peachScore < lionScore){
                    // 최대 점수 차이 
                    if(maxScore < lionScore-peachScore){
                        maxScore = lionScore-peachScore;
                        answer = new ArrayList<>();

                        for(int i=0;i<=10;i++){
                            answer.add(lionInfo[i]);
                        }
                        // 같을때 작은 수가 더 많은것이 갱신되도록 비교
                    }else if(maxScore == lionScore-peachScore){
                        boolean flag = false;
                        for(int i=10;i>=0;i--){
                            if(lionInfo[i] > answer.get(i)){
                                flag = true;
                                break;
                            }else if(lionInfo[i] < answer.get(i)){ // answer가 더 낮은거 큰 경우도 break
                                break;
                            }
                        }
                        if(flag){
                            answer = new ArrayList<>();

                            for(int i=0;i<=10;i++){
                                answer.add(lionInfo[i]);
                            }
                        }
                    }

                }
                // lionInfo[10] = 0;
            }
            
            
            return;
        }

        // 조건 : info[idx]가 0이 아닌 경우
        if(info[10-idx] > 0){
            int num = info[10-idx];
            // 2가지 (안쏘는 경우, 쏴서 k 얻는 경우)
            // 동점인 경우 어피치가 가져가는 데 그것도 포함??? -> X
            // lionInfo 넣기 필요!!
            // 1. 안 쏘는 경우
            go(n,info, idx-1, lionScore,peachScore+idx);
            // 2. 쏴서 k 얻는 경우 (total 남아있는지 체크)
            if(num < n){
                lionInfo[10-idx] = num+1;
                go(n-num-1, info, idx-1, lionScore + idx,peachScore);
                lionInfo[10-idx] = 0;
            }
        }else{
            // 2가지 (안쏘는 경우, 쏴서 K 얻는 경우)
            // 1. 안쏘는 경우
            go(n,info,idx-1,lionScore,peachScore);

            lionInfo[10-idx] = 1;
            go(n-1,info,idx-1,lionScore+idx,peachScore);
            lionInfo[10-idx] = 0;
            
        }
    }
}