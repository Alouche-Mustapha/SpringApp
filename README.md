# SpringApp

* Structure de l'application : 

- L'application permet la gestion et l'allocation des materiels par des operations CRUD sur une liste local des materiels qui remplace le role d'une base 
  de données.
- La classe main est la classe "AppGestionMateriel.java" qui doit contenir un attribut static final qui represente l'instance du contexte de l'application.
- Le contexte doit definir les instances des beans des classes utilisées dans cette application, et ensuite les injections entre eux (par constructeur ou par
  accesseur).
- La classe "GestionMaterielController.java" premet les interactions entre les utilisateurs et l'application à l'aide des méthodes définies dans les services
  (GestionMateriel et AllocationMateriel), allors une injection par constructeur est nécessaire.
- La couche DAO contient les opérations CRUD nécessaires pour la gestion et l'allocation des materiels, alors que cette couche doit être injectée dans chacun
  des services 

* Les fonctionnalités : 

Chaque utilisateur peut : 
- Avoir la liste des matériels disponibles 
- Avoir la liste des matériels alloués 
- Ajouter un nouveau materiel en spécifiant les informations nécessaires (selon le type de materiel) (le id du materiel est unique)
- Supprimer un matériel en donnant le id (id existe donc matériel supprimé, sinon un message d'erreur)
- Modifier un matériel en donnant le id (id existe donc matériel modifié, sinon un message d'erreur)
- Chercher un matériel en donnant le id (id existe donc matériel trouvé, sinon un message d'erreur)
- Allouer un matériel en donnant le id (id existe donc materiel alloué, sinon un message d'erreur)
- Rendre un matériel en donnant le id (id existe donc materiel rendu, sinon un message d'erreur)
