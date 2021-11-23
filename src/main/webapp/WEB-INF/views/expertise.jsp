<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Expertise</title>
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
        <h2 align = "center">Expertise scientifique</h2>
        
        <form> 
            <table align="center"> 
                <tr>
                    <td> Date de début：</td> 
                    <td><input type="date" name="Date de début"/></td> 
                </tr>
                
                <tr>
                    <td> Date de fin：</td> 
                    <td><input type="date" name="Date de fin"/></td> 
                </tr>
                
                <tr>
                    <td>Type：</td>
                    <td>
                        <select name="Type">
                            <option value="Type1" selected="selected">name_choice1</option> 
                            <option value="Type2">name_choice2</option> 
                        </select> 
                    </td> 
                </tr>
                
                <tr>
                    <td> Description：</td> 
                    <td><textarea rows="10" cols="100"></textarea></td>
                </tr>
                
                <tr>
                    <td> </td>
                    <td align="right"><input type="submit" value="Valider" onclick = "alert('Saisie réussie !')"/></td> 
                </tr> 
            </table> 
        </form>
    </body>
</html>