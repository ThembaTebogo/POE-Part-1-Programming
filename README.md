# POE-Part-1-Programming
This is a project about a Chat App, where the first part we create the phase of registration and login phase of the chatapp.


# ChatAppPOE – Registration & Login System  

Java application that allows a user to (register) with a (username, password, and South African phone number), then {log in} with their credentials.  

This project was developed for a Practical Object-Oriented Programming (POE) task and follows OOP principles with validation and JUnit tests.  
 Features
- Registration Form
  - Username must contain `_` and be at least 5 characters long.
  - Password must be at least 8 characters and include:
    - Uppercase letter  
    - Lowercase letter  
    - Number  
    - Special character  
  - Phone number must follow **South African format (`+27XXXXXXXXX`).  

- Login Form
  - Validates entered username and password against registered credentials.
  - Shows success or error messages via dialogs.  

- Validation Logic
  - Centralized in reusable methods:  
    - `checkUsername(String username)`  
    - `checkPasswordComplexity(String password)`  
    - `checkPhoneNumber(String phone)`  
    - `validateInput(String username, String password, String phone)`  

- JUnit Tests
  - Full test coverage for validation methods.  
  - Tests both valid and invalid cases.  

