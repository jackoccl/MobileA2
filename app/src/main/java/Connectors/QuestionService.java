package Connectors;

import java.util.ArrayList;
import java.util.Random;


public class QuestionService {
    int count = 10;
    public ArrayList<Celebrity> randCelebs = new ArrayList<>();
    public QuestionService(ArrayList<Celebrity> celebs) {
        Random r = new Random();
        for(int i=0;i<10;i++){
            randCelebs.add(celebs.get(r.nextInt(celebs.size()-1+1)+1));
        }
    }
}
