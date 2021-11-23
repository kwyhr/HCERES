<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Intranet CRTI</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/1.css">
</head>
<body>
    <ul class = "menuBar">
        <li><img id = "logo" src = "images/logo.png" alt ="logo"/></li>
    </ul>

    <div class="connexionInfos">
        <form action="login.do" method="POST">
            <p>Connexion</p>
            <input type="login" name="user" placeholder="Username" /><br>
            <input type="password" name="passwd" placeholder="Password"/><br>
            <input type="submit" value="Valider"/><br>
        </form>
        <a href="#">Mot de passe oublié ?</a>
    </div>

    <h1 class="headTitle">
        Intranet CRTI
    </h1>
    <div class="mainInfos">
        <p>Bienvenue sur l'espace interne des chercheurs de l'université de Nantes</p>
    </div>

    <div class="mainInfos">
        <P>Informations relatives à l'intranet à modifier ?</P>
    </div>

    <div class="about">
        <form action="about.do" method="GET" >
            <input type="image" class="smallIcon" src="images/About.png" alt ="about"/>        
        </form>
    </div>

</body>