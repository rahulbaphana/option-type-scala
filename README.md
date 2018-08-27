## Choice / Option type implementation exercise
#### Implement all of the preceding functions on Option. As you implement each function, try to think about what it means and in what situations you’d use it. We’ll explore when to use each of these functions next. Here are a few hints for solving this exercise:

##### It’s fine to use pattern matching, though you should be able to implement all the functions besides map and getOrElse without resorting to pattern matching.
##### 1.For map and flatMap, the type signature should be enough to determine the implementation.
##### 2.getOrElse returns the result inside the Some case of the Option, or if the Option is None, returns the given default value.
##### 3.orElse returns the first Option if it’s defined; otherwise, it returns the second Option.

##### **Note:** watch out for refactoring opportunities.