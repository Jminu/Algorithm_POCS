import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Backjoon17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];

        Stack<Integer> stack=new Stack<>();
        int[] result=new int[n];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0; i<arr.length; i++)
            arr[i]=Integer.parseInt(st.nextToken());

        /**
         * ���� ������ ������ ��ū�� Ž�� ������ �����Ѵ�.
         * peek �� ��ū���� �ƴ� ���, pop
         * ��ū���� ������ ��(������ ���� �ʾ�����) peek �� ����� �־��ְ�
         * �� �� -1�� ����� �־��ش�.
         * ���� Ž������ ��ū�� �ĺ��� ���Խ��� Ž���� ������ ���� �Ѵ�.
         */
        for(int i=arr.length-1; i>=0; i--){
            while(!stack.isEmpty()&&stack.peek()<=arr[i])
                stack.pop();

            result[i]=stack.isEmpty()?-1:stack.peek();

            stack.push(arr[i]);
        }

        for (int value : result) {
            bw.write(String.valueOf(value)+" ");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
