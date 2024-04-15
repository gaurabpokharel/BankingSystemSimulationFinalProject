<!-- Ajay Shrestha (C0885384) Gaurab Pokharel (C0886046) Nirajan Karki (C0885390) Sakar Thapa (C0890972) -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login</title>
    <link rel="stylesheet" href="css/login.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Cambay:ital,wght@0,400;0,700;1,400;1,700&display=swap"
      rel="stylesheet"
    />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  </head>
  <body>
    <nav class="nav">
      <div class="left-nav">
        <h1>HB</h1>
      </div>
      <div class="right-nav">
        <ul>
          <li>Home</li>
          <li>About Us</li>
          <li>Contact Us</li>
        </ul>
      </div>
    </nav>
    <div class="container text-center">
      <div class="row">
        <div class="col-8 banner-image">
          <img src="media/5989813.jpg" alt="" />
        </div>
        <div class="col-4 card_wrapper">
           <form action="RegisterServlet" method="post" id="login-form" novalidate>
      <h2 class="textheadline">Signup to HamroSewa Banking</h2>
      <div class="user-box">
        <input class="form-control" type="text" value="" name="username" id="username" required />
        <label for="username">Username</label>
       
        <div class="invalid-feedback">Please enter a username.</div>
      </div>
      <div class="user-box">
       <input class="form-control" type="password" name="password" id="password" required />
       <label for="password">Password</label>
       <div class="invalid-feedback">Please enter a password.</div>
        <div id="invalid-feedback"></div>
      </div>
      <div class="user-box">
        <input type="email" id="email" name="email" required />
        <label for="email">Email</label>
        <div class="invalid-feedback">Please enter a valid email address.</div>
      </div>
      <div class="user-box">
        <input type="number" id="phone" name="phone" required />
        <label for="phone">Phone Number</label>
        <div class="invalid-feedback">Please enter a valid phone number.</div>
      </div>
      <button type="submit" class="btn-primary">Register</button>
    </form>
        </div>
      </div>
    </div>
   




  
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    
    <script>
    
    const passwordInput = document.getElementById('password');
    const passwordFeedback = document.getElementById('invalid-feedback');

    passwordInput.addEventListener('input', function () {
        const password = passwordInput.value;

       
        const passwordPattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$/;

        if (!passwordPattern.test(password)) {
            passwordFeedback.textContent = 'Password must be at least 8 characters long and contain at least one lowercase letter, one uppercase letter, and one number.';
            passwordInput.setCustomValidity('Invalid password');
        } else {
            passwordFeedback.textContent = '';
            passwordInput.setCustomValidity('');
        }
    });
    var form = document.getElementById("login-form");
    form.addEventListener("submit", function(event) {
      if (!form.checkValidity()) {
        event.preventDefault();
        event.stopPropagation();
      }

      form.classList.add("was-validated");
    });
 
   </script>
  </body>
</html>
