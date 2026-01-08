# [level 1] K번째수 - 42748 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42748?language=java) 

### 성능 요약

메모리: 89.5 MB, 시간: 0.46 ms

### 구분

코딩테스트 연습 > 정렬

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2026년 01월 08일 23:28:09

### 문제 설명

<p style="user-select: auto !important;">배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.</p>

<p style="user-select: auto !important;">예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면</p>

<ol style="user-select: auto !important;">
<li style="user-select: auto !important;">array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.</li>
<li style="user-select: auto !important;">1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.</li>
<li style="user-select: auto !important;">2에서 나온 배열의 3번째 숫자는 5입니다.</li>
</ol>

<p style="user-select: auto !important;">배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.</p>

<h5 style="user-select: auto !important;">제한사항</h5>

<ul style="user-select: auto !important;">
<li style="user-select: auto !important;">array의 길이는 1 이상 100 이하입니다.</li>
<li style="user-select: auto !important;">array의 각 원소는 1 이상 100 이하입니다.</li>
<li style="user-select: auto !important;">commands의 길이는 1 이상 50 이하입니다.</li>
<li style="user-select: auto !important;">commands의 각 원소는 길이가 3입니다.</li>
</ul>

<h5 style="user-select: auto !important;">입출력 예</h5>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">array</th>
<th style="user-select: auto !important;">commands</th>
<th style="user-select: auto !important;">return</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">[1, 5, 2, 6, 3, 7, 4]</td>
<td style="user-select: auto !important;">[[2, 5, 3], [4, 4, 1], [1, 7, 3]]</td>
<td style="user-select: auto !important;">[5, 6, 3]</td>
</tr>
</tbody>
      </table>
<h5 style="user-select: auto !important;">입출력 예 설명</h5>

<p style="user-select: auto !important;">[1, 5, 2, 6, 3, 7, 4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5입니다.<br style="user-select: auto !important;">
[1, 5, 2, 6, 3, 7, 4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫 번째 숫자는 6입니다.<br style="user-select: auto !important;">
[1, 5, 2, 6, 3, 7, 4]를 1번째부터 7번째까지 자릅니다. [1, 2, 3, 4, 5, 6, 7]의 세 번째 숫자는 3입니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges