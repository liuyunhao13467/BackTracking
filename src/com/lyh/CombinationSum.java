package com.lyh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	List<List<Integer>> result;  
    List<Integer> path;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	result = new ArrayList<>();
    	path = new ArrayList<>();
    	Arrays.sort(candidates);
    	helper(candidates, 0, 0, target);
		return result;
    }
    
    void helper(int[] nums, int pos, int base, int target){
    	//·���͵���Ŀ��ֵ
    	if(base == target){
    		result.add(new ArrayList<>(path));
    		return;
    	}
    	//�����ǰ·���ʹ���Ŀ��ֵ��˵���������һ����֮ǰ·���ͻ���С��Ŀ��ֵ�ģ�
    	//��˸�·��������Ҫ����ǰ����һ���㣬�˵������ڶ���·���ڵ���
    	if(base > target){
    		return;
    	}
    	//�����ǰ·����С��Ŀ��ֵ��˵����ǰ·����������ǰ��һ�������г���
    	for(int i = pos; i < nums.length; ++i){
    		path.add(nums[i]);
    		helper(nums,i,base+nums[i],target);
    		path.remove(path.size()-1);
    	}
    }
}
