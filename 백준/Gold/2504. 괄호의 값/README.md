# [Gold V] 괄호의 값 - 2504 

[문제 링크](https://www.acmicpc.net/problem/2504) 

### 성능 요약

메모리: 14280 KB, 시간: 132 ms

### 분류

자료 구조, 구현, 스택

### 제출 일자

2024년 3월 28일 15:14:59

### 문제 설명

<p style="user-select: auto !important;">4개의 기호 ‘<code style="user-select: auto !important;">(</code>’, ‘<code style="user-select: auto !important;">)</code>’, ‘<code style="user-select: auto !important;">[</code>’, ‘<code style="user-select: auto !important;">]</code>’를 이용해서 만들어지는 괄호열 중에서 올바른 괄호열이란 다음과 같이 정의된다.</p>

<ol style="user-select: auto !important;">
	<li style="user-select: auto !important;">한 쌍의 괄호로만 이루어진 ‘<code style="user-select: auto !important;">()</code>’와 ‘<code style="user-select: auto !important;">[]</code>’는 올바른 괄호열이다. </li>
	<li style="user-select: auto !important;">만일 <code style="user-select: auto !important;">X</code>가 올바른 괄호열이면 ‘<code style="user-select: auto !important;">(X)</code>’이나 ‘<code style="user-select: auto !important;">[X]</code>’도 모두 올바른 괄호열이 된다. </li>
	<li style="user-select: auto !important;"><code style="user-select: auto !important;">X</code>와 <code style="user-select: auto !important;">Y</code> 모두 올바른 괄호열이라면 이들을 결합한 <code style="user-select: auto !important;">XY</code>도 올바른 괄호열이 된다.</li>
</ol>

<p style="user-select: auto !important;">예를 들어 ‘<code style="user-select: auto !important;">(()[[]])</code>’나 ‘<code style="user-select: auto !important;">(())[][]</code>’ 는 올바른 괄호열이지만 ‘<code style="user-select: auto !important;">([)]</code>’ 나 ‘<code style="user-select: auto !important;">(()()[]</code>’ 은 모두 올바른 괄호열이 아니다. 우리는 어떤 올바른 괄호열 <code style="user-select: auto !important;">X</code>에 대하여 그 괄호열의 값(괄호값)을 아래와 같이 정의하고 값(<code style="user-select: auto !important;">X</code>)로 표시한다. </p>

<ol style="user-select: auto !important;">
	<li style="user-select: auto !important;">‘<code style="user-select: auto !important;">()</code>’ 인 괄호열의 값은 2이다.</li>
	<li style="user-select: auto !important;">‘<code style="user-select: auto !important;">[]</code>’ 인 괄호열의 값은 3이다.</li>
	<li style="user-select: auto !important;">‘<code style="user-select: auto !important;">(X)</code>’ 의 괄호값은 2×값(<code style="user-select: auto !important;">X</code>) 으로 계산된다.</li>
	<li style="user-select: auto !important;">‘<code style="user-select: auto !important;">[X]</code>’ 의 괄호값은 3×값(<code style="user-select: auto !important;">X</code>) 으로 계산된다.</li>
	<li style="user-select: auto !important;">올바른 괄호열 <code style="user-select: auto !important;">X</code>와 <code style="user-select: auto !important;">Y</code>가 결합된 <code style="user-select: auto !important;">XY</code>의 괄호값은 값(<code style="user-select: auto !important;">XY</code>)= 값(<code style="user-select: auto !important;">X</code>)+값(<code style="user-select: auto !important;">Y</code>) 로 계산된다.</li>
</ol>

<p style="user-select: auto !important;">예를 들어 ‘<code style="user-select: auto !important;">(()[[]])([])</code>’ 의 괄호값을 구해보자. ‘<code style="user-select: auto !important;">()[[]]</code>’ 의 괄호값이 2 + 3×3=11 이므로 ‘<code style="user-select: auto !important;">(()[[]])</code>’의 괄호값은 2×11=22 이다. 그리고 ‘<code style="user-select: auto !important;">([])</code>’의 값은 2×3=6 이므로 전체 괄호열의 값은 22 + 6 = 28 이다.</p>

<p style="user-select: auto !important;">여러분이 풀어야 할 문제는 주어진 괄호열을 읽고 그 괄호값을 앞에서 정의한대로 계산하여 출력하는 것이다. </p>

### 입력 

 <p style="user-select: auto !important;">첫째 줄에 괄호열을 나타내는 문자열(스트링)이 주어진다. 단 그 길이는 1 이상, 30 이하이다.</p>

### 출력 

 <p style="user-select: auto !important;">첫째 줄에 그 괄호열의 값을 나타내는 정수를 출력한다. 만일 입력이 올바르지 못한 괄호열이면 반드시 0을 출력해야 한다. </p>

