# Report: Homework 3

## Algorithmic Complexity
| Operation | Complexity | |
| --- | --- | --- |
| enqueue()/dequeue() | O | Takes the same amount of operations every time |
| EmergencyWaitingRoom.nextPatient() | O | Checks at most 4 lanes; not proportional to data size |
| Linked Stack push()/pop()/peek() | O | Takes the same amount of operations every time |
| Queue recursive toString() | O(n) | Linearly processes every single node |

## Queue Comparison
| Metric | Linked Queue | Circular Array Queue |
| --- | --- | --- |
| enqueue | O | O |
| dequeue | O | O |
| toString() | O(n) | O(n) |
| instance capacity | theoretically infinite | bounded by array size |

The operations performed by both have the same complexity.
The array-based queue could have faster recall (especially in the case of toString()),
being a contiguous memory block, while the linked-node version has to jump to
nodes which could be spaced out across the program's entire address space.
However, this time difference is likely negligible; in addition, the linked-node version
is more intuitive and easier to understand.