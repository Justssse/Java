import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String[] nw = input.nextLine().split(" ");
        int n = Integer.parseInt(nw[0]);
        int w = Integer.parseInt(nw[1]);
        String[] tmp = input.nextLine().split(" ");
        int[] v = new int[n];
        long totalV = 0;
        for (int i = 0; i < n; i++) {
            v[i] = Integer.parseInt(tmp[i]);
            totalV += v[i];
        }
        int res = 0;
        if (totalV <= w){
            res = (int) Math.pow(2,n);
        }else {
            res = find(n - 1,w,v);
        }
        System.out.println(res);
    }

    public static int find(int n,int w,int[] v){
        if (w <= 0){
            return 0;
        }
        if (n == 0){
            if (v[0] > w){
                return 1;
            }else {
                return 2;
            }
        }
        return find(n - 1, w,v) + find(n - 1,w - v[n],v);
    }

}

/**
 *一共有n个，要求任取其中i个数，其和小于等于w，求共有多少种取法，i可取0；
 *f(i, w) = f(i-1, w) + f(i-1, w-v[i]);
 *前i个小于w的可能取法分为两种情况，第i个不取f(i-1, w);第i个取，即前i-1个小于w-v[i], f(i-1, w-v[i]);
 *终止条件：1.递归中出现w <= 0，则返回0；
 *        2.i = 1，w > 0;如果v[1] > w，则返回1，即第一个不取；如果v[1] <= w，则返回2，取或不取都可。
 */

/*
public static void main(String[] args)
{
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int w = sc.nextInt();
    int[] v = new int[n];
    int ans = 0;
    long totalWeight = 0L;

    for(int i = 0; i < n; i++)
    {
        v[i] = sc.nextInt();
        totalWeight += v[i];
    }

    if(totalWeight <= w)
    {
        System.out.println((long)Math.pow(2, n));
        return;
    }

    ans = loop(v, n - 1, w);
    System.out.println(ans);
}

    private static int loop(int[] v, int i, int w)
    {
        if(w <= 0)
        {
            return 0;
        }
        if(i == 0)
        {
            if(v[0] > w)
            {
                return 1;
            }
            else
            {
                return 2;
            }
        }

        return loop(v, i - 1, w) + loop(v, i - 1, w - v[i]);
    }*/
