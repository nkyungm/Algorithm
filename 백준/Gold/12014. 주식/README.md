# [Gold II] 주식 - 12014 

[문제 링크](https://www.acmicpc.net/problem/12014) 

### 성능 요약

메모리: 40380 KB, 시간: 452 ms

### 분류

이분 탐색, 가장 긴 증가하는 부분 수열: O(n log n)

### 제출 일자

2024년 4월 15일 22:40:51

### 문제 설명

<p style="user-select: auto !important;">어느 날 당신은 출근길에, 지하철역 쓰레기통에서 놀라운 문서를 얻게 되었다. 이 문서는 미래의 어떤 회사의 주식 가격의 변동이 담겨 있었다. 설마 하는 마음으로 이 회사의 주식 가격의 변동을 본 결과, 문서에 담긴 내용이 사실이라는 것을 알게 되었다. 아마도 미래에서 타임머신을 타고 온 후손이 선조를 돕기 위해서 보낸 것이 아닐까 하는 마음이 들었다.</p>

<p style="user-select: auto !important;">앞으로 N 일간 주식 가격이 N 개의 숫자로 주어져 있다. 당신은 지금까지 주식이라는 것을 거래해본 적이 없기 대문에, 증권회사에 가서 거래를 시작하기로 했다. 미래를 알면서 주식을 거래한다면 다른 사람들이 의심할지도 모른다는 생각이 들어서, 총 K 번 주식을 사기로 했다. 하루에는 주식을 한 번만 살수 있기 때문에, 주식을 사는 날은 총 K 일이다.</p>

<p style="user-select: auto !important;">의심을 더 줄이기 위해서, 주식을 살 때마다 맨 처음을 제외하고는 바로 직전에 주식을 샀을 때보다 가격이 올라갔을 때만 사기로 했다. 예를 들어, 10일간 주가의 변동이 다음 표와 같다고 하자.</p>

<table class="table table-bordered" style="user-select: auto !important;">
	<thead style="user-select: auto !important;">
		<tr style="user-select: auto !important;">
			<th style="user-select: auto !important;">날짜</th>
			<th style="user-select: auto !important;">1</th>
			<th style="user-select: auto !important;">2</th>
			<th style="user-select: auto !important;">3</th>
			<th style="user-select: auto !important;">4</th>
			<th style="user-select: auto !important;">5</th>
			<th style="user-select: auto !important;">6</th>
			<th style="user-select: auto !important;">7</th>
			<th style="user-select: auto !important;">8</th>
			<th style="user-select: auto !important;">9</th>
			<th style="user-select: auto !important;">10</th>
		</tr>
	</thead>
	<tbody style="user-select: auto !important;">
		<tr style="user-select: auto !important;">
			<th style="user-select: auto !important;">주가</th>
			<td style="user-select: auto !important;">100</td>
			<td style="user-select: auto !important;">50</td>
			<td style="user-select: auto !important;">70</td>
			<td style="user-select: auto !important;">90</td>
			<td style="user-select: auto !important;">75</td>
			<td style="user-select: auto !important;">87</td>
			<td style="user-select: auto !important;">105</td>
			<td style="user-select: auto !important;">78</td>
			<td style="user-select: auto !important;">110</td>
			<td style="user-select: auto !important;">60</td>
		</tr>
	</tbody>
</table>

<p style="user-select: auto !important;">K=3이라면, 2일, 3일, 4일에 주식을 사면 그날의 주가는 50, 70, 90이기 대문에 주어진 조건을 만족한다. 만약 K=6이라면, 2일, 3일, 5일, 6일, 7일, 9일에 주식을 사면 주가가 50, 70, 75, 87, 105, 110이기 때문에 주어진 조건을 만족한다. K=10이라면 조건을 만족할 수 없다.</p>

<p style="user-select: auto !important;">N과 K, 주가가 주어졌을때 주어진 조건을 만족하게 주식을 구입할 수 있는지 여부를 알려주는 프로그램을 작성하시오.</p>

### 입력 

 <p style="user-select: auto !important;">입력 파일에는 여러 테스트 케이스가 포함될 수 있다. 파일의 첫째 줄에 케이스의 개수 T(2 ≤ T ≤ 100)가 주어지고, 이후 차례로 T 개 테스트 케이스가 주어진다. 각 테스트 케이스의 첫 줄에 두 정수 N과 K이 주어진다. N은 앞으로 주가를 알 수 있는 날 수이며, (1 ≤ N ≤ 10,000) K는 거래의 회수이다. (1 ≤ K ≤ 10,000) 다음 줄에는 앞으로 N 날의 주가가 사이에 공백을 두고 주어진다. 주가는 1부터 10,000 사이의 정수이다.</p>

### 출력 

 <p style="user-select: auto !important;">각 테스트 케이스에 대해서 출력은 한 줄로 구성된다. T 번째 테스트 케이스에 대해서는 첫째 줄에는 "Case #T"를 출력한다. 두 번째 줄에는 주어진 조건을 만족하게 주식을 살 수 있으면 1, 아니면 0을 출력한다.</p>

