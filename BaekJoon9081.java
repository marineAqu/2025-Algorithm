import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon9081 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        String line;
        LinkedList<Integer> list = new LinkedList<>();
        int maxNum;
        int minNum;
        //PriorityQueue<Integer> list = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<t; i++) {
            list.clear();
            line = br.readLine();
            maxNum = -1;

            //1. 전체 검사를 해서 순서를 저장한다. 이때 같은 알파벳은 같은 (15243 형태)
            //2. 뒤에서부터 검사했을때 하나 더 증가할 수 있는지 검사한다.
            //          (현재에 대해서) 나보다 큰 값이 큐에 존재해야 한다. -> 그럼 굳이 순서를 확인하지않아도됨
            //현재가 그런 경우: 큐에서 나보다 큰 값 중 가장 작은 값을 꺼내서 넣고 그 이후 오름차순 출력한다.

            //검사
            for(int k=line.length()-1; k>=0; k--) {
                if(list.size() > 0) {
                    // 나보다 큰 값이 큐에 존재하는 경우 (재정렬해서 출력하면 되는 경우)
                    if(maxNum > (int) line.charAt(k)){

                        list.add((int) line.charAt(k));

                        //출력 가능
                        //나보다 큰 값이 여러개 존재하는 경우가 있을 수 있다 (ex: 1 4 3)
                        // 이때는 그 중 가장 작은 값을 넣은 뒤 남은 것들은 오름차순으로 넣어야함
                        //변하지 않는 것들(내 앞의 것들) 넣기
                        for(int e=0; e<k; e++){
                            sb.append(line.charAt(e));
                        }

                        minNum = 100;
                        for(int e=0; e<list.size(); e++){
                            if(list.get(e) < minNum && list.get(e) > (int) line.charAt(k)) {
                                minNum = e;
                            }
                        }

                        //내 위치를 다음 알파벳으로 업데이트
                        sb.append((char) (int)list.remove((int)minNum));

                        Collections.sort(list);

                        while (!list.isEmpty()) {
                            sb.append((char) (int) list.poll());
                        }

                        sb.append("\n");

                        break; //멈추고 다음 테스트케이스로
                    }
                }

                // 이외 모든 경우엔 나 자신을 큐에 넣는다
                maxNum = Math.max(maxNum, (int) line.charAt(k));
                list.add((int) line.charAt(k));
            }

            //출력 (내가 맨 끝인 경우 -> 원문 그대로 출력)
            if(!list.isEmpty()) sb.append(line).append("\n");
        }

        System.out.print(sb);
    }
}
