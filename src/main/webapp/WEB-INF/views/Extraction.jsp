<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Extraction</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/1.css">
        <script type="text/javascript">
            function openwindow(){
                    var modal = document.getElementById('myModal');
                    var span = document.getElementsByClassName("close")[0];
                    var ok=document.getElementsByClassName("ok")[0];
                    var no=document.getElementsByClassName("no")[0];
                    modal.style.display = "block";
                    ok.onclick=function(){
                            alert("Exécuter l'opération du bouton valider");                        
                            modal.style.display = "none";
                    };
                    no.onclick=function(){
                            modal.style.display = "none";
                    };
                    span.onclick = function() {
                            modal.style.display = "none";
                    };
                    window.onclick = function(event) {
                            if (event.target === modal) modal.style.display = "none";
                    };
            }
        </script>
    </head>

    <body>
        <ul class = "menuBar">
        <li><img src = "images/logo.png" width="192" height = "67" alt ="logo"/></li>
        <li><a>Accueil</a></li>
        <li><a>Nouveau Profil</a></li>
        <li><a>Supprimer Profil</a></li>
        <li><a>Extraction d'activités</a></li>
        <li><a>Ajout d'activités</a></li>
        </ul> 

        <h2 align = "center">Extraction</h2>

        <button style="float: left; float: bottom; color: white; border: outset; border-radius: 10px; background-color: green">Filtre</button>
        <button onclick="openwindow()" style="float: left; float: bottom; color: white; border: outset; border-radius: 10px; background-color: green">Trier par</button>
            <div id="myModal" class="modal">
                <div class="modal-content">
                    <div class="modal-header">
                        <span class="close">&times;</span>
                        <h2>Trier</h2>
                    </div>

                    <div class="modal-body"> 
                        <table align="center">
                            <tr>
                                <td><input type="checkbox" name="titre"  />Par date d'ajout</td>
                            </tr>

                            <tr>
                                <td><input type="checkbox" checked="checked" name="titre"/>Type d'activité</td>
                                <td><select name="activity">
                                    <option value="Publication">Publication</option> 
                                    <option value="Book">Book</option> 
                                    </select> 
                                </td>
                            </tr>
                        </table>
                    </div>

                    <div class="modal-footer">
                        <button class="ok">Valider</button>&nbsp;<button class="no">Annuler</button>
                    </div>
                </div>
            </div>

        <table align="right"> 
                <tr><td>Admin</td></tr>
                <tr><td>Connecté</td></tr>
                <tr><td>Deconnexion</td></tr>
        </table>
        <br/>
        <br/>
        <br/>
        <br/>
        <textarea rows="10" cols="265">
        Entrée1
        Projet machin
        Info1
        Info2
        -
        </textarea>
        <button style="float: right; float: bottom; color: white; border: outset; border-radius: 10px; background-color: green">Extraire</button>  

        <br/>
        <textarea rows="10" cols="265">
        Entrée2
        Projet machin
        Info1
        Info2
        -
        </textarea>
        <button style="float: right; float: bottom; color: white; border: outset; border-radius: 10px; background-color: green">Extraire</button>

        <br/>
        <textarea rows="10" cols="265">
        Entrée3
        Projet machin
        Info1
        Info2
        -
        </textarea>
        <button style="float: right; float: bottom; color: white; border: outset; border-radius: 10px; background-color: green">Extraire</button>

        <br/>
        <textarea rows="10" cols="265">
        Entrée4
        Projet machin
        Info1
        Info2
        -
        </textarea>
        <button style="float: right; float: bottom; color: white; border: outset; border-radius: 10px; background-color: green">Extraire</button>

        <br/>
        <br/>
        <br/>
        <button style="float: right; float: bottom; color: white; border: outset; border-radius: 10px; background-color: green">Tout extraire</button>       
    </body> 
</html>
