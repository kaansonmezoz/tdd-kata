This Kata is taken from [Roy Osherove](https://osherove.com/tdd-kata-1).

#### Things To Consider
- Don't forget to go through step by step.
- Always start with the simplest test case.
- Red -> Green -> Refactor
- Don't forget to test after refactor.
- Always code minimum to pass & fail tests.


#### Scenario
-  Create a simple class class StringCalculator with a method ```public int add(string numbers)```

1) Given empty string as parameter When add() is called Then it should return 0
2) Given one number  When add() is called Then it should return that number.
   i.e Given "1" When add() is called Then it should return 1.
3) Given "1,2" When add() is called Then it should return 3
4) Given "1,2,3" When add() is called Then it should return 6
5) Given unlimited amount of numbers When add() is called Then it should return sum of them
6) Given "1\n2,3" When add() is called Then it should return 6 and \n is seen as a delimiter
7) Given //[delimiter]\n[numbers…] When add() is called Then it should split via given delimiter in the beginning and return the sum
   “//;\n1;2” == 3  delimiter is ';'
8) Given negative numbers When add() is called Then it should throw an exception with message: “negatives not allowed [negative-number]"
9) Given multiple negative numbers When add() is called Then it should throw an exception and show all the values in the message
10) Given add() is called for multiple times, When getCalledCount() is invoked Then it should return how many times add() has been called
11) Given Numbers bigger than 1000 should be ignored.
12) Delimiters can be of any length with the following format ```“//[delimiter]\n”``` ```“//[***]\n1***2***3” = 6```
13) Allow multiple delimeters like this: ```“//[delim1][delim2]\n”```  ```“//[*][%]\n1*2%3” == 6```
14) Make sure you can also handle multiple delimiters with length longer than one char ```“//[**][%%]\n1**2%%3” == 6```

