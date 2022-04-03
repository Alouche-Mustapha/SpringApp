# SpringApp
- L'application permet la gestion des materiels par des operations CRUD sur une liste local des materiels qui remplace le role d'une base de données.
- La classe main est la classe "AppGestionMateriel.java" qui doit contenir un attribut static final qui represente l'instance du context de l'application.
- L'application contexte va contenir les beans des classes de service utilisés dans cette application, et ensuite une injection vers la classe controller*
"GestionmaterielController.java".
La classe "GestionMaterielController.java" premet les interactions entre les utilisateurs et l'application à l'aide des méthodes des services des deux classes
"GestionMaterielService.java" et "AllocationMaterielService.java".
