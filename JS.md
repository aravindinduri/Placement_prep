# 📘 Popular Interview JS Questions
---

## 📌 1. Data Types in JavaScript

**Use Case:** Understanding the fundamental data types is crucial for every JavaScript developer.

JavaScript has the following data types: 
*   **Primitive data types:** 
    *   **Number:** For integer and floating-point numbers.
    *   **String:** For characters and alphanumeric values.
    *   **Boolean:** For `true` and `false` values.
    *   **Null:** For empty or unknown values.
    *   **Undefined:** For a variable that is declared but not yet assigned a value.
    *   **Symbol:** For unique identifiers for objects.
*   **Non-primitive data type:** 
    *   **Object:** For collections of data.

> 🔍 **Trick:** Remember that the value of `typeof null` is `"object"`, which is a long-standing bug in JavaScript.

---

## 📌 2. `var`, `let`, and `const`

**Use Case:** To declare variables with different scopes and reassignment capabilities.

*   `var`: Function-scoped, can be redeclared and reassigned.
*   `let`: Block-scoped, cannot be redeclared but can be reassigned.
*   `const`: Block-scoped, cannot be redeclared or reassigned.

```javascript
var a = 1;
let b = 2;
const c = 3;

a = 11; // Works
b = 22; // Works
// c = 33; // TypeError: Assignment to constant variable.
```

> 💡 **Trick:** Use `const` by default, `let` when you need to reassign, and avoid `var` in modern JavaScript.

---

## 📌 3. `==` vs `===`

**Use Case:** To compare two values with or without type coercion.

*   `==` (Loose Equality): Compares two values for equality after performing type conversion if necessary.
*   `===` (Strict Equality): Compares two values for equality without any type conversion.

```javascript
console.log(5 == "5"); // true
console.log(5 === "5"); // false
```

> 🎯 **Trick:** Always use `===` for comparisons to avoid unexpected bugs from type coercion.

---

## 📌 4. Hoisting

**Use Case:** A JavaScript mechanism where variables and function declarations are moved to the top of their scope before code execution.

```javascript
console.log(myVar); // undefined
var myVar = 5;

myFunction(); // "Hello"
function myFunction() {
  console.log("Hello");
}
```

> 🔐 **Trick:** Only declarations are hoisted, not initializations. `let` and `const` declarations are also hoisted but are not initialized, which results in a `ReferenceError`.

---

## 📌 5. Closures

**Use Case:** A closure is a function that has access to the variables in its outer (enclosing) function's scope chain.

```javascript
function outerFunction(outerVariable) {
  return function innerFunction(innerVariable) {
    console.log("outerVariable:", outerVariable);
    console.log("innerVariable:", innerVariable);
  };
}

const newFunction = outerFunction("outside");
newFunction("inside"); // outerVariable: outside, innerVariable: inside
```

> 🌿 **Trick:** Closures are created every time a function is created, at function creation time. They are useful for creating private variables and data encapsulation.

---

## 📌 6. `this` Keyword

**Use Case:** The `this` keyword refers to the object it belongs to. Its value depends on how a function is called.

*   **In a method:** `this` refers to the owner object.
*   **Alone:** `this` refers to the global object.
*   **In a function (strict mode):** `this` is `undefined`.
*   **In an event:** `this` refers to the element that received the event.

> 🧠 **Trick:** Arrow functions do not have their own `this`. They inherit `this` from the parent scope.

---

## 📌 7. Immediately Invoked Function Expression (IIFE)

**Use Case:** An IIFE is a function that runs as soon as it is defined.

```javascript
(function() {
  console.log("This will run immediately");
})();
```

> ✨ **Trick:** IIFEs are great for avoiding polluting the global namespace. Variables declared inside an IIFE are not accessible from the outside world.

---

## ✅ Summary Table

| Concept | Use Case | Key Feature |
| --- | --- | --- |
| Data Types | Foundational knowledge | Primitives vs. Non-Primitives. |
| `var`, `let`, `const` | Variable declaration | Scope and reassignment rules. |
| `==` vs `===` | Comparison of values | Loose vs. Strict equality. |
| Hoisting | Understanding execution context | Declarations are moved to the top. |
| Closures | Data privacy and encapsulation | A function's access to its outer function's scope. |
| `this` Keyword | Object context | Value is determined by how a function is invoked. |
| IIFE | Avoiding global scope pollution | A function that is executed immediately after it is created. |

