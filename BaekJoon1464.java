import java.io.*;
import java.util.PriorityQueue;

class Point{
    int index, value;
    Point(int index, int value){
        this.index = index;
        this.value = value;
    }
}

public class BaekJoon1464 {
    static int map[];
    static PriorityQueue<Point> queue = new PriorityQueue<>((o1, o2) -> {
            if(o1.value == o2.value) return o2.index - o1.index;
            else return o1.value - o2.value;
        });

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        map = new int[line.length()];
        int last;
        
        for(int i=0; i<line.length(); i++) {
            map[i] = (int) line.charAt(i);
            queue.add(new Point(i, (int) line.charAt(i)));
            //if((int) line.charAt(i) <= last.value) last = new Point(i, (int) line.charAt(i));
        }

        last = queue.poll().index;
        dfs(last);
        changeMap(last);

        for(int i=0; i<line.length(); i++) {
            System.out.print((char)map[i]);
        }
        //사전순으로 가장 앞서는 것을 출력하기.
        //가장 A에 가까운 것을 마지막에 뒤집고, 그 이후로는 뒤집어서는 안 된다.

        //가장 A에 가까운 수에 도달하기 전에, 그 사이 숫자들을 정렬하면 가장 사전 순으로 앞서는 문자열.

        //가장 작은 것에 도달하기 전 중 가장 작은 것을 가장 오른쪽으로.

        //같은 알파벳이 여러개 있을 수 있다. 이럴 땐 가장 뒤에 있는 걸 기점으로

        //CAAB 2 뒤집고
        //AACB 3 뒤집고 끝

        //ABCA 라면
        //CBAA 3
        //AABC 4

        //그러면 재귀 식으로 이걸 무한히 반복하면 될 것 같은데
        //0~last -> 0~last' 식

        //ADCBF
        //50글자를 50번 뒤집으면 25(1회연산시)*50(번) = 1250연산
    }

    static void dfs(int now){
        Point p;
        while (!queue.isEmpty()) {
            p = queue.poll();

            if(p.index < now) {
                //이미 가장 오른쪽에 있다면
                if(p.index == 0) {
                    changeMap(now-1);

                    //for(int i=0; i<map.length; i++) {
                    //    System.out.print((char)map[i]);
                    //}
                    //System.out.println("--");
                }

                else if(p.index == now - 1) {
                    dfs(p.index); //이 경우에는 그 안에 0~p.index 사이에 걸 하고
                    //대신 이 안에서 changeMap(now); 를 하면 안된다
                    //continue;
                }

                //이미 now의 바로 왼쪽인 경우가 아니면 dfs
                else {
                    dfs(p.index);
                    changeMap(p.index);
                    changeMap(now-1); //0에 위치한 걸 now-1에 위치하도록 한다
                }

                break;
            }
        }

        //

        //changeMap(now); //함수 안이 아니라 밖에서 하도록 수정

        //호출한 dfs가 종료됐다면 이제 바꾼다
        //가장 왼쪽으로 붙이기 위해 index위치에서 호출한 다음 
        //DFBEA 라면
        //FDBEA
        //BDFEA
        //EFDBA

        //BFDEA -> EDFBA -> ABFDE 3에서 한번 교체 4에서 한번 교체
        
    }

    //0~r을 뒤집는다 (r포함)
    //0 1 2 3
    //
    static void changeMap(int r){
        int temp;
        for(int i=0; i<=r/2; i++){
            temp = map[i];
            map[i] = map[r-i];
            map[r-i] = temp;
        }
    }

    //A(3)는 가장 앞으로 와야하고
    //B는 A의 바로 왼쪽에 가야하며
    //C는 B의 가장 오른쪽에

    //last의 last(=se)가 last의 가장 왼쪽에 가려면 se가 가장 오른쪽에 있어야한다.
    //그러면 changeMap(se.index) 후에 changeMap(last.index - 1)이면 된다
    //*  se를 가장 오른쪽으로 둔 뒤에는 last와 se 사이 뒤집기를 수행할 수 없다.


    //그러면 세번째로 작은 알파벳을 가깝게 두려면 어떻게 해야하나

    //원래
    //DCBAF 였다고 한다면
    //마찬가지로 B를 기준점으로 잡고 B의 바로왼쪽에 붙어있어야하니까
    //원래 CDBAF 였다면 2에서 뒤집고 3에서 뒤집고 4에서 뒤집어서 ABCDF를 만들 수 있다
    //그러니까 가장 작은거 last의 가장 왼쪽에 last'가 붙어있으려면 last'가 가장 오른쪽에.
    // 가장 오른쪽으로 옮기기(=changeMap(last'.index)) 전에 0~last' 내에서 가장 작은 걸 last'의 가장 오른쪽에 붙여야하고
    // 이를 위해 last''가 가장 왼쪽에있어야하므로 changeMap(last''.index)를 수행해야하고
    
}
