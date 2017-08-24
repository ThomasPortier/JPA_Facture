
<html> 
 <head>
  <title>Elle est ou la poulette?</title>
   <link rel="stylesheet" type="text/css" href="http://ddl.angelo-b.net/style.css">
 </head>
 <table border collapse>
  <thead><th>Id Plat</th><th>Nom plat</th><th>Tarif</th></thead>
   <tbody>
    <#list listePlat as plat>
  		 <tr align=center><td>${plat.id_Plat}</td><td>${plat.nom}</td><td>${plat.tarif}</td></tr> 
  	</#list>
   </tbody>
  </table>
</html>