---
Of course! Here are 10 more popular JavaScript interview questions for freshers, formatted as a markdown cheatsheet.

---

# 📘 More Popular JS Questions for Freshers

---

## 📌 10. `null` vs. `undefined`

**Use Case:** Understanding the distinction between a variable that has been explicitly assigned a value of nothing (`null`) versus one that has been declared but not assigned a value (`undefined`).

*   **`undefined`**: A variable has been declared, but no value has been assigned to it. It is the default value of a declared variable.
*   **`null`**: An assignment value that represents the intentional absence of any object value.

```javascript
let a;
console.log(a); // undefined

let b = null;
console.log(b); // null

console.log(typeof undefined); // "undefined"
console.log(typeof null);      // "object"
```

> 🔍 **Trick:** `null` is an intentional "empty" value, whereas `undefined` means a value hasn't been set. Remember that `null == undefined` is `true`, but `null === undefined` is `false`.

---

## 📌 11. Arrow Functions

**Use Case:** A more concise syntax for writing function expressions. They are especially useful for functions that are passed as arguments.

```javascript
// Traditional Function Expression
const add = function(a, b) {
  return a + b;
};

// Arrow Function
const addArrow = (a, b) => a + b;

console.log(add(2, 3));      // 5
console.log(addArrow(2, 3)); // 5
```

> 💡 **Trick:** The main difference from traditional functions is that arrow functions do not have their own `this` binding. They inherit `this` from the enclosing scope, which can be very helpful in avoiding `this`-related confusion.

---

## 📌 12. Higher-Order Functions

**Use Case:** Functions that operate on other functions, either by taking them as arguments or by returning them.

`map`, `filter`, and `reduce` are common examples.

```javascript
const numbers = [1, 2, 3, 4, 5];

// map: creates a new array by applying a function to each element.
const doubled = numbers.map(num => num * 2); // [2, 4, 6, 8, 10]

// filter: creates a new array with elements that pass a test.
const evens = numbers.filter(num => num % 2 === 0); // [2, 4]

// reduce: executes a reducer function to produce a single value.
const sum = numbers.reduce((accumulator, current) => accumulator + current, 0); // 15
```

> 🎯 **Trick:** Higher-order functions allow for more declarative and readable code, enabling you to describe *what* you want to do rather than *how* to do it with loops.

---

## 📌 13. Callbacks

**Use Case:** A function passed into another function as an argument, which is then invoked inside the outer function to complete some kind of routine or action.

```javascript
function fetchData(callback) {
  // Simulating an asynchronous operation
  setTimeout(() => {
    const data = { name: "John Doe", age: 30 };
    callback(data);
  }, 1000);
}

fetchData((data) => {
  console.log(data); // { name: "John Doe", age: 30 }
});
```

> 🔐 **Trick:** Callbacks are the foundation of asynchronous operations in JavaScript, like handling API responses or user events.

---

## 📌 14. Promises

**Use Case:** An object representing the eventual completion (or failure) of an asynchronous operation and its resulting value. A promise provides a cleaner alternative to callback hell.

A Promise can be in one of three states:
*   **Pending:** Initial state, neither fulfilled nor rejected.
*   **Fulfilled:** The operation completed successfully.
*   **Rejected:** The operation failed.

```javascript
const myPromise = new Promise((resolve, reject) => {
  let success = true; // Simulating a successful operation
  setTimeout(() => {
    if (success) {
      resolve("The operation was successful!");
    } else {
      reject("The operation failed.");
    }
  }, 1000);
});

myPromise
  .then(result => console.log(result)) // Handles success
  .catch(error => console.log(error)); // Handles failure
```

> 📏 **Trick:** Use `.then()` for success, `.catch()` for errors, and `.finally()` for code that should run regardless of the outcome.

---

## 📌 15. `async/await`

**Use Case:** Syntactic sugar built on top of Promises, making asynchronous code look and behave more like synchronous code. This makes it easier to read and write.

```javascript
function resolveAfter2Seconds() {
  return new Promise(resolve => {
    setTimeout(() => {
      resolve('resolved');
    }, 2000);
  });
}

async function asyncCall() {
  console.log('calling');
  const result = await resolveAfter2Seconds();
  console.log(result); // "resolved"
}

asyncCall();
```

> ⚠️ **Trick:** The `await` keyword can only be used inside an `async` function. It pauses the execution of the `async` function until the Promise is resolved.

