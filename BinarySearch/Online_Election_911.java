package BinarySearch;
import java.util.Arrays;
import java.util.HashMap;

class TopVotedCandidate {
    HashMap<Integer, Integer> time_lead;
    HashMap<Integer, Integer> person_votes;
    
    int[] time;
    public TopVotedCandidate(int[] persons, int[] times) {
        time_lead = new HashMap<>();
        person_votes = new HashMap<>();
        int lead = -1;
        time = times;
        int n = persons.length;
        for (int i = 0; i < n; i++)
        {
            person_votes.put(persons[i], person_votes.getOrDefault(persons[i], 0) + 1);
            if (i == 0 || person_votes.get(persons[i]) >= person_votes.get(lead))
            {   
                lead = persons[i];
            }
            time_lead.put(times[i], lead);
        }
    }

    public static int binarySearch(int[] times, int t)
    {
        int i = 0, j = times.length - 1;
        int mid = i + (j - i)/2;
        int ans = -1;
        while (i <= j)
        {
            if (times[mid] == t)
            {
                return times[mid];
            }
            else if (times[mid] > t)
            {
                j = mid - 1;
            }
            else
            {
                ans = times[mid];
                i = mid + 1;
            }
            mid = i + (j - i)/2;
        }
        return ans;
    }
    
    public int q(int t) {
        int i = binarySearch(time, t);
        int value = time_lead.get(i);
        return value;
    }
}

public class Online_Election_911 {
    
}
