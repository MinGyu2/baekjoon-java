package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14889 {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        StringTokenizer st;
        for(int i = 0; i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    
        int[] teamName = new int[n/2];
        boolean[] team = new boolean[n];
        team[0] = true;
        teamFind(arr, teamName, team, 1, 1, n/2);
        System.out.println(min);
    }
    static void teamFind(final int[][] ability,final int[] teamName,final boolean[] team,int currentFindMember, int cnt,final int maxTeam){
        if(cnt == maxTeam){
            // System.out.print(Arrays.toString(teamName));
            // System.out.println(abilitySum(ability, teamName));
            
            int[] anotherTeam = new int[maxTeam];
            for(int i = 0, k = 0;i<team.length;i++){
                if(!team[i]){
                    anotherTeam[k++] = i;
                }
            }
            // System.out.print(Arrays.toString(anotherTeam));
            // System.out.println(abilitySum(ability, anotherTeam));
            int temp = abilitySum(ability, teamName) - abilitySum(ability, anotherTeam);
            temp = Math.abs(temp);
            if(min > temp) { min = temp; }
            return;
        }
        for(int i = currentFindMember; i< team.length; i++){
            if(!team[i]){
                team[i] = true;
                teamName[cnt] = i;
                teamFind(ability, teamName, team, i+1, cnt+1, maxTeam);
                team[i] = false;
                teamName[cnt] = 0;
            }
        }
    }
    static int abilitySum(final int[][] abiltyNum, final int[] teamName){
        int sum = 0;
        for(int i:teamName){
            for(int j:teamName){
                sum +=abiltyNum[i][j];
            }
        }
        return sum;
    }
}