---

## 📌 16. Implicit Type Coercion

**Use Case:** The automatic conversion of a value from one data type to another. This happens in JavaScript when you use operators on values of different types.

```javascript
console.log('5' - 3);      // 2 (String '5' is coerced to number 5)
console.log('5' + 3);      // "53" (Number 3 is coerced to string '3')
console.log(5 + null);     // 5 (null is coerced to 0)
console.log('5' == 5);     // true (number 5 is coerced to string '5')
```

> 🧠 **Trick:** The `+` operator is ambiguous: it performs either addition or string concatenation depending on the operand types. Other arithmetic operators (`-`, `*`, `/`) always convert operands to numbers.

---

## 📌 17. The `...` (Spread and Rest) Operator

**Use Case:** The three dots (`...`) can be used as either a spread operator or a rest parameter, depending on the context.

*   **Spread Operator:** Expands an iterable (like an array or string) into individual elements.
*   **Rest Parameter:** Collects multiple elements and "condenses" them into a single array.

```javascript
// Spread Operator
const arr1 = [1, 2, 3];
const arr2 = [...arr1, 4, 5]; // [1, 2, 3, 4, 5]
const obj1 = { a: 1, b: 2 };
const obj2 = { ...obj1, c: 3 }; // { a: 1, b: 2, c: 3 }

// Rest Parameter
function sum(...numbers) {
  return numbers.reduce((acc, curr) => acc + curr, 0);
}
console.log(sum(1, 2, 3, 4)); // 10
```

> 🌿 **Trick:** Use spread for creating copies or combining arrays/objects, and rest for gathering a variable number of function arguments.

---

## 📌 18. Object and Array Destructuring

**Use Case:** A convenient way of extracting properties from an object or items from an array and putting them into distinct variables.

```javascript
// Object Destructuring
const person = {
  firstName: 'John',
  lastName: 'Doe',
  age: 30
};
const { firstName, age } = person;
console.log(firstName); // "John"
console.log(age);       // 30

// Array Destructuring
const fruits = ['Apple', 'Banana', 'Cherry'];
const [firstFruit, secondFruit] = fruits;
console.log(firstFruit);  // "Apple"
console.log(secondFruit); // "Banana"
```

> 🔧 **Trick:** You can assign new variable names and provide default values during destructuring: `const { firstName: fName, country = 'USA' } = person;`

---

## 📌 19. The Event Loop

**Use Case:** Understanding how JavaScript handles asynchronous operations without being multi-threaded. The event loop is a constantly running process that checks if the call stack is empty and if there are any pending tasks in the callback queue.

1.  **Call Stack:** Where function calls are pushed and popped.
2.  **Web APIs:** Handle asynchronous tasks (e.g., `setTimeout`, `fetch`).
3.  **Callback Queue:** Where callback functions wait after the async task is complete.
4.  **Event Loop:** Moves callbacks from the queue to the stack when the stack is empty.

```javascript
console.log('First');

setTimeout(() => {
  console.log('Second');
}, 0);

console.log('Third');

// Output:
// First
// Third
// Second
```

> ✅ **Trick:** Even with a timeout of 0ms, `setTimeout` is handled by the Web API, and its callback is placed in the queue. The event loop waits for the call stack to be empty (after `console.log('Third')` runs) before executing the callback.

---

## ✅ Summary Table

| Concept | Use Case | Key Feature |
| --- | --- | --- |
| `null` vs. `undefined` | Distinguishing empty values | `null` is an assigned value; `undefined` is the default. |
| Arrow Functions | Concise function syntax | Lexical `this` binding (inherits from parent). |
| Higher-Order Functions | Abstracting operations | Functions like `map`, `filter`, `reduce`. |
| Callbacks | Handling asynchronous tasks | A function passed as an argument to be executed later. |
| Promises | Managing async operations | Represents the eventual result of an async task. |
| `async/await` | Simplifying promise syntax | Makes async code look synchronous. |
| Implicit Type Coercion | Automatic type conversion | JavaScript automatically changes types during operations. |
| Spread/Rest Operator | Expanding/condensing iterables | Versatile `...` syntax for arrays and objects. |
| Destructuring | Unpacking values | Easy extraction of values from arrays and objects. |
| Event Loop | Concurrency model | Manages the call stack and callback queue. |

---

Happy Coding! 💻✨