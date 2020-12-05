<h1 align="center">BigInt</h1>
<h3 align="center">Arbitrary-sized integer class for C++</h3>

---

:construction: Work in progress :construction:

#### Contents

* [Infos](#infos)
* [Usage](#usage)
* [Features](#features)

## Infos

BigInt class allows us to handle large integers (integers with a size larger than the Long Long int) and we can perform arithmetic operations like addition, subtraction, multiplication,...

## Usage
 
1. Create new java project. 
1. Installation is very simple, just download and copy the [BigInt class](src/BigInt/BigInt.java) to your project.  
Then, you can simply run the project as java application.

## Features

### Functions

#### Constructor: `BigInt()`, `BigInt(StringBuffer)`,
  constructor of `BigInt`class .
It is possible to instantiate a BigInt in this ways:  
```java
StringBuffer s2=new StringBuffer("2765456545667765454335566449976755");
BigInt a =new BigInt(s1);
BigInt b=new BigInt();
BigInt c; 
```
