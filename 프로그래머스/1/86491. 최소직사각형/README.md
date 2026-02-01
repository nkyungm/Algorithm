# [level 1] 최소직사각형 - 86491 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/86491) 

### 성능 요약

메모리: 97.9 MB, 시간: 1.52 ms

### 구분

코딩테스트 연습 > 완전탐색

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2026년 02월 01일 23:50:20

### 문제 설명

<p style="user-select: auto !important;">명함 지갑을 만드는 회사에서 지갑의 크기를 정하려고 합니다. 다양한 모양과 크기의 명함들을 모두 수납할 수 있으면서, 작아서 들고 다니기 편한 지갑을 만들어야 합니다. 이러한 요건을 만족하는 지갑을 만들기 위해 디자인팀은 모든 명함의 가로 길이와 세로 길이를 조사했습니다.</p>

<p style="user-select: auto !important;">아래 표는 4가지 명함의 가로 길이와 세로 길이를 나타냅니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">명함 번호</th>
<th style="user-select: auto !important;">가로 길이</th>
<th style="user-select: auto !important;">세로 길이</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">60</td>
<td style="user-select: auto !important;">50</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">30</td>
<td style="user-select: auto !important;">70</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">3</td>
<td style="user-select: auto !important;">60</td>
<td style="user-select: auto !important;">30</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">4</td>
<td style="user-select: auto !important;">80</td>
<td style="user-select: auto !important;">40</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;">가장 긴 가로 길이와 세로 길이가 각각 80, 70이기 때문에 80(가로) x 70(세로) 크기의 지갑을 만들면 모든 명함들을 수납할 수 있습니다. 하지만 2번 명함을 가로로 눕혀 수납한다면 80(가로) x 50(세로) 크기의 지갑으로 모든 명함들을 수납할 수 있습니다. 이때의 지갑 크기는 4000(=80 x 50)입니다.</p>

<p style="user-select: auto !important;">모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes가 매개변수로 주어집니다. 모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때, 지갑의 크기를 return 하도록 solution 함수를 완성해주세요.</p>

<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">제한사항</h5>

<ul style="user-select: auto !important;">
<li style="user-select: auto !important;">sizes의 길이는 1 이상 10,000 이하입니다.

<ul style="user-select: auto !important;">
<li style="user-select: auto !important;">sizes의 원소는 [w, h] 형식입니다.</li>
<li style="user-select: auto !important;">w는 명함의 가로 길이를 나타냅니다.</li>
<li style="user-select: auto !important;">h는 명함의 세로 길이를 나타냅니다.</li>
<li style="user-select: auto !important;">w와 h는 1 이상 1,000 이하인 자연수입니다.</li>
</ul></li>
</ul>

<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">입출력 예</h5>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">sizes</th>
<th style="user-select: auto !important;">result</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">[[60, 50], [30, 70], [60, 30], [80, 40]]</td>
<td style="user-select: auto !important;">4000</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">[[10, 7], [12, 3], [8, 15], [14, 7], [5, 15]]</td>
<td style="user-select: auto !important;">120</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">[[14, 4], [19, 6], [6, 16], [18, 7], [7, 11]]</td>
<td style="user-select: auto !important;">133</td>
</tr>
</tbody>
      </table>
<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">입출력 예 설명</h5>

<p style="user-select: auto !important;">입출력 예 #1<br style="user-select: auto !important;">
문제 예시와 같습니다.</p>

<p style="user-select: auto !important;">입출력 예 #2<br style="user-select: auto !important;">
명함들을 적절히 회전시켜 겹쳤을 때, 3번째 명함(가로: 8, 세로: 15)이 다른 모든 명함보다 크기가 큽니다. 따라서 지갑의 크기는 3번째 명함의 크기와 같으며, 120(=8 x 15)을 return 합니다.</p>

<p style="user-select: auto !important;">입출력 예 #3<br style="user-select: auto !important;">
명함들을 적절히 회전시켜 겹쳤을 때, 모든 명함을 포함하는 가장 작은 지갑의 크기는 133(=19 x 7)입니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges