<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome | Hoteloka</title>
    <link rel="stylesheet" href="style/welcome.css">
</head>
<body>
    <div class="container welcome-container">
        <a href="login.jsp">Back to Login</a>
        <header class="welcome-header">
            <h1>Welcome to Hoteloka!</h1>
        </header>
        <main class="welcome-main">
            <p>We’re excited to see you here. Explore our features and enjoy your experience.</p>
            <div class="welcome-buttons">
                <a href="UserProfile.jsp" class="button">Your Profile</a>
                <a href="home.jsp" class="button">Home Pages</a>
            </div>
            <img src="images/tick.webp" width="25%">
        </main>
        <footer class="welcome-footer">
            <p>&copy; 2024 Hoteloka. All rights reserved.</p>
        </footer>
    </div>
</body>
</html>
