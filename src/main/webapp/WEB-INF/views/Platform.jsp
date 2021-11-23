<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Platform</title>
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
        <h2 align = "center">Publication</h2>
        
        <form> 
            <table align="center"> 
                <tr>
                    <td> Date de création：</td> 
                    <td><input type="text" name="Date de création"/></td> 
                </tr>
                
                 <tr>
                    <td> Description obligatoire：</td> 
                    <td><textarea rows="1" cols="100"></textarea></td> 
                </tr> 
                
                <tr>
                    <td> Gérants：</td> 
                    <td><textarea rows="1" cols="100"></textarea></td> 
                </tr>
                
                <tr>
                    <td> Affiliation：</td> 
                    <td><input type="text" name="Affiliation"/></td> 
                </tr>
                
                <tr>
                    <td> Labellisation：</td> 
                    <td><input type="text" name=" Labellisation"/></td> 
                </tr>
                
                <tr>
                    <td> </td>
                    <td align="right"><input type="submit" value="Valider" onclick = "alert('Saisie réussie !')"/></td> 
                </tr> 
            </table> 
        </form>
    </body>
</html>