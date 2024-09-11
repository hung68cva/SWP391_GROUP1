<%-- 
    Document   : login
    Created on : Sep 10, 2024, 9:19:14 AM
    Author     : Hung Bui
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
        <link rel="stylesheet" href="style/style.css">
        <title>Modern Login Page</title>
    </head>
    <body>        
        <c:set var="cookie" value="${pageContext.request.cookies}"/>
        <h3 style="color: red">${requestScope.error}</h3>
        <div class="container" id="container">
            <div class="form-container sign-up">
                <form action="LoginServlet" method="post">
                    <h1>Tạo tài khoản</h1>
                    <div class="social-icons">
                        <a href="#" class="icon"><i class="fa-brands fa-google"></i></a>
                        <a href="#" class="icon"><i class="fa-brands fa-facebook-f"></i></a>
                        <a href="#" class="icon"><i class="fa-brands fa-github"></i></a>
                    </div>
                    <span>hoặc dùng email của bạn để đăng ký</span>
                    <input type="email" name="email" placeholder="Email" required>
                    <input type="password" name="pass" placeholder="Password" required>
                    <input type="password" name="confirmPass" placeholder="Confirm Password" required>
                    <button>Đăng ký</button>
                </form>
            </div>
            <div class="form-container sign-in">
                <form action="LoginServlet" method="get">
                    <h1>Đăng nhập</h1>
                    <div class="social-icons">
                        <a href="#" class="icon"><i class="fa-brands fa-google"></i></a>
                        <a href="#" class="icon"><i class="fa-brands fa-facebook-f"></i></a>
                        <a href="#" class="icon"><i class="fa-brands fa-github"></i></a>
                    </div>                   
                    <span>hoặc dùng email để đăng nhập</span>
                    <input type="email" name="user" placeholder="Email" required>
                    <input type="password" name="pass" placeholder="Password" required>                  
                    <a href="#">Quên tài khoản?</a>
                    <button type="submit">Đăng nhập</button>
                </form>
            </div>
            <div class="toggle-container">
                <div class="toggle">
                    <div class="toggle-panel toggle-left">
                        <h1>Bạn đã có tài khoản?</h1>
                        <p>Hãy đăng nhập để có thể truy cập vào website</p>
                        <button class="hidden" id="login">Đăng nhập</button>
                    </div>
                    <div class="toggle-panel toggle-right">
                        <h1>Bạn chưa có tài khoản?</h1>
                        <p>Hãy đăng ký để có thể sử dụng toàn bộ tính năng thú vị của website</p>
                        <button class="hidden" id="register">Đăng ký</button>
                    </div>
                </div>
            </div>
        </div>

        <script src="Script/script.js"></script>
    </body>
</html>
