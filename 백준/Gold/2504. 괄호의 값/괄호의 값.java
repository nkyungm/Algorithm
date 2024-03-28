import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		 
		Stack<Character> stack = new Stack<>();
		
		int temp = 1;
		int result = 0;
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if(c == '(') {
				temp*=2;
				stack.add(c);
			}
			else if(c=='[') {
				temp*=3;
				stack.add(c);
			}else if(c==')') {
				if(stack.isEmpty()) {
					result = 0;
					break;
				}
				char out = stack.pop();
				if(out != '(') { //종료 조건
					result = 0; break;
				}
				if(s.charAt(i-1) =='(') result+=temp;
				temp/=2;
				
			}else if(c==']') {
				if(stack.isEmpty()) {
					result = 0;
					break;
				}
				char out = stack.pop();
				if(out != '[') { //종료 조건
					result = 0; break;
				}
				if(s.charAt(i-1) =='[') result+=temp;
				temp/=3;
			}
		}
		if(!stack.isEmpty()) result = 0;
		System.out.println(result);
	}
}
