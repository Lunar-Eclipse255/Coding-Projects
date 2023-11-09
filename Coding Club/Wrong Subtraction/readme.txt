Little girl Tanya is learning how to decrease a number by one, but she does it wrong with a number consisting of two or more digits. Tanya subtracts one from a number by the following algorithm:

    if the last digit of the number is non-zero, she decreases the number by one;
    if the last digit of the number is zero, she divides the number by 10 (i.e. removes the last digit). 

You are given an integer number 𝑛
. Tanya will subtract one from it 𝑘 times. Your task is to print the result after all 𝑘

subtractions.

It is guaranteed that the result will be positive integer number.
Input

The first line of the input contains two integer numbers 𝑛
and 𝑘 (2≤𝑛≤109, 1≤𝑘≤50

) — the number from which Tanya will subtract and the number of subtractions correspondingly.
Output

Print one integer number — the result of the decreasing 𝑛
by one 𝑘

times.

It is guaranteed that the result will be positive integer number.

Examples
Input:
512 4

Output:
50

Input:
1000000000 9

Output:
1