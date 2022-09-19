public class BubbleSort implements SortStrategy {

	@Override
	public long[] sort(long[] numbers) {
		// TODO Auto-generated method stub
		for (int i = (numbers.length - 1); i >= 0; i--)
		{
			for (int j = 1; j <= i; j++)
			{
				if (numbers[j-1] > numbers[j])
				{
					long temp = numbers[j-1];
					numbers[j-1] = numbers[j];
					numbers[j] = temp;
				}
			}
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
		
		return "Bubble Sort";
	}
}