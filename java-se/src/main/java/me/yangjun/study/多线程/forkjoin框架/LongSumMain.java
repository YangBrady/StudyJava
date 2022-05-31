package me.yangjun.study.多线程.forkjoin框架;

import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.utils.DataUtils;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @author mooejun
 * @since 2022/5/31 15:19
 */
@Slf4j
public class LongSumMain {
	// 获取逻辑处理器数量
	static final int N_CPU = Runtime.getRuntime().availableProcessors();
	/**
	 * for time conversion
	 */
	static final long NPS = (1000L * 1000 * 1000);
	static final boolean reportSteals = true;
	static long calcSum;

	public static void main(String[] args) throws Exception {
		int[] array = DataUtils.genRandomIntArr(2000000);
		log.debug("cpu-num:" + N_CPU);
		// 单线程下计算数组数据总和
		long start1 = System.currentTimeMillis();
		calcSum = seqSum(array);
		log.debug("single thread sum=" + calcSum);
		log.debug("single thread cost:->" + (System.currentTimeMillis() - start1));

		long start2 = System.currentTimeMillis();
		//采用fork/join方式将数组求和任务进行拆分执行，最后合并结果
		LongSum ls = new LongSum(array, 0, array.length);
		ForkJoinPool fjp = new ForkJoinPool(N_CPU); //使用的线程数
		ForkJoinTask<Long> task = fjp.submit(ls);

		log.debug("fork join sum=" + task.get());
		log.debug("fork join cost:->" + (System.currentTimeMillis() - start2));
		if (task.isCompletedAbnormally()) {
			log.error("异常：", task.getException());
		}
		fjp.shutdown();
	}

	static long seqSum(int[] array) {
		long sum = 0;
		for (int j : array) {
			sum += j;
		}
		return sum;
	}
}
