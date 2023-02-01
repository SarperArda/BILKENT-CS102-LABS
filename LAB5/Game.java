import java.util.ArrayList;

public class Game {
    public ArrayList<Integer> gb;
    public ArrayList<Integer> score;
    public int N;

    public Game(ArrayList<Integer> gb,ArrayList<Integer> score, int N){
        this.gb = gb;
        this.score = score;
        this.N = N;
    }

    public int sumGb(){
        int sum = 0;
        if(score == null){
            return 0;
        }
        for (int i = 0; i < gb.size();i++) {
            sum = sum + gb.get(i);
        }
        return sum;
    }


    public int mostScore(){
        if(score == null){
            return 0;
        }
        int most = score.get(0);
        int x = 0;

        for (int i = 1; i < score.size();i++){
            if(most < score.get(i)){
                most = score.get(i);
                x = i;
            }
        }

        if(N >= gb.get(x) ){
            score.remove(x);
            this.N = N - gb.get(x);

            gb.remove(x);
            return most;
        }
        if(N < gb.get(x) ){

            if(score.size() == 1 ){
                return 0;
            }
            score.remove(x);
            gb.remove(x);
            return mostScore();
        }
        return 0;
    }
    public int lengthGb(){
        return gb.size();
    }


}
