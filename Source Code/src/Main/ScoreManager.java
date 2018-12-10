package Main;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ScoreManager {
    public long timeScore;
    public JList jScoreList;
    public JFrame frame;
    public String name;
    public List<String> scoreList;
    public String scoreName[];
    public List<String> sortedScoreList;

    public ScoreManager(long timeScore){
        this.timeScore = timeScore;
        frame = new JFrame("Score manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize( 700, 500);



    }

    public void setScore(){
        scoreList = new ArrayList<>();
        name = JOptionPane.showInputDialog("Please enter your name: ");

       try {
           File file = new File("Score.txt");
           Scanner sc = new Scanner(file);
           while (sc.hasNextLine()){
               scoreList.add(sc.nextLine());
           }
       }
       catch (Exception e){

       }
        System.out.println(scoreList);
        scoreList.add(Long.toString(timeScore) + " seconds: " + name);
        System.out.println(scoreList);
        try {
            PrintWriter writer = new PrintWriter("Score.txt");

        }
        catch(Exception e){

        }
        try {
            File fout = new File("Score.txt");
            FileOutputStream fos = new FileOutputStream(fout);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            for(String s: scoreList){
                bw.write(s);
                bw.newLine();
            }
            bw.close();
        }
        catch (Exception e){

        }


        Object[] scoreArr = new String[ sortScore(scoreList).size()];
        scoreArr =  sortScore(scoreList).toArray(scoreArr);
        jScoreList = new JList(scoreArr);
        frame.add(jScoreList);
        frame.setVisible(true);
    }

    public List sortScore(List sL){
        List<Score> scores = new ArrayList<>();

        for(Object score: sL){
            scoreName = score.toString().split(" seconds: ");
            scores.add(new Score(Integer.parseInt(scoreName[0]), scoreName[1]));
        }
        scores.sort(Comparator.comparingDouble(Score::getScore)
                .reversed());

        sortedScoreList = new ArrayList<>();

        for(int i = 0; i < scores.size(); i++){
            sortedScoreList.add("Position: " + (i + 1) + ": Time alive(Seconds): " + scores.get(i).getScore() + ": name: " + scores.get(i).getName());
        }

        return sortedScoreList;
    }



}
