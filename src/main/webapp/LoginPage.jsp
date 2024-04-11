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
        <div class="col-4 card_wrapper mt-2">
          <form id="login-form" method="post" action="loginServlet">
            <h2 class="textheadline">Welcome to HamroSewa Banking</h2>
            <div class="user-box">
              <input type="text" id="username" name="username" required/>
              <label for ="username">Username</label>
            </div>
            <div class="user-box">
              <input type="password" id="password" name="password" required="" />
              <label for="password">Password</label>
            </div>
            <button type="submit" class="btn-primary">Login</button>
            <h5>or</h5>
            <button class="signup">
              <a href="Register.jsp">Open online account</a>
            </button>
          </form>
        </div>
      </div>
    </div>
   

   

    <!-- <div class="login-container">
      <div class="wrapper">
        <div class="left-wrapper">
          <img src="../media/5989813.jpg" alt="" />
        </div>
        <div class="right-wrapper">
          <div class="card-wrapper">
            <form id="login-form">
              <h1 class="textheadline">Welcome to HamroSewa Banking</h1>
              <div class="user-box">
                <input type="text" name="" required="" />
                <label>Username</label>
              </div>
              <div class="user-box">
                <input type="password" name="" required="" />
                <label>Password</label>
              </div>
              <button class="btn-primary">Login</button>
              <h4>OR</h4>
              <button class="signup">
                <a href="./signup.html">Open online account</a>
              </button>
            </form>
          </div>
        </div>
      </div>
    </div> -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
  </body>
</html>
