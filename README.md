# Data Structures Implementation in Java

A comprehensive implementation of fundamental data structures built from scratch in Java, demonstrating best practices and clean code principles.

## 📚 Implemented Data Structures

### Stack
- **ArrayStack**: Fixed-size stack using array
- **LinkedListStack**: Dynamic stack using linked list

### Queue
- **ArrayQueue**: Circular array-based queue (fixed size)
- **LinkedListQueue**: Dynamic queue using linked list

## ✨ Features

- ✅ Generic types support (`<T>`)
- ✅ Custom exception handling
- ✅ Comprehensive documentation (Javadoc)
- ✅ O(1) time complexity for all core operations
- ✅ Memory-efficient implementations
- ✅ Full unit test coverage

## 🚀 Quick Start

### Stack Example

```java
import stack.LinkedListStack;

public class Main {
    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        System.out.println(stack.pop());  // 30
        System.out.println(stack.peek()); // 20
    }
}
```

### Queue Example

```java
import queue.ArrayQueue;

public class Main {
    public static void main(String[] args) {
        ArrayQueue<String> queue = new ArrayQueue<>(5);
        
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");
        
        System.out.println(queue.dequeue()); // First
        System.out.println(queue.peek());    // Second
    }
}
```

## 📊 Complexity Analysis

### Stack Operations

| Operation | ArrayStack | LinkedListStack |
|-----------|------------|-----------------|
| push()    | O(1)*      | O(1)           |
| pop()     | O(1)       | O(1)           |
| peek()    | O(1)       | O(1)           |
| isEmpty() | O(1)       | O(1)           |

*Amortized O(1) for ArrayStack (may need resize)

### Queue Operations

| Operation | ArrayQueue | LinkedListQueue |
|-----------|------------|-----------------|
| enqueue() | O(1)       | O(1)            |
| dequeue() | O(1)       | O(1)            |
| peek()    | O(1)       | O(1)            |
| isEmpty() | O(1)       | O(1)            |

## 🏗️ Project Structure

```
src/
├── exceptions/          # Custom exceptions
├── stack/              # Stack implementations
├── queue/              # Queue implementations
└── common/             # Shared utilities
```

## 🧪 Testing

Run tests using your IDE or command line:

```bash
# Compile
javac -d bin src/**/*.java

# Run tests
java -cp bin test.stack.ArrayStackTest
```

## 📖 Documentation

Each class includes comprehensive Javadoc comments:
- Method descriptions
- Parameter explanations
- Return value documentation
- Exception specifications
- Time/Space complexity notes

## 🎯 Design Principles

- **SOLID principles** applied
- **DRY (Don't Repeat Yourself)** code
- **KISS (Keep It Simple, Stupid)** approach
- **Clean Code** practices
- Industry-standard naming conventions

## 🔧 Custom Exceptions

- `StackOverflowException`: Thrown when pushing to a full array-based stack
- `StackUnderflowException`: Thrown when popping from an empty stack
- `QueueOverflowException`: Thrown when enqueueing to a full array-based queue
- `QueueUnderflowException`: Thrown when dequeueing from an empty queue

## 📝 Key Implementation Details

### ArrayStack
- Uses dynamic array with resize capability
- Supports generic types
- Memory-efficient with null cleanup for GC

### LinkedListStack
- No capacity limit (dynamic size)
- Memory overhead for node pointers
- No need for resize operations

### ArrayQueue (Circular)
- Efficient O(1) operations using modulo arithmetic
- Fixed capacity (prevents overflow)
- Circular buffer implementation

### LinkedListQueue
- Maintains both front and rear pointers
- Truly dynamic size
- No wasted space

## 🤝 Contributing

This is a learning project, but feedback and suggestions are welcome!

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Open a Pull Request

## 📜 License

This project is open source and available under the [MIT License](LICENSE).

## 👨‍💻 Author

**[Your Name]**
- GitHub: [@yourusername](https://github.com/yourusername)
- LinkedIn: [Your Profile](https://linkedin.com/in/yourprofile)

## 🎓 Learning Resources

This implementation was created as part of learning Data Structures and Algorithms.

### References:
- Introduction to Algorithms (CLRS)
- Data Structures and Algorithm Analysis in Java (Mark Allen Weiss)
- Effective Java (Joshua Bloch)

## 🐛 Known Issues

None currently. Please report any bugs in the Issues section.

## 🚧 Future Enhancements

- [ ] Add more data structures (Trees, Graphs, Heaps)
- [ ] Implement iterators
- [ ] Add performance benchmarks
- [ ] Create visualization tools
- [ ] Add more comprehensive test suites

---

⭐ If you found this helpful, please star the repository!
