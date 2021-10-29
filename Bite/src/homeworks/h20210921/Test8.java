package homeworks.h20210921;

import java.util.HashMap;
import java.util.Map;

/*
    997. 找到小镇的法官
    https://leetcode-cn.com/problems/find-the-town-judge/*/

class Solution {
    public int findJudge(int n, int[][] trust) {
        /*
        1.给每个人创建两个变量，数组下标即对应的那个人编号。
        2.遍历trust ，相信别人的人在其一个变量里+1，被相信的人在其变量里+1
        3.trust 遍历结束后，第一个变量不是0的人都是相信别人的人，也就不是法官。
    第二个变量是 n-1 的人说明得到了其他所有人的信任。如果他还满足前一个条件，就说明他是法官。
         */
        int[] trusts = new int[n];
        int[] trusted = new int[n];
        for (int[] person : trust) {
            trusts[person[0] - 1]++;
            trusted[person[1] - 1]++;
        }
        for (int i = 0; i < n; i++) {
            if (trusts[i] == 0 && trusted[i] == n - 1) {
                return i + 1;
            }
        }
        return -1;
    }
}
