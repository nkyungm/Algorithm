# [level 2] 주식가격 - 42584 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42584) 

### 성능 요약

메모리: 79 MB, 시간: 32.42 ms

### 구분

코딩테스트 연습 > 스택／큐

### 채점결과

정확성: 66.7<br/>효율성: 33.3<br/>합계: 100.0 / 100.0

### 제출 일자

2026년 01월 25일 23:26:04

### 문제 설명

<p style="user-select: auto !important;">초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.</p>

<h5 style="user-select: auto !important;">제한사항</h5>

<ul style="user-select: auto !important;">
<li style="user-select: auto !important;">prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.</li>
<li style="user-select: auto !important;">prices의 길이는 2 이상 100,000 이하입니다.</li>
</ul>

<h5 style="user-select: auto !important;">입출력 예</h5>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">prices</th>
<th style="user-select: auto !important;">return</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">[1, 2, 3, 2, 3]</td>
<td style="user-select: auto !important;">[4, 3, 1, 1, 0]</td>
</tr>
</tbody>
      </table>
<h5 style="user-select: auto !important;">입출력 예 설명</h5>

<ul style="user-select: auto !important;">
<li style="user-select: auto !important;">1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.</li>
<li style="user-select: auto !important;">2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.</li>
<li style="user-select: auto !important;">3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.</li>
<li style="user-select: auto !important;">4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.</li>
<li style="user-select: auto !important;">5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.</li>
</ul>

<p style="user-select: auto !important;">※ 공지 - 2019년 2월 28일 지문이 리뉴얼되었습니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges