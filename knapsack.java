package hackerrank;
import java.util.*;


public class knapsack {
    static ArrayList<Integer> can = new ArrayList<>();
    // static int sum = 0;

    static int  multiChk(int n, int t,int summ){
        if((t/n) >2){
            int sum = summ;
            int count = t/n;
                
            for(int j = 0;j<count;j++){
                if(sum+n <=t){
                sum = sum+n;
                }
                else{
                    break;
                }
                
            }
            // System.out.println("sum out of multichk:"+sum);
            return sum;

            }
        else{
            return -1;
        }
    }

    
    static public void knap(int k,List<Integer> l){

        ArrayList<Integer> thel = new ArrayList<>(l);
        Collections.sort(thel, Collections.reverseOrder());


        for(int i = 0; i<thel.size();i++){
            int sum = 0;
            // System.out.println("i"+i);
            if(thel.get(i)>k){
                // System.out.println("inside greater than argument");
                continue;
            }
            else{
                sum = sum+thel.get(i);
                if(sum == k){
                    // System.out.println(sum);
                    return;
                }

                int chk =multiChk(thel.get(i), k,sum);
                // System.out.println("firstt multi check: "+chk);
                if(sum == k){
                    System.out.println(sum);
                    return;
                }

                if(chk != -1){
                    can.add(chk);
                }
                if(i<thel.size()-1){

                    for(int j =i+1;j<l.size();j++){
                        // System.out.println("j"+j);

                        if(sum+thel.get(j)<k){
                            // System.out.println("success is adding "+sum+"and"+thel.get(j));
                            sum = sum+thel.get(j);

                            if(sum == k){
                                // System.out.println(sum);
                                return;
                            }
                        }
                        int chk2 = multiChk(k-sum, k,sum);
                        // System.out.println("second multi check: "+chk2);

                        if(sum == k){
                            // System.out.println(sum);
                            return;
                        }
                        if(chk2 != -1){
                        can.add(chk2);
                        }


                    }

                }
                else{
                    // System.out.println("inside else"+i);

                    int chk2 = multiChk(thel.get(i), k,sum);
                    if(chk2 != -1){
                        can.add(chk2);
                    }
                }

                }

            }

        Collections.sort(can, Collections.reverseOrder());
        // System.out.println(can);
        System.out.println(can.get(0));
        return;    
    }


        
    
    
    
    
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3,7,9,11);


        knap(13,list);


    }
    


}
