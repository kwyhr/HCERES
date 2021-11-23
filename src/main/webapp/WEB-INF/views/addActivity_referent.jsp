<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Ajouter une activité (mode référent)</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/1.css">
    </head>

    <body>
        <ul class = "menuBar">
        <li><img id = "logo" src = "images/logo.png" alt ="logo"/></li>
        <li><a>Accueil</a></li>
        <li><a>Mes Activités</a></li>
        <li><a>Ajout d'activités</a></li>
    </ul>

    <h1 align = "center">Bienvenue Nom_Referent_Equipe</h1> 

    <table align="left"> 
        <tr>
            <td><button><img id = "team" src = "images/team.png" width="30" height = "30" alt ="team"/> &nbsp; &nbsp; Votre équipe</button></td> 
            <td></td> 
        </tr>

        <tr>
            <td>Nom_chercheur1</td>
            <td><img id = "delete" src = "images/delete.png" width="30" height = "30" alt ="delete"/></td> 
        </tr>

        <tr>
            <td>Nom_chercheur2</td>
            <td><img src = "images/delete.png" width="30" height = "30" alt ="delete"/></td> 
        </tr>

        <tr>
            <td>Nom_chercheur3</td>
            <td><img src = "images/delete.png" width="30" height = "30" alt ="delete"/></td> 
        </tr>

        <tr>
            <td>Nom_chercheur4</td>
            <td><img  src = "images/delete.png" width="30" height = "30" alt ="delete"/></td> 
        </tr>

        <tr>
            <td>Nom_Doctorant1</td>
            <td><img  src = "images/delete.png" width="30" height = "30" alt ="delete"/></td> 
        </tr>
        <tr>
        <td><button style="float: left; float: bottom; color: white; border: outset; border-radius: 10px; background-color: green">Ajouter un membre</button></td>
        <td></td>
        </tr>
    </table>  

    <table align="center"> 
        <tr>
            <td><div align = "center">Historique des dernières entrées (2-3 dernières)</div></td> 
        </tr>

        <tr>
            <td>
            <textarea style="height:300px;width:800px;overflow:auto;background:#EEEEEE;">
            Entrée 1
            Projet mochain
            Info1
            Info2
            -
            -
            -
            Entrée 2
            Projet Truc
            Info1
            Info2
            -
            -
            -
            Entrée 3
            Projet Truc
            Info1
            Info2
            -
            -
            -
            </textarea>
            </td> 
        </tr>
        <tr>
            <td>
            <a href="Extraction.html" style="color: black; text-decoration: none"><span>Voir toutes mes activités </span></a>
            &nbsp; &nbsp; &nbsp; &nbsp;
            <a href="Formulaire_d_activité.html" style="color:black; text-decoration: none"><span>Ajouter une activité</span></a>
            </td>
        </tr>
    </table>
    </body> 
</html>
