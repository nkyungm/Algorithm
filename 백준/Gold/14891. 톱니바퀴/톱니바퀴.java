import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static char[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =null;

        // 톱니바퀴 2진수로 저장
        arr= new int[4];
        // 1번 : 2, 2번: 6, 3번 : 2, 4번: 6 배열에 저장
        check = new char[6];

        for (int i = 0; i <4 ; i++) {
            arr[i] = Integer.parseInt(br.readLine(), 2);
            // 2 또는 6번째 자리 저장
            checkBit(i);
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st  = new StringTokenizer(br.readLine());
            // 톱니바퀴 번호
            int num = Integer.parseInt(st.nextToken());
            // 방향
            int turn = Integer.parseInt(st.nextToken());
            boolean isTurn = true; // 앞에꺼 돌았는지 체크
            switch(num) {
                case 1: //톱니바퀴 1번이 돌아가는 경우
                    shift(0, turn);
                    for (int j = 0; j < 3; j++) {
                        if(j > 0 && !isTurn) continue;
                        if (check[j*2] == check[(j*2)+ 1]) {
                            isTurn = false;
                            continue; //앞과 동일한 경우 안돌고 그대로 진행
                        }
                        turn = ((turn == -1) ? 1 : -1);
                        shift(j + 1, turn); //반대방향으로 돌기
//                        checkBit(j + 1); //2 또는 6번째 부딪치는 부분 저장
                        isTurn = true;
                    }
                    for (int j = 0; j < 4; j++) {
                        checkBit(j); //2 또는 6번째 부딪치는 부분 저장
                    }
                    break;
                case 2: //톱니바퀴 2번이 돌아가는 경우
                    shift(1, turn);
                    if (check[1] != check[0]) { //2와 1 비교
                        shift(0, (turn == -1 ? 1 : -1)); //2와 반대로 돌아가도록 구현
                    }
                    // 2 -> 3-> 4 비교
                    for (int j = 1; j < 3; j++) {
                        if(j > 1 && !isTurn) continue;
                        if (check[j*2] == check[(j*2) + 1]) {
                            isTurn = false;
                            continue; //앞과 동일한 경우 안돌고 그대로 진행
                        }
                        turn = ((turn == -1) ? 1 : -1);
                        shift(j + 1, turn); //반대방향으로 돌기
                        isTurn = true;
                    }
                    for (int j = 0; j < 4; j++) {
                        checkBit(j); //2 또는 6번째 부딪치는 부분 저장
                    }
                    break;
                case 3: //톱니바퀴 3번이 돌아가는 경우
                    shift(2, turn);
                    if (check[4] != check[5]) { //3와 4 비교
                        shift(3, (turn == -1 ? 1 : -1)); //3과 반대로 돌아가도록 구현
                    }
                    // 3 -> 2 -> 1 비교
                    for (int j = 2; j > 0; j--) {
                        if (j == 1 && !isTurn) continue;
                        if (check[2*j-1] == check[2*j-2]) {
                            isTurn = false;
                            continue; //앞과 동일한 경우 안돌고 그대로 진행
                        }
                        turn = ((turn == -1) ? 1 : -1);
                        shift(j - 1, turn); //반대방향으로 돌기
                        isTurn = true;
                    }
                    for (int j = 0; j < 4; j++) {
                        checkBit(j); //2 또는 6번째 부딪치는 부분 저장
                    }
                    break;
                case 4: //톱니바퀴 4번이 돌아가는 경우
                    shift(3, turn);
                    for (int j = 3; j > 0; j--) {
                        if(j < 3 && !isTurn) continue;
                        if (check[2*j-1] == check[2*j-2]) {
                            isTurn = false;
                            continue; //앞과 동일한 경우 안돌고 그대로 진행
                        }
                        turn = ((turn == -1) ? 1 : -1);
                        shift(j - 1, turn); //반대방향으로 돌기
                        isTurn = true;
                    }
                    for (int j = 0; j < 4; j++) {
                        checkBit(j); //2 또는 6번째 부딪치는 부분 저장
                    }
                    break;
            }
        }
//        for (int i = 0; i < 4; i++) {
//            System.out.println(Integer.toBinaryString(arr[i]));
//        }
        int ans = 0;
        ans += (((0x80 >>> 0) & (byte) arr[0]) == 0 ? 0 : 1);
        ans += (((0x80 >>> 0) & (byte) arr[1]) == 0 ? 0 : 2);
        ans += (((0x80 >>> 0) & (byte) arr[2]) == 0 ? 0 : 4);
        ans += (((0x80 >>> 0) & (byte) arr[3]) == 0 ? 0 : 8);

        System.out.println(ans);
    }
    private static void shift(int idx, int turn){
        if(turn== -1){
            arr[idx] = ((arr[idx] << 1) | (arr[idx] >>> (8-1)))& 0xFF; //왼쪽 shift 연산
        }else{
            arr[idx] = ((arr[idx] >>> 1) | (arr[idx] << (8-1)))& 0xFF; //오른쪽 shift 연산
        }
    }
    private static void checkBit(int idx){
        if (idx == 0) {
            check[0] = ((0x80 >>> 2) & (byte) arr[idx]) == 0 ? '0' : '1';
        } else if(idx ==1){
            check[1] = ((0x80 >>> 6) & (byte) arr[idx]) == 0 ? '0' : '1';
            check[2] = ((0x80 >>> 2) & (byte) arr[idx]) == 0 ? '0' : '1';
        }else if(idx ==2){
            check[3] = ((0x80 >>> 6) & (byte) arr[idx]) == 0 ? '0' : '1';
            check[4] = ((0x80 >>> 2) & (byte) arr[idx]) == 0 ? '0' : '1';
        }
        else if (idx == 3) {
            check[5] = ((0x80 >>> 6) & (byte) arr[idx]) == 0 ? '0' : '1';
        }
    }
}
