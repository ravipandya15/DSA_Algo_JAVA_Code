package String;

public class Rotate_String_796 {
    
    // asked in Qualcomm

    public boolean rotateString(String s, String goal) {
        return ((s.length() == goal.length()) && (s + s).indexOf(goal) != -1);
    }

}
