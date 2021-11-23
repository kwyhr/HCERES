<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>AddActivity</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/1.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
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
                    }
                    no.onclick=function(){
                            modal.style.display = "none";
                    }
                    span.onclick = function() {
                            modal.style.display = "none";
                    }
                    window.onclick = function(event) {
                            if (event.target == modal) modal.style.display = "none";
                    }
            }
    </script>
    </head>
    <body>
       
    <ul class = "menuBar">
        <li><img id = "logo" src = "images/logo.png" alt ="logo"/></li>
        <li><a>Accueil</a></li>
        <li><a>Mes Activités</a></li>
        <li><a>Ajout d'activités</a></li>
    </ul>

    <h1 align = "center">Bienvenue Nom_Referent_Equipe</h1> 
   <br>

    	<table class="table table-striped">
    		<thead><tr>
    			<th>Liste des activités existantes</th>
    		</tr>
    	</thead>
    	<tbody>
    		<tr><td>Book</td></tr>
    		<tr><td>Publication</td></tr>
    		<tr><td>Lab evaluation</td></tr>
    		<tr><td>Platform</td></tr>
    		<tr><td>Electronic tool product</td></tr>
    		<tr><td>Book</td></tr>
    		<tr><td>Publication</td></tr>
    		<tr><td>Lab evaluation</td></tr>
    		<tr><td>Platform</td></tr>
    		<tr><td>Electronic tool product</td></tr>
    		<tr><td>Book</td></tr>
    		<tr><td>Publication</td></tr>
    		<tr><td>Lab evaluation</td></tr>
    		<tr><td>Platform</td></tr>
    		<tr><td>Electronic tool product</td></tr>
    	</tbody>
   
    	<button onclick="openwindow()" style="float: right; float: bottom; color: white; border: outset; border-radius: 10px; background-color: green">Ajouter un nouveau type d'activité</button>
	<div id="myModal" class="modal">
			<div class="modal-content">
			  <div class="modal-header">
			    <span class="close">&times;</span>
			    <h2>Ajouter un nouveau type d'activité</h2>
			  </div>
			  <div class="modal-body">
			  	Nom de la nouvelle activité： <br>
			  	<input type="text" name="Nom de la nouvelle activité">
			  </div>
			  <div class="modal-footer">
			   <button class="ok">Valider</button>&nbsp;<button class="no">Annuler</button>
			  </div>
			</div>
	</div>
    	</table>
	</body>
</html>