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

Happy Coding! 💻✨