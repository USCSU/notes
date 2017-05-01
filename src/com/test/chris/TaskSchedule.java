package com.test.chris;
import java.util.HashMap;

/*
 每种task都有冷却时间，比如task1执行完后，要经过interval时间后，才能再次执行，求总共所需时间。
 Calculate how much time needed to finish all tasks with cool down. 
 @param tasks All tasks represented by integer
 @param cooldown time
 @return 
 */
public class TaskSchedule {
	public static int totalTimeWithTasks(int[] tasks,int cooldown){
		//error checking
		if(tasks == null || tasks.length ==0) return 0;
		HashMap<Integer,Integer> map = new HashMap<>(); // key: task number; value: earliest time can be started for that task
		int time = 0;
		for(int i =0;i<tasks.length;i++){
			int task = tasks[i];
			if(!map.containsKey(task)){
				map.put(task, time+cooldown+1); // this task hasn't been run before
			}else{
				if(time >= map.get(task)) map.put(task,time+cooldown+1);
				else i--;
			}
			time++;
		}
		return time;
	}
	
	public static int totalTimeWithTasksReformat(int[] tasks,int cooldown){
		if(tasks == null || tasks.length ==0) return 0;
		HashMap<Integer,Integer> map = new HashMap<>(); // key: task number; value: earliest time can be started for that task
		int time = 0;
		for(int i =0;i<tasks.length;i++){
			int task = tasks[i];
			if(map.containsKey(task)&& time < map.get(task)) i--;
			else map.put(task, time+cooldown+1);
			time ++;
		}
		return time;
	}
	public static void main(String[] args){
		int[] tasks = new int[]{1, 1, 2, 1};
		int cooldown = 2;
		System.out.println(TaskSchedule.totalTimeWithTasks(tasks, cooldown));
		System.out.println(TaskSchedule.totalTimeWithTasksReformat(tasks, cooldown));
	}

}
