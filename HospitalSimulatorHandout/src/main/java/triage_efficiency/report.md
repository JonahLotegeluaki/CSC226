# Search Algorithms
*Homework 2*

## Comparison
| Data Size | Linear Search (ns) | Binary Search (ns) | Exponential Search (ns) |
| -----------| --------------------| --------------------| -------------------------|
| 100       | 27361              | 10470              | 6372                    |
| 1000      | 36158              | 8146               | 9478                    |
| 10000     | 253213             | 8156               | 8275                    |
| 100000    | 6157070            | 7945               | 23263                   |

As the data size grows, the performance of each algorithm chanegs as follows:
- Linear: the time of execution grows rapidly at the same rate as the data size.
- Binary: its execution time grows, but at a much slower rate than linear, and the rate of growth also decreases with constant data size growth.
- Exponential: its execution time grows in a similar manner to binary search, but its performance is more erratic, likely due to its use of two different O(log n) steps.

The algorithm that should be used is binary search. It is much faster than linear search, and is usually the same or more performant on time than exponential search. This is because binary search is a single O(log n) phase, while exponential search has two different O(log n) steps, which causes it to take significantly more time than binary search on occasions.

Measuring time in ns is not at all the best way to examine algorithmic efficiency. CPU clock rate, process scheduling, and many other confounding factors impact the time it takes to run an algorithm. An accurate measure would be to analyze how many cycles it takes to execute an algorithm, although the compiler's ability is still a factor. 

The results follow what big O theory predicts. O(log n) algorithms significantly outperform O(n) algorithms.