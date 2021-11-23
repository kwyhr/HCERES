<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Réseau</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/1.css">
    </head>
    <body>
        <ul class = "menuBar">
        <li><img src = "images/logo.png" width="192" height = "67" alt ="logo"/></li>
        <li><a>Accueil</a></li>
        <li><a>Mes activités</a></li>
        <li><a>Ajout d'activités</a></li>
        </ul>
         
        <h1 align = "center">Formulaire de saise d'activité</h1> 
        <h2 align = "center">Réseau</h2>
        
        <form> 
            <table align="center"> 
                <tr>
                    <td> Date de début：</td> 
                    <td><input type="text" name="Date de début"/></td> 
                </tr>
                
                <tr>
                    <td>Nom de réseau：</td>
                     <td><input type="text" name="nomreseau"/></td> 
                </tr>
               
                <tr>
                    <td> Réseau d'activités：</td>
                     <td><input type="text" name="activité"/></td> 
                </tr>
                
                <tr>
                    <td>Est-ce en cours?</td> 
                    <td><input type="radio" name="Encours" value="Oui"/>Oui
                        <input type="radio" name="Encours" value="Non" />Non 
                    </td> 
                </tr> 
                
                <tr>
                    <td>Funding agency:</td> 
                    <td><input type="text" name="fundingagency"/></td> 
                </tr>
                
                <tr>
                    <td>Nombre de publications produites:</td> 
                    <td><input type="text" name="nombre"/></td> 
                </tr>
                
                <tr>
                    <td>Référence de publications produites:</td> 
                    <td><input type="text" name="reference"/></td> 
                </tr>
                                
                <tr>
                    <td>Umr1064 coordonné?</td> 
                    <td><input type="radio" name="Umr1064" value="Oui"/>Oui
                        <input type="radio" name="Umr1064" value="Non" />Non 
                    </td> 
                </tr> 
                
                <tr>
                    <td>Accord signé?</td> 
                    <td><input type="radio" name="accord" value="Oui"/>Oui
                        <input type="radio" name="accord" value="Non" />Non 
                    </td> 
                </tr> 
                <tr> 
                    <td> </td>
                    <td align="right"><input type="submit" value="Valider" onclick = "alert('Saisie réussie !')"/></td> 
                </tr> 
            </table> 
        </form>
    </body>
</html>