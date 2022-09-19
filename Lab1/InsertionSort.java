public class InsertionSort implements SortStrategy {

	@Override
	public long[] sort(long[] numbers) {
		// TODO Auto-generated method stub
		for (int i=1; i < numbers.length; i++)
		{
			long index = numbers[i]; int j = i;
			while (j > 0 && numbers[j-1] > index)
			{
				numbers[j] = numbers[j-1];
				j--;
			}
			numbers[j] = index;
		}
		return numbers;
	}

	@Override
	public long getSortTime() {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		return totalTime;
	}

	@Override
	public String strategyName() {
		// TODO Auto-generated method stub
		
		return "Insertion Sort";
	}
}
