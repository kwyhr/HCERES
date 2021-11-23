<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Ajout Profil</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/1.css">
</head>
<body>

    <ul class = "menuBar">
        <li><img id = "logo" src = "images/logo.png" alt ="logo"/></li>
        <form id="accueilForm" action="login.do" method="GET" >  
                <li><a onclick="document.getElementById('accueilForm').submit();">Accueil</a></li>
        </form>
        <form id="newProfileForm" action="newProfile.do" method="GET" >   
            <li><a onclick="document.getElementById('newProfileForm').submit();">Nouveau Profil</a></li>
        </form>
        <form id="suppProfileForm" action="suppressionProfile.do" method="GET" >   
            <li><a onclick="document.getElementById('suppProfileForm').submit();">Supprimer Profil</a></button></li>
        </form> 
        <li><a>Extraction d'activités</a></li>
        <form id="newActivity" action="newActivity.do" method="GET" >   
            <li><a onclick="document.getElementById('newActivity').submit();">Ajout d'activités</a></li>
        </form>
    </ul>

    <div class="connexionInfos">
        <form action="index.do" method="GET">
            <p>Admin : Connecté</p>
            <input type="submit" value="Déconnexion"/><br>
        </form>
    </div>

    <h1 class="headTitle"><img id="teamIcon" src="images/user.png"> Ajout de profil </h1>

    <div class="mainInfos">
        <P>Choisissez le profil que vous voulez ajouter :</P>
    </div>

    <div class="listeEquipe">
        <form action="newDoctorant.do" method="GET" >
            <input type="submit" value="Doctorant" />
        </form>
        <br>
        <form action="newChercheur.do" method="GET" >
            <input type="submit" value="Chercheur" />
        </form>
    </div>  
    
    <p class="about">
        <img class="smallIcon" src="images/About.png" alt ="about"/>
    </p>

</body>