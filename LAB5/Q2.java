import java.util.ArrayList;

public class Q2 {

    public static ArrayList<Integer> Wazowski(int N, Game G, ArrayList<Integer> games){

        if(N == 0){
            return games;
        }

        if(N >= G.sumGb()){

            for(int i = 0; i < G.lengthGb(); i++){
                games.add(G.score.get(i));

            }
            return games;
        }
        int x = G.mostScore();
        games.add(x);
        return Wazowski(G.N, G,games);
    }

    public static void main(String[] args){
        ArrayList <Integer> games = new ArrayList<Integer>();
        ArrayList<Integer> gb = new ArrayList<Integer>();
        gb.add(45);
        gb.add(10);
        gb.add(15);
        gb.add(20);
        gb.add(25);
        gb.add(100);
        ArrayList<Integer> score = new ArrayList<Integer>();
        score.add(50);
        score.add(85);
        score.add(45);
        score.add(100);
        score.add(6);
        score.add(100);

        Game G = new Game(gb,score,1000);

        ArrayList <Integer> result = new ArrayList<Integer>(Wazowski(1000,G,games));
        //ArrayList <Integer> result = new ArrayList<Integer>(Wazowski(0,G,games));


        System.out.print("Result is: ");
        for (int i = 0; i < result.size();i++){
            System.out.print(result.get(i) + " ");
        }
        System.out.println();
        games.clear();
        result = new ArrayList<Integer>(Wazowski(0,G,games));


        System.out.print("Result is: ");
        for (int i = 0; i < result.size();i++){
            System.out.print(result.get(i) + " ");
        }
        System.out.println();

        games.clear();

        G = new Game(gb,score,145);
        result = new ArrayList<>(Wazowski(145,G,games));
        System.out.print("Result is: ");
        for (int i = 0; i < result.size();i++){
            System.out.print(result.get(i) + " ");
        }
        System.out.println();

        gb.clear();
        score.clear();
        gb.add(60);
        gb.add(50);
        gb.add(200);
        gb.add(15);
        gb.add(40);
        score.add(75);
        score.add(85);
        score.add(65);
        score.add(100);
        score.add(55);
        //result.clear();
        games.clear();

        Game T = new Game(gb,score,115);
        result = new ArrayList<>(Wazowski(115,T,games));
        System.out.print("Result is: ");
        for (int i = 0; i < result.size();i++){
            System.out.print(result.get(i) + " ");
        }

    }
}