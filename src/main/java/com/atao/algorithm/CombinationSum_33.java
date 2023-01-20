package com.atao.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description (LeetCode- 39) 组合总和
 * @Author atao
 */
public class CombinationSum_33 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        /*数组事先排序，方便后面剪枝*/
        Arrays.sort(candidates);
        backTrack(candidates, 0, candidates.length, target, new ArrayList<Integer>(), res);
        return res;
    }

    private void backTrack(int[] candidates, int begin, int len, int target, List<Integer> path, List<List<Integer>> res) {
        /*target被减为0，满足条件，加入总结果集
         * 小于0的部分会被剪枝*/
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        /*begin用来避免重复计算，比如减3分支不再计算减2*/
        for (int i = begin; i < len; i++) {
            /*数组已排序，进行剪枝*/
            if (target - candidates[i] < 0) {
                break;
            }
            path.add(candidates[i]);
            backTrack(candidates, i, len, target - candidates[i], path, res);
            path.remove(path.size() - 1);
        }
    }

}
