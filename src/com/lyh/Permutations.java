package com.lyh;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Permutations {
	/**
	 * ȫ���к���
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if(nums == null || nums.length == 0){
        	return result;
        }
        helper(nums, result, path);
        return result;
    }
	/**
	 * DFS�����������������ֹͣ��������·���ĳ��ȵ���ԭʼ���ݼ��ϵĳ���
	 * @param nums
	 * @param result
	 * @param path
	 */
	public void helper(int[] nums, List<List<Integer>> result, List<Integer> path){
		if(nums.length == path.size()){
			result.add(new ArrayList<>(path));
			return;
		}
		//���path�ĳ��Ȼ�������nums�ĳ��ȣ�˵�����л�û����ɣ�
		//Ҫ��������ʣ�µ�Ԫ�أ����뵽path�У���һ��Ԫ�ز��ܺ�����path�е�Ԫ���غ�
		boolean isVisited = false;
		for(int i = 0; i < nums.length; ++i){
			isVisited = find(nums[i], path);
			if(!isVisited){
				path.add(nums[i]);
				helper(nums, result, path);
				path.remove(path.size() - 1);
			}
		}
	}
	/**
	 * �жϵ�ǰԪ���Ƿ��Ѿ�������path��
	 * @param target
	 * @param path
	 * @return
	 */
	public boolean find(int target, List<Integer> path){
		Iterator<Integer> pathIt = path.iterator();
		boolean result = false;
		while(pathIt.hasNext()){
			Integer tmp = pathIt.next();
			if(tmp.intValue() == target){
				result = true;
				break;
			}
		}
		return result;
	}
}
