<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lab</title>
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
        <h1 align = "center">Formulaire de saise d'activité</h1> 
        <h2 align = "center">Lab evalution</h2>

        <form> 
            <table align="center"> 
                <tr>
                    <td> Year：</td> 
                    <td><input type="text" name="Year"/></td> 
                </tr>

                <tr>
                    <td> Name of the evaluted lab：</td> 
                    <td><textarea rows="1" cols="100"></textarea></td> 
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