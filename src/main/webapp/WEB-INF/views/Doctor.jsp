<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Doctor</title>
        <meta charset="UTF-8">
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
        
        <table align="center">
        <tr>
        <td><img src = "images/add_user.png" width="60" height = "60" alt ="user"/></td>
        <td><h1 align = "center">Ajout de profil </h1></td> 
        </tr>
        </table>
        <h2 align = "center">Inscription d'un doctorant </h2>
        
        <form action="newDoctor.do" method="POST"> 
            <table align="center"> 
                <tr>
                    <td> Nom</td>
                    <td><input type="text" name="nameStudent" placeholder="Nom"/> </td> 
                </tr>
                
                <tr>
                    <td> Prénom</td> 
                    <td><input type="text" name="surnameStudent" placeholder="Prénom"/></td> 
                </tr> 
                
                <tr>
                    <td> Numéro ORCID(pas obligatoire)</td> 
                    <td><input type="text" name="idOrcidStudent" placeholder="Id"/></td> 
                </tr> 
                
                <tr>
                    <td> Date soutenance</td> 
                    <td><input type="date" name="defenseDate"/></td> 
                </tr>
                
                <tr>
                    <td> Durée thèse</td> 
                    <td><input type="text" name="dateStartThesis" placeholder="Nb de mois"/></td> 
                </tr>
                
                <tr>
                    <td> Devenir</td> 
                    <td><input type="text" name="future" /></td> 
                </tr>
                
                <tr>
                    <td>Combien avez-vous d'encadrants?</td>
                    <td><input type="text" name="Nombre" placeholder="Nombre"/></td>
                </tr> 
                
                <tr>
                    <td>Encadrant</td> <!-- Il peut y en avoir plusieurs : faire une boucle, avec une sélection entre ceux déjà dans la base-->
                    <td><input type="text" name="Nom" placeholder="Nom"/></td>
                    <td><input type="text" name="Prénom" placeholder="Prénom"/></td>
                </tr> 

                <tr>
                    <td> </td>
                    <td> </td>
                    <td align="right"><input type="submit" value="Valider"/></td> 
                </tr> 
            </table> 
        </form>
        
        <div class="about">
            <form action="about.do" method="GET" >
                <input type="image" class="smallIcon" src="images/About.png" alt ="about"/>        
            </form>
        </div>
        
    </body>
</html>