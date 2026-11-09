# Report
## Structure Comparison

**Insert Time (ns)**
| Loops | `TreeSet` | `ArrayList` | `LinkedList` |
| --- | --- | --- | --- |
| 100 | 5293194 | 2485104 | 1378551 |
| 1000 | 1899617 | 9384033 | 13475324 |
| 10000 |6628634 | 427697050 | 812749465 |

The `TreeSet` is outperformed on inserts at smaller scales by the other two, but becomes the better choice by a large margin as the data size increases. 

In search times, `TreeSet` is always `O(log n)`, `ArrayList` can also be if sorted, and is `O(n)` otherwise, and `LinkedList` is always `O(n)`. 

Since `TreeSet`'s insertion times scale better and has the same search complexity as `ArrayList`, it is the best option out of the three.