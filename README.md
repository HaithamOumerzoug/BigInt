<h1 align="center">BigInt</h1>
<h3 align="center">Big integer class for Java</h3>

---

:construction: Work in progress :construction:

#### Contents

* [Infos](#infos)
* [Usage](#usage)
* [Features](#features)
* [Contributing](#Contributing)
* [License](#License)


## Infos

BigInt class allows us to handle large integers (integers with a size larger than the Long Long int) and we can perform arithmetic operations like addition, subtraction, multiplication,...

## Usage
 
1. Create new java project. 
1. Installation is very simple, just download and copy the [BigInt class](src/BigInt/BigInt.java) to your project.  
Then, you can simply run the project as java application.

## Features

#### Constructor: `BigInt()`, `BigInt(StringBuffer)`,
  constructor of `BigInt`class .
  It is possible to instantiate a BigInt in this ways:  
  ```java
  StringBuffer s1=new StringBuffer("2765456545667765454335566449976755");
  BigInt a =new BigInt(s1);
  BigInt b=new BigInt();
  BigInt c; 
  ```
  In this class defines an attribute of type StringBuffer which must store us the big integer.
### Methods:
  * #### `check(char)`
    static boolean function use to check if values are only integer.
    
  * #### `.Add(BigInt)`
    addition between two `BigInt`.
    ```java
    Big1 = Big1.Add(Big2);
    ```

  * #### `.Sub(BigInt)`
    subtraction between two `BigInt`.
    ```java
    Big1 = Big1.Sub(Big2);
    ```

  * #### `.Mult(BigInt)`
    multiplication between two `BigInt`.
    ```java
    Big1 = Big1.Mult(Big2);
    ```

  * #### `.Divs(BigInt)`
    division between two `BigInt`.
    ```java
    Big1 = Big1.Divs(Big2);
    ```

  * #### `.Mod(BigInt)`
    modulo of a `BigInt` over another `BigInt` passed as parameters.
    ```java
    Big1 = Big1.Mod(Big2);
    ```

  * #### `.AddMod(BigInt , BigInt)`
    addition modulo between two `BigInt`.
    ```java
    Big1 = Big1.AddMod(Big2);
    ```

  * #### `.SubMod(BigInt , BigInt)`
    subtraction modulo between two `BigInt`.
    ```java
    Big1 = Big1.SubMod(Big2);
    ```

  * #### `.MultMod(BigInt , BigInt)`
    multiplication modulo between two `BigInt`.
    ```java
    Big1 = Big1.MultMod(Big2);
    ```

  * #### `.DivsMod(BigInt , BigInt)`
    division modulo between two `BigInt`.
    ```java
    Big1 = Big1.DivsMod(Big2);
    ```
    
  * #### `.inf(BigInt)`
    boolean function use to test if the current object is less than the object passed as a parameter.
    ```java
    Big1 = Big1.inf(Big2);
    ``` 
## Contributing
  Contributions are welcome, this repository, modify it, open a pull  request or issue. You can really use it whatever you want.

## License
This project is licensed under the terms of the [MIT license](LICENSE)
