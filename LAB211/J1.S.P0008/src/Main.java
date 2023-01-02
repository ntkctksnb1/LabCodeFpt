
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DELL
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StringProcessor s = new StringProcessor("Alo anh binh gold day phai khong a, dung roi anh binh day ne!");
        s.countLetters();
        for (Map.Entry<String, Integer> en : s.getLetters().entrySet()) {
            System.out.println(en.getKey() + ", " + en.getValue());

        }
    }

}
