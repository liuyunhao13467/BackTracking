package com.lyh;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
	public List<List<Integer>> combine(int n, int k) {
        if(k == 0 || n == 0){
        	return result;
        }
        dfs(1, 0, n, k);
        return result;
    }
	public void dfs(int start, int listSize, int n, int k){
		if(listSize == k){
			result.add(new ArrayList<>(list));//����Ҫע�⣡��������ֻ��list���룬��Ϊ��ֻ�Ǹ����ã��ڵݹ������£�ÿһ�εݹ鶼�Ὺ���µĿռ䣬���ö�����
			return;
		}
		for(int i = start; i <= n; ++i){
			list.add(i);
			dfs(++start, listSize+1, n, k);
			list.remove(list.size()-1);//����Ҫע�⣡����remove()�������÷������������int����Ĭ��ɾ��index��Ӧ��Ԫ�أ�������ֵΪ������Ԫ��
		}
	}
}
