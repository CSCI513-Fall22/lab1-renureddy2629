public class SelectionSort implements SortStrategy {

	@Override
	public long[] sort(long[] numbers) {
		// TODO Auto-generated method stub
		for (int i = 0; i < numbers.length-1 ; i++)
		{
			int min = i;
			for (int j = i+1; j < numbers.length; j++)
				if (numbers[j] < numbers[min]) min = j;
			long temp = numbers[i];
			numbers[i] = numbers[min];
			numbers[min] = temp;
		}
		return numbers;
	}

	@Override
	public long getSortTime() {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		System.out.println(startTime);
		long endTime = System.currentTimeMillis();
		System.out.println(endTime);
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
		return totalTime;
	}

	@Override
	public String strategyName() {
		// TODO Auto-generated method stub
		return "Selection Sort";
	}
	
}